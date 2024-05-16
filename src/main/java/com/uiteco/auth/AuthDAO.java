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

/**
 *
 * @author nddmi
 */
public class AuthDAO {

    public static final String PBE_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA256";
    public static final int PBE_DERIVATION_SALT_LENGTH = 16; // bytes;
    public static final int PBE_DERIVATIONKEY_KEY_LENGTH = 16; // bytes

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
    public static void login(String username, String email, String password) throws Exception {

        String sql;
        PreparedStatement statement;
        ResultSet rs;
        try {
            Connection conn = ConnectionManager.getConnection();
            if (email != null && !email.equals("")) {
                sql = "SELECT * FROM TAIKHOAN WHERE EMAIL = ?";
                statement = conn.prepareStatement(sql);
                statement.setString(1, email);
            } else {
                sql = "SELECT * FROM TAIKHOAN WHERE USERNAME = ?";
                statement = conn.prepareStatement(sql);
                statement.setString(1, username);
            }

            rs = statement.executeQuery();
            if (rs.next()) {
                byte[] passwordHash = rs.getBytes("MATKHAU");
                byte[] salt = rs.getBytes("PBKDF2_SALT");
                byte[] toBeVerified = deriveKey(password, salt);

                if (compareKeys(toBeVerified, passwordHash) == false) {
                    throw new InvalidCredentialsException();
                }

            } else {
                throw new InvalidCredentialsException();
            }

            conn.close();
        } catch (Exception e) {
            throw e;
        }
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
    private static void register(String email, String username, String password, int accountType) {
        /* Verify email, username, password, accountType */
        try {
            Connection conn = ConnectionManager.getConnection();
            byte[] salt = genSalt();
            byte[] passwordHash = deriveKey(password, salt);

            String sql = "INSERT INTO TAIKHOAN (EMAIL, USERNAME, MATKHAU, PBKDF2_SALT, LOAITK) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setBytes(3, passwordHash);
            statement.setBytes(4, salt);
            statement.setInt(5, accountType);
            statement.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Register successful");
    }

    // This function is meant for testing purpose
    public static void main(String[] args) {
//        java.util.Scanner sc = new java.util.Scanner(System.in);
//        while (true) {
//            System.out.print("Email: ");
//            String email = sc.nextLine();
//            System.out.print("Username: ");
//
//            String username = sc.nextLine();
//
//            System.out.print("Password: ");
//            String password = sc.nextLine();
//
//            try {
//                login(username, email, password);
//                System.out.println("Login successful");
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//                continue;
//            }
//        }
/* đã thêm các tài khoản này vào csdl rồi
        register("22520124@gm.uit.edu.vn", "vubao", "11111111", 2);
        register("22520872@gm.uit.edu.vn", "ducminh", "11111111", 2);
        register("22520423@gm.uit.edu.vn", "thuyhien", "11111111", 2);
        register("22520001@gm.uit.edu.vn", "apple", "11111111", 2);
        register("22520002@gm.uit.edu.vn", "banana", "11111111", 2);
        register("22520003@gm.uit.edu.vn", "mango", "11111111", 2);
        register("22520004@gm.uit.edu.vn", "papaya", "11111111", 2);
        register("22520005@gm.uit.edu.vn", "kiwi", "11111111", 2);
        register("22520006@gm.uit.edu.vn", "chily", "11111111", 2);
        register("22520007@gm.uit.edu.vn", "blueberry", "11111111", 2);
        register("22520008@gm.uit.edu.vn", "table", "11111111", 2);
        register("22520009@gm.uit.edu.vn", "house", "11111111", 2);
        register("22520010@gm.uit.edu.vn", "grape", "11111111", 2);
        register("22520011@gm.uit.edu.vn", "rambutan", "11111111", 2);
        register("22520012@gm.uit.edu.vn", "longan", "11111111", 2);
        register("22520013@gm.uit.edu.vn", "milk", "11111111", 2);
        register("22520014@gm.uit.edu.vn", "rice", "11111111", 2);
        register("22520015@gm.uit.edu.vn", "orange", "11111111", 2);
        register("22520016@gm.uit.edu.vn", "lemon", "11111111", 2);
        register("22520017@gm.uit.edu.vn", "store", "11111111", 2);
        register("22520018@gm.uit.edu.vn", "book", "11111111", 2);
        register("22520019@gm.uit.edu.vn", "plane", "11111111", 2);
        register("22520020@gm.uit.edu.vn", "bike", "11111111", 2);
        register("22520021@gm.uit.edu.vn", "motobike", "11111111", 2);
        register("22520022@gm.uit.edu.vn", "bicycle", "11111111", 2);
        register("22520023@gm.uit.edu.vn", "water", "11111111", 2);
        register("22520024@gm.uit.edu.vn", "fire", "11111111", 2);
        register("22520025@gm.uit.edu.vn", "snow", "11111111", 2);
        register("22520026@gm.uit.edu.vn", "tree", "11111111", 2);
        register("22520027@gm.uit.edu.vn", "sunlight", "11111111", 2);
        register("22520028@gm.uit.edu.vn", "rain", "11111111", 2);
        register("22520029@gm.uit.edu.vn", "rainbow", "11111111", 2);
        register("22520030@gm.uit.edu.vn", "mushroom", "11111111", 2);
        register("22520031@gm.uit.edu.vn", "daisy", "11111111", 2);
        register("22520032@gm.uit.edu.vn", "flower", "11111111", 2);
        register("22520033@gm.uit.edu.vn", "tiger", "11111111", 2);
        register("22520034@gm.uit.edu.vn", "lion", "11111111", 2);
        register("22520035@gm.uit.edu.vn", "monkey", "11111111", 2);
        register("22520036@gm.uit.edu.vn", "elephant", "11111111", 2);
        register("22520037@gm.uit.edu.vn", "lime", "11111111", 2);
        register("22520038@gm.uit.edu.vn", "glass", "11111111", 2);
        register("22520039@gm.uit.edu.vn", "coffee", "11111111", 2);
        register("22520040@gm.uit.edu.vn", "phone", "11111111", 2);
        register("13520040@gm.uit.edu.vn", "nguyenkhanhvinh", "11111111", 3);
        register("hangdv@uit.edu.vn", "duongviethang", "11111111", 4);
        register("huynk@uit.edu.vn", "nguyenkhoahuy", "11111111", 1);
        register("anpnt@uit.edu.vn", "phannguyenthuyan", "11111111", 4);
*/
/*chưa đăng ký 
    register("trantb@uit.edu.vn", "thaibaotran", "11111111", 4);
    register("chuongph@uit.edu.vn", "phanhoangchuong", "11111111", 4);
    register("locth@uit.edu.vn", "tranhoangloc", "11111111", 4);
    register("havds@uit.edu.vn", "vanducsonha", "11111111", 4);
    register("phuongtv@uit.edu.vn", "tavietphuong", "11111111", 4);
    register("dungtq@uit.edu.vn", "truongquocdung", "11111111", 1);
    register("hiepnt@uit.edu.vn", "nguyenthanghiep", "11111111", 1);
    register("toannv@uit.edu.vn", "nguyenvantoan", "11111111", 1);
    register("16520040@gm.uit.edu.vn", "nguyenbichnhu", "11111111", 3);
    register("12520040@gm.uit.edu.vn", "dohaiminh", "11111111", 3);
*/
    }
}
