package com.uiteco.OfCuocThiPanel.secondPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.secondPage.GlassPanePopup.GlassPanePopup;
import javax.swing.ImageIcon;

public class DetailedOnePost_View extends javax.swing.JPanel {

    /**
     * @return the jRegisterTime
     */
    public javax.swing.JLabel getjRegisterTime() {
        return jRegisterTime;
    }

    /**
     * @return the scrollPaneImages
     */
    public com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages getScrollPaneImages() {
        return scrollPaneImages;
    }

    public DetailedOnePost_View() {
        FlatMacLightLaf.setup();
        initComponents();
        jScrollPane.setBorder(null);
    }

    public DetailedOnePost_Controller createController(BriefPost_Model model) {
        this.controller = new DetailedOnePost_Controller(this, model);
        return getController();
    }

    public DetailedOnePost_Controller getController() {
        return controller;
    }

    private DetailedOnePost_Controller controller;
    private boolean isLiked = false;

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
        jRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        like = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jContent = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        youtubePlay = new com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay();
        scrollPaneImages = new com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages();

        setBackground(new java.awt.Color(242, 243, 244));
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

        jBody.setBackground(new java.awt.Color(242, 243, 244));
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

        iconOrganization.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-company-80.png"))); // NOI18N

        jPostTime.setText("jLabel2");

        jLike.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 0, 1, 1));
        jLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-facebook-like-35.png"))); // NOI18N
        jLike.setColor(new java.awt.Color(242, 243, 244));
        jLike.setColorClick(new java.awt.Color(242, 243, 244));
        jLike.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        jLike.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLikeActionPerformed(evt);
            }
        });

        jRegister.setBackground(new java.awt.Color(85, 146, 213));
        jRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 1, 1));
        jRegister.setForeground(new java.awt.Color(255, 255, 255));
        jRegister.setText("ĐĂNG KÍ");
        jRegister.setColor(new java.awt.Color(85, 146, 213));
        jRegister.setColorClick(new java.awt.Color(68, 185, 225));
        jRegister.setColorOver(new java.awt.Color(85, 146, 213));
        jRegister.setFont(new java.awt.Font("Merriweather", 1, 19)); // NOI18N
        jRegister.setPreferredSize(new java.awt.Dimension(160, 55));
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });

        jOrganizer.setText("jLabel1");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(199, 182, 241));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(52, 6));

        javax.swing.GroupLayout jBelowTitleLayout = new javax.swing.GroupLayout(jBelowTitle);
        jBelowTitle.setLayout(jBelowTitleLayout);
        jBelowTitleLayout.setHorizontalGroup(
            jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBelowTitleLayout.createSequentialGroup()
                .addComponent(like)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jBelowTitleLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(iconOrganization)
                .addGap(27, 27, 27)
                .addGroup(jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrganizer)
                    .addComponent(jPostTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1155, Short.MAX_VALUE)
                .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLike, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jBelowTitleLayout.setVerticalGroup(
            jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBelowTitleLayout.createSequentialGroup()
                .addComponent(like)
                .addGroup(jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBelowTitleLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconOrganization)
                            .addGroup(jBelowTitleLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jOrganizer)
                                .addGap(19, 19, 19)
                                .addComponent(jPostTime))))
                    .addGroup(jBelowTitleLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBelowTitleLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jBelowTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLike, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        youtubePlay.setPreferredSize(new java.awt.Dimension(500, 380));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(75, 0, 80, 0);
        jBody.add(youtubePlay, gridBagConstraints);

        scrollPaneImages.setPreferredSize(new java.awt.Dimension(1600, 600));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(49, 168, 82, 79);
        jBody.add(scrollPaneImages, gridBagConstraints);

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

        ConfirmPopUp popUp = new ConfirmPopUp();
        GlassPanePopup.showPopup(popUp);

        popUp.getjOk().addActionListener((e) -> {
            //CuocThiDAO.registerCompetition(getController().getBaseModel());
            CuocThiDAO.insertUserRegisterCompetition(getController().getPostID());
            GlassPanePopup.closePopupAll();

            //when press Register, display unregister button 
            jRegister.setVisible(false);
        });

        popUp.getjNo().addActionListener((e) -> {
            popUp.removeAll();
            GlassPanePopup.closePopupAll();
        });

    }//GEN-LAST:event_jRegisterActionPerformed

    private void jLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLikeActionPerformed
        // TODO add your handling code here:
        isLiked = !isLiked;
        if (isLiked) {
            jLike.setIcon(new ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-facebook-like-35 (1).png")));
        } else {
            jLike.setIcon(new ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-facebook-like-35.png")));

        }
        CuocThiDAO.getCountLikePost(controller.getBaseModel());
        jLike.setText(Integer.toString(controller.getBaseModel().countLike));
        jLike.revalidate();
        jLike.repaint();

    }//GEN-LAST:event_jLikeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected com.uiteco.components.RoundedPanel RegisterTimePanel;
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
    private javax.swing.JLabel jRegisterTime;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    protected javax.swing.JLabel jTitle;
    private javax.swing.JPanel jTop;
    private javax.swing.JLabel like;
    protected com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages scrollPaneImages;
    protected com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay youtubePlay;
    // End of variables declaration//GEN-END:variables
}
