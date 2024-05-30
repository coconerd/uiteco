package com.uiteco.OfCuocThiPanel.secondPage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ConfirmPopUp extends javax.swing.JPanel {

    /**
     * @return the jTitle
     */
    public javax.swing.JLabel getjTitle() {
        return jTitle;
    }

    /**
     * @param jTitle the jTitle to set
     */
    public void setjTitle(javax.swing.JLabel jTitle) {
        this.jTitle = jTitle;
    }

    /**
     * @return the jContent
     */
    public javax.swing.JLabel getjContent() {
        return jContent;
    }

    /**
     * @return the jIcon
     */
    public javax.swing.JLabel getjIcon() {
        return jIcon;
    }

    /**
     * @param jContent the jContent to set
     */
    public void setjContent(javax.swing.JLabel jContent) {
        this.jContent = jContent;
    }

    /**
     * @param jIcon the jIcon to set
     */
    public void setjIcon(javax.swing.JLabel jIcon) {
        this.jIcon = jIcon;
    }

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
        super.paintComponent(g); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jContent = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();
        jNo = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jOk = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(55);
        roundedPanel1.setRoundBottomRight(55);
        roundedPanel1.setRoundTopLeft(55);
        roundedPanel1.setRoundTopRight(55);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jContent.setFont(new java.awt.Font("Segoe UI", 2, 22)); // NOI18N
        jContent.setForeground(new java.awt.Color(102, 102, 102));
        jContent.setText("<html>Sau khi nhấn xác nhận đăng kí tham gia, sinh viên có thể nhấn hủy tham gia (nếu muốn) trong thời gian qui định của ban tổ chức. </html>");
        roundedPanel1.add(jContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 166, 908, 63));

        jTitle.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jTitle.setForeground(new java.awt.Color(51, 51, 51));
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("Xác nhận đăng kí tham gia cuộc thi");
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        roundedPanel1.add(jTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 532, -1));

        jNo.setText("Hủy");
        jNo.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jNo.setPreferredSize(new java.awt.Dimension(90, 50));
        jNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNoActionPerformed(evt);
            }
        });
        roundedPanel1.add(jNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 251, 147, -1));

        jOk.setText("Xác nhận");
        jOk.setColor(new java.awt.Color(247, 182, 255));
        jOk.setColorClick(new java.awt.Color(237, 153, 231));
        jOk.setColorOver(new java.awt.Color(203, 163, 233));
        jOk.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jOk.setPreferredSize(new java.awt.Dimension(90, 50));
        roundedPanel1.add(jOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 251, 156, -1));

        jIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/check_9068676.png"))); // NOI18N
        roundedPanel1.add(jIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 14, 78, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jContent;
    private javax.swing.JLabel jIcon;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jNo;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jOk;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel jTitle;
    protected com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
