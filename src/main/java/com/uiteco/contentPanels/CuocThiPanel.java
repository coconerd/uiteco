package com.uiteco.contentPanels;

// Import the necessary package
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.raven.scroll.ScrollPaneUtil;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Controller;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_View;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Controller;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_View;
import com.uiteco.main.App;
import static com.uiteco.main.App.getMainFrame;
import com.uiteco.rightPanels.CuocThiRightPanel_SecondPage;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

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
//action handler

    //private firstPage body = new firstPage();
    //private List<BriefPost_Model> list = new ArrayList<>();
    //private TagsAndSort_new header = new TagsAndSort_new();
    public CuocThiPanel() {
        FlatMacLightLaf.setup();
        initComponents();
        jScrollPane.setBorder(null);
        jScrollPane.setOpaque(false);
        ScrollPaneUtil.configureScrollBar(jScrollPane);
        _initPostsList();
    }

    private List<BriefPost_Model> posts = CuocThiDAO.getPostsInfo_Default();
    private BriefPost_View postUI;
    private final Map<Integer, BriefPost_View> postMap = new HashMap<>();

    private void _initPostsList() {

        setPosts(CuocThiDAO.getPostsInfo_Default());
        for (BriefPost_Model post : getPosts()) {
            setPostUI(new BriefPost_View());

            BriefPost_Controller postController = new BriefPost_Controller(post, getPostUI());

            setPostUI(postController.setData());

            postMap.put(post.getId(), getPostUI());

            postList.add(getPostUI());

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

//    public TagsAndSort_new getHeader() {
//        return header;
//    }
//
//    public CuocThiPanel() {
//        _init();
//        this.add(header);
//
//        this.add(body);
//
//        if (true) {
//            //CuocThiPanel listens to the change of button date of header 
//            header.getTeam()._addPropertyChangeListener((evt) -> {
//                if (evt.getPropertyName().equals("selected")) {
//
//                    list = CuocThiDAO.getPostsInfo_Sort(2, false, false);
//                    body.updateContent(list);
//                }
//            });
//            header.getSolo()._addPropertyChangeListener((evt) -> {
//                if (evt.getPropertyName().equals("selected")) {
//
//                    list = CuocThiDAO.getPostsInfo_Sort(1, false, false);
//                    body.updateContent(list);
//                }
//            });
//            header.getHotest()._addPropertyChangeListener((evt) -> {
//                if (evt.getPropertyName().equals("selected")) {
//
//                    list = CuocThiDAO.getPostsInfo_Sort(0, false, true);
//                    body.updateContent(list);
//                }
//            });
//            header.getDate()._addPropertyChangeListener((evt) -> {
//                if (evt.getPropertyName().equals("selected")) {
//
//                    list = CuocThiDAO.getPostsInfo_Sort(0, true, false);
//                    body.updateContent(list);
//                }
//            });
//            
//            //header.getTagComboBox().
//        }
//
//    }
//    public void sortButtons() {
//
//        Component component = App.getMainFrame().getContentPanel().getComponent("cuocThiPanel");
//
//        if (component instanceof CuocThiPanel competition) {
//            System.out.println("hi");
//            body = competition.body;
//
//        }
//
//    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        comboBox = new com.uiteco.OfCuocThiPanel.Components.comboBox.ComboBoxMultiSelection();
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
        jScrollPane = new javax.swing.JScrollPane();
        slideShowAndPosts = new javax.swing.JPanel();
        newestCompetitions_new = new com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewestCompetitions_new();
        postList = new javax.swing.JPanel();
        jHello = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setMinimumSize(new java.awt.Dimension(100, 34));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(1160, 39));
        roundedPanel1.setRoundBottomLeft(45);
        roundedPanel1.setRoundBottomRight(45);
        roundedPanel1.setRoundTopLeft(45);
        roundedPanel1.setRoundTopRight(45);
        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        comboBox.setPreferredSize(new java.awt.Dimension(600, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        roundedPanel1.add(comboBox, gridBagConstraints);

        sort.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        sort.setText("SORT:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 50);
        roundedPanel1.add(sort, gridBagConstraints);

        solo.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        solo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        solo.setIconTextGap(6);
        solo.setLabel("Cá nhân");
        solo.setPreferredSize(new java.awt.Dimension(140, 54));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 35);
        roundedPanel1.add(solo, gridBagConstraints);

        team.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 28, 1, 1));
        team.setText("Đội nhóm");
        team.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        team.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        team.setIconTextGap(6);
        team.setPreferredSize(new java.awt.Dimension(140, 54));
        team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        roundedPanel1.add(team, gridBagConstraints);

        hottest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        hottest.setText("Hot nhất");
        hottest.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        hottest.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        hottest.setPreferredSize(new java.awt.Dimension(140, 54));
        hottest.setVerifyInputWhenFocusTarget(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 32);
        roundedPanel1.add(hottest, gridBagConstraints);

        due.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        due.setFont(new java.awt.Font("Merriweather", 1, 18)); // NOI18N
        due.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        due.setLabel("Đến hạn");
        due.setPreferredSize(new java.awt.Dimension(140, 54));
        due.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 41);
        roundedPanel1.add(due, gridBagConstraints);

        tagIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-tag-28.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 25);
        roundedPanel1.add(tagIcon, gridBagConstraints);

        soloIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-person-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 12);
        roundedPanel1.add(soloIcon, gridBagConstraints);

        teamIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-team-25.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        roundedPanel1.add(teamIcon, gridBagConstraints);

        hotestIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-hot-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        roundedPanel1.add(hotestIcon, gridBagConstraints);

        dueIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/icons8-time-24.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        roundedPanel1.add(dueIcon, gridBagConstraints);

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
        slideShowAndPosts.setLayout(new java.awt.GridBagLayout());

        newestCompetitions_new.setPreferredSize(new java.awt.Dimension(1500, 850));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        slideShowAndPosts.add(newestCompetitions_new, gridBagConstraints);

        postList.setBackground(new java.awt.Color(242, 243, 244));
        postList.setLayout(new java.awt.GridLayout(0, 1, 0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 30, 0);
        slideShowAndPosts.add(postList, gridBagConstraints);

        jScrollPane.setViewportView(slideShowAndPosts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 40, 35);
        add(jScrollPane, gridBagConstraints);

        jHello.setFont(new java.awt.Font("Merriweather", 2, 26)); // NOI18N
        jHello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_files/waving-hand_9837221.png"))); // NOI18N
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
        // TODO add your handling code here:
    }//GEN-LAST:event_teamActionPerformed

    private void dueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.Components.comboBox.ComboBoxMultiSelection comboBox;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton due;
    private javax.swing.JLabel dueIcon;
    private javax.swing.JLabel hotestIcon;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton hottest;
    private javax.swing.JLabel jHello;
    private javax.swing.JScrollPane jScrollPane;
    private com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewestCompetitions_new newestCompetitions_new;
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
