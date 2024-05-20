package com.uiteco.OfCuocThiPanel.firstPage.slideShow;

import com.uiteco.OfCuocThiPanel.getDataFromDB.CuocThiData;
import com.uiteco.components.RoundedImagePanel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class NewstCompetitions extends javax.swing.JPanel {

    public NewstCompetitions() {
        setPreferredSize(new Dimension(1165, 520));
        initComponents();
        List<ImageIcon> imageList = CuocThiData.getAllImages();
        List<Component> list = new ArrayList<>();
        for(ImageIcon image : imageList){
            RoundedImagePanel r = new RoundedImagePanel();
            r.setImage(image);
            r.setRoundBottomLeft(30);
            r.setRoundBottomRight(30);
            r.setRoundTopLeft(30);
            r.setRoundTopRight(30);
            
            list.add(r);
        }
        slideShow_AutoSlide.initSlideshow(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedGradientPanel1 = new com.uiteco.components.RoundedGradientPanel();
        next = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        slideShow_AutoSlide = new com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide();

        roundedGradientPanel1.setColor1(new java.awt.Color(252, 225, 208));
        roundedGradientPanel1.setColor2(new java.awt.Color(221, 108, 214));
        roundedGradientPanel1.setPreferredSize(new java.awt.Dimension(1170, 500));
        roundedGradientPanel1.setRoundBottomLeft(30);
        roundedGradientPanel1.setRoundBottomRight(30);
        roundedGradientPanel1.setRoundTopLeft(30);
        roundedGradientPanel1.setRoundTopRight(30);
        roundedGradientPanel1.setLayout(new java.awt.BorderLayout(35, 0));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-next-page-50.png"))); // NOI18N
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nextMousePressed(evt);
            }
        });
        roundedGradientPanel1.add(next, java.awt.BorderLayout.LINE_END);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-to-50.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
        });
        roundedGradientPanel1.add(back, java.awt.BorderLayout.LINE_START);

        slideShow_AutoSlide.setOpaque(false);
        roundedGradientPanel1.add(slideShow_AutoSlide, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        slideShow_AutoSlide.back();
        slideShow_AutoSlide.stop();
    }//GEN-LAST:event_backMousePressed

    private void nextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMousePressed
        // TODO add your handling code here:
        slideShow_AutoSlide.next();
        slideShow_AutoSlide.stop();
    }//GEN-LAST:event_nextMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel next;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide slideShow_AutoSlide;
    // End of variables declaration//GEN-END:variables
}
