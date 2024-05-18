/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.firstPage.view;

//import java.awt.Color;

import com.uiteco.components.RoundedPanel;
import javax.swing.JLabel;

public class LabelDaysLeft extends javax.swing.JPanel {

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public LabelDaysLeft() {
        _initComponents();
    }

    private void _initComponents() {

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        setjLabel1(new javax.swing.JLabel());

        setOpaque(false); //background of roundedPanel1

        //roundedPanel1.setBackground(new java.awt.Color(35, 161, 150));
        roundedPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 2, 1)); //set gap of label inside
        roundedPanel1.setPreferredSize(new java.awt.Dimension(114, 30));
        roundedPanel1.setRoundBottomLeft(25);
        roundedPanel1.setRoundBottomRight(25);
        roundedPanel1.setRoundTopLeft(25);
        roundedPanel1.setRoundTopRight(25);

        getjLabel1().setBackground(new java.awt.Color(255, 255, 255));
        getjLabel1().setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getjLabel1().setForeground(new java.awt.Color(255, 255, 255));
        getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-circle-8.png"))); // NOI18N

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getjLabel1(), javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(getjLabel1(), javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }
//
//    public void setStatus(Model_OnePost model) {
//        String status = model.getStatus1();
//        if (status != null) {
//            jLabel1.setText(status);
//
//            if (status.startsWith(StatusType.UPCOMING.getStatus())) {
//                int daysRemaining = Integer.parseInt(status.replaceAll("\\D+", ""));
//                roundedPanel1.setBackground(new Color(245,247,247));
//                if (daysRemaining <= 2) {
//                    jLabel1.setForeground(Color.RED);
//                } else {
//                    jLabel1.setForeground(Color.WHITE);
//                }
//            } 
//            else if (status.equals(StatusType.ONGOING.getStatus())) {
//                roundedPanel1.setBackground(new Color(234, 93, 37));
//                jLabel1.setForeground(Color.WHITE);
//            } 
//            else if (status.equals(StatusType.FINISHED.getStatus())) {
//                roundedPanel1.setBackground(new Color(35, 161, 150));
//                jLabel1.setForeground(Color.WHITE);
//            }
//        }
//    }
// 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        roundedPanel1.setBackground(new java.awt.Color(35, 161, 150));
        roundedPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 2, 1));
        roundedPanel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        roundedPanel1.setPreferredSize(new java.awt.Dimension(114, 30));
        roundedPanel1.setRoundBottomLeft(25);
        roundedPanel1.setRoundBottomRight(25);
        roundedPanel1.setRoundTopLeft(25);
        roundedPanel1.setRoundTopRight(25);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-circle-8.png"))); // NOI18N

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jLabel1;
    protected com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables

    public LabelDaysLeft(JLabel jLabel1, RoundedPanel roundedPanel1) {
        this.jLabel1 = jLabel1;
        this.roundedPanel1 = roundedPanel1;
    }
}
