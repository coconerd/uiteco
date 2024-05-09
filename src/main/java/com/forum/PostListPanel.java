/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
import java.util.ArrayList;
import com.forum.database.BaiDangForumDAO;
import java.util.Collections;
import java.util.Comparator;

public class PostListPanel extends javax.swing.JPanel{
    private  ArrayList<PostPanel> listPost;
    private  int currentPage;
    private  int totalPages; 
    
    public PostListPanel(){
        initPostList();
        updateTotalPages(); 
        updateShowPagination();
    }
    public  void setCurrentPage(int newPage){
        currentPage = newPage;
    }
    public  void setTotalPages(int number){
        totalPages = number;
    }
    public void setListPost(ArrayList<PostPanel> postList){
        listPost = postList;
    }
    public void updateTotalPages(){
        totalPages = (int) Math.ceil((double) listPost.size() / 20);
    }
    public int getCurrentPage(){
        return currentPage;
    }
    public int getTotalPages(){
        return totalPages;
    }
    public ArrayList<PostPanel> getListPost(){
        return listPost;
    }
    public void switchPage(int page){
    /*ví dụ: khi người dùng muốn di chuyển đến trang 1 thì dùng hàm switchPage này để thay đổi currentPage, do ta lưu currentPage bắt đầu từ 0
    nên tham số page truyền vào phải trừ đi 1 thì mới đúng bằng giá trị currentPage ta lưu cho trang đó*/
        int mapping = page-1;
        if(mapping != currentPage && mapping >= 0 && mapping < totalPages){
            currentPage = mapping;
        }
    }
    public void setCurrentPageToNext(){
        if(currentPage < getTotalPages()-1){
            currentPage = currentPage+1;
            updateShowPagination();
        }
    }
    public void setCurrentPageToBack(){
        if(currentPage > 0){
            currentPage = currentPage-1;
            updateShowPagination();
        }
    }
    public void loadPostForumFromDatabaseIntoListPost(){
        setListPost(BaiDangForumDAO.loadAndSortListPostFromDatabase());
        updateTotalPages(); 
        updateShowPagination();
    }
    public void updateShowPagination(){
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
    public void sortNewestPost(){
        /*hàm này nhằm load các bài đăng từ bảng BAIDANGFORUM rồi tiến hành sắp xếp theo thứ tự bài đăng mới đăng gần đây nhất, 
        mà không cần dùng ORDER BY khi thực hiện câu select bảng BAIDANGFORUM từ csdl
        */
        setListPost(BaiDangForumDAO.loadListPostWithoutSorting());
        Collections.sort(listPost, new Comparator<PostPanel>(){
        @Override
            public int compare(PostPanel p1, PostPanel p2) {
                return p2.getPostingDate().compareTo(p1.getPostingDate()); // Sắp xếp giảm dần
            }
        });
        updateTotalPages();
        updateShowPagination();
    }
    
    void initPostList(){
        setSize(1063,650);
        setLayout(new java.awt.GridLayout(0,1));
        listPost = new ArrayList<PostPanel>();
        listPost = BaiDangForumDAO.loadAndSortListPostFromDatabase();

   }
}
