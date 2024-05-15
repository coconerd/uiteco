/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofSuKienPanel.detailed;

import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.main.App;
import com.uiteco.main.MainFrame;
import com.uiteco.ofSuKienPanel.SuKienModel;
import com.uiteco.rightPanels.SuKienRightPanel;
import com.uiteco.swing.ContentPanel;
import java.awt.Component;
import javax.swing.SwingUtilities;

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

    /**
     *
     * @param suKienModel
     * @throws NullSuKienModelException
     */
    public void loadDetailOfSuKien(SuKienModel suKienModel) throws NullSuKienModelException {
        if (suKienModel == null) {
            throw new NullSuKienModelException();
        }

        suKienDetail = new SuKienDetail(suKienModel);
        setViewportView(suKienDetail);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContentPanel appRightPanel = App.getMainFrame().getRightPanel();

                Component comp = appRightPanel.getCurrentComponent();
                if (comp instanceof SuKienRightPanel) {
                    SuKienRightPanel suKienRightPanel = (SuKienRightPanel) appRightPanel.getCurrentComponent();
                    suKienRightPanel.getHistoryPanel().addHistory(suKienModel);
                    System.out.println("DEBUG: a new line has been added to history panel");
                }

                getVerticalScrollBar().setValue(0);
            }
        });
    }
}
