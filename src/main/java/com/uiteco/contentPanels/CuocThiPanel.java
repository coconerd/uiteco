package com.uiteco.contentPanels;

// Import the necessary package
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.firstPage.TagsAndSort;
import java.awt.Color;
import com.uiteco.OfCuocThiPanel.firstPage.firstPage;
import com.uiteco.OfCuocThiPanel.getDataFromDB.CuocThiData;
import com.uiteco.main.App;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class CuocThiPanel extends JPanel { //action handler

    private firstPage body = new firstPage();
    private List<BriefPost_Model> list = new ArrayList<>();
    private TagsAndSort header = new TagsAndSort();

    public TagsAndSort getHeader() {
        return header;
    }

    public CuocThiPanel() {
        _init();
        this.add(header);

        this.add(body);

        if (true) {
            //CuocThiPanel listens to the change of button date of header 
            header.getTeam()._addPropertyChangeListener((evt) -> {
                if (evt.getPropertyName().equals("selected")) {

                    list = CuocThiData.getPostsInfo_Sort(2, false, false);
                    body.updateContent(list);
                }
            });
            header.getSolo()._addPropertyChangeListener((evt) -> {
                if (evt.getPropertyName().equals("selected")) {

                    list = CuocThiData.getPostsInfo_Sort(1, false, false);
                    body.updateContent(list);
                }
            });
            header.getHotest()._addPropertyChangeListener((evt) -> {
                if (evt.getPropertyName().equals("selected")) {

                    list = CuocThiData.getPostsInfo_Sort(0, false, true);
                    body.updateContent(list);
                }
            });
            header.getDate()._addPropertyChangeListener((evt) -> {
                if (evt.getPropertyName().equals("selected")) {

                    list = CuocThiData.getPostsInfo_Sort(0, true, false);
                    body.updateContent(list);
                }
            });
        }

    }

//    public void sortButtons() {
//
//        Component component = App.getMainFrame().getContentPanel().getComponent("cuocThiPanel");
//
//        if (component instanceof CuocThiPanel competition) {
//            System.out.println("hi");
//            body = competition.body;
//
//        }
//
//    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(242, 243, 244));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void _init() {

        setBackground(new Color(242, 243, 244));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 665, Short.MAX_VALUE)
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
