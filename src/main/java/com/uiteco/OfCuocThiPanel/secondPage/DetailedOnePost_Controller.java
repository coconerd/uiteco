package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.main.App;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class DetailedOnePost_Controller {

    public BriefPost_Model getBaseModel() {
        return baseModel;
    }

    public DetailedOnePost_Controller(DetailedOnePost_View view, BriefPost_Model baseModel) {
        this.view = view;
        this.baseModel = baseModel;

    }

    private final DetailedOnePost_View view;
    private final BriefPost_Model baseModel;

    public int getPostID() {
        return getBaseModel().getId();
    }

    public DetailedOnePost_View setData(BriefPost_Model baseModel) {
        view.jTitle.setText(baseModel.getTitle());
        view.getjRegisterTime().setText(baseModel.getDateRange_ForDetailedPage());
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
            r.getjLabel1().setIcon(i);
            listImage.add(r);
        }

        for (Component c : listImage) {
            view.scrollPaneImages.getRoundedGradientPanel().add(c);

            view.scrollPaneImages.getRoundedGradientPanel().add(c);
            c.addMouseListener(new MouseListener() {

                @Override
                public void mousePressed(MouseEvent e) {
                    createDialog("Ảnh sự kiện", c);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });

        }

//        DetailedOnePost_Model dModel = CuocThiDAO.getAllImagesAndUrls(baseModel.getId());
//        view.youtubePlay.setUri_String(dModel.getUrlYT());
//        view.youtubePlay.setThumbnail(baseModel.getThumbnailYT());
        view.revalidate();
        view.repaint();
        return view;
    }

    public static void createDialog(String dialogName, Component child) {
        JDialog dialog = new JDialog(App.getMainFrame(), dialogName, false);
        dialog.setLayout(new GridLayout(1, 1, 0, 0));
        dialog.setSize(child.getPreferredSize());
        dialog.add(child);
        dialog.setVisible(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = dialog.getSize();
        dialog.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
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
