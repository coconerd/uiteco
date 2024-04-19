package com.uiteco.components;

import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Raven
 */
public class RoundedGradientPanel extends JPanel {

    public int roundTopLeft = 0;
    public int roundTopRight = 0;
    public int roundBottomLeft = 0;
    public int roundBottomRight = 0;
    public static final int N = 32;
    public boolean fade = true;
    public boolean full = true;
    public Color color1;
    public Color color2;
    public Direction direction;

    public static enum Direction {
        VERTICAL, HORIZONTAL, DIAGONAL
    };

    public static Direction VERTICAL = Direction.VERTICAL;
    public static Direction HORIZONTAL = Direction.DIAGONAL;
    public static Direction DIAGONAL = Direction.DIAGONAL;

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

    public static int getN() {
        return N;
    }

    public boolean isFade() {
        return fade;
    }

    public boolean isFull() {
        return full;
    }

    public Color getColor1() {
        return color1;
    }

    public Color getColor2() {
        return color2;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setFade(boolean fade) {
        this.fade = fade;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public RoundedGradientPanel() {
        setColor1(getBackground());
        setColor2(getColor1().brighter());
        setDirection(Direction.VERTICAL);
        _init();
    }

    public RoundedGradientPanel(boolean fade, boolean full, Color color1, Color color2, Direction direction) {
        setFade(fade);
        setFull(full);
        setColor1(color1);
        setColor2(color2);
        setDirection(direction);
        _init();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2d = (Graphics2D) grphcs.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        g2d.setColor(getBackground());

        // Add rounded border to panels
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

        // Add gradient to panel
        int w = getWidth();
        int h = this.full ? getHeight() : getHeight() / 2;
        switch (getDirection()) {
            case VERTICAL:
                GradientPaint gp = new GradientPaint(
                        0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                break;
            case HORIZONTAL:
                gp = new GradientPaint(0, 0, color1, w, 0, color2);
                g2d.setPaint(gp);
                break;
            case DIAGONAL:
                gp = new GradientPaint(0, 0, color1, w * 0.85f, h, color2);
                g2d.setPaint(gp);
                break;
        }

        // Finalize and render panel
        g2d.fill(area);
        g2d.dispose();
        super.paintComponent(grphcs);
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

    private void _init() {
        setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(N, N, N, N));
        if (isFade()) {
            setColor2(getColor1().brighter());
        }
    }
}
