package com.uiteco.OfCuocThiPanel.secondPage;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class ScrollPaneImages extends JPanel {

    /**
     * @return the roundedGradientPanel
     */
    public com.uiteco.components.RoundedGradientPanel getRoundedGradientPanel() {
        return roundedGradientPanel;
    }

    public ScrollPaneImages() {
        initComponents();
        jScrollPane.setBorder(null);
        jScrollPane.setOpaque(false);
        UIManager.put("ScrollBar.showButtons", false);
        jScrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
        );
        UIManager.put("ScrollBar.track", new Color(0xe0e0e0));
        UIManager.put("ScrollBar.thumb", new ColorUIResource(100, 150, 200)); // Change thumb color
        FlatMacLightLaf.setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        roundedGradientPanel = new com.uiteco.components.RoundedGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roundedGradientPanel1 = new com.uiteco.components.RoundedGradientPanel();

        setOpaque(false);

        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        roundedGradientPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        roundedGradientPanel.setColor1(new java.awt.Color(222, 236, 221));
        roundedGradientPanel.setColor2(new java.awt.Color(238, 241, 245));
        roundedGradientPanel.setFull(false);
        roundedGradientPanel.setRoundBottomLeft(40);
        roundedGradientPanel.setRoundBottomRight(40);
        roundedGradientPanel.setRoundTopLeft(40);
        roundedGradientPanel.setRoundTopRight(40);
        roundedGradientPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 50, 10));
        jScrollPane.setViewportView(roundedGradientPanel);

        jPanel1.setOpaque(false);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(true);

        roundedGradientPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        roundedGradientPanel1.setColor1(new java.awt.Color(253, 189, 85));
        roundedGradientPanel1.setColor2(new java.awt.Color(249, 131, 255));
        roundedGradientPanel1.setFull(false);
        roundedGradientPanel1.setRoundBottomLeft(40);
        roundedGradientPanel1.setRoundBottomRight(40);
        roundedGradientPanel1.setRoundTopLeft(40);
        roundedGradientPanel1.setRoundTopRight(40);
        roundedGradientPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 50, 40));
        jScrollPane1.setViewportView(roundedGradientPanel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
