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
import javax.swing.JPanel;

public class NotificationsEvent extends javax.swing.JPanel {

    private JPanel parentPanel;
    private int x = 0, y = 0;
    
    private int footer = 6;
    
    private float MinX;
    private float MaxX;
    private float pos = -1;
    private float Xfooter;
    
    public NotificationsEvent() {
        Start();
    }
    
    public NotificationsEvent(float pos) {        
        this.pos = pos;
        Start();
    }

    private void Start()  
    {
        initComponents();
        setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HeadText = new javax.swing.JLabel();
        BodyText = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(80, 80, 80));
        setForeground(new java.awt.Color(0, 0, 0));
        setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(215, 215, 215));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeadText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HeadText.setForeground(new java.awt.Color(255, 255, 255));
        HeadText.setText("Thứ, Ngày, Tháng, Năm ");

        BodyText.setBackground(new java.awt.Color(80, 80, 80));
        BodyText.setColumns(20);
        BodyText.setForeground(new java.awt.Color(227, 227, 227));
        BodyText.setLineWrap(true);
        BodyText.setRows(1);
        BodyText.setText("Nội dung");
        BodyText.setWrapStyleWord(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HeadText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BodyText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(HeadText)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BodyText)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g)
    {        
        MinX = (float) (footer * Math.sqrt(2) + footer / 2) + 5;
        MaxX = (float) (this.getWidth() - footer * Math.sqrt(2) - footer / 2) - 5;
        if(pos == -1)
            Xfooter = (MaxX + MinX) / 2;
        else
            Xfooter = MinX + pos * (MaxX - MinX) / 6;
        
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
        
//        this.repaint();
        
        if(parentPanel != null)
        {    
            parentPanel.add(this, new org.netbeans.lib.awtextra.AbsoluteConstraints(x - (int) this.getXfooter(), y - this.getHeight() + 2, -1, -1), 0);
            parentPanel.repaint();
            this.repaint();
        }
        
        super.paintComponent(g);
    }
    
    public void setBodyText(String Text)
    {
        BodyText.setText(Text);
    }
    
    public void setHeadText(String Text)
    {
        HeadText.setText(Text);
    }
    
    public void setXfooter(float Xfooter)
    {
        this.Xfooter = Xfooter;
    }
    
    public float getXfooter()
    {
        return Xfooter;
    }
    
    public void setparentPanel(JPanel parent, int x, int y)
    {
        parentPanel = parent;
        this.x = x;
        this.y = y;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BodyText;
    private javax.swing.JLabel HeadText;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
