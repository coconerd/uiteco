/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.components.ImagePanel;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienListModel;
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
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

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
        addTab("Tìm theo tiêu đề", _createEmptyPanel());
        addTab("Tìm theo nội dung bài đăng", _createEmptyPanel());
        addTab("Tìm theo người đăng", _createEmptyPanel());
        try {
            ArrayList<SuKienModel> suKienList = SuKienDAO.searchSuKienByTitle(searchText);
            if (suKienList != null && suKienList.size() > 0) {
                setComponentAt(0, _createResultScrollPane(suKienList));
            }

            suKienList = SuKienDAO.searchSuKienByContent(searchText);
            if (suKienList != null && suKienList.size() > 0) {
                setComponentAt(1, _createResultScrollPane(suKienList));
            }

            suKienList = SuKienDAO.searchSuKienByOwner(searchText);
            if (suKienList != null && suKienList.size() > 0) {
                setComponentAt(2, _createResultScrollPane(suKienList));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JPanel _createEmptyPanel() {
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

    private ScrollPaneWin11 _createResultScrollPane(ArrayList<SuKienModel> suKienList) {
        ScrollPaneWin11 scrollPane = new ScrollPaneWin11();
        scrollPane.setBorder(null);
        
        SuKienListView suKienListView = new SuKienListView(new SuKienListModel(suKienList), null);
        suKienListView.setBorder(new EmptyBorder(10, 30, 0, 30));
        scrollPane.setViewportView(suKienListView);
        
        return scrollPane;
    }
}
