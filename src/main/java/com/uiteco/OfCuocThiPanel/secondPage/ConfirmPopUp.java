package com.uiteco.OfCuocThiPanel.secondPage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ConfirmPopUp extends javax.swing.JPanel {

    /**
     * @return the jNo
     */
    public com.uiteco.OfCuocThiPanel.secondPage.CustomButton getjNo() {
        return jNo;
    }

    /**
     * @return the jOk
     */
    public com.uiteco.OfCuocThiPanel.secondPage.CustomButton getjOk() {
        return jOk;
    }

    public ConfirmPopUp() {
        initComponents();
        setOpaque(false);
        jNo.setContentAreaFilled(false);
        jOk.setContentAreaFilled(false);
        setBorder(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        g2.dispose();
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jNo = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jOk = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jIcon = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(50);
        roundedPanel1.setRoundBottomRight(50);
        roundedPanel1.setRoundTopLeft(50);
        roundedPanel1.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("<html>Sau khi nhấn xác nhận đăng kí tham gia, sinh viên có thể nhấn hủy tham gia (nếu muốn) trong thời gian qui định của ban tổ chức. </html>");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xác nhận đăng kí tham gia cuộc thi");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jNo.setText("Hủy");
        jNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNoActionPerformed(evt);
            }
        });

        jOk.setText("Xác nhận");
        jOk.setColor(new java.awt.Color(247, 182, 255));
        jOk.setColorClick(new java.awt.Color(237, 153, 231));
        jOk.setColorOver(new java.awt.Color(203, 163, 233));
        jOk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jIcon.setImage(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N

        javax.swing.GroupLayout jIconLayout = new javax.swing.GroupLayout(jIcon);
        jIcon.setLayout(jIconLayout);
        jIconLayout.setHorizontalGroup(
            jIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );
        jIconLayout.setVerticalGroup(
            jIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jNo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jOk, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(roundedPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundedPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jIcon.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize jIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jNo;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jOk;
    private javax.swing.JPopupMenu jPopupMenu1;
    protected com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
