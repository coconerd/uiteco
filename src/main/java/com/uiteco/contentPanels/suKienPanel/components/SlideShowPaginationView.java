/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author nddmi
 */
public class SlideShowPaginationView extends JComponent implements PropertyChangeListener {

    private int animationFraction;
    private SlideShowModel slideShowModel;
    private MigLayout layout;

    public SlideShowPaginationView() {
        _init();
    }

    public SlideShowPaginationView(SlideShowModel slideShowModel) {
        setSlideShowModel(slideShowModel);
        _init();

        slideShowModel.addPropertyChangeListener(this);
        
        removeAll();
        for (int i = 0; i < slideShowModel.getPageCount(); i++) {
            final int page = i + 1;
            SlideShowButton button = new SlideShowButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    slideShowModel.switchPage(page);
                }
            });
            add(button);
        };
        this.repaint();
        this.revalidate();
    }

    public SlideShowModel getSlideShowModel() {
        return this.slideShowModel;
    }

    public MigLayout getLayout() {
        return layout;
    }

    public int getAnimationFraction() {
        return this.animationFraction;
    }

    public void setSlideShowModel(SlideShowModel slideShowModel) {
        this.slideShowModel = slideShowModel;
    }

    public void setLayout(MigLayout layout) {
        this.layout = layout;
    }

    public void setAnimationFraction(int animationFraction) {
        this.animationFraction = animationFraction;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            int oldIndex = (Integer) evt.getOldValue();
            int newIndex = (Integer) evt.getNewValue();
            int alpha = getAnimationFraction();
            SlideShowButton buttonOut = (SlideShowButton) getComponent(oldIndex);
            SlideShowButton buttonIn = (SlideShowButton) getComponent(newIndex);
            buttonIn.setAlpha(alpha);
            buttonOut.setAlpha(1f - alpha);
        }
    }

    private void _init() {
        setLayout(new MigLayout("inset 15", "[center]10[center]"));
    }

    public class SlideShowButton extends JButton {

        private float alpha;

        public SlideShowButton() {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(Color.WHITE);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
//            addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent ae) {
//                    
//                }
//            });

        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
            this.repaint();
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            int width = getWidth();
            int height = getHeight();
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            g2.setColor(getBackground());
            g2.fillOval(0, 0, width, height);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.setColor(new Color(11, 124, 173));
            g2.fillOval(0, 0, width, height);
            g2.dispose();
        }
    }
}
