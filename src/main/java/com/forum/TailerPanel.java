/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.forum;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TailerPanel extends javax.swing.JPanel{
    public TailerPanel(){
        initComponents();
    }
    public void updateJTextFieldOfPageNumberCurrent(int currentPageOfPostListPanel){
    jTextFieldOfPageNumberCurrent.setText(String.valueOf(currentPageOfPostListPanel+1));
    jTextFieldOfPageNumberCurrent.setEditable(false);
    jTextFieldOfPageNumberCurrent.setCaret(new javax.swing.text.DefaultCaret(){
        @Override
        protected synchronized void damage(java.awt.Rectangle r) {
            // không làm gì cả
        }
        @Override
        public void paint(java.awt.Graphics g) {
            // không vẽ caret
        }
    });        
}    
    void initComponents(){
        setBackground(new java.awt.Color(231,231,231));
        setPreferredSize(new java.awt.Dimension(1060, 32));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        //nextButton = new javax.swing.JButton();
        nextButton = new com.forum.RoundedBorderButton();
        nextButton.setBackground(new java.awt.Color(195, 208, 229));
        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-right-26.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setSize(87, 32);
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);
        nextButton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
            System.out.println("Next button in the main interface of forum is clicked!");
            javax.swing.JPanel panel = (javax.swing.JPanel)getParent();
            com.forum.PostListPanel pl = (com.forum.PostListPanel)panel.getComponent(0);
            pl.setCurrentPageToNext();
            jTextFieldOfPageNumberCurrent.setText(String.valueOf(pl.getCurrentPage()+1));
        }
    });
        
        //backButton = new javax.swing.JButton();
        backButton = new com.forum.RoundedBorderButton();
        backButton.setBackground(new java.awt.Color(195, 208, 229));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-left-26.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setSize(87,32);
        backButton.setBorderPainted(false);
        backButton.setFocusable(false);
        backButton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
            System.out.println("Back button in the main interface of forum is clicked!");
            javax.swing.JPanel panel = (javax.swing.JPanel)getParent();  
            com.forum.PostListPanel pl = (com.forum.PostListPanel)panel.getComponent(0);
            pl.setCurrentPageToBack();
            jTextFieldOfPageNumberCurrent.setText(String.valueOf(pl.getCurrentPage()+1));
        }
    });
        
        hienthisotrangPanel = new javax.swing.JPanel();
        jTextFieldOfPageNumberCurrent = new javax.swing.JTextField();
        jTextFieldOfPageNumberCurrent.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.TEXT_CURSOR));
        ofLabel = new javax.swing.JLabel();
        pageLabel = new javax.swing.JLabel();
        totalPageNumberLabel = new javax.swing.JLabel();          
        
        hienthisotrangPanel.setBackground(new java.awt.Color(231,231,231));
        hienthisotrangPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                javax.swing.JPanel panel = (javax.swing.JPanel)getParent();               
                com.forum.PostListPanel pl = (com.forum.PostListPanel)panel.getComponent(0);
                updateJTextFieldOfPageNumberCurrent(pl.getCurrentPage());
            }
        });

        pageLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pageLabel.setForeground(new java.awt.Color(0, 0, 0));
        pageLabel.setText("Page");
        pageLabel.setPreferredSize(new java.awt.Dimension(28, 16));

        jTextFieldOfPageNumberCurrent.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldOfPageNumberCurrent.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldOfPageNumberCurrent.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(204, 204, 204)));
        jTextFieldOfPageNumberCurrent.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                jTextFieldOfPageNumberCurrent.setEditable(true);
                javax.swing.text.DefaultCaret defaultCaret = new javax.swing.text.DefaultCaret();
                defaultCaret.setBlinkRate(500); // Thiết lập tần số nhấp nháy
                jTextFieldOfPageNumberCurrent.setCaret(defaultCaret);
                jTextFieldOfPageNumberCurrent.setCaretPosition(jTextFieldOfPageNumberCurrent.getText().length()); //đặt con trỏ ở cuối văn bản
                jTextFieldOfPageNumberCurrent.getCaret().setVisible(true); // hiển thị con trỏ
            }
        });
        jTextFieldOfPageNumberCurrent.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e){
                javax.swing.JPanel panel = (javax.swing.JPanel)getParent();               
                PostListPanel pl = (PostListPanel)panel.getComponent(0);
              
                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
                    String text = jTextFieldOfPageNumberCurrent.getText();
                    try{
                        int pageNumber = Integer.parseInt(text);
                        if(pageNumber >= 1 && pageNumber <= pl.getTotalPages()){ //số trang nhập vào hợp lệ
                            if(pageNumber == (pl.getCurrentPage()+1)){ //số trang nhập vào đúng bằng số trang hiện tại đang đứng
                                updateJTextFieldOfPageNumberCurrent(pl.getCurrentPage());                                   
                            }
                            else{ //thực hiện chuyển trang theo số trang người dùng nhập vào
                                pl.switchPage(pageNumber);
                                jTextFieldOfPageNumberCurrent.setText(String.valueOf(pl.getCurrentPage()+1));
                                jTextFieldOfPageNumberCurrent.setEditable(false);
                                jTextFieldOfPageNumberCurrent.setCaret(new javax.swing.text.DefaultCaret(){
                                    @Override
                                    protected synchronized void damage(java.awt.Rectangle r) {
                                        // không làm gì cả
                                    }
                                    @Override
                                    public void paint(java.awt.Graphics g) {
                                        // không vẽ caret
                                    }
                                });                                        
                            }
                        }
                        else{ //ví dụ nhập số âm, số 0, số vượt quá tổng số trang
                            updateJTextFieldOfPageNumberCurrent(pl.getCurrentPage());                              
                        }
                    }
                    catch(NumberFormatException ex){ //người dùng nhập vào không phải chuỗi số nguyên, ví dụ nhập "a#123", "12.34", ...
                        updateJTextFieldOfPageNumberCurrent(pl.getCurrentPage());                        
                    }
                }
            }
        });        

        ofLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ofLabel.setForeground(new java.awt.Color(0, 0, 0));
        ofLabel.setText("of");
        ofLabel.setPreferredSize(new java.awt.Dimension(15, 16));

        totalPageNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalPageNumberLabel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout hienthisotrangPanelLayout = new javax.swing.GroupLayout(hienthisotrangPanel);
        hienthisotrangPanel.setLayout(hienthisotrangPanelLayout);
        hienthisotrangPanelLayout.setHorizontalGroup(
            hienthisotrangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienthisotrangPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTextFieldOfPageNumberCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(ofLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(totalPageNumberLabel)
                .addContainerGap())
        );
        hienthisotrangPanelLayout.setVerticalGroup(
            hienthisotrangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hienthisotrangPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(pageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
            .addGroup(hienthisotrangPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTextFieldOfPageNumberCurrent)
                .addGap(6, 6, 6))
            .addGroup(hienthisotrangPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(hienthisotrangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPageNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ofLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );    
        
        add(hienthisotrangPanel);
        add(backButton);
        add(nextButton);      
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        // khi click chuột vào panel này thì con trỏ nhấp nháy của jtextfield hiển thị số trang ở TailerPanel sẽ không còn nhấp nháy nữa, đồng thời số trang mà hiện tại người dùng đang đứng cũng được hiển thị                        
            @Override       
            public void mouseClicked(java.awt.event.MouseEvent e){
                javax.swing.JPanel panel = (javax.swing.JPanel)getParent();  
                if (panel != null) {
                    com.forum.PostListPanel pl = (com.forum.PostListPanel)panel.getComponent(0);
                    updateJTextFieldOfPageNumberCurrent(pl.getCurrentPage());
                }
            }
        });
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JPanel getHienthisotrangPanel() {
        return hienthisotrangPanel;
    }

    public void setHienthisotrangPanel(JPanel hienthisotrangPanel) {
        this.hienthisotrangPanel = hienthisotrangPanel;
    }

    public JTextField getjTextFieldOfPageNumberCurrent() {
        return jTextFieldOfPageNumberCurrent;
    }

    public void setjTextFieldOfPageNumberCurrent(JTextField jTextFieldOfPageNumberCurrent) {
        this.jTextFieldOfPageNumberCurrent = jTextFieldOfPageNumberCurrent;
    }

    public JLabel getOfLabel() {
        return ofLabel;
    }

    public void setOfLabel(JLabel ofLabel) {
        this.ofLabel = ofLabel;
    }

    public JLabel getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(JLabel pageLabel) {
        this.pageLabel = pageLabel;
    }

    public JLabel getTotalPageNumberLabel() {
        return totalPageNumberLabel;
    }

    public void setTotalPageNumberLabel(JLabel totalPageNumberLabel) {
        this.totalPageNumberLabel = totalPageNumberLabel;
    }

    private javax.swing.JButton nextButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel hienthisotrangPanel;
    private javax.swing.JTextField jTextFieldOfPageNumberCurrent;
    private javax.swing.JLabel ofLabel;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JLabel totalPageNumberLabel;    
}
