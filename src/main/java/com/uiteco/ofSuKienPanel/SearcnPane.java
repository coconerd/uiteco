/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import com.uiteco.components.RoundedPanel;

/**
 *
 * @author nddmi
 */
public class SearcnPane extends RoundedPanel {
    public SearcnPane() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(36, 37, 38));
        setRoundBottomLeft(50);
        setRoundBottomRight(50);
        setRoundTopLeft(50);
        setRoundTopRight(50);

        jFormattedTextField1.setBackground(new java.awt.Color(36, 37, 38));
        jFormattedTextField1.setBorder(null);
        jFormattedTextField1.setForeground(new java.awt.Color(242, 243, 244));
        jFormattedTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jFormattedTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    // End of variables declaration//GEN-END:variables
}
