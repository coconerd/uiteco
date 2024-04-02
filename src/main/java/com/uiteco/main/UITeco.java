/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.main;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import com.uiteco.swing.DynamicPanel;

public class UITeco {
   private static final String[] LABELS = { "One", "Two", "Three", "Four",
         "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
         "Thirteen", "Fourteen", "Fifteen" };
   private static final Dimension LABEL_SIZE = new Dimension(400, 300);

   private static void createAndShowGui() {
      DynamicPanel manager = new DynamicPanel();
      Random random = new Random();

      // I'm using JLabels as a simple substitute for your complex JPanel GUI "pages"
      for (String labelText : LABELS) {
         JLabel label = new JLabel(labelText, SwingConstants.CENTER);
         label.setPreferredSize(LABEL_SIZE);
         label.setOpaque(true);
         label.setBackground(new Color(random.nextInt(170) + 85, random
               .nextInt(170) + 85, random.nextInt(170) + 85));
         manager.registerPage(label, labelText);
      }

      JFrame frame = new JFrame("LayoutManagerContainer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(manager.getSize());
      frame.getContentPane().add(manager);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
