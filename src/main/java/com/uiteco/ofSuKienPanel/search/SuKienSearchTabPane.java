/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.components.ImagePanel;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienListView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.uiteco.components.ModernTabPane;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.util.List;
import javax.swing.border.EmptyBorder;
import com.uiteco.ofSuKienPanel.search.SuKienListModelSearch.SEARCH_OPTION;
import java.awt.Component;

/**
 *
 * @author nddmi
 */
public class SuKienSearchTabPane extends ModernTabPane {

    public static final String INSTANCE_NAME = "suKienSearchTabPane";

    /**
     * Constructor
     */
    public SuKienSearchTabPane() {
    }

    public void loadSuKienSearchTabPane(String searchText) {
        removeAll();
        addTab("Tìm theo tiêu đề", _createResultPane(searchText, SEARCH_OPTION.title));
        addTab("Tìm theo nội dung", _createResultPane(searchText, SEARCH_OPTION.content));
        addTab("Tìm theo người đăng", _createResultPane(searchText, SEARCH_OPTION.postedBy));

    }

    private Component _createEmptyPanel() {
        JPanel emptyPanel = new JPanel();
//        emptyPanel.setBackground(new Color(242, 243, 244));
        emptyPanel.setBackground(new Color(164, 217, 235));
        emptyPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Không tìm thấy thông tin...");
        label.setIcon(new ImageIcon(getClass().getResource("/icons8-polar-bear-48.png")));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setForeground(new Color(5, 5, 5));

        ImagePanel img = new ImagePanel(new ImageIcon(getClass().getResource("/antartica.jpeg")));

        emptyPanel.add(label, BorderLayout.NORTH);
        emptyPanel.add(img, BorderLayout.CENTER);

        return emptyPanel;
    }

    private Component _createResultPane(String searchText, SEARCH_OPTION searchOption) {

        SuKienListModelSearch newModel = new SuKienListModelSearch(searchText, searchOption);
        SuKienListView suKienListView = new SuKienListView(newModel, null);
        newModel.addPropertyChangeListener(newModel);
        newModel.loadData();
        
        if (suKienListView.getSuKienListModel().getEntries() > 0) {
            ScrollPaneWin11 scrollPane = new ScrollPaneWin11();
            scrollPane.setBorder(null);
            suKienListView.setBorder(new EmptyBorder(10, 30, 0, 30));
            scrollPane.setViewportView(suKienListView);
            return scrollPane;
        }

        return _createEmptyPanel();
    }
}
