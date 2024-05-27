package com.uiteco.OfCuocThiPanel.secondPage.pieChart;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pieChart1 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart();
        pieChart2 = new com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1700, 1077));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setRoundBottomLeft(40);
        roundedPanel1.setRoundBottomRight(40);
        roundedPanel1.setRoundTopLeft(40);
        roundedPanel1.setRoundTopRight(40);
        roundedPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CuocThiPanel_resources/icons8-chart-94.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(60, 180, 0, 31);
        roundedPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Merriweather", 1, 38)); // NOI18N
        jLabel2.setText("Thống kê");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(80, 0, 0, 270);
        roundedPanel1.add(jLabel2, gridBagConstraints);

        pieChart1.setBackground(new java.awt.Color(51, 0, 204));
        pieChart1.setChartType(com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart.PeiChartType.DONUT_CHART);
        pieChart1.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        pieChart1.setPreferredSize(new java.awt.Dimension(450, 450));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(40, 60, 370, 45);
        roundedPanel1.add(pieChart1, gridBagConstraints);

        pieChart2.setBackground(new java.awt.Color(153, 204, 0));
        pieChart2.setChartType(com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart.PeiChartType.DONUT_CHART);
        pieChart2.setFont(new java.awt.Font("Merriweather", 0, 16)); // NOI18N
        pieChart2.setPreferredSize(new java.awt.Dimension(450, 450));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(39, 50, 380, 60);
        roundedPanel1.add(pieChart2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Merriweather", 2, 22)); // NOI18N
        jLabel3.setText("Theo niên khóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 320, 0);
        roundedPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Merriweather", 2, 22)); // NOI18N
        jLabel4.setText("Theo khoa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 320, 0);
        roundedPanel1.add(jLabel4, gridBagConstraints);

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
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart pieChart1;
    private com.uiteco.OfCuocThiPanel.secondPage.pieChart.PieChart pieChart2;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
