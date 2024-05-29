
package com.uiteco.OfCuocThiPanel.secondPage;

public class RoundImageUI extends javax.swing.JPanel {

    /**
     * @return the jLabel
     */
    public javax.swing.JLabel getjLabel() {
        return jLabel;
    }

    /**
     * @return the roundedImagePanel2
     */
    public com.uiteco.components.RoundedImagePanel getRoundedImagePanel2() {
        return roundedImagePanel2;
    }

    public com.uiteco.components.RoundedImagePanel getRoundedImagePanel1() {
        return roundedImagePanel1;
    }

//    public javax.swing.JLabel getjLabel() {
//        return jLabel;
//    }

    public RoundImageUI() {
        initComponents();
        roundedImagePanel1.setBorder(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedImagePanel1 = new com.uiteco.components.RoundedImagePanel();
        roundedImagePanel2 = new com.uiteco.components.RoundedImagePanel();
        jLabel = new javax.swing.JLabel();

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

        javax.swing.GroupLayout roundedImagePanel2Layout = new javax.swing.GroupLayout(roundedImagePanel2);
        roundedImagePanel2.setLayout(roundedImagePanel2Layout);
        roundedImagePanel2Layout.setHorizontalGroup(
            roundedImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        roundedImagePanel2Layout.setVerticalGroup(
            roundedImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel1;
    private com.uiteco.components.RoundedImagePanel roundedImagePanel2;
    // End of variables declaration//GEN-END:variables
}
