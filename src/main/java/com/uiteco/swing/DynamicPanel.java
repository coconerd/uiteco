
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.swing;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

/**
 *
 * @author nddmi
 */
public class DynamicPanel extends JPanel {
    /**
     *  Custom variables declaration
     */
        // Custom variables declaration
    private final CardLayout cardLayout;
    private final JPanel pageHolder;

    /**
     * Creates new form LayoutManagerPanel
     * 
     */
    public DynamicPanel() {
        cardLayout = new CardLayout();
        pageHolder = new JPanel(cardLayout);
//        pageHolder.setBorder(BorderFactory.createEtchedBorder());
//        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        setLayout(new BorderLayout(5, 5));
        this.setLayout(new java.awt.GridLayout(1, 1));
//        pageHolder
        this.add(pageHolder);
    }
    
    public DynamicPanel(Dimension d) {
        cardLayout = new CardLayout();
        pageHolder = new JPanel(cardLayout);
        pageHolder.setBorder(BorderFactory.createEtchedBorder());

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(pageHolder, BorderLayout.CENTER);
        this.setSize(d);
    }
    
    public void previousPage() {
        cardLayout.previous(pageHolder);
    }
    
    public void nextPage() {
        cardLayout.next(pageHolder);
    }
    
    public void show(String name) {
        cardLayout.show(pageHolder, name);
    }
    
    public void registerPage(JComponent page, String name) {
        pageHolder.add(name, page);
    }
    

    
//    private class NameComboListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//               show(selection);
//        }
//    }
}
