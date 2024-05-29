package com.uiteco.contentPanels;

import com.uiteco.contentPanels.CauLacBo.DetailPageCLB;
import com.uiteco.contentPanels.CauLacBo.FloatingBackUI.FloatingButtonUI;
import com.uiteco.contentPanels.CauLacBo.IntroductionClub;
import com.uiteco.database.ConnectionManager;
import com.uiteco.rightPanels.CauLacBoRightPanel;
import com.uiteco.swing.ContentPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import com.uiteco.swing.ScrollableContentPanel;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLayer;

/**
 *
 * @author VStorm
 */

public class CauLacBoPanel extends JPanel {
    // Biến Lưu trữ các thông tin của CLB
    private CauLacBoRightPanel RightPanelCLB;
    private java.util.ArrayList<IntroductionClub> ListCLB = new java.util.ArrayList();
    private int NumOfPageCLB = 0;
    private ContentPanel mainContentPanel;
    private ContentPanel Interface = new ContentPanel();
    private String CurrentPage = "Tab1";
    
    private int indexLayer = 0;
    private JLayer CurrentLayer; 
    
    private int NumberCLUB = 0, NumberEvent = 0, NumberOnline = 0, NumberOffline = 0;
    
    public CauLacBoPanel() {
        Start();
    }
    
    public CauLacBoPanel(CauLacBoRightPanel RightPanelCLB, ContentPanel mainContentPanel) {
        this.RightPanelCLB = RightPanelCLB;
        this.mainContentPanel = mainContentPanel;
        RightPanelCLB.setClubPanel(this);
               
        Start();
    }
    
    private void Start()
    {
//        initComponents();
        addDatabaseToListCLB();
        ConTentPanelCauLacBo();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents
    
    private JPanel ShowBodyInterfaceCLB(int startIndex, int endIndex)
    {     
        javax.swing.JPanel GroupCLB = new javax.swing.JPanel();
        int marginX = 15, marginClb = 25;
        int marginY = 15;
        
        for(int index = startIndex; index < endIndex; index++)
        {    
            IntroductionClub clb = ListCLB.get(index);  
            GroupCLB.add(clb);           
        }
        
        //GroupCLB.setBounds(marginX, marginY, 900, 1200);      this.setLayout(null);
        GroupCLB.setLayout(new GridLayout(Math.max(endIndex - startIndex, 3), 1, 0, marginClb));

        return GroupCLB;
    }
    
    private JPanel ShowHeaderInterfaceCLB(int NumberCLUB, int NumberEvent, int NumberOnline, int NumberOffline)
    {
        JPanel HeaderCLUB = new JPanel();
        //HeaderCLUB.setBackground(Color.BLUE);
        HeaderCLUB.setVisible(true);
        
        HeaderCLUB.setPreferredSize(new Dimension(0, 200));
        HeaderCLUB.setLayout(new BorderLayout(0, 0));
        
        JPanel TopMargin = new JPanel();
        TopMargin.setBackground(HeaderCLUB.getBackground());
        TopMargin.setPreferredSize(new Dimension(0, 15));
        HeaderCLUB.add(TopMargin, BorderLayout.NORTH);
        HeaderCLUB.add(new com.uiteco.contentPanels.CauLacBo.HeaderCLB(NumberCLUB, NumberEvent, NumberOnline, NumberOffline), BorderLayout.CENTER);
        
        return HeaderCLUB;
    }
    
    private JPanel ShowFooterInterfaceCLB(int PresentPage)
    {
        // Thêm footer chuyển page
        
        JPanel FooterCLUB = new JPanel();
        FooterCLUB.setVisible(true);
        FooterCLUB.setPreferredSize(new Dimension(0, 68));
        
        com.uiteco.contentPanels.CauLacBo.FooterChangePageCLB ChangePageCLB = new com.uiteco.contentPanels.CauLacBo.FooterChangePageCLB(120, PresentPage, NumOfPageCLB);
        ChangePageCLB.setMainPanel(this);
        
        FooterCLUB.setLayout(new java.awt.FlowLayout());
        FooterCLUB.add(ChangePageCLB);
       
        return FooterCLUB;
    }
    
    private void addDatabaseToListCLB()
    {
        
        String NameCLB = "", InfoCLB = "", BackgroundImageURL = null, LogoImageURL = "", Khoa = "", CreateBy = "", HostBy = "";
        int MaCLB, SLThanhVien, SLThich, DKXetTuyen, Status;
        LocalDateTime LastedDate = null;
        LocalDate DateCreate = null;
        
        try {
            Connection conn = ConnectionManager.getConnection();
               
            String sql = "select * from Caulacbo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                // ----- Get Data Start -----
                Blob blob;   
//                System.out.println("" + rs.getString("maclb") + " , " + rs.getString("TenCLB"));
                MaCLB = rs.getInt("maclb");
                NameCLB = rs.getNString("TENCLB");
                InfoCLB = rs.getNString("GIOITHIEU");
                Khoa = rs.getNString("KHOA");
                
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
                DKXetTuyen = rs.getInt("DKXETTUYEN");
                Status = rs.getInt("TRANGTHAI");
                
                Timestamp timestamp= rs.getTimestamp("NGAYCAPNHAPGANNHAT");
                if(timestamp != null)
                    LastedDate = timestamp.toLocalDateTime();
                
                CreateBy = rs.getNString("NHOMNGUOITHANHLAP");
                HostBy = rs.getInt("CHUNHIEM") + "";
                
                Date date = rs.getDate("NGAYTHANHLAP");
                if(date != null)
                    DateCreate = date.toLocalDate();

                // ----- Get Data End -----
   
                ArrayList<String> ListImageUrl = new ArrayList();
                    
                if(BackgroundImageURL != null)
                {
                    ListImageUrl.add(BackgroundImageURL);
                }
                
                {
                    String FirstBackgroundImageURL = "";
                    
                    try {
                        Connection conn1 = ConnectionManager.getConnection();

                        String sql1 = "select * from HINHANHCAULACBO where MACLB = " + MaCLB;
                        PreparedStatement ps1 = conn1.prepareStatement(sql1);
                        ResultSet rs1 = ps1.executeQuery();
                        
                        while(rs1.next())
                        {
                            blob = rs1.getBlob("ANH");
                            if(blob != null)
                            {
                                byte[] bdata = blob.getBytes(1, (int) blob.length());
                                FirstBackgroundImageURL = new String(bdata);
                            }
                            
                            break;
                        }
                        
                        conn1.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    if(!FirstBackgroundImageURL.equals(""))
                        ListImageUrl.add(FirstBackgroundImageURL);
                }
                
                IntroductionClub Clb = new IntroductionClub(NameCLB, InfoCLB, LogoImageURL, SLThanhVien, LastedDate, Khoa, Status, ListImageUrl);
                
                Clb.setMainPanel(this);
                Clb.setRightPanelCLB(RightPanelCLB);
                Clb.setMaCLB(MaCLB);
                Clb.setSLThich(SLThich);
                Clb.setDKXetTuyen(DKXetTuyen);
                Clb.setCreateBy(CreateBy);
                Clb.setHostBy(HostBy);
                Clb.setDateCreate(DateCreate);
                
                ListCLB.add(Clb);
                
                NumberCLUB++;
                
                if(Status == 0)
                    NumberOffline++;
                else
                {
                    NumberOnline++;
                    if(Status == 2)
                        NumberEvent++;
                }
            }
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private int LastedNumOfPageCLB = 0;
    
    private void ConTentPanelCauLacBo()    
    {   
        System.out.println("goto content");
        
        boolean checkIsInit = true;
        if(LastedNumOfPageCLB == 0)
            checkIsInit = false;
        
        int MAXClbIn1Tab = 5;
        NumOfPageCLB = ListCLB.size() % MAXClbIn1Tab == 0 ? ListCLB.size() / MAXClbIn1Tab : ListCLB.size() / MAXClbIn1Tab + 1;
        NumOfPageCLB = Math.max(NumOfPageCLB, 1);    
        
        for(int i = 1 ; i <= NumOfPageCLB; i++)
        {
            ScrollableContentPanel NewTab = new ScrollableContentPanel();
            JPanel InterfacePanel = new JPanel();
            
            if(LastedNumOfPageCLB >= i)
            {
                NewTab = (ScrollableContentPanel) Interface.getComponent("Tab" + i);
//                NewTab.removeAll();   
                InterfacePanel = (JPanel) NewTab.getComponent("Interface");
                InterfacePanel.removeAll();
            }
            
            NewTab.setFocusable(false);

            InterfacePanel.setLayout(new java.awt.BorderLayout(0, 25));
            // HeaderInterfaceCLB
            InterfacePanel.add(ShowHeaderInterfaceCLB(NumberCLUB, NumberEvent, NumberOnline, NumberOffline), java.awt.BorderLayout.NORTH);
            // BodyInterfaceCLB
            InterfacePanel.add(ShowBodyInterfaceCLB((i - 1) * MAXClbIn1Tab + 0, Math.min(i * MAXClbIn1Tab, ListCLB.size())), java.awt.BorderLayout.CENTER);
            // FooterInterfaceCLB
            InterfacePanel.add(ShowFooterInterfaceCLB(i), java.awt.BorderLayout.SOUTH);

            // chỉnh margin phải và trái của Interface
            JPanel RightMargin = new JPanel();
            RightMargin.setBackground(this.getBackground());
            //RightMargin.setBackground(Color.BLACK);
            RightMargin.setPreferredSize(new java.awt.Dimension(120, 0));
//            InterfacePanel.add(RightMargin, java.awt.BorderLayout.EAST);

            JPanel LeftMargin = new JPanel();
            LeftMargin.setBackground(InterfacePanel.getBackground());
            //LeftMargin.setBackground(Color.PINK);
            LeftMargin.setPreferredSize(new java.awt.Dimension(120, 0));
//            InterfacePanel.add(LeftMargin, java.awt.BorderLayout.WEST);    
                
            if(LastedNumOfPageCLB < i)
            {
                NewTab.registerComponent(InterfacePanel, "Interface");
                Interface.registerComponent(NewTab, "Tab" + i);
                LastedNumOfPageCLB ++;
            }
            
            NewTab.showComponentAndTrimHistory("Interface");   
            NewTab.ScrollToBottom();
            NewTab.ScrollToTop();
        }
        
        // Show Interface
        Interface.showComponentAndTrimHistory("Tab1");
        CurrentPage = "Tab1";
        
        if(Interface != null)
            this.remove(Interface);
            
        if(true)
        {
            this.setLayout(new java.awt.BorderLayout(0, 0));
            this.add(Interface, java.awt.BorderLayout.CENTER);
        }
    
        this.repaint();
//        this.repaint(100, 300, 500, HEIGHT);
    }
    
    public void returnToMainPanel()
    {
        Interface.showComponentAndTrimHistory(CurrentPage);
        RightPanelCLB.showMainPanel();
    }
    
    public void goToDetailPage(DetailPageCLB DetailPageCLUB)
    {
        if(DetailPageCLUB == null)
            return;
     
        if(CurrentLayer != null)
        {
            Interface.remove(CurrentLayer);
            CurrentLayer.removeAll();
        }
        
        indexLayer ++;
            
        // add PageClb
        ScrollableContentPanel NewTab = new ScrollableContentPanel();
        NewTab.setFocusable(false);
        JPanel InterfacePanel = new JPanel();
        InterfacePanel.setLayout(new java.awt.BorderLayout(0, 0));
        InterfacePanel.add(DetailPageCLUB, java.awt.BorderLayout.CENTER);
        
        NewTab.registerComponent(InterfacePanel, "Interface");
        NewTab.showComponentAndTrimHistory("Interface");
        NewTab.ScrollToTop();
        
        // add interface
//        Interface.registerComponent(NewTab, "DetailPageCLB");
            
            CurrentLayer = new JLayer(NewTab, new FloatingButtonUI(this));
            Interface.registerComponent(CurrentLayer, "DetailPageCLB" + indexLayer);
        Interface.showComponentAndTrimHistory("DetailPageCLB" + indexLayer);
    }
    
    public void goToNextPage(int PresentPage)
    {
//        System.out.println("Next, Present Page: " + PresentPage);
        
        if(PresentPage + 1 <= NumOfPageCLB)
        {
            Interface.showComponentAndTrimHistory("Tab" + (PresentPage + 1));    
            CurrentPage = "Tab" + (PresentPage + 1);
            
            ScrollableContentPanel ScrollPanel = (ScrollableContentPanel) Interface.getComponent("Tab" + (PresentPage + 1));
            ScrollPanel.ScrollToTop();
        }
    }
    
    public void goToPreviousPage(int PresentPage)
    {
//        System.out.println("Pre, Present Page: " + PresentPage);
        
        if(PresentPage - 1 >= 1)
        {
            Interface.showComponentAndTrimHistory("Tab" + (PresentPage - 1));
            CurrentPage = "Tab" + (PresentPage - 1);
            
            ScrollableContentPanel ScrollPanel = (ScrollableContentPanel) Interface.getComponent("Tab" + (PresentPage - 1));
            ScrollPanel.ScrollToTop();
        }
    }
  
    public void FilterListCLB(String Area, String NameBox, String StyleBox, String Status_, String ConditionJoin)  
    {
        String Bodysql = "", Ordersql = "";
        
        System.out.println("Area: " + Area + ", NameBox: " + NameBox + ", StyleBox: " + StyleBox + ", Status: " + Status_ + ", ConditionJoin: " + ConditionJoin);
    
        if(!Area.equals(""))
        {
            Bodysql += "PHAMVI = " + Area + " ";
        }
        
        if(!Status_.equals(""))
        {
            if(!Bodysql.equals(""))
                Bodysql += "AND ";
            
            Bodysql += "TRANGTHAI = " + Status_ + " ";
        }
        
        if(!ConditionJoin.equals(""))
        {
            if(!Bodysql.equals(""))
                Bodysql += "AND ";
            
            Bodysql += "DKXETTUYEN = " + ConditionJoin + " ";
        }
        
         if(!Bodysql.equals(""))
            Bodysql = "WHERE " + Bodysql;
        
        if(!NameBox.equals(""))
        {
            if(NameBox.equals("Tên"))
                Ordersql += "TENCLB ";
            else
                Ordersql += "SOLUONGTHANHVIEN ";
            
            if(StyleBox.equals("Tăng dần"))
                Ordersql += "ASC ";
            else
                Ordersql += "DESC ";
        }
        
        if(!Ordersql.equals(""))
            Ordersql = "ORDER BY " + Ordersql;
        
        NumberCLUB = 0;
        NumberOffline = 0;
        NumberEvent = 0;
        NumberOnline = 0;
        ListCLB.clear();
        try {
            String NameCLB = "", InfoCLB = "", BackgroundImageURL = null, LogoImageURL = "", Khoa = "", CreateBy = "", HostBy = "";
            int MaCLB, SLThanhVien, SLThich, DKXetTuyen, Status;
            LocalDateTime LastedDate = null;
            LocalDate DateCreate = null;
            String ImageUrl = "";
            
            Connection conn = ConnectionManager.getConnection();
            String sql = "select * from CAULACBO " + Bodysql + Ordersql;
            
            System.out.println("code : " + sql);
            
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                // ----- Get Data Start -----
                Blob blob;   
//                System.out.println("" + rs.getString("maclb") + " , " + rs.getString("TenCLB"));
                MaCLB = rs.getInt("maclb");
                NameCLB = rs.getNString("TENCLB");
                InfoCLB = rs.getNString("GIOITHIEU");
                Khoa = rs.getNString("KHOA");
                
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
                
//                System.out.println("LOGO: " + LogoImageURL);
                
                SLThanhVien = rs.getInt("SOLUONGTHANHVIEN");
                SLThich = rs.getInt("SOLUONGTHICH");
                DKXetTuyen = rs.getInt("DKXETTUYEN");
                Status = rs.getInt("TRANGTHAI");
                
                Timestamp timestamp= rs.getTimestamp("NGAYCAPNHAPGANNHAT");
                if(timestamp != null)
                    LastedDate = timestamp.toLocalDateTime();
                
                CreateBy = rs.getNString("NHOMNGUOITHANHLAP");
                HostBy = rs.getInt("CHUNHIEM") + "";
                
                Date date = rs.getDate("NGAYTHANHLAP");
                if(date != null)
                    DateCreate = date.toLocalDate();

                // ----- Get Data End -----
   
                ArrayList<String> ListImageUrl = new ArrayList();
                    
                if(BackgroundImageURL != null)
                    ListImageUrl.add(BackgroundImageURL);
                
                IntroductionClub Clb = new IntroductionClub(NameCLB, InfoCLB, LogoImageURL, SLThanhVien, LastedDate, Khoa, Status, ListImageUrl);
                Clb.setMainPanel(this);
                Clb.setRightPanelCLB(RightPanelCLB);
                Clb.setMaCLB(MaCLB);
                Clb.setSLThich(SLThich);
                Clb.setDKXetTuyen(DKXetTuyen);
                Clb.setCreateBy(CreateBy);
                Clb.setHostBy(HostBy);
                Clb.setDateCreate(DateCreate);
                
                ListCLB.add(Clb);
                
                NumberCLUB++;
                
                if(Status == 0)
                    NumberOffline++;
                else
                {
                    NumberOnline++;
                    if(Status == 2)
                        NumberEvent++;
                }
            }

            conn.close();
            
            ConTentPanelCauLacBo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
