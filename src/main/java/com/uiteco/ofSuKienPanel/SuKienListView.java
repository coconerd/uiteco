/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.uiteco.components.RoundedPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import com.raven.scroll.ScrollPaneWin11;

/**
 *
 * @author nddmi
 * @description: A Panel to display a vertical list of events
 * @preferredSize: [786, 444]
 * @layout: Box layout (Y-axis)
 */
public class SuKienListView extends JPanel implements PropertyChangeListener {

    private SuKienListModel suKienListModel;
    public int verticalGap;
    public static int DEFAULT_VERTICAL_GAP = 99;

    public SuKienListView() {
        setSuKienListModel(new SuKienListModel());
        setVerticalGap(DEFAULT_VERTICAL_GAP);
        initComponents();
        _additionalInit();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            _populateSuKienList();
            _populatePaginationBar();
        });
    }

    public SuKienListView(SuKienListModel suKienListModel, int verticalGap) {
        setSuKienListModel(suKienListModel);
        setVerticalGap(verticalGap);
        initComponents();
        _additionalInit();

        javax.swing.SwingUtilities.invokeLater(() -> {
            _populateSuKienList();
            _populatePaginationBar();
        });
    }

    public SuKienListModel getSuKienListModel() {
        return this.suKienListModel;
    }

    public int getVerticalGap() {
        return this.verticalGap;
    }

    public void setSuKienListModel(SuKienListModel suKienListModel) {
        this.suKienListModel = suKienListModel;
    }

    public void setVerticalGap(int verticalGap) {
        this.verticalGap = verticalGap;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("suKienList")) {
            removeAll();
            _populateSuKienList();
            _populatePaginationBar();
            repaint();
            revalidate();
            Component parent = getParent();
            while (!(parent instanceof ScrollPaneWin11)) {
                parent = parent.getParent();
            }
            ((ScrollPaneWin11) parent).scrollToTop(); // Scroll to the top of the page
        }
    }

    private void _additionalInit() {
        this.suKienListModel.addPropertyChangeListener(this);
    }

    private void _populateSuKienList() {
        for (SuKienModel eventModel : suKienListModel.getSuKienList()) {
            SuKienView eventView = new SuKienView(eventModel);
            add(eventView);
            add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, getVerticalGap())));
        }
    }

    private void _populatePaginationBar() {
        int radius = 7;
        
        RoundedPanel paginationBar = RoundedPanel.getRoundedPanel(radius, new FlowLayout());
        paginationBar.setBackground(new Color(242, 243, 244)); // Navy blue

        int pageCount = suKienListModel.getPageCount();
        int currentPage = suKienListModel.getCurrentPage();
        int windowSize = 9;
        int startPage = Math.max(1, currentPage - windowSize / 2);
        int endPage = Math.min(pageCount, currentPage + windowSize / 2);

        // Add a button to let user quickly return to first page
        if (startPage > 1) {
            RoundedPanel box = RoundedPanel.getRoundedPanel(radius, new FlowLayout(FlowLayout.CENTER));
            box.setPreferredSize(new Dimension(25, 25));
            box.add(new JLabel("<<"));
            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    suKienListModel.switchPage(1);
                }
            });
            paginationBar.add(box);
        };
        
        if (currentPage > 1) {
            RoundedPanel box = RoundedPanel.getRoundedPanel(radius, new FlowLayout(FlowLayout.CENTER));
            box.setPreferredSize((new Dimension(25, 25)));
            box.add(new JLabel("<"));
            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    suKienListModel.switchPreviousPage();
                }
            });
            paginationBar.add(box);
        }

        for (int i = startPage; i <= endPage; i++) {
            final int pageNum = i;
            RoundedPanel numberBox = RoundedPanel.getRoundedPanel(radius, new FlowLayout(FlowLayout.CENTER));
            numberBox.setPreferredSize(new Dimension(30, 25));
            numberBox.setBackground(i == currentPage ? Color.WHITE.darker() : Color.WHITE);

            JLabel number = new JLabel();
            java.awt.Font boldFont = new java.awt.Font(number.getFont().getName(), java.awt.Font.BOLD, number.getFont().getSize());
            number.setFont(boldFont);
            number.setText(Integer.toString(i));

            number.setAlignmentX(JLabel.CENTER);
            number.setAlignmentY(JLabel.CENTER);
            numberBox.add(number);
            numberBox.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    suKienListModel.switchPage(pageNum);
                }
            });

            paginationBar.add(numberBox);
        }

        if (currentPage < pageCount) {
            RoundedPanel box = RoundedPanel.getRoundedPanel(radius, new FlowLayout(FlowLayout.CENTER));
            box.setPreferredSize((new Dimension(25, 25)));
            box.add(new JLabel(">"));
            box.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // This method will be called when the panel is clicked
                    suKienListModel.switchNextPage();
                }
            });
            paginationBar.add(box);
        };

        add(paginationBar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(242, 243, 244));
        setForeground(new java.awt.Color(242, 243, 244));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Implements lazy-loading for SuKienListView
     *
     * @param evt
     */
    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
//        _populateSuKienList();
//        _populatePaginationBar();
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
