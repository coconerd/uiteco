/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum.database;

import com.forum.PostDetailView;
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
            System.out.println("Load data without sorting posting time from database fail!");
        }else{
            System.out.println("Load data without sorting posting time from database sucessfully!");  
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
            System.out.println("Load data and sort by latest posting time from database fail!");
        }else{
            System.out.println("Load data and sort by latest posting time from database sucessfully!");  
        }        
        return postList;
    }
    public static void insertIntoDatabaseWhenClickPosting(String postedBy, String content, String title, int viewNumber, int replyNumber){
        try{
    /*khi người dùng đăng bài thì lấy username từ Session.java, sau đó lưu vào csdl thì ta lưu NGUOIDANG là kiểu number trong csdl, 
    vì vậy cần thực hiện câu select để lấy thông tin MATK tương ứng với username đang bấm xác nhận đăng bài để lưu vào bảng BAIDANGFORUM*/
              Connection conn = ConnectionManager.getConnection();
              String strSQL = "INSERT INTO BAIDANGFORUM (NGUOIDANG, NOIDUNG, TIEUDE, LUOTXEM, LUOTPHANHOI) VALUES ((SELECT MATK FROM TAIKHOAN WHERE USERNAME=?),?,?,?,?)";
              PreparedStatement pr = conn.prepareStatement(strSQL);
              pr.setString(1, postedBy);
              /*chuyển kiểu localdatetime thành kiểu timestamp trong sql
              Timestamp postingTimeStamp = Timestamp.valueOf(postingTime);
              pr.setTimestamp(2, postingTimeStamp);
              */

              /* Cách 1: //tạo 1 đối tượng clob để sử dụng cho hàm setClob
              Clob clob = conn.createNClob();
              clob.setString(3, content);
              pr.setClob(3, clob);
              */
              /*Cách 2: ngắn gọn hơn*/
              pr.setString(2,content);
              pr.setString(3, title);
              pr.setInt(4, viewNumber);
              pr.setInt(5, replyNumber);

              pr.executeUpdate();
              conn.close();
              System.out.println("Insert bai dang vao csdl thanh cong!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
    public static void insertIntoDatabaseWhenClickReply(String username, String contentReply, int mabaidangforum){
        try{
                Connection conn = ConnectionManager.getConnection();
                String strSQL = "INSERT INTO BINHLUAN(MABDFORUM, NOIDUNG, NGUOIBL) VALUES (?,?,(SELECT MATK FROM TAIKHOAN WHERE USERNAME = ?))";
                PreparedStatement pre = conn.prepareStatement(strSQL);
                pre.setInt(1,mabaidangforum);
                pre.setString(2,contentReply);
                pre.setString(3,username);
                pre.executeUpdate();
                conn.close();
                System.out.println("Insert binh luan phan hoi cho bai viet co ma "+mabaidangforum+" vao csdl thanh cong!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void increaseViewNumber(int mabaidangforum){
            try{
                  Connection conn = ConnectionManager.getConnection();
                  String strSQL = "UPDATE BAIDANGFORUM SET LUOTXEM = LUOTXEM+1 WHERE MABDFORUM = ?";
                  PreparedStatement pr = conn.prepareStatement(strSQL);
                  pr.setInt(1, mabaidangforum);
                  pr.executeUpdate();
                  conn.close();
                  System.out.println("Cap nhat so luong LUOTXEM cho bai dang co ma "+mabaidangforum+" thanh cong!");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    public static void increaseReplyNumber(int mabaidangforum){
        try{
              Connection conn = ConnectionManager.getConnection();
              String strSQL = "UPDATE BAIDANGFORUM SET LUOTPHANHOI = LUOTPHANHOI+1 WHERE MABDFORUM = ?";
              PreparedStatement pr = conn.prepareStatement(strSQL);
              pr.setInt(1, mabaidangforum);
              pr.executeUpdate();
              conn.close();
              System.out.println("Cap nhat so luong LUOTPHANHOI cho bai dang co ma "+mabaidangforum+" thanh cong!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

   

    public static ArrayList<PostDetailView> getCommentsFromDatabaseBaseOnPostID(int mabaidang) {
        ArrayList<PostDetailView> postDetailViewList = new ArrayList<>();
        try{
            Connection conn = ConnectionManager.getConnection();
            String strSQL = "SELECT B.MABDFORUM, T.USERNAME, B.THOIDIEMBL, B.NOIDUNG FROM BINHLUAN B JOIN TAIKHOAN T ON B.NGUOIBL = T.MATK WHERE MABDFORUM = ?";
            PreparedStatement stat = conn.prepareStatement(strSQL);
            stat.setInt(1, mabaidang);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                int postID = result.getInt(1);
                String replyPerson = result.getString(2);
                Timestamp replyTimeStamp = result.getTimestamp(3);
                String content = result.getString(4);
                PostDetailView postDetailView = new PostDetailView(postID, replyPerson, replyTimeStamp.toLocalDateTime(), content);
                postDetailViewList.add(postDetailView);
            }
            conn.close();
            System.out.println("Get comments of postID "+mabaidang+" from database successfully!");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return postDetailViewList;
    }
    
//    public static PostDetailView loadDataIntoPostDetailView(int mabaidang) {
//        PostDetailView postDetailView = new PostDetailView(mabaidang);
//        try{
//            Connection conn = ConnectionManager.getConnection();
//            String strSQL = "SELECT T.USERNAME, THOIDIEMDANG, TIEUDE, NOIDUNG FROM BAIDANGFORUM B JOIN TAIKHOAN T ON B.NGUOIDANG = T.MATK WHERE B.MABDFORUM = ?";
//            
//            PreparedStatement stat = conn.prepareStatement(strSQL);
//            stat.setInt(1, mabaidang);
//            ResultSet result = stat.executeQuery();
//            while(result.next()){
//                postDetailView.setPostingPerson(result.getString(1));
//                postDetailView.setPostingTimeStamp(result.getTimestamp(2).toLocalDateTime());
//                postDetailView.setTitle(result.getString(3));
//                postDetailView.setContent(result.getString(4));
//            }
//            conn.close();
//            System.out.println("Lay thong tin bai dang forum dua vao ma bai dang thanh cong!");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return postDetailView;
//    }

        public static ArrayList<Object> getDataIntoPostDetailView(int mabaidang) {
            ArrayList<Object> postDetailView = new ArrayList<>();
        try{
            Connection conn = ConnectionManager.getConnection();
            String strSQL = "SELECT T.USERNAME, THOIDIEMDANG, TIEUDE, NOIDUNG FROM BAIDANGFORUM B JOIN TAIKHOAN T ON B.NGUOIDANG = T.MATK WHERE B.MABDFORUM = ?";         
            PreparedStatement stat = conn.prepareStatement(strSQL);
            stat.setInt(1, mabaidang);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                postDetailView.add(result.getString(1));
                postDetailView.add(result.getTimestamp(2).toLocalDateTime());
                postDetailView.add(result.getString(3));
                postDetailView.add(result.getString(4));
            }
            conn.close();
            System.out.println("Lay thong tin tu csdl vao PostDetailView.java (thong tin chi tiet bai dang khi nguoi dung click vao tieu de bai dang do o giao dien chinh cua forum) thanh cong!");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return postDetailView;
    }
//    public static com.forum.features.StatisticFeatureFrame getInfomationToShowStatisticFrame(int mabaidang){
//        com.forum.features.StatisticFeatureFrame frame = new com.forum.features.StatisticFeatureFrame();
//        try{
//            Connection conn = ConnectionManager.getConnection();
//            String strSQL = "SELECT T.USERNAME, B.MABDFORUM, B.THOIDIEMDANG, B.LUOTXEM, B.LUOTPHANHOI FROM TAIKHOAN T JOIN BAIDANGFORUM B ON T.MATK = B.NGUOIDANG WHERE MABDFORUM = ?";
//            PreparedStatement pre = conn.prepareStatement(strSQL);
//            pre.setInt(1, mabaidang);
//            ResultSet result = pre.executeQuery();
//
//            while(result.next()){
//                frame.setPostedBy(result.getString(1));
//                frame.setPostID(result.getInt(2));
//                frame.setPostedAt(result.getTimestamp(3).toLocalDateTime());
//                frame.setViewNumbers(result.getInt(4));
//                frame.setReplyNumbers(result.getInt(5));
//            }
//            conn.close();
//            System.out.println("Get information of post ID "+mabaidang+" to show statistic successfully!");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return frame;
//    }
        public static ArrayList<Object> getInfomationToShowStatisticFrame(int mabaidang) {
            ArrayList<Object> statisticInfoFrame = new ArrayList<>();
        try{
            Connection conn = ConnectionManager.getConnection();
            String strSQL = "SELECT T.USERNAME, B.THOIDIEMDANG, B.LUOTXEM, B.LUOTPHANHOI FROM TAIKHOAN T JOIN BAIDANGFORUM B ON T.MATK = B.NGUOIDANG WHERE MABDFORUM = ?";
            PreparedStatement stat = conn.prepareStatement(strSQL);
            stat.setInt(1, mabaidang);
            ResultSet result = stat.executeQuery();
            while(result.next()){
                statisticInfoFrame.add(result.getString(1));
                statisticInfoFrame.add(result.getTimestamp(2).toLocalDateTime());
                statisticInfoFrame.add(result.getInt(3));
                statisticInfoFrame.add(result.getInt(4));
            }
            conn.close();
            System.out.println("Get information of post ID "+mabaidang+" to show statistic successfully!");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return statisticInfoFrame;
    }
}
