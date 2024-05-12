package com.uiteco.OfCuocThiPanel.data;

import com.uiteco.OfCuocThiPanel.firstPage.Model_OnePost;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static com.uiteco.database.ConnectionManager.getConnection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import java.time.*;
import java.util.*;

public class RetrieveData {
    public RetrieveData() {}
    
    public String[] getAllTags(){ //retrieve tags data in TAG_BAIDANG table
        try{
            
            conn = getConnection(); //get connection to database
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
            query = "SELECT * FROM TAG_NAMES";
            rset = stmt.executeQuery(query); 
        
            List<Object> tags = new ArrayList<>(); //contains string values obtained from a database
            while (rset.next()) {
                tags.add(rset.getString("TAG")); 
            }
            
            rset.close();
            conn.close();
            
            return tags.toArray(String[]::new); //String[]::new is a method reference to the constructor of the String[] array, 
                                                //which takes no arguments and returns a new String array
        
//            rset.close(); //need to be placed before return, if place here it cannot be executed cause return make this method done
//            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
            return new String[0];
        }
    }
    
                
    public List<Model_OnePost> getOnePostInfo(){
        try{
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
            query = "SELECT "
                    + "NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, TAG "
                    + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT, TAGS_BAIDANG T "
                    + "WHERE BD.MABD = BD_CT.MABD AND T.MABD = BD.MABD "
                    + "AND LOAIBD = 2 "
                    + "ORDER BY THOIDIEMDANG DESC";
            rset = stmt.executeQuery(query);
            
            List<Model_OnePost> postList = new ArrayList<>(); 
            
            while (rset.next()) {
                Model_OnePost post = new Model_OnePost();
                post.setContent(rset.getString("NOIDUNG"));
                post.setTitle(rset.getString("TIEUDE"));
                post.setType(rset.getString("HINHTHUCTG"));
                
                byte[] imageData = rset.getBytes("THUMBNAIL");
                if(imageData != null){
                    try{
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);
                        
                        //create a scaled version of the BufferedImage
                        Image thumbnail = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        
                        //set the Image object as the thumnail
                        post.setImage(thumbnail);
               
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
                
                post.setOrganizer(rset.getString("DONVITOCHUC"));
                Date sqlDate = rset.getDate("NGAYBD_DANGKICUOCTHI");
                if(sqlDate != null){
                    LocalDate localDate = ((java.sql.Date) sqlDate).toLocalDate();
                    post.setStartDate(localDate);
                }
                
                Date sqlDate1 = rset.getDate("NGAYHETHAN_DANGKICUOCTHI");
                if(sqlDate1 != null){
                    LocalDate localDate = ((java.sql.Date) sqlDate).toLocalDate();
                    post.setEndDate(localDate);
                }
                
                String tagsString = rset.getString("TAG");
                if(tagsString != null){
                    String[] tagsArray = tagsString.split(",");
                    List<String> tagsList = Arrays.asList(tagsArray);
                    post.setTags(tagsList);
                }
                
                postList.add(post);
            }
            
            conn.close();
            rset.close();
                
            return postList;
                
        }catch(SQLException e){
            e.printStackTrace();
            return new ArrayList<>(0);
        }

    }
        
    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;
}
