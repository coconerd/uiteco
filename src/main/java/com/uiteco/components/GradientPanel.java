/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

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

    public GradientPanel() {
        setColor1(this.getBackground());
        setFade(true);
        setFull(true);
        setColor2(getColor1().brighter());
        setDirection(Direction.VERTICAL);
        _init();
    }

    public GradientPanel(boolean fade, boolean full, Color color1, Color color2, Direction direction) {
        setFade(fade);
        setFull(full);
        setColor1(color1);
        setColor2(color2);
        setDirection(direction);
        _init();
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (color2 == null) {
            setColor2(isFade() ? color1.brighter() : Color.WHITE);
        }
        int w = getWidth();
        int h = isFull() ? getHeight() : getHeight() / 2;

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
        g2d.fillRect(0, 0, w, h);
    }

    private void _init() {
        this.setBorder(BorderFactory.createEmptyBorder(N, N, N, N));
        if (isFade()) {
            setColor2(getColor1().brighter());
        }
    }
}
