/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;

public class TitlePanel extends javax.swing.JPanel{
    public TitlePanel(){
        initTitlePanel();
    }
    
    void initTitlePanel(){
        setSize(1060,40);
        setBackground(new java.awt.Color(231,231,231));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
        
        add(javax.swing.Box.createHorizontalStrut(140));
        topicLabel = new javax.swing.JLabel();
        topicLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        topicLabel.setText("Topic");
        topicLabel.setSize(50, 34);
        add(topicLabel);

        add(javax.swing.Box.createHorizontalStrut(400));
        statisticLabel = new javax.swing.JLabel();
        statisticLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        statisticLabel.setText("Statistic");
        statisticLabel.setSize(70,34);
        add(statisticLabel);
        
        add(javax.swing.Box.createHorizontalStrut(200));
        postedByLabel = new javax.swing.JLabel();
        postedByLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        postedByLabel.setText("Posted by");
        postedByLabel.setSize(85,34);
        add(postedByLabel);
        add(javax.swing.Box.createHorizontalStrut(90));
        
        addMouseListener(new java.awt.event.MouseAdapter() { 
        // khi click chuột vào panel này thì con trỏ nhấp nháy của jtextfield hiển thị số trang ở TailerPanel sẽ không còn nhấp nháy nữa, đồng thời số trang mà hiện tại người dùng đang đứng cũng được hiển thị            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                javax.swing.JPanel panel1 = (javax.swing.JPanel)getParent(); 
                //System.out.println(getParent().getClass()); //kết quả là: com.uiteco.contentPanels.ForumPanel;
                com.raven.scroll.ScrollPaneWin11 scrollPaneWin11 = (com.raven.scroll.ScrollPaneWin11)panel1.getComponent(0);
                javax.swing.JPanel panel2 = (javax.swing.JPanel)scrollPaneWin11.getViewport().getView();
                com.forum.TailerPanel tp = (com.forum.TailerPanel)panel2.getComponent(1);
                tp.updateJTextFieldOfPageNumberCurrent(((com.forum.PostListPanel)panel2.getComponent(0)).getCurrentPage());
            }
        });        
    }
    private javax.swing.JLabel topicLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JLabel postedByLabel;
}
