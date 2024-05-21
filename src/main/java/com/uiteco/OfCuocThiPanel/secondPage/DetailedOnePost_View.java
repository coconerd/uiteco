package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_View;

public class DetailedOnePost_View extends BriefPost_View {
    
    private DetailedOnePost_Controller controller;
    
    public DetailedOnePost_Controller createController(BriefPost_Model model){
        this.controller = new DetailedOnePost_Controller(this, model);
        return controller;
    }
    
    public DetailedOnePost_View() {
        initComponents();
        setBounds(10, 0, 1285, 1200);
        setOpaque(true);
        setBorder(null);
        scrollPaneWin111.setBorder(null);
        jParentPanel.setBorder(null);
        //GlassPanePopup.install(this);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneWin111 = new com.raven.scroll.ScrollPaneWin11();
        jParentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBodyPanel = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtons = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jListRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLike = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jPostTime = new javax.swing.JLabel();
        jContent = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        ytPanel = new com.uiteco.OfCuocThiPanel.secondPage.YTPanel();
        topGradientPanel = new com.uiteco.components.GradientPanel();
        RegisterTimePanel = new com.uiteco.components.RoundedPanel();
        jRegisterTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(1185, 1014));

        scrollPaneWin111.setBackground(new java.awt.Color(255, 255, 51));

        jParentPanel.setBackground(new java.awt.Color(242, 243, 244));
        jParentPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1913, Short.MAX_VALUE)
        );

        jParentPanel.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jBodyPanel.setBackground(new java.awt.Color(242, 243, 244));
        jBodyPanel.setPreferredSize(new java.awt.Dimension(1185, 1913));

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 46)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("jLabel1");
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1185, 1265));

        jButtons.setOpaque(false);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 10));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 10));

        jRegister.setBackground(new java.awt.Color(242, 243, 244));
        jRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 1, 1));
        jRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register.png"))); // NOI18N
        jRegister.setText("THAM GIA");
        jRegister.setIconTextGap(4);

        jListRegister.setBackground(new java.awt.Color(242, 243, 244));
        jListRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 1, 1));
        jListRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookmark.png"))); // NOI18N
        jListRegister.setText("DANH SÁCH");
        jListRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jListRegister.setIconTextGap(6);
        jListRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListRegisterActionPerformed(evt);
            }
        });

        jLike.setBackground(new java.awt.Color(242, 243, 244));
        jLike.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.png"))); // NOI18N
        jLike.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jButtonsLayout = new javax.swing.GroupLayout(jButtons);
        jButtons.setLayout(jButtonsLayout);
        jButtonsLayout.setHorizontalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jListRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLike, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jButtonsLayout.setVerticalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jListRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/construction.png"))); // NOI18N

        jOrganizer.setText("jLabel3");

        jPostTime.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPostTime, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jOrganizer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPostTime)))
                .addContainerGap())
        );

        jContent.setEditable(false);
        jContent.setColumns(20);
        jContent.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jContent.setLineWrap(true);
        jContent.setWrapStyleWord(true);
        jContent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jContent.setOpaque(false);
        jContent.setSelectionColor(new java.awt.Color(242, 243, 244));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(20, 1259));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1259, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ytPanelLayout = new javax.swing.GroupLayout(ytPanel);
        ytPanel.setLayout(ytPanelLayout);
        ytPanelLayout.setHorizontalGroup(
            ytPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        ytPanelLayout.setVerticalGroup(
            ytPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ytPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jContent, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ytPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jBodyPanelLayout = new javax.swing.GroupLayout(jBodyPanel);
        jBodyPanel.setLayout(jBodyPanelLayout);
        jBodyPanelLayout.setHorizontalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jBodyPanelLayout.setVerticalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jParentPanel.add(jBodyPanel, java.awt.BorderLayout.PAGE_START);

        scrollPaneWin111.setViewportView(jParentPanel);

        topGradientPanel.setColor1(new java.awt.Color(255, 134, 134));
        topGradientPanel.setColor2(new java.awt.Color(249, 141, 255));
        topGradientPanel.setPreferredSize(new java.awt.Dimension(1185, 300));

        RegisterTimePanel.setBackground(new java.awt.Color(255, 255, 255));
        RegisterTimePanel.setRoundBottomLeft(45);
        RegisterTimePanel.setRoundBottomRight(45);
        RegisterTimePanel.setRoundTopLeft(45);
        RegisterTimePanel.setRoundTopRight(45);

        jRegisterTime.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jRegisterTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRegisterTime.setText("jLabel3");

        javax.swing.GroupLayout RegisterTimePanelLayout = new javax.swing.GroupLayout(RegisterTimePanel);
        RegisterTimePanel.setLayout(RegisterTimePanelLayout);
        RegisterTimePanelLayout.setHorizontalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterTimePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jRegisterTime, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        RegisterTimePanelLayout.setVerticalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegisterTime, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout topGradientPanelLayout = new javax.swing.GroupLayout(topGradientPanel);
        topGradientPanel.setLayout(topGradientPanelLayout);
        topGradientPanelLayout.setHorizontalGroup(
            topGradientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topGradientPanelLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        topGradientPanelLayout.setVerticalGroup(
            topGradientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topGradientPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(topGradientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topGradientPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>                        

    private void jTymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTymActionPerformed

    }//GEN-LAST:event_jTymActionPerformed

    private void jLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLikeActionPerformed
        // TODO add your handling code here:
                                           
    
    }//GEN-LAST:event_jLikeActionPerformed

    private void jListRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jListRegisterActionPerformed
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected com.uiteco.components.RoundedPanel RegisterTimePanel;
    protected javax.swing.JPanel jBodyPanel;
    protected javax.swing.JPanel jButtons;
    protected javax.swing.JTextArea jContent;
    private javax.swing.JLabel jLabel2;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jLike;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton jListRegister;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jParentPanel;
    protected javax.swing.JLabel jPostTime;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jRegister;
    protected javax.swing.JLabel jRegisterTime;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    protected javax.swing.JLabel jTitle;
    protected com.raven.scroll.ScrollPaneWin11 scrollPaneWin111;
    protected com.uiteco.components.GradientPanel topGradientPanel;
    protected com.uiteco.OfCuocThiPanel.secondPage.YTPanel ytPanel;
    // End of variables declaration//GEN-END:variables
}
