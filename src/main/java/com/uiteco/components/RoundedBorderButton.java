package com.uiteco.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FontMetrics;
import java.awt.Rectangle;

public class RoundedBorderButton extends JButton{
    private Color borderColor;
    public RoundedBorderButton(){
        super();
        borderColor = getBackground();
        setContentAreaFilled(false); // Táº¯t viá»‡c váº½ hÃ¬nh chá»¯ nháº­t bÃªn ngoÃ i button
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                borderColor = Color.BLACK;
                repaint();
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                borderColor = getBackground();
                repaint();
            }
        });
    }
    public RoundedBorderButton(String text){
        super(text);
        borderColor = getBackground();
        setContentAreaFilled(false); // Táº¯t viá»‡c váº½ hÃ¬nh chá»¯ nháº­t bÃªn ngoÃ i button
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                borderColor = Color.BLACK;
                repaint();
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                borderColor = getBackground();
                repaint();
            }
        });
    }

//    @Override //hÃ m override nÃ y sá»­ dá»¥ng hÃ m paint Ä‘á»ƒ váº½, sá»­ dá»¥ng fillRoundRect váº½ Ä‘Æ°á»£c cáº£ ná»n láº«n viá»n, tuy nhiÃªn Ä‘Æ°á»ng viá»n sáº½ Ä‘áº­m hÆ¡n
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g.create(); // Chuyá»ƒn Ä‘á»•i Graphics sang Graphics2D
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//
//        super.paint(g2d);
//        
//        // Váº½ viá»n bo trÃ²n cho nÃºt
//        g2d.setColor(borderColor);
//        int arcWidth = 13;
//        int arcHeight = 13;
//        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
//        g2d.setColor(getBackground());
//        g2d.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, arcWidth, arcHeight);
//
//        // Láº¥y kÃ­ch thÆ°á»›c cá»§a vÄƒn báº£n vÃ  icon
//        FontMetrics fm = g2d.getFontMetrics();
//        Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
//        int textWidth = textBounds.width;
//        int textHeight = textBounds.height;
//        int iconWidth = (getIcon() != null) ? getIcon().getIconWidth() : 0;
//        int iconHeight = (getIcon() != null) ? getIcon().getIconHeight() : 0;
//
//        // TÃ­nh toÃ¡n vá»‹ trÃ­ Ä‘á»ƒ cÄƒn chá»‰nh vÄƒn báº£n vÃ  icon
//        float textX = (getWidth() - textWidth)/1.5f;
//        int textY = (getHeight() - textHeight) / 2 + fm.getAscent();
//        int iconX = (getWidth() - iconWidth - textWidth)/4; // CÄƒn giá»¯a icon vÃ  text
//        int iconY = (getHeight() - iconHeight) / 2;
//
//        // Váº½ vÄƒn báº£n vÃ  icon
//        g2d.setColor(getForeground());
//        if (getIcon() != null) {
//            getIcon().paintIcon(this, g2d, iconX, iconY);
//        }
//        g2d.drawString(getText(), textX, textY);
//
//        g2d.dispose(); // Giáº£i phÃ³ng Ä‘á»‘i tÆ°á»£ng Graphics2D
//    }
    
    @Override //hÃ m override nÃ y sá»­ dá»¥ng hÃ m paintComponent, káº¿t há»£p dÃ¹ng fillRoundRect Ä‘á»ƒ váº½ ná»n vÃ  dÃ¹ng drawRoundRect Ä‘á»ƒ váº½ Ä‘Æ°á»ng viá»n, Ä‘Æ°á»ng viá»n cÃ³ thá»ƒ thay Ä‘á»•i Ä‘Æ°á»£c Ä‘á»™ dÃ y Ä‘áº­m hay máº£nh nháº¡t
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create(); // Chuyá»ƒn Ä‘á»•i Graphics sang Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        super.paintComponent(g2d);
        
        
         // Váº½ ná»n cá»§a button
        g2d.setColor(getBackground());
        int arcWidth = 12;
        int arcHeight = 12;
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Thiáº¿t láº­p Ä‘Æ°á»ng viá»n cho viá»n bÃªn ngoÃ i
        float strokeWidth = 2.0f; // Äá»™ dÃ y cá»§a viá»n
        g2d.setStroke(new java.awt.BasicStroke(strokeWidth));
        g2d.setColor(borderColor);

        // Váº½ viá»n bÃªn ngoÃ i
        g2d.drawRoundRect(0, 0, getWidth(), getHeight()-1, arcWidth, arcHeight);

        // Láº¥y kÃ­ch thÆ°á»›c cá»§a vÄƒn báº£n vÃ  icon
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
        int textWidth = textBounds.width;
        int textHeight = textBounds.height;
        int iconWidth = (getIcon() != null) ? getIcon().getIconWidth() : 0;
        int iconHeight = (getIcon() != null) ? getIcon().getIconHeight() : 0;

        // TÃ­nh toÃ¡n vá»‹ trÃ­ Ä‘á»ƒ cÄƒn chá»‰nh vÄƒn báº£n vÃ  icon
        float textX = (getWidth() - textWidth)/1.5f;
        int textY = (getHeight() - textHeight) / 2 + fm.getAscent();
        int iconX = (getWidth() - iconWidth - textWidth)/4; // CÄƒn giá»¯a icon vÃ  text
        int iconY = (getHeight() - iconHeight) / 2;

        // Váº½ vÄƒn báº£n vÃ  icon
        g2d.setColor(getForeground());
        if (getIcon() != null) {
            getIcon().paintIcon(this, g2d, iconX, iconY);
        }
        g2d.drawString(getText(), textX, textY);

        g2d.dispose(); // Giáº£i phÃ³ng Ä‘á»‘i tÆ°á»£ng Graphics2D
    }
}
