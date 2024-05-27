package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.OfCuocThiPanel.secondPage.GlassPanePopup.GlassPanePopup;
import java.awt.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Controller {

    public DetailedOnePost_Controller(DetailedOnePost_View view, BriefPost_Model baseModel) {
        this.view = view;
        this.baseModel = baseModel;
        this.isLiked = false;
        currentLikes = baseModel.countLike;
        view.jLike.addActionListener(e -> jLikeActionPerformed());
        view.jRegister.addActionListener(e -> jRegisterActionPerformed());

    }

    private final DetailedOnePost_View view;
    private final BriefPost_Model baseModel;
    private boolean isLiked;
    private int currentLikes;

    public int getPostID() {
        return baseModel.getId();
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
            r.getRoundedImagePanel().setImage(i);
            listImage.add(r);
        }
        System.out.println(listImage.size());

        for (Component c : listImage) {

            view.scrollPaneImages.getRoundedGradientPanel().add(c);
        }

        return view;
    }

    private void jLikeActionPerformed() {
        // TODO add your handling code here:
        //first press + 1, second press - 1 
        isLiked = !isLiked;

        int newCountLike = currentLikes + (isLiked ? 1 : -1);

        newCountLike = Math.max(newCountLike, 0);
        baseModel.setCountLike(newCountLike);

        view.jLike.setText(String.valueOf(newCountLike));
        CuocThiDAO.updateCountLikeDB(baseModel.getId(), newCountLike);

        currentLikes = newCountLike;
    }

    private static void showConfirmationDialog() {

    }

    private void jRegisterActionPerformed() {
        // Add your logic for the "Register" button here
        // For example, you could call a method in the DetailedOnePost_Model to handle the registration
        ConfirmPopUp popUp = new ConfirmPopUp();
        GlassPanePopup.showPopup(popUp);

        popUp.getjOk().addActionListener((e) -> {
            CuocThiDAO.insertUserRegisterCompetition(baseModel.getId(), LocalDateTime.now());
            GlassPanePopup.closePopupAll();

            //when press Register, display unregister button 
            view.jRegister.setVisible(false);
        });

        popUp.getjNo().addActionListener((e) -> {
            popUp.removeAll();
            GlassPanePopup.closePopupAll();
        });

    }
}
