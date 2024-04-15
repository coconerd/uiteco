/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.util.ArrayList;

/**
 *
 * @author nddmi
 */
public class SuKienDAO {
    
    public static ArrayList<SuKienModel> getAllSuKienFromDb() {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        // mock
        for (int i = 0; i < 100; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            String tag = null;
            int postID = i;
            String content = "Hello World Java Swing GUI. It's such a beautiful day isn't it? So how's life been treating you lately! Life is shit btw, but's that doesn't make it any less beautiful";
            String postedBy = "Duc Minh Dev";
            java.time.LocalDate postedAt = java.time.LocalDate.now();
            String note = null;
            String clubID = null;
            SuKienModel event = new SuKienModel(title, tag, postID, type, content, postedBy, postedAt,note, clubID);
            suKienList.add(event);
        }
            
        return suKienList;
    }
    
    public static ArrayList<SuKienModel> getFirstNSuKienFromDb(int N) {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        // mock
        for (int i = 0; i < N; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            String tag = null;
            int postId = i;
            String content = "Hello World Java Swing GUI. It's such a beautiful day isn't it? So how's life been treating you lately! Life is shit btw, but's that doesn't make it any less beautiful";
            String postedBy = "Duc Minh Dev";
            java.time.LocalDate postedAt = java.time.LocalDate.now();
            String note = null;
            String clubID = null;
            SuKienModel event = new SuKienModel(title, tag, postId, type, content, postedBy, postedAt,note, clubID);
            suKienList.add(event);
        }
            
        return suKienList;
    }
}
