package com.uiteco.OfCuocThiPanel.dataBase;

import com.bulenkov.iconloader.util.Pair;
import com.bulenkov.iconloader.util.Scalr;
import com.bulenkov.iconloader.util.Scalr.Method;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.pagination.Pagination;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Model;
import com.uiteco.OfCuocThiPanel.secondPage.pieChart.ModelPieChart;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static com.uiteco.database.ConnectionManager.getConnection;
import static com.uiteco.main.App.getSession;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CuocThiDAO {

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
            return new ArrayList<>();
        }
    }


    //5 khóa
    public static List<ModelPieChart> getDataForPieChart_CourseYear(int postID) {
        List<ModelPieChart> modelList = new ArrayList<>();
        try {
            conn = getConnection();
            query = "SELECT COUNT(D.MATK) AS COUNT_MATK, "
                    + "'K' || (TO_CHAR(TO_NUMBER(SUBSTR(S.MSSV, 1, 2)) - 5)) AS COURSE_YEAR "
                    + "FROM DANGKY D "
                    + "JOIN SINHVIEN S ON D.MATK = S.MATK "
                    + "WHERE D.MABD = ? "
                    + "GROUP BY SUBSTR(S.MSSV, 1, 2)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            int index = 0;
            while (rset.next()) {
                int count = rset.getInt("COUNT_MATK");
                String courseYear = rset.getString("COURSE_YEAR");

                ModelPieChart model = new ModelPieChart(courseYear, count, getColor(index++));
                modelList.add(model);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    //6 khoa 
    public static List<ModelPieChart> getDataForPieChart_FacultyName(int postID) {
        List<ModelPieChart> modelList = new ArrayList<>();
        try {
            conn = getConnection();
            query = "SELECT TENKHOA, COUNT(D.MATK) AS COUNT_MATK "
                    + "FROM DANGKY D, SINHVIEN S "
                    + "WHERE D.MATK = S.MATK AND D.MABD = ? "
                    + "GROUP BY TENKHOA";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            int index = 0;
            while (rset.next()) {
                String tk = rset.getString("TENKHOA");
                int count = rset.getInt("COUNT_MATK");

                ModelPieChart model = new ModelPieChart(tk, count, getColor(index++));
                modelList.add(model);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    //color for pie chart
    public static Color getColor(int index) {
        Color[] color = new Color[]{
            new Color(211, 223, 122),
            new Color(223, 122, 130),
            new Color(226, 248, 143),
            new Color(64, 70, 40),
            new Color(114, 79, 243),
            new Color(253, 235, 243)
        };
        return color[index % color.length];
    }

    public static List<BriefPost_Model> getPostsInfo_Default() {
        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            query = "SELECT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                    + "FROM BAIDANG "
                    + "WHERE LOAIBD = 2 "
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
                
                post.setCountLike(rset.getInt("LUOTTHICH"));
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
                    }
                }
                
//                byte[] imageData1 = rset.getBytes("THUMBNAIL_YOUTUBEPLAY");
//                if (imageData1 != null) {
//                    try {
//                        //convert the byte array to an Image object
//                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData1);
//                        BufferedImage bufferedImage = ImageIO.read(inputStream);
//
//                        //create a scaled version of the BufferedImage
//                        Image scaledImage = bufferedImage.getScaledInstance(480, 360, Image.SCALE_SMOOTH);
//
//                        //set the Image object as the thumnail
//                        ImageIcon thumbnail = new ImageIcon(scaledImage);
//                        post.setImage(thumbnail);
//                        
//                    } catch (IOException e) {
//                    }
//                }
//                
                post.setOrganizer(rset.getString("DONVITOCHUC"));
                
                Timestamp timeStampPost = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampPost != null) {
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }
                
                Timestamp _timeStampPost = rset.getTimestamp("THOIDIEMBD_DIENRA");
                if (_timeStampPost != null) {
                    LocalDateTime localDateTimePost = _timeStampPost.toLocalDateTime();
                    post.setDueDate(localDateTimePost);
                }
                
                LocalDate timeStart = rset.getDate("NGAYBD_DANGKY").toLocalDate();
                if (timeStart != null) {
                    
                    post.setStartDate(timeStart);
                }
                
                LocalDate timeEnd = rset.getDate("NGAYHH_DANGKY").toLocalDate();
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

    public static DetailedOnePost_Model getAllImagesForPosts(int postID) {
        DetailedOnePost_Model model = new DetailedOnePost_Model();
        List<ImageIcon> imagesList = new ArrayList<>();

        query = "SELECT ANH "
                + "FROM HINHANH "
                + "WHERE MABD = ?";

        try {
            conn = getConnection();

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();

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

            model.setImages(imagesList);

            rset.close();
            p.close();
            conn.close();

        } catch (SQLException e) {
        }
        return model;
    }

    //use store procedure
    public static void getCountLikePost(BriefPost_Model model) {
        try {
            conn = getConnection();
            query = "{CALL PROC_THICH_BAIDANG(?, ?, ?)}";
            CallableStatement cstm = conn.prepareCall(query);
            cstm.setInt(1, model.getId());
            cstm.setInt(2, getSession().getAccountID());
            cstm.registerOutParameter(3, java.sql.Types.INTEGER);
            cstm.execute();

            int likes = cstm.getInt(3);

            model.setCountLike(likes);

            conn.close();
            cstm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerCompetition(BriefPost_Model model) {
        try {
            conn = getConnection();
            query = "{CALL PROC_DANGKY_SUKIEN(?, ?, ?)}";
            CallableStatement cstm = conn.prepareCall(query);

            cstm.setInt(1, getSession().getAccountID());
            cstm.setInt(2, model.getId());
            cstm.registerOutParameter(3, java.sql.Types.INTEGER);
            cstm.execute();

            conn.close();
            cstm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Pair<URI, String>> getvideoAndThumbnailYoutubeUrl(int postID){
        List<Pair<URI, String>> listUrls = new ArrayList<>();
        
        try{
            conn = getConnection();
            query = "SELECT URL FROM HINHANH WHERE MABD = ? AND URL LIKE '%youtube.com%'";
            
            PreparedStatement p = conn.prepareCall(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            
            while(rset.next()){
                String ytVideoUrl = rset.getString("URL");
                URI ytVideoURI = stringToURI(ytVideoUrl);
                String ytThumbnailUrl = getYouTubeThumbnailUrl(ytVideoUrl);
                
                Pair<URI, String> urls = new Pair<>(ytVideoURI, ytThumbnailUrl);
                listUrls.add(urls);
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUrls;
    }
    
    public static URI stringToURI(String uriString) {
        try {
            return new URI(uriString);
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + uriString);
            e.printStackTrace();
            return null;
        }
    }
    
    private static String extractYouTubeVideoId(String videoUrl) {
        String videoId = null;
        String pattern = "^(?:https?:\\/\\/)?(?:www\\.)?(?:youtube\\.com\\/.*(?:\\bv=|\\/v\\/|\\/embed\\/|\\/watch\\/|\\/v\\/|\\/e\\/|\\/user\\/[^#]*?\\/[^#]*?\\/|youtu\\.be\\/|\\/embed\\/|\\/v\\/|\\/e\\/|watch\\?.*?&?v=)|youtu\\.be\\/)([^#\\&\\?\\n]*)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(videoUrl);

        if (matcher.find()) {
            videoId = matcher.group(1);
        }
        return videoId;
    }
    
    private static String getYouTubeThumbnailUrl(String videoUrl) {
        String videoId = extractYouTubeVideoId(videoUrl);
        if (videoId != null) {
            return "https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";
        }
        return null;
    }
    
    public static void downloadFile(String fileURL, String saveDir) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileURL);

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                // Extracts the content and saves it to a file
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream outputStream = new FileOutputStream(saveDir)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("File downloaded to " + saveDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    //for pagination
    public static List<BriefPost_Model> getPostsInfo_Offset(Pagination p, int page, int limit, int type, boolean dueDate, boolean hottest) {
        List<BriefPost_Model> postList = new ArrayList<>();
        int offset = (page - 1) * limit;
        try {
            conn = getConnection();
            
            String query1 = "SELECT COUNT(*) FROM BAIDANG WHERE LOAIBD = 2";
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rset1 = stmt.executeQuery(query1);
            int count = 0;
            if (rset1.first()) {
                count = rset1.getInt(1);
            }
            rset1.close();
            stmt.close();
            
            int totalPages = (int) Math.ceil((double) count / limit);
            
            if (type == 0) {
                if (dueDate == true) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                            + "FROM BAIDANG "
                            + "WHERE LOAIBD = 2 AND THOIDIEMBD_DIENRA = NGAYHH_DANGKY "
                            + "ORDER BY THOIDIEMDANG DESC "
                            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                } else if (hottest == true) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                            + "FROM BAIDANG "
                            + "WHERE LOAIBD = 2 "
                            + "ORDER BY LUOTTHICH DESC "
                            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                }
            } else if (type == 1 || type == 2) {
                query = "SELECT "
                        + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                        + "FROM BAIDANG "
                        + "WHERE LOAIBD = 2 AND HINHTHUCTG = ? "
                        + "ORDER BY LUOTTHICH DESC "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                
            } else if (type == 3) {
                query = "SELECT "
                        + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                        + "FROM BAIDANG "
                        + "WHERE LOAIBD = 2 "
                        + "ORDER BY THOIDIEMDANG DESC "
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            }
            
            PreparedStatement pstm = conn.prepareStatement(query);
            
            if (type == 1 || type == 2) {
                pstm.setInt(1, type);
                pstm.setInt(2, offset);
                pstm.setInt(3, limit);
            } else {
                pstm.setInt(1, offset);
                pstm.setInt(2, limit);
            }
            
            rset = pstm.executeQuery();
            
            while (rset.next()) {
                
                BriefPost_Model post = new BriefPost_Model();
                
                int postID = rset.getInt("MABD");
                post.setId(postID);
                
                String tagQuery = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
                PreparedStatement pstmt = conn.prepareStatement(tagQuery);
                pstmt.setInt(1, postID);
                
                ResultSet tagRset = pstmt.executeQuery();
                
                List<String> tagsString = new ArrayList<>();
                
                while (tagRset.next()) {
                    tagsString.add(tagRset.getString("TAG"));
                }
                
                post.setCountLike(rset.getInt("LUOTTHICH"));
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
                
                Timestamp _timeStampPost = rset.getTimestamp("THOIDIEMBD_DIENRA");
                if (_timeStampPost != null) {
                    LocalDateTime localDateTimePost = _timeStampPost.toLocalDateTime();
                    post.setDueDate(localDateTimePost);
                }
                
                Timestamp timeStampPost = rset.getTimestamp("THOIDIEMDANG");
                if (timeStampPost != null) {
                    LocalDateTime localDateTimePost = timeStampPost.toLocalDateTime();
                    post.setPostTime(localDateTimePost);
                }
                
                LocalDate timeStart = rset.getDate("NGAYBD_DANGKY").toLocalDate();
                if (timeStart != null) {
                    
                    post.setStartDate(timeStart);
                }
                
                LocalDate timeEnd = rset.getDate("NGAYHH_DANGKY").toLocalDate();
                if (timeStart != null) {
                    
                    post.setEndDate(timeEnd);
                }
                
                postList.add(post);
                
            }
            p.setPagegination(page, totalPages);
            rset.close();
            conn.close();
            pstm.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return postList;
    }
    

    public static void insertUserRegisterCompetition(int postId) {
        try {
            conn = getConnection();
            query = "INSERT INTO DANGKY (MATK, MABD, THOIDIEMDK) VALUES (?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(query);

            p.setInt(1, getSession().getAccountID());
            p.setInt(2, postId);
            Timestamp time = Timestamp.valueOf(LocalDateTime.now());
            p.setTimestamp(3, time);

            rset = p.executeQuery();

            conn.commit();
            rset.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Insert succesfully");
    }

    public static void getRegisterInfo_TableView(JTable table, int postID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            conn = getConnection();
            query = "SELECT HOTEN, USERNAME, EMAIL, MSSV "
                    + "FROM TAIKHOAN T, DANGKY D, SINHVIEN S "
                    + "WHERE T.MATK = D.MATK AND D.MATK = S.MATK "
                    + "AND D.MABD = ?";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();

            // Load images from the folder
            ArrayList<String> avatars = loadImagesFromFolder("src/main/resources/CuocThiPanel_resources/avatars/");
            Random random = new Random();

            while (rset.next()) {
                String fullName = rset.getString("HOTEN");
                String userName = rset.getString("USERNAME");
                String email = rset.getString("EMAIL");
                String mssv = rset.getString("MSSV");

                // Select an avatar, default to a specific image if none are found
                String selectedAvatar;
                if (!avatars.isEmpty()) {
                    selectedAvatar = avatars.get(random.nextInt(avatars.size()));
                } else {
                    selectedAvatar = "src/main/resources/CuocThiPanel_resources/avatars/icons8-octocat-48.png"; // Default avatar image
                }

                ImageIcon avatarIcon = new ImageIcon(selectedAvatar);
                JLabel avatarLabel = new JLabel(avatarIcon);
                avatarLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the image horizontally
                avatarLabel.setVerticalAlignment(SwingConstants.CENTER);
                avatarLabel.setBorder(null);

                model.addRow(new Object[]{avatarLabel, fullName, userName, email, mssv});
            }

            table.setModel(model);
            conn.close();
            p.close();
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Integer> checkAlreadyRegisteredUser(int postID) {
        List<Integer> idList = new ArrayList<>();
        try {
            conn = getConnection();
            query = "SELECT MATK FROM DANGKY WHERE MABD = ?";
            PreparedStatement p = conn.prepareCall(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            while (rset.next()) {
                int id = rset.getInt("MATK");
                idList.add(id);
            }

            conn.close();
            p.close();
            rset.close();

        } catch (SQLException e) {
        }
        return idList;
    }

    // Method to load images from a folder
    private static ArrayList<String> loadImagesFromFolder(String folderPath) {
        ArrayList<String> imagePaths = new ArrayList<>();
        File folder = new File(folderPath);

        if (!folder.exists()) {
            return imagePaths;
        }

        // Filter to get only image files
        FilenameFilter imageFilter = (dir, name) -> {
            String lowercaseName = name.toLowerCase();
            return lowercaseName.endsWith(".jpg") || lowercaseName.endsWith(".png")
                    || lowercaseName.endsWith(".jpeg");
        };

        // Get list of image files in the folder
        File[] files = folder.listFiles(imageFilter);

        // Add image paths to the list
        if (files != null) {
            for (File file : files) {
                imagePaths.add(file.getAbsolutePath());
            }
        }

        return imagePaths;
    }

    public static List<BriefPost_Model> getPostsInfo_ByTags(Pagination p, int page, int limit, List<Object> selectedTags) {
        List<BriefPost_Model> postList = new ArrayList<>();
        try {
            conn = getConnection();
            
            String tagFilter = selectedTags.stream()
                    .map(tag -> "'" + tag + "'")
                    .collect(Collectors.joining(", "));
            
            String countQuery = "SELECT COUNT(*) "
                    + "FROM BAIDANG "
                    + "WHERE LOAIBD = 2 "
                    + "AND BD.MABD IN (SELECT MABD FROM TAGS_BAIDANG WHERE TAG IN (" + tagFilter + "))";
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rsetCount = stmt.executeQuery(countQuery);
            int count = 0;
            if (rsetCount.first()) {
                count = rsetCount.getInt(1);
            }
            rsetCount.close();
            stmt.close();
            
            int offset = (page - 1) * limit;
            int totalPages = (int) Math.ceil((double) count / limit);
            
            String offsetQuery = "SELECT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKY, NGAYHH_DANGKY, THOIDIEMDANG, LUOTTHICH, THOIDIEMBD_DIENRA "
                    + "FROM BAIDANG "
                    + "WHERE LOAIBD = 2 "
                    + "AND MABD IN (SELECT MABD FROM TAGS_BAIDANG WHERE TAG IN (" + tagFilter + ")) "
                    + "ORDER BY THOIDIEMDANG DESC "
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            
            PreparedStatement pOffset = conn.prepareStatement(offsetQuery);
            pOffset.setInt(1, offset);
            pOffset.setInt(2, limit);
            rset = pOffset.executeQuery();
            
            while (rset.next()) {
                BriefPost_Model post = new BriefPost_Model();
                
                int postID = rset.getInt("MABD");
                post.setId(postID);
                
                String tagQuery = "SELECT TAG FROM TAGS_BAIDANG WHERE MABD = ?";
                PreparedStatement pstmt = conn.prepareStatement(tagQuery);
                pstmt.setInt(1, postID);
                ResultSet tagRset = pstmt.executeQuery();
                
                List<String> tagsString = new ArrayList<>();
                
                while (tagRset.next()) {
                    tagsString.add(tagRset.getString("TAG"));
                }
                
                pstmt.close();
                
                Timestamp _timeStampPost = rset.getTimestamp("THOIDIEMBD_DIENRA");
                if (_timeStampPost != null) {
                    LocalDateTime localDateTimePost = _timeStampPost.toLocalDateTime();
                    post.setDueDate(localDateTimePost);
                }
                
                post.setCountLike(rset.getInt("LUOTTHICH"));
                post.setTags(tagsString);
                post.setContent(rset.getString("NOIDUNG"));
                post.setTitle(rset.getString("TIEUDE"));
                post.setType(rset.getInt("HINHTHUCTG"));
                
                byte[] imageData = rset.getBytes("THUMBNAIL");
                if (imageData != null) {
                    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData)) {
                        BufferedImage bufferedImage = ImageIO.read(inputStream);
                        Image scaledImage = bufferedImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        post.setImage(thumbnail);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
                post.setOrganizer(rset.getString("DONVITOCHUC"));
                post.setPostTime(rset.getTimestamp("THOIDIEMDANG").toLocalDateTime());
                post.setStartDate(rset.getDate("NGAYBD_DANGKY").toLocalDate());
                post.setEndDate(rset.getDate("NGAYHH_DANGKY").toLocalDate());
                
                postList.add(post);
            }
            conn.close();
            rset.close();
            pOffset.close();
            
            p.setPagegination(page, totalPages);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
    
    public static List<ImageIcon> getImagesForSlideshow() {
        List<ImageIcon> imagesList = new ArrayList<>();
        try {
            conn = getConnection();
            query = "SELECT B.MABD "
                    + "FROM HINHANH H, BAIDANG B "
                    + "WHERE H.MABD = B.MABD AND LOAIBD = 2 "
                    + "ORDER BY THOIDIEMDANG DESC";
            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rset = stmt.executeQuery(query);
            
            while (rset.next()) {
                String query1 = "SELECT ANH "
                        + "FROM HINHANH "
                        + "WHERE MABD = ? "
                        + "ORDER BY MAHINHANH "
                        + "FETCH FIRST 1 ROW ONLY";
                
                PreparedStatement p = conn.prepareStatement(query1);
                
                int postID1 = rset.getInt("MABD");
                p.setInt(1, postID1);
                ResultSet rset1 = p.executeQuery();
                while (rset1.next()) {
                    Blob blob = rset1.getBlob("ANH");
                    if (blob != null) {
                        try {
                            // Convert the Blob to a byte array
                            byte[] imageData = blob.getBytes(1, (int) blob.length());
                            // Convert the byte array to an Image object
                            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                            BufferedImage bufferedImage = ImageIO.read(inputStream);
                            if (bufferedImage != null) {
                                
                                Image scaledImg = Scalr.resize(bufferedImage, Method.ULTRA_QUALITY, 1300, 700);
                                ImageIcon thumbnail = new ImageIcon(scaledImg);
                                imagesList.add(thumbnail);
                            }
                            
                        } catch (IOException e) {
                        }
                    } else {
                        System.out.println("Failed to read the image!");
                    }
                }
                p.close();
                rset1.close();
            }
            
            rset.close();
            conn.close();
            
        } catch (SQLException e) {
        }
        return imagesList;
    }
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rset;
    static String query;
}
