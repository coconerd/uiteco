package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Controller {

    /**
     * @return the baseModel
     */
    public BriefPost_Model getBaseModel() {
        return baseModel;
    }

    public DetailedOnePost_Controller(DetailedOnePost_View view, BriefPost_Model baseModel) {
        this.view = view;
        this.baseModel = baseModel;
        this.isLiked = false;
        currentLikes = baseModel.countLike;

    }

    private final DetailedOnePost_View view;
    private final BriefPost_Model baseModel;
    private boolean isLiked;
    private int currentLikes;

    public int getPostID() {
        return getBaseModel().getId();
    }

    public DetailedOnePost_View setData(BriefPost_Model baseModel) {
        view.jTitle.setText(baseModel.getTitle());
        view.jRegisterTime.setText(baseModel.getDateRange_ForDetailedPage());
        view.jOrganizer.setText(baseModel.getOrganizer());
        view.jPostTime.setText(baseModel.getPostTime_String());
        view.jContent.setText(baseModel.getContent());
        view.jLike.setText(baseModel.getCountLike_String());
        if (baseModel.getType() == 2) {
            view.jRegister.setVisible(false);
        } else if (baseModel.getType() == 1) {
            view.jRegister.setVisible(true);
        }

        List<ImageIcon> imageList = CuocThiDAO.getAllImagesAndUrls(baseModel.getId()).images;
        List<RoundImageUI> listImage = new ArrayList<>();
        for (ImageIcon i : imageList) {
            RoundImageUI r = new RoundImageUI();
            r.getjLabel().setIcon(i);
            listImage.add(r);
        }

        for (Component c : listImage) {
            view.scrollPaneImages.getRoundedGradientPanel().add(c);
        }
        
        view.revalidate();
        view.repaint();
        return view;
    }


    private static void showConfirmationDialog() {

    }

//    private void jRegisterActionPerformed() {
//        // Add your logic for the "Register" button here
//        // For example, you could call a method in the DetailedOnePost_Model to handle the registration
//        ConfirmPopUp popUp = new ConfirmPopUp();
//        GlassPanePopup.showPopup(popUp);
//
//        popUp.getjOk().addActionListener((e) -> {
//            CuocThiDAO.insertUserRegisterCompetition(baseModel.getId());
//            GlassPanePopup.closePopupAll();
//
//            //when press Register, display unregister button 
//            view.jRegister.setVisible(false);
//        });
//
//        popUp.getjNo().addActionListener((e) -> {
//            popUp.removeAll();
//            GlassPanePopup.closePopupAll();
//        });
//
//    }
}
