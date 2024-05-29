/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.secondPage.pieChart;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BoxLayout;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class LegendPanel extends javax.swing.JPanel {

    public LegendPanel() {
        initComponents();
    }

    public LegendPanel(List<ModelPieChart> pieCharts) {
        this.pieCharts = pieCharts;
        setLayout(null);
        setOpaque(false);
        updateItems();
    }

    private void updateItems() {
        removeAll();
        int y = 0;
        for (ModelPieChart pieChart : pieCharts) {
            LegenditemPanel a = new LegenditemPanel(pieChart.getColor(), pieChart.getName());
            a.setBounds(0, y, 120, 30);
            add(a);
            y += a.getHeight();
        }
        
        revalidate();
        repaint();
    }

    public void updateData(List<ModelPieChart> newPieCharts) {
        this.pieCharts = newPieCharts;
        updateItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private List<ModelPieChart> pieCharts;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
