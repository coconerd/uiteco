/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.firstPage;

import java.awt.Color;
import java.util.List;

public class BriefPost_Controller {

    private final BriefPost_Model model;
    private final BriefPost_View view;

    public BriefPost_Controller(BriefPost_Model model, BriefPost_View view) {
        this.model = model;
        this.view = view;
    }

    public BriefPost_View setData() {
        //view.postID = model.getId();

        view.getjTitle().setText(model.getTitle());
        view.jImage.setImage(model.getImage());
        view.jDateRange.setText(model.getDateRange());
        view.jOrganizer.setText(model.getOrganizer());
        view.jType.setText(model.convertType());

        //jCountLike.setText();
        String customStatus = model.getCustomStatus();
        setDaysLeft(customStatus);

        List<String> tags = model.getTags();
        setTagsUI(tags);

        view.repaint();
        
        return view;
    }
    
    public void setDaysLeft(String status) {
        if (status != null) {
            if (status.startsWith("Còn ")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 158, 128));
                view.getLabelDaysLeft1().jLabel1.setText(status);
                
            } else if (status.startsWith("Dang ")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 213, 127));
                view.getLabelDaysLeft1().jLabel1.setText(status);
                
            } else if (status.startsWith("Het ")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 209, 220));
                view.getLabelDaysLeft1().jLabel1.setText(status);
            }
            
            view.getLabelDaysLeft1().revalidate();
            view.getLabelDaysLeft1().repaint();
        }
    }
    
    public void setTagsUI(List<String> tags) {
        //display on panel the number of tags which a post has (based on database)
        for (String tagText : tags) {
            LabelTag tagLabel = new LabelTag();
            tagLabel.jLabel_TagName.setText(tagText);
            view.getjPanelContainTags().add(tagLabel);
        }
        
        view.getjPanelContainTags().revalidate();
        view.getjPanelContainTags().repaint();
    }
}
