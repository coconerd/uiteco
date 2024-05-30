/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo;

import com.uiteco.contentPanels.CauLacBoPanel;
import java.awt.Color;
/**
 *
 * @author Acer
 */
public class FooterChangePageCLB extends javax.swing.JPanel {

    private int RC = 15, NumPresentPage = 0, NumberOfCLB = 0;
    private CauLacBoPanel MainPanelCLB;
    
    private boolean IsDisableNextButton = false;
    private boolean IsDisableBackButton = false;
    
    public FooterChangePageCLB() {
        Start(15);
        initComponents();
        
    }

    public FooterChangePageCLB(int RC) {
        Start(RC);
        initComponents();   
    }
    
    public FooterChangePageCLB(int RC, int PresentPage, int NumOfPageCLB) {
        NumPresentPage = PresentPage;
        NumberOfCLB = NumOfPageCLB;
        
        if(NumPresentPage == NumOfPageCLB)
            IsDisableNextButton = true;
        if(NumPresentPage == 1)
            IsDisableBackButton = true;
        
        Start(RC);
        initComponents();
        
        this.PresentPage.setText("" + PresentPage);
        this.NumOfPageCLB.setText("" + NumOfPageCLB);
        
    }
    
    public void Start(int RC)
    {
        this.RC = RC;
    }
    
    public void setMainPanel(CauLacBoPanel MainPanelCLB)
    {
        this.MainPanelCLB = MainPanelCLB;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barrier = new javax.swing.JLabel();
        NumOfPageCLB = new javax.swing.JLabel();
        PresentPage = new javax.swing.JLabel();
        BackButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound(IsDisableBackButton);
        NextButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound(IsDisableNextButton);

        Barrier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Barrier.setText("/");

        NumOfPageCLB.setText("NumOfPageCLB");
        NumOfPageCLB.setFocusable(false);

        PresentPage.setForeground(new java.awt.Color(40, 206, 40));
        PresentPage.setText("PresentPage");

        BackButton.setBorder(null);
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Back_16px.png"))); // NOI18N
        BackButton.setboderSize(2);
        BackButton.setBorderColor(new java.awt.Color(51, 153, 255));
        BackButton.setColorClick(new java.awt.Color(218, 218, 218));
        BackButton.setColorOver(new java.awt.Color(242, 242, 242));
        BackButton.setFocusable(false);
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BackButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BackButton.setRadius(80);
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackButtonMousePressed(evt);
            }
        });

        NextButton.setBorder(null);
        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Next_16px.png"))); // NOI18N
        NextButton.setboderSize(2);
        NextButton.setBorderColor(new java.awt.Color(51, 153, 255));
        NextButton.setColorClick(new java.awt.Color(218, 218, 218));
        NextButton.setColorOver(new java.awt.Color(242, 242, 242));
        NextButton.setFocusable(false);
        NextButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NextButton.setRadius(80);
        NextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PresentPage)
                .addGap(4, 4, 4)
                .addComponent(Barrier)
                .addGap(4, 4, 4)
                .addComponent(NumOfPageCLB)
                .addGap(15, 15, 15)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(PresentPage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Barrier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(NumOfPageCLB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMousePressed
        if(NumPresentPage != NumberOfCLB)
            MainPanelCLB.goToNextPage(NumPresentPage);
    }//GEN-LAST:event_NextButtonMousePressed

    private void BackButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMousePressed
        if(NumPresentPage != 1)
            MainPanelCLB.goToPreviousPage(NumPresentPage);
    }//GEN-LAST:event_BackButtonMousePressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.contentPanels.CauLacBo.ButtonRound BackButton;
    private javax.swing.JLabel Barrier;
    private com.uiteco.contentPanels.CauLacBo.ButtonRound NextButton;
    private javax.swing.JLabel NumOfPageCLB;
    private javax.swing.JLabel PresentPage;
    // End of variables declaration//GEN-END:variables
}
