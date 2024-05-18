package com.uiteco.OfCuocThiPanel.getDataFromDB;

import com.uiteco.OfCuocThiPanel.firstPage.Model.OnePost_Model;
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

public class CuocThiData {

    public static List<String> getAllTags() { //retrieve all tags data in TAG_BAIDANG table
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

    public static List<OnePost_Model> getPostsInfo() {
        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            query = "SELECT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG "
                    + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                    + "WHERE BD.MABD = BD_CT.MABD "
                    + "AND LOAIBD = 2 "
                    + "ORDER BY THOIDIEMDANG DESC";

            rset = stmt.executeQuery(query);

            List<OnePost_Model> postList = new ArrayList<>();

            while (rset.next()) {
                OnePost_Model post = new OnePost_Model();

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
                if(timeStampPost != null){
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }
                
                Timestamp timeStampStart = rset.getTimestamp("NGAYBD_DANGKICUOCTHI");
                if (timeStampStart != null) {
                    LocalDate localDateStart = timeStampStart.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
                    post.setStartDate(localDateStart);
                }
                Timestamp timeStampEnd = rset.getTimestamp("NGAYHETHAN_DANGKICUOCTHI");
                if (timeStampEnd != null) {
                    LocalDate localDateEnd = timeStampEnd.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
                    post.setEndDate(localDateEnd);
                }
                Timestamp timeStampThoiDiemDang = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampThoiDiemDang != null) {
                    LocalDate localDateThoiDiemDang = timeStampThoiDiemDang.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
                    post.setThoiDiemDang(localDateThoiDiemDang);
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

    public static List<ImageIcon> getAllImagesAndURL() {
        List<ImageIcon> imagesList = new ArrayList<>();
        String imageQuery = "SELECT ANH FROM HINHANH H "
                + "INNER JOIN "
                + "(SELECT MABD FROM BAIDANG WHERE LOAIBD = 2 ORDER BY THOIDIEMDANG DESC FETCH FIRST 10 ROWS ONLY) B "
                + "ON H.MABD = B.MABD";

        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rset = stmt.executeQuery(imageQuery);

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
        } catch (SQLException e) {
        }

        return imagesList;
    }

    static Connection conn;
    static Statement stmt;
    static ResultSet rset;
    static String query;
}
