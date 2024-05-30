/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import com.uiteco.database.ConnectionManager;
import static com.uiteco.database.mock.InsertBAIDANG.getRandomContent;
import static com.uiteco.database.mock.InsertBAIDANG.getRandomImages;
import static com.uiteco.database.mock.InsertBAIDANG.getRandomTags;
import static com.uiteco.database.mock.InsertBAIDANG.getRandomThumbnail;
import static com.uiteco.database.mock.InsertBAIDANG.readAllContents;
import static com.uiteco.database.mock.InsertCAULACBO.getAllClubIDs;
import static com.uiteco.database.mock.InsertCAULACBO.getRandomClubID;
import static com.uiteco.database.mock.InsertCAULACBO.getRandomDateInPast;
import static com.uiteco.database.mock.InsertTAIKHOAN.getAllAccountIDs;
import static com.uiteco.ofSuKienPanel.SuKienDAO.createSuKien;
import static com.uiteco.ofSuKienPanel.SuKienDAO.getAllTags;
import static com.uiteco.ofSuKienPanel.SuKienDAO.loadImagesFromFolder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.time.LocalDateTime;

/**
 *
 * @author nddmi
 */
public class InsertBAIDANG_CUOCTHI {

    public static void insertBAIDANG_CUOCTHI() throws Exception {
        String imagePath = "D:\\DoAn\\database\\mock\\ImagesOfSuKien"; // Replace with your folder path
        String thumbnailPath = "src/main/resources/thumbnails_cuocthi"; // Replace with your folder path

        String contentPath = "D:\\DoAn\\database\\mock\\content"; // Replace with your folder path
        List<String> fileContents = readAllContents(contentPath);
        
        List<ImageIcon> images = loadImagesFromFolder(imagePath);
        List<ImageIcon> thumbnailImages = loadImagesFromFolder(thumbnailPath);
        Set<String> tags = getAllTags();
        List<Integer> accountIDs = getAllAccountIDs();
        List<Integer> clubIDs = getAllClubIDs();
        
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = null;
        
        for (int i = 0; i < 5; i++) {
            String title = "Đây là sự cuộc thi thư  " + String.valueOf(i + 1);
            LocalDate enrollStart = getRandomDateInPast();
            LocalDate enrollEnd = LocalDate.now().plusDays(7);
            LocalDate start = LocalDate.now().plusDays(9);
            LocalDate end = start.plusDays(1);
            Integer postID = createSuKien(
                    2,
                    title,
                    getRandomContent(fileContents),
                    156, // Admin account
                    getRandomTags(tags),
                    getRandomImages(images),
                    getRandomThumbnail(thumbnailImages),
                    getRandomClubID(clubIDs),
                    true,
                    i % 2 == 0 ? i + 10 : null,
                    enrollStart,
                    enrollEnd,
                    "Trường đại học Công nghệ Thông tin" // org
            );

            if (postID == null) {
                System.err.println("Insert baidang failed, skipping");
                continue;
            }
            
            try {
                String sql = "UPDATE BAIDANG SET THOIDIEMBD_DIENRA = ?, THOIDIEMKT_DIENRA = ? WHERE MABD = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setDate(1, java.sql.Date.valueOf(start));
                pstm.setDate(2, java.sql.Date.valueOf(end));
                pstm.setInt(3, postID);
                pstm.executeUpdate();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                System.err.println("Error when updating baidang of cuocthi, skipping");
                continue;
            }
        }
        
        conn.commit();
        pstm.close();
        conn.close();
    }
}
