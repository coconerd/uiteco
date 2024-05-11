package com.uiteco.mockData;
import com.uiteco.database.ConnectionManager;
import static com.uiteco.database.TestAuth.deriveKey;
import static com.uiteco.database.TestAuth.genSalt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class GenerateAndInsertMockData {
    
    private GenerateAndInsertMockData() {
        
    }
    
    public static void insertUserData(String hoten, String email, String username, LocalDate ngaytao, String phonenumber, String password, int accountType){
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
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertAccountData(){
        insertUserData("Phan Thị Thủy Hiền", "thuyhienphanthi2004@uit.edu.vn", "hienphann", LocalDate.now(), "0971238000","0106", 1);
        insertUserData("Nguyên Đô Đức Minh", "minhduc@uit.edu.vn", "ducminh", LocalDate.now(), "0971238001", "0806", 1);
        insertUserData("Trần Vũ Bão", "vubao@uit.edu.vn", "vstorm", LocalDate.now(), "0971238002", "0001", 1);
        insertUserData("Phan Thành Công", "congphan@uit.edu.vn", "congphan", LocalDate.now(), "0971238003", "0002", 1);
        
        insertUserData("Nguyễn Văn An", "annguyenvan2004@uit.edu.vn", "annguyenvan", LocalDate.now(), "0971238226", "0103", 3);
        insertUserData("Trần Thị Bình", "binhtranthi2004@uit.edu.vn", "binhtranthi", LocalDate.now(), "0971238227", "0104", 4);
        insertUserData("Lê Văn Cường", "cuonglevan2004@uit.edu.vn", "cuonglevan", LocalDate.now(), "0971238228", "0102", 2);
        insertUserData("Hồ Thị Dung", "dunghothi2004@uit.edu.vn", "dunghothi", LocalDate.now(), "0971238229", "0103", 3);
        insertUserData("Phạm Văn Eo", "eophamvan2004@uit.edu.vn", "eophamvan", LocalDate.now(), "0971238230", "0104", 4);
        insertUserData("Vũ Thị Phương", "phuongvuthi2004@uit.edu.vn", "phuongvuthi", LocalDate.now(), "0971238231", "0102", 2);
        insertUserData("Nguyễn Văn Giang", "giangnguyenvan2004@uit.edu.vn", "giangnguyenvan", LocalDate.now(), "0971238232", "0103", 3);
        insertUserData("Trần Thị Hà", "hatranthi2004@uit.edu.vn", "hatranthi", LocalDate.now(), "0971238233", "0104", 4);
        insertUserData("Lê Văn I", "ilevan2004@uit.edu.vn", "ilevan", LocalDate.now(), "0971238234", "0102", 2);
        insertUserData("Hoàng Thị Thúy", "thuyhoangthi2004@uit.edu.vn", "thuyhoangthi", LocalDate.now(), "0971238235", "0103", 3);
        insertUserData("Phạm Văn Kha", "khaphamvan2004@uit.edu.vn", "khaphamvan", LocalDate.now(), "0971238236", "0104", 4);
        insertUserData("Lê Thị Lâm", "lamlethi2004@uit.edu.vn", "lamlethi", LocalDate.now(), "0971238237", "0102", 2);
        insertUserData("Nguyễn Văn Mạnh", "manhnguyenvan2004@uit.edu.vn", "manhnguyenvan", LocalDate.now(), "0971238238", "0103", 3);
        insertUserData("Trần Thị Nga", "ngatranthi2004@uit.edu.vn", "ngatranthi", LocalDate.now(), "0971238239", "0104", 4);
        insertUserData("Lê Văn Oanh", "oanhlevan2004@uit.edu.vn", "oanhlevan", LocalDate.now(), "0971238240", "0102", 2);
        insertUserData("Hoàng Thị Phương", "phuonghoangthi2004@uit.edu.vn", "phuonghoangthi", LocalDate.now(), "0971238241", "0103", 3);
        insertUserData("Phạm Văn Quân", "quanphamvan2004@uit.edu.vn", "quanphamvan", LocalDate.now(), "0971238242", "0104", 4);
        insertUserData("Lê Thị Rồng", "ronglethi2004@uit.edu.vn", "ronglethi", LocalDate.now(), "0971238243", "0102", 2);
        insertUserData("Nguyễn Văn Sơn", "sonnguyenvan2004@uit.edu.vn", "sonnguyenvan", LocalDate.now(), "0971238244", "0103", 3);
        insertUserData("Hồ Văn Thanh", "thanhvoho2004@uit.edu.vn", "thanhvoho", LocalDate.now(), "0971238246", "0104", 4);
        insertUserData("Võ Thị Uyên", "uyenvothi2004@uit.edu.vn", "uyenvothi", LocalDate.now(), "0971238247", "0102", 2);
        insertUserData("Nguyễn Văn Vượng", "vuongnguyenvan2004@uit.edu.vn", "vuongnguyenvan", LocalDate.now(), "0971238248", "0103", 3);
        insertUserData("Trần Thị Xinh", "xinhtranthi2004@uit.edu.vn", "xinhtranthi", LocalDate.now(), "0971238249", "0104", 4);
        insertUserData("Lê Văn Y", "ylevan2004@uit.edu.vn", "ylevan", LocalDate.now(), "0971238250", "0102", 2);
        insertUserData("Hoàng Thị Z", "zhoangthi2004@uit.edu.vn", "zhoangthi", LocalDate.now(), "0971238251", "0103", 3);
        insertUserData("Phạm Thị An", "anphamthi2004@uit.edu.vn", "anphamthi", LocalDate.now(), "0971238252", "0104", 4);
        insertUserData("Đặng Văn Bình", "binhdangvan2004@uit.edu.vn", "binhdangvan", LocalDate.now(), "0971238253", "0102", 2);
        insertUserData("Mai Thị Cường", "cuongmaithi2004@uit.edu.vn", "cuongmaithi", LocalDate.now(), "0971238254", "0103", 3);
        insertUserData("Lý Văn Đạo", "daolyvan2004@uit.edu.vn", "daolyvan", LocalDate.now(), "0971238255", "0104", 4);
        insertUserData("Trương Thị Em", "emtruongthi2004@uit.edu.vn", "emtruongthi", LocalDate.now(), "0971238256", "0102", 2);
        insertUserData("Ngô Văn Gia", "giango2004@uit.edu.vn", "giango", LocalDate.now(), "0971238257", "0103", 3);
        insertUserData("Vũ Thị Hạnh", "hanhvuthi2004@uit.edu.vn", "hanhvuthi", LocalDate.now(), "0971238258", "0104", 4);
        insertUserData("Lê Văn Hùng", "hungle2004@uit.edu.vn", "hungle", LocalDate.now(), "0971238259", "0102", 2);
        insertUserData("Trần Thị Khánh", "khanhtranthi2004@uit.edu.vn", "khanhtranthi", LocalDate.now(), "0971238260", "0103", 3);
        insertUserData("Phạm Văn Lâm", "lamphamvan2004@uit.edu.vn", "lamphamvan", LocalDate.now(), "0971238261", "0104", 4);
    }
}
