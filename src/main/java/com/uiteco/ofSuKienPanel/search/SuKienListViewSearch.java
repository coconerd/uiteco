/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.uiteco.components.RoundedPanel;
import com.uiteco.ofSuKienPanel.SuKienListModel;
import com.uiteco.ofSuKienPanel.SuKienListView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nddmi
 */
public class SuKienListViewSearch extends SuKienListView {

    public SuKienListViewSearch() {
        super();
    }

    public SuKienListViewSearch(SuKienListModelSearch suKienListModel, Integer verticalGap) {
        super(suKienListModel, verticalGap);
    }

    @Override
    protected void _populatePaginationBar() {
        boolean hasNextPage = ((SuKienListModelSearch) getSuKienListModel()).hasNextPage();
        boolean hasPreviousPage = ((SuKienListModelSearch) getSuKienListModel()).hasPreviousPage();

        add(new PaginationBar(hasNextPage, hasPreviousPage) {
            @Override
            public void changePage(boolean isNext) {
                if (isNext) {
                    getSuKienListModel().switchNextPage();
                } else {
                    getSuKienListModel().switchPreviousPage();
                }
            }
        });
    }

    @Override
    protected void _populateSuKienList() {
        SuKienListModelSearch model =  (SuKienListModelSearch) getSuKienListModel();
        int entries = getSuKienListModel().getEntries();

        if (entries > 0) {
            super._populateSuKienList();
            RoundedPanel statsPanel = RoundedPanel.getRoundedPanel(40, 40, 40, 40, new GridLayout(1, 1));
            statsPanel.setBackground(getBackground());

            JLabel statsLabel = new JLabel();
            statsLabel.setFont(new Font("Arial", Font.BOLD, 16));
            String text = "Đang hiển thị " + String.valueOf(entries) + " kết quả tìm kiếm";
            if (model.hasNextPage() || model.hasPreviousPage) {
                text += (" (ở trang thứ " + String.valueOf(model.getCurrentPage()) + ")");
            }
            statsLabel.setText(text);
            statsLabel.setIcon(new ImageIcon(getClass().getResource("/icons8-search-28.png")));
            statsPanel.add(statsLabel);
            add(statsPanel, Component.LEFT_ALIGNMENT, 0);
            add(Box.createRigidArea(new Dimension(0, 30)), 1);

        }
    }
}
