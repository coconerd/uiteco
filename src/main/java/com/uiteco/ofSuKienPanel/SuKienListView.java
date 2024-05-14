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
import com.uiteco.main.App;
import com.uiteco.ofSuKienPanel.detailed.NullSuKienModelException;
import com.uiteco.swing.ContentPanel;
import com.uiteco.ofSuKienPanel.detailed.SuKienDetailScrollPane;
import java.awt.Cursor;
import javax.swing.BoxLayout;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author nddmi
 * @description: A Panel to display a vertical list of events
 * @preferredSize: [786, 444]
 * @layout: Box layout (Y-axis)
 */
public class SuKienListView extends JPanel implements PropertyChangeListener {

    public static final String LIST_POPULATED_EVENT = "LIST_POPULATED";

    private SuKienListModel suKienListModel;
    public int verticalGap;
    public static int DEFAULT_VERTICAL_GAP = 50;
    private PropertyChangeSupport propertyChangeSupport;

    public SuKienListView() {
        _init();
        setSuKienListModel(new SuKienListModel());
        setVerticalGap(DEFAULT_VERTICAL_GAP);
        _additionalInit();
    }

    public SuKienListView(SuKienListModel suKienListModel, Integer verticalGap) {
        _init();
        setSuKienListModel(suKienListModel);
        setVerticalGap(verticalGap != null ? verticalGap : DEFAULT_VERTICAL_GAP);
        _additionalInit();
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
                if (parent instanceof ScrollPaneWin11) {
                    ((ScrollPaneWin11) parent).scrollToTop(); // Scroll to the top of the page            
                    break;
                }
            }
            
            propertyChangeSupport.firePropertyChange(LIST_POPULATED_EVENT, null, null);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void _init() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    private void _additionalInit() {
        this.suKienListModel.addPropertyChangeListener(this);

        if (getSuKienListModel() != null
                && getSuKienListModel().getSuKienList() != null
                && getSuKienListModel().getSuKienList().size() > 0) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                _populateSuKienList();
                _populatePaginationBar();
            });
        }
    }

    private void _populateSuKienList() {
        for (SuKienModel model : suKienListModel.getSuKienList()) {
            SuKienView view = new SuKienView(model);
            view.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    ContentPanel appContentPanel = App.getMainFrame().getContentPanel();
                    SuKienDetailScrollPane sd = (SuKienDetailScrollPane) (appContentPanel.getComponent(SuKienDetailScrollPane.INSTANCE_NAME));
                    try {
                        sd.loadDetailOfSuKien(model);
                        appContentPanel.showComponentAndTrimHistory(SuKienDetailScrollPane.INSTANCE_NAME);
                    } catch (NullSuKienModelException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent evt) {
                    view.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });

            add(view);
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

                @Override
                public void mouseEntered(MouseEvent e) {
                    box.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    box.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

                @Override
                public void mouseEntered(MouseEvent e) {
                    numberBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    numberBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

                @Override
                public void mouseEntered(MouseEvent e) {
                    box.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    box.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
            paginationBar.add(box);
        };

        add(paginationBar);
    }
}
