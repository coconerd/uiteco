/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo;

import java.awt.geom.RoundRectangle2D;


/**
 *
 * @author Acer
 */
public class HeaderCLB extends javax.swing.JPanel {

    /**
     * Creates new form HeaderCLB
     */
    public HeaderCLB() {
        Start();
        
        this.setOpaque(false);
        this.setBorder(new javax.swing.border.EmptyBorder(7, 5 ,7 ,5));
    }

    public HeaderCLB(int NumberCLUB, int NumberEvent, int NumberOnline, int NumberOffline) {
        Start();
        
        NumberCLB.setText("" + NumberCLUB);
        EvePanel.setText(NumberEvent + " Sự kiện");
        OnlPanel.setText(NumberOnline + " Hoạt động");
        OffPanel.setText(NumberOffline + " Không hoạt động");
        InfoHeader.setBackground(this.getBackground());
//        this.setBackground(java.awt.Color.red);
    }
    
    private void Start()
    {
        initComponents();
        this.setOpaque(false);
//        this.setBorder(new javax.swing.border.EmptyBorder(7, 5 ,7 ,5));
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics grphcs)
    {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) grphcs.create();
        
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
  
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleHeaderCLB = new javax.swing.JLabel();
        InfoHeader = new javax.swing.JTextPane();
        NumberCLB = new javax.swing.JLabel();
        EvePanel = new javax.swing.JLabel();
        OnlPanel = new javax.swing.JLabel();
        OffPanel = new javax.swing.JLabel();
        TitleNumberCLB = new javax.swing.JLabel();

        setBackground(new java.awt.Color(65, 65, 65));
        setFocusable(false);

        TitleHeaderCLB.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        TitleHeaderCLB.setForeground(new java.awt.Color(89, 155, 255));
        TitleHeaderCLB.setText("WELCOME TO UIT CLUB");

        InfoHeader.setBackground(new java.awt.Color(65, 65, 65));
        InfoHeader.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InfoHeader.setForeground(new java.awt.Color(218, 218, 218));
        InfoHeader.setText("Nơi kết nối sinh viên, cải thiện kỹ năng và là nơi học thêm những điều mới");

        NumberCLB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NumberCLB.setForeground(new java.awt.Color(255, 102, 0));
        NumberCLB.setText("Number Of CLB ");

        EvePanel.setForeground(new java.awt.Color(224, 134, 0));
        EvePanel.setText("NumberEvent");
        EvePanel.setAutoscrolls(true);

        OnlPanel.setForeground(new java.awt.Color(0, 204, 0));
        OnlPanel.setText("NumberOnline");

        OffPanel.setForeground(new java.awt.Color(186, 186, 186));
        OffPanel.setText("NumberOffline");

        TitleNumberCLB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TitleNumberCLB.setForeground(new java.awt.Color(210, 210, 210));
        TitleNumberCLB.setText("Câu Lạc Bộ hiện tại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NumberCLB)
                                .addGap(7, 7, 7)
                                .addComponent(TitleNumberCLB))
                            .addComponent(InfoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OffPanel)
                            .addComponent(OnlPanel)
                            .addComponent(EvePanel))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleHeaderCLB)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleHeaderCLB)
                        .addGap(2, 2, 2)
                        .addComponent(InfoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EvePanel)
                        .addGap(12, 12, 12)
                        .addComponent(OnlPanel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NumberCLB)
                        .addComponent(TitleNumberCLB))
                    .addComponent(OffPanel))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EvePanel;
    private javax.swing.JTextPane InfoHeader;
    private javax.swing.JLabel NumberCLB;
    private javax.swing.JLabel OffPanel;
    private javax.swing.JLabel OnlPanel;
    private javax.swing.JLabel TitleHeaderCLB;
    private javax.swing.JLabel TitleNumberCLB;
    // End of variables declaration//GEN-END:variables
}
