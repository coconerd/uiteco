/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.components;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class ImagePanel extends JPanel {

    protected Icon image;

    public ImagePanel(Icon image) {
        setImage(image);
        _init();
    }

    public ImagePanel() {
        _init();
    }

    public Icon getImage() {
        return this.image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        if (getImage() != null) {
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

            Rectangle size = _getAutoSize(getImage());
            g2d.drawImage(
                    _toImage(getImage()),
                    size.x,
                    size.y,
                    size.width,
                    size.height,
                    null
            );
        }
        super.paintComponent(grphcs);
    }

    private Rectangle _getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image _toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    private void _init() {
        setOpaque(false);
        setPreferredSize(new Dimension(350, 200));
        setMaximumSize(new Dimension(1920, 1080));
        setMinimumSize(new Dimension(350, 200));
    }

}
