package com.uiteco.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
               
            int MaCLB = 0;
            
            String sql = "select * from CAULACBO where MACLB = " + MaCLB;
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            boolean IsNull = true;
                
//                System.out.println(rs.)
            while(rs.next())
            {
                IsNull = false;

               System.out.println("TenCLb: " + rs.getString("TENCLB"));
            }
                
                
            if(IsNull)
                System.out.println("Null");
            else
                System.out.println("Not Null");
            
        } catch (Exception e) {
            e.printStackTrace();
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
