package com.uiteco.OfCuocThiPanel.firstPage;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import java.awt.Color;
import java.util.List;

public class BriefPost_Controller {

    private BriefPost_Model model;
    private BriefPost_View view;

    public BriefPost_Controller(BriefPost_Model post, BriefPost_View postUI) {
        this.model = post;
        this.view = postUI;
    }

    public BriefPost_View setData() {

        view.getjTitle().setText(model.getTitle());
        view.jImage.setImage(model.getImage());
        view.jDateRange.setText(model.getDateRange());
        view.jOrganizer.setText(model.getOrganizer());
        view.jType.setText(model.convertType());
        view.jCountLike.setText(model.getCountLike_String());
        //view.jDueDate.setText(model.getDate_String(model.dueDate));
        
        String customStatus = model.getCustomStatus();
        setDaysLeft(customStatus);

        List<String> tags = model.getTags();
        setTagsUI(tags);

        model._addPropertyChangeListener(evt -> {
            if (evt.getPropertyName().equals("countLike")) {
                CuocThiDAO.getPostsInfo_Default();
                view.jCountLike.setText(model.getCountLike_String()); // Update UI
                view.repaint();
            }
        });

        return view;
    }

    public void setDaysLeft(String status) {
        if (status != null) {
            if (status.startsWith("Còn ")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 158, 128));
                view.getLabelDaysLeft1().jLabel1.setText(status);

            } else if (status.equals("Đang diên ra")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 213, 127));
                view.getLabelDaysLeft1().jLabel1.setText(status);

            } else if (status.equals("Kết thúc")) {
                view.getLabelDaysLeft1().roundedPanel1.setBackground(new Color(255, 209, 220));
                view.getLabelDaysLeft1().jLabel1.setText(status);
            }

            view.getLabelDaysLeft1().revalidate();
            view.getLabelDaysLeft1().repaint();
        }
    }

    //display on panel the number of tags which a post has (based on database)
    public void setTagsUI(List<String> tags) {
        for (String tagText : tags) {
            LabelTag tagLabel = new LabelTag();
            tagLabel.jLabel_TagName.setText(tagText);
            view.getjPanelContainTags().add(tagLabel);
        }

        view.getjPanelContainTags().revalidate();
        view.getjPanelContainTags().repaint();
    }
}
