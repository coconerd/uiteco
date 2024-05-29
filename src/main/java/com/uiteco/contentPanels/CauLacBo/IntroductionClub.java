/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo;

import com.uiteco.contentPanels.CauLacBoPanel;
import com.uiteco.rightPanels.CauLacBoRightPanel;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDate.now;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author VStorm
 */
public class IntroductionClub extends javax.swing.JPanel {
    private CauLacBoPanel MainPanelCLB;
    private CauLacBoRightPanel RightPanelCLB;
    
    private boolean IsLoving = false;
    private int MaCLB, SLThich, DKXetTuyen;
    // Need Use SLThich, DKXetTuyen
    private String NameCLUB = "", CreateBy = "", HostBy = "";
    private LocalDate DateCreate = null;
    
    public IntroductionClub() {
        Start();
    }
    
    // Status Chỉ có giá trị 2 hoặc 1 hoặc 0; 2 là đang có sự kiện hay cuộc thi,1 là đang hoạt động, 0 là không hoạt động.
    public IntroductionClub(String NameCLB_, String BasicInfo_, String LogoUrl_,int NumOFMember_, LocalDateTime LastedUpdate_, String Department_, int Status_, ArrayList<String> ListImageUrl) {
        Start();
        
        NameCLB.setText(NameCLB_);
        NameCLUB = NameCLB_;

        BasicInfo.setText(BasicInfo_);

        if(LogoUrl_ != null && !LogoUrl_.equals(""))
        {
            LogoCLUB.setImage(new ImageIcon(getClass().getResource(LogoUrl_)));
        }
        
        if(NumOFMember_ >= 2)
            NumMem.setText(NumOFMember_ + " Members");
        else
            NumMem.setText(NumOFMember_ + " Member");
        
        String TimeUpdate = "Cập nhật: ";

        long Seconds = -1;
        
        if(LastedUpdate_ != null)
        {
            Duration duration = Duration.between(LastedUpdate_, LocalDateTime.now());
            Seconds = duration.getSeconds();
        }
        
        if(Seconds == -1)
            TimeUpdate += "";
        else
        if (Seconds < 60)
            TimeUpdate += Seconds + " Giây Trước";
        else
        if (Seconds < 60*60)
            TimeUpdate += Seconds/60 + " Phút Trước";
        else
        if (Seconds < 60*60*24)
            TimeUpdate += Seconds/(60*60) + " Giờ Trước";    
        else
        if (Seconds < 60*60*24*30)
            TimeUpdate += Seconds/(60*60*24) + " Ngày Trước";        
        else
        if (Seconds < 60*60*24*30*12)
            TimeUpdate += Seconds/(60*60*24*30) + " Tháng Trước";
        else
            TimeUpdate += "Hơn 1 Năm Trước";
     
        LastUpdate.setText(TimeUpdate);
        Department.setText(Department_);
        
        switch(Status_)
        {
            case 2:
                Status.setText("Đang có sự kiện");
                Status.setForeground(new Color(255,102,0));
                break;
            case 1:
                Status.setText("Đang hoạt động");
                Status.setForeground(new Color(51,204,0));
                break;
            case 0:
                Status.setText("Không hoạt động");
                Status.setForeground(new Color(153,153,153));
                break;
            default:
                Status.setText("");
        }

        SlideShowImage.initSlideshow(ListImageUrl);
        
        if(ListImageUrl.size() <= 1)
        {
            jpanelRound3.remove(BackPanel);
            jpanelRound3.remove(NextPanel);
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics grphcs)
    {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) grphcs.create();
        
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
  
        g2.dispose();
        super.paintComponent(grphcs);
    }
    
    
    private void Start()
    {
        initComponents();
        this.setVisible(true);
        this.setOpaque(false);
        this.setBorder(new javax.swing.border.EmptyBorder(7, 5 ,7 ,5));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jpanelRound3 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        NumMem = new javax.swing.JLabel();
        LogoCLUB = new com.uiteco.contentPanels.CauLacBo.ImageAvatar();
        NextPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        NextIcon = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        BackPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        BackIcon = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        SlideShowImage = new com.uiteco.contentPanels.CauLacBo.SlideShow.Slideshow(false);
        jpanelRound1 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        BasicInfo = new javax.swing.JTextPane();
        Status = new javax.swing.JLabel();
        Department = new javax.swing.JLabel();
        LastUpdate = new javax.swing.JLabel();
        JoinButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound();
        XetTuyen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LoveButton = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        jpanelRound2 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        NameCLB = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setBackground(new java.awt.Color(238, 238, 238));
        setForeground(new java.awt.Color(238, 238, 238));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        jpanelRound3.setBackground(new java.awt.Color(245, 245, 245));
        jpanelRound3.setRoundBottomLeft(50);
        jpanelRound3.setRoundBottomRight(50);
        jpanelRound3.setRoundTopLeft(50);
        jpanelRound3.setRoundTopRight(50);
        jpanelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumMem.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        NumMem.setForeground(new java.awt.Color(51, 204, 0));
        NumMem.setText("NumOfMember");
        NumMem.setToolTipText("");
        jpanelRound3.add(NumMem, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 170, -1));

        LogoCLUB.setBackground(new java.awt.Color(102, 102, 102));
        LogoCLUB.setBorderSize(3);
        LogoCLUB.setImage(new javax.swing.ImageIcon(getClass().getResource("/uit.png"))); // NOI18N
        jpanelRound3.add(LogoCLUB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 120));

        NextPanel.setBackground(new java.awt.Color(102, 102, 102));
        NextPanel.setAlpha(0.0F);
        NextPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NextPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextPanelMouseExited(evt);
            }
        });
        NextPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NextIcon.setAlpha(0.15F);
        NextIcon.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Next.png"))); // NOI18N
        NextPanel.add(NextIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 108, 40, 50));

        jpanelRound3.add(NextPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 80, 95, 270));

        BackPanel.setBackground(new java.awt.Color(102, 102, 102));
        BackPanel.setAlpha(0.0F);
        BackPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackPanelMouseExited(evt);
            }
        });
        BackPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackIcon.setAlpha(0.15F);
        BackIcon.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Back.png"))); // NOI18N
        BackPanel.add(BackIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 108, 40, 50));

        jpanelRound3.add(BackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 95, 270));

        SlideShowImage.setBackground(new java.awt.Color(210, 210, 210));
        jpanelRound3.add(SlideShowImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 720, 270));

        jpanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jpanelRound1.setRoundBottomLeft(30);
        jpanelRound1.setRoundBottomRight(30);
        jpanelRound1.setRoundTopLeft(30);
        jpanelRound1.setRoundTopRight(30);

        BasicInfo.setEditable(false);
        BasicInfo.setBackground(new java.awt.Color(255, 255, 255));
        BasicInfo.setBorder(null);
        BasicInfo.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        BasicInfo.setForeground(new java.awt.Color(135, 135, 135));
        BasicInfo.setText("Basic Information \n");
        BasicInfo.setToolTipText("");

        Status.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Status.setForeground(new java.awt.Color(153, 153, 153));
        Status.setText("Status");

        Department.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        Department.setForeground(new java.awt.Color(185, 185, 185));
        Department.setText("Department");

        LastUpdate.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        LastUpdate.setForeground(new java.awt.Color(146, 146, 146));
        LastUpdate.setText("LastedUpdate");

        JoinButton.setBorder(null);
        JoinButton.setForeground(new java.awt.Color(255, 255, 255));
        JoinButton.setText("Tham Gia");
        JoinButton.setboderSize(3);
        JoinButton.setBorderColor(new java.awt.Color(51, 204, 0));
        JoinButton.setColor(new java.awt.Color(54, 229, 0));
        JoinButton.setColorClick(new java.awt.Color(50, 211, 0));
        JoinButton.setColorOver(new java.awt.Color(51, 217, 0));
        JoinButton.setFocusable(false);
        JoinButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JoinButton.setRadius(15);
        JoinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JoinButtonMousePressed(evt);
            }
        });

        XetTuyen.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        XetTuyen.setForeground(new java.awt.Color(0, 255, 51));
        XetTuyen.setText("Tham gia không cần xét tuyển");

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addComponent(BasicInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(XetTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        jpanelRound1Layout.setVerticalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(BasicInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(XetTuyen)
                        .addGap(29, 29, 29)))
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Department)
                        .addGap(12, 12, 12)
                        .addComponent(Status))
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addComponent(LastUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jpanelRound3.add(jpanelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 720, 210));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jpanelRound3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 10, 20));

        LoveButton.setBackground(new java.awt.Color(255, 255, 255));
        LoveButton.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Heart1.png"))); // NOI18N
        LoveButton.setRoundBottomLeft(20);
        LoveButton.setRoundBottomRight(20);
        LoveButton.setRoundTopLeft(20);
        LoveButton.setRoundTopRight(20);
        LoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoveButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout LoveButtonLayout = new javax.swing.GroupLayout(LoveButton);
        LoveButton.setLayout(LoveButtonLayout);
        LoveButtonLayout.setHorizontalGroup(
            LoveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        LoveButtonLayout.setVerticalGroup(
            LoveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jpanelRound3.add(LoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 30, 30));

        jpanelRound2.setBackground(new java.awt.Color(75, 151, 255));
        jpanelRound2.setForeground(new java.awt.Color(255, 255, 255));
        jpanelRound2.setRoundTopRight(80);

        NameCLB.setFont(new java.awt.Font("Calibri", 1, 32)); // NOI18N
        NameCLB.setForeground(new java.awt.Color(235, 235, 235));
        NameCLB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NameCLB.setText("Name CLB");
        NameCLB.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        NameCLB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpanelRound2Layout = new javax.swing.GroupLayout(jpanelRound2);
        jpanelRound2.setLayout(jpanelRound2Layout);
        jpanelRound2Layout.setHorizontalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound2Layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addComponent(NameCLB, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpanelRound2Layout.setVerticalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(NameCLB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jpanelRound3.add(jpanelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 410, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelRound3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
//        this.setBackground(new Color(154,202,255));
//        BasicInfo.setBackground(new Color(193,224,255));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
//        this.setBackground(new Color(167,209,255));
//        BasicInfo.setBackground(new Color(211,233,255));
    }//GEN-LAST:event_formMouseExited

    private void NextPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseExited
        NextPanel.setAlpha(0f);
        NextIcon.setAlpha(0.15f);
    }//GEN-LAST:event_NextPanelMouseExited

    private void NextPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseEntered
        NextPanel.setAlpha(0.1f);
        NextIcon.setAlpha(0.25f);
    }//GEN-LAST:event_NextPanelMouseEntered

    private void NextPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseClicked
        SlideShowImage.next();
    }//GEN-LAST:event_NextPanelMouseClicked

    private void BackPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseExited
        BackPanel.setAlpha(0f);
        BackIcon.setAlpha(0.15f);
    }//GEN-LAST:event_BackPanelMouseExited

    private void BackPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseEntered
        BackPanel.setAlpha(0.1f);
        BackIcon.setAlpha(0.25f);
    }//GEN-LAST:event_BackPanelMouseEntered

    private void BackPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseClicked
        SlideShowImage.back();
    }//GEN-LAST:event_BackPanelMouseClicked

    private void LoveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoveButtonMousePressed
        if (IsLoving)
        {
            LoveButton.setImage(new ImageIcon(getClass().getResource("/CauLacBoResources/Heart1.png")));
            LoveButton.repaint();
            IsLoving = false;
        }
        else
        {
            LoveButton.setImage(new ImageIcon(getClass().getResource("/CauLacBoResources/Heart2.png")));
            LoveButton.repaint();
            IsLoving = true;
        } 
    }//GEN-LAST:event_LoveButtonMousePressed

    private void JoinButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JoinButtonMousePressed
        if(MainPanelCLB == null)
            return;
        
        DetailPageCLB DetailPage = new DetailPageCLB(MainPanelCLB);
        DetailPage.setDataToPage(MaCLB);
        MainPanelCLB.goToDetailPage(DetailPage);
        
        //ShowRightPanel
        this.RightPanelCLB.showDetailPageRightPanel(MaCLB, NameCLUB, CreateBy, HostBy, DateCreate);
    }//GEN-LAST:event_JoinButtonMousePressed

    public void setMainPanel(CauLacBoPanel MainPanelCLB)
    {
        this.MainPanelCLB = MainPanelCLB;
    }
    
    public void setRightPanelCLB(CauLacBoRightPanel RightPanelCLB)
    {
        this.RightPanelCLB = RightPanelCLB;
    }
    
    public void setMaCLB(int MaCLB)
    {
        this.MaCLB = MaCLB;
    }
    
    public int getMaCLB()
    {
        return MaCLB;
    }
    
    public void setSLThich(int SLThich)
    {
        this.SLThich = SLThich;
    }
    
    public int getSLThich()
    {
        return SLThich;
    }
    
    public void setDKXetTuyen(int DKXetTuyen)
    {
        this.DKXetTuyen = DKXetTuyen;
        
        if(DKXetTuyen == 1)
        {
            XetTuyen.setText("Tham gia cần xét tuyển");
            XetTuyen.setForeground(new Color(204,204,0));
        }
        else
        {
            XetTuyen.setText("Tham gia không cần xét tuyển");
            XetTuyen.setForeground(new Color(0,255,51));
        }
        
    }
    
    public int getDKXetTuyen()
    {
        return DKXetTuyen;
    }
    
    public void setIsLoving(boolean IsLoving)
    {
        this.IsLoving = IsLoving;
    }
    
    public boolean getIsLoving()
    {
        return IsLoving;
    }
    
    public void setCreateBy(String CreateBy)
    {
        this.CreateBy = CreateBy;
    }
    
    public String getCreateBy()
    {
        return CreateBy;
    }
    
    public void setHostBy(String HostBy)
    {
        this.HostBy = HostBy;
    }
    
    public String getHostBy()
    {
        return HostBy;
    }
    
    public void setDateCreate(LocalDate DateCreate)
    {
        this.DateCreate = DateCreate;
    }
    
    public LocalDate getDateCreate()
    {
        return DateCreate;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackIcon;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackPanel;
    private javax.swing.JTextPane BasicInfo;
    private javax.swing.JLabel Department;
    private com.uiteco.contentPanels.CauLacBo.ButtonRound JoinButton;
    private javax.swing.JLabel LastUpdate;
    private com.uiteco.contentPanels.CauLacBo.ImageAvatar LogoCLUB;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound LoveButton;
    private javax.swing.JLabel NameCLB;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound NextIcon;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound NextPanel;
    private javax.swing.JLabel NumMem;
    private com.uiteco.contentPanels.CauLacBo.SlideShow.Slideshow SlideShowImage;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel XetTuyen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound2;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound3;
    // End of variables declaration//GEN-END:variables
}
