/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

/**
 *
 * @author 21H1 HNQA
 */
public class HeaderForum extends javax.swing.JPanel{
    public HeaderForum(){
        initHeaderForum();
    }
    void initHeaderForum(){
        setSize(1060,50);
        setBackground(new java.awt.Color(0,102,102));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        
        add(javax.swing.Box.createHorizontalStrut(15));
        topicButton = new javax.swing.JButton();
        topicButton.setSize(110,38);
        topicButton.setBackground(new java.awt.Color(246,246,238));
        topicButton.setFont(new java.awt.Font("Segoe UI",1,16));
        topicButton.setForeground(new java.awt.Color(51,51,51));
        topicButton.setText("POSTING"); 
        topicButton.setBorderPainted(false);
        topicButton.setFocusable(false);
        topicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                topicButton.setBorderPainted(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                topicButton.setBorderPainted(false);
            }
        });
        add(topicButton);
        
        add(javax.swing.Box.createHorizontalStrut(15));
        lastedPostButton = new javax.swing.JButton();
        lastedPostButton.setSize(150,38);
        lastedPostButton.setBackground(new java.awt.Color(246,246,238));
        lastedPostButton.setFont(new java.awt.Font("Segoe UI",1,16));
        lastedPostButton.setForeground(new java.awt.Color(51,51,51));
        lastedPostButton.setText("LASTED POST");  
        lastedPostButton.setBorderPainted(false);
        lastedPostButton.setFocusable(false);
        lastedPostButton.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mouseEntered(java.awt.event.MouseEvent e){
             lastedPostButton.setBorderPainted(true);
         }
         @Override
         public void mouseExited(java.awt.event.MouseEvent e){
             lastedPostButton.setBorderPainted(false);
         }
     });
        add(lastedPostButton);
        
        add(javax.swing.Box.createHorizontalStrut(610));
        ecoForumLabel = new javax.swing.JLabel();
        ecoForumLabel.setSize(150,42);
        ecoForumLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ecoForumLabel.setForeground(new java.awt.Color(255, 255, 255));
        ecoForumLabel.setText("ECO-FORUM");
        add(ecoForumLabel);
        add(javax.swing.Box.createHorizontalStrut(2));
        
    } 
    private javax.swing.JButton topicButton;
    private javax.swing.JButton lastedPostButton;
    private javax.swing.JLabel ecoForumLabel;
}
    
    
