/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import com.uiteco.database.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import static com.uiteco.database.mock.InsertTAIKHOAN.getRandomAccountID;
import static com.uiteco.database.mock.InsertTAIKHOAN.getAllAccountIDs;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nddmi
 */
public class InsertCAULACBO {

    public static void insertCAULACBO() throws SQLException {
        List<Integer> accountIDs = getAllAccountIDs();
        _insert("Webdev Studios", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("Sách và hành động", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("Media UIT", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("UIT AI Club", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("CLB lớp trưởng", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("GDSC-UIT", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("Data Science Society", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("Open English Club", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("CLB thiết kế vi mạch", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("CLB cờ vua", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("UIT Gamapp", getRandomAccountID(accountIDs), getRandomDateInPast());
        _insert("Máy tính cũ - tri thức mới", getRandomAccountID(accountIDs), getRandomDateInPast());
    }

    public static void _insert(String tenclb, int chunhiem, LocalDate ngaythanhlap) throws SQLException {
        Connection conn = ConnectionManager.getConnection();

        String sql = "INSERT INTO CAULACBO (TENCLB, CHUNHIEM, NGAYTHANHLAP) VALUES (?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, tenclb);
        pstm.setInt(2, chunhiem);
        pstm.setDate(3, Date.valueOf(ngaythanhlap));
        pstm.executeUpdate();

        conn.commit();
        pstm.close();
        conn.close();
    }

    public static LocalDate getRandomDateInPast() {
        Random random = new Random();

        // Define the maximum number of days to add (e.g., up to 4 years back)
        long min = ChronoUnit.DAYS.between(LocalDate.now().minusYears(4), LocalDate.now());

        // Generate a random number of days to add
        long randomDays = random.nextInt((int) min + 1);

        // Add the random number of days to the start date
        return LocalDate.now().minusDays(randomDays);
    }
    
    public static List<Integer> getAllClubIDs() throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT MACLB FROM CAULACBO";
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<Integer> ids = new ArrayList<Integer>();
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("MACLB");
            ids.add(id);
        }
        
        return ids;
    }
    
    public static Integer getRandomClubID(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return null;
        }
        
        Random random = new Random();
        int randIndex = random.nextInt(ids.size());
        
        return ids.get(randIndex);
    }

}
