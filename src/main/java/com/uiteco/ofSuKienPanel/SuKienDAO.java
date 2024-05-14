/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.uiteco.database.ConnectionManager;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

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

            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));

            int postID = i;
            String content = "Hello World Java Swing GUI. Hello World Coconerd. Hello world, good bye world. Bye bye world. I love Java. I hate Java. I hate IT.";
            String postedBy = "Minh Duc";
            java.time.LocalDateTime postedAt = java.time.LocalDateTime.now();
            String note = null;
            String clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\LabJava\\FeaturedImages\\3.jpg"); // Mock image
            int views = 1200;
            SuKienModel event = new SuKienModel(title, tags, postID, type, content, postedBy, postedAt, note, clubID, thumbnail, views);
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
            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
            int postId = i + 1;
            String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.";
            String postedBy = "Duc Minh";
            java.time.LocalDateTime postedAt = java.time.LocalDateTime.now();
            String note = null;
            String clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\DoAn\\database\\mock\\FeaturedImages\\3.jpg");
            int views = 1200;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views);
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
            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
            int postId = i + 1;
            String content = "Hello World Java Swing GUI. Hello World Coconerd. Hello world, good bye world. Bye bye world. I love Java. I hate Java. I hate IT.";
            String postedBy = "Duc Minh";
            java.time.LocalDateTime postedAt = java.time.LocalDateTime.now();
            String note = null;
            String clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\LabJava\\FeaturedImages\\3.jpg"); // Mock image
            int views = 1200;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views);
            suKienList.add(event);
        }

        return suKienList;

    }

    public static int getCount() {
        return 300;  // mock
    }

    public static LinkedList<SuKienModel> getPageData(int page, int pageSize) {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();

        // mock
        for (int i = 0; i < getCount(); i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
            int postId = i + 1;
//            String content = "Hello World Java Swing GUI. Hello World Coconerd. Hello world, good bye world. Bye bye world. I love Java. I hate Java. I hate IT.";
            String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum."
                    + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"\n"
                    + "                + \"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \"\n"
                    + "                + \"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi \"\n"
                    + "                + \"ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit \"\n"
                    + "                + \"in voluptate velit esse cillum dolore eu fugiat nulla pariatur. \"\n"
                    + "                + \"Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia \"\n"
                    + "                + \"deserunt mollit anim id est laborum.";
            String postedBy = "Duc Minh";
            java.time.LocalDateTime postedAt = java.time.LocalDateTime.now();
            String note = null;
            String clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\DoAn\\database\\mock\\FeaturedImages\\3.jpg"); // Mock image
            int views = 1200;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views);
            suKienList.add(event);
        }

        int startIdx = (page - 1) * pageSize;
        int endIdx = Math.min(startIdx + pageSize, suKienList.size());
        System.out.println("Debug: start index = " + startIdx);
        System.out.println("Debug: end index = " + endIdx);

        List<SuKienModel> sublist = suKienList.subList(startIdx, endIdx);
        return new LinkedList<SuKienModel>(sublist);
    }

    public static ArrayList<SuKienModel> getSuKienSlideShow(int slides) {
        /**
         * Mock function
         */
        int imageCount = getSlideShowPageCount();
        int imageIndex = 0;
        ArrayList<ImageIcon> images = loadImagesFromFolder();

        ArrayList<SuKienModel> suKienList = new ArrayList<SuKienModel>();
        for (int i = 0; i < slides; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
            int postId = i + 1;
            String content = "Hello World Java Swing GUI. Hello World Coconerd. Hello world, good bye world. Bye bye world. I love Java. I hate Java. I hate IT.";
            String postedBy = "Duc Minh";
            java.time.LocalDateTime postedAt = java.time.LocalDateTime.now();
            String note = null;
            String clubID = null;
            ImageIcon thumbnail = images.get(imageIndex);
            imageIndex = (imageIndex == imageCount - 1 ? 0 : imageIndex + 1); // Update image index
            int views = 1200;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views);
            suKienList.add(event);
        }
        return suKienList;
    }

    public static int getSlideShowPageCount() {
        return 5;
    }

    // Mock only
    public static ArrayList<ImageIcon> loadImagesFromFolder() {
        String folderPath = "D:\\DoAn\\database\\mock\\FeaturedImages"; // Hardcoded folder path
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        ArrayList<ImageIcon> imageIcons = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                ImageIcon icon = new ImageIcon(file.getPath());
                imageIcons.add(icon);
            }
        }
        return imageIcons;
    }

    // Mock only
    public static ArrayList<ImageIcon> loadImagesFromFolder(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        ArrayList<ImageIcon> imageIcons = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                ImageIcon icon = new ImageIcon(file.getPath());
                imageIcons.add(icon);
            }
        }
        return imageIcons;
    }

    public static ArrayList<ImageIcon> getSuKienImages(int postID) throws SQLException, IOException {
        ArrayList images = new ArrayList<ImageIcon>();
//
//        try {
//            Connection conn = ConnectionManager.getConnection();
//
//            String sql = "SELECT * FROM BAIDANG WHERE MABD = ?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, postID);
//            System.out.println("Fetching images for postID: " + postID);
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                Blob blob = rs.getBlob("ANH");
//                Image image = javax.imageio.ImageIO.read(blob.getBinaryStream());
//                ImageIcon imageIcon = new ImageIcon(image);
//                images.add(imageIcon);
//            }
//
//            conn.close();
//            return images;
//
//        } catch (SQLException | IOException e) {
//            throw e;
//        }
        // Mock

        return loadImagesFromFolder("D:\\DoAn\\database\\mock\\ImagesOfSuKien");
    }

    public static ArrayList<SuKienModel> searchSuKienByTitle(String title) throws SQLException {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        if (title == null) {
            return suKienList;
        }

//        try {
//            Connection conn = ConnectionManager.getConnection();
//            
//            
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw e;
//        }
        /**
         * Mock data
         */
        for (SuKienModel sk : getNewest(50)) {
            if (sk.getTitle().contains(title)) {
                suKienList.add(sk);
            }
        }

        return suKienList;
    }

    public static ArrayList<SuKienModel> searchSuKienByContent(String content) throws SQLException {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        if (content == null) {
            return suKienList;
        }

//        try {
//            Connection conn = ConnectionManager.getConnection();
//            
//            
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw e;
//        }
        /**
         * Mock data
         */
        for (SuKienModel sk : getNewest(50)) {
            if (sk.getContent().contains(content)) {
                suKienList.add(sk);
            }
        }

        return suKienList;
    }

    public static ArrayList<SuKienModel> searchSuKienByOwner(String owner) throws SQLException {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        if (owner == null) {
            return suKienList;
        }

//        try {
//            Connection conn = ConnectionManager.getConnection();
//            
//            
//            
//            conn.close();
//        } catch (SQLException e) {
//            throw e;
//        }
        /**
         * Mock data
         */
        for (SuKienModel sk : getNewest(50)) {
            if (sk.getPostedBy().contains(owner)) {
                suKienList.add(sk);
            }
        }

        return suKienList;
    }

    public HashSet<String> getTagsOfSuKien(int postID) throws SQLException {
            HashSet<String> tags;

//        try {
//            Connection conn = ConnectionManager.getConnection();
//            String sql = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
//            PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = pstm.executeQuery();
//            
//            while (rs.next()) {
//                String tag = rs.getString("TAGS");
//                tags.add(tag);
//            }
//            
//            rs.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw e;
//        }
//        
        /**
         * Mock
         */
//        tags.add("Beginner Friendly");
//        tags.add("Low/No Code");
//        tags.add("Social good");
        tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
        return tags;
    }

    public static HashSet<String> getAllTags() throws SQLException {
        HashSet<String> tags = new HashSet<String>();

        String sql = "SELECT TAG FROM TAG_NAMES";

        try {
            Connection conn = ConnectionManager.getConnection();
            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                tags.add(rs.getString("TAG"));
            }

            rs.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }

        return tags;
    }

    /**
     * Function meant for test-only purpose
     */
    public static void main(String[] args) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
