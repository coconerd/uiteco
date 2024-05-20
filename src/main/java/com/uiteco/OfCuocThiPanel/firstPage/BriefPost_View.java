package com.uiteco.OfCuocThiPanel.firstPage;

import java.awt.Color;

public class BriefPost_View extends javax.swing.JPanel {

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


    public javax.swing.JLabel getCountLike() {
        return jCountLike;
    }

    public com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft getLabelDaysLeft1() {
        return labelDaysLeft1;
    }

    public com.uiteco.components.RoundedPanel getRoundPanel_Parent() {
        return roundPanel_Parent;
    }

    public javax.swing.JLabel getjDateRange() {
        return jDateRange;
    }

    public com.uiteco.components.RoundedImagePanel getjImage() {
        return jImage;
    }

    public javax.swing.JLabel getjOrganizer() {
        return jOrganizer;
    }

    public javax.swing.JPanel getjPanelContainTags() {
        return jPanelContainTags;
    }

    public javax.swing.JSeparator getjSeparator() {
        return jSeparator;
    }

    public javax.swing.JLabel getjTagsIcon() {
        return jTagsIcon;
    }

    public javax.swing.JLabel getjType() {
        return jType;
    }

    public void setCountLike(javax.swing.JLabel countLike) {
        this.jCountLike = countLike;
    }

    public void setLabelDaysLeft1(com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1) {
        this.labelDaysLeft1 = labelDaysLeft1;
    }

    public void setRoundPanel_Parent(com.uiteco.components.RoundedPanel roundPanel_Parent) {
        this.roundPanel_Parent = roundPanel_Parent;
    }
    
    public void setjDateRange(javax.swing.JLabel jDateRange) {
        this.jDateRange = jDateRange;
    }
    
    public void setjImage(com.uiteco.components.RoundedImagePanel jImage) {
        this.jImage = jImage;
    }
    
    public void setjOrganizer(javax.swing.JLabel jOrganizer) {
        this.jOrganizer = jOrganizer;
    }
    
    public void setjPanelContainTags(javax.swing.JPanel jPanelContainTags) {
        this.jPanelContainTags = jPanelContainTags;
    }
    
    public void setjSeparator(javax.swing.JSeparator jSeparator) {
        this.jSeparator = jSeparator;
    }
    
    public void setjTagsIcon(javax.swing.JLabel jTagsIcon) {
        this.jTagsIcon = jTagsIcon;
    }
    
    public void setjType(javax.swing.JLabel jType) {
        this.jType = jType;
    }

    public BriefPost_View() {
        initComponents();
        setOpaque(false);
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel_Parent = new com.uiteco.components.RoundedPanel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTagsIcon = new javax.swing.JLabel();
        jImage = new com.uiteco.components.RoundedImagePanel();
        jType = new javax.swing.JLabel();
        labelDaysLeft1 = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();
        jPanelContainTags = new javax.swing.JPanel();
        jCountLike = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1150, 240));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1160, 240));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel_Parent.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel_Parent.setOpaque(true);
        roundPanel_Parent.setPreferredSize(new java.awt.Dimension(1160, 240));
        roundPanel_Parent.setRoundBottomLeft(25);
        roundPanel_Parent.setRoundBottomRight(25);
        roundPanel_Parent.setRoundTopLeft(25);
        roundPanel_Parent.setRoundTopRight(25);

        jOrganizer.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("fefe");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("gewrgwrg");
        jDateRange.setIconTextGap(13);

        jTagsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-tag-24.png"))); // NOI18N
        jTagsIcon.setText("jLabel1");

        jImage.setBackground(new java.awt.Color(255, 255, 255));
        jImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/medium_square.png"))); // NOI18N
        jImage.setMinimumSize(new java.awt.Dimension(200, 200));
        jImage.setPreferredSize(new java.awt.Dimension(200, 200));
        jImage.setRoundBottomLeft(20);
        jImage.setRoundBottomRight(20);
        jImage.setRoundTopLeft(20);
        jImage.setRoundTopRight(20);

        javax.swing.GroupLayout jImageLayout = new javax.swing.GroupLayout(jImage);
        jImage.setLayout(jImageLayout);
        jImageLayout.setHorizontalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jImageLayout.setVerticalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jType.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-global-24.png"))); // NOI18N
        jType.setText("fvsdf");

        labelDaysLeft1.setPreferredSize(new java.awt.Dimension(110, 30));

        jPanelContainTags.setBackground(new java.awt.Color(204, 204, 0));
        jPanelContainTags.setOpaque(false);
        jPanelContainTags.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 13, 12));

        jCountLike.setForeground(new java.awt.Color(51, 51, 51));
        jCountLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-heart-24.png"))); // NOI18N
        jCountLike.setIconTextGap(6);

        jTitle.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jTitle.setText("jLabel1");
        jTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));
        jTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTitleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTitleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTitleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTitleMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel_ParentLayout = new javax.swing.GroupLayout(roundPanel_Parent);
        roundPanel_Parent.setLayout(roundPanel_ParentLayout);
        roundPanel_ParentLayout.setHorizontalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCountLike))
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateRange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        roundPanel_ParentLayout.setVerticalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCountLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDaysLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jType)
                        .addGap(18, 18, 18)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(roundPanel_Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void jTitleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTitleMouseEntered
        // TODO add your handling code here:
        jTitle.setForeground(new Color(90, 116, 214));
    }//GEN-LAST:event_jTitleMouseEntered

    private void jTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTitleMousePressed
        // TODO add your handling code here:
        jTitle.setForeground(new Color(90, 116, 214));
    }//GEN-LAST:event_jTitleMousePressed

    private void jTitleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTitleMouseReleased
        // TODO add your handling code here
    }//GEN-LAST:event_jTitleMouseReleased

    private void jTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTitleMouseExited
        // TODO add your handling code here:
        jTitle.setForeground(new Color(30, 30, 30));
    }//GEN-LAST:event_jTitleMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jCountLike;
    protected javax.swing.JLabel jDateRange;
    protected com.uiteco.components.RoundedImagePanel jImage;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JPanel jPanelContainTags;
    protected javax.swing.JSeparator jSeparator;
    protected javax.swing.JLabel jTagsIcon;
    protected javax.swing.JLabel jTitle;
    protected javax.swing.JLabel jType;
    private com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1;
    protected com.uiteco.components.RoundedPanel roundPanel_Parent;
    // End of variables declaration//GEN-END:variables
}
