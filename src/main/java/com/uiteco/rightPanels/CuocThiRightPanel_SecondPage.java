package com.uiteco.rightPanels;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.secondPage.GlassPanePopup.GlassPanePopup;
import com.uiteco.OfCuocThiPanel.secondPage.RegisterTableInfo;
import com.uiteco.OfCuocThiPanel.secondPage.floatingButton.EventFloatingActionButton;
import com.uiteco.OfCuocThiPanel.secondPage.pieChart.ModelPieChart;
import com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChartPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CuocThiRightPanel_SecondPage extends JPanel {

    /**
     * @param postID the postID to set
     */
    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getPostID() {
        return postID;
    }

    public CuocThiRightPanel_SecondPage(int postID) {
        this.postID = postID;
        initComponents();
        actionPressButton();
    }

    public CuocThiRightPanel_SecondPage() {
        initComponents();
        actionPressButton();
    }

    public void actionPressButton() {
        ImageIcon listIcon = new ImageIcon(getClass().getResource("/note.png"));
        ImageIcon researchIcon = new ImageIcon(getClass().getResource("/pie-chart.png"));

        floatingActionButton.addItem(listIcon, Color.white);
        floatingActionButton.addItem(researchIcon, Color.white);

        floatingActionButton.addEvent(new EventFloatingActionButton() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    RegisterTableInfo table = new RegisterTableInfo();
                    CuocThiDAO.getRegisterInfo_TableView(table.getTable(), getPostID());
                    showForm(table);

                } else if (index == 1) {
                    PieChartPanel chartPanel = new PieChartPanel();

                    List<ModelPieChart> models1 = CuocThiDAO.getDataForPieChart_CourseYear(getPostID());

                    if (models1 == null || models1.isEmpty()) {
                        chartPanel.removeAll();
                        
                        JLabel placeholder = new JLabel("No posts available");
                        Font placeholderFont = new Font("Merriweather", Font.PLAIN, 24);
                        placeholder.setFont(placeholderFont);

                        placeholder.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 118));

                        placeholder.setHorizontalAlignment( SwingConstants.CENTER);
                        placeholder.setPreferredSize(new java.awt.Dimension(1160, 805)); // Adjust dimensions as needed

                        chartPanel.add(placeholder);
                        
                        chartPanel.revalidate();
                        chartPanel.repaint();
                    }
                    
                    for (ModelPieChart m : models1) {
                        chartPanel.getPieChart1().addData(m);
                        System.out.println("chart1");
                    }

                    chartPanel.updateLegend1(models1);
                    
                    
                    List<ModelPieChart> models2 = CuocThiDAO.getDataForPieChart_FacultyName(getPostID());
                    for (ModelPieChart m : models2) {
                        chartPanel.getPieChart2().addData(m);
                        System.out.println("chart2");
                    }

                    chartPanel.updateLegend2(models2);

                    chartPanel.revalidate();
                    chartPanel.repaint();
                    showForm(chartPanel);
                }
            }
        });

        floatingActionPanel.addFloatingActionButton(floatingActionButton);

    }

    private void showForm(Component com) {
        GlassPanePopup.showPopup(com);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        floatingActionPanel = new com.uiteco.OfCuocThiPanel.secondPage.floatingButton.FloatingActionPanel();
        floatingActionButton = new com.uiteco.OfCuocThiPanel.secondPage.floatingButton.FloatingActionButton();

        setBackground(new java.awt.Color(242, 243, 244));
        setOpaque(false);

        floatingActionButton.setPreferredSize(new java.awt.Dimension(30, 20));

        floatingActionPanel.setLayer(floatingActionButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout floatingActionPanelLayout = new javax.swing.GroupLayout(floatingActionPanel);
        floatingActionPanel.setLayout(floatingActionPanelLayout);
        floatingActionPanelLayout.setHorizontalGroup(
            floatingActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floatingActionPanelLayout.createSequentialGroup()
                .addComponent(floatingActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        floatingActionPanelLayout.setVerticalGroup(
            floatingActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(floatingActionPanelLayout.createSequentialGroup()
                .addComponent(floatingActionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(floatingActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(floatingActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private int postID;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.OfCuocThiPanel.secondPage.floatingButton.FloatingActionButton floatingActionButton;
    private com.uiteco.OfCuocThiPanel.secondPage.floatingButton.FloatingActionPanel floatingActionPanel;
    // End of variables declaration//GEN-END:variables
}
