package com.uiteco.contentPanels;

import com.uiteco.contentPanels.CauLacBo.DetailPageCLB;
import com.uiteco.contentPanels.CauLacBo.FloatingBackUI.FloatingButtonUI;
import com.uiteco.contentPanels.CauLacBo.IntroductionClub;
import com.uiteco.rightPanels.CauLacBoRightPanel;
import com.uiteco.swing.ContentPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import com.uiteco.swing.ScrollableContentPanel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
    private ContentPanel Interface = new ContentPanel();
    private String CurrentPage = "Tab1";
    
    private int indexLayer = 0;
    private JLayer CurrentLayer; 
    
    public CauLacBoPanel() {
//        initComponents();
        ConTentPanelCauLacBo();
    }
    
    public CauLacBoPanel(CauLacBoRightPanel RightPanelCLB) {
//        initComponents();
        this.RightPanelCLB = RightPanelCLB;
        RightPanelCLB.setClubPanel(this);
        
        ConTentPanelCauLacBo();        
//        if(this.RightPanelCLB != null)
//            System.out.println("RightPanel __");
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
        GroupCLB.setLayout(new GridLayout(Math.max(endIndex - startIndex, 3), 1, marginX, marginClb));

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
    
    private void ConTentPanelCauLacBo()    
    {   
        // Biến này ta tăng khi ta nhập dữ liệu từ database;
        // ở đây ta thêm tạm thời vì ta tạo dữ liệu ảo
        int NumberCLUB, NumberEvent, NumberOnline, NumberOffline;
        
        // dữ liệu clb lấy trong database
        // tạm thời cho các thông tin ảo
        
        ArrayList<String> ListImageUrl = new ArrayList();
        ListImageUrl.add("/CauLacBoResources/SampleCoverImage.png");
        ListImageUrl.add("/CauLacBoResources/SampleLogoImage.jpg");
                
        IntroductionClub Clb1 = new IntroductionClub("UITGamAPP", "Câu Lạc Bộ dành cho người có sự đam mê khám phá về game", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 260, LocalDateTime.of(2024,04,18,21,12,16), "Công Nghệ Phần Mềm", 2, ListImageUrl);
        Clb1.setMainPanel(this);
        Clb1.setRightPanelCLB(RightPanelCLB);
        IntroductionClub Clb2 = new IntroductionClub("BadmintonCLB", "Cầu Lông là Sự sống", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 300, LocalDateTime.of(2024,04,18,21,38,0), "Hệ Thống Thông Tin", 1, ListImageUrl);
        Clb2.setMainPanel(this);
        Clb2.setRightPanelCLB(RightPanelCLB);
        IntroductionClub Clb3 = new IntroductionClub("GymCLB", "Sống với GYM ngủ với GYM", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 230, LocalDateTime.of(2024,02,17,0,0,0), "Mạng Máy Tính", 2, ListImageUrl);
        Clb3.setMainPanel(this);
        Clb3.setRightPanelCLB(RightPanelCLB);
        IntroductionClub Clb4 = new IntroductionClub("VStorm Đỉnh VL", "Có ai Pro bằng anh này", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 1, LocalDateTime.of(2020,02,15,0,0,0), "Anh Bão PRO", 1, ListImageUrl);
        Clb4.setMainPanel(this);
        Clb4.setRightPanelCLB(RightPanelCLB);
        IntroductionClub Clb5 = new IntroductionClub("VStorm Đỉnh VL", "Có ai Pro bằng anh này", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 1, LocalDateTime.of(2024,02,15,1,1,1), "Anh Bão PRO", 0, ListImageUrl); 
        Clb5.setMainPanel(this);
        Clb5.setRightPanelCLB(RightPanelCLB);
        IntroductionClub Clb6 = new IntroductionClub("VStorm Đỉnh VL", "Có ai Pro bằng anh này", new ImageIcon(getClass().getResource("/CauLacBoResources/SampleLogoImage.jpg")), 1, LocalDateTime.of(2018,04,15,2,2,2), "Anh Bão PRO", 0, ListImageUrl);
        Clb6.setMainPanel(this);
        Clb6.setRightPanelCLB(RightPanelCLB);
        
        // Với dữ liệu ảo ta tạm tính được
        NumberCLUB = 6;
        NumberEvent = 2;
        NumberOnline = 4;
        NumberOffline = 2;
        
        ListCLB.add(Clb1);
        ListCLB.add(Clb2);
        ListCLB.add(Clb3);
        ListCLB.add(Clb4);
        ListCLB.add(Clb5);
        ListCLB.add(Clb6);

        // Kết thúc tạo biến tạm cho Dữ liệu
        
        int MAXClbIn1Tab = 5;
        NumOfPageCLB = ListCLB.size() % MAXClbIn1Tab == 0 ? ListCLB.size() / MAXClbIn1Tab : ListCLB.size() / MAXClbIn1Tab + 1;
            
        for(int i = 1 ; i <= NumOfPageCLB; i++)
        {
            ScrollableContentPanel NewTab = new ScrollableContentPanel();
            NewTab.setFocusable(false);
            
            JPanel InterfacePanel = new JPanel();
            InterfacePanel.setLayout(new java.awt.BorderLayout(0, 25));
            // HeaderInterfaceCLB
            InterfacePanel.add(ShowHeaderInterfaceCLB(NumberCLUB, NumberEvent, NumberOnline, NumberOffline), java.awt.BorderLayout.NORTH);
            // BodyInterfaceCLB
            InterfacePanel.add(ShowBodyInterfaceCLB((i - 1) * 5 + 0, Math.min(i * 5, ListCLB.size())), java.awt.BorderLayout.CENTER);
            // FooterInterfaceCLB
            InterfacePanel.add(ShowFooterInterfaceCLB(i), java.awt.BorderLayout.SOUTH);

            // chỉnh margin phải và trái của Interface
            JPanel RightMargin = new JPanel();
            RightMargin.setBackground(this.getBackground());
                //RightMargin.setBackground(Color.BLACK);
                RightMargin.setPreferredSize(new java.awt.Dimension(120, 0));
                InterfacePanel.add(RightMargin, java.awt.BorderLayout.EAST);

            JPanel LeftMargin = new JPanel();
            LeftMargin.setBackground(InterfacePanel.getBackground());
                //LeftMargin.setBackground(Color.PINK);
                LeftMargin.setPreferredSize(new java.awt.Dimension(120, 0));
                InterfacePanel.add(LeftMargin, java.awt.BorderLayout.WEST);    
                
            NewTab.registerComponent(InterfacePanel, "Interface");
            NewTab.showComponentAndTrimHistory("Interface");   
            NewTab.ScrollToTop();
            Interface.registerComponent(NewTab, "Tab" + i);
        }
        
        // Show Interface
        Interface.showComponentAndTrimHistory("Tab1");
        CurrentPage = "Tab1";
        
        this.setLayout(new java.awt.BorderLayout(0, 0));
        this.add(Interface, java.awt.BorderLayout.CENTER);
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
  
    public void FilterListCLB(String Area, String NameBox, String StyleBox, String Status, String ConditionJoin)  
    {
        System.out.println("Area: " + Area + ", NameBox: " + NameBox + ", StyleBox: " + StyleBox + ", Status: " + Status + ", ConditionJoin: " + ConditionJoin);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
