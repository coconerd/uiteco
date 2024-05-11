package com.uiteco.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;

/**
 *
 * @author nddmi
 */
public class TestConnection {

    public static void testConn() throws SQLException {
        Connection conn;
        Connection conn2;

        try {
                conn = ConnectionManager.getConnection();
                conn2 = ConnectionManager.getConnection();
                
                if (conn != null) {
                    System.out.println("Connected (conn1)");
                } else {
                    System.out.println("We're doomed");
                }
                
                if (conn2 != null) {
                    System.out.println("Connected (conn2)");
                } else {
                    System.out.println("We're doomed");
                }

                Statement stm = conn.createStatement();
                Statement stm2 = conn2.createStatement();
                String query = "SELECT * FROM TAIKHOAN";

                ResultSet rs = stm.executeQuery(query);
                ResultSet rs2 = stm2.executeQuery(query);
                while (rs.next() && rs2.next()) {
                    String _accountId = rs.getString("MATK");
                    String _email = rs.getString("EMAIL");
                    String _username = rs.getString("USERNAME");
                    Date _createdDate = rs.getDate("NGAYTAO");
                    String _accountId2 = rs.getString("MATK");
                    String _email2 = rs.getString("EMAIL");
                    String _username2 = rs.getString("USERNAME");
                    Date _createdDate2 = rs.getDate("NGAYTAO");
                    
                    
                    System.out.println("Connection 1 details: ");
                    System.out.println(_accountId);
                    System.out.println(_email);
                    System.out.println(_username);
                    System.out.println(_createdDate);
                    
                    System.out.println("Connection 2 details: ");
                    System.out.println(_accountId2);
                    System.out.println(_email2);
                    System.out.println(_username2);
                    System.out.println(_createdDate2);
                }
            


        } catch (SQLException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            testConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
