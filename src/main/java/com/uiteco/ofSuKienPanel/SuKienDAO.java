/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.uiteco.database.ConnectionManager;
import com.uiteco.ofSuKienPanel.search.SuKienListModelSearch;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import static com.uiteco.ofSuKienPanel.tagsAndSort.SuKienListModelWithTagSort.SORT_OPTION;
import static com.uiteco.ofSuKienPanel.search.SuKienListModelSearch.SEARCH_OPTION;
import static com.uiteco.ofSuKienPanel.tagsAndSort.SuKienListModelWithTagSort.DEFAULT_SORT_OPTION;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import javax.imageio.ImageIO;
import java.sql.NClob;
import com.uiteco.database.DataUtils;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import static com.uiteco.main.App.getSession;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
import java.sql.CallableStatement;

/**
 *
 * @author nddmi
 */
public class SuKienDAO {

    public static Set<String> getRandomTags(Set<String> originalTags) {
        // Convert the original set to a list
        List<String> list = new ArrayList<>(originalTags);

        // Determine the number of elements to select (between 1 and 3, inclusive)
        int selectQuantity = new Random().nextInt(Math.min(3, originalTags.size())) + 1;

        // Shuffle the list to randomize the order
        Collections.shuffle(list);

        // Create a new set to hold the randomly selected elements
        Set<String> randomSubset = new HashSet<>();

        // Add the randomly selected elements to the new set
        for (int i = 0; i < selectQuantity; i++) {
            randomSubset.add(list.get(i));
        }

        return randomSubset;
    }

    public static ArrayList<SuKienModel> genMockData() throws SQLException {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        // mock
        for (int i = 0; i < 100; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
//            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
//            try {
            Set<String> tags = getRandomTags(getAllTags());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

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
            Integer clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\DoAn\\database\\mock\\FeaturedImages\\3.jpg");
            int views = i + 1;
            int likes = views - 1;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views, likes);
            suKienList.add(event);
        }

        return suKienList;
    }

    public static ArrayList<SuKienModel> genMockData(int N) throws SQLException {
        ArrayList<SuKienModel> suKienList = new ArrayList<>();
        // mock
        for (int i = 0; i < N; i++) {
            String title = String.format("Day la su kien thu %d", i + 1);
            String type = "Event";
//            HashSet<String> tags = new HashSet<>(java.util.Arrays.asList("Beginner Friendly", "Social Good", "Low/No Code"));
//            try {
            Set<String> tags = getRandomTags(getAllTags());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

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
            Integer clubID = null;
            ImageIcon thumbnail = new ImageIcon("D:\\DoAn\\database\\mock\\FeaturedImages\\3.jpg");
            int views = i + 1;
            int likes = views - 1;
            SuKienModel event = new SuKienModel(title, tags, postId, type, content, postedBy, postedAt, note, clubID, thumbnail, views, likes);
            suKienList.add(event);
        }

        return suKienList;
    }

    public static Integer getCount(Set<String> tags) throws SQLException {
        int tagCount = tags.size();

        if (tagCount < 1) {
            return getCount();
        }

        String tagParams = "";
        for (int i = 0; i < tagCount; i++) {
            tagParams += "?";
            if (i < tagCount - 1) {
                tagParams += ", ";
            }
        }
        String sql = "SELECT COUNT(DISTINCT BD.MABD) FROM "
                + "     (SELECT MABD FROM BAIDANG WHERE LOAIBD = 1) BD "
                + "JOIN "
                + "     (SELECT MABD FROM TAGS_BAIDANG WHERE TAG IN (" + tagParams + ")) TA ON TA.MABD = BD.MABD";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        int i = 1;
        for (String tag : tags) {
            pstm.setString(i, tag);
            i++;
        }

        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            return null;
        }
        int count = rs.getInt(1);
        pstm.close();
        rs.close();
        conn.close();
        return count;
    }

    public static Integer getCount() throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT COUNT(MABD) FROM BAIDANG WHERE LOAIBD = 1";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            return null;
        }

        int count = rs.getInt(1);
        conn.close();
        pstm.close();
        return count;
    }

    public static ArrayList<SuKienModel> searchSuKien(String searchText, SEARCH_OPTION searchOption, int page, int pageSize) throws SQLException, IOException {
        ArrayList<SuKienModel> result = new ArrayList<SuKienModel>();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = null;
        String sql = "";

        switch (searchOption) {
            case title:
                sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, T.HOTEN, BD.THOIDIEMDANG "
                        + "FROM "
                        + "    (SELECT MABD, TIEUDE, THUMBNAIL, NGUOIDANG, THOIDIEMDANG FROM BAIDANG WHERE LOAIBD = 1 AND TIEUDE LIKE ?) BD "
                        + "JOIN "
                        + "    (SELECT HOTEN, MATK FROM TAIKHOAN) T "
                        + "ON T.MATK = BD.NGUOIDANG "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + searchText + "%");
                pstm.setInt(2, (page - 1) * pageSize);
                pstm.setInt(3, pageSize + 1); // Fetch an extra row to see if there is more page
                break;
            case content:
                sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, T.HOTEN, BD.THOIDIEMDANG "
                        + "FROM "
                        + "    (SELECT MABD, TIEUDE, THUMBNAIL, NGUOIDANG, THOIDIEMDANG FROM BAIDANG WHERE LOAIBD = 1 AND DBMS_LOB.INSTR(NOIDUNG, ?) > 0)  BD "
                        + "JOIN "
                        + "    (SELECT HOTEN, MATK FROM TAIKHOAN) T "
                        + "ON T.MATK = BD.NGUOIDANG "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, searchText);
                pstm.setInt(2, (page - 1) * pageSize);
                pstm.setInt(3, pageSize + 1); // Fetch an extra row to see if there is more page
                break;
            case postedBy:
                sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, T.HOTEN, BD.THOIDIEMDANG "
                        + "FROM "
                        + "    (SELECT MABD, TIEUDE, THUMBNAIL, NGUOIDANG, THOIDIEMDANG FROM BAIDANG WHERE LOAIBD = 1)  BD "
                        + "JOIN "
                        + "    (SELECT HOTEN, MATK FROM TAIKHOAN WHERE HOTEN LIKE ? OR USERNAME LIKE ?) T "
                        + "ON T.MATK = BD.NGUOIDANG "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                ;
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%" + searchText + "%");
                pstm.setString(2, "%" + searchText + "%");
                pstm.setInt(3, (page - 1) * pageSize);
                pstm.setInt(4, pageSize + 1); // Fetch an extra row to see if there is more page
                break;
        }

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int postID = rs.getInt("MABD");
            String title = rs.getString("TIEUDE");
//            ImageIcon thumbnail = DataUtils.blobToImageIcon(rs.getBlob("THUMBNAIL"));
            Blob blob = rs.getBlob("THUMBNAIL");
            String postedBy = rs.getString("HOTEN");
            LocalDateTime postedAt = rs.getTimestamp("THOIDIEMDANG").toLocalDateTime();

            SuKienModel newModel = new SuKienModel();
            try {
                InputStream is = blob.getBinaryStream(1, blob.length());
                Image buffImage = ImageIO.read(is);
                ImageIcon thumbnail = new ImageIcon(buffImage);

                // Cleanup
                is.close();
                blob.free();
                is = null;
                buffImage = null;
                blob = null;
                newModel.setThumbnail(thumbnail);
            } catch (Exception e) {
                System.out.println("Encountered exception, skipping");
            } finally {
                newModel.setPostID(postID);
                newModel.setTitle(title);
                newModel.setTitle(title);
                newModel.setPostedAt(postedAt);
                newModel.setPostedBy(postedBy);
                result.add(newModel);
            }
        }

        pstm.close();
        rs.close();
        conn.close();
        return result;
    }

//    public static SuKienModel getSuKien() {
//        
//    }
    public static LinkedList<SuKienModel> getPageData(int page, int pageSize, SORT_OPTION sortOption) throws SQLException {
        String sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, BD.THOIDIEMDANG, TK.HOTEN "
                + "FROM "
                + "     (SELECT MABD, NGUOIDANG, TIEUDE, THUMBNAIL, THOIDIEMDANG FROM BAIDANG WHERE LOAIBD = 1 ORDER BY " + (sortOption == SORT_OPTION.HOTTEST ? "LUOTXEM" : "THOIDIEMDANG") + " DESC) BD "
                + "JOIN "
                + "     (SELECT HOTEN, MATK FROM TAIKHOAN) TK ON BD.NGUOIDANG = TK.MATK "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pstm.setInt(1, (page - 1) * pageSize);
        pstm.setInt(2, pageSize);

        LinkedList<SuKienModel> suKienList = new LinkedList<SuKienModel>();

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            SuKienModel newModel = new SuKienModel();
            int postID = rs.getInt("MABD");
            String title = rs.getString("TIEUDE");
            String postedBy = rs.getString("HOTEN");
            LocalDateTime postedAt = rs.getTimestamp("THOIDIEMDANG").toLocalDateTime();
            Blob blob = rs.getBlob("THUMBNAIL");

            try {
                InputStream is = blob.getBinaryStream(1, blob.length());
                Image buffImage = ImageIO.read(is);
                ImageIcon thumbnail = new ImageIcon(buffImage);

                // Cleanup
                is.close();
                blob.free();
                is = null;
                buffImage = null;
                blob = null;
                newModel.setThumbnail(thumbnail);
            } catch (Exception e) {
                System.err.println("Encountered exception when parsing thumbnail of su kien" + String.valueOf(postID));

            } finally {
                newModel.setPostID(postID);
                newModel.setTitle(title);
                newModel.setPostedAt(postedAt);
                newModel.setPostedBy(postedBy);
                suKienList.add(newModel);
            }
        }

        pstm.close();
        rs.close();
        conn.close();
        return suKienList;
    }

    public static LinkedList<SuKienModel> getPageData(int page, int pageSize, Set<String> selectedTags, SORT_OPTION sortOption) throws SQLException {
        int tagCount = selectedTags.size();

        System.err.println("DEBUG: selected tags: " + selectedTags.toString());
        if (tagCount < 1) {
            return getPageData(page, pageSize, sortOption);
        }
        

        String tagParams = "";
        for (int i = 0; i < tagCount; i++) {
            tagParams += "?";
            if (i < tagCount - 1) {
                tagParams += ", ";
            }
        }
        String sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, BD.THOIDIEMDANG, TK.HOTEN "
                + "FROM "
                + "  (SELECT B.MABD, B.NGUOIDANG, B.TIEUDE, B.THUMBNAIL, B.THOIDIEMDANG FROM BAIDANG B WHERE "
                + "    B.LOAIBD = 1 AND "
                + "    EXISTS (SELECT 1 FROM TAGS_BAIDANG TBD WHERE TBD.MABD = B.MABD AND TBD.TAG IN (" + tagParams + "))"
                + "    ORDER BY " + (sortOption == SORT_OPTION.HOTTEST ? "B.LUOTXEM" : "B.THOIDIEMDANG") + " DESC) BD "
                + "JOIN "
                + "  (SELECT HOTEN, MATK FROM TAIKHOAN) TK ON BD.NGUOIDANG = TK.MATK "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);

        int i = 1;
        for (String tag : selectedTags) {
            pstm.setNString(i, tag);
            i++;
        }
        pstm.setInt(i, (page - 1) * pageSize);
        pstm.setInt(i + 1, pageSize);

        LinkedList<SuKienModel> suKienList = new LinkedList<SuKienModel>();
        
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            SuKienModel newModel = new SuKienModel();
            int postID = rs.getInt("MABD");
            String title = rs.getString("TIEUDE");
            String postedBy = rs.getString("HOTEN");
            LocalDateTime postedAt = rs.getTimestamp("THOIDIEMDANG").toLocalDateTime();
            Blob blob = rs.getBlob("THUMBNAIL");

            try {
                InputStream is = blob.getBinaryStream(1, blob.length());
                Image buffImage = ImageIO.read(is);
                ImageIcon thumbnail = new ImageIcon(buffImage);

                // Cleanup
                is.close();
                blob.free();
                is = null;
                buffImage = null;
                blob = null;
                newModel.setThumbnail(thumbnail);
            } catch (Exception e) {
                System.err.println("Encountered exception when parsing thumbnail of su kien" + String.valueOf(postID));
            } finally {
                newModel.setPostID(postID);
                newModel.setTitle(title);
                newModel.setPostedAt(postedAt);
                newModel.setPostedBy(postedBy);
                suKienList.add(newModel);
            }
        }

        pstm.close();
        rs.close();
        conn.close();
        return suKienList;
    }

    public static ArrayList<SuKienModel> getSuKienSlideShow(int slides) throws SQLException {
        /**
         * Mock function
         */
        int imageCount = getSlideShowPageCount();
        int imageIndex = 0;
        ArrayList<ImageIcon> images = loadImagesFromFolder();

//        ArrayList<SuKienModel> suKienList = new ArrayList<SuKienModel>();
        ArrayList<SuKienModel> suKienList = genMockData(slides);

        for (int i = 0; i < slides; i++) {
            ImageIcon thumbnail = images.get(imageIndex);
            suKienList.get(i).setThumbnail(thumbnail);

            imageIndex = (imageIndex == imageCount - 1 ? 0 : imageIndex + 1); // Update image index
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

    public static HashSet<String> getTagsOfSuKien(int postID) throws SQLException {
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

    public static void createSuKien(
            String title,
            String content,
            int accountID,
            Set<String> tags,
            List<ImageIcon> images,
            ImageIcon thumbnail,
            Integer clubID
    ) throws IOException, SQLException {
        Connection conn = ConnectionManager.getConnection();

        // Insert BAIDANG
        String sql = "INSERT INTO BAIDANG (TIEUDE, NOIDUNG, NGUOIDANG, THUMBNAIL, MACLBDANGBAI, LOAIBD) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(sql, new String[]{"MABD"});

        NClob nclob = conn.createNClob();
        nclob.setString(1, content);
        pstm.setString(1, title);

        pstm.setNClob(2, nclob);

        pstm.setInt(3, accountID);

        if (thumbnail == null) {
            pstm.setNull(4, java.sql.Types.BLOB);
        } else {
            pstm.setBlob(4, new ByteArrayInputStream(DataUtils.convertImageIconToBytes(thumbnail)));
        }

        if (clubID == null) {
            pstm.setNull(5, java.sql.Types.INTEGER);
        } else {
            pstm.setInt(5, clubID);
        }

        pstm.setInt(6, 1); // 1 value is for SuKien

        pstm.executeUpdate();
        ResultSet genKeys = pstm.getGeneratedKeys();

        if (genKeys.next()) {
            int postID = genKeys.getInt(1);
            if (tags != null && tags.size() > 0) {
                // Insert TAGS_BAIDANG
                sql = "INSERT INTO TAGS_BAIDANG (MABD, TAG) VALUES (?, ?)";
                pstm = conn.prepareStatement(sql);
                for (String tag : tags) {
                    pstm.setInt(1, postID);
                    pstm.setString(2, tag);
                    pstm.addBatch();
                }
                pstm.executeBatch();
            }
            if (images != null && images.size() > 0) {
                sql = "INSERT INTO HINHANH (MABD, ANH) VALUES (?, ?)";
                pstm = conn.prepareStatement(sql);
                for (ImageIcon image : images) {
                    pstm.setInt(1, postID);
                    pstm.setBlob(2, new ByteArrayInputStream(DataUtils.convertImageIconToBytes(image)));
                    pstm.addBatch();
                }
                pstm.executeBatch();
            }
        }

        conn.commit();
        pstm.close();
        conn.close();
    }

    public static ArrayList<TaiKhoanModel> getLikers(SuKienModel suKienModel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT TK.MATK, HOTEN, ANHDAIDIEN FROM "
                + "     (SELECT MATK FROM THICH_BAIDANG WHERE MABD = ?) LBD "
                + "JOIN "
                + "     (SELECT HOTEN, ANHDAIDIEN, MATK FROM TAIKHOAN) TK ON LBD.MATK = TK.MATK "
                + "FETCH FIRST 20 ROWS ONLY";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        ResultSet rs = pstm.executeQuery();

        ArrayList<TaiKhoanModel> likers = new ArrayList<>();

        while (rs.next()) {
            TaiKhoanModel liker = new TaiKhoanModel();
            liker.setFullname(rs.getString("HOTEN"));
            liker.setAccountID(rs.getInt("MATK"));

            Blob blob = rs.getBlob("ANHDAIDIEN");
            try {
                InputStream is = blob.getBinaryStream(1, blob.length());
                Image buffImage = ImageIO.read(is);
                ImageIcon thumbnail = new ImageIcon(buffImage);

                // Cleanup
                is.close();
                blob.free();
                is = null;
                buffImage = null;
                blob = null;

                liker.setAvatar(thumbnail);
            } catch (Exception e) {
                System.out.println("Encountered exception, skipping");
            } finally {
                likers.add(liker);
            }
        }

        pstm.close();
        rs.close();
        conn.close();
        return likers;
    }

    public static void increaseViews(SuKienModel suKienModel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "{CALL PROC_TANG_LUOT_XEM_BAIDANG(?)}";
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, suKienModel.getPostID());
        cstm.execute();

        suKienModel.setViews(suKienModel.getViews() + 1);

        cstm.close();
        conn.close();
    }

    public static void getMissingDetail(SuKienModel suKienModel) throws IOException, SQLException {
        String content;
        Set<String> tags;
        List<ImageIcon> images;
        Integer clubID;
        Integer views;
        Integer likes;

        Connection conn = ConnectionManager.getConnection();
        // Get MACLB and NOIDUNG
        String sql = "SELECT LBD.MABD, NOIDUNG, MACLBDANGBAI, LUOTXEM, LUOTTHICH, TENCLB\n"
                + "FROM \n"
                + "	(SELECT MABD, NOIDUNG, MACLBDANGBAI, LUOTXEM, LUOTTHICH FROM BAIDANG BD WHERE MABD = ?) BD \n"
                + "LEFT JOIN\n"
                + "     (SELECT MACLB, TENCLB FROM CAULACBO) CLB ON BD.MACLBDANGBAI = CLB.MACLB "
                + "LEFT JOIN\n"
                + "	(SELECT MABD FROM THICH_BAIDANG WHERE MATK = ? AND MABD = ?) LBD ON LBD.MABD = BD.MABD";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        pstm.setInt(2, getSession().getUser().getAccountID());
        pstm.setInt(3, suKienModel.getPostID());

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            suKienModel.setClubID(rs.getInt("MACLBDANGBAI"));
            suKienModel.setViews(rs.getInt("LUOTXEM"));
            suKienModel.setLikes(rs.getInt("LUOTTHICH"));
            suKienModel.setContent(rs.getString("NOIDUNG"));

            // Check if user has liked the post
            rs.getInt("MABD");
            suKienModel.setLiked(!rs.wasNull());

            String clubName = rs.getString("TENCLB");
            if (!rs.wasNull()) {
                suKienModel.setClubName(clubName);
            }
        }

        // Get tags
        pstm.close();
        rs.close();
        sql = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        rs = pstm.executeQuery();
        tags = new HashSet<String>();
        while (rs.next()) {
            tags.add(rs.getString("TAG"));
        }
        if (!tags.isEmpty()) {
            suKienModel.setTags(tags);
        }

        // Get images
        pstm.close();
        rs.close();
        sql = "SELECT ANH FROM HINHANH WHERE MABD = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        rs = pstm.executeQuery();
        images = new ArrayList<ImageIcon>();
        while (rs.next()) {
            try {
                Blob blob = rs.getBlob("ANH");
                InputStream is = blob.getBinaryStream(1, blob.length());
                Image buffImage = ImageIO.read(is);
                ImageIcon image = new ImageIcon(buffImage);

                // Cleanup
                is.close();
                blob.free();
                is = null;
                buffImage = null;
                blob = null;

                images.add(image);
            } catch (Exception e) {
                System.err.println("Encountered exception when parsing ANH of su kien" + String.valueOf(suKienModel.getPostID()));
            }
        }
        if (!images.isEmpty()) {
            suKienModel.setImages(images.toArray(ImageIcon[]::new));
        }

        pstm.close();
        rs.close();
        conn.close();
    }

    public static void likePost(SuKienModel suKienModel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "{CALL PROC_THICH_BAIDANG(?, ?, ?)}";
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, suKienModel.getPostID());
        cstm.setInt(2, getSession().getUser().getAccountID());
        cstm.registerOutParameter(3, java.sql.Types.INTEGER);
        cstm.execute();

        int likes = cstm.getInt(3);
        suKienModel.setLikes(likes);
    }

    /**
     * Function meant for test-only purpose
     */
    public static void main(String[] args) {
        ImageIcon thumbnail = loadImagesFromFolder().get(0);
        try {
//            createSuKien("Nóng hổi vừa thổi vừa chill!!!", "Content bẩn nhưng lại nhiều view thì làm sao heheheheh", 2, getRandomTags(getAllTags()), loadImagesFromFolder(), thumbnail, null);
//            getSuKien();
//            System.out.println
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
