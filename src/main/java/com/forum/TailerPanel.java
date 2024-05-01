/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

public class TailerPanel extends javax.swing.JPanel{
    public TailerPanel(){
        initComponents();
    }
    void initComponents(){
        setBackground(new java.awt.Color(231,231,231));
        setPreferredSize(new java.awt.Dimension(1060, 32));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        nextButton = new javax.swing.JButton();
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setSize(87, 32);
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                nextButton.setBorderPainted(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                nextButton.setBorderPainted(false);
            }
        });
        
        backButton = new javax.swing.JButton();
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setSize(87,32);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                backButton.setBorderPainted(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                backButton.setBorderPainted(false);
            }
        });
        add(backButton);
        add(nextButton);      
    }

    private javax.swing.JButton nextButton;
    private javax.swing.JButton backButton;
}
