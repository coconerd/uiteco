/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.component;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InvertedGradientPanel extends JPanel {
    private static final int N = 32;
    private boolean fade = true;
    private boolean full = true;

    public InvertedGradientPanel() {
        initPanel();
    }
    
    public InvertedGradientPanel(boolean _fade, boolean _full) {
        this.fade = _fade;
        this.full = _full;
        initPanel();
    }
    
    
    private void initPanel() {
        this.setBorder(BorderFactory.createEmptyBorder(N, N, N, N));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = getBackground();
        Color color2 = this.fade ? Color.WHITE : color1.brighter();
        int w = getWidth();
        int h = this.full ? getHeight() : getHeight() / 2;
        GradientPaint gp = new GradientPaint(
            0, 0, color2, 0, h, color1);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    private void display() {
        JFrame f = new JFrame("InvertedGradientPanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new InvertedGradientPanel().display();
            }
        });
    }
}
