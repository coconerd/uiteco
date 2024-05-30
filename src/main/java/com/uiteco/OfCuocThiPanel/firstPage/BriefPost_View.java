package com.uiteco.OfCuocThiPanel.firstPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import com.uiteco.components.RoundedImagePanel;
import com.uiteco.components.RoundedPanel;

public class BriefPost_View extends RoundedPanel {

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
        return labelDaysLeft;
    }

    public com.uiteco.components.RoundedPanel getRoundPanel_Parent() {
        return roundPanel_Parent;
    }

    public javax.swing.JLabel getjDateRange() {
        return jDateRange;
    }

    public RoundedImagePanel getjImage() {
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
        this.labelDaysLeft = labelDaysLeft1;
    }

    public void setRoundPanel_Parent(com.uiteco.components.RoundedPanel roundPanel_Parent) {
        this.roundPanel_Parent = roundPanel_Parent;
    }
    
    public void setjDateRange(javax.swing.JLabel jDateRange) {
        this.jDateRange = jDateRange;
    }
    
    public void setjImage(RoundedImagePanel jImage) {
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
        FlatMacLightLaf.setup();
        initComponents();
        setOpaque(false);
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel_Parent = new com.uiteco.components.RoundedPanel();
        jOrganizer = new javax.swing.JLabel();
        jDateRange = new javax.swing.JLabel();
        jTagsIcon = new javax.swing.JLabel();
        jType = new javax.swing.JLabel();
        jPanelContainTags = new javax.swing.JPanel();
        jCountLike = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();
        jDueDate = new javax.swing.JLabel();
        jImage = new com.uiteco.components.RoundedImagePanel();
        labelDaysLeft = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();
        jSeparator = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1150, 240));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(1160, 240));
        setRoundBottomLeft(30);
        setRoundBottomRight(30);
        setRoundTopLeft(30);
        setRoundTopRight(30);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel_Parent.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel_Parent.setPreferredSize(new java.awt.Dimension(1160, 240));
        roundPanel_Parent.setRoundBottomLeft(25);
        roundPanel_Parent.setRoundBottomRight(25);
        roundPanel_Parent.setRoundTopLeft(25);
        roundPanel_Parent.setRoundTopRight(25);

        jOrganizer.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-organization-28.png"))); // NOI18N
        jOrganizer.setText("fefe");

        jDateRange.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-calendar-28.png"))); // NOI18N
        jDateRange.setText("gewrgwrg");
        jDateRange.setIconTextGap(19);

        jTagsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-tag-29.png"))); // NOI18N
        jTagsIcon.setText("jLabel1");

        jType.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-global-28.png"))); // NOI18N
        jType.setText("fvsdf");

        jPanelContainTags.setBackground(new java.awt.Color(204, 204, 0));
        jPanelContainTags.setOpaque(false);
        jPanelContainTags.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 10, 12));

        jCountLike.setForeground(new java.awt.Color(51, 51, 51));
        jCountLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-heart-28.png"))); // NOI18N
        jCountLike.setIconTextGap(6);

        jTitle.setFont(new java.awt.Font("Merriweather", 1, 16)); // NOI18N
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

        jDueDate.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jDueDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-time-28.png"))); // NOI18N
        jDueDate.setText("jLabel1");
        jDueDate.setIconTextGap(19);

        jImage.setMinimumSize(new java.awt.Dimension(200, 200));
        jImage.setPreferredSize(new java.awt.Dimension(200, 200));
        jImage.setRoundBottomLeft(25);
        jImage.setRoundBottomRight(25);
        jImage.setRoundTopLeft(25);
        jImage.setRoundTopRight(25);

        javax.swing.GroupLayout jImageLayout = new javax.swing.GroupLayout(jImage);
        jImage.setLayout(jImageLayout);
        jImageLayout.setHorizontalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        jImageLayout.setVerticalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        labelDaysLeft.setPreferredSize(new java.awt.Dimension(114, 32));

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout roundPanel_ParentLayout = new javax.swing.GroupLayout(roundPanel_Parent);
        roundPanel_Parent.setLayout(roundPanel_ParentLayout);
        roundPanel_ParentLayout.setHorizontalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                                    .addComponent(labelDaysLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jCountLike)
                                    .addGap(83, 83, 83))
                                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(119, 119, 119)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateRange, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelContainTags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(116, 116, 116)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel_ParentLayout.setVerticalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(labelDaysLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jType))
                            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                                .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jCountLike, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(302, 302, 302)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(roundPanel_Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 240));
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
    protected javax.swing.JLabel jDueDate;
    protected com.uiteco.components.RoundedImagePanel jImage;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JPanel jPanelContainTags;
    private javax.swing.JSeparator jSeparator;
    protected javax.swing.JLabel jTagsIcon;
    protected javax.swing.JLabel jTitle;
    protected javax.swing.JLabel jType;
    private com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft;
    protected com.uiteco.components.RoundedPanel roundPanel_Parent;
    // End of variables declaration//GEN-END:variables
}
