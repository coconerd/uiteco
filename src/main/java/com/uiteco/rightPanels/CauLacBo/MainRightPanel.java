package com.uiteco.rightPanels.CauLacBo;

import com.uiteco.contentPanels.CauLacBoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

/**
 *
 * @author VStorm
 */

public class MainRightPanel extends javax.swing.JPanel {
    private CauLacBoPanel ClubPanel;
    
    private boolean IsSelected_area_InSchool;
    private boolean IsSelected_area_OutSchool;
    private boolean IsSelected_status_HasEvent;
    private boolean IsSelected_status_Offline;
    private boolean IsSelected_status_Online;
    private boolean IsSelected_condition_Yes;
    private boolean IsSelected_condition_No;
    
    public MainRightPanel() {
        initComponents();
        
        InitWithGroup();
    }
    
    public MainRightPanel(CauLacBoPanel ClubPanel) {
        this.ClubPanel = ClubPanel;
        
        initComponents();
        
        InitWithGroup();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Panel = new javax.swing.JPanel();
        jpanelRound1 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Line1 = new javax.swing.JPanel();
        jpanelRound3 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Tick_area_InSchool = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        Tick_area_OutSchool = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        jLabel2 = new javax.swing.JLabel();
        jpanelRound2 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Line2 = new javax.swing.JPanel();
        jpanelRound4 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StyleComboBox = new com.uiteco.contentPanels.CauLacBo.ComboBox();
        NameComboBox = new com.uiteco.contentPanels.CauLacBo.ComboBox();
        Line4 = new javax.swing.JPanel();
        Line3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Tick_condition_Yes = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        jLabel5 = new javax.swing.JLabel();
        Tick_status_HasEvent = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        Tick_status_Offline = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        Tick_status_Online = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        Tick_condition_No = new com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom();
        filterButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(232, 232, 232));

        jpanelRound1.setBackground(new java.awt.Color(245, 245, 245));
        jpanelRound1.setRoundBottomLeft(20);
        jpanelRound1.setRoundBottomRight(20);
        jpanelRound1.setRoundTopLeft(20);
        jpanelRound1.setRoundTopRight(20);
        jpanelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Line1.setBackground(new java.awt.Color(192, 192, 192));

        javax.swing.GroupLayout Line1Layout = new javax.swing.GroupLayout(Line1);
        Line1.setLayout(Line1Layout);
        Line1Layout.setHorizontalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        Line1Layout.setVerticalGroup(
            Line1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jpanelRound1.add(Line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 276, 1));

        jpanelRound3.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/SchoolIcon.png"))); // NOI18N

        javax.swing.GroupLayout jpanelRound3Layout = new javax.swing.GroupLayout(jpanelRound3);
        jpanelRound3.setLayout(jpanelRound3Layout);
        jpanelRound3Layout.setHorizontalGroup(
            jpanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jpanelRound3Layout.setVerticalGroup(
            jpanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jpanelRound1.add(jpanelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Tick_area_InSchool.setForeground(new java.awt.Color(80, 80, 80));
        Tick_area_InSchool.setText(" Thuộc Trường Học");
        Tick_area_InSchool.setFocusable(false);
        jpanelRound1.add(Tick_area_InSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        Tick_area_OutSchool.setForeground(new java.awt.Color(80, 80, 80));
        Tick_area_OutSchool.setText(" Ngoài Trường Học");
        Tick_area_OutSchool.setFocusable(false);
        jpanelRound1.add(Tick_area_OutSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Phạm vi câu lạc bộ");
        jpanelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, -1, -1));

        jpanelRound2.setBackground(new java.awt.Color(245, 245, 245));
        jpanelRound2.setRoundBottomLeft(20);
        jpanelRound2.setRoundBottomRight(20);
        jpanelRound2.setRoundTopLeft(20);
        jpanelRound2.setRoundTopRight(20);
        jpanelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Line2.setBackground(new java.awt.Color(192, 192, 192));

        javax.swing.GroupLayout Line2Layout = new javax.swing.GroupLayout(Line2);
        Line2.setLayout(Line2Layout);
        Line2Layout.setHorizontalGroup(
            Line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        Line2Layout.setVerticalGroup(
            Line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jpanelRound2.add(Line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 276, 1));

        jpanelRound4.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/FilterIcon2.png"))); // NOI18N

        javax.swing.GroupLayout jpanelRound4Layout = new javax.swing.GroupLayout(jpanelRound4);
        jpanelRound4.setLayout(jpanelRound4Layout);
        jpanelRound4Layout.setHorizontalGroup(
            jpanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jpanelRound4Layout.setVerticalGroup(
            jpanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jpanelRound2.add(jpanelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Điều kiện tham gia");
        jpanelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 395, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Bộ lọc tìm kiếm");
        jpanelRound2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, -1, -1));

        StyleComboBox.setBackground(new java.awt.Color(245, 245, 245));
        StyleComboBox.setForeground(new java.awt.Color(54, 54, 54));
        StyleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng dần", "Giảm dần" }));
        StyleComboBox.setSelectedIndex(-1);
        StyleComboBox.setEnabled(false);
        StyleComboBox.setFocusable(false);
        StyleComboBox.setLabeText("Loại lọc");
        jpanelRound2.add(StyleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 180, -1));

        NameComboBox.setBackground(new java.awt.Color(245, 245, 245));
        NameComboBox.setForeground(new java.awt.Color(54, 54, 54));
        NameComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Không", "Tên", "Số lượng thành viên" }));
        NameComboBox.setSelectedIndex(-1);
        NameComboBox.setFocusable(false);
        NameComboBox.setLabeText("Thành phần lọc");
        NameComboBox.setName(""); // NOI18N
        jpanelRound2.add(NameComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, -1));

        Line4.setBackground(new java.awt.Color(192, 192, 192));

        javax.swing.GroupLayout Line4Layout = new javax.swing.GroupLayout(Line4);
        Line4.setLayout(Line4Layout);
        Line4Layout.setHorizontalGroup(
            Line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        Line4Layout.setVerticalGroup(
            Line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jpanelRound2.add(Line4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 276, 1));

        Line3.setBackground(new java.awt.Color(192, 192, 192));

        javax.swing.GroupLayout Line3Layout = new javax.swing.GroupLayout(Line3);
        Line3.setLayout(Line3Layout);
        Line3Layout.setHorizontalGroup(
            Line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        Line3Layout.setVerticalGroup(
            Line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jpanelRound2.add(Line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 276, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Lọc theo thứ tự");
        jpanelRound2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 120, -1));

        Tick_condition_Yes.setText(" Có");
        Tick_condition_Yes.setFocusable(false);
        jpanelRound2.add(Tick_condition_Yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Trạng Thái");
        jpanelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 120, -1));

        Tick_status_HasEvent.setText(" Đang có sự kiện");
        Tick_status_HasEvent.setFocusable(false);
        jpanelRound2.add(Tick_status_HasEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        Tick_status_Offline.setText(" Không hoạt động");
        Tick_status_Offline.setFocusable(false);
        jpanelRound2.add(Tick_status_Offline, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        Tick_status_Online.setText(" Đang hoạt động");
        Tick_status_Online.setFocusable(false);
        jpanelRound2.add(Tick_status_Online, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        Tick_condition_No.setText(" Không");
        Tick_condition_No.setFocusable(false);
        jpanelRound2.add(Tick_condition_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        filterButton.setBorder(null);
        filterButton.setForeground(new java.awt.Color(255, 255, 255));
        filterButton.setText("Lọc");
        filterButton.setboderSize(3);
        filterButton.setBorderColor(new java.awt.Color(227, 134, 0));
        filterButton.setColor(new java.awt.Color(255, 156, 11));
        filterButton.setColorClick(new java.awt.Color(242, 144, 0));
        filterButton.setColorOver(new java.awt.Color(255, 151, 0));
        filterButton.setFocusable(false);
        filterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        jpanelRound2.add(filterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 120, 40));

        jLabel6.setBackground(new java.awt.Color(23, 23, 23));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(100, 100, 100));
        jLabel6.setText("Copyright © 2024 : CocoNerd ");
        jpanelRound2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 590, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(98, 98, 98));
        jLabel8.setText("VStorm");
        jpanelRound2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 610, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(100, 100, 100));
        jLabel7.setText("Designed by ");
        jpanelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, -1, -1));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 793));
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        String Area = "", NameBox = "", StyleBox = "", Status = "", ConditionJoin = "";
        
        if(Tick_area_InSchool.isSelected())
            Area = "in"; 
        else if(Tick_area_OutSchool.isSelected())
            Area = "out";
        
        if((String) NameComboBox.getSelectedItem() != null)
        {
            NameBox = (String) NameComboBox.getSelectedItem();
            StyleBox = (String) StyleComboBox.getSelectedItem();
        }
        
        if(Tick_status_HasEvent.isSelected())
            Status = "event";
        else if(Tick_status_Online.isSelected())
            Status = "online";
        else if(Tick_status_Offline.isSelected())
            Status = "offline";
        
        if(Tick_condition_Yes.isSelected())
            ConditionJoin = "yes";
        else if(Tick_condition_No.isSelected())
            ConditionJoin = "no";
        
        ClubPanel.FilterListCLB(Area, NameBox, StyleBox, Status, ConditionJoin);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void InitWithGroup()
    {
        ButtonGroup groupButton1 = new ButtonGroup();
        groupButton1.add(Tick_area_InSchool);
        groupButton1.add(Tick_area_OutSchool);
        
        IsSelected_area_InSchool = Tick_area_InSchool.isSelected();
        Tick_area_InSchool.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_area_InSchool)
                {
                    groupButton1.clearSelection();
                    IsSelected_area_InSchool = false;
                }
                else
                {
                    IsSelected_area_InSchool = true;
                    
                    IsSelected_area_OutSchool = false;
                }
            }
        });
        
        IsSelected_area_OutSchool = Tick_area_OutSchool.isSelected();
        Tick_area_OutSchool.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_area_OutSchool)
                {
                    groupButton1.clearSelection();
                    IsSelected_area_OutSchool = false;
                }
                else
                {
                    IsSelected_area_OutSchool = true;
                    
                    IsSelected_area_InSchool = false;
                }
            }
        });
        
        //--
        
        ButtonGroup groupButton2 = new ButtonGroup();
        groupButton2.add(Tick_status_HasEvent);
        groupButton2.add(Tick_status_Offline);
        groupButton2.add(Tick_status_Online);
        
        IsSelected_status_HasEvent = Tick_status_HasEvent.isSelected();
        Tick_status_HasEvent.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_status_HasEvent)
                {
                    groupButton2.clearSelection();
                    IsSelected_status_HasEvent = false;
                }
                else
                {
                    IsSelected_status_HasEvent = true;
                    
                    IsSelected_status_Offline = false;
                    IsSelected_status_Online = false;
                }
            }
        });
        
        IsSelected_status_Offline = Tick_status_Offline.isSelected();
        Tick_status_Offline.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_status_Offline)
                {
                    groupButton2.clearSelection();
                    IsSelected_status_Offline = false;
                }
                else
                {
                    IsSelected_status_Offline = true;
                    
                    IsSelected_status_HasEvent = false;
                    IsSelected_status_Online = false;
                }
            }
        });
        
        IsSelected_status_Online = Tick_status_Online.isSelected();
        Tick_status_Online.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_status_Online)
                {
                    groupButton2.clearSelection();
                    IsSelected_status_Online = false;
                }
                else
                {
                    IsSelected_status_Online = true;
                    
                    IsSelected_status_Offline = false;
                    IsSelected_status_HasEvent = false;
                }
            }
        });
        
        //--
        
        ButtonGroup groupButton3 = new ButtonGroup();
        groupButton3.add(Tick_condition_No);
        groupButton3.add(Tick_condition_Yes);
        
        IsSelected_condition_No = Tick_condition_No.isSelected();
        Tick_condition_No.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_condition_No)
                {
                    groupButton3.clearSelection();
                    IsSelected_condition_No = false;
                }
                else
                {
                    IsSelected_condition_No = true;
                    
                    IsSelected_condition_Yes = false;
                }
            }
        });
        
        IsSelected_condition_Yes = Tick_condition_Yes.isSelected();
        Tick_condition_Yes.addMouseListener(new java.awt.event.MouseAdapter() {            
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(IsSelected_condition_Yes)
                {
                    groupButton3.clearSelection();
                    IsSelected_condition_Yes = false;
                }
                else
                {
                    IsSelected_condition_Yes = true;
                    
                    IsSelected_condition_No = false;
                }
            }
        });
        
        //--

        NameComboBox.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NameSelect = (String) NameComboBox.getSelectedItem();
                
                if(NameSelect == "Không")
                {
                    NameComboBox.setSelectedIndex(-1);
                    
                    StyleComboBox.setSelectedIndex(-1);
                    StyleComboBox.setEnabled(false);
                }        
                else
                {
                    StyleComboBox.setSelectedIndex(0);
                    StyleComboBox.setEnabled(true);
                }
            }
        });
    
    }

    public void setClubPanel(CauLacBoPanel ClubPanel)
    {
        this.ClubPanel = ClubPanel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Line1;
    private javax.swing.JPanel Line2;
    private javax.swing.JPanel Line3;
    private javax.swing.JPanel Line4;
    private com.uiteco.contentPanels.CauLacBo.ComboBox NameComboBox;
    private javax.swing.JPanel Panel;
    private com.uiteco.contentPanels.CauLacBo.ComboBox StyleComboBox;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_area_InSchool;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_area_OutSchool;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_condition_No;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_condition_Yes;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_status_HasEvent;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_status_Offline;
    private com.uiteco.contentPanels.CauLacBo.JCheckBoxCustom Tick_status_Online;
    private com.uiteco.contentPanels.CauLacBo.ButtonRound filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollBar jScrollBar1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound2;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound3;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound4;
    // End of variables declaration//GEN-END:variables
}
