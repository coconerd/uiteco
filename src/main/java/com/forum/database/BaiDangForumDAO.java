/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.database;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.time.LocalDateTime;
import com.forum.PostPanel;
import java.util.List;
import com.uiteco.database.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Clob;
import java.io.StringReader;

/**
 *
 * @author 21H1 HNQA
 */
public class BaiDangForumDAO {
        /*Load các bài đăng từ bảng BAIDANGFORUM mà không sắp xếp*/
        public static ArrayList<PostPanel> loadListPostWithoutSorting() {
        ArrayList<PostPanel> postList = new ArrayList<>();
        try{
            Connection conn = ConnectionManager.getConnection();
            String strSQL = "SELECT B.MABDFORUM, B.TIEUDE, B.LUOTXEM, B.LUOTPHANHOI, T.EMAIL, B.THOIDIEMDANG, B.NOIDUNG FROM BAIDANGFORUM B JOIN TAIKHOAN T ON T.MATK = B.NGUOIDANG";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(strSQL);
            while(result.next()){
                int MABDFORUM = result.getInt(1);  
                String TIEUDE = result.getString(2);         
                int LUOTXEM = result.getInt(3);            
                int LUOTPHANHOI = result.getInt(4);              
                String NGUOIDANG = result.getString(5); //muốn hiển thị gì thì tuỳ chỉnh lại trong câu select. Hiện tại đang lấy EMAIL để hiển thị cho trường NGUOIDANG             
                Timestamp THOIDIEMDANG = result.getTimestamp(6);
                String NOIDUNG = result.getString(7);
                PostPanel post = new PostPanel(MABDFORUM, TIEUDE, LUOTXEM, LUOTPHANHOI, NGUOIDANG, THOIDIEMDANG.toLocalDateTime(), NOIDUNG);
                postList.add(post);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(postList.isEmpty()){
            System.out.println("Load data from database fail!");
        }else{
            System.out.println("Load data from database sucessfully!");  
        }        
        return postList;
    }
        /*load và đồng thời sắp xếp theo thứ tự các bài đăng mới được đăng gần đây nhất*/
        public static ArrayList<PostPanel> loadAndSortListPostFromDatabase() {
        ArrayList<PostPanel> postList = new ArrayList<>();
        try{
            Connection conn = ConnectionManager.getConnection();
            String strSQL = "SELECT B.MABDFORUM, B.TIEUDE, B.LUOTXEM, B.LUOTPHANHOI, T.EMAIL, B.THOIDIEMDANG, B.NOIDUNG FROM BAIDANGFORUM B JOIN TAIKHOAN T ON T.MATK = B.NGUOIDANG ORDER BY THOIDIEMDANG DESC";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(strSQL);
            while(result.next()){
                int MABDFORUM = result.getInt(1);  
                String TIEUDE = result.getString(2);         
                int LUOTXEM = result.getInt(3);            
                int LUOTPHANHOI = result.getInt(4);              
                String NGUOIDANG = result.getString(5); //muốn hiển thị gì thì tuỳ chỉnh lại trong câu select. Hiện tại đang lấy EMAIL để hiển thị cho trường NGUOIDANG             
                Timestamp THOIDIEMDANG = result.getTimestamp(6);
                String NOIDUNG = result.getString(7);
                PostPanel post = new PostPanel(MABDFORUM, TIEUDE, LUOTXEM, LUOTPHANHOI, NGUOIDANG, THOIDIEMDANG.toLocalDateTime(), NOIDUNG);
                postList.add(post);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(postList.isEmpty()){
            System.out.println("Load data from database fail!");
        }else{
            System.out.println("Load data from database sucessfully!");  
        }        
        return postList;
    }
        public static void insertRecordIntoDatabaseWhenClickPosting(String postedBy, LocalDateTime postingTime, String content, String title, int viewNumber, int replyNumber){
            try{
                  Connection conn = ConnectionManager.getConnection();
                  String strSQL = "INSERT INTO BAIDANGFORUM (NGUOIDANG, THOIDIEMDANG, NOIDUNG, TIEUDE, LUOTXEM, LUOTPHANHOI) VALUES (?,?,?,?,?,?)";
                  PreparedStatement pr = conn.prepareStatement(strSQL);
                  pr.setString(1, postedBy);
                  //chuyển kiểu localdatetime thành kiểu timestamp trong sql
                  Timestamp postingTimeStamp = Timestamp.valueOf(postingTime);
                  pr.setTimestamp(2, postingTimeStamp);
                  /* Cách 1: //tạo 1 đối tượng clob để sử dụng cho hàm setClob
                  Clob clob = conn.createNClob();
                  clob.setString(3, content);
                  pr.setClob(3, clob);
                  */
                  /*Cách 2: ngắn gọn hơn*/
                  pr.setString(3,content);
                  pr.setString(4, title);
                  pr.setInt(5, viewNumber);
                  pr.setInt(6, replyNumber);
                  
                  pr.executeUpdate();    
                  conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    public static void increaseViewNumber(){
            try{
                  Connection conn = ConnectionManager.getConnection();
                  String strSQL = "UPDATE BAIDANGFORUM SET LUOTXEM = LUOTXEM+1 WHERE MABD = ?";
                  PreparedStatement pr = conn.prepareStatement(strSQL);
                  pr.setInt(0, 0);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    public static int getCount() {
        return 300;  // mock
    }

    public static ArrayList<PostPanel> getPageData(int page, int pageSize) {
        ArrayList<PostPanel> postList = new ArrayList<>();

        // mock
        for (int i = 0; i < getCount(); i++) {
            String title = String.format("Day la bai dang thu %d", i + 1);
            int postID = i;
            String content = "Hello World Java Swing GUI. Hello World Coconerd. Hello world, good bye world. Bye bye world. I love Java. I hate Java. I hate IT.";
            String postedBy = "Cong Phan";
            java.time.LocalDateTime postingDate = java.time.LocalDateTime.now();
            int viewNumber = 1200;
            int responseNumber = 1000;
            PostPanel post = new PostPanel(postID, title, viewNumber, responseNumber, postedBy, postingDate, content);
            postList.add(post);
        }

        int startIdx = (page - 1) * pageSize;
        int endIdx = Math.min(startIdx + pageSize, postList.size());
        System.out.println("Debug: start index = " + startIdx);
        System.out.println("Debug: end index = " + endIdx);

        java.util.List<PostPanel> sublist = postList.subList(startIdx, endIdx);
        return new ArrayList<PostPanel>(sublist);
    }

 
}
