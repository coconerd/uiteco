/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import com.uiteco.database.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author nddmi
 */
public class InsertTHANHVIENCLB {

    public static void insertTHANHVIENCLB() throws SQLException {
        Connection conn = ConnectionManager.getConnection();

        String sql = "SELECT MACLB, CHUNHIEM FROM CAULACBO";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        HashSet<Integer> chuNhiemList = new HashSet<Integer>();
        while (rs.next()) {
            int clubID = rs.getInt("MACLB");
            int accountID = rs.getInt("CHUNHIEM");
            chuNhiemList.add(accountID);
            sql = "INSERT INTO THANHVIENCLB (MACLB, MATK, DUOCQUYENDANGBAI) VALUES (?, ?, 1)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, clubID);
            pstm.setInt(2, accountID);
//            pstm.addBatch();
            pstm.executeUpdate();
        }
//        pstm.executeBatch();
        conn.commit();
//        if (pstm != null)
//                pstm.close();

        // Get random people and add them to random clubs
        List<Integer> accountIDs = InsertTAIKHOAN.getAllAccountIDs();
        List<Integer> clbList = InsertCAULACBO.getAllClubIDs();

        for (int accountID : accountIDs) {
            if (chuNhiemList.contains(accountID)) {
                continue;
            }

            int randomClbID = InsertCAULACBO.getRandomClubID(clbList);
            sql = "INSERT INTO THANHVIENCLB (MACLB, MATK) VALUES (?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, randomClbID);
            pstm.setInt(2, accountID);
//            pstm.addBatch();
            pstm.executeUpdate();
        }
//        pstm.executeBatch();

        conn.commit();
        pstm.close();
        rs.close();
        conn.close();
    }
}
