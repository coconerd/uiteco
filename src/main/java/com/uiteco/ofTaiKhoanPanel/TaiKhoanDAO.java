/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel;

import com.uiteco.database.ConnectionManager;
import static com.uiteco.ofTaiKhoanPanel.ofClbPanel.Clb.MiniClbModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.uiteco.ofTaiKhoanPanel.TaiKhoanModel.ACCOUNT_TYPE;
import java.time.LocalDateTime;

/**
 *
 * @author nddmi
 */
public class TaiKhoanDAO {

    public static ArrayList<MiniClbModel> getUserClubs(TaiKhoanModel user) throws SQLException {
        ArrayList<MiniClbModel> result = new ArrayList<>();
        Connection conn = ConnectionManager.getConnection();

        String sql = """
                     SELECT TK.HOTEN, CLB.TENCLB, CLB.CHUNHIEM, TV.DUOCQUYENDANGBAI  FROM
                     \t(SELECT MACLB, CHUNHIEM, TENCLB FROM CAULACBO) CLB
                     \tJOIN
                     \t(SELECT MACLB, MATK, DUOCQUYENDANGBAI FROM THANHVIENCLB WHERE MATK = ?) TV ON TV.MACLB = CLB.MACLB
                     \tJOIN
                     \t(SELECT MATK, HOTEN FROM TAIKHOAN) TK ON TK.MATK = TV.MATK""";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, user.getAccountID());
        ResultSet rs = pstm.executeQuery();

        MiniClbModel newModel = new MiniClbModel();
        while (rs.next()) {
//            newModel.setClbAvatar(null);
            newModel.setClbName(rs.getString("TENCLB"));
            newModel.setPersonName(rs.getString("HOTEN"));

            String clbRole;
            if (rs.getInt("CHUNHIEM") == user.getAccountID()) {
                clbRole = "Chủ nhiệm";
            } else if (rs.getInt("DUOCQUYENDANGBAI") == 1) {
                clbRole = "Ủy nhiệm viên";
            } else {
                clbRole = "Thành viên";
            }
            newModel.setClbRole(clbRole);
            result.add(newModel);
        }

        return result;
    }

    public static void getMissingDetail(TaiKhoanModel user) throws SQLException {
        Connection conn = ConnectionManager.getConnection();

        String sql = "SELECT EMAIL, SDT, GIOITHIEU, NGAYTAO, TRUYCAP, LOAITK, TINHTHANHPHO, QUOCGIA, MUIGIO FROM TAIKHOAN WHERE MATK = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, user.getAccountID());

        ResultSet rs = pstm.executeQuery();

        if (!rs.next()) {
            throw new SQLException("TaiKhoan with ID " + user.getAccountID() + "not found in database");
        }

        // Set account type
        switch (rs.getInt("LOAITK")) {
            case 1 ->
                user.setAccountType(ACCOUNT_TYPE.admin);
            case 2 ->
                user.setAccountType(ACCOUNT_TYPE.sinhvien);
            case 3 ->
                user.setAccountType(ACCOUNT_TYPE.cuusinhvien);
            case 4 ->
                user.setAccountType(ACCOUNT_TYPE.giangvien);
        }

        user.setEmail(rs.getString("EMAIL"));
        user.setPhone(rs.getString("SDT"));
        user.setIntro(rs.getString("GIOITHIEU"));
        user.setAccountCreationDate(rs.getDate("NGAYTAO").toLocalDate());
        user.setCountry(rs.getString("QUOCGIA"));
        user.setProvince(rs.getString("TINHTHANHPHO"));
        user.setTimezone(rs.getString("MUIGIO"));
        java.sql.Timestamp ts = rs.getTimestamp("TRUYCAP");
        if (!rs.wasNull()) {
            user.setLastAccess(ts.toLocalDateTime());
        }

        // Retrieve student ID and faculty of account type is student
        if (user.getAccountType() == ACCOUNT_TYPE.sinhvien || user.getAccountType() == ACCOUNT_TYPE.cuusinhvien) {
            sql = "SELECT MSSV, TENKHOA FROM SINHVIEN WHERE MATK = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getAccountID());

            rs = pstm.executeQuery();
            if (rs.next()) {
                user.setMssv(rs.getString("MSSV"));
                String faculty = rs.getString("TENKHOA");

                if (!rs.wasNull()) {
                    user.setFaculty(faculty);
                }
            }
        }
        
        rs.close();
        pstm.close();
        conn.close();
    }

}
