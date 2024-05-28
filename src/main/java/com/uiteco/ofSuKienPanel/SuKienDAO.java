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
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Arrays;
import static com.uiteco.main.App.getSession;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
import java.sql.CallableStatement;
import static com.uiteco.main.App.getSession;
import com.uiteco.ofTaiKhoanPanel.postManagement.TaiKhoanModelParticipant;
import java.sql.Date;

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
            int type = 1;
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
            int type = 1;
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
                + "     (SELECT MABD, NGUOIDANG, TIEUDE, THUMBNAIL, THOIDIEMDANG FROM BAIDANG WHERE LOAIBD = 1 ORDER BY " + (sortOption == SORT_OPTION.HOTTEST ? "LUOTDANGKY DESC, LUOTTHICH DESC, LUOTXEM DESC" : "THOIDIEMDANG DESC") + ") BD "
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

        if (tagCount < 1) {
            return getPageData(page, pageSize, sortOption);
        }

        String tagParams = "(";
        int i = 0;
        for (String tag : selectedTags) {
            tagParams += "'" + tag + "'";
            if (i < tagCount - 1) {
                tagParams += ", ";
            }
            i++;
        }
        tagParams += ")";

        String sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, BD.THOIDIEMDANG, TK.HOTEN\n"
                + "FROM\n"
                + "	(SELECT B.MABD, B.NGUOIDANG, B.TIEUDE, B.THUMBNAIL, B.THOIDIEMDANG, B.LUOTDANGKY, B.LUOTTHICH, B.LUOTXEM  FROM BAIDANG B WHERE B.LOAIBD = 1 \n"
                + "		AND EXISTS (SELECT 1 FROM TAGS_BAIDANG TBD WHERE TBD.MABD = B.MABD AND TBD.TAG IN " + tagParams + ")) BD \n"
                + "JOIN\n"
                + "	(SELECT HOTEN, MATK FROM TAIKHOAN) TK ON BD.NGUOIDANG = TK.MATK\n"
                + "ORDER BY " + (sortOption == SORT_OPTION.NEWEST ? "BD.THOIDIEMDANG DESC" : "BD.LUOTXEM DESC, BD.LUOTTHICH DESC, BD.LUOTXEM DESC") + "\n"
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
//
//        int i = 1;
//        for (String tag : selectedTags) {
//            pstm.setString(i, tag);
//            i++;
//        }
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


        /*
        Real function
//         */
//        ArrayList<SuKienModel> suKienList = new ArrayList();
//
//        Connection conn = ConnectionManager.getConnection();
//
//        String sql = "SELECT BD.MABD, BD.TIEUDE, BD.THUMBNAIL, BD.THOIDIEMDANG, TK.HOTEN "
//                + "FROM "
//                + "     (SELECT MABD, NGUOIDANG, TIEUDE, THUMBNAIL, THOIDIEMDANG, LUOTDANGKY, LUOTTHICH, LUOTXEM FROM BAIDANG WHERE LOAIBD = 1) BD\n"
//                + "JOIN\n"
//                + "     (SELECT HOTEN, MATK FROM TAIKHOAN) TK ON BD.NGUOIDANG = TK.MATK\n"
//                + "ORDER BY THOIDIEMDANG DESC, LUOTDANGKY DESC, LUOTTHICH DESC, LUOTXEM DESC\n"
//                + "FETCH FIRST ? ROWS ONLY";
//
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setInt(1, slides);
//        ResultSet rs = pstm.executeQuery();
//
//        while (rs.next()) {
//            SuKienModel post = new SuKienModel();
//            post.setPostID(rs.getInt("MABD"));
//            post.setTitle(rs.getString("TIEUDE"));
//            post.setPostedAt(rs.getTimestamp("THOIDIEMDANG").toLocalDateTime());
//            post.setPostedBy(rs.getString("HOTEN"));
//            Blob blob = rs.getBlob("THUMBNAIL");
//
//            if (!rs.wasNull()) {
//                try {
//                    InputStream is = blob.getBinaryStream(1, blob.length());
//                    Image buffImage = ImageIO.read(is);
//                    ImageIcon thumbnail = new ImageIcon(buffImage);
//
//                    // Cleanup
//                    is.close();
//                    blob.free();
//                    is = null;
//                    buffImage = null;
//                    blob = null;
//
//                    post.setThumbnail(thumbnail);
//                } catch (Exception e) {
//                    System.out.println("Encountered exception, skipping");
//                }
//
//            }
//
//            suKienList.add(post);
//        }
//        return suKienList;
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
            int postType,
            String title,
            String content,
            int accountID,
            Set<String> tags,
            List<ImageIcon> images,
            ImageIcon thumbnail,
            Integer clubID,
            boolean enrollable,
            Integer enrollLimit,
            LocalDate enrollStart,
            LocalDate enrollEnd,
            String organization
    ) throws IOException, SQLException {
        Connection conn = ConnectionManager.getConnection();

        // Insert BAIDANG
        String sql = "INSERT INTO BAIDANG (TIEUDE, NOIDUNG, NGUOIDANG, THUMBNAIL, MACLBDANGBAI, LOAIBD, COTHEDANGKY, SL_DANGKY_TOIDA, NGAYBD_DANGKY, NGAYHH_DANGKY)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

        pstm.setInt(6, postType); // 1 for Su kien, 2 for Cuoc thi

        if (enrollable) {
            pstm.setInt(7, 1);
            if (enrollLimit != null) {
                pstm.setInt(8, enrollLimit);
            } else {
                pstm.setNull(8, java.sql.Types.INTEGER);
            }
            pstm.setDate(9, Date.valueOf(enrollStart));
            pstm.setDate(10, Date.valueOf(enrollEnd));
        } else {
            pstm.setInt(7, 0);
            pstm.setNull(8, java.sql.Types.INTEGER);
            pstm.setNull(9, java.sql.Types.DATE);
            pstm.setNull(10, java.sql.Types.DATE);
        }

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
            if (organization != null) {
                sql = "INSERT INTO BAIDANG_CUOCTHI (MABD, DONVITOCHUC) VALUES (?, ?)";
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, postID);
                pstm.setNString(2, organization);
                pstm.executeUpdate();
            }

        }

        if (genKeys != null) {
            genKeys.close();
        }
        conn.commit();
        pstm.close();
        conn.close();
    }

    public static void updateSuKien(
            int postID,
            int postType,
            String title,
            String content,
            int accountID,
            Set<String> tags,
            List<ImageIcon> images,
            ImageIcon thumbnail,
            boolean enrollable,
            Integer enrollLimit,
            LocalDate enrollStart,
            LocalDate enrollEnd
    ) throws IOException, SQLException {
        Connection conn = ConnectionManager.getConnection();

        // Insert BAIDANG
        String sql = """
                     UPDATE BAIDANG
                     SET TIEUDE = ?,
                     \tNOIDUNG = ?,
                     \tTHUMBNAIL = ?,
                     \tLOAIBD = ?,
                     \tCOTHEDANGKY = ?,
                     \tSL_DANGKY_TOIDA = ?,
                     \tNGAYBD_DANGKY = ?,
                     \tNGAYHH_DANGKY = ?
                     WHERE MABD = ?""";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, title);

        NClob nclob = conn.createNClob();
        nclob.setString(1, content);
        pstm.setNClob(2, nclob);

        if (thumbnail == null) {
            pstm.setNull(3, java.sql.Types.BLOB);
        } else {
            pstm.setBlob(3, new ByteArrayInputStream(DataUtils.convertImageIconToBytes(thumbnail)));
        }

        pstm.setInt(4, postType);

        if (enrollable) {
            pstm.setInt(5, 1);
            if (enrollLimit != null) {
                pstm.setInt(6, enrollLimit);
            } else {
                pstm.setNull(6, java.sql.Types.INTEGER);
            }
            pstm.setDate(7, Date.valueOf(enrollStart));
            pstm.setDate(8, Date.valueOf(enrollEnd));
        } else {
            pstm.setInt(5, 0);
            pstm.setNull(6, java.sql.Types.INTEGER);
            pstm.setNull(7, java.sql.Types.DATE);
            pstm.setNull(8, java.sql.Types.DATE);
        }
        pstm.setInt(9, postID);

        pstm.executeUpdate();

        sql = "DELETE FROM TAGS_BAIDANG WHERE MABD = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, postID);
        pstm.executeUpdate();
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
        sql = "DELETE FROM HINHANH WHERE MABD = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, postID);
        pstm.executeUpdate();
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
            if (!rs.wasNull()) {
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
                }
            }

            likers.add(liker);
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
        String sql = """
                     SELECT LBD.MABD, NOIDUNG, MACLBDANGBAI, LUOTXEM, LUOTTHICH, TENCLB, LUOTDANGKY, COTHEDANGKY, NGAYBD_DANGKY, NGAYHH_DANGKY, SL_DANGKY_TOIDA, LOAIBD
                     FROM 
                     \t(SELECT MABD, NOIDUNG, MACLBDANGBAI, LUOTXEM, LUOTTHICH, LUOTDANGKY, COTHEDANGKY, NGAYBD_DANGKY, NGAYHH_DANGKY, SL_DANGKY_TOIDA, LOAIBD FROM BAIDANG BD WHERE MABD = ?) BD 
                     LEFT JOIN
                          (SELECT MACLB, TENCLB FROM CAULACBO) CLB ON BD.MACLBDANGBAI = CLB.MACLB LEFT JOIN
                     \t(SELECT MABD FROM THICH_BAIDANG WHERE MATK = ? AND MABD = ?) LBD ON LBD.MABD = BD.MABD""";
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
            suKienModel.setEnrollCount(rs.getInt("LUOTDANGKY"));
            suKienModel.setType(rs.getInt("LOAIBD"));
            suKienModel.setEnrollable(rs.getInt("COTHEDANGKY") == 1 ? true : false);
            if (suKienModel.isEnrollable()) {
                suKienModel.setEnrollStart(rs.getDate("NGAYBD_DANGKY").toLocalDate());
                suKienModel.setEnrollEnd(rs.getDate("NGAYHH_DANGKY").toLocalDate());
                Integer enrollLimit = rs.getInt("SL_DANGKY_TOIDA");
                if (!rs.wasNull()) {
                    suKienModel.setEnrollLimit(enrollLimit);
                }
            }

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
        suKienModel.setTags(tags);

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

    public static LinkedList<TaiKhoanModel> getParticipants(SuKienModel suKienModel) throws SQLException {
        LinkedList<TaiKhoanModel> result = new LinkedList<>();
        String sql = """
                     SELECT TK.MATK, HOTEN, ANHDAIDIEN, TENKHOA
                     FROM\t
                     \t(SELECT MATK, HOTEN, ANHDAIDIEN FROM TAIKHOAN WHERE MATK IN (SELECT MATK FROM DANGKY DK WHERE DK.MABD = ?)) TK
                     \tJOIN
                     \t(SELECT TENKHOA, MATK FROM SINHVIEN) SV ON SV.MATK = TK.MATK""";
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            TaiKhoanModel user = new TaiKhoanModel();
            user.setAccountID(rs.getInt("MATK"));
            user.setFullname(rs.getString("HOTEN"));
            user.setFaculty(rs.getString("TENKHOA"));
            Blob blob = rs.getBlob("ANHDAIDIEN");
            if (!rs.wasNull()) {
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

                    user.setAvatar(thumbnail);
                } catch (Exception e) {
                    System.out.println("Encountered exception when parsing avatar of user " + user.getAccountID());
                }
            }
            result.add(user);
        }

        rs.close();
        pstm.close();
        conn.close();
        return result;
    }

    public static LinkedList<TaiKhoanModelParticipant> getParticipantsManagement(SuKienModel suKienModel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = """
                     SELECT TK.MATK, HOTEN, MSSV, TENKHOA, DK.THOIDIEMDK
                     FROM
                     \t(SELECT MATK, HOTEN FROM TAIKHOAN WHERE LOAITK = 2 OR LOAITK = 3) TK
                     \tJOIN
                     \t(SELECT MATK, MSSV, TENKHOA FROM SINHVIEN) SV ON SV.MATK = TK.MATK
                     \tJOIN
                     \t(SELECT MATK, THOIDIEMDK FROM DANGKY WHERE MABD = ?) DK ON DK.MATK = TK.MATK""";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, suKienModel.getPostID());
        ResultSet rs = pstm.executeQuery();

        LinkedList<TaiKhoanModelParticipant> result = new LinkedList<>();
        while (rs.next()) {
            TaiKhoanModelParticipant user = new TaiKhoanModelParticipant();
            user.setAccountID(rs.getInt("MATK"));
            user.setFullname(rs.getString("HOTEN"));
            user.setMssv(rs.getString("MSSV"));
            user.setFaculty(rs.getString("TENKHOA"));
            user.setEnrolledAt(rs.getTimestamp("THOIDIEMDK").toLocalDateTime());
            result.add(user);
        }

        pstm.close();
        conn.close();
        return result;
    }

    public static void enrollInSuKien(SuKienModel suKienModel) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "{CALL PROC_DANGKY_SUKIEN(?, ?, ?)}";
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, getSession().getUser().getAccountID());
        cstm.setInt(2, suKienModel.getPostID());
        cstm.registerOutParameter(3, java.sql.Types.INTEGER);
        cstm.execute();
        suKienModel.setEnrollCount(cstm.getInt(3));

        cstm.close();
        conn.close();
    }

    public static ArrayList<SuKienModel> getPostsOfUser(TaiKhoanModel user) throws SQLException {
        ArrayList<SuKienModel> result = new ArrayList<>();

        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT MABD, TIEUDE, THUMBNAIL, LUOTXEM, LUOTTHICH, THOIDIEMDANG, COTHEDANGKY, LUOTDANGKY, SL_DANGKY_TOIDA, CAPNHATLANCUOI FROM BAIDANG WHERE NGUOIDANG = ? ORDER BY CAPNHATLANCUOI DESC";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, user.getAccountID());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            SuKienModel post = new SuKienModel();
            post.setPostID(rs.getInt("MABD"));
            post.setTitle(rs.getString("TIEUDE"));
            post.setViews(rs.getInt("LUOTXEM"));
            post.setLikes(rs.getInt("LUOTTHICH"));
            post.setPostedAt(rs.getTimestamp("THOIDIEMDANG").toLocalDateTime());
            post.setEnrollable(rs.getInt("COTHEDANGKY") == 1 ? true : false);
            post.setEnrollCount(rs.getInt("LUOTDANGKY"));
            post.setLastUpdated(rs.getTimestamp("CAPNHATLANCUOI").toLocalDateTime());

            Integer enrollLimit = rs.getInt("SL_DANGKY_TOIDA");
            post.setEnrollLimit(!rs.wasNull() ? enrollLimit : null);

            Blob blob = rs.getBlob("THUMBNAIL");
            if (!rs.wasNull()) {
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

                    post.setThumbnail(thumbnail);
                } catch (Exception e) {
                    System.out.println("Encouterend exception when parsing thumbnail of post");
                }
            }

            result.add(post);
        }

        rs.close();
        pstm.close();
        return result;
    }

    public static void deletePost(SuKienModel suKienModel) throws SQLException {
        String sql = "{CALL PROC_XOA_BAIDANG(?)}";
        Connection conn = ConnectionManager.getConnection();
        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, suKienModel.getPostID());
        cstm.execute();

        cstm.close();
        conn.close();
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
