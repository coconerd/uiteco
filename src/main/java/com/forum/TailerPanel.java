/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

import com.uiteco.contentPanels.ForumPanel;
import javax.swing.JPanel;

public class TailerPanel extends javax.swing.JPanel{
    public TailerPanel(){
        initComponents();
    }
    void initComponents(){
        setBackground(new java.awt.Color(231,231,231));
        setPreferredSize(new java.awt.Dimension(1060, 32));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        //nextButton = new javax.swing.JButton();
        nextButton = new com.forum.RoundedBorderButton();
        nextButton.setBackground(new java.awt.Color(195, 208, 229));
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setSize(87, 32);
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
                 System.out.println("Next button in the main interface of forum is clicked!");
                 JPanel panel = (JPanel)getParent();
                 PostListPanel pl = (PostListPanel)panel.getComponent(0);
                 pl.setCurrentPageToNext();
        }
    });
        
        //backButton = new javax.swing.JButton();
        backButton = new com.forum.RoundedBorderButton();
        backButton.setBackground(new java.awt.Color(195, 208, 229));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setSize(87,32);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
                 System.out.println("Back button in the main interface of forum is clicked!");
                 JPanel panel = (JPanel)getParent();               
                 PostListPanel pl = (PostListPanel)panel.getComponent(0);
                 pl.setCurrentPageToBack();
        }
    });

        add(backButton);
        add(nextButton);      
        
        //thiết kế label hoặc button để hiển thị số trang hiện tại trên tổng số trang, cho phép người dùng di chuyển đến 1 trang bất kỳ
    }

    private javax.swing.JButton nextButton;
    private javax.swing.JButton backButton;
}
