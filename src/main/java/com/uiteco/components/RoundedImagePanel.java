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
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class RoundedImagePanel extends JPanel {

    protected int roundTopLeft = 0;
    protected int roundTopRight = 0;
    protected int roundBottomLeft = 0;
    protected int roundBottomRight = 0;
    private Icon image;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    public static RoundedPanel getRoundedPanel(int radius) {
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setRoundTopLeft(radius);
        roundedPanel.setRoundTopRight(radius);
        roundedPanel.setRoundBottomLeft(radius);
        roundedPanel.setRoundBottomRight(radius);
        return roundedPanel;
    }

    public static RoundedPanel getRoundedPanel(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setRoundTopLeft(topLeft);
        roundedPanel.setRoundTopRight(topRight);
        roundedPanel.setRoundBottomLeft(bottomLeft);
        roundedPanel.setRoundBottomRight(bottomRight);
        return roundedPanel;
    }

    public static RoundedPanel getRoundedPanel(int radius, java.awt.LayoutManager layout) {
        RoundedPanel roundedPanel = getRoundedPanel(radius);
        roundedPanel.setLayout(layout);
        return roundedPanel;
    }

    public static RoundedPanel getRoundedPanel(int topLeft, int topRight, int bottomLeft, int bottomRight, java.awt.LayoutManager layout) {
        RoundedPanel roundedPanel = getRoundedPanel(topLeft, topRight, bottomLeft, bottomRight);
        roundedPanel.setLayout(layout);
        return roundedPanel;
    }

    protected Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    protected Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    protected Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    protected Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    public RoundedImagePanel(Icon image) {
        setImage(image);
        _init();
    }

    public RoundedImagePanel() {
        _init();
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2d = (Graphics2D) grphcs.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        // Always draw the round edges
        g2d.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2d.setClip(area);

        // Draw the image if available
        if (getImage() != null) {
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

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

        // Finalize
        g2d.dispose();
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
