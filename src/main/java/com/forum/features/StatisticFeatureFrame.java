/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.forum.features;
import com.forum.database.BaiDangForumDAO;
import java.awt.Cursor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StatisticFeatureFrame extends javax.swing.JFrame {
    private int postID;
    private int viewNumbers;
    private int replyNumbers;
    private String postedBy;
    private LocalDateTime postedAt;

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getViewNumbers() {
        return viewNumbers;
    }

    public void setViewNumbers(int viewNumbers) {
        this.viewNumbers = viewNumbers;
    }

    public int getReplyNumbers() {
        return replyNumbers;
    }

    public void setReplyNumbers(int replyNumbers) {
        this.replyNumbers = replyNumbers;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public StatisticFeatureFrame(int mabaidang) {
        this.postID = mabaidang;
        _initComponents(mabaidang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        postIDLabel = new javax.swing.JLabel();
        jTextFieldOfPostID = new javax.swing.JTextField();
        postedByLabel = new javax.swing.JLabel();
        postedAtLabel = new javax.swing.JLabel();
        viewNumberLabel = new javax.swing.JLabel();
        replyNumberLabel = new javax.swing.JLabel();
        jTextFieldOfPostedBy = new javax.swing.JTextField();
        jTextFieldOfPostedAt = new javax.swing.JTextField();
        jTextFieldOfViewNumbers = new javax.swing.JTextField();
        jTextFieldOfReplyNumbers = new javax.swing.JTextField();
        statisticLabel = new javax.swing.JLabel();
        uitLabel = new javax.swing.JLabel();
        iconRightLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(176, 186, 197));

        mainPanel.setBackground(new java.awt.Color(238, 247, 248));

        postIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        postIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postIDLabel.setText("Post ID");

        jTextFieldOfPostID.setEditable(false);
        jTextFieldOfPostID.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostID.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostID.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        postedByLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postedByLabel.setForeground(new java.awt.Color(0, 0, 0));
        postedByLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postedByLabel.setText("Posted by");

        postedAtLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postedAtLabel.setForeground(new java.awt.Color(0, 0, 0));
        postedAtLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postedAtLabel.setText("Posted at");

        viewNumberLabel.setBackground(new java.awt.Color(255, 255, 204));
        viewNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        viewNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewNumberLabel.setText("View numbers");

        replyNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        replyNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        replyNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        replyNumberLabel.setText("Reply numbers");

        jTextFieldOfPostedBy.setEditable(false);
        jTextFieldOfPostedBy.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldOfPostedBy.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostedBy.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        jTextFieldOfPostedAt.setEditable(false);
        jTextFieldOfPostedAt.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostedAt.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostedAt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        jTextFieldOfViewNumbers.setEditable(false);
        jTextFieldOfViewNumbers.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfViewNumbers.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfViewNumbers.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        jTextFieldOfReplyNumbers.setEditable(false);
        jTextFieldOfReplyNumbers.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfReplyNumbers.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfReplyNumbers.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        statisticLabel.setFont(new java.awt.Font("Sitka Heading", 1, 28)); // NOI18N
        statisticLabel.setForeground(new java.awt.Color(0, 102, 102));
        statisticLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statisticLabel.setText("STATISTIC");

        uitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uit (1).png"))); // NOI18N

        iconRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconRightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-analysis-65.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(postedAtLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(postIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(replyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldOfViewNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jTextFieldOfPostedAt)
                            .addComponent(jTextFieldOfPostID)
                            .addComponent(jTextFieldOfPostedBy)
                            .addComponent(jTextFieldOfReplyNumbers))
                        .addGap(71, 71, 71))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(statisticLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)))
                .addComponent(iconRightLabel)
                .addGap(98, 98, 98))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(uitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(iconRightLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(statisticLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedAtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostedAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextFieldOfViewNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfReplyNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void _initComponents(int mabaidang) {
        ArrayList <Object> list = BaiDangForumDAO.getInfomationToShowStatisticFrame(mabaidang);
        this.postedBy = (String)list.get(0);
        this.postedAt = (LocalDateTime)list.get(1);
        this.viewNumbers = (int)list.get(2);
        this.replyNumbers = (int)list.get(3);
        mainPanel = new javax.swing.JPanel();
        postIDLabel = new javax.swing.JLabel();
        jTextFieldOfPostID = new javax.swing.JTextField();
        postedByLabel = new javax.swing.JLabel();
        postedAtLabel = new javax.swing.JLabel();
        viewNumberLabel = new javax.swing.JLabel();
        replyNumberLabel = new javax.swing.JLabel();
        jTextFieldOfPostedBy = new javax.swing.JTextField();
        jTextFieldOfPostedAt = new javax.swing.JTextField();
        jTextFieldOfViewNumbers = new javax.swing.JTextField();
        jTextFieldOfReplyNumbers = new javax.swing.JTextField();
        statisticLabel = new javax.swing.JLabel();
        uitLabel = new javax.swing.JLabel();
        iconRightLabel = new javax.swing.JLabel();
        /*DISPOSE_ON_CLOSE chỉ định rằng chỉ có mỗi JFrame này bị đóng và không ảnh hưởng đến các tác vụ khác của ứng dụng 
        chứ không phải như EXIT_ON_CLOSE mà ứng dụng sẽ kết thúc hoàn toàn và tất cả các tác vụ đang chạy sẽ bị dừng*/
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        setBackground(new java.awt.Color(176, 186, 197));

        mainPanel.setBackground(new java.awt.Color(238, 247, 248));

        postIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        postIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postIDLabel.setText("Post ID");

        jTextFieldOfPostID.setEditable(false);
        jTextFieldOfPostID.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostID.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostID.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jTextFieldOfPostID.setText(""+this.postID);
        jTextFieldOfPostID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //Nothing to do
            }
        });

        postedByLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postedByLabel.setForeground(new java.awt.Color(0, 0, 0));
        postedByLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postedByLabel.setText("Posted by");

        postedAtLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        postedAtLabel.setForeground(new java.awt.Color(0, 0, 0));
        postedAtLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postedAtLabel.setText("Posted at");

        viewNumberLabel.setBackground(new java.awt.Color(255, 255, 204));
        viewNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        viewNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        viewNumberLabel.setText("View numbers");

        replyNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        replyNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        replyNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        replyNumberLabel.setText("Reply numbers");

        jTextFieldOfPostedBy.setEditable(false);
        jTextFieldOfPostedBy.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostedBy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldOfPostedBy.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostedBy.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jTextFieldOfPostedBy.setText(this.postedBy);
        jTextFieldOfPostedBy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //Nothing to do
            }
        });

        jTextFieldOfPostedAt.setEditable(false);
        jTextFieldOfPostedAt.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPostedAt.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPostedAt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        jTextFieldOfPostedAt.setText(this.postedAt.format(formatter));
        jTextFieldOfPostedAt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //Nothing to do
            }
        });

        jTextFieldOfViewNumbers.setEditable(false);
        jTextFieldOfViewNumbers.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfViewNumbers.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfViewNumbers.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jTextFieldOfViewNumbers.setText(""+this.viewNumbers);
        jTextFieldOfViewNumbers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //Nothing to do
            }
        });

        jTextFieldOfReplyNumbers.setEditable(false);
        jTextFieldOfReplyNumbers.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfReplyNumbers.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfReplyNumbers.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jTextFieldOfReplyNumbers.setText(""+this.replyNumbers);
        jTextFieldOfReplyNumbers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                //Nothing to do
            }
        });

        statisticLabel.setFont(new java.awt.Font("Sitka Heading", 1, 28)); // NOI18N
        statisticLabel.setForeground(new java.awt.Color(0, 102, 102));
        statisticLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statisticLabel.setText("STATISTIC");

        uitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uit (1).png"))); // NOI18N

        iconRightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconRightLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-analysis-65.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(postedAtLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(postIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(replyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldOfViewNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jTextFieldOfPostedAt)
                            .addComponent(jTextFieldOfPostID)
                            .addComponent(jTextFieldOfPostedBy)
                            .addComponent(jTextFieldOfReplyNumbers))
                        .addGap(71, 71, 71))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(statisticLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)))
                .addComponent(iconRightLabel)
                .addGap(98, 98, 98))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(uitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(iconRightLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(statisticLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postedAtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfPostedAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jTextFieldOfViewNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOfReplyNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconRightLabel;
    private javax.swing.JTextField jTextFieldOfPostID;
    private javax.swing.JTextField jTextFieldOfPostedAt;
    private javax.swing.JTextField jTextFieldOfPostedBy;
    private javax.swing.JTextField jTextFieldOfReplyNumbers;
    private javax.swing.JTextField jTextFieldOfViewNumbers;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel postIDLabel;
    private javax.swing.JLabel postedAtLabel;
    private javax.swing.JLabel postedByLabel;
    private javax.swing.JLabel replyNumberLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JLabel uitLabel;
    private javax.swing.JLabel viewNumberLabel;
    // End of variables declaration//GEN-END:variables
}
