/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo.Calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

public class NotificationsEvent extends javax.swing.JPanel {

    private int footer = 6;
    private int TextHeight = 16;
    private int width = 219, height = 64 + TextHeight * 1;
    
    private float MinX = (float) (footer * Math.sqrt(2) + footer / 2) + 5;
    private float MaxX = (float) (width - footer * Math.sqrt(2) - footer / 2) - 5;
    
    private float Xfooter = (MaxX + MinX) / 2;
    
    public NotificationsEvent() {
        Start();
    }
    
    public NotificationsEvent(float pos) {        
        Xfooter = MinX + pos * (MaxX - MinX) / 6;

        Start();
    }
    
    public NotificationsEvent(int width, int height){
        this.width = width;
        this.height = height;
        
        Start();
    }
    
    public NotificationsEvent(int width, int height, float pos){
        Xfooter = MinX + pos * (MaxX - MinX) / 6;
        this.width = width;
        this.height = height;
        
        Start();
    }

    private void Start()  
    {
        initComponents();
        setOpaque(false);
        this.setPreferredSize(new Dimension(width, height));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(80, 80, 80));
        setForeground(new java.awt.Color(0, 0, 0));
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(215, 215, 215));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thứ, Ngày, Tháng, Năm ");

        jTextArea2.setBackground(new java.awt.Color(80, 80, 80));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(227, 227, 227));
        jTextArea2.setRows(1);
        jTextArea2.setText("Nội dung");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextArea2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g)
    {
        
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(80,80,80));
        
        AffineTransform tran = new AffineTransform();
        tran.translate(Xfooter, getHeight() - footer * 2 * Math.sqrt(2));
        tran.rotate(Math.toRadians(45));
        Path2D p = new Path2D.Double(new RoundRectangle2D.Double(0, 0, footer * 2, footer * 2, 3, 3), tran);
        Area AreaComponent  = new Area(p);
        AreaComponent.add(new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight() - footer, 15, 15)));
        g2.fill(AreaComponent);
        g2.dispose();
        
        this.repaint();
        
        super.paintComponent(g);
    }
    
    public float getXfooter()
    {
        return Xfooter;
    }
    
    public int getwidth()
    {
        return width;
    }
    
    public int getheight()
    {
        return height;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
