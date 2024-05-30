package com.uiteco.contentPanels;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.raven.scroll.ScrollPaneUtil;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Controller;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_View;
import com.uiteco.OfCuocThiPanel.firstPage.pagination.EventPagination;
import com.uiteco.OfCuocThiPanel.firstPage.pagination.PaginationItemRenderStyle1;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Controller;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_View;
import com.uiteco.main.App;
import static com.uiteco.main.App.getMainFrame;
import com.uiteco.rightPanels.CuocThiRightPanel_SecondPage;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CuocThiPanel extends JPanel {

    public BriefPost_View getPostUI() {
        return postUI;
    }

    public void setPostUI(BriefPost_View postUI) {
        this.postUI = postUI;
    }

    public List<BriefPost_Model> getPosts() {
        return posts;
    }

    public void setPosts(List<BriefPost_Model> posts) {
        this.posts = posts;
    }

    private List<BriefPost_Model> posts = CuocThiDAO.getPostsInfo_Default();
    private BriefPost_View postUI;
    private final Map<Integer, BriefPost_View> postMap = new HashMap<>();

    public CuocThiPanel() {
        FlatMacLightLaf.setup();
        initComponents();
        jScrollPane.setBorder(null);
        jScrollPane.setOpaque(false);
        ScrollPaneUtil.configureScrollBar(jScrollPane);

        _initComboBox();
        _initPagination();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        newestCompetitions_new.repaint();
        roundedPanel1.revalidate();
        postList.revalidate();
        roundedPanel1.repaint();
        postList.repaint();
        
    }
    
    private void _initComboBox() {
        List<String> tagsList = CuocThiDAO.getAllTags();
        String[] tags = tagsList.toArray(String[]::new);
        comboBox.setModel(new DefaultComboBoxModel(tags));
    }

    private void _initPagination() {
        posts = CuocThiDAO.getPostsInfo_Offset(pagination, 1, 3, 3, false, false);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_Offset(pagination, page, 3, 3, false, false);
                _initPostsList(posts);
            }
        });

    }

    private void _initPostsList(List<BriefPost_Model> posts) {

        pagination.setPaginationItemRender(new PaginationItemRenderStyle1());
        postList.removeAll();

        if (posts == null || posts.isEmpty()) {
            JLabel placeholder = new JLabel("No posts available");
            Font placeholderFont = new Font("Merriweather", Font.PLAIN, 24);
            placeholder.setFont(placeholderFont);

            placeholder.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 118));

            placeholder.setHorizontalAlignment(SwingConstants.CENTER);
            placeholder.setPreferredSize(new java.awt.Dimension(1160, 805)); // Adjust dimensions as needed

            
        }

        setPosts(posts);
        
        for (BriefPost_Model post : getPosts()) {
            setPostUI(new BriefPost_View());
            BriefPost_Controller postController = new BriefPost_Controller(post, getPostUI());

            setPostUI(postController.setData());

            postMap.put(post.getId(), getPostUI());

            postList.add(getPostUI());
            postList.repaint();
            getPostUI().getjTitle().addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {

                    //find the OnePost_View instance that was clicked 
                    for (Map.Entry<Integer, BriefPost_View> entry : postMap.entrySet()) {

                        if (entry.getValue().getjTitle().equals(e.getSource())) {
                            int clickedPostID = entry.getKey();
                            for (BriefPost_Model post : getPosts()) {
                                if (post.getId() == clickedPostID) {

                                    Component comp = App.getMainFrame().getContentPanel().getComponent("cuocThiDetailedPanel");
                                    if (comp instanceof DetailedOnePost_View detailedPanel) {
                                        DetailedOnePost_Controller detailedController = detailedPanel.createController(post);

                                        detailedPanel = detailedController.setData(post);

                                        getMainFrame().getContentPanel().showComponentAndTrimHistory("cuocThiDetailedPanel");
                                    }

                                    Component compRight = App.getMainFrame().getRightPanel().getComponent("cuocThiRightPanel_SecondPage");
                                    if (compRight instanceof CuocThiRightPanel_SecondPage rightPanel) {
                                        rightPanel.setPostID(post.getId());
                                        getMainFrame().getRightPanel().showComponentAndTrimHistory("cuocThiRightPanel_SecondPage");

                                    }

                                }
                            }

                        }

                    }
                }
            });

            postList.revalidate();
            postList.repaint();

        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        comboBox = new com.uiteco.OfCuocThiPanel.firstPage.comboBox.ComboBoxMultiSelection();
        sort = new javax.swing.JLabel();
        solo = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        team = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        hottest = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        due = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        tagIcon = new javax.swing.JLabel();
        soloIcon = new javax.swing.JLabel();
        teamIcon = new javax.swing.JLabel();
        hotestIcon = new javax.swing.JLabel();
        dueIcon = new javax.swing.JLabel();
        filterIcon = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jScrollPane = new javax.swing.JScrollPane();
        slideShowAndPosts = new javax.swing.JPanel();
        newestCompetitions_new = new com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewestCompetitions_new();
        postList = new javax.swing.JPanel();
        pagination = new com.uiteco.OfCuocThiPanel.firstPage.pagination.Pagination();
        jHello = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setLayout(new java.awt.GridBagLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setMinimumSize(new java.awt.Dimension(100, 34));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(1160, 39));
        roundedPanel1.setRoundBottomLeft(45);
        roundedPanel1.setRoundBottomRight(45);
        roundedPanel1.setRoundTopLeft(45);
        roundedPanel1.setRoundTopRight(45);
        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        comboBox.setPreferredSize(new java.awt.Dimension(500, 42));
        comboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboBoxMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        roundedPanel1.add(comboBox, gridBagConstraints);

        sort.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        sort.setText("SORT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 50);
        roundedPanel1.add(sort, gridBagConstraints);

        solo.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        solo.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        solo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        solo.setIconTextGap(6);
        solo.setLabel("Cá nhân");
        solo.setPreferredSize(new java.awt.Dimension(140, 54));
        solo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                soloMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 35);
        roundedPanel1.add(solo, gridBagConstraints);

        team.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        team.setText("Đội nhóm");
        team.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        team.setIconTextGap(6);
        team.setPreferredSize(new java.awt.Dimension(140, 54));
        team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        roundedPanel1.add(team, gridBagConstraints);

        hottest.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        hottest.setText("Hot nhất");
        hottest.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        hottest.setPreferredSize(new java.awt.Dimension(140, 54));
        hottest.setVerifyInputWhenFocusTarget(false);
        hottest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hottestMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 32);
        roundedPanel1.add(hottest, gridBagConstraints);

        due.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        due.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        due.setLabel("Đến hạn");
        due.setPreferredSize(new java.awt.Dimension(140, 54));
        due.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 41);
        roundedPanel1.add(due, gridBagConstraints);

        tagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-tag-29.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 25);
        roundedPanel1.add(tagIcon, gridBagConstraints);

        soloIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-person-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 12);
        roundedPanel1.add(soloIcon, gridBagConstraints);

        teamIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-team-25.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        roundedPanel1.add(teamIcon, gridBagConstraints);

        hotestIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-hot-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        roundedPanel1.add(hotestIcon, gridBagConstraints);

        dueIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-time-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        roundedPanel1.add(dueIcon, gridBagConstraints);

        filterIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-filter-32.png"))); // NOI18N
        filterIcon.setColor(new java.awt.Color(255, 255, 255));
        filterIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        filterIcon.setPreferredSize(new java.awt.Dimension(70, 50));
        filterIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterIconActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 7.0;
        roundedPanel1.add(filterIcon, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.045;
        gridBagConstraints.insets = new java.awt.Insets(9, 35, 30, 35);
        add(roundedPanel1, gridBagConstraints);

        jScrollPane.setBackground(new java.awt.Color(242, 243, 244));
        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new java.awt.Dimension(1160, 1300));

        slideShowAndPosts.setBackground(new java.awt.Color(242, 243, 244));
        slideShowAndPosts.setPreferredSize(new java.awt.Dimension(950, 1857));
        slideShowAndPosts.setLayout(new java.awt.GridBagLayout());

        newestCompetitions_new.setPreferredSize(new java.awt.Dimension(700, 850));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(30, 25, 30, 25);
        slideShowAndPosts.add(newestCompetitions_new, gridBagConstraints);

        postList.setBackground(new java.awt.Color(242, 243, 244));
        postList.setLayout(new java.awt.GridLayout(0, 1, 0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(22, 24, 35, 0);
        slideShowAndPosts.add(postList, gridBagConstraints);

        pagination.setFont(new java.awt.Font("Merriweather", 0, 26)); // NOI18N
        pagination.setOpaque(false);
        pagination.setPreferredSize(new java.awt.Dimension(300, 80));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 36);
        slideShowAndPosts.add(pagination, gridBagConstraints);

        jScrollPane.setViewportView(slideShowAndPosts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 40, 35);
        add(jScrollPane, gridBagConstraints);

        jHello.setFont(new java.awt.Font("Merriweather", 2, 26)); // NOI18N
        jHello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/waving-hand_9837221.png"))); // NOI18N
        jHello.setText("Xin chào cahoivuotthac!");
        jHello.setIconTextGap(12);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 55, 17, 0);
        add(jHello, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void teamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamActionPerformed

        posts = CuocThiDAO.getPostsInfo_Offset(pagination, 1, 3, 2, false, false);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_Offset(pagination, page, 3, 2, false, false);
                _initPostsList(posts);
            }
        });

    }//GEN-LAST:event_teamActionPerformed

    private void dueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueActionPerformed
        // TODO add your handling code here:
        posts = CuocThiDAO.getPostsInfo_Offset(pagination, 1, 3, 0, true, false);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_Offset(pagination, page, 3, 0, true, false);
                _initPostsList(posts);
            }
        });

    }//GEN-LAST:event_dueActionPerformed

    private void soloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soloMousePressed
        // TODO add your handling code here:
        //removeAll();
        posts = CuocThiDAO.getPostsInfo_Offset(pagination, 1, 3, 1, true, false);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_Offset(pagination, page, 3, 1, true, false);
                _initPostsList(posts);
            }
        });

    }//GEN-LAST:event_soloMousePressed

    private void hottestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hottestMousePressed
        // TODO add your handling code here:
        //removeAll();
        posts = CuocThiDAO.getPostsInfo_Offset(pagination, 1, 3, 0, false, true);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_Offset(pagination, page, 3, 0, false, true);
                _initPostsList(posts);
            }
        });

    }//GEN-LAST:event_hottestMousePressed

    private void comboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxMouseReleased
        // TODO add your handling code here:
        List<Object> tags = comboBox.getSelectedItems();
    }//GEN-LAST:event_comboBoxMouseReleased

    private void filterIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterIconActionPerformed
        // TODO add your handling code here:
        List<Object> tags = comboBox.getSelectedItems();
        posts = CuocThiDAO.getPostsInfo_ByTags(pagination, 1, 3, tags);
        _initPostsList(posts);

        pagination.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                posts = CuocThiDAO.getPostsInfo_ByTags(pagination, page, 3, tags);
                _initPostsList(posts);
            }
        });
    }//GEN-LAST:event_filterIconActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.firstPage.comboBox.ComboBoxMultiSelection comboBox;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton due;
    private javax.swing.JLabel dueIcon;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton filterIcon;
    private javax.swing.JLabel hotestIcon;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton hottest;
    private javax.swing.JLabel jHello;
    private javax.swing.JScrollPane jScrollPane;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewestCompetitions_new newestCompetitions_new;
    private com.uiteco.OfCuocThiPanel.firstPage.pagination.Pagination pagination;
    private javax.swing.JPanel postList;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    private javax.swing.JPanel slideShowAndPosts;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton solo;
    private javax.swing.JLabel soloIcon;
    private javax.swing.JLabel sort;
    private javax.swing.JLabel tagIcon;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton team;
    private javax.swing.JLabel teamIcon;
    // End of variables declaration//GEN-END:variables

}
