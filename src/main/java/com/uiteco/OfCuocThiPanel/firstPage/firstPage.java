package com.uiteco.OfCuocThiPanel.firstPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static com.raven.scroll.ScrollPaneUtil.configureScrollBar;
import com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewstCompetitions;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Controller;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_View;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_View_new;
import com.uiteco.main.App;
import static com.uiteco.main.App.getMainFrame;
import com.uiteco.rightPanels.CuocThiRightPanel_SecondPage;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class firstPage extends javax.swing.JPanel {

    /**
     * @param postUI the postUI to set
     */
    public void setPostUI(BriefPost_View postUI) {
        this.postUI = postUI;
    }

    /**
     * @return the jPanel2
     */
    public JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(List<BriefPost_Model> posts) {
        this.posts = posts;
    }

    private final Pagination pagination = new Pagination();
    private final Map<Integer, BriefPost_View> postMap = new HashMap<>();
    private BriefPost_View postUI;
    private List<BriefPost_Model> posts = CuocThiDAO.getPostsInfo_Default();

    public firstPage() {
        FlatMacLightLaf.setup();
        _initComponents(posts);
        setBounds(30, 105, 1185, 840);
        setBorder(null);
        setOpaque(false);

    }

    public void updateContent(List<BriefPost_Model> posts) {

        jPanel2.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 29, 20, 10);
        gbc.gridx = 0; //first row
        gbc.gridy = 0; //first col
        gbc.anchor = GridBagConstraints.CENTER;

        for (BriefPost_Model post : posts) {
            postUI = new BriefPost_View();

            BriefPost_Controller postController = new BriefPost_Controller(post, postUI);

            postUI = postController.setData();

            postMap.put(post.getId(), postUI);

            jPanel2.add(postUI, gbc);
            gbc.gridy++;

            postUI.getjTitle().addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {

                    //find the OnePost_View instance that was clicked 
                    for (Map.Entry<Integer, BriefPost_View> entry : postMap.entrySet()) {

                        if (entry.getValue().getjTitle().equals(e.getSource())) {
                            int clickedPostID = entry.getKey();
                            for (BriefPost_Model post : posts) {
                                if (post.getId() == clickedPostID) {

                                    Component comp = App.getMainFrame().getContentPanel().getComponent("cuocThiDetailedPanel");
                                    if (comp instanceof DetailedOnePost_View) {
                                        DetailedOnePost_View_new detailedPanel = (DetailedOnePost_View_new) comp;
                                        DetailedOnePost_Controller detailedController = detailedPanel.createController(post);

                                        detailedPanel = detailedController.setData(post);

                                        getMainFrame().getContentPanel().showComponentAndTrimHistory("cuocThiDetailedPanel");
                                    }

                                    Component compRight = App.getMainFrame().getRightPanel().getComponent("cuocThỉRightPanel_SecondPage");
                                    if (compRight instanceof CuocThiRightPanel_SecondPage) {
                                        //CuocThiRightPanel rightPanel = (CuocThiRightPanel) compRight;
                                        CuocThiRightPanel_SecondPage rightPanel = new CuocThiRightPanel_SecondPage();
                                        rightPanel.actionPressButton();
                                        getMainFrame().getRightPanel().showComponentAndTrimHistory("cuocThiRightPanel_SecondPage");
                                    }

                                }
                            }

                        }

                    }
                }
            });
        }

        jPanel2.setVisible(true);

        jPanel2.repaint();

        jPanel2.revalidate();

    }

    public void _initComponents(List<BriefPost_Model> posts) {

        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        configureScrollBar(scrollPane);

        jPanel1 = new javax.swing.JPanel();
        NewstCompetitions newestCompetitions2 = new NewstCompetitions();
        setjPanel2(new javax.swing.JPanel());

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(newestCompetitions2, BorderLayout.NORTH);
        
        setjPanel2(new javax.swing.JPanel());
        getjPanel2().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 34, 5, 0);
        gbc.gridx = 0; //first row
        gbc.gridy = 0; //first col
        gbc.anchor = GridBagConstraints.CENTER;

        // Set up the pagination event
        pagination.setPaginationItemRender(new PaginationItemRenderStyle1());

//        pagination.addEventPagination(new EventPagination() {
//            @Override
//            public void pageChanged(int page) {
//                pagination.setPagegination(page, posts.size());
        setPosts(CuocThiDAO.getPostsInfo_Default());
        for (BriefPost_Model post : posts) {
            setPostUI(new BriefPost_View());

            BriefPost_Controller postController = new BriefPost_Controller(post, postUI);

            setPostUI(postController.setData());

            postMap.put(post.getId(), postUI);

            getjPanel2().add(postUI, gbc);
            gbc.gridy++;

            postUI.getjTitle().addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {

                    //find the OnePost_View instance that was clicked 
                    for (Map.Entry<Integer, BriefPost_View> entry : postMap.entrySet()) {

                        if (entry.getValue().getjTitle().equals(e.getSource())) {
                            int clickedPostID = entry.getKey();
                            for (BriefPost_Model post : posts) {
                                if (post.getId() == clickedPostID) {

                                    Component comp = App.getMainFrame().getContentPanel().getComponent("cuocThiDetailedPanel");
                                    if (comp instanceof DetailedOnePost_View) {
                                        DetailedOnePost_View_new detailedPanel = (DetailedOnePost_View_new) comp;
                                        DetailedOnePost_Controller detailedController = detailedPanel.createController(post);

                                        detailedPanel = detailedController.setData(post);

                                        getMainFrame().getContentPanel().showComponentAndTrimHistory("cuocThiDetailedPanel");
                                    }

                                    Component compRight = App.getMainFrame().getRightPanel().getComponent("cuocThiRightPanel_SecondPage");
                                    if (compRight instanceof CuocThiRightPanel_SecondPage) {
                                        CuocThiRightPanel_SecondPage rightPanel = (CuocThiRightPanel_SecondPage) compRight;
                                        rightPanel.setPostID(post.id);
                                        getMainFrame().getRightPanel().showComponentAndTrimHistory("cuocThiRightPanel_SecondPage");
                                        
                                    }

                                }
                            }

                        }

                    }
                }
            });
            getjPanel2().revalidate();
            getjPanel2().repaint();
        }

        //});
        Box space = Box.createVerticalBox();
        space.add(Box.createRigidArea(new Dimension(1185, 40)));
        space.add(jPanel1, Component.CENTER_ALIGNMENT);
        jPanel1.add(getjPanel2(), BorderLayout.CENTER);

        //});
        pagination.setBorder(BorderFactory.createEmptyBorder(0, 500, 0, 0));
        jPanel1.add(pagination, BorderLayout.SOUTH);

        scrollPane.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    @SuppressWarnings("unchecked")
    //private final DetailedPost_View detailedPanel = new DetailedPost_View();

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1057, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1057, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private JScrollPane scrollPane;
    private JPanel jPanel1;
    private JPanel jPanel2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
