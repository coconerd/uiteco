/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author nddmi
 */
public class SlideShowPaginationView extends JComponent implements PropertyChangeListener {

//    private int animationFraction;
    private SlideShowModel slideShowModel;
    private MigLayout layout;
    private ImageIcon activeIcon;
    private ImageIcon inactiveIcon;

    public static String DEFAULT_ACTIVE_ICON_NAME = "/icons8-dark-dot-26.png";
    public static String DEFAULT_INACTIVE_ICON_NAME = "/icons8-light-dot-26.png";

    public SlideShowPaginationView() {
        setSlideShowModel(new SlideShowModel());
        _init();
    }

    public SlideShowPaginationView(SlideShowModel slideShowModel) {
        setSlideShowModel(slideShowModel);
        _init();
    }

    public ImageIcon getActiveIcon() {
        return activeIcon;
    }

    public ImageIcon getInactiveIcon() {
        return inactiveIcon;
    }

    public SlideShowModel getSlideShowModel() {
        return this.slideShowModel;
    }

    public MigLayout getLayout() {
        return layout;
    }
//
//    public int getAnimationFraction() {
//        return this.animationFraction;
//    }

    public void setSlideShowModel(SlideShowModel slideShowModel) {
        this.slideShowModel = slideShowModel;
    }

    public void setLayout(MigLayout layout) {
        this.layout = layout;
    }

    public void setActiveIcon(ImageIcon activeIcon) {
        this.activeIcon = activeIcon;
    }

    public void setInactiveIcon(ImageIcon inactiveIcon) {
        this.inactiveIcon = inactiveIcon;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            int oldIndex = (Integer) evt.getOldValue() - 1;
            int newIndex = (Integer) evt.getNewValue() - 1;
            JLabel buttonOut = (JLabel) getComponent(oldIndex);
            JLabel buttonIn = (JLabel) getComponent(newIndex);
            buttonOut.setIcon(getInactiveIcon());
            buttonIn.setIcon(getActiveIcon());
        }
    }

    private void _init() {
//        setLayout(new MigLayout("inset 15", "[center]10[center]"));
        slideShowModel.addPropertyChangeListener(this);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setActiveIcon(new ImageIcon(getClass().getResource(DEFAULT_ACTIVE_ICON_NAME)));
        setInactiveIcon(new ImageIcon(getClass().getResource(DEFAULT_INACTIVE_ICON_NAME)));

        removeAll();
        for (int i = 0; i < slideShowModel.getPageCount(); i++) {
            final int page = i + 1;
            JLabel pageButton = new JLabel();
            pageButton.setIcon(getInactiveIcon());
            pageButton.setHorizontalAlignment(SwingConstants.LEFT);

            pageButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    slideShowModel.switchPage(page);
                }
            });
            add(pageButton);
            if (i == slideShowModel.getPageCount() - 1) {
                setSize(pageButton.getWidth() * (i + 1), getHeight());
            }   
        }
        JLabel currentButton = (JLabel)getComponent(slideShowModel.getCurrentPage() - 1);
        currentButton.setIcon(getActiveIcon());
        repaint();
        revalidate();

    }
//
//    public class SlideShowButton extends JButton {
//
//        private float alpha;
//
//        public SlideShowButton() {
//            setContentAreaFilled(false);
//            setBorder(new EmptyBorder(5, 5, 5, 5));
//            setBackground(Color.WHITE);
//            setCursor(new Cursor(Cursor.HAND_CURSOR));
////            addActionListener(new ActionListener() {
////                @Override
////                public void actionPerformed(ActionEvent ae) {
////                    
////                }    public class SlideShowButton extends JButton {
//
////            });
//
//        }
//
//        public float getAlpha() {
//            return alpha;
//        }
//
//        public void setAlpha(float alpha) {
//            this.alpha = alpha;
//            this.repaint();
//        }
//
//        @Override
//        public void paint(Graphics grphcs) {
//            super.paint(grphcs);
//            int width = getWidth();
//            int height = getHeight();
//            Graphics2D g2 = (Graphics2D) grphcs.create();
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
//            g2.setColor(getBackground());
//            g2.fillOval(0, 0, width, height);
//            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
//            g2.setColor(new Color(11, 124, 173));
//            g2.fillOval(0, 0, width, height);
//            g2.dispose();
//        }
//    }
}
