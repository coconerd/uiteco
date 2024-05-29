/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import com.uiteco.database.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel.ACCOUNT_TYPE;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import com.uiteco.database.DataUtils;
import java.sql.Blob;
import static com.uiteco.main.App.getSession;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.time.LocalDateTime;

/**
 *
 * @author nddmi
 */
public class AuthDAO {

    public static final String PBE_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA256";
    public static final int PBE_DERIVATION_SALT_LENGTH = 16; // bytes;
    public static final int PBE_DERIVATIONKEY_KEY_LENGTH = 16; // bytes

    public static class LoginResult {

    }

    public static class LoginResult {

    }

    /**
     *
     * @param username
     * @param email
     * @param password
     * @throws MissingCredentialsException if required credentials aren't
     * provided
     * @throws InvalidCredentialsException if required credentials are provided
     * but is invalid or has bad format
     */
    public static TaiKhoanModel login(String username, String email, String password) throws Exception {
        boolean hasEmail = (email != null && !email.equals(""));

        // Query from db
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement;
        String sql;
        if (hasEmail) {
            sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ?";
            statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, email);
        } else {
            sql = "SELECT * FROM TAIKHOAN WHERE USERNAME = ?";
            statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, username);
        }
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            throw new InvalidCredentialsException();

        }

        // Password verification
        byte[] passwordHash = rs.getBytes("MATKHAU");
        byte[] salt = rs.getBytes("PBKDF2_SALT");
        byte[] toBeVerified = deriveKey(password, salt);
        if (compareKeys(toBeVerified, passwordHash) == false) {
            throw new InvalidCredentialsException();
        }

        // Save user info to Session
        ACCOUNT_TYPE accountType = null;
        int accountID;
        int a = rs.getInt("LOAITK");
        switch (a) {
            case 1:
                accountType = ACCOUNT_TYPE.admin;
                break;
            case 2:
                accountType = ACCOUNT_TYPE.sinhvien;
                break;
            case 3:
                accountType = ACCOUNT_TYPE.cuusinhvien;
                break;
            case 4:
                accountType = ACCOUNT_TYPE.giangvien;
                break;
        }

        System.out.println("Account type: " + accountType);

        if (hasEmail) {
            username = rs.getString("USERNAME");
        } else {
            email = rs.getString("EMAIL");
        }

        accountID = rs.getInt("MATK");

        Permissible perm = new Permissible() {
            private byte[] accessKey;

            @Override
            public byte[] getAccessKey() {
                return accessKey;
            }

            @Override
            public void setAccessKey(byte[] _accessKey) {
                accessKey = _accessKey;
            }
        };

        LocalDate accountCreationDate = rs.getDate("NGAYTAO").toLocalDate();

        // Retrieve avatar image
        ImageIcon avatar;
        Blob blob = rs.getBlob("ANHDAIDIEN");
        if (blob != null) {
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            blob.free();    
            avatar = DataUtils.convertBytesToImageIcon(bytes);
        } else {
            avatar = null;
        }

        // Retrieve fullname
        String fullname = rs.getString("HOTEN");

        // Retrieve phone number
        String phone = rs.getString("SDT");
        
        // Retrieve country
        String country = rs.getString("QUOCGIA");
        
        // Retrieve province
        String province = rs.getString("TINHTHANHPHO");
        
        // Retrieve timezone
        String timezone = rs.getString("MUIGIO");
        
        // Retrieve user brief introduction
        String intro = rs.getString("GIOITHIEU");
        
        // Update and retrieve account last access;
        sql = "{? = call FN_UPDATE_TRUYCAP_TAIKHOAN(?)}";
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.registerOutParameter(1, java.sql.Types.TIMESTAMP);
        cstm.setInt(2, accountID);
        cstm.execute();
        LocalDateTime lastAccess = cstm.getTimestamp(1).toLocalDateTime();
        cstm.close();

        TaiKhoanModel newUser = new TaiKhoanModel();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setAccountType(accountType);
        newUser.setAccountID(accountID);
        newUser.setAccountCreationDate(accountCreationDate);
        newUser.setAvatar(avatar);
        newUser.setFullname(fullname);
        newUser.setPhone(phone);
        newUser.setCountry(country);
        newUser.setProvince(province);
        newUser.setTimezone(timezone);
        newUser.setIntro(intro);
        newUser.setLastAccess(lastAccess);

        // Get mssv if account type is student / ex-student
        if (accountType == ACCOUNT_TYPE.sinhvien || accountType == ACCOUNT_TYPE.cuusinhvien) {
            sql = "SELECT MSSV, TENKHOA FROM SINHVIEN WHERE MATK = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, accountID);

            rs = statement.executeQuery();
            if (rs.next()) {
                String mssv = rs.getString("MSSV");
                String faculty = rs.getString("TENKHOA");
                newUser.setMssv(mssv);
                
                if (!rs.wasNull()) {
                    newUser.setFaculty(faculty);
                }
            }
        }

        // Cleanup
        statement.close();
        rs.close();
        conn.close();
        return newUser;
    }

    public static void updateGeneralInfo(String email, String username, String phone, String fullname, ImageIcon avatar, String intro) throws SQLException, IOException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "UPDATE TAIKHOAN SET EMAIL = ?, USERNAME = ?, SDT = ?, HOTEN = ?, ANHDAIDIEN = ?, GIOITHIEU = ? WHERE MATK = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, email);
        pstm.setString(2, username);
        pstm.setString(3, phone);
        pstm.setString(4, fullname);
        pstm.setBlob(5, new ByteArrayInputStream(DataUtils.convertImageIconToBytes(avatar)));
        pstm.setString(6, intro);
        pstm.setInt(7, getSession().getUser().getAccountID());

        pstm.executeUpdate();

        pstm.close();
        conn.close();
    }

    public static boolean verifyPassword(String password) throws Exception {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT MATKHAU, PBKDF2_SALT FROM TAIKHOAN WHERE MATK = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, getSession().getUser().getAccountID());
        ResultSet rs = pstm.executeQuery();

        if (!rs.next()) {
            throw new InvalidCredentialsException();

        }

        // Password verification
        byte[] passwordHash = rs.getBytes("MATKHAU");
        byte[] salt = rs.getBytes("PBKDF2_SALT");
        byte[] toBeVerified = deriveKey(password, salt);
        return compareKeys(toBeVerified, passwordHash);
    }

    private static byte[] deriveKey(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        int iterations = 65536;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, PBE_DERIVATIONKEY_KEY_LENGTH * 8);

        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBE_DERIVATION_ALGORITHM);
        SecretKey sk = factory.generateSecret(spec);

        return sk.getEncoded();
    }

    private static boolean compareKeys(byte[] key1, byte[] key2) {
        if (key1.length != key2.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < key1.length; i++) {
            result |= key1[i] ^ key2[i];
        }

        return result == 0;
    }

    private static byte[] genSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }

    // This function is only for testing purpose
    public static void register(String email, String username, String password, int accountType, String fullname, String phone) {
        /* Verify email, username, password, accountType */
        try {
            Connection conn = ConnectionManager.getConnection();
            byte[] salt = genSalt();
            byte[] passwordHash = deriveKey(password, salt);

            String sql = "INSERT INTO TAIKHOAN (EMAIL, USERNAME, MATKHAU, PBKDF2_SALT, LOAITK, HOTEN, SDT) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setBytes(3, passwordHash);
            statement.setBytes(4, salt);
            statement.setInt(5, accountType);
            statement.setString(6, fullname);
            statement.setString(7, phone);
            statement.executeUpdate();

            conn.commit();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Register successful");
    }

    // This function is meant for testing purpose
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Username: ");

            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            try {
//                login(username, email, password);
                register(email, username, password, 2, "", "");
                System.out.println("Login successful");
                break;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
