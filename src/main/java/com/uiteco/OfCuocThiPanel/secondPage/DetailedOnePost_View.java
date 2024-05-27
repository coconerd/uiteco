package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;

public class DetailedOnePost_View extends javax.swing.JPanel {

    /**
     * @return the scrollPaneImages
     */
    public com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages getScrollPaneImages() {
        return scrollPaneImages;
    }

    public DetailedOnePost_View() {
        initComponents();
    }
    
    public DetailedOnePost_Controller createController(BriefPost_Model model) {
        this.controller = new DetailedOnePost_Controller(this, model);
        return getController();
    }
    public DetailedOnePost_Controller getController() {
        return controller;
    }

    private DetailedOnePost_Controller controller;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTop = new javax.swing.JPanel();
        RegisterTimePanel = new com.uiteco.components.RoundedPanel();
        jRegisterTime = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jBody = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        jBelowTitle = new javax.swing.JPanel();
        iconOrganization = new javax.swing.JLabel();
        jPostTime = new javax.swing.JLabel();
        jLike = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        bookmarkButton = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        like = new javax.swing.JLabel();
        bookmark = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jContent = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        youtubePlay = new com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay();
        scrollPaneImages = new com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages();
        roundedGradientPanel = new com.uiteco.components.RoundedGradientPanel();

        setBackground(new java.awt.Color(204, 255, 204));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jTop.setBackground(new java.awt.Color(255, 153, 153));
        jTop.setPreferredSize(new java.awt.Dimension(1190, 370));
        jTop.setLayout(new java.awt.GridBagLayout());

        RegisterTimePanel.setPreferredSize(new java.awt.Dimension(1000, 100));
        RegisterTimePanel.setRoundBottomLeft(50);
        RegisterTimePanel.setRoundBottomRight(50);
        RegisterTimePanel.setRoundTopLeft(50);
        RegisterTimePanel.setRoundTopRight(50);
        RegisterTimePanel.setLayout(new java.awt.GridBagLayout());

        jRegisterTime.setFont(new java.awt.Font("Merriweather", 1, 34)); // NOI18N
        jRegisterTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRegisterTime.setText("<code>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(36, 405, 32, 401);
        RegisterTimePanel.add(jRegisterTime, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.025;
        gridBagConstraints.insets = new java.awt.Insets(0, 150, 20, 150);
        jTop.add(RegisterTimePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(jTop, gridBagConstraints);

        jScrollPane.setBackground(new java.awt.Color(242, 243, 244));
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new java.awt.Dimension(1190, 630));

        jBody.setBackground(new java.awt.Color(102, 255, 102));
        jBody.setOpaque(false);
        jBody.setLayout(new java.awt.GridBagLayout());

        jTitle.setFont(new java.awt.Font("Merriweather", 1, 40)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 40, 0);
        jBody.add(jTitle, gridBagConstraints);

        jBelowTitle.setBackground(new java.awt.Color(242, 243, 244));
        jBelowTitle.setOpaque(false);
        jBelowTitle.setPreferredSize(new java.awt.Dimension(1160, 100));
        jBelowTitle.setLayout(new java.awt.GridBagLayout());

        iconOrganization.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-company-64.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        jBelowTitle.add(iconOrganization, gridBagConstraints);

        jPostTime.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 27, 5, 30);
        jBelowTitle.add(jPostTime, gridBagConstraints);

        jLike.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 1, 1));
        jLike.setText("LIKE");
        jLike.setColor(new java.awt.Color(242, 243, 245));
        jLike.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        jLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLikeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 8, 6);
        jBelowTitle.add(jLike, gridBagConstraints);

        bookmarkButton.setBackground(new java.awt.Color(242, 243, 244));
        bookmarkButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 1, 1));
        bookmarkButton.setText("BOOKMARK");
        bookmarkButton.setColor(new java.awt.Color(242, 243, 244));
        bookmarkButton.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        bookmarkButton.setPreferredSize(new java.awt.Dimension(145, 45));
        bookmarkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookmarkButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 25);
        jBelowTitle.add(bookmarkButton, gridBagConstraints);

        jRegister.setBackground(new java.awt.Color(85, 146, 213));
        jRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 1, 1));
        jRegister.setForeground(new java.awt.Color(255, 255, 255));
        jRegister.setText("ĐĂNG KÍ");
        jRegister.setFont(new java.awt.Font("Merriweather", 1, 19)); // NOI18N
        jRegister.setPreferredSize(new java.awt.Dimension(160, 55));
        jRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRegisterMousePressed(evt);
            }
        });
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 45);
        jBelowTitle.add(jRegister, gridBagConstraints);

        like.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-like-50.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jBelowTitle.add(like, gridBagConstraints);

        bookmark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/bookmark_10969413.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jBelowTitle.add(bookmark, gridBagConstraints);

        jOrganizer.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(12, 27, 12, 30);
        jBelowTitle.add(jOrganizer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(32, 135, 60, 88);
        jBody.add(jBelowTitle, gridBagConstraints);

        jContent.setEditable(false);
        jContent.setColumns(1);
        jContent.setFont(new java.awt.Font("Segoe UI", 0, 29)); // NOI18N
        jContent.setLineWrap(true);
        jContent.setWrapStyleWord(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 237, 167, 152);
        jBody.add(jContent, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Merriweather", 1, 31)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 99, 213));
        jLabel2.setText("H  Ì  N  H    Ả  N  H    N  Ổ  I    B  Ậ  T");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 155, 11, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(199, 204, 242));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 7));
        jSeparator2.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 2.8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 65);
        jPanel1.add(jSeparator2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 44);
        jBody.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Merriweather", 1, 31)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(85, 99, 213));
        jLabel1.setText("T  Ì  M   H  I  Ể  U   T  H  Ê  M   V Ề   C  U  Ộ  C    T  H  I");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 155, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jSeparator3.setForeground(new java.awt.Color(199, 204, 242));
        jSeparator3.setPreferredSize(new java.awt.Dimension(0, 7));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 2.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 65);
        jPanel2.add(jSeparator3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 44);
        jBody.add(jPanel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(70, 0, 70, 1160);
        jBody.add(youtubePlay, gridBagConstraints);

        scrollPaneImages.setPreferredSize(new java.awt.Dimension(1600, 530));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(50, 172, 70, 50);
        jBody.add(scrollPaneImages, gridBagConstraints);

        roundedGradientPanel.setPreferredSize(new java.awt.Dimension(600, 380));
        roundedGradientPanel.setRoundBottomLeft(35);
        roundedGradientPanel.setRoundBottomRight(35);
        roundedGradientPanel.setRoundTopLeft(35);
        roundedGradientPanel.setRoundTopRight(35);

        javax.swing.GroupLayout roundedGradientPanelLayout = new javax.swing.GroupLayout(roundedGradientPanel);
        roundedGradientPanel.setLayout(roundedGradientPanelLayout);
        roundedGradientPanelLayout.setHorizontalGroup(
            roundedGradientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        roundedGradientPanelLayout.setVerticalGroup(
            roundedGradientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jBody.add(roundedGradientPanel, gridBagConstraints);

        jScrollPane.setViewportView(jBody);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 11.0;
        add(jScrollPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRegisterActionPerformed

    private void bookmarkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookmarkButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookmarkButtonActionPerformed

    private void jLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLikeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLikeActionPerformed

    private void jRegisterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRegisterMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRegisterMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.components.RoundedPanel RegisterTimePanel;
    private javax.swing.JLabel bookmark;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton bookmarkButton;
    private javax.swing.JLabel iconOrganization;
    private javax.swing.JPanel jBelowTitle;
    private javax.swing.JPanel jBody;
    protected javax.swing.JTextArea jContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jLike;
    protected javax.swing.JLabel jOrganizer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    protected javax.swing.JLabel jPostTime;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jRegister;
    protected javax.swing.JLabel jRegisterTime;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    protected javax.swing.JLabel jTitle;
    private javax.swing.JPanel jTop;
    private javax.swing.JLabel like;
    private com.uiteco.components.RoundedGradientPanel roundedGradientPanel;
    protected com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages scrollPaneImages;
    private com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay youtubePlay;
    // End of variables declaration//GEN-END:variables
}
