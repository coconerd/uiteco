package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.secondPage.scrollBar.ScrollBarCustom;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ScrollPaneImages extends JPanel {

    public com.uiteco.components.RoundedGradientPanel getRoundedGradientPanel() {
        return roundedGradientPanel;
    }

    public ScrollPaneImages() {
        initComponents();
        
        jScrollPane.setHorizontalScrollBar(new ScrollBarCustom());
        jScrollPane.setBorder(null);
        
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        jScrollPane.setHorizontalScrollBar(sp);
        
        jScrollPane.setViewportView(roundedGradientPanel);
        //UIManager.put("ScrollBar.showButtons", false);
//        jScrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
//                + "trackArc:999;"
//                + "trackInsets:3,3,3,3;"
//                + "thumbInsets:3,3,3,3;"
//        );
//        UIManager.put("ScrollBar.track", new Color(0xe0e0e0));
//        UIManager.put("ScrollBar.thumb", new ColorUIResource(100, 150, 200)); // Change thumb color
//        FlatMacLightLaf.setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        roundedGradientPanel = new com.uiteco.components.RoundedGradientPanel();

        setOpaque(false);

        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setViewportView(roundedGradientPanel);

        roundedGradientPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(45, 0, 10, 0));
        roundedGradientPanel.setColor1(new java.awt.Color(222, 236, 221));
        roundedGradientPanel.setColor2(new java.awt.Color(238, 241, 245));
        roundedGradientPanel.setFull(false);
        roundedGradientPanel.setPreferredSize(new java.awt.Dimension(110, 100));
        roundedGradientPanel.setRoundBottomLeft(40);
        roundedGradientPanel.setRoundBottomRight(40);
        roundedGradientPanel.setRoundTopLeft(40);
        roundedGradientPanel.setRoundTopRight(40);
        roundedGradientPanel.setLayout(new javax.swing.BoxLayout(roundedGradientPanel, javax.swing.BoxLayout.X_AXIS));
        jScrollPane.setViewportView(roundedGradientPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel;
    // End of variables declaration//GEN-END:variables
}
