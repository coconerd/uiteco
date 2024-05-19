package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;

public class DetailedOnePost_Controller {

    //private final DetailedOnePost_Model model;
    public DetailedOnePost_Controller(DetailedOnePost_View view, BriefPost_Model baseModel) {
        this.view = view;
        this.baseModel = baseModel;
    }
    private final DetailedOnePost_View view;
    private final BriefPost_Model baseModel;

    public DetailedOnePost_View setData(BriefPost_Model model) {
        view.jTitle.setText(baseModel.getTitle());
        view.jRegisterTime.setText(baseModel.getDateRange());
        view.jOrganizer.setText(baseModel.getOrganizer());
        view.jPostTime.setText(baseModel.getPostTime_String());
        view.jContent.setText(baseModel.getContent());

        view.addPropertyChangeListener((evt) -> {

            if (evt.getPropertyName().equals("like Count")) {
                int newLikeCount = (int) evt.getNewValue();
                view.jLike.setText(String.valueOf(newLikeCount));
            }
        });

        return view;
    }

}
