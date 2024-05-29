package com.uiteco.contentPanels.CauLacBo;

import com.uiteco.contentPanels.CauLacBo.JTable.TableCustom;
import com.uiteco.contentPanels.CauLacBoPanel;
import com.uiteco.contentPanels.CauLacBoPanel;
import com.uiteco.database.ConnectionManager;
import com.uiteco.rightPanels.CauLacBoRightPanel;
import com.uiteco.swing.ScrollableContentPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.*;

/**
 *
 * @author Acer
 */
public class DetailPageCLB extends ScrollableContentPanel {
    private CauLacBoPanel MainPanelCLB;
    private CauLacBoRightPanel RightPanelCLB;
    
    public DetailPageCLB() {
        initComponents();
        
        Start();
    }

    public DetailPageCLB(Component... coms) {
        initComponents();
        
        SlideShow.initSlideshow(coms);
        
        Start();
    }
    
    public DetailPageCLB(CauLacBoPanel MainPanelCLB) {
        this.MainPanelCLB = MainPanelCLB;
        initComponents();
        Start();
    }
    
    private void Start()
    {
        TableCustom.apply(jScrollTableMem, TableCustom.TableType.DEFAULT);
        
//        System.out.println(MainPanelCLB.getWidth() + ", " + MainPanelCLB.getHeight());
//        textPaneVSCustom1.setS
 }
    
    private void RemoveAllDataTable()
    {
        DefaultTableModel model = (DefaultTableModel) TableMembers.getModel();
        
        
    }
    
    private void AddMemToTable(String NameMem, String MSSVMem, String EmailMem, String PosMem)
    {
        DefaultTableModel model = (DefaultTableModel) TableMembers.getModel();
        model.addRow(new Object[]{"" + (TableMembers.getRowCount() + 1), NameMem, MSSVMem, EmailMem, PosMem});
    }
    
    public void setDataToPage(int MaCLB)
    {
        String GioiThieu = "....", Email = "", SDT = "", Truong = "", LoaiCLB = "", ThongTinCLB = "....", DieuLe = "....";
        int SLDanhGia = 0, SaoDanhGia = 0;
        
//        System.out.println("MaCLB: " + MaCLB);
 
        System.out.println("W: " + MainPanelCLB.getPreferredSize().width + ", H: " + MainPanelCLB.getPreferredSize().getHeight());
        
//        textPaneVSCustom1.setPreferredSize(new Dimension(400,(int) textPaneVSCustom1.getPreferredSize().getHeight()));

        /// BodyData
        try {
            Connection conn = ConnectionManager.getConnection();
               
            String sql = "select * from CHITIETCAULACBO where MACLB = " + MaCLB;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
//            System.out.println("sql: " + sql);
            
            while(rs.next())
            {            
                // ----- Get Data Start -----
                Blob blob;
                
                blob = rs.getBlob("INTRODUCTION");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    GioiThieu = new String(bdata);
                }
                
//                System.out.println("GioiThieu: " + GioiThieu);
                
                blob = rs.getBlob("THONGTINCLB");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    ThongTinCLB = new String(bdata);
                }
                
                blob = rs.getBlob("DIEULE");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    DieuLe = new String(bdata);
                }
                
                Email = rs.getString("EMAIL"); 
                SDT = rs.getString("SDT");
                Truong = rs.getNString("TRUONG");
                LoaiCLB = rs.getNString("LOAICLB");
                
                SLDanhGia = rs.getInt("SOLUONGDANHGIA");
                SaoDanhGia = rs.getInt("SaoDanhGia");
                // ----- Get Data End -----
                
                Text_Introduction.setText(GioiThieu);
                Text_Email.setText(Email);
                Text_SDT.setText(SDT);
                Text_School.setText(Truong);
                Text_Club.setText(LoaiCLB);
                TextArea_InfoClub1.setText(ThongTinCLB);
//                TextArea_InfoClub1.setText("ASDASD ASD AS DAS DSA DAS DASD AS DAS DAS DAS DAS DAS DAS DA DAS DAS sadas dsadsadsadsadsadsd sd sd asd asd asd as das dsa das d as das das das das das das dsa das das dasd as das as das das dsd ");
                TextArea_LawClub.setText(DieuLe);
                
                if(SLDanhGia == 0)
                    Text_Rate.setText("Chưa đánh giá (" + SLDanhGia + " đã đánh giá)");
                else    
                    {
                        String SaoDG = "";
                        for(int i = 1; i <= (int) SaoDanhGia; i++)
                            SaoDG += "★";
                        
                        for (int i = (int) SaoDanhGia + 1; i <= 5; i++)
                            SaoDG += "☆";

                        Text_Rate.setText(SaoDG + " (" + SLDanhGia + " đã đánh giá)");
                    }
            
            } 
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /// HeadData
        
        String NameCLB = "", BackgroundImageURL = "", LogoImageURL = "";
        int SLThanhVien, SLThich, Status;
        
        try {
            Connection conn = ConnectionManager.getConnection();
               
            String sql = "select * from CAULACBO where MACLB = " + MaCLB;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
            while(rs.next())
            {
                // ----- Get Data Start -----
                Blob blob;   
                
                NameCLB = rs.getNString("TENCLB");
                
                blob = rs.getBlob("BACKGROUND");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    BackgroundImageURL = new String(bdata);
                }
                
                blob = rs.getBlob("LOGO");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    LogoImageURL = new String(bdata);
                }
                
                SLThanhVien = rs.getInt("SOLUONGTHANHVIEN");
                SLThich = rs.getInt("SOLUONGTHICH");
                Status = rs.getInt("TRANGTHAI");
                // ----- Get Data End -----
                
                Text_NameClub.setText(NameCLB);
                Text_NumLoveOfClub.setText("Số lượng lượt thích: " + SLThich);
                Text_NumMem.setText("Số lượng thành viên: " + SLThanhVien);
                
                String Status_ = "Không hoạt động";
                if(Status == 2)
                    Status_ = "Đang có sự kiện";
                else if(Status == 1)
                    Status_ = "Đang hoạt động";
                Text_Status.setText(Status_);
                Text_StatusClub.setText(Status_);
                
                //set logo and background
                
                if(!LogoImageURL.equals(""))
                    LogoClub.setImage(new ImageIcon(getClass().getResource(LogoImageURL)));
                
                if(!BackgroundImageURL.equals(""))
                    CoverClub.setImage(new ImageIcon(getClass().getResource(BackgroundImageURL)));
            } 
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /// TableData
        
        TableMembers.removeAll();
        
        try {
            String NameTV = "", MSSVTV = "", EmailTV = "", PosTV = "";
            
            Connection conn = ConnectionManager.getConnection();
               
            String sql = "select TK.HOTEN, SV.MSSV, TK.EMAIL, TV.CHUCVU " +
                        "from THANHVIENCLB TV inner join TAIKHOAN TK on TV.MATK = TK.MATK " +
                        "inner join SINHVIEN SV on TK.MATK = SV.MATK " + 
                        "where TV.MACLB = " + MaCLB;
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
            while(rs.next())
            {
                // ----- Get Data Start -----
                NameTV = rs.getNString(1);
                MSSVTV = rs.getString(2);
                EmailTV = rs.getString(3);
                PosTV = rs.getNString(4);
                // ----- Get Data End -----
                
                AddMemToTable(NameTV, MSSVTV, EmailTV, PosTV);
            } 
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // slideShow Data
        try {
            String ImageUrl = "";
            ArrayList<String> ListImageUrl = new ArrayList<String>();
            
            Connection conn = ConnectionManager.getConnection();
            String sql = "select * from HINHANHCAULACBO where MACLB = " + MaCLB;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Blob blob;
                
                blob = rs.getBlob("ANH");
                if(blob != null)
                {
                    byte[] bdata = blob.getBytes(1, (int) blob.length());
                    GioiThieu = new String(bdata);
                }
                
                if(!ImageUrl.equals(""))
                {
                    ListImageUrl.add(ImageUrl);
                }
            } 
            
            SlideShow.initSlideshow(ListImageUrl);
            if(ListImageUrl.size() <= 1)
            {
                SlideShowPanel.remove(BackPanel);
                SlideShowPanel.remove(NextPanel);
            }
            
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Weight: " + (TextArea_InfoClub1.getPreferredSize().width ) + ", " + TextArea_InfoClub1.getSize().width);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        JPanelHeader = new javax.swing.JPanel();
        jpanelRound1 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        JPanelRound1 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        JPanelRound2 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        LogoClub = new com.uiteco.contentPanels.CauLacBo.ImageAvatar();
        BackgroundIcon = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Text_NameClub = new javax.swing.JLabel();
        Text_NumMem = new javax.swing.JLabel();
        Text_NumLoveOfClub = new javax.swing.JLabel();
        Text_StatusClub = new javax.swing.JLabel();
        JoinButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound();
        LoveButton = new com.uiteco.contentPanels.CauLacBo.ButtonRound();
        jPanel1 = new javax.swing.JPanel();
        jpanelRound2 = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        CoverClub = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        JPanelBody = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        IntroductionPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Lock_Introduction = new javax.swing.JLabel();
        Text_Introduction = new javax.swing.JTextArea();
        Line1 = new javax.swing.JPanel();
        Text_SDT = new javax.swing.JLabel();
        Lock_SDT = new javax.swing.JLabel();
        Text_Status = new javax.swing.JLabel();
        Lock_Rate = new javax.swing.JLabel();
        Lock_Status = new javax.swing.JLabel();
        Text_Rate = new javax.swing.JLabel();
        Lock_Club = new javax.swing.JLabel();
        Text_Club = new javax.swing.JLabel();
        Lock_School = new javax.swing.JLabel();
        Text_School = new javax.swing.JLabel();
        Lock_Email = new javax.swing.JLabel();
        Text_Email = new javax.swing.JLabel();
        BodyPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        SlideShowPanel = new javax.swing.JPanel();
        BackPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        BackIcon = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        NextPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        NextIcon = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        SlideShow = new com.uiteco.contentPanels.CauLacBo.SlideShow.Slideshow();
        TextArea_InfoClub1 = new javax.swing.JTextArea();
        Lock_SuKien = new javax.swing.JLabel();
        ThanhVienPanel = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Lock_ThanhVien = new javax.swing.JLabel();
        jScrollTableMem = new javax.swing.JScrollPane();
        TableMembers = new javax.swing.JTable();
        Line2 = new javax.swing.JPanel();
        Line3 = new javax.swing.JPanel();
        Icon_Lock_InfoClb = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Lock_InfoClb = new javax.swing.JLabel();
        Line4 = new javax.swing.JPanel();
        Line5 = new javax.swing.JPanel();
        Icon_Lock_LawClb = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        Lock_LawClb = new javax.swing.JLabel();
        Line6 = new javax.swing.JPanel();
        TextArea_LawClub = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        textPaneVSCustom1 = new com.uiteco.contentPanels.CauLacBo.TextPaneVSCustom();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBackground(new java.awt.Color(225, 225, 225));

        JPanelHeader.setBackground(new java.awt.Color(225, 225, 225));
        JPanelHeader.setPreferredSize(new java.awt.Dimension(810, 575));

        jpanelRound1.setBackground(new java.awt.Color(153, 0, 153));
        jpanelRound1.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Tran.png"))); // NOI18N

        JPanelRound1.setBackground(new java.awt.Color(225, 225, 225));
        JPanelRound1.setRoundTopRight(80);

        JPanelRound2.setBackground(new java.awt.Color(58, 58, 58));

        LogoClub.setBackground(new java.awt.Color(70, 72, 73));
        LogoClub.setBorderColor(new java.awt.Color(48, 48, 48));
        LogoClub.setBorderSize(8);
        LogoClub.setImage(new javax.swing.ImageIcon(getClass().getResource("/uit.jpg"))); // NOI18N

        BackgroundIcon.setBackground(new java.awt.Color(58, 58, 58));
        BackgroundIcon.setRoundBottomLeft(80);
        BackgroundIcon.setRoundTopRight(70);

        Text_NameClub.setFont(new java.awt.Font("Segoe UI", 1, 33)); // NOI18N
        Text_NameClub.setForeground(new java.awt.Color(243, 243, 243));
        Text_NameClub.setText("NAME CLUB");

        Text_NumMem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Text_NumMem.setForeground(new java.awt.Color(204, 204, 204));
        Text_NumMem.setText("NumMemOfClub");

        Text_NumLoveOfClub.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Text_NumLoveOfClub.setForeground(new java.awt.Color(204, 204, 204));
        Text_NumLoveOfClub.setText("NumLoveOfClub");

        Text_StatusClub.setForeground(new java.awt.Color(255, 204, 51));
        Text_StatusClub.setText("StatusClub");

        JoinButton.setBackground(new java.awt.Color(0, 153, 255));
        JoinButton.setBorder(null);
        JoinButton.setForeground(new java.awt.Color(255, 255, 255));
        JoinButton.setText("Tham Gia");
        JoinButton.setboderSize(4);
        JoinButton.setBorderColor(new java.awt.Color(0, 149, 250));
        JoinButton.setColor(new java.awt.Color(0, 153, 255));
        JoinButton.setColorClick(new java.awt.Color(0, 130, 217));
        JoinButton.setColorOver(new java.awt.Color(0, 140, 235));
        JoinButton.setFocusable(false);
        JoinButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JoinButton.setInheritsPopupMenu(true);
        JoinButton.setRadius(10);
        JoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinButtonActionPerformed(evt);
            }
        });

        LoveButton.setBackground(new java.awt.Color(255, 83, 83));
        LoveButton.setBorder(null);
        LoveButton.setForeground(new java.awt.Color(255, 255, 255));
        LoveButton.setText("Yêu Thích");
        LoveButton.setboderSize(4);
        LoveButton.setBorderColor(new java.awt.Color(255, 79, 79));
        LoveButton.setColor(new java.awt.Color(255, 83, 83));
        LoveButton.setColorClick(new java.awt.Color(255, 47, 47));
        LoveButton.setColorOver(new java.awt.Color(255, 66, 66));
        LoveButton.setFocusable(false);
        LoveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoveButton.setInheritsPopupMenu(true);
        LoveButton.setRadius(10);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundIconLayout = new javax.swing.GroupLayout(BackgroundIcon);
        BackgroundIcon.setLayout(BackgroundIconLayout);
        BackgroundIconLayout.setHorizontalGroup(
            BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundIconLayout.createSequentialGroup()
                .addGroup(BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundIconLayout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundIconLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_NameClub, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BackgroundIconLayout.createSequentialGroup()
                                .addComponent(Text_NumMem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Text_NumLoveOfClub, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundIconLayout.createSequentialGroup()
                                .addComponent(Text_StatusClub, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(LoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        BackgroundIconLayout.setVerticalGroup(
            BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundIconLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Text_NameClub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_NumMem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_NumLoveOfClub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_StatusClub, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LogoClub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BackgroundIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelRound1Layout.setVerticalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(BackgroundIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(LogoClub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(JPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpanelRound2.setBackground(new java.awt.Color(204, 204, 204));

        CoverClub.setBackground(new java.awt.Color(204, 204, 204));
        CoverClub.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg"))); // NOI18N

        javax.swing.GroupLayout CoverClubLayout = new javax.swing.GroupLayout(CoverClub);
        CoverClub.setLayout(CoverClubLayout);
        CoverClubLayout.setHorizontalGroup(
            CoverClubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        CoverClubLayout.setVerticalGroup(
            CoverClubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpanelRound2Layout = new javax.swing.GroupLayout(jpanelRound2);
        jpanelRound2.setLayout(jpanelRound2Layout);
        jpanelRound2Layout.setHorizontalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CoverClub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanelRound2Layout.setVerticalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CoverClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout JPanelHeaderLayout = new javax.swing.GroupLayout(JPanelHeader);
        JPanelHeader.setLayout(JPanelHeaderLayout);
        JPanelHeaderLayout.setHorizontalGroup(
            JPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPanelHeaderLayout.setVerticalGroup(
            JPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelHeaderLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(JPanelHeader, java.awt.BorderLayout.NORTH);

        JPanelBody.setBackground(new java.awt.Color(225, 225, 225));

        IntroductionPanel.setBackground(new java.awt.Color(243, 243, 243));
        IntroductionPanel.setRoundBottomRight(53);
        IntroductionPanel.setRoundTopRight(60);

        Lock_Introduction.setBackground(new java.awt.Color(51, 51, 51));
        Lock_Introduction.setFont(new java.awt.Font("Calibri", 1, 26)); // NOI18N
        Lock_Introduction.setForeground(new java.awt.Color(51, 51, 51));
        Lock_Introduction.setText("Giới Thiệu");

        Text_Introduction.setBackground(new java.awt.Color(243, 243, 243));
        Text_Introduction.setColumns(20);
        Text_Introduction.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Text_Introduction.setForeground(new java.awt.Color(51, 51, 51));
        Text_Introduction.setLineWrap(true);
        Text_Introduction.setRows(1);
        Text_Introduction.setText("...");
        Text_Introduction.setWrapStyleWord(true);

        Line1.setBackground(new java.awt.Color(203, 203, 203));
        Line1.setForeground(new java.awt.Color(211, 211, 211));

        Text_SDT.setBackground(new java.awt.Color(37, 40, 41));
        Text_SDT.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Text_SDT.setForeground(new java.awt.Color(130, 130, 130));
        Text_SDT.setText("...");

        Lock_SDT.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_SDT.setForeground(new java.awt.Color(51, 51, 51));
        Lock_SDT.setText("SĐT  ·");

        Text_Status.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Text_Status.setForeground(new java.awt.Color(255, 153, 51));
        Text_Status.setText("Hoạt Động");

        Lock_Rate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_Rate.setForeground(new java.awt.Color(51, 51, 51));
        Lock_Rate.setText("Đánh giá  ·");

        Lock_Status.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_Status.setForeground(new java.awt.Color(51, 51, 51));
        Lock_Status.setText("Trạng Thái  ·");

        Text_Rate.setBackground(new java.awt.Color(48, 50, 51));
        Text_Rate.setForeground(new java.awt.Color(181, 181, 181));
        Text_Rate.setText("★★★☆☆ (0 đã đánh giá)");

        Lock_Club.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_Club.setForeground(new java.awt.Color(51, 51, 51));
        Lock_Club.setText("CLUB  ·");

        Text_Club.setBackground(new java.awt.Color(37, 40, 41));
        Text_Club.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Text_Club.setForeground(new java.awt.Color(130, 130, 130));
        Text_Club.setText("...");

        Lock_School.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_School.setForeground(new java.awt.Color(51, 51, 51));
        Lock_School.setText("Trường  ·");

        Text_School.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Text_School.setForeground(new java.awt.Color(41, 190, 41));
        Text_School.setText("...");

        Lock_Email.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Lock_Email.setForeground(new java.awt.Color(51, 51, 51));
        Lock_Email.setText("EMAIL  ·");

        Text_Email.setBackground(new java.awt.Color(37, 40, 41));
        Text_Email.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Text_Email.setForeground(new java.awt.Color(130, 130, 130));
        Text_Email.setText("...");

        javax.swing.GroupLayout IntroductionPanelLayout = new javax.swing.GroupLayout(IntroductionPanel);
        IntroductionPanel.setLayout(IntroductionPanelLayout);
        IntroductionPanelLayout.setHorizontalGroup(
            IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(IntroductionPanelLayout.createSequentialGroup()
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addComponent(Lock_School, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Text_School))
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addComponent(Lock_Rate)
                                .addGap(5, 5, 5)
                                .addComponent(Text_Rate))
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addComponent(Lock_Club)
                                .addGap(8, 8, 8)
                                .addComponent(Text_Club)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addComponent(Lock_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Text_SDT))
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addComponent(Lock_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Text_Status))
                            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(Text_Email))
                            .addComponent(Lock_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(215, 215, 215))
                    .addGroup(IntroductionPanelLayout.createSequentialGroup()
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Line1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lock_Introduction, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Introduction, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(60, 60, 60))))
        );
        IntroductionPanelLayout.setVerticalGroup(
            IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IntroductionPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lock_Introduction, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(IntroductionPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Text_Introduction)))
                .addGap(12, 12, 12)
                .addComponent(Line1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IntroductionPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lock_Club)
                            .addComponent(Text_Club))
                        .addGap(12, 12, 12)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lock_School)
                            .addComponent(Text_School))
                        .addGap(12, 12, 12)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lock_Rate)
                            .addComponent(Text_Rate)))
                    .addGroup(IntroductionPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_SDT)
                            .addComponent(Lock_SDT))
                        .addGap(12, 12, 12)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_Email)
                            .addComponent(Lock_Email))
                        .addGap(12, 12, 12)
                        .addGroup(IntroductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lock_Status)
                            .addComponent(Text_Status))))
                .addGap(35, 35, 35))
        );

        BodyPanel.setBackground(new java.awt.Color(243, 243, 243));
        BodyPanel.setRoundBottomLeft(50);
        BodyPanel.setRoundBottomRight(50);
        BodyPanel.setRoundTopLeft(50);
        BodyPanel.setRoundTopRight(50);

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
        BackPanel.add(BackIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 150, 50, 60));

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
        NextPanel.add(NextIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 150, 50, 60));

        javax.swing.GroupLayout SlideShowPanelLayout = new javax.swing.GroupLayout(SlideShowPanel);
        SlideShowPanel.setLayout(SlideShowPanelLayout);
        SlideShowPanelLayout.setHorizontalGroup(
            SlideShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SlideShowPanelLayout.createSequentialGroup()
                .addComponent(BackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(SlideShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SlideShowPanelLayout.setVerticalGroup(
            SlideShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(SlideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TextArea_InfoClub1.setBackground(new java.awt.Color(243, 243, 243));
        TextArea_InfoClub1.setColumns(20);
        TextArea_InfoClub1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextArea_InfoClub1.setForeground(new java.awt.Color(44, 44, 44));
        TextArea_InfoClub1.setLineWrap(true);
        TextArea_InfoClub1.setRows(1);
        TextArea_InfoClub1.setText("...");
        TextArea_InfoClub1.setWrapStyleWord(true);

        Lock_SuKien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Lock_SuKien.setForeground(new java.awt.Color(100, 124, 214));
        Lock_SuKien.setText("Hình ảnh về câu lạc bộ");

        ThanhVienPanel.setBackground(new java.awt.Color(0, 131, 218));
        ThanhVienPanel.setRoundTopLeft(30);
        ThanhVienPanel.setRoundTopRight(30);

        Lock_ThanhVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lock_ThanhVien.setForeground(new java.awt.Color(255, 255, 255));
        Lock_ThanhVien.setText("Thành Viên Nhóm");

        javax.swing.GroupLayout ThanhVienPanelLayout = new javax.swing.GroupLayout(ThanhVienPanel);
        ThanhVienPanel.setLayout(ThanhVienPanelLayout);
        ThanhVienPanelLayout.setHorizontalGroup(
            ThanhVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThanhVienPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lock_ThanhVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThanhVienPanelLayout.setVerticalGroup(
            ThanhVienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThanhVienPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Lock_ThanhVien)
                .addGap(8, 8, 8))
        );

        TableMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ Và Tên", "MSSV", "Email", "Chức Vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMembers.getTableHeader().setReorderingAllowed(false);
        jScrollTableMem.setViewportView(TableMembers);
        if (TableMembers.getColumnModel().getColumnCount() > 0) {
            TableMembers.getColumnModel().getColumn(0).setResizable(false);
            TableMembers.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableMembers.getColumnModel().getColumn(1).setResizable(false);
            TableMembers.getColumnModel().getColumn(1).setPreferredWidth(170);
            TableMembers.getColumnModel().getColumn(2).setResizable(false);
            TableMembers.getColumnModel().getColumn(2).setPreferredWidth(80);
            TableMembers.getColumnModel().getColumn(3).setResizable(false);
            TableMembers.getColumnModel().getColumn(3).setPreferredWidth(170);
            TableMembers.getColumnModel().getColumn(4).setResizable(false);
            TableMembers.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        Line2.setBackground(new java.awt.Color(203, 203, 203));

        javax.swing.GroupLayout Line2Layout = new javax.swing.GroupLayout(Line2);
        Line2.setLayout(Line2Layout);
        Line2Layout.setHorizontalGroup(
            Line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line2Layout.setVerticalGroup(
            Line2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Line3.setBackground(new java.awt.Color(203, 203, 203));

        javax.swing.GroupLayout Line3Layout = new javax.swing.GroupLayout(Line3);
        Line3.setLayout(Line3Layout);
        Line3Layout.setHorizontalGroup(
            Line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line3Layout.setVerticalGroup(
            Line3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Icon_Lock_InfoClb.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/InfoCLB.png"))); // NOI18N

        javax.swing.GroupLayout Icon_Lock_InfoClbLayout = new javax.swing.GroupLayout(Icon_Lock_InfoClb);
        Icon_Lock_InfoClb.setLayout(Icon_Lock_InfoClbLayout);
        Icon_Lock_InfoClbLayout.setHorizontalGroup(
            Icon_Lock_InfoClbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        Icon_Lock_InfoClbLayout.setVerticalGroup(
            Icon_Lock_InfoClbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        Lock_InfoClb.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Lock_InfoClb.setForeground(new java.awt.Color(0, 0, 0));
        Lock_InfoClb.setText("Thông tin CLB ");

        Line4.setBackground(new java.awt.Color(203, 203, 203));

        javax.swing.GroupLayout Line4Layout = new javax.swing.GroupLayout(Line4);
        Line4.setLayout(Line4Layout);
        Line4Layout.setHorizontalGroup(
            Line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line4Layout.setVerticalGroup(
            Line4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Line5.setBackground(new java.awt.Color(203, 203, 203));
        Line5.setPreferredSize(new java.awt.Dimension(669, 1));

        javax.swing.GroupLayout Line5Layout = new javax.swing.GroupLayout(Line5);
        Line5.setLayout(Line5Layout);
        Line5Layout.setHorizontalGroup(
            Line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line5Layout.setVerticalGroup(
            Line5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        Icon_Lock_LawClb.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/RuleCLB.png"))); // NOI18N

        javax.swing.GroupLayout Icon_Lock_LawClbLayout = new javax.swing.GroupLayout(Icon_Lock_LawClb);
        Icon_Lock_LawClb.setLayout(Icon_Lock_LawClbLayout);
        Icon_Lock_LawClbLayout.setHorizontalGroup(
            Icon_Lock_LawClbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        Icon_Lock_LawClbLayout.setVerticalGroup(
            Icon_Lock_LawClbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        Lock_LawClb.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Lock_LawClb.setForeground(new java.awt.Color(0, 0, 0));
        Lock_LawClb.setText("Điều Lệ");

        Line6.setBackground(new java.awt.Color(203, 203, 203));
        Line6.setPreferredSize(new java.awt.Dimension(669, 1));

        javax.swing.GroupLayout Line6Layout = new javax.swing.GroupLayout(Line6);
        Line6.setLayout(Line6Layout);
        Line6Layout.setHorizontalGroup(
            Line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Line6Layout.setVerticalGroup(
            Line6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        TextArea_LawClub.setEditable(false);
        TextArea_LawClub.setBackground(new java.awt.Color(243, 243, 243));
        TextArea_LawClub.setColumns(20);
        TextArea_LawClub.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TextArea_LawClub.setForeground(new java.awt.Color(44, 44, 44));
        TextArea_LawClub.setLineWrap(true);
        TextArea_LawClub.setRows(1);
        TextArea_LawClub.setText("...");
        TextArea_LawClub.setWrapStyleWord(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Line5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                            .addComponent(Line4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Line2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ThanhVienPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SlideShowPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollTableMem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Line6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                            .addComponent(TextArea_LawClub, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextArea_InfoClub1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addComponent(Icon_Lock_LawClb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Lock_LawClb))
                            .addGroup(BodyPanelLayout.createSequentialGroup()
                                .addComponent(Icon_Lock_InfoClb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(Lock_InfoClb))
                            .addComponent(Lock_SuKien)
                            .addComponent(textPaneVSCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Lock_SuKien)
                .addGap(18, 18, 18)
                .addComponent(SlideShowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(ThanhVienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollTableMem, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Line3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon_Lock_InfoClb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Lock_InfoClb)))
                .addGap(15, 15, 15)
                .addComponent(Line4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TextArea_InfoClub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textPaneVSCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(Line5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon_Lock_LawClb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lock_LawClb, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addComponent(Line6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TextArea_LawClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout JPanelBodyLayout = new javax.swing.GroupLayout(JPanelBody);
        JPanelBody.setLayout(JPanelBodyLayout);
        JPanelBodyLayout.setHorizontalGroup(
            JPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelBodyLayout.createSequentialGroup()
                .addGroup(JPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IntroductionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JPanelBodyLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
        );
        JPanelBodyLayout.setVerticalGroup(
            JPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelBodyLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(IntroductionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(BodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        add(JPanelBody, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void BackPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseEntered
        BackPanel.setAlpha(0.1f);
        BackIcon.setAlpha(0.25f);
    }//GEN-LAST:event_BackPanelMouseEntered

    private void BackPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseExited
        BackPanel.setAlpha(0f);
        BackIcon.setAlpha(0.15f);
    }//GEN-LAST:event_BackPanelMouseExited

    private void BackPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BackPanelMouseClicked

    private void NextPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseEntered
        NextPanel.setAlpha(0.1f);
        NextIcon.setAlpha(0.25f);
    }//GEN-LAST:event_NextPanelMouseEntered

    private void NextPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseExited
        NextPanel.setAlpha(0f);
        NextIcon.setAlpha(0.15f);
    }//GEN-LAST:event_NextPanelMouseExited

    private void NextPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NextPanelMouseClicked

    private void JoinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JoinButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackIcon;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackPanel;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackgroundIcon;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BodyPanel;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound CoverClub;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound Icon_Lock_InfoClb;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound Icon_Lock_LawClb;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound IntroductionPanel;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound JPanelBody;
    private javax.swing.JPanel JPanelHeader;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound JPanelRound1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound JPanelRound2;
    private com.uiteco.contentPanels.CauLacBo.ButtonRound JoinButton;
    private javax.swing.JPanel Line1;
    private javax.swing.JPanel Line2;
    private javax.swing.JPanel Line3;
    private javax.swing.JPanel Line4;
    private javax.swing.JPanel Line5;
    private javax.swing.JPanel Line6;
    private javax.swing.JLabel Lock_Club;
    private javax.swing.JLabel Lock_Email;
    private javax.swing.JLabel Lock_InfoClb;
    private javax.swing.JLabel Lock_Introduction;
    private javax.swing.JLabel Lock_LawClb;
    private javax.swing.JLabel Lock_Rate;
    private javax.swing.JLabel Lock_SDT;
    private javax.swing.JLabel Lock_School;
    private javax.swing.JLabel Lock_Status;
    private javax.swing.JLabel Lock_SuKien;
    private javax.swing.JLabel Lock_ThanhVien;
    private com.uiteco.contentPanels.CauLacBo.ImageAvatar LogoClub;
    private com.uiteco.contentPanels.CauLacBo.ButtonRound LoveButton;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound NextIcon;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound NextPanel;
    private com.uiteco.contentPanels.CauLacBo.SlideShow.Slideshow SlideShow;
    private javax.swing.JPanel SlideShowPanel;
    private javax.swing.JTable TableMembers;
    private javax.swing.JTextArea TextArea_InfoClub1;
    private javax.swing.JTextArea TextArea_LawClub;
    private javax.swing.JLabel Text_Club;
    private javax.swing.JLabel Text_Email;
    private javax.swing.JTextArea Text_Introduction;
    private javax.swing.JLabel Text_NameClub;
    private javax.swing.JLabel Text_NumLoveOfClub;
    private javax.swing.JLabel Text_NumMem;
    private javax.swing.JLabel Text_Rate;
    private javax.swing.JLabel Text_SDT;
    private javax.swing.JLabel Text_School;
    private javax.swing.JLabel Text_Status;
    private javax.swing.JLabel Text_StatusClub;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound ThanhVienPanel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollTableMem;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound1;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound jpanelRound2;
    private com.uiteco.contentPanels.CauLacBo.TextPaneVSCustom textPaneVSCustom1;
    // End of variables declaration//GEN-END:variables
}
