package com.uiteco.contentPanels.CauLacBo;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Acer
 */
public class ButtonCLB extends JButton{
    private int RoundedCorners = 16;
    
    public ButtonCLB()
    {
        RoundedCorners = 16;
        Start();
    }
    
    public ButtonCLB(int RC)
    {
        RoundedCorners = RC;
        Start();
    }
    
    public void Start()
    {
        this.setContentAreaFilled(false);
//        this.setOpaque(false);
//        this.setBorder(new javax.swing.border.LineBorder(new Color(0,0,0)));
//        this.setVisible(true);
    }
    @Override
    protected void paintComponent(java.awt.Graphics grphcs)
    {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) grphcs.create();
        
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), RoundedCorners, RoundedCorners));
  
        g2.dispose();
        
        super.paintComponent(grphcs);
    }
    
    public void setRoundedCorners(int RoundedCorners)
    {
       this.RoundedCorners = RoundedCorners;
    }
}
