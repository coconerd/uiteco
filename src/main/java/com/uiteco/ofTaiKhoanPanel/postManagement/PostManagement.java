/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel.postManagement;

import static com.uiteco.ofSuKienPanel.SuKienDAO.getPostsOfUser;
import static com.uiteco.main.App.getSession;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import static com.uiteco.ofTaiKhoanPanel.createPost.CreatePostUI.createDialog;
import static com.uiteco.main.App.getMainFrame;
import com.uiteco.ofSuKienPanel.detailed.SuKienDetailScrollPane;
import com.uiteco.ofSuKienPanel.detailed.rightPanel.SuKienDetailRightPanel;
import com.uiteco.swing.ContentPanel;
import java.awt.Cursor;

/**
 *
 * @author nddmi
 */
public class PostManagement extends javax.swing.JPanel {

    public static final String INSTANCE_NAME = "postManagement";

    /**
     * Creates new form PostManagement
     */
    public PostManagement() {
        initComponents();
//        String migConstraint = "wrap 1, gapx 0, gapy 25, insets 10 5 0 5";
//        String migConstraint = ";
        viewport.setLayout(new MigLayout("fillx", "[grow]"));
    }

    public void load() {
        _populatePostList();
        scrollpane.scrollToTop();
    }

    private void _populatePostList() {
        viewport.removeAll();
        try {
            List<SuKienModel> posts = getPostsOfUser(getSession().getUser());
            for (SuKienModel post : posts) {
                PostLine line = new PostLine(post);
                viewport.add(line, "growx, wrap");

                // Add mouse listener for delete button
                line.getDelBtn().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        int option = JOptionPane.showConfirmDialog(viewport, "Bạn có chắc muốn xóa bài viết", "Xác nhận xóa", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if (option != JOptionPane.YES_OPTION) {
                            return;
                        }

                        try {
                            SuKienDAO.deletePost(line.getSuKienModel());
                            viewport.remove(line);
                            viewport.revalidate();
                            viewport.repaint();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

                // Add mouse listener for participants button
                if (post.isEnrollable()) {
                    line.getParticipantsBtn().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent evt) {
                            createDialog("Quản lý người tham gia sự kiện", new ParticipantsTable(line.getSuKienModel()));
                        }
                    });
                } else {
                    line.getParticipantsBtn().setVisible(false);
                }

                line.getEditBtn().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        ContentPanel contentPanel = getMainFrame().getContentPanel();
                        ((UpdatePostUI) contentPanel.getComponent(UpdatePostUI.INSTANCE_NAME)).load(line.getSuKienModel());
                        contentPanel.showComponentAndTrimHistory(UpdatePostUI.INSTANCE_NAME);
                    }
                });

                line.getTitleLabel().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        ContentPanel contentPanel = getMainFrame().getContentPanel();
                        ContentPanel rightPanel = getMainFrame().getRightPanel();
                        try {
                            ((SuKienDetailScrollPane) contentPanel.getComponent(SuKienDetailScrollPane.INSTANCE_NAME)).load(line.getSuKienModel());
                            ((SuKienDetailRightPanel) rightPanel.getComponent(SuKienDetailRightPanel.INSTANCE_NAME)).load(line.getSuKienModel());
                            
                            contentPanel.showComponentAndTrimHistory(SuKienDetailScrollPane.INSTANCE_NAME);
                            rightPanel.showComponentAndTrimHistory(SuKienDetailRightPanel.INSTANCE_NAME);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent evt) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent evt) {
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            viewport.revalidate();
            viewport.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollpane = new com.raven.scroll.ScrollPaneWin11();
        viewport = new com.uiteco.components.RoundedGradientPanel();

        jLabel1.setFont(new java.awt.Font("SVN-Avo", 1, 16)); // NOI18N
        jLabel1.setText("Quản lý các bài đăng");

        scrollpane.setBorder(null);

        viewport.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 20, 20));
        viewport.setColor1(new java.awt.Color(255, 255, 255));
        viewport.setColor2(new java.awt.Color(0, 102, 102));
        viewport.setFade(false);

        javax.swing.GroupLayout viewportLayout = new javax.swing.GroupLayout(viewport);
        viewport.setLayout(viewportLayout);
        viewportLayout.setHorizontalGroup(
            viewportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        viewportLayout.setVerticalGroup(
            viewportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        scrollpane.setViewportView(viewport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.raven.scroll.ScrollPaneWin11 scrollpane;
    private com.uiteco.components.RoundedGradientPanel viewport;
    // End of variables declaration//GEN-END:variables
}
