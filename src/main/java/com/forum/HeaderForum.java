/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

public class HeaderForum extends javax.swing.JPanel{
    public HeaderForum(){
        initHeaderForum();
    }
    void initHeaderForum(){
        setBackground(new java.awt.Color(0,102,102));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        setPreferredSize(new java.awt.Dimension(1063,42));
        setMaximumSize(this.getPreferredSize());
       
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10,0)));
        topicPanel = new javax.swing.JPanel();
        topicButton = new javax.swing.JButton();
        topicPanel.setBackground(new java.awt.Color(0,102,102));
        topicPanel.setPreferredSize(new java.awt.Dimension(130,35));
        topicPanel.setMaximumSize(topicPanel.getPreferredSize());
//        topicPanel.setAlignmentY(java.awt.Component.TOP_ALIGNMENT);
//        topicButton.setMaximumSize(new java.awt.Dimension(topicPanel.getPreferredSize().width, topicPanel.getPreferredSize().height-8));
        topicButton.setMaximumSize(topicPanel.getPreferredSize());
        topicButton.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        topicButton.setBackground(new java.awt.Color(246,246,238));
        topicButton.setFont(new java.awt.Font("Segoe UI",1,16));
        topicButton.setForeground(new java.awt.Color(51,51,51));
        topicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-20.png")));
        topicButton.setText("New Post"); 
        topicButton.setBorderPainted(false);
        topicButton.setFocusable(false);
        //topicButton.setBorder(javax.swing.BorderFactory.createRoundBorder(10));
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
        topicPanel.setLayout(new javax.swing.BoxLayout(topicPanel, javax.swing.BoxLayout.X_AXIS));
        topicPanel.add(topicButton);
        add(topicPanel);
        
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(10,0)));
        lastedPostPanel = new javax.swing.JPanel();
        lastedPostButton = new javax.swing.JButton();
        lastedPostPanel.setBackground(new java.awt.Color(0,102,102));
        lastedPostPanel.setPreferredSize(new java.awt.Dimension(150, 35));
        lastedPostPanel.setMaximumSize(lastedPostPanel.getPreferredSize());
//        lastedPostPanel.setAlignmentY(java.awt.Component.LEFT_ALIGNMENT);
        lastedPostButton.setMaximumSize(lastedPostPanel.getPreferredSize());
        lastedPostButton.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        lastedPostButton.setBackground(new java.awt.Color(246,246,238));
        lastedPostButton.setFont(new java.awt.Font("Segoe UI",1,16));
        lastedPostButton.setForeground(new java.awt.Color(51,51,51));
        lastedPostButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-conversion-18.png")));
        lastedPostButton.setText("Latest Post");  
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
        lastedPostPanel.setLayout(new javax.swing.BoxLayout(lastedPostPanel, javax.swing.BoxLayout.X_AXIS));
        lastedPostPanel.add(lastedPostButton);
        add(lastedPostPanel);
        
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(550,0)));
        ecoForumPanel = new javax.swing.JPanel();
        ecoForumLabel = new javax.swing.JLabel();
        ecoForumPanel.setBackground(new java.awt.Color(0,102,102));
        //ecoForumPanel.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
        ecoForumPanel.setPreferredSize(new java.awt.Dimension(150,35));
        ecoForumPanel.setMaximumSize(ecoForumPanel.getPreferredSize());
        ecoForumLabel.setMaximumSize(ecoForumPanel.getPreferredSize());
        ecoForumLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ecoForumLabel.setForeground(new java.awt.Color(255, 255, 255));
        ecoForumLabel.setText("ECO-FORUM");
        
        ecoForumPanel.setLayout(new javax.swing.BoxLayout(ecoForumPanel, javax.swing.BoxLayout.X_AXIS));
        ecoForumPanel.add(ecoForumLabel);
        add(ecoForumPanel);
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(8,0)));
        
    } 
    private javax.swing.JButton topicButton;
    private javax.swing.JButton lastedPostButton;
    private javax.swing.JLabel ecoForumLabel;
    private javax.swing.JPanel topicPanel;
    private javax.swing.JPanel lastedPostPanel;
    private javax.swing.JPanel ecoForumPanel;
}
    
    
