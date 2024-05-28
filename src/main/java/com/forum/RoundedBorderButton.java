/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
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
        setContentAreaFilled(false); // Tắt việc vẽ hình chữ nhật bên ngoài button
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
        setContentAreaFilled(false); // Tắt việc vẽ hình chữ nhật bên ngoài button
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

//    @Override //hàm override này sử dụng hàm paint để vẽ, sử dụng fillRoundRect vẽ được cả nền lẫn viền, tuy nhiên đường viền sẽ đậm hơn
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g.create(); // Chuyển đổi Graphics sang Graphics2D
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//
//        super.paint(g2d);
//        
//        // Vẽ viền bo tròn cho nút
//        g2d.setColor(borderColor);
//        int arcWidth = 13;
//        int arcHeight = 13;
//        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
//        g2d.setColor(getBackground());
//        g2d.fillRoundRect(2, 2, getWidth()-4, getHeight()-4, arcWidth, arcHeight);
//
//        // Lấy kích thước của văn bản và icon
//        FontMetrics fm = g2d.getFontMetrics();
//        Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
//        int textWidth = textBounds.width;
//        int textHeight = textBounds.height;
//        int iconWidth = (getIcon() != null) ? getIcon().getIconWidth() : 0;
//        int iconHeight = (getIcon() != null) ? getIcon().getIconHeight() : 0;
//
//        // Tính toán vị trí để căn chỉnh văn bản và icon
//        float textX = (getWidth() - textWidth)/1.5f;
//        int textY = (getHeight() - textHeight) / 2 + fm.getAscent();
//        int iconX = (getWidth() - iconWidth - textWidth)/4; // Căn giữa icon và text
//        int iconY = (getHeight() - iconHeight) / 2;
//
//        // Vẽ văn bản và icon
//        g2d.setColor(getForeground());
//        if (getIcon() != null) {
//            getIcon().paintIcon(this, g2d, iconX, iconY);
//        }
//        g2d.drawString(getText(), textX, textY);
//
//        g2d.dispose(); // Giải phóng đối tượng Graphics2D
//    }
    
    @Override //hàm override này sử dụng hàm paintComponent, kết hợp dùng fillRoundRect để vẽ nền và dùng drawRoundRect để vẽ đường viền, đường viền có thể thay đổi được độ dày đậm hay mảnh nhạt
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create(); // Chuyển đổi Graphics sang Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        super.paintComponent(g2d);
        
        
         // Vẽ nền của button
        g2d.setColor(getBackground());
        int arcWidth = 12;
        int arcHeight = 12;
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Thiết lập đường viền cho viền bên ngoài
        float strokeWidth = 2.0f; // Độ dày của viền
        g2d.setStroke(new java.awt.BasicStroke(strokeWidth));
        g2d.setColor(borderColor);

        // Vẽ viền bên ngoài
        g2d.drawRoundRect(0, 0, getWidth(), getHeight()-1, arcWidth, arcHeight);

        // Lấy kích thước của văn bản và icon
        FontMetrics fm = g2d.getFontMetrics();
        Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
        int textWidth = textBounds.width;
        int textHeight = textBounds.height;
        int iconWidth = (getIcon() != null) ? getIcon().getIconWidth() : 0;
        int iconHeight = (getIcon() != null) ? getIcon().getIconHeight() : 0;

        // Tính toán vị trí để căn chỉnh văn bản và icon
        float textX = (getWidth() - textWidth)/1.5f;
        int textY = (getHeight() - textHeight) / 2 + fm.getAscent();
        int iconX = (getWidth() - iconWidth - textWidth)/4; // Căn giữa icon và text
        int iconY = (getHeight() - iconHeight) / 2;

        // Vẽ văn bản và icon
        g2d.setColor(getForeground());
        if (getIcon() != null) {
            getIcon().paintIcon(this, g2d, iconX, iconY);
        }
        g2d.drawString(getText(), textX, textY);

        g2d.dispose(); // Giải phóng đối tượng Graphics2D
    }
}
