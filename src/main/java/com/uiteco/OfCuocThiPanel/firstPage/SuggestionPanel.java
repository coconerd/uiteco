package com.uiteco.OfCuocThiPanel.firstPage;

public class SuggestionPanel extends javax.swing.JPanel {

    public SuggestionPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundedGradientPanel1 = new com.uiteco.components.RoundedGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setOpaque(false);

        roundedGradientPanel1.setColor1(new java.awt.Color(255, 254, 255));
        roundedGradientPanel1.setColor2(new java.awt.Color(215, 255, 254));
        roundedGradientPanel1.setRoundBottomLeft(45);
        roundedGradientPanel1.setRoundBottomRight(45);
        roundedGradientPanel1.setRoundTopLeft(45);
        roundedGradientPanel1.setRoundTopRight(45);
        roundedGradientPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Merriweather", 0, 18)); // NOI18N
        jLabel1.setText("Competitions suggestion to you");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 25, 0);
        roundedGradientPanel1.add(jLabel1, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-light-45.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 24, 10);
        roundedGradientPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Merriweather", 2, 16)); // NOI18N
        jLabel4.setText("Coming soon ...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        roundedGradientPanel1.add(jLabel4, gridBagConstraints);

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
