
package com.uiteco.OfCuocThiPanel.secondPage;

public class RoundImageUI extends javax.swing.JPanel {

    /**
     * @return the highResolutionResize1
     */
    public com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize getHighResolutionResize1() {
        return highResolutionResize1;
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
        highResolutionResize1 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();

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

        highResolutionResize1.setImage(new javax.swing.ImageIcon(getClass().getResource("/IS.jpg"))); // NOI18N
        highResolutionResize1.setRoundBottomLeft(30);
        highResolutionResize1.setRoundBottomRight(30);
        highResolutionResize1.setRoundTopLeft(30);
        highResolutionResize1.setRoundTopRight(30);

        javax.swing.GroupLayout highResolutionResize1Layout = new javax.swing.GroupLayout(highResolutionResize1);
        highResolutionResize1.setLayout(highResolutionResize1Layout);
        highResolutionResize1Layout.setHorizontalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        highResolutionResize1Layout.setVerticalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(highResolutionResize1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(highResolutionResize1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize1;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel1;
    // End of variables declaration//GEN-END:variables
}
