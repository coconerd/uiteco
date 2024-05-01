/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostListPanel extends javax.swing.JPanel{
    public PostListPanel(){
        initPostList();
    }
    void initPostList(){
        setSize(1063,650);
        setLayout(new java.awt.GridLayout(0,1));
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String postingDate = currentTime.format(formatter);
        add(new com.forum.PostPanel("Thông báo quy định quản lý spam - ĐỌC KỸ TRƯỚC KHI ĐĂNG BÀI", 0,0, "Phan Thành Công", postingDate));
        add(new com.forum.PostPanel("Hai vây xinh xinh, cá vàng bơi trong bể nước, ngôi lên lặn xuống, cá vàng múa tung tăng", 0,0, "Phan Thành Công", postingDate));   
        add(new com.forum.PostPanel("Các account của trường cấp và cách xử lý một số sự cố", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));   
        add(new com.forum.PostPanel("Quên mật khẩu email trường cấp", 0,0, "Phan Thị Thuỷ Hiền", postingDate));       
        add(new com.forum.PostPanel("Thắc mắc về thời hạn đăng ký gia hạn học phí", 0,0, "Trần Vũ Bão", postingDate));  
        add(new com.forum.PostPanel("Lỗi thay đổi đường dẫn tới trang Facebook cá nhân trong trang Lý lịch sinh viên", 0,0, "Phan Thị Thuỷ Hiền", postingDate));      
        add(new com.forum.PostPanel("Bộ nhớ gg drive của trường bị đầy", 0,0, "Phan Thị Thuỷ Hiền", postingDate));  
        add(new com.forum.PostPanel("Tìm bạn K18 để học chung tiếng Nhật N5 ở trung tâm của trường", 0,0, "Phan Thị Thuỷ Hiền", postingDate));      
        add(new com.forum.PostPanel("[Tân SV UIT khóa 2023] Hướng dẫn xem thời khóa biểu", 0,0, "Phan Thị Thuỷ Hiền", postingDate));       
        add(new com.forum.PostPanel("Vấn Đề Nộp chứng chỉ miễn thi ngoại ngữ", 0,0,"Phan Thị Thuỷ Hiền", postingDate));        
        add(new com.forum.PostPanel("[TUYỂN SINH SĐH] - Thông báo tuyển sinh đợt 1 - 2019", 0,0, "Trần Vũ Bão", postingDate));        
        add(new com.forum.PostPanel("Xin đề thi cuối kì môn đại cương", 0,0, "Trần Vũ Bão", postingDate));
        add(new com.forum.PostPanel("[UIT ALGO BOOTCAMP 2023] Thông báo đăng ký tham gia khóa huấn luyện Tư duy lập trình - Thuật toán", 0,0, "Trần Vũ Bão", postingDate));
        add(new com.forum.PostPanel("Chia sẻ sách học lập trình Game Unity, HTML5, JS, Python, PHP, SQL, C++,...", 0,0, "Trần Vũ Bão", postingDate));
        add(new com.forum.PostPanel("Tìm kiếm cơ hội kết nối các anh chị để trao đổi kiến thức, kinh nghiệm, trải nghiệm về ngành Thương mại điện tử", 0,0, "Trần Vũ Bão", postingDate));
        add(new com.forum.PostPanel("Tuyển 1 bạn sinh viên năm 1 hoặc năm 2 làm Dev-Assitant", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));
        add(new com.forum.PostPanel("Nhờ SV thực hiện khảo sát cho đề tài NCKH về xu hướng đào tạo trực tuyến", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));
        add(new com.forum.PostPanel("[Q2,Q3] Golden Owl Solutions Tuyển dụng Thực Tập Sinh IT T4/2024 (đợt 2)", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));
        add(new com.forum.PostPanel("[Online] Sự kiện nhân Ngày Quốc tế Toán học với chủ đề “Playing With Math”: Hình học , IMO và AI", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));
        add(new com.forum.PostPanel("Share phòng chung cư Bcons miền đông", 0,0, "Nguyễn Đỗ Đức Minh", postingDate));

   }
}
