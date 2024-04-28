/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

/**
 *
 * @author 21H1 HNQA
 */
public class TailerPanel extends javax.swing.JPanel{
    public TailerPanel(){
        initComponents();
    }
    void initComponents(){
        setBackground(new java.awt.Color(231,231,231));
        setPreferredSize(new java.awt.Dimension(1060, 32));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        //setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        
        //add(javax.swing.Box.createHorizontalStrut(500));
        nextButton = new javax.swing.JButton();
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setSize(87, 32);
        nextButton.setFocusable(false);
        
        //nextButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        //add(javax.swing.Box.createHorizontalStrut(10));
        backButton = new javax.swing.JButton();
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setSize(87,32);
        backButton.setFocusable(false);
        add(backButton);
        add(nextButton); 
        //add(javax.swing.Box.createHorizontalStrut(30));
        //backButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        
    }

    private javax.swing.JButton nextButton;
    private javax.swing.JButton backButton;
}
