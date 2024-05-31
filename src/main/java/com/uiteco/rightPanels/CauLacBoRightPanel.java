package com.uiteco.rightPanels;

import com.uiteco.contentPanels.CauLacBoPanel;
import com.uiteco.rightPanels.CauLacBo.DetailPageRightPanel;
import com.uiteco.rightPanels.CauLacBo.MainRightPanel;
import java.time.LocalDate;

/**
 *
 * @author VStorm
 */
public class CauLacBoRightPanel extends javax.swing.JPanel {

    private CauLacBoPanel ClubPanel;

    private DetailPageRightPanel LastestDetailPage;
    private MainRightPanel MainPanel;
    private int MaCLB = -1;
    private int indexRightPanel = 0;

    public CauLacBoRightPanel() {
        initComponents();

        MainPanel = new MainRightPanel();
        RightPanel.registerComponent(MainPanel, "Main");
        RightPanel.showComponentAndTrimHistory("Main");
    }

    public CauLacBoRightPanel(CauLacBoPanel clubPanel) {
        this.ClubPanel = clubPanel;
        initComponents();
        MainPanel = new MainRightPanel(this.ClubPanel);
        RightPanel.registerComponent(MainPanel, "Main");
        RightPanel.showComponentAndTrimHistory("Main");
    }

    public void showMainPanel() {
        RightPanel.showComponentAndTrimHistory("Main");
    }

    public void showDetailPageRightPanel(int MaCLB, String NameCLB, String CreateBy, String HostBy, LocalDate DateCreate) {
        indexRightPanel++;

        if (LastestDetailPage != null) {
//            RightPanel.remove(LastestDetailPage);
            LastestDetailPage.removeAll();
            LastestDetailPage.repaint();
        }

        LastestDetailPage = new DetailPageRightPanel(MaCLB, NameCLB, CreateBy, HostBy, DateCreate);
        RightPanel.registerComponent(LastestDetailPage, "DetailPage" + indexRightPanel);
        RightPanel.showComponentAndTrimHistory("DetailPage" + indexRightPanel);
        System.out.println("Why is detail right panel not showing");
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RightPanel = new com.uiteco.swing.ContentPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setClubPanel(CauLacBoPanel ClubPanel) {
        this.ClubPanel = ClubPanel;
        MainPanel.setClubPanel(ClubPanel);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.swing.ContentPanel RightPanel;
    // End of variables declaration//GEN-END:variables
}
