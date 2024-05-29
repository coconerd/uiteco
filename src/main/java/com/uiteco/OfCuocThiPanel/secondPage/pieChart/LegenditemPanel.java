/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.secondPage.pieChart;

import javax.swing.*;
import java.awt.*;

public class LegenditemPanel extends JPanel {
    public LegenditemPanel(Color color, String name) {
        setLayout(null);
        setPreferredSize(new Dimension(350, 35));
        
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(color);
        colorPanel.setBounds(9, 4, 22, 22);
        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(38, 0, 120, 29);
        add(colorPanel);
        add(nameLabel);
        
    }
}

