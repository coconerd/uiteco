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
        setSize(1060,650);
        //setBackground(new java.awt.Color(246, 243, 243));
        //setLayout(new javax.swing.BoxLayout(postListPanel_, javax.swing.BoxLayout.Y_AXIS));
        setLayout(new java.awt.GridLayout(0,1));
//        setLayout(new java.awt.GridBagLayout(0,1));
        add(new com.forum.PostPanel("bài đăng 1", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 2", 100, "congphan"));   
        add(new com.forum.PostPanel("bài đăng 3", 100, "congphan"));   
        add(new com.forum.PostPanel("bài đăng 4", 100, "congphan"));       
        add(new com.forum.PostPanel("bài đăng 5", 100, "congphan"));  
        add(new com.forum.PostPanel("bài đăng 6", 100, "congphan"));      
        add(new com.forum.PostPanel("bài đăng 7", 100, "congphan"));  
        add(new com.forum.PostPanel("bài đăng 8", 100, "congphan"));      
        add(new com.forum.PostPanel("bài đăng 9", 100, "congphan"));       
        add(new com.forum.PostPanel("bài đăng 10", 100, "congphan"));        
        add(new com.forum.PostPanel("bài đăng 11", 100, "congphan"));        
        add(new com.forum.PostPanel("bài đăng 12", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 13", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 14", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 15", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 16", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 17", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 18", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 19", 100, "congphan"));
        add(new com.forum.PostPanel("bài đăng 20", 100, "congphan"));

        /*this panel contains nextButton and backButton*/
        tailerPanel = new javax.swing.JPanel();
        tailerPanel.setBackground(new java.awt.Color(255,255,51));
        tailerPanel.setMaximumSize(new java.awt.Dimension(1060, 20));
        
        nextButton = new javax.swing.JButton();
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
        nextButton.setText("Next");
//        nextButton.setSize(87, 32);
        nextButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        
        backButton = new javax.swing.JButton();
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
        backButton.setText("Back");
//        backButton.setSize(87,32);
        backButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        tailerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        tailerPanel.add(backButton);
        tailerPanel.add(nextButton); 
        add(tailerPanel);
    }
    private javax.swing.JPanel tailerPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton backButton;
}
