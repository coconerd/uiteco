/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
//import com.raven.scroll.ScrollPaneWin11;
/**
 *
 * @author 21H1 HNQA
 */
public class PostListPanel extends javax.swing.JPanel{
    public PostListPanel(){
        initPostList();
    }
    void initPostList(){
        setSize(1063,650);
        //setBackground(new java.awt.Color(246, 243, 243));
        //setLayout(new javax.swing.BoxLayout(postListPanel_, javax.swing.BoxLayout.Y_AXIS));
        setLayout(new java.awt.GridLayout(0,1));
//        setLayout(new java.awt.GridBagLayout(0,1));
        add(new com.forum.PostPanel("bài đăng 1 haha hah aa aa aa aaa aa aa aaa aaa aaa a aaa aa aaaa a aa aa aa aaa aab bbb bbbb bbb bbb bbbb bbb bbbbb bbbb bb bbbb bbb bbbb bbb bbb bb bbb bbb bbb bb", 0,0, "Phan Thành Công"));
        add(new com.forum.PostPanel("bài đăng 2", 0,0, "Phan Thành Công"));   
        add(new com.forum.PostPanel("bài đăng 3", 0,0, "Phan Thành Công"));   
        add(new com.forum.PostPanel("bài đăng 4", 0,0, "Phan Thành Công"));       
        add(new com.forum.PostPanel("bài đăng 5", 0,0, "Phan Thành Công"));  
        add(new com.forum.PostPanel("bài đăng 6", 0,0, "Phan Thị Thuỷ Hiền"));      
        add(new com.forum.PostPanel("bài đăng 7", 0,0, "Phan Thị Thuỷ Hiền"));  
        add(new com.forum.PostPanel("bài đăng 8", 0,0, "Phan Thị Thuỷ Hiền"));      
        add(new com.forum.PostPanel("bài đăng 9", 0,0, "Phan Thị Thuỷ Hiền"));       
        add(new com.forum.PostPanel("bài đăng 10", 0,0,"Phan Thị Thuỷ Hiền"));        
        add(new com.forum.PostPanel("bài đăng 11", 0,0, "Trần Vũ Bão"));        
        add(new com.forum.PostPanel("bài đăng 12", 0,0, "Trần Vũ Bão"));
        add(new com.forum.PostPanel("bài đăng 13", 0,0, "Trần Vũ Bão"));
        add(new com.forum.PostPanel("bài đăng 14", 0,0, "Trần Vũ Bão"));
        add(new com.forum.PostPanel("bài đăng 15", 0,0, "Trần Vũ Bão"));
        add(new com.forum.PostPanel("bài đăng 16", 0,0, "Nguyễn Đỗ Đức Minh"));
        add(new com.forum.PostPanel("bài đăng 17", 0,0, "Nguyễn Đỗ Đức Minh"));
        add(new com.forum.PostPanel("bài đăng 18", 0,0, "Nguyễn Đỗ Đức Minh"));
        add(new com.forum.PostPanel("bài đăng 19", 0,0, "Nguyễn Đỗ Đức Minh"));
        add(new com.forum.PostPanel("bài đăng 20", 0,0, "Nguyễn Đỗ Đức Minh"));

        /*this panel contains nextButton and backButton*/
//        tailerPanel = new javax.swing.JPanel();
//        tailerPanel.setBackground(new java.awt.Color(255,255,51));
//        tailerPanel.setMaximumSize(new java.awt.Dimension(1060, 20));
//        
//        nextButton = new javax.swing.JButton();
//        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
//        nextButton.setText("Next");
////        nextButton.setSize(87, 32);
//        nextButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
//
//        
//        backButton = new javax.swing.JButton();
//        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
//        backButton.setText("Back");
////        backButton.setSize(87,32);
//        backButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
//        tailerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
//        tailerPanel.add(backButton);
//        tailerPanel.add(nextButton); 
//        add(tailerPanel);
   }
//    private javax.swing.JPanel tailerPanel;
//    private javax.swing.JButton nextButton;
//    private javax.swing.JButton backButton;
}
