package com.uiteco.OfCuocThiPanel.dataBase;

import com.bulenkov.iconloader.util.Scalr;
import com.bulenkov.iconloader.util.Scalr.Method;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.Pagination;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Model;
import com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static com.uiteco.database.ConnectionManager.getConnection;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import java.time.*;
import java.util.*;
import javaswingdev.chart.ModelPieChart;
import javaswingdev.chart.PieChart;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public static List<BriefPost_Model> getPostsInfo_Default() {
        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            query = "SELECT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH, THOIDIEMDIENRA, THUMBNAIL_YOUTUBEPLAY "
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

                byte[] imageData1 = rset.getBytes("THUMBNAIL_YOUTUBEPLAY");
                if (imageData1 != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData1);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(480, 360, Image.SCALE_SMOOTH);

                        //set the Image object as the thumnail
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        post.setImage(thumbnail);

                    } catch (IOException e) {
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

    //5 khóa
    public static void getDataForPieChart_CourseYear(PieChart chart, int postID) {
        try {
            conn = getConnection();
            query = "SELECT COUNT(D.MATK) AS COUNT_MATK, "
                    + "'K ' + (CAST(CAST((LEFT(MSSV, 2) AS INTEGER)) - 5) AS VARCHAR) AS COURSE_YEAR "
                    + "FROM DANGKY D, SINHVIEN S "
                    + "D.MATK = S.MATK AND MABD = ? "
                    + "GROUP BY LEFT(MSSV, 2)";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            int index = 0;
            while (rset.next()) {
                int count = rset.getInt("COUNT_MATK");
                String courseYear = rset.getString("COURSE_YEAR");

                chart.addData(new ModelPieChart(courseYear, count, getColor(index++)));

            }

        } catch (SQLException e) {
        }
    }

    //6 khoa 
    public static void getDataForPieChart_FacultyName(PieChart chart, int postID) {
        try {
            conn = getConnection();
            query = "SELECT TENKHOA, COUNT(D.MATK) AS COUNT_MATK "
                    + "FROM DANGKY D, SINHVIEN S "
                    + "D.MATK = S.MATK AND MABD = ? "
                    + "GROUP BY TENKHOA";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            int index = 0;
            while (rset.next()) {
                String tk = rset.getString("TENKHOA");
                int count = rset.getInt("COUNT_MATK");

                chart.addData(new ModelPieChart(tk, count, getColor(index++)));

            }

        } catch (SQLException e) {
        }
    }

    public static Color getColor(int index) {
        Color[] color = new Color[]{
            Color.BLUE,
            Color.DARK_GRAY,
            Color.GRAY,
            Color.GREEN,
            Color.PINK,
            Color.MAGENTA

        };
        return color[index];
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

    public static DetailedOnePost_Model getAllImagesAndUrls(int postID) {
        DetailedOnePost_Model model = new DetailedOnePost_Model();
        List<ImageIcon> imagesList = new ArrayList<>();
        List<String> urlList = new ArrayList<>();

        query = "SELECT ANH, URL "
                + "FROM HINHANH "
                + "WHERE MABD = ?";

        try {
            conn = getConnection();

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();

            while (rset.next()) {

                if (rset.getString("URL") != null) {
                    String url = rset.getString("URL");
                    urlList.add(url);
                }

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
            model.setUrlYT(urlList);

            rset.close();
            p.close();
            conn.close();

        } catch (SQLException e) {
        }
        return model;
    }

    public static boolean updateCountLikeDB(int postId, int newCountLike) {
        try {

            conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement(
                    "UPDATE BAIDANG SET LUOTTHICH = ? WHERE MABD = ?");
            pstm.setInt(1, newCountLike);
            pstm.setInt(2, postId);
            int rowsAffected = pstm.executeUpdate();

            pstm.close();
            conn.close();

            return rowsAffected == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<BriefPost_Model> getPostsInfo_Offset(Pagination p, int page) {

        List<BriefPost_Model> postList = new ArrayList<>();

        try {

            int limit = 1;

            String query1 = "SELECT "
                    + "COUNT(*), BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH "
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
        }
    }

    public static void getRegisterInfo_TableView(JTable table, int postID) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            conn = getConnection();
            query = "SELECT ANHDAIDIEN, HOTEN, USERNAME, EMAIL, MSSV "
                    + "FROM TAIKHOAN T, DANGKY D, SINHVIEN S "
                    + "WHERE T.MATK = D.MATK AND D.MATK = S.MATK "
                    + "AND MABD = ?";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();

            rset = stmt.executeQuery(query);

            HighResolutionResize avatarPanel = new HighResolutionResize();

            while (rset.next()) {
                byte[] imageData = rset.getBytes("ANHDAIDIEN");
                if (imageData != null) {
                    try {
                        //convert the byte array to an Image object
                        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                        BufferedImage bufferedImage = ImageIO.read(inputStream);

                        //create a scaled version of the BufferedImage
                        Image scaledImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

                        //set the Image object as the thumnail
                        ImageIcon thumbnail = new ImageIcon(scaledImage);
                        avatarPanel.setImage(thumbnail);

                    } catch (IOException e) {
                    }
                }

                String fullName = rset.getString("HOTEN");
                String userName = rset.getString("USERNAME");
                String email = rset.getString("EMAIL");

                model.addRow(new Object[]{avatarPanel, fullName, userName, email});

            }

            table.setModel(model);
            conn.close();
            p.close();
            rset.close();
        } catch (SQLException e) {
        }

    }

    public static List<BriefPost_Model> getPostsInfo_ComboBox(List<String> tags) {
        List<BriefPost_Model> models = new ArrayList<>();
        try {
            conn = getConnection();
            StringBuilder queryBuilder = new StringBuilder("SELECT DISTINCT MABD FROM TAGS_BAIDANG WHERE TAG IN (");
            for (int i = 0; i < tags.size(); i++) {
                queryBuilder.append("?");
                if (i < tags.size() - 1) {
                    queryBuilder.append(",");
                }
            }
            queryBuilder.append(")");
            query = queryBuilder.toString();
            PreparedStatement p = conn.prepareStatement(query);

            for (int i = 0; i < tags.size(); i++) {
                p.setString(i + 1, tags.get(i));
            }

            rset = p.executeQuery();
            while (rset.next()) {
                int postID = rset.getInt("MABD");
                models.add(getInfoPost_BaseMethod(postID));
            }

            conn.close();
            rset.close();
            p.close();

        } catch (SQLException e) {
            return new ArrayList<>();
        }
        return models;
    }

    public static List<BriefPost_Model> getPostsInfo_Sort(int type, boolean dueDate, boolean hottest) {
        try {
            conn = getConnection();
            //type = 0: not in a specific type
            //meet 1 requirment once time
            if (type == 0) {
                if (dueDate == true) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH, THOIDIEMDIENRA "
                            + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                            + "WHERE BD.MABD = BD_CT.MABD "
                            + "AND LOAIBD = 2 AND THOIDIEMDIENRA = NGAYHETHAN_DANGKICUOCTHI"
                            + "ORDER BY THOIDIEMDANG DESC";
                } else if (hottest == true) {
                    query = "SELECT "
                            + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH, THOIDIEMDIENRA "
                            + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                            + "WHERE BD.MABD = BD_CT.MABD "
                            + "AND LOAIBD = 2 "
                            + "ORDER BY LUOTTHICH DESC";
                }
            } else if (type == 1 || type == 2) {
                query = "SELECT "
                        + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH, THOIDIEMDIENRA "
                        + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                        + "WHERE BD.MABD = BD_CT.MABD "
                        + "AND LOAIBD = 2 AND HINHTHUCTG = ? "
                        + " ORDER BY THOIDIEMDANG DESC ";
            }

            PreparedStatement p = conn.prepareStatement(query);
            if (type == 1 || type == 2) {
                p.setInt(1, type);
            }
            rset = p.executeQuery();

            List<BriefPost_Model> postList = new ArrayList<>();

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
            //p.close();

            return postList;

        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public static BriefPost_Model getInfoPost_BaseMethod(int postID) {
        BriefPost_Model post = new BriefPost_Model();
        try {
            conn = getConnection();
            query = "SELECT DISTINCT "
                    + "BD.MABD, NOIDUNG, HINHTHUCTG, TIEUDE, THUMBNAIL, DONVITOCHUC, NGAYBD_DANGKICUOCTHI, NGAYHETHAN_DANGKICUOCTHI, THOIDIEMDANG, LUOTTHICH, THOIDIEMDIENRA "
                    + "FROM BAIDANG BD, BAIDANG_CUOCTHI BD_CT "
                    + "WHERE BD.MABD = BD_CT.MABD "
                    + "AND LOAIBD = 2 AND MABD = ? "
                    + " ORDER BY THOIDIEMDANG DESC ";

            PreparedStatement p = conn.prepareStatement(query);
            p.setInt(1, postID);
            rset = p.executeQuery();
            while (rset.next()) {
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
            }

            conn.close();
            rset.close();
            p.close();

        } catch (SQLException e) {
        }
        return post;
    }

    static Connection conn;
    static Statement stmt;
    static ResultSet rset;
    static String query;
}
