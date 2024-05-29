/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.detailed;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.uiteco.components.RoundedGradientPanel;
import com.uiteco.components.RoundedImagePanel;
import com.raven.scroll.ScrollPaneWin11;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import com.uiteco.components.ImageAvatar;
import com.uiteco.components.ImagePanel;
import com.uiteco.components.RoundedPanel;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import java.awt.Dimension;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Arrays;
import static com.uiteco.ofSuKienPanel.detailed.SuKienDetail.showImageDialog;

/**
 *
 * @author nddmi
 */
public class Gallery extends ScrollPaneWin11 {

    private RoundedPanel imgContainer;
    private JLabel dotLabel;
    private ArrayList<ImageIcon> images;

    public Gallery() {
    }

    /**
     * Creates new form GalleryView
     */
    public Gallery(SuKienModel suKienModel) {
        this.imgContainer = new RoundedPanel();
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        imgContainer.setBorder(new EmptyBorder(30, 20, 0, 20));
        imgContainer.setLayout(new BoxLayout(imgContainer, BoxLayout.Y_AXIS));
        imgContainer.setForeground(new Color(152, 153, 157));
        imgContainer.setRoundTopLeft(16);
        imgContainer.setRoundBottomLeft(16);
        imgContainer.setRoundTopRight(16);
        imgContainer.setRoundBottomRight(16);

        dotLabel = new JLabel();
        dotLabel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        dotLabel.setText(".");
        dotLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
        dotLabel.setForeground(new Color(204, 204, 204));

        _addDotLabel();

        imgContainer.setBackground(new Color(255, 255, 255));
//        imgContainer.setColor2(new Color(255, 255, 255));

        setOpaque(true);

        setViewportView(imgContainer);
        getViewport().setBackground(new Color(240, 242, 245));

        if (suKienModel.getImages() == null) {
            System.out.println("Images is null, fetching from db!");
//            try {
                this.images = new ArrayList<ImageIcon>();
//                imgContainer.removeAll();
//
//                for (ImageIcon img : images) {
//                    RoundedImagePanel imgPanel = new RoundedImagePanel(img);
//                    _addMouseEventListenerForImgPanel(imgPanel);
//
//                    imgPanel.setRoundTopLeft(10);
//                    imgPanel.setRoundBottomLeft(10);
//                    imgPanel.setRoundTopRight(10);
//                    imgPanel.setRoundBottomRight(10);
//                    imgContainer.add(imgPanel);
//                    imgContainer.add(Box.createVerticalStrut(30));
//                }
//                _addDotLabel();
//                imgContainer.revalidate();
//
//            } catch (Exception e) {
//                // SQLException | IOException
//                e.printStackTrace();
//            }
        } else {
            imgContainer.removeAll();

            for (int i = 0; i < suKienModel.getImages().length; i++) {
                ImageIcon img = suKienModel.getImages()[i];


                RoundedImagePanel imgPanel = new RoundedImagePanel(img);
                _addMouseEventListenerForImgPanel(imgPanel);
                imgPanel.setRoundTopLeft(10);
                imgPanel.setRoundBottomLeft(10);
                imgPanel.setRoundTopRight(10);
                imgPanel.setRoundBottomRight(10);
                imgContainer.add(imgPanel);
                imgContainer.add(Box.createVerticalStrut(30));
            }
            _addDotLabel();
            imgContainer.revalidate();
        }
    }

    private void _addMouseEventListenerForImgPanel(RoundedImagePanel i) {
        i.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                i.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                i.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                showImageDialog(i);
            }
        });

    }

    public JLabel getDotLabel() {
        return this.dotLabel;
    }

    public RoundedPanel getImgContainer() {
        return imgContainer;
    }

    private void _addDotLabel() {
        imgContainer.add(dotLabel);
    }
}
