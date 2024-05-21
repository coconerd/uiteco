package com.uiteco.OfCuocThiPanel.getDataFromDB;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.Pagination;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static com.uiteco.database.ConnectionManager.getConnection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import java.time.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CuocThiData {

    public static List<String> getAllTags() { //for comboBoxMultiSelection
        try {

            conn = getConnection(); //get connection to database
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            query = "SELECT * FROM TAG_NAMES";
            rset = stmt.executeQuery(query);

            List<String> tags = new ArrayList<>();
            while (rset.next()) {
                tags.add(rset.getString("TAG"));
            }

            rset.close();
            conn.close();

            return tags;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<BriefPost_Model> getPostsInfo_Default() {
        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            query = "SELECT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, SOLUOTTHICH, THOIDIEMDIENRA "
                    + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                    + "WHERE BD.MABD = BD_CT.MABD "
                    + "AND LOAIBD = 2 "
                    + "ORDER BY THOIDIEMDANG DESC";

            rset = stmt.executeQuery(query);

            List<BriefPost_Model> postList = new ArrayList<>();

            while (rset.next()) {
                BriefPost_Model post = new BriefPost_Model();

                int postID = rset.getInt("MABD");
                post.setId(postID);

                // SQL query with named parameters
                String tagQuery = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
                PreparedStatement pstmt = conn.prepareStatement(tagQuery);
                pstmt.setInt(1, postID);
                ResultSet tagRset = pstmt.executeQuery();

                List<String> tagsString = new ArrayList<>();

                while (tagRset.next()) {
                    tagsString.add(tagRset.getString("TAG"));
                }

                pstmt.close();

                post.setCountLike(rset.getInt("SOLUOTTHICH"));
                post.setTags(tagsString);
                post.setContent(rset.getString("NOIDUNG"));
                post.setTitle(rset.getString("TIEUDE"));
                post.setType(rset.getInt("HINHTHUCTG"));

                byte[] imageData = rset.getBytes("THUMBNAIL");
                if (imageData != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                        //set the Image object as the thumnail
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        post.setImage(thumbnail);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                post.setOrganizer(rset.getString("DONVITOCHUC"));

                Timestamp timeStampPost = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampPost != null) {
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }

                LocalDate timeBegin = rset.getDate("THOIDIEMDIENRA").toLocalDate();
                post.setDueDate(timeBegin);

                LocalDate timeStart = rset.getDate("NGAYBD_DANGKICUOCTHI").toLocalDate();
                if (timeStart != null) {

                    post.setStartDate(timeStart);
                }

                LocalDate timeEnd = rset.getDate("NGAYHETHAN_DANGKICUOCTHI").toLocalDate();
                if (timeStart != null) {

                    post.setEndDate(timeEnd);
                }

                postList.add(post);
            }

            conn.close();
            rset.close();

            return postList;

        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public static List<ImageIcon> getAllImages() {
        List<ImageIcon> imagesList = new ArrayList<>();
        query = "SELECT ANH, URL FROM HINHANH H "
                + "INNER JOIN "
                + "(SELECT MABD FROM BAIDANG WHERE LOAIBD = 2 ORDER BY THOIDIEMDANG DESC FETCH FIRST 10 ROWS ONLY) B "
                + "ON H.MABD = B.MABD";

        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rset = stmt.executeQuery(query);

            while (rset.next()) {

                byte[] imageData = rset.getBytes("ANH");

                if (imageData != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(943, 436, Image.SCALE_SMOOTH);
                        ImageIcon thumbnail = new ImageIcon(scaledImage);

                        //set the Image object as the thumnail
                        imagesList.add(thumbnail);

                    } catch (IOException e) {
                    }
                }
            }

            conn.close();
            rset.close();

        } catch (SQLException e) {
        }

        return imagesList;
    }

    public static boolean updateCountLikeDB(int postId, int newCountLike) {
        try {

            conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "UPDATE BAIDANG SET SOLUOTTHICH = ? WHERE MABD = ?");
            pstm.setInt(1, newCountLike);
            pstm.setInt(2, postId);
            int rowsAffected = pstm.executeUpdate();

            pstm.close();
            conn.close();

            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public static List<String> getURLForYTVideo(int postID){
//        try {
//            conn = getConnection();
//            String query = "SELECT URL "
//        } catch (SQLException e) {
//        }
//    }
    public static List<BriefPost_Model> getPostsInfo_Offset(Pagination p, int page) {

        List<BriefPost_Model> postList = new ArrayList<>();

        try {

            int limit = 1;

            String query1 = "SELECT "
                    + "COUNT(*), BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, SOLUOTTHICH "
                    + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                    + "WHERE BD.MABD = BD_CT.MABD AND "
                    + "AND LOAIBD = 2 "
                    + "ORDER BY THOIDIEMDANG DESC "
                    + "OFFSET " + (page - 1) * limit + " ROWS FETCH NEXT " + limit + " ROWS ONLY";

            PreparedStatement p1 = conn.prepareStatement(query1);
            rset = p1.executeQuery();

            while (rset.next()) {

                BriefPost_Model post = new BriefPost_Model();

                int postID = rset.getInt("MABD");
                post.setId(postID);

                // SQL query with named parameters
                String tagQuery = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
                PreparedStatement pstmt = conn.prepareStatement(tagQuery);
                pstmt.setInt(1, postID);

                ResultSet tagRset = pstmt.executeQuery();

                List<String> tagsString = new ArrayList<>();

                while (tagRset.next()) {
                    tagsString.add(tagRset.getString("TAG"));
                }
                post.setCountLike(rset.getInt("SOLUOTTHICH"));
                post.setTags(tagsString);
                post.setContent(rset.getString("NOIDUNG"));
                post.setTitle(rset.getString("TIEUDE"));
                post.setType(rset.getInt("HINHTHUCTG"));

                byte[] imageData = rset.getBytes("THUMBNAIL");
                if (imageData != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                        //set the Image object as the thumnail
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        post.setImage(thumbnail);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                post.setOrganizer(rset.getString("DONVITOCHUC"));

                Timestamp timeStampPost = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampPost != null) {
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }

                LocalDate timeStart = rset.getDate("NGAYBD_DANGKICUOCTHI").toLocalDate();
                if (timeStart != null) {

                    post.setStartDate(timeStart);
                }

                LocalDate timeEnd = rset.getDate("NGAYHETHAN_DANGKICUOCTHI").toLocalDate();
                if (timeStart != null) {

                    post.setEndDate(timeEnd);
                }

                postList.add(post);

            }
            //pagination 
            rset.close();
            conn.close();
            p1.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        return postList;
    }

    public static void insertUserRegisterCompetition(int postId, LocalDateTime timeLCT) {
        try {
            conn = getConnection();
            String query = "INSERT INTO DANGKY (MATK, MABD, THOIDIEMDK) VALUES (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(query);

            p.setInt(1, 1);
            p.setInt(2, postId);
            Timestamp time = Timestamp.valueOf(timeLCT);
            p.setTimestamp(3, time);

            rset = p.executeQuery();

            rset.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDataForRegisterTable(JTable table, int postID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String query = "SELECT HOTEN, USERNAME, EMAIL, MSSV "
                + "FROM TAIKHOAN T, DANGKY D, SINHVIEN S "
                + "WHERE T.MATK = D.MATK AND D.MATK = S.MATK "
                + "AND MABD = ?";

        try {
            conn = getConnection();
            PreparedStatement p = conn.prepareStatement(query);

            p.setInt(1, postID);
            rset = p.executeQuery();

            while (rset.next()) {
                String name = rset.getString("HOTEN");
                String userName = rset.getString("USERNAME");
                String email = rset.getString("EMAIL");
                String mssv = rset.getString("MSSV");

                model.addRow(new Object[]{name, userName, email, mssv});

                rset.close();
                p.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<String> getRegisterInfo(){
//        try {
//            conn = getConnection();
//            String query = "SELECT HOTEN, USERNAME, EMAIL, MSSV "
//                    + "FROM TAIKHOAN T, DANGKY D, SINHVIEN S "
//                    + "WHERE T.MATK = D.MATK AND D.MATK = S.MATK";
//            
//            rset = stmt.executeQuery(query);
//            List<String> registers = new ArrayList<>();
//            
//            while(rset.next()){
//                
//            }
//        } catch (SQLException e) {
//        }
//    }
    public static List<BriefPost_Model> getPostsInfo_Sort(int type, boolean dueDate, boolean hotest) {
        try {
            conn = getConnection();
            
            dueDate = false;
            hotest = false;
            
            //type = 0: not in a specific type
            //meet 1 requirment once time
            if (type == 0) {
                if (!dueDate) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, SOLUOTTHICH, THOIDIEMDIENRA "
                            + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                            + "WHERE BD.MABD = BD_CT.MABD "
                            + "AND LOAIBD = 2 AND THOIGIANDIENRA = NGAYHETHAN_DANGKICUOCTHI"
                            + "ORDER BY THOIDIEMDANG DESC";
                } else if (!hotest) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, SOLUOTTHICH, THOIDIEMDIENRA "
                            + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                            + "WHERE BD.MABD = BD_CT.MABD "
                            + "AND LOAIBD = 2 "
                            + "ORDER BY SOLUOTTHICH DESC";
                }

            } else if (type == 1 || type == 2){
                query = "SELECT "
                        + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, SOLUOTTHICH, THOIDIEMDIENRA "
                        + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                        + "WHERE BD.MABD = BD_CT.MABD "
                        + "AND LOAIBD = 2 AND HINHTHUCTG = ? " 
                        + " ORDER BY THOIDIEMDANG DESC ";
            }
            PreparedStatement p = conn.prepareStatement(query);
            
            p.setInt(1, type);
            rset = p.executeQuery();

            List<BriefPost_Model> postList = new ArrayList<>();

            while (rset.next()) {
                BriefPost_Model post = new BriefPost_Model();

                int postID = rset.getInt("MABD");
                post.setId(postID);

                // SQL query with named parameters
                String tagQuery = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
                PreparedStatement pstmt = conn.prepareStatement(tagQuery);
                pstmt.setInt(1, postID);
                ResultSet tagRset = pstmt.executeQuery();

                List<String> tagsString = new ArrayList<>();

                while (tagRset.next()) {
                    tagsString.add(tagRset.getString("TAG"));
                }

                pstmt.close();

                post.setCountLike(rset.getInt("SOLUOTTHICH"));
                post.setTags(tagsString);
                post.setContent(rset.getString("NOIDUNG"));
                post.setTitle(rset.getString("TIEUDE"));
                post.setType(rset.getInt("HINHTHUCTG"));

                byte[] imageData = rset.getBytes("THUMBNAIL");
                if (imageData != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

                        //set the Image object as the thumnail
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        post.setImage(thumbnail);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                post.setOrganizer(rset.getString("DONVITOCHUC"));

                LocalDate timeBegin = rset.getDate("THOIDIEMDIENRA").toLocalDate();
                post.setDueDate(timeBegin);

                Timestamp timeStampPost = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampPost != null) {
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }

                LocalDate timeStart = rset.getDate("NGAYBD_DANGKICUOCTHI").toLocalDate();
                if (timeStart != null) {

                    post.setStartDate(timeStart);
                }
                LocalDate timeEnd = rset.getDate("NGAYHETHAN_DANGKICUOCTHI").toLocalDate();
                if (timeEnd != null) {

                    post.setEndDate(timeEnd);
                }

                postList.add(post);
            }

            conn.close();
            rset.close();
            p.close();

            return postList;

        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    static Connection conn;
    static Statement stmt;
    static ResultSet rset;
    static String query;
}
