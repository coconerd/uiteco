package com.uiteco.OfCuocThiPanel.secondPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CustomButton extends JButton{

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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
    
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;
    
    public CustomButton(){
        
        //init color for button
        setColor(new Color(247,245,244)); //khi không lia chuột vào
        colorOver = new Color(203,230,239); //khi lia chuột vào
        colorClick = new Color(237,237,237); 
        borderColor = new Color(237,237,237);
        
        //set other properties
        setFocusable(false);
        setOpaque(true); //don't display button's background
        setContentAreaFilled(false); 
        setPreferredSize(new Dimension(90, 45)); //set width and height
        setBorderPainted(false);
        
        //text 
        setForeground(Color.BLACK); //set color for the text inside
        setFont(new Font("Arial", Font.BOLD, 12));
        
        setIconTextGap(10); // Set the gap between the icon and text
        
        //set Border
        setRadius(37);
        
        //Sets the vertical/horizontal position just for text
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        
        //Sets the vertical/horizontal alignment of the icon and text.
        setHorizontalAlignment(SwingConstants.CENTER); 
        setVerticalAlignment(SwingConstants.CENTER); 
        
        //Sets the vertical/horizontal position of the text related to the icon.
        setHorizontalTextPosition(SwingConstants.RIGHT); 
        setVerticalTextPosition(SwingConstants.CENTER); 
        
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
                    //over is true means press button
                    setBackground(colorOver);
                }else{
                    setBackground(color);
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) { //is called whenever the button needs to be repainted
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
        g2.setColor(getBackground()); //g2.setColor(color); ko duoc
        
        //This draws the background color of the button, but with a 2-pixel gap between the edge of the background color and the border
        g2.fillRoundRect(0, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        
        super.paintComponent(grphcs);
    }

}
   