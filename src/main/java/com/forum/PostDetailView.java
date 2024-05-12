/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.forum;
import com.forum.database.BaiDangForumDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author 21H1 HNQA
 */
public class PostDetailView extends javax.swing.JPanel {
    private String title;
    private LocalDateTime postingTimeStamp;
    private String content;
    private String postingPerson;
    private int postID;
    private int replyForMABLPHANHOI; //bình luận này đang bình luận cho mã bình luận nào MABLPHANHOI
    private int replyID; //mã bình luận MABL

    public int getReplyForPostID() {
        return replyForMABLPHANHOI;
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public void setReplyForPostID(int replyForMABLPHANHOI) {
        this.replyForMABLPHANHOI = replyForMABLPHANHOI;
    }
    
    
    public int getpostID() {
        return postID;
    }

    public void setpostID(int postID) {
        this.postID = postID;
    }

    public String getPostingPerson() {
        return postingPerson;
    }

    public void setPostingPerson(String postingPerson) {
        this.postingPerson = postingPerson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPostingTimeStamp() {
        return postingTimeStamp;
    }

    public void setPostingTimeStamp(LocalDateTime postingTimeStamp) {
        this.postingTimeStamp = postingTimeStamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    public PostDetailView(int mabaidang) {
        //initComponents();
        this.postID = mabaidang;
        _initComponents(mabaidang); // constructor này để khởi tạo PostDetailView để hiển thị chi tiết bài đăng khi người dùng click chuột vào title của bài đăng nào đó được hiển thị ở giao diện chính của forum
    }
    public PostDetailView(int postID, int replyID, int replyForMABLPHANHOI, String replyPerson, LocalDateTime replyTime, String content){
        /*hàm này dùng để khởi tạo các bình luận của mã bài đăng được truyền vào và được load dữ liệu từ csdl, sau đó khởi tạo thành các PostDetailView*/
        initComponent(postID, replyID, replyForMABLPHANHOI, replyPerson, replyTime, content);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        userimageLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        scrollPaneContent = new com.raven.scroll.ScrollPaneWin11();
        contentPanel = new javax.swing.JPanel();
        contentLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        leftPanel.setBackground(new java.awt.Color(235, 235, 235));

        userimageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-80.png"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Công Phan");
        usernameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(userimageLabel)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(userimageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(204, 255, 204));

        titlePanel.setBackground(new java.awt.Color(242, 247, 232));

        titleLabel.setBackground(new java.awt.Color(242, 247, 232));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("title và thời điểm đăng");
        titleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        scrollPaneContent.setBorder(null);
        scrollPaneContent.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneContent.setViewportView(contentPanel);

        contentPanel.setBackground(new java.awt.Color(242, 247, 232));

        contentLabel.setForeground(new java.awt.Color(0, 0, 0));
        contentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contentLabel.setText("kk");
        contentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        scrollPaneContent.setViewportView(contentPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPaneContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
        private void initComponent(int postID, int replyID, int replyForMABLPHANHOI, String replyPerson, LocalDateTime replyTimeStamp, String content){
            this.postID = postID;
            this.content = content;
            this.postingTimeStamp = replyTimeStamp;
            this.postingPerson = replyPerson;
            this.replyForMABLPHANHOI = replyForMABLPHANHOI;
            this.replyID = replyID;
            
            leftPanel = new javax.swing.JPanel();
            userimageLabel = new javax.swing.JLabel();
            usernameLabel = new javax.swing.JLabel();
            mainPanel = new javax.swing.JPanel();
            titlePanel = new javax.swing.JPanel();
            titleLabel = new javax.swing.JLabel();
            scrollPaneContent = new com.raven.scroll.ScrollPaneWin11();
            contentPanel = new javax.swing.JPanel();
            contentLabel = new javax.swing.JLabel();

            setBackground(new java.awt.Color(255, 255, 255));

            leftPanel.setBackground(new java.awt.Color(235, 235, 235));

            userimageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-80.png"))); // NOI18N

            usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
            usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            usernameLabel.setText("<html>"+this.postingPerson+"<br>Reply ID: "+this.replyID+"</html>");
            usernameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
            leftPanel.setLayout(leftPanelLayout);
            leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(userimageLabel)
                    .addContainerGap(50, Short.MAX_VALUE))
            );
            leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leftPanelLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(userimageLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            mainPanel.setBackground(new java.awt.Color(204, 255, 204));

            titlePanel.setBackground(new java.awt.Color(242, 247, 232));

            titleLabel.setBackground(new java.awt.Color(242, 247, 232));
            titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            titleLabel.setForeground(new java.awt.Color(0, 0, 0));
            titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            titleLabel.setText("<html>"+this.postingTimeStamp.format(formatter)+"<br><i>Phản hồi cho mã bình luận(Reply ID): "+this.replyForMABLPHANHOI+"</i></html>");
            titleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
            titlePanel.setLayout(titlePanelLayout);
            titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
            );

            scrollPaneContent.setBorder(null);
            scrollPaneContent.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            contentPanel.setBackground(new java.awt.Color(242, 247, 232));

            contentLabel.setForeground(new java.awt.Color(0, 0, 0));
            contentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            contentLabel.setText(this.content);
            contentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
            contentPanel.setLayout(contentPanelLayout);
            contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
            );

            scrollPaneContent.setViewportView(contentPanel);
            java.awt.Insets insets = new java.awt.Insets(0, 0, 0, 13); // top, left, bottom, right
            contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));            

            javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);
            mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)
                    .addComponent(scrollPaneContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }
        private void _initComponents(int mabaidang) {
        ArrayList <Object> list = BaiDangForumDAO.getDataIntoPostDetailView(mabaidang);
        this.postingPerson = (String)list.get(0);
        this.postingTimeStamp = (LocalDateTime)list.get(1);
        this.title = (String)list.get(2);
        this.content = (String)list.get(3);
        
        leftPanel = new javax.swing.JPanel();
        userimageLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        scrollPaneContent = new com.raven.scroll.ScrollPaneWin11();
        contentPanel = new javax.swing.JPanel();
        contentLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        leftPanel.setBackground(new java.awt.Color(235, 235, 235));

        userimageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-80.png"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("<html>"+this.postingPerson+"<br><ROOT></html>");
        usernameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(userimageLabel)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(userimageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(204, 255, 204));

        titlePanel.setBackground(new java.awt.Color(242, 247, 232));

        titleLabel.setBackground(new java.awt.Color(242, 247, 232));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        titleLabel.setText("<html><b>"+this.title+"</b><br><i>"+this.postingTimeStamp.format(formatter)+"</i></html>");
        titleLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        scrollPaneContent.setBorder(null);
        scrollPaneContent.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contentPanel.setBackground(new java.awt.Color(242, 247, 232));

        contentLabel.setForeground(new java.awt.Color(0, 0, 0));
        contentLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contentLabel.setText(this.content);
        contentLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        scrollPaneContent.setViewportView(contentPanel);
        java.awt.Insets insets = new java.awt.Insets(0, 0, 0, 13); // top, left, bottom, right
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollPaneContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contentLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private com.raven.scroll.ScrollPaneWin11 scrollPaneContent;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel userimageLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
