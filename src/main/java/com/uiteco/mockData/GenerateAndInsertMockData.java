package com.uiteco.mockData;
import com.uiteco.database.ConnectionManager;
import static com.uiteco.database.TestAuth.deriveKey;
import static com.uiteco.database.TestAuth.genSalt;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GenerateAndInsertMockData {
    
    private GenerateAndInsertMockData() {
        
    }
    
    public static void generateUserData(String hoten, String email, String username, LocalDate ngaytao, String phonenumber, String password, int accountType){
        try {
            Connection conn = ConnectionManager.getConnection();
            byte[] salt = genSalt();
            byte[] passwordHash = deriveKey(password, salt);

            String sql = "INSERT INTO TAIKHOAN (HOTEN, EMAIL, USERNAME, NGAYTAO, SDT, MATKHAU, PBKDF2_SALT, LOAITK) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlNgayTao = java.sql.Date.valueOf(ngaytao);
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hoten);
            statement.setString(2, email);
            statement.setString(3, username);
            statement.setDate(4, sqlNgayTao);
            statement.setString(5, phonenumber);
            statement.setBytes(6, passwordHash);
            statement.setBytes(7, salt);
            statement.setInt(8, accountType);
            
            statement.executeUpdate();
            conn.close();
            
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
        }
    }
    
    public static void insertAccountData(){
        generateUserData("Phan Thị Thủy Hiền", "thuyhienphanthi2004@uit.edu.vn", "hienphann", LocalDate.now(), "0971238000","01062004", 1);
//        generateUserData("Nguyên Đô Đức Minh", "minhduc@uit.edu.vn", "ducminh", LocalDate.now(), "0971238001", "08061011", 1);
//        generateUserData("Trần Vũ Bão", "vubao@uit.edu.vn", "vstorm", LocalDate.now(), "0971238002", "00011214", 1);
//        generateUserData("Phan Thành Công", "congphan@uit.edu.vn", "congphan", LocalDate.now(), "0971238003", "00021234", 1);
//        
//        generateUserData("Nguyễn Văn An", "annguyenvan2004@uit.edu.vn", "annguyenvan", LocalDate.now(), "0971238226", "0103", 3);
//        generateUserData("Trần Thị Bình", "binhtranthi2004@uit.edu.vn", "binhtranthi", LocalDate.now(), "0971238227", "0104", 4);
//        generateUserData("Lê Văn Cường", "cuonglevan2004@uit.edu.vn", "cuonglevan", LocalDate.now(), "0971238228", "0102", 2);
//        generateUserData("Hồ Thị Dung", "dunghothi2004@uit.edu.vn", "dunghothi", LocalDate.now(), "0971238229", "0103", 3);
//        generateUserData("Phạm Văn Eo", "eophamvan2004@uit.edu.vn", "eophamvan", LocalDate.now(), "0971238230", "0104", 4);
//        generateUserData("Vũ Thị Phương", "phuongvuthi2004@uit.edu.vn", "phuongvuthi", LocalDate.now(), "0971238231", "0102", 2);
//        generateUserData("Nguyễn Văn Giang", "giangnguyenvan2004@uit.edu.vn", "giangnguyenvan", LocalDate.now(), "0971238232", "0103", 3);
//        generateUserData("Trần Thị Hà", "hatranthi2004@uit.edu.vn", "hatranthi", LocalDate.now(), "0971238233", "0104", 4);
//        generateUserData("Lê Văn I", "ilevan2004@uit.edu.vn", "ilevan", LocalDate.now(), "0971238234", "0102", 2);
//        generateUserData("Hoàng Thị Thúy", "thuyhoangthi2004@uit.edu.vn", "thuyhoangthi", LocalDate.now(), "0971238235", "0103", 3);
//        generateUserData("Phạm Văn Kha", "khaphamvan2004@uit.edu.vn", "khaphamvan", LocalDate.now(), "0971238236", "0104", 4);
//        generateUserData("Lê Thị Lâm", "lamlethi2004@uit.edu.vn", "lamlethi", LocalDate.now(), "0971238237", "0102", 2);
//        generateUserData("Nguyễn Văn Mạnh", "manhnguyenvan2004@uit.edu.vn", "manhnguyenvan", LocalDate.now(), "0971238238", "0103", 3);
//        generateUserData("Trần Thị Nga", "ngatranthi2004@uit.edu.vn", "ngatranthi", LocalDate.now(), "0971238239", "0104", 4);
//        generateUserData("Lê Văn Oanh", "oanhlevan2004@uit.edu.vn", "oanhlevan", LocalDate.now(), "0971238240", "0102", 2);
//        generateUserData("Hoàng Thị Phương", "phuonghoangthi2004@uit.edu.vn", "phuonghoangthi", LocalDate.now(), "0971238241", "0103", 3);
//        generateUserData("Phạm Văn Quân", "quanphamvan2004@uit.edu.vn", "quanphamvan", LocalDate.now(), "0971238242", "0104", 4);
//        generateUserData("Lê Thị Rồng", "ronglethi2004@uit.edu.vn", "ronglethi", LocalDate.now(), "0971238243", "0102", 2);
//        generateUserData("Nguyễn Văn Sơn", "sonnguyenvan2004@uit.edu.vn", "sonnguyenvan", LocalDate.now(), "0971238244", "0103", 3);
//        generateUserData("Hồ Văn Thanh", "thanhvoho2004@uit.edu.vn", "thanhvoho", LocalDate.now(), "0971238246", "0104", 4);
//        generateUserData("Võ Thị Uyên", "uyenvothi2004@uit.edu.vn", "uyenvothi", LocalDate.now(), "0971238247", "0102", 2);
//        generateUserData("Nguyễn Văn Vượng", "vuongnguyenvan2004@uit.edu.vn", "vuongnguyenvan", LocalDate.now(), "0971238248", "0103", 3);
//        generateUserData("Trần Thị Xinh", "xinhtranthi2004@uit.edu.vn", "xinhtranthi", LocalDate.now(), "0971238249", "0104", 4);
//        generateUserData("Lê Văn Y", "ylevan2004@uit.edu.vn", "ylevan", LocalDate.now(), "0971238250", "0102", 2);
//        generateUserData("Hoàng Thị Z", "zhoangthi2004@uit.edu.vn", "zhoangthi", LocalDate.now(), "0971238251", "0103", 3);
//        generateUserData("Phạm Thị An", "anphamthi2004@uit.edu.vn", "anphamthi", LocalDate.now(), "0971238252", "0104", 4);
//        generateUserData("Đặng Văn Bình", "binhdangvan2004@uit.edu.vn", "binhdangvan", LocalDate.now(), "0971238253", "0102", 2);
//        generateUserData("Mai Thị Cường", "cuongmaithi2004@uit.edu.vn", "cuongmaithi", LocalDate.now(), "0971238254", "0103", 3);
//        generateUserData("Lý Văn Đạo", "daolyvan2004@uit.edu.vn", "daolyvan", LocalDate.now(), "0971238255", "0104", 4);
//        generateUserData("Trương Thị Em", "emtruongthi2004@uit.edu.vn", "emtruongthi", LocalDate.now(), "0971238256", "0102", 2);
//        generateUserData("Ngô Văn Gia", "giango2004@uit.edu.vn", "giango", LocalDate.now(), "0971238257", "0103", 3);
//        generateUserData("Vũ Thị Hạnh", "hanhvuthi2004@uit.edu.vn", "hanhvuthi", LocalDate.now(), "0971238258", "0104", 4);
//        generateUserData("Lê Văn Hùng", "hungle2004@uit.edu.vn", "hungle", LocalDate.now(), "0971238259", "0102", 2);
//        generateUserData("Trần Thị Khánh", "khanhtranthi2004@uit.edu.vn", "khanhtranthi", LocalDate.now(), "0971238260", "0103", 3);
//        generateUserData("Phạm Văn Lâm", "lamphamvan2004@uit.edu.vn", "lamphamvan", LocalDate.now(), "0971238261", "0104", 4);
    }
    
//    public void insertThumbnailCuocThi(){
//        try{
//            conn = getConnection();
//            String sql = "INSERT INTO BAIDANG(LOAIBD, )"
//            PreparedStatement ps = conn.prepareStatement(sql)
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        
//    }
}
