package com.uiteco.OfCuocThiPanel.components.roundedButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class CustomButton extends JButton{

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius;
   
    public CustomButton(){
        //init color
        setColor(Color.WHITE);
        colorOver = new Color(203,230,239);
        colorClick = new Color(237,237,237);
        borderColor = Color.WHITE;
        
        setPreferredSize(new Dimension(70, 37)); //set width and height for buttons
        setFocusable(false);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        setRadius(20);
        setContentAreaFilled(true);
        
        //add event mouse
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){ //lia chuột vào button
                setBackground(colorOver);
                over = true;
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                setBackground(color);
                over = false;
            }
            
            @Override
            public void mousePressed(MouseEvent me){ //click button
                setBackground(colorClick);
                super.mousePressed(me);
            }
            
            @Override
            public void mouseReleased(MouseEvent me){ //nhấn + thả button 
                if(over){
                    //over is true
                    setBackground(colorOver);
                }else{
                    setBackground(color);
                }
            }
        });
    }
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2=(Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        
        //Border set 2 pix
        g2.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, radius, radius);
        
        super.paintComponent(grphcs);
    }

}
