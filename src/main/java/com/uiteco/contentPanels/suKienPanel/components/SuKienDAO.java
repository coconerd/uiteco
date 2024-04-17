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

    /**
     * Should not use this
     *
     * @return
     */
    public static ArrayList<SuKienModel> getAll() {
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
            SuKienModel event = new SuKienModel(title, tag, postID, type, content, postedBy, postedAt, note, clubID);
            suKienList.add(event);
        }

        return suKienList;
    }

    /**
     *
     * @param N
     * @return
     */
    public static ArrayList<SuKienModel> getNewest(int N) {

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
            SuKienModel event = new SuKienModel(title, tag, postId, type, content, postedBy, postedAt, note, clubID);
            suKienList.add(event);
        }

        return suKienList;
    }

    public static ArrayList<SuKienModel> getNewest() {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();

        // mock
        for (int i = 0; i < 100; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            String tag = null;
            int postId = i;
            String content = "Hello World Java Swing GUI. It's such a beautiful day isn't it? So how's life been treating you lately! Life is shit btw, but's that doesn't make it any less beautiful";
            String postedBy = "Duc Minh Dev";
            java.time.LocalDate postedAt = java.time.LocalDate.now();
            String note = null;
            String clubID = null;
            SuKienModel event = new SuKienModel(title, tag, postId, type, content, postedBy, postedAt, note, clubID);
            suKienList.add(event);
        }

        return suKienList;

    }

    public static int getCount() {
        return 100;  // mock
    }

    public static ArrayList<SuKienModel> getPageData(int page, int pageSize) {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();

        // mock
        for (int i = 0; i < 100; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            String tag = null;
            int postId = i;
            String content = "Hello World Java Swing GUI. It's such a beautiful day isn't it? So how's life been treating you lately! Life is shit btw, but's that doesn't make it any less beautiful";
            String postedBy = "Duc Minh Dev";
            java.time.LocalDate postedAt = java.time.LocalDate.now();
            String note = null;
            String clubID = null;
            SuKienModel event = new SuKienModel(title, tag, postId, type, content, postedBy, postedAt, note, clubID);
            suKienList.add(event);
        }
        
        int startIdx = (page -  1) * pageSize;
        int endIdx = Math.min(startIdx + pageSize, suKienList.size());
        System.out.println("Debug: start index = " + startIdx);
        System.out.println("Debug: end index = " + endIdx);
        
        
        java.util.List<SuKienModel> sublist = suKienList.subList(startIdx, endIdx);
        return new ArrayList<SuKienModel>(sublist);
    }
}
