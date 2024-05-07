/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
import com.forum.PostPanel;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class PostListPanel extends javax.swing.JPanel{
    private  ArrayList<PostPanel> listPost;
    private  int currentPage = 0;
    private  int totalPages; // = (int) Math.ceil((double) listPost.size() / 20); //mỗi trang chỉ hiển thị 20 bài đăng, còn lại được hiển thị ở các trang tiếp theo
    
    public  void setCurrentPage(int newPage){
        currentPage = newPage;
    }
    public  void setTotalPages(int number){
        totalPages = number;
    }
    public  void setListPost(ArrayList<PostPanel> postList){
        listPost = postList;
    }
    public  void updateTotalPages(){
        totalPages = (int) Math.ceil((double) listPost.size() / 20);
    }
    public  int getCurrentPage(){
        return currentPage;
    }
    public  int getTotalPages(){
        return totalPages;
    }
    public  ArrayList<PostPanel> getListPost(){
        return listPost;
    }
    public  void switchPage(int page){
    /*ví dụ: khi người dùng muốn di chuyển đến trang 1 thì dùng hàm switchPage này để thay đổi currentPage, do ta lưu currentPage bắt đầu từ 0
    nên tham số page truyền vào phải trừ đi 1 thì mới đúng bằng giá trị currentPage ta lưu cho trang đó*/
        int mapping = page-1;
        if(mapping != currentPage && mapping >= 0 && mapping < totalPages){
            currentPage = mapping;
        }
    }
    public  void setCurrentPageToNext(){
        if(currentPage < getTotalPages()-1){
            currentPage = currentPage+1;
        }
    }
    public  void setCurrentPageToBack(){
        if(currentPage > 0){
            currentPage = currentPage-1;
        }
    }
    public PostListPanel(){
        initPostList();
        updateShowPagination();
    }
    public  void loadPostForumFromDatabaseIntoListPost(){
        //truy vấn bảng bài đăng forum từ csdl vào listPost
    }
//    public  void addPostIntoPostListWhenClickPostingButton(PostPanel post){
//        listPost.add(post);
//        updateTotalPages();
//    }
    public  void updateShowPagination(){
         // Hiển thị các bài đăng khi vào giao diện chính của forum
        int startIndex = currentPage * 20;
        int endIndex = Math.min((currentPage + 1) * 20, listPost.size());
        removeAll(); // Xóa tất cả các panelSub hiện tại khỏi panelMain
        for (int i = startIndex; i < endIndex; i++) {
            add(listPost.get(i)); 
        }
         // Cập nhật giao diện
        revalidate();
        repaint();
    }
    
    
    void initPostList(){
        setSize(1063,650);
        setLayout(new java.awt.GridLayout(0,1));
        LocalDateTime currentTime = LocalDateTime.now();
        //<insert here>loadPostForumFromDatabaseIntoListPost function
        listPost = new ArrayList<PostPanel>();
        listPost.add(new PostPanel(1,"Thông báo quy định quản lý spam - ĐỌC KỸ TRƯỚC KHI ĐĂNG BÀI", 0,0, "Phan Thành Công", currentTime, "demo"));
        listPost.add(new PostPanel(2,"Hai vây xinh xinh, cá vàng bơi trong bể nước, ngôi lên lặn xuống, cá vàng múa tung tăng", 0,0, "Phan Thành Công", currentTime, "demo"));   
        listPost.add(new PostPanel(3,"Các account của trường cấp và cách xử lý một số sự cố", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));   
        listPost.add(new PostPanel(4,"Quên mật khẩu email trường cấp", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));       
        listPost.add(new PostPanel(5,"Thắc mắc về thời hạn đăng ký gia hạn học phí", 0,0, "Trần Vũ Bão", currentTime, "demo"));  
        listPost.add(new PostPanel(6,"Lỗi thay đổi đường dẫn tới trang Facebook cá nhân trong trang Lý lịch sinh viên", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));      
        listPost.add(new PostPanel(7,"Bộ nhớ gg drive của trường bị đầy", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));  
        listPost.add(new PostPanel(8,"Tìm bạn K18 để học chung tiếng Nhật N5 ở trung tâm của trường", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));      
        listPost.add(new PostPanel(9,"[Tân SV UIT khóa 2023] Hướng dẫn xem thời khóa biểu", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));       
        listPost.add(new PostPanel(10,"Vấn Đề Nộp chứng chỉ miễn thi ngoại ngữ", 0,0,"Phan Thị Thuỷ Hiền", currentTime, "demo"));        
        listPost.add(new PostPanel(11,"[TUYỂN SINH SĐH] - Thông báo tuyển sinh đợt 1 - 2019", 0,0, "Trần Vũ Bão", currentTime, "demo"));        
        listPost.add(new PostPanel(12,"Xin đề thi cuối kì môn đại cương", 0,0, "Trần Vũ Bão", currentTime, "demo"));
        listPost.add(new PostPanel(13,"[UIT ALGO BOOTCAMP 2023] Thông báo đăng ký tham gia khóa huấn luyện Tư duy lập trình - Thuật toán", 0,0, "Trần Vũ Bão", currentTime, "demo"));
        listPost.add(new PostPanel(14,"Chia sẻ sách học lập trình Game Unity, HTML5, JS, Python, PHP, SQL, C++,...", 0,0, "Trần Vũ Bão", currentTime, "demo"));
        listPost.add(new PostPanel(15,"Tìm kiếm cơ hội kết nối các anh chị để trao đổi kiến thức, kinh nghiệm, trải nghiệm về ngành Thương mại điện tử", 0,0, "Trần Vũ Bão", currentTime, "demo"));
        listPost.add(new PostPanel(16,"Tuyển 1 bạn sinh viên năm 1 hoặc năm 2 làm Dev-Assitant", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));
        listPost.add(new PostPanel(17,"Nhờ SV thực hiện khảo sát cho đề tài NCKH về xu hướng đào tạo trực tuyến", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));
        listPost.add(new PostPanel(18,"[Q2,Q3] Golden Owl Solutions Tuyển dụng Thực Tập Sinh IT T4/2024 (đợt 2)", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));
        listPost.add(new PostPanel(19,"[Online] Sự kiện nhân Ngày Quốc tế Toán học với chủ đề “Playing With Math”: Hình học , IMO và AI", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));
        listPost.add(new PostPanel(20,"Share phòng chung cư Bcons miền đông", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));
        listPost.add(new PostPanel(21,"1Thông báo quy định quản lý spam - ĐỌC KỸ TRƯỚC KHI ĐĂNG BÀI", 0,0, "Phan Thành Công", currentTime, "demo"));
        listPost.add(new PostPanel(22,"2Hai vây xinh xinh, cá vàng bơi trong bể nước, ngôi lên lặn xuống, cá vàng múa tung tăng", 0,0, "Phan Thành Công", currentTime, "demo"));   
        listPost.add(new PostPanel(23,"3Các account của trường cấp và cách xử lý một số sự cố", 0,0, "Nguyễn Đỗ Đức Minh", currentTime, "demo"));   
        listPost.add(new PostPanel(24,"4Quên mật khẩu email trường cấp", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));       
        listPost.add(new PostPanel(25,"5Thắc mắc về thời hạn đăng ký gia hạn học phí", 0,0, "Trần Vũ Bão", currentTime, "demo"));  
        listPost.add(new PostPanel(26,"6Lỗi thay đổi đường dẫn tới trang Facebook cá nhân trong trang Lý lịch sinh viên", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo"));      
        listPost.add(new PostPanel(27,"7Bộ nhớ gg drive của trường bị đầy", 0,0, "Phan Thị Thuỷ Hiền", currentTime, "demo")); 
//          // Hiển thị các bài đăng khi vào giao diện chính của forum
//        int startIndex = currentPage * 20;
//        int endIndex = Math.min((currentPage + 1) * 20, listPost.size());
//        removeAll(); // Xóa tất cả các panelSub hiện tại khỏi panelMain
//        for (int i = startIndex; i < endIndex; i++) {
//            add(listPost.get(i)); 
//        }
//         // Cập nhật giao diện
//        revalidate();
//        repaint();
//          updateTotalPages();
//          updateShowPagination();
//        listPost.add(new com.forum.PostPanel("Thông báo quy định quản lý spam - ĐỌC KỸ TRƯỚC KHI ĐĂNG BÀI", 0,0, "Phan Thành Công", currentTime));
//        listPost.add(new com.forum.PostPanel("Hai vây xinh xinh, cá vàng bơi trong bể nước, ngôi lên lặn xuống, cá vàng múa tung tăng", 0,0, "Phan Thành Công", currentTime));   
//        listPost.add(new com.forum.PostPanel("Các account của trường cấp và cách xử lý một số sự cố", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));   
//        listPost.add(new com.forum.PostPanel("Quên mật khẩu email trường cấp", 0,0, "Phan Thị Thuỷ Hiền", currentTime));       
//        listPost.add(new com.forum.PostPanel("Thắc mắc về thời hạn đăng ký gia hạn học phí", 0,0, "Trần Vũ Bão", currentTime));  
//        listPost.add(new com.forum.PostPanel("Lỗi thay đổi đường dẫn tới trang Facebook cá nhân trong trang Lý lịch sinh viên", 0,0, "Phan Thị Thuỷ Hiền", currentTime));      
//        listPost.add(new com.forum.PostPanel("Bộ nhớ gg drive của trường bị đầy", 0,0, "Phan Thị Thuỷ Hiền", currentTime));  
//        listPost.add(new com.forum.PostPanel("Tìm bạn K18 để học chung tiếng Nhật N5 ở trung tâm của trường", 0,0, "Phan Thị Thuỷ Hiền", currentTime));      
//        listPost.add(new com.forum.PostPanel("[Tân SV UIT khóa 2023] Hướng dẫn xem thời khóa biểu", 0,0, "Phan Thị Thuỷ Hiền", currentTime));       
//        listPost.add(new com.forum.PostPanel("Vấn Đề Nộp chứng chỉ miễn thi ngoại ngữ", 0,0,"Phan Thị Thuỷ Hiền", currentTime));        
//        listPost.add(new com.forum.PostPanel("[TUYỂN SINH SĐH] - Thông báo tuyển sinh đợt 1 - 2019", 0,0, "Trần Vũ Bão", currentTime));        
//        listPost.add(new com.forum.PostPanel("Xin đề thi cuối kì môn đại cương", 0,0, "Trần Vũ Bão", currentTime));
//        listPost.add(new com.forum.PostPanel("[UIT ALGO BOOTCAMP 2023] Thông báo đăng ký tham gia khóa huấn luyện Tư duy lập trình - Thuật toán", 0,0, "Trần Vũ Bão", currentTime));
//        listPost.add(new com.forum.PostPanel("Chia sẻ sách học lập trình Game Unity, HTML5, JS, Python, PHP, SQL, C++,...", 0,0, "Trần Vũ Bão", currentTime));
//        listPost.add(new com.forum.PostPanel("Tìm kiếm cơ hội kết nối các anh chị để trao đổi kiến thức, kinh nghiệm, trải nghiệm về ngành Thương mại điện tử", 0,0, "Trần Vũ Bão", currentTime));
//        listPost.add(new com.forum.PostPanel("Tuyển 1 bạn sinh viên năm 1 hoặc năm 2 làm Dev-Assitant", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));
//        listPost.add(new com.forum.PostPanel("Nhờ SV thực hiện khảo sát cho đề tài NCKH về xu hướng đào tạo trực tuyến", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));
//        listPost.add(new com.forum.PostPanel("[Q2,Q3] Golden Owl Solutions Tuyển dụng Thực Tập Sinh IT T4/2024 (đợt 2)", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));
//        listPost.add(new com.forum.PostPanel("[Online] Sự kiện nhân Ngày Quốc tế Toán học với chủ đề “Playing With Math”: Hình học , IMO và AI", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));
//        listPost.add(new com.forum.PostPanel("Share phòng chung cư Bcons miền đông", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));
//        listPost.add(new com.forum.PostPanel("1Thông báo quy định quản lý spam - ĐỌC KỸ TRƯỚC KHI ĐĂNG BÀI", 0,0, "Phan Thành Công", currentTime));
//        listPost.add(new com.forum.PostPanel("2Hai vây xinh xinh, cá vàng bơi trong bể nước, ngôi lên lặn xuống, cá vàng múa tung tăng", 0,0, "Phan Thành Công", currentTime));   
//        listPost.add(new com.forum.PostPanel("3Các account của trường cấp và cách xử lý một số sự cố", 0,0, "Nguyễn Đỗ Đức Minh", currentTime));   
//        listPost.add(new com.forum.PostPanel("4Quên mật khẩu email trường cấp", 0,0, "Phan Thị Thuỷ Hiền", currentTime));       
//        listPost.add(new com.forum.PostPanel("5Thắc mắc về thời hạn đăng ký gia hạn học phí", 0,0, "Trần Vũ Bão", currentTime));  
//        listPost.add(new com.forum.PostPanel("6Lỗi thay đổi đường dẫn tới trang Facebook cá nhân trong trang Lý lịch sinh viên", 0,0, "Phan Thị Thuỷ Hiền", currentTime));      
//        listPost.add(new com.forum.PostPanel("7Bộ nhớ gg drive của trường bị đầy", 0,0, "Phan Thị Thuỷ Hiền", currentTime)); 

   }
}
