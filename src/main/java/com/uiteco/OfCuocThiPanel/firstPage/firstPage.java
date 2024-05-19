package com.uiteco.OfCuocThiPanel.firstPage;

import com.uiteco.OfCuocThiPanel.firstPage.slideShow.NewstCompetitions;
import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.OfCuocThiPanel.getDataFromDB.CuocThiData;
import com.uiteco.OfCuocThiPanel.firstPage.slideShow.Pagination;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_Controller;
import com.uiteco.OfCuocThiPanel.secondPage.DetailedOnePost_View;
import com.uiteco.main.App;
import static com.uiteco.main.App.getMainFrame;
import com.uiteco.swing.ContentPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class firstPage extends javax.swing.JPanel {

    /**
     * Creates new form testing2
     */
    public firstPage() {
        _initComponents();
        setBounds(30, 120, 1185, 800);
        setBorder(null);
        setOpaque(false);

    }

    private void _initComponents() {

        scrollPaneWin111 = new com.raven.scroll.ScrollPaneWin11();
        scrollPaneWin111.setBorder(null);
        jPanel1 = new javax.swing.JPanel();
        NewstCompetitions newestCompetitions2 = new NewstCompetitions();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(newestCompetitions2, BorderLayout.NORTH);
        jPanel1.add(Box.createVerticalStrut(25));

        jPanel2 = new javax.swing.JPanel();
        jPanel2.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; //first row
        gbc.gridy = 0; //first col
        gbc.anchor = GridBagConstraints.CENTER;

        List<BriefPost_Model> fetchedPosts = CuocThiData.getPostsInfo();
        Map<Integer, BriefPost_View> postMap = new HashMap<>();
        //show all posts 
        for (int i = 0; i < fetchedPosts.size(); i++) {
            postUI = new BriefPost_View();

            BriefPost_Controller postController = new BriefPost_Controller(fetchedPosts.get(i), postUI);
            postUI = postController.setData();
            
            postMap.put(fetchedPosts.get(i).getId(), postUI);

            jPanel2.add(postUI, gbc);
            gbc.gridy++;

        }

        //when click on a post's title
        postUI.getjTitle().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                //find the OnePost_View instance that was clicked 
                for (Map.Entry<Integer, BriefPost_View> entry : postMap.entrySet()) {

                    if (entry.getValue().getjTitle().equals(e.getSource())) {
                        int clickedPostID = entry.getKey();
                        for (BriefPost_Model post : fetchedPosts) {
                            if (post.getId() == clickedPostID) {
                                
                                ContentPanel panel = getMainFrame().getContentPanel();
                                Component comp = App.getMainFrame().getContentPanel().getComponent("cuocThiDetailedPanel");
                                if (comp instanceof DetailedOnePost_View) {
                                    DetailedOnePost_View detailedPanel = (DetailedOnePost_View) comp;
                                    
                                    DetailedOnePost_Controller detailedController = new DetailedOnePost_Controller(detailedPanel, post);
                                    
                                    detailedPanel = detailedController.setData(post);
                                    //postUI.jCountLike.setText(detailedPanel.getCountLike_Update());

                                    getMainFrame().getContentPanel().showComponentAndTrimHistory("cuocThiDetailedPanel");
                                }

                            }
                        }

                    }

                }
            }
        });

        jPanel1.add(jPanel2, BorderLayout.CENTER);

        pagination = new Pagination();
        jPanel1.add(pagination, BorderLayout.SOUTH);

        scrollPaneWin111.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    //private final DetailedPost_View detailedPanel = new DetailedPost_View();
    private Pagination pagination;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1057, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private BriefPost_View postUI;
    private ScrollPaneWin11 scrollPaneWin111;
    private JPanel jPanel1;
    private JPanel jPanel2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
