package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.components.RoundedGradientPanel;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class ScrollPaneImages extends JPanel {

    public JPanel getjPanel() {
        return jPanel;
    }

    public com.uiteco.components.RoundedGradientPanel getRoundedGradientPanel1() {
        return roundedGradientPanel1;
    }

    public ScrollPaneImages() {
        _initComponents();

    }

    private void _initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jPanel = new JPanel();
        roundedGradientPanel1 = new RoundedGradientPanel();
        
        roundedGradientPanel1.setOpaque(true);
        jScrollPane.setOpaque(false);
        jPanel.setOpaque(false);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setViewportView(jPanel);

        getRoundedGradientPanel1().setColor1(new java.awt.Color(62, 147, 252));
        getRoundedGradientPanel1().setColor2(new java.awt.Color(239, 183, 192));
        getRoundedGradientPanel1().setRoundBottomLeft(30);
        getRoundedGradientPanel1().setRoundBottomRight(30);
        getRoundedGradientPanel1().setRoundTopLeft(30);
        getRoundedGradientPanel1().setRoundTopRight(30);
        getRoundedGradientPanel1().setLayout(new FlowLayout(1, 50, 0));

        javax.swing.GroupLayout roundedGradientPanel1Layout = new javax.swing.GroupLayout(roundedGradientPanel1);
        roundedGradientPanel1.setLayout(roundedGradientPanel1Layout);
        roundedGradientPanel1Layout.setHorizontalGroup(
                roundedGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedGradientPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
        );
        roundedGradientPanel1Layout.setVerticalGroup(
                roundedGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(roundedGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedGradientPanel1 = new com.uiteco.components.RoundedGradientPanel();
        jScrollPane = new javax.swing.JScrollPane();

        roundedGradientPanel1.setColor1(new java.awt.Color(62, 147, 252));
        roundedGradientPanel1.setColor2(new java.awt.Color(239, 183, 192));
        roundedGradientPanel1.setRoundBottomLeft(30);
        roundedGradientPanel1.setRoundBottomRight(30);
        roundedGradientPanel1.setRoundTopLeft(30);
        roundedGradientPanel1.setRoundTopRight(30);

        jScrollPane.setOpaque(true);

        javax.swing.GroupLayout roundedGradientPanel1Layout = new javax.swing.GroupLayout(roundedGradientPanel1);
        roundedGradientPanel1.setLayout(roundedGradientPanel1Layout);
        roundedGradientPanel1Layout.setHorizontalGroup(
            roundedGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedGradientPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
        );
        roundedGradientPanel1Layout.setVerticalGroup(
            roundedGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedGradientPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private JPanel jPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
