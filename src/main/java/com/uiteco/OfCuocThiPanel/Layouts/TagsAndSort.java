/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.Layouts;

import com.uiteco.components.RoundedBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class TagsAndSort extends JPanel{
    
    public TagsAndSort(){
        this.setLayout(new BorderLayout());
        //this.setVisible(true);
        this.setBounds(30, 40, 1170, 50);
        this.setBackground(Color.WHITE);
        
        // Create a RoundedPanel instance with desired corner radius
        //RoundedPanel roundedPanel = new RoundedPanel(20);
        
        // Set the RoundedPanel as the border of this panel
        //this.setBorder(roundedPanel);
        RoundedBorder roundBor = new RoundedBorder(new Color(242, 243, 244), Color.WHITE, Color.WHITE, 15, 0);
        this.setBorder(roundBor);
    }
}
