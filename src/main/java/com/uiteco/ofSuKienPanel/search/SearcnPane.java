/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.uiteco.components.RoundedPanel;
import java.awt.Cursor;

/**
 *
 * @author nddmi
 */
public class SearcnPane extends RoundedPanel {

    private String placeHolder;

    public SearcnPane() {
        initComponents();
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(36, 37, 38));
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        setRoundBottomLeft(50);
        setRoundBottomRight(50);
        setRoundTopLeft(50);
        setRoundTopRight(50);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        text.setBackground(new java.awt.Color(36, 37, 38));
        text.setBorder(null);
        text.setForeground(new java.awt.Color(242, 243, 244));
        text.setText("Tìm kiếm " + (placeHolder != null && placeHolder != "" ? placeHolder : "")
        );
        text.setCaretColor(new java.awt.Color(255, 255, 255));
        text.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFocusLost(evt);
            }
        });
        text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMouseClicked(evt);
            }
        });
        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(176, 179, 184));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-28.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(text))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_textMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_formMouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel1MouseExited

    private void textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusGained
        // TODO add your handling code here:
        text.setText("");
    }//GEN-LAST:event_textFocusGained

    private void textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFocusLost
        // TODO add your handling code here:
        text.setText("Tìm kiếm " + (placeHolder != null && placeHolder != "" ? placeHolder : ""));
    }//GEN-LAST:event_textFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JFormattedTextField text;
    // End of variables declaration//GEN-END:variables
}
