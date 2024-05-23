/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel.detailed;

import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.main.App;
import com.uiteco.main.MainFrame;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienModel;
import com.uiteco.rightPanels.SuKienRightPanel;
import com.uiteco.swing.ContentPanel;
import java.awt.Component;
import static com.uiteco.ofSuKienPanel.SuKienDAO.getMissingDetail;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author nddmi
 */
public class SuKienDetailScrollPane extends ScrollPaneWin11 {

    public static final String INSTANCE_NAME = "suKienDetailScrollPane";
    private SuKienDetail suKienDetail;

    /**
     * Constructor
     */
    public SuKienDetailScrollPane() {
        setBorder(null);
        setViewportBorder(null);
        setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public SuKienDetail getSuKienDetail() {
        return this.suKienDetail;
    }

    public void load(SuKienModel suKienModel) throws NullSuKienModelException, IOException, SQLException {
        if (suKienModel == null) {
            throw new NullSuKienModelException();
        }
        
        if (suKienModel.getImages() == null) {
            getMissingDetail(suKienModel);
        }
        
        SuKienDAO.increaseViews(suKienModel);

        suKienDetail = new SuKienDetail(suKienModel);
        
        getViewport().removeAll();
        setViewportView(suKienDetail);
    }

    public void display() {

        // Display
        MainFrame mainFrame = App.getMainFrame();
        ContentPanel appContentPanel = (ContentPanel) mainFrame.getContentPanel();

        appContentPanel.showComponentAndTrimHistory(INSTANCE_NAME);

        // Show rightPanel to fix blank right panel bug
        ContentPanel appRightPanel = (ContentPanel) mainFrame.getRightPanel();
        appRightPanel.showComponentAndTrimHistory("suKienRightPanel");

        // Add to HistoryPanel
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContentPanel appRightPanel = mainFrame.getRightPanel();

                Component comp = appRightPanel.getCurrentComponent();
                if (comp instanceof SuKienRightPanel) {
                    SuKienRightPanel suKienRightPanel = (SuKienRightPanel) appRightPanel.getCurrentComponent();
                    suKienRightPanel.getHistoryPanel().addHistory(suKienDetail.getSuKienModel());
//                    System.out.println("DEBUG: a new line has been added to history panel");
                }

                getVerticalScrollBar().setValue(0);
            }
        });
    }

    /**
     *
     * @param suKienModel
     * @throws NullSuKienModelException
     */
    public void loadAndDisplay(SuKienModel suKienModel) throws NullSuKienModelException, IOException, SQLException {
        load(suKienModel);
        display();
    }
}
