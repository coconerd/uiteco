/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofTaiKhoanRightPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel.ACCOUNT_TYPE;
import com.uiteco.main.App;
import com.uiteco.ofTaiKhoanPanel.clubManagement.ClubManagementUI;
import com.uiteco.ofTaiKhoanPanel.introduction.IntroductionUI;
import com.uiteco.ofTaiKhoanPanel.security.SecurityUI;
import com.uiteco.ofTaiKhoanPanel.createPost.CreatePostUI;
import com.uiteco.ofTaiKhoanPanel.postManagement.PostManagement;
import com.uiteco.swing.ContentPanel;

/**
 *
 * @author nddmi
 */
public class Menu extends JComponent {

    private class PagePair {

        public String contentPanelName;
        public String rightPanelName;

        public PagePair() {
        }

        ;

        public PagePair(String contentPanelName, String rightPanelName) {
            this.contentPanelName = contentPanelName;
            this.rightPanelName = rightPanelName;
        }
    }

    private MigLayout layout;
    private String[][] menuNames;
    private String[][] menuImageNames;
    private Icon[][] menuIcons;
    private PagePair[][] pagePairs;

    private MenuItem currentItem;
    private MenuItem currentSubItem;

    public Menu() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (App.getSession().getUser().getAccountType() == ACCOUNT_TYPE.admin) {
                    menuNames = new String[][]{
                        {"Thông tin cá nhân", "Chỉnh sửa", "Bảo mật"},
                        {"Admin", "Đăng bài", "Quản lý bài đăng"},
                        {"Quản lý câu lạc bộ"}
                    };

                    pagePairs = new PagePair[][]{
                        {null, new PagePair(IntroductionUI.INSTANCE_NAME, "taiKhoanRightPanel"), new PagePair(SecurityUI.INSTANCE_NAME, "taiKhoanRightPanel")},
                        {null, new PagePair(CreatePostUI.INSTANCE_NAME, "taiKhoanRightPanel"), new PagePair(PostManagement.INSTANCE_NAME, "taiKhoanRightPanel")},
                        {new PagePair(ClubManagementUI.INSTANCE_NAME, "taiKhoanRightPanel")},};

                    menuImageNames = new String[][]{
                        {"icons8-settings-24.png", "icons8-edit-24.png", "icons8-lock-24.png"},
                        {"icons8-user-shield-24.png", "icons8-edit-row-24.png", "icons8-goodnotes-24.png"},
                        {"icons8-club-24.png"}
                    };

                } else {
                    menuNames = new String[][]{
                        {"Thông tin cá nhân", "Chỉnh sửa", "Bảo mật"},
                        {"Quản lý câu lạc bộ"}
                    };

                    pagePairs = new PagePair[][]{
                        {null, new PagePair(IntroductionUI.INSTANCE_NAME, "taiKhoanRightPanel"), new PagePair(SecurityUI.INSTANCE_NAME, "taiKhoanRightPanel")},
                        {new PagePair(ClubManagementUI.INSTANCE_NAME, "taiKhoanRightPanel")},};

                    menuImageNames = new String[][]{
                        {"icons8-settings-24.png", "icons8-edit-24.png", "icons8-lock-24.png"},
                        {"icons8-club-24.png"}
                    };

                }

                menuIcons = new Icon[menuImageNames.length][];
                for (int i = 0; i < menuImageNames.length; i++) {
                    menuIcons[i] = new Icon[menuImageNames[i].length];

                    for (int j = 0; j < menuImageNames[i].length; j++) {
                        menuIcons[i][j] = new ImageIcon(getClass().getResource("/" + menuImageNames[i][j]));
                    }
                }
                _init();
            }
        });

    }

    private void _init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);

        // Init MenuItems
        for (int i = 0; i < menuNames.length; i++) {
            addMenu(menuNames[i][0], menuIcons[i][0], i);
        }
    }

    private void addMenu(String text, Icon icon, int index) {
        int length = menuNames[index].length;
        MenuItem item = new MenuItem(text, icon, index, false, length > 1);

        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (currentItem != null) {
                    currentItem.setBackground(Color.WHITE);
                    currentItem.setLabelForeground(new Color(5, 5, 5));
                }
                currentItem = item;
                currentItem.setBackground(new Color(8, 102, 255));
                currentItem.setLabelForeground(Color.white);

                if (length > 1) {
                    if (!item.isSelected()) {
                        // Show item
                        addSubMenu(item, index, length, getComponentZOrder(item) + 1);
                        item.setSelected(true);
                        item.getArrowIcon().setIcon(new ImageIcon(getClass().getResource("/icons8-up-arrow-23.png")));
                    } else {
                        // Hide item
                        _hideMenu(item, index);
                        item.setSelected(false);
                        item.getArrowIcon().setIcon(new ImageIcon(getClass().getResource("/icons8-down-arrow-23.png")));
                    }
                } else {
                    if (currentSubItem != null) {
                        currentSubItem.setBackground(Color.white);
                        currentSubItem.setSelected(false);
                    }
                    currentSubItem = null;

                    PagePair pagePair = pagePairs[index][0];
                    if (pagePair != null) {
                        _switchPage(pagePair);
                    }
                }

            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                // setBackground(getBackground().darker());
                if (item != currentItem) {
                    item.setBackground(new Color(240, 242, 245));
                } else {
                    item.setBackground(item.getBackground().darker());
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                // setBackground(getBackground().brighter());
                if (item != currentItem) {
                    item.setBackground(Color.white);
                } else {
                    item.setBackground(new Color(8, 102, 255));
                }
            }

        });
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setOpaque(false);
        panel.setName(index + "");
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuNames[index][i], menuIcons[index][i], i, true, false);
            subItem.initSubMenu(i, length);

            final int finalI = i;
            subItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    if (!subItem.isSelected()) {
                        subItem.setBackground(new Color(235, 235, 235));
                    }
                }

                public void mouseExited(MouseEvent evt) {
                    if (!subItem.isSelected()) {
                        subItem.setBackground(Color.white);
                    }
                }

                public void mouseClicked(MouseEvent evt) {
                    if (currentSubItem == subItem) {
                        return;

                    }

                    if (currentSubItem != null) {
                        currentSubItem.setBackground(Color.white);
                        currentSubItem.setSelected(false);
                    }
                    subItem.setSelected(true);
                    currentSubItem = subItem;
                    currentSubItem.setBackground(new Color(221, 221, 221));

                    PagePair pagePair = pagePairs[index][finalI];
                    if (pagePair != null) {
                        _switchPage(pagePair);
                    }
                }
            });

            panel.add(subItem);
        }

        add(panel, "h 0!", indexZorder);
        revalidate();
        repaint();
        MenuAnimation.showAnimation(panel, item, layout, true);
    }

    private void _hideMenu(MenuItem item, int index) {
        for (Component comp : getComponents()) {
            if (comp instanceof JPanel && comp.getName() != null && comp.getName().equals(index + "")) {
                MenuAnimation.showAnimation(comp, item, layout, false);
                break;
            }
        }
    }

    private void _switchPage(PagePair pagePair) {
        ContentPanel contentPanel = App.getMainFrame().getContentPanel();

        // Abort page-switching bcuz already on page
        if (pagePair.contentPanelName.equals(
                contentPanel.getPageHistoryAt(contentPanel.getHistoryIndex()))) {
            return;
        }

        if (pagePair.contentPanelName.equals(PostManagement.INSTANCE_NAME)) {
            ((PostManagement) contentPanel.getComponent(PostManagement.INSTANCE_NAME)).load();
        }
        
        contentPanel.showComponentAndTrimHistory(pagePair.contentPanelName);
        App.getMainFrame().getRightPanel().showComponentAndTrimHistory(pagePair.rightPanelName);
    }
}
