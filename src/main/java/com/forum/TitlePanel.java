/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

/**
 *
 * @author 21H1 HNQA
 */
public class TitlePanel extends javax.swing.JPanel{
    public TitlePanel(){
        initTitlePanel();
    }
    
    void initTitlePanel(){
        setSize(1060,40);
        //setBackground(new java.awt.Color(231,231,231));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        
        add(javax.swing.Box.createHorizontalStrut(40));
        topicLabel = new javax.swing.JLabel();
        topicLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        topicLabel.setText("Topic");
        topicLabel.setSize(50, 34);
        add(topicLabel);

        add(javax.swing.Box.createHorizontalStrut(450));
        statisticLabel = new javax.swing.JLabel();
        statisticLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        statisticLabel.setText("Statistic");
        statisticLabel.setSize(70,34);
        add(statisticLabel);
        
        add(javax.swing.Box.createHorizontalStrut(250));
        postedByLabel = new javax.swing.JLabel();
        postedByLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        postedByLabel.setText("Posted by");
        postedByLabel.setSize(85,34);
        add(postedByLabel);
        add(javax.swing.Box.createHorizontalStrut(105));
    }
    private javax.swing.JLabel topicLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JLabel postedByLabel;
}
