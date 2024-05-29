package com.uiteco.OfCuocThiPanel.secondPage.pieChart;

import com.uiteco.rightPanels.CuocThiRightPanel_SecondPage;
import java.util.List;

public class PieChartPanel extends CuocThiRightPanel_SecondPage {

    /**
     * @return the pieChart1
     */
    public com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart getPieChart1() {
        return pieChart1;
    }

    /**
     * @return the pieChart2
     */
    public com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart getPieChart2() {
        return pieChart2;
    }

    public PieChartPanel() {
        initComponents();
    }
    
    public void updateLegend1(List<ModelPieChart> pieCharts) {
        legendPanel1.updateData(pieCharts);
        System.out.println("legend1");
    }

    public void updateLegend2(List<ModelPieChart> pieCharts) {
        legendPanel2.updateData(pieCharts);
        System.out.println("legend2");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pieChart1 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart();
        pieChart2 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        legendPanel1 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.LegendPanel();
        legendPanel2 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.LegendPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1700, 1077));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(40);
        roundedPanel1.setRoundBottomRight(40);
        roundedPanel1.setRoundTopLeft(40);
        roundedPanel1.setRoundTopRight(40);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-chart-94.png"))); // NOI18N
        roundedPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Merriweather", 1, 38)); // NOI18N
        jLabel2.setText("Thống kê");
        roundedPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 80, -1, -1));

        pieChart1.setBackground(new java.awt.Color(51, 0, 204));
        pieChart1.setChartType(com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart.PeiChartType.DONUT_CHART);
        pieChart1.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        pieChart1.setPreferredSize(new java.awt.Dimension(450, 450));
        roundedPanel1.add(pieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 470, 450));

        pieChart2.setBackground(new java.awt.Color(153, 204, 0));
        pieChart2.setChartType(com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart.PeiChartType.DONUT_CHART);
        pieChart2.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        pieChart2.setPreferredSize(new java.awt.Dimension(450, 450));
        roundedPanel1.add(pieChart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 230, 480, 440));

        jLabel3.setFont(new java.awt.Font("Merriweather", 2, 24)); // NOI18N
        jLabel3.setText("Theo niên khóa");
        roundedPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 690, -1, -1));

        jLabel4.setFont(new java.awt.Font("Merriweather", 2, 24)); // NOI18N
        jLabel4.setText("Theo khoa");
        roundedPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 690, -1, -1));

        legendPanel1.setBackground(new java.awt.Color(255, 255, 0));
        legendPanel1.setOpaque(false);
        legendPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout legendPanel1Layout = new javax.swing.GroupLayout(legendPanel1);
        legendPanel1.setLayout(legendPanel1Layout);
        legendPanel1Layout.setHorizontalGroup(
            legendPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        legendPanel1Layout.setVerticalGroup(
            legendPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        roundedPanel1.add(legendPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 240, 250, 300));

        legendPanel2.setBackground(new java.awt.Color(204, 204, 0));
        legendPanel2.setOpaque(false);
        legendPanel2.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout legendPanel2Layout = new javax.swing.GroupLayout(legendPanel2);
        legendPanel2.setLayout(legendPanel2Layout);
        legendPanel2Layout.setHorizontalGroup(
            legendPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        legendPanel2Layout.setVerticalGroup(
            legendPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        roundedPanel1.add(legendPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 230, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.LegendPanel legendPanel1;
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.LegendPanel legendPanel2;
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart pieChart1;
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart pieChart2;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
