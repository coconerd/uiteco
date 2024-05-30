package com.uiteco.OfCuocThiPanel.secondPage;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uiteco.OfCuocThiPanel.secondPage.scrollBar.ScrollBarCustom;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class ScrollPaneImages extends JPanel {

    public com.uiteco.components.RoundedGradientPanel getRoundedGradientPanel() {
        return roundedGradientPanel;
    }

    public ScrollPaneImages() {
        initComponents();
        
        jScrollPane.setHorizontalScrollBar(new ScrollBarCustom());
        jScrollPane.setBorder(null);
        jScrollPane.setOpaque(false);
        ScrollBarCustom sp = new ScrollBarCustom();
        
        sp.setOrientation(JScrollBar.HORIZONTAL);
        jScrollPane.setHorizontalScrollBar(sp);
        
        jScrollPane.setViewportView(roundedGradientPanel);
        UIManager.put("ScrollBar.showButtons", false);
        
        UIManager.put("ScrollBar.track", Color.WHITE);
        UIManager.put("ScrollBar.thumb", new ColorUIResource(100, 150, 200)); // Change thumb color
        FlatMacLightLaf.setup();
        
        roundedGradientPanel.revalidate();
        roundedGradientPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        roundedGradientPanel = new com.uiteco.components.RoundedGradientPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setOpaque(false);

        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setViewportView(roundedGradientPanel);

        roundedGradientPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 30, 20, 30));
        roundedGradientPanel.setColor1(new java.awt.Color(233, 222, 250));
        roundedGradientPanel.setDirection(com.uiteco.components.RoundedGradientPanel.Direction.HORIZONTAL);
        roundedGradientPanel.setRoundBottomLeft(60);
        roundedGradientPanel.setRoundBottomRight(60);
        roundedGradientPanel.setRoundTopLeft(60);
        roundedGradientPanel.setRoundTopRight(60);
        roundedGradientPanel.setLayout(new java.awt.GridLayout(1, 0, 65, 0));
        jScrollPane.setViewportView(roundedGradientPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JScrollPane jScrollPane;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel;
    // End of variables declaration//GEN-END:variables
}
