/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.forum;
import com.forum.database.BaiDangForumDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostPanel extends javax.swing.JPanel {
    private String title;
    private int viewNumber;
    private String postedBy;
    private int responseNumber;
    private LocalDateTime postingDate;
    private int postID;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(int responseNumber) {
        this.responseNumber = responseNumber;
    }

    public LocalDateTime getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDateTime postingDate) {
        this.postingDate = postingDate;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public PostPanel() {
        //initComponents();
    }
    
    public PostPanel(int postID, String title, int viewNumber, int responseNumber, String postedBy, LocalDateTime postingDate, String content) {
        InitComponents(postID, title, viewNumber, responseNumber, postedBy, postingDate, content);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 247, 226));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void InitComponents(int postID, String title, int viewNumber, int responseNumber, String postedBy, LocalDateTime postingDate, String content){
        this.postID = postID;
        this.title = title;
        this.viewNumber = viewNumber;
        this.responseNumber = responseNumber;
        this.postedBy = postedBy; 
        this.postingDate = postingDate;
        this.content = content;
        
        setPreferredSize(new java.awt.Dimension(1063,70));
        setMaximumSize(this.getPreferredSize());
        setBackground(new java.awt.Color(247,247,226));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(18,0)));
        
        titleLabel = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titlePanel.setBackground(new java.awt.Color(247,247,226));
        titlePanel.setPreferredSize(new java.awt.Dimension(510, 60));
        titlePanel.setMaximumSize(titlePanel.getPreferredSize());
        titleLabel.setForeground(new java.awt.Color(19,117,214));
        titleLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        titleLabel.setMaximumSize(titlePanel.getPreferredSize());
        titleLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        titleLabel.setText("<html> "+this.title+" </html>");
        titleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                titleLabel.setForeground(new java.awt.Color(39,109,179));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                titleLabel.setForeground(new java.awt.Color(19,117,214));
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                int mabaidang = getPostID();
                System.out.println("Ban vua moi click vao title cua bai dang co MABDFORUM la: "+mabaidang);
                /*cập nhật LUOTXEM+1 cho trường LUOTXEM của table BAIDANGFORUM*/
                BaiDangForumDAO.increaseViewNumber(mabaidang);
                /*hiển thị giao diện chi tiết bài đăng cùng với các bình luận phản hồi của bài đăng*/
                com.forum.PostListPanel postlist = (com.forum.PostListPanel)getParent();
                javax.swing.JPanel panel = (javax.swing.JPanel)postlist.getParent();
                javax.swing.JViewport viewport = (javax.swing.JViewport)panel.getParent();
                com.raven.scroll.ScrollPaneWin11 scrollpane = (com.raven.scroll.ScrollPaneWin11)viewport.getParent();
                com.uiteco.contentPanels.ForumPanel forum = (com.uiteco.contentPanels.ForumPanel)scrollpane.getParent();
                forum.showPostDetailAndReplyView(mabaidang);
            }
        });
        titleLabel.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        titlePanel.setLayout(new javax.swing.BoxLayout(titlePanel,javax.swing.BoxLayout.X_AXIS));
        titlePanel.add(titleLabel);
        add(titlePanel);

  
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(75,0)));
        statisticPanel = new javax.swing.JPanel();
        statisticLabel = new javax.swing.JLabel();
        statisticPanel.setPreferredSize(new java.awt.Dimension(150,60));
        statisticLabel.setMaximumSize(statisticPanel.getPreferredSize());
        statisticPanel.setMaximumSize(statisticPanel.getPreferredSize());
        statisticPanel.setBackground(new java.awt.Color(247,247,226));
        statisticLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        statisticLabel.setText("<html>"+String.valueOf(this.viewNumber)+" views<br>"+ String.valueOf(this.responseNumber)+" responses</html>");
        statisticLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        
        statisticPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        statisticPanel.add(statisticLabel);
        add(statisticPanel);
        
        
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(85,0)));
        postedByPanel = new javax.swing.JPanel();
        postedByLabel = new javax.swing.JLabel();
        postedByPanel.setPreferredSize(new java.awt.Dimension(190,60));
        postedByPanel.setBackground(new java.awt.Color(247,247,226));
        postedByPanel.setMaximumSize(postedByPanel.getPreferredSize());
        int loaitaikhoan = BaiDangForumDAO.getLoaiTaiKhoan(this.postedBy);
        if(loaitaikhoan == 2){ //là tài khoản sinh viên
            postedByLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-24.png"))); 
        }
        else if(loaitaikhoan == 1){ //là tài khoản admin
            postedByLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-admin-24.png")));
        } 
        else if(loaitaikhoan == 3){ //là tài khoản cựu sinh viên
            postedByLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-24_1.png")));
        }
        else if(loaitaikhoan == 4){ //là tài khoản giảng viên
            postedByLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-test-account-24.png")));
        }
        
        postedByLabel.setMaximumSize(postedByPanel.getPreferredSize());
        postedByLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        postedByLabel.setText("<html>"+this.postedBy+"<br>"+this.postingDate.format(formatter)+"</html>");
        postedByLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
             
        postedByPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        postedByPanel.add(postedByLabel);
        add(postedByPanel);
        add(javax.swing.Box.createRigidArea(new java.awt.Dimension(15,0)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JLabel postedByLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JPanel postedByPanel;
}
