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
        highResolutionResize1 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        highResolutionResize2 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
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

        highResolutionResize1.setImage(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        highResolutionResize1.setPreferredSize(new java.awt.Dimension(80, 436));

        javax.swing.GroupLayout highResolutionResize1Layout = new javax.swing.GroupLayout(highResolutionResize1);
        highResolutionResize1.setLayout(highResolutionResize1Layout);
        highResolutionResize1Layout.setHorizontalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        highResolutionResize1Layout.setVerticalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        roundedGradientPanel1.add(highResolutionResize1, java.awt.BorderLayout.LINE_START);

        highResolutionResize2.setImage(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        highResolutionResize2.setPreferredSize(new java.awt.Dimension(80, 436));

        javax.swing.GroupLayout highResolutionResize2Layout = new javax.swing.GroupLayout(highResolutionResize2);
        highResolutionResize2.setLayout(highResolutionResize2Layout);
        highResolutionResize2Layout.setHorizontalGroup(
            highResolutionResize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        highResolutionResize2Layout.setVerticalGroup(
            highResolutionResize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        roundedGradientPanel1.add(highResolutionResize2, java.awt.BorderLayout.LINE_END);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize1;
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize2;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel2;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide slideShow_AutoSlide;
    // End of variables declaration//GEN-END:variables
}
