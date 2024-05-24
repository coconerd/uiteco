
package com.uiteco.OfCuocThiPanel.secondPage;

public class RoundImageUI extends javax.swing.JPanel {

    /**
     * @return the roundedImagePanel
     */
    public com.uiteco.components.RoundedImagePanel getRoundedImagePanel() {
        return roundedImagePanel;
    }


    /**
     * Creates new form RoundImageUI
     */
    public RoundImageUI() {
        initComponents();
        roundedImagePanel1.setBorder(null);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedImagePanel1 = new com.uiteco.components.RoundedImagePanel();
        roundedImagePanel = new com.uiteco.components.RoundedImagePanel();

        javax.swing.GroupLayout roundedImagePanel1Layout = new javax.swing.GroupLayout(roundedImagePanel1);
        roundedImagePanel1.setLayout(roundedImagePanel1Layout);
        roundedImagePanel1Layout.setHorizontalGroup(
            roundedImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        roundedImagePanel1Layout.setVerticalGroup(
            roundedImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        setOpaque(false);

        roundedImagePanel.setRoundBottomLeft(30);
        roundedImagePanel.setRoundBottomRight(30);
        roundedImagePanel.setRoundTopLeft(30);
        roundedImagePanel.setRoundTopRight(30);

        javax.swing.GroupLayout roundedImagePanelLayout = new javax.swing.GroupLayout(roundedImagePanel);
        roundedImagePanel.setLayout(roundedImagePanelLayout);
        roundedImagePanelLayout.setHorizontalGroup(
            roundedImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        roundedImagePanelLayout.setVerticalGroup(
            roundedImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.components.RoundedImagePanel roundedImagePanel;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel1;
    // End of variables declaration//GEN-END:variables
}
