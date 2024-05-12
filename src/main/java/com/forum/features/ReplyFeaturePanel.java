/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.forum.features;

import com.forum.database.BaiDangForumDAO;

/**
 *
 * @author 21H1 HNQA
 */
public class ReplyFeaturePanel extends javax.swing.JPanel {
    private int postID;
    
    public int getPostID(){
        return postID;
    }
    public void setPostID(int postID){
        this.postID = postID;
    }
    public ReplyFeaturePanel(int mabaidang) {
        //initComponents();
        this.postID = mabaidang;
        _initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        uitImageLabel = new javax.swing.JLabel();
        forumImageLabel = new javax.swing.JLabel();
        ecoLabel = new javax.swing.JLabel();
        jScrollPaneOfContentReply = new javax.swing.JScrollPane();
        jTextAreaOfContentReply = new javax.swing.JTextArea();
        replyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jTextFieldOfMABLPHANHOI = new javax.swing.JTextField();

        setBackground(new java.awt.Color(248, 242, 242));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(30, 30, 14));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("REPLY BÀI ĐĂNG FORUM");

        uitImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uitImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uit(3).png"))); // NOI18N

        forumImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forumImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-communication-85.png"))); // NOI18N

        ecoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ecoLabel.setForeground(new java.awt.Color(80, 80, 181));
        ecoLabel.setText("ECO-FORUM");

        jTextAreaOfContentReply.setBackground(new java.awt.Color(255, 255, 255));
        jTextAreaOfContentReply.setColumns(20);
        jTextAreaOfContentReply.setForeground(new java.awt.Color(0, 0, 0));
        jTextAreaOfContentReply.setLineWrap(true);
        jTextAreaOfContentReply.setRows(5);
        jTextAreaOfContentReply.setText("<Nhập nội dung phản hồi của bạn tại đây>");
        jTextAreaOfContentReply.setToolTipText("Nhập nội dung phản hồi của bạn tại đây");
        jTextAreaOfContentReply.setWrapStyleWord(true);
        jScrollPaneOfContentReply.setViewportView(jTextAreaOfContentReply);

        replyButton.setBackground(new java.awt.Color(172, 172, 172));
        replyButton.setForeground(new java.awt.Color(0, 0, 0));
        replyButton.setText("Reply");
        replyButton.setFocusable(false);

        cancelButton.setBackground(new java.awt.Color(172, 172, 172));
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelButton.setText("Cancel");
        cancelButton.setFocusable(false);

        jTextFieldOfMABLPHANHOI.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfMABLPHANHOI.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfMABLPHANHOI.setText("Nhập mã bình luận mà bạn muốn phản hồi");
        jTextFieldOfMABLPHANHOI.setToolTipText("Nhập mã bình luận mà bạn muốn phản hồi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replyButton)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uitImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addGap(106, 106, 106)
                                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                                .addGap(68, 68, 68))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jTextFieldOfMABLPHANHOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forumImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPaneOfContentReply)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forumImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(uitImageLabel))
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldOfMABLPHANHOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jScrollPaneOfContentReply, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents
        
        private void _initComponents() {
            titleLabel = new javax.swing.JLabel();
            uitImageLabel = new javax.swing.JLabel();
            forumImageLabel = new javax.swing.JLabel();
            ecoLabel = new javax.swing.JLabel();
            jScrollPaneOfContentReply = new javax.swing.JScrollPane();
            jTextAreaOfContentReply = new javax.swing.JTextArea();
            replyButton = new javax.swing.JButton();
            cancelButton = new javax.swing.JButton();
            jTextFieldOfMABLPHANHOI = new javax.swing.JTextField();

            setBackground(new java.awt.Color(248, 242, 242));

            titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            titleLabel.setForeground(new java.awt.Color(30, 30, 14));
            titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            titleLabel.setText("REPLY BÀI ĐĂNG FORUM");

            uitImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            uitImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uit(3).png"))); // NOI18N

            forumImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            forumImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-communication-85.png"))); // NOI18N

            ecoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
            ecoLabel.setForeground(new java.awt.Color(80, 80, 181));
            ecoLabel.setText("ECO-FORUM");

            jTextAreaOfContentReply.setBackground(new java.awt.Color(255, 255, 255));
            jTextAreaOfContentReply.setColumns(20);
            jTextAreaOfContentReply.setForeground(new java.awt.Color(0, 0, 0));
            jTextAreaOfContentReply.setLineWrap(true);
            jTextAreaOfContentReply.setRows(5);
            jTextAreaOfContentReply.setText("<Nhập nội dung phản hồi của bạn tại đây>");
            jTextAreaOfContentReply.setToolTipText("Nhập nội dung phản hồi của bạn tại đây");
            jTextAreaOfContentReply.setWrapStyleWord(true);
            jTextAreaOfContentReply.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                     jTextAreaOfContentReply.getCaret().setVisible(true);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    if(jTextAreaOfContentReply.getText().isEmpty()){
                        jTextAreaOfContentReply.setText("<Nhập nội dung phản hồi của bạn tại đây>");
                    }
                }
            });
            jTextAreaOfContentReply.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(jTextAreaOfContentReply.getText().equals("<Nhập nội dung phản hồi của bạn tại đây>")){
                        jTextAreaOfContentReply.setText("");
                    }
                }
            });
            jScrollPaneOfContentReply.setViewportView(jTextAreaOfContentReply);

            replyButton.setBackground(new java.awt.Color(172, 172, 172));
            replyButton.setForeground(new java.awt.Color(0, 0, 0));
            replyButton.setText("Reply");
            replyButton.setFocusable(false);
            replyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Reply button in ReplyFeaturePanel.java (the replying interface)is clicked!");
                /*lưu thông tin bình luận phản hồi vào csdl*/
                String replyContent = jTextAreaOfContentReply.getText();
                String replyPerson = com.uiteco.main.App.getSession().getUsername();
                String MABLPHANHOI = jTextFieldOfMABLPHANHOI.getText();
                int postIDForum = getPostID();
                /*Nếu trường hợp khi mới hiển thị giao diện reply và người dùng chưa click vào vùng soạn thảo của jtextarea
                mà click button Reply ngay thì lúc này vùng soạn thảo đang có text là "<Nhập phản hồi của bạn tại đây>"
                hoặc trường hợp mới hiển thị giao diện reply và người dùng đã có click vào vùng soạn thảo nhưng xà quằn một hồi 
                thì rốt không có dữ liệu nào được nhập vào vùng soạn thảo đó cả, lúc này vùng soạn thảo có text là rỗng 
                Đối với 2 trường hợp trên thì khi người dùng click button Reply thì sẽ không lưu dữ liệu vào database và vẫn đứng ở giao diên đó
                kèm jDialog để thông báo(nếu congphan thiết kế kịp), và chỉ khi người dùng click vào button Cancel thì mới được hiển thị lại
                giao diện chi tiết bài đăng và những bình luận phản hồi của bài đăng đó*/
                if(replyContent.equals("<Nhập nội dung phản hồi của bạn tại đây>")  || replyContent.isEmpty()){
                    /*hiển thị dialog thông báo cho người dùng*/ 
                    javax.swing.JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ nội dung bình luận phản hồi hoặc nhấn Cancel để thoát khỏi màn hình bình luận", "Thông báo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("ban chua nhap noi dung binh luan vao vung soan thao cua jTextAreaOfContentReply");
                }
                else{
                    /*người dùng không nhập gì vào, tức là không reply cho bình luận nào cả, chỉ nhập nội dung bình luận rồi click button Reply*/
                    if(MABLPHANHOI.equals("Nhập mã bình luận mà bạn muốn phản hồi") || MABLPHANHOI.isEmpty()){
                        BaiDangForumDAO.insertIntoDatabaseWhenClickReply(replyPerson, replyContent, postIDForum,"");
                        /*cập nhật lượt phản hồi cho bài đăng này ở trường LUOTPHANHOI của table BAIDANGFORUM*/
                        BaiDangForumDAO.increaseReplyNumber(postIDForum);
                        /*hiển thị lại giao diện chi tiết bài đăng kèm với những phản hồi của bài đăng này*/
                        com.uiteco.contentPanels.ForumPanel panel1 = (com.uiteco.contentPanels.ForumPanel)getParent(); 
                        panel1.showPostDetailAndReplyView(getPostID()); 
                    }
                    /*người dùng nhập đầy đủ thông tin mã bình luận mà họ muốn phản hồi kèm với nội dung phản hồi*/
                    else{
                        BaiDangForumDAO.insertIntoDatabaseWhenClickReply(replyPerson, replyContent, postIDForum, MABLPHANHOI);
                        /*cập nhật lượt phản hồi cho bài đăng này ở trường LUOTPHANHOI của table BAIDANGFORUM*/
                        BaiDangForumDAO.increaseReplyNumber(postIDForum);
                        /*hiển thị lại giao diện chi tiết bài đăng kèm với những phản hồi của bài đăng này*/
                        com.uiteco.contentPanels.ForumPanel panel1 = (com.uiteco.contentPanels.ForumPanel)getParent(); 
                        panel1.showPostDetailAndReplyView(getPostID());                        
                    }
                }
            }
        });
            cancelButton.setBackground(new java.awt.Color(172, 172, 172));
            cancelButton.setForeground(new java.awt.Color(0, 0, 0));
            cancelButton.setText("Cancel");
            cancelButton.setFocusable(false);
            cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //thoát khỏi giao diện reply bài đăng, về giao diện chi tiết bài đăng kèm với những phản hồi của bài đăng đó
                System.out.println("Cancel button in ReplyFeaturePanel.java (the reply interface)is clicked!");
                com.uiteco.contentPanels.ForumPanel panel1 = (com.uiteco.contentPanels.ForumPanel)getParent(); 
                panel1.showPostDetailAndReplyView(getPostID());
            }
        });
            jTextFieldOfMABLPHANHOI.setBackground(new java.awt.Color(255, 255, 255));
            jTextFieldOfMABLPHANHOI.setForeground(new java.awt.Color(0, 0, 0));
            jTextFieldOfMABLPHANHOI.setText("Nhập mã bình luận mà bạn muốn phản hồi");
            jTextFieldOfMABLPHANHOI.setToolTipText("Đây là trường thông tin KHÔNG BẮT BUỘC phải nhập nếu bạn không muốn phản hồi cho bất kỳ bình luận nào");
            jTextFieldOfMABLPHANHOI.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                     jTextFieldOfMABLPHANHOI.getCaret().setVisible(true);
                }
                public void focusLost(java.awt.event.FocusEvent evt) {
                    if(jTextFieldOfMABLPHANHOI.getText().isEmpty()){
                        jTextFieldOfMABLPHANHOI.setText("Nhập mã bình luận mà bạn muốn phản hồi");
                    }
                }
            });
            jTextFieldOfMABLPHANHOI.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if(jTextFieldOfMABLPHANHOI.getText().equals("Nhập mã bình luận mà bạn muốn phản hồi")){
                        jTextFieldOfMABLPHANHOI.setText("");
                    }
                }
            });
            
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(replyButton)
                    .addGap(41, 41, 41))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(uitImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addGap(106, 106, 106)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                                    .addGap(68, 68, 68))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(278, 278, 278)
                                    .addComponent(jTextFieldOfMABLPHANHOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(forumImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jScrollPaneOfContentReply)
                            .addGap(69, 69, 69))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ecoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(forumImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(uitImageLabel))
                            .addGap(22, 22, 22)
                            .addComponent(jTextFieldOfMABLPHANHOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(51, 51, 51)
                    .addComponent(jScrollPaneOfContentReply, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(replyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17))
            );           
    }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel ecoLabel;
    private javax.swing.JLabel forumImageLabel;
    private javax.swing.JScrollPane jScrollPaneOfContentReply;
    private javax.swing.JTextArea jTextAreaOfContentReply;
    private javax.swing.JTextField jTextFieldOfMABLPHANHOI;
    private javax.swing.JButton replyButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel uitImageLabel;
    // End of variables declaration//GEN-END:variables
}
