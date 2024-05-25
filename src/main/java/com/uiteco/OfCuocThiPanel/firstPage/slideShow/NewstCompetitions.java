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
        //setPreferredSize(new Dimension(1160, 520));
        initComponents();
       
        List<ImageIcon> imageList = CuocThiDAO.getImagesForSlideshow();
        //System.out.println(width);
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
        slideShow_AutoSlide = new com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        roundedGradientPanel1.setColor1(new java.awt.Color(252, 225, 208));
        roundedGradientPanel1.setColor2(new java.awt.Color(221, 108, 214));
        roundedGradientPanel1.setPreferredSize(new java.awt.Dimension(1170, 500));
        roundedGradientPanel1.setRoundBottomLeft(40);
        roundedGradientPanel1.setRoundBottomRight(40);
        roundedGradientPanel1.setRoundTopLeft(40);
        roundedGradientPanel1.setRoundTopRight(30);
        roundedGradientPanel1.setLayout(new java.awt.BorderLayout(35, 20));

        slideShow_AutoSlide.setOpaque(false);
        roundedGradientPanel1.add(slideShow_AutoSlide, java.awt.BorderLayout.CENTER);

        jLabel1.setText("jLabel1");
        roundedGradientPanel1.add(jLabel1, java.awt.BorderLayout.LINE_END);

        back.setText("jLabel2");
        roundedGradientPanel1.add(back, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel1;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.SlideShow_AutoSlide slideShow_AutoSlide;
    // End of variables declaration//GEN-END:variables
}
