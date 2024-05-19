package com.uiteco.OfCuocThiPanel.firstPage;

import java.awt.Color;
import java.util.List;

public class OnePost_View extends javax.swing.JPanel {

    /**
     * @return the postID
     */
    public int getPostID() {
        return postID;
    }

    /**
     * @param postID the postID to set
     */
    public void setPostID(int postID) {
        this.postID = postID;
    }


    /**
     * @return the countLike
     */
    public javax.swing.JLabel getCountLike() {
        return jCountLike;
    }

    /**
     * @return the labelDaysLeft1
     */
    public com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft getLabelDaysLeft1() {
        return labelDaysLeft1;
    }

    /**
     * @return the roundPanel_Parent
     */
    public com.uiteco.components.RoundedPanel getRoundPanel_Parent() {
        return roundPanel_Parent;
    }

    /**
     * @return the jDateRange
     */
    public javax.swing.JLabel getjDateRange() {
        return jDateRange;
    }

    /**
     * @return the jImage
     */
    public com.uiteco.components.RoundedImagePanel getjImage() {
        return jImage;
    }

    /**
     * @return the jOrganizer
     */
    public javax.swing.JLabel getjOrganizer() {
        return jOrganizer;
    }

    /**
     * @return the jPanelContainTags
     */
    public javax.swing.JPanel getjPanelContainTags() {
        return jPanelContainTags;
    }

    /**
     * @return the jSeparator
     */
    public javax.swing.JSeparator getjSeparator() {
        return jSeparator;
    }

    /**
     * @return the jTagsIcon
     */
    public javax.swing.JLabel getjTagsIcon() {
        return jTagsIcon;
    }

    /**
     * @return the jTitle
     */
    public javax.swing.JLabel getjTitle() {
        return jTitle;
    }

    /**
     * @return the jType
     */
    public javax.swing.JLabel getjType() {
        return jType;
    }

    /**
     * @param countLike the countLike to set
     */
    public void setCountLike(javax.swing.JLabel countLike) {
        this.jCountLike = countLike;
    }

    /**
     * @param labelDaysLeft1 the labelDaysLeft1 to set
     */
    public void setLabelDaysLeft1(com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1) {
        this.labelDaysLeft1 = labelDaysLeft1;
    }

    /**
     * @param roundPanel_Parent the roundPanel_Parent to set
     */
    public void setRoundPanel_Parent(com.uiteco.components.RoundedPanel roundPanel_Parent) {
        this.roundPanel_Parent = roundPanel_Parent;
    }

    /**
     * @param jDateRange the jDateRange to set
     */
    public void setjDateRange(javax.swing.JLabel jDateRange) {
        this.jDateRange = jDateRange;
    }

    /**
     * @param jImage the jImage to set
     */
    public void setjImage(com.uiteco.components.RoundedImagePanel jImage) {
        this.jImage = jImage;
    }

    /**
     * @param jOrganizer the jOrganizer to set
     */
    public void setjOrganizer(javax.swing.JLabel jOrganizer) {
        this.jOrganizer = jOrganizer;
    }

    /**
     * @param jPanelContainTags the jPanelContainTags to set
     */
    public void setjPanelContainTags(javax.swing.JPanel jPanelContainTags) {
        this.jPanelContainTags = jPanelContainTags;
    }

    /**
     * @param jSeparator the jSeparator to set
     */
    public void setjSeparator(javax.swing.JSeparator jSeparator) {
        this.jSeparator = jSeparator;
    }

    /**
     * @param jTagsIcon the jTagsIcon to set
     */
    public void setjTagsIcon(javax.swing.JLabel jTagsIcon) {
        this.jTagsIcon = jTagsIcon;
    }

    /**
     * @param jTitle the jTitle to set
     */
    public void setjTitle(javax.swing.JLabel jTitle) {
        this.jTitle = jTitle;
    }

    /**
     * @param jType the jType to set
     */
    public void setjType(javax.swing.JLabel jType) {
        this.jType = jType;
    }

    
    public void setDaysLeft(String status) {
        if (status != null) {
            if (status.startsWith("Còn ")) {
                getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 158, 128));
                getLabelDaysLeft1().jLabel1.setText(status);

            } else if (status.startsWith("Dang ")) {
                getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 213, 127));
                getLabelDaysLeft1().jLabel1.setText(status);
                
            } else if (status.startsWith("Het ")) {
                getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 209, 220));
                getLabelDaysLeft1().jLabel1.setText(status);
            }

            getLabelDaysLeft1().revalidate();
            getLabelDaysLeft1().repaint();
        }
    }
    
    public void setTagsUI(List<String> tags) {
        //display on panel the number of tags which a post has (based on database)
        for (String tagText : tags) {
            LabelTag tagLabel = new LabelTag();
            tagLabel.jLabel_TagName.setText(tagText);
            getjPanelContainTags().add(tagLabel);
        }

        getjPanelContainTags().revalidate();
        getjPanelContainTags().repaint();
    }

    public OnePost_View() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel_Parent = new com.uiteco.components.RoundedPanel();
        jTitle = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTagsIcon = new javax.swing.JLabel();
        jImage = new com.uiteco.components.RoundedImagePanel();
        jType = new javax.swing.JLabel();
        labelDaysLeft1 = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();
        jPanelContainTags = new javax.swing.JPanel();
        jCountLike = new javax.swing.JLabel();

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

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 23)); // NOI18N
        jTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTitleMousePressed(evt);
            }
        });

        jOrganizer.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("fefe");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("gewrgwrg");
        jDateRange.setIconTextGap(10);

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

        jPanelContainTags.setBackground(new java.awt.Color(204, 204, 0));
        jPanelContainTags.setOpaque(false);
        jPanelContainTags.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 13, 12));

        jCountLike.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jCountLike.setForeground(new java.awt.Color(51, 51, 51));
        jCountLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-heart-24.png"))); // NOI18N
        jCountLike.setText("3");
        jCountLike.setIconTextGap(6);

        javax.swing.GroupLayout roundPanel_ParentLayout = new javax.swing.GroupLayout(roundPanel_Parent);
        roundPanel_Parent.setLayout(roundPanel_ParentLayout);
        roundPanel_ParentLayout.setHorizontalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jCountLike))
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
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
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCountLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDaysLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jType)
                .addGap(18, 18, 18)
                .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        );

        add(roundPanel_Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void jTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTitleMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTitleMousePressed
    
    protected int postID; 
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
    protected com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1;
    protected com.uiteco.components.RoundedPanel roundPanel_Parent;
    // End of variables declaration//GEN-END:variables
}
