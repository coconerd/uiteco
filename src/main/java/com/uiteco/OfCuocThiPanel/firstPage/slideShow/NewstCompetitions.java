package com.uiteco.OfCuocThiPanel.firstPage.slideShow;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.components.RoundedImagePanel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class NewstCompetitions extends javax.swing.JPanel {

    public NewstCompetitions() {
        setPreferredSize(new Dimension(1160, 520));
        initComponents();
        List<ImageIcon> imageList = CuocThiDAO.getImagesForSlideshow();
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
        roundedImagePanel2 = new com.uiteco.components.RoundedImagePanel();
        back = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        next = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        slideShow_AutoSlide = new com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide();

        roundedGradientPanel1.setColor1(new java.awt.Color(252, 225, 208));
        roundedGradientPanel1.setColor2(new java.awt.Color(221, 108, 214));
        roundedGradientPanel1.setPreferredSize(new java.awt.Dimension(1170, 500));
        roundedGradientPanel1.setRoundBottomLeft(30);
        roundedGradientPanel1.setRoundBottomRight(30);
        roundedGradientPanel1.setRoundTopLeft(30);
        roundedGradientPanel1.setRoundTopRight(30);
        roundedGradientPanel1.setLayout(new java.awt.BorderLayout(35, 0));

        javax.swing.GroupLayout roundedImagePanel2Layout = new javax.swing.GroupLayout(roundedImagePanel2);
        roundedImagePanel2.setLayout(roundedImagePanel2Layout);
        roundedImagePanel2Layout.setHorizontalGroup(
            roundedImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        roundedImagePanel2Layout.setVerticalGroup(
            roundedImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        roundedGradientPanel1.add(roundedImagePanel2, java.awt.BorderLayout.CENTER);

        back.setImage(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(80, 436));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
        });

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        roundedGradientPanel1.add(back, java.awt.BorderLayout.LINE_START);

        next.setImage(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        next.setPreferredSize(new java.awt.Dimension(80, 436));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nextMousePressed(evt);
            }
        });

        javax.swing.GroupLayout nextLayout = new javax.swing.GroupLayout(next);
        next.setLayout(nextLayout);
        nextLayout.setHorizontalGroup(
            nextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        nextLayout.setVerticalGroup(
            nextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        roundedGradientPanel1.add(next, java.awt.BorderLayout.LINE_END);

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
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        slideShow_AutoSlide.stop();
        slideShow_AutoSlide.back();
    }//GEN-LAST:event_backMousePressed

    private void nextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMousePressed
        // TODO add your handling code here:
        slideShow_AutoSlide.stop();
        slideShow_AutoSlide.next();
    }//GEN-LAST:event_nextMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize back;
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize next;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel2;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide slideShow_AutoSlide;
    // End of variables declaration//GEN-END:variables
}
