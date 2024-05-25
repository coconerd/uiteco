/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel;

import com.raven.scroll.ScrollPaneWin11;
import com.uiteco.components.RoundedGradientPanel;
import static com.uiteco.ofTaiKhoanPanel.ofClbPanel.Clb.MiniClbModel;
import com.uiteco.ofTaiKhoanPanel.ofClbPanel.Clb;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author nddmi
 */
public class ClbPanel extends RoundedGradientPanel {

    public static final String INSTANCE_NAME = "ClbPanel";

    private TaiKhoanModel user;

    /**
     * Creates new form CLBPanel
     */
    public ClbPanel() {
        super(false, true, new Color(210, 217, 231), new Color(157, 162, 195), RoundedGradientPanel.HORIZONTAL);
        setRoundTopLeft(30);
        setRoundTopRight(30);
        setRoundBottomLeft(30);
        setRoundBottomRight(30);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new MigLayout("fillx", "[grow]", "[]15[]"));
    }

    public void load(TaiKhoanModel user) {
        this.user = user;
        _populateViewport();
    }

    private void _populateViewport() {
        removeAll();

        try {
            ArrayList<MiniClbModel> clbList = TaiKhoanDAO.getUserClubs(user);
            // Read
//            for (MiniClbModel miniModel : clbList) {
//                // Clb ui component
//                Clb clbComp = new Clb(miniModel);
//                viewport.add(clbComp, "growx, wrap, height ::" + clbComp.getPreferredSize().height);
//            }

            // Mock
            for (int i = 0; i < 5; i++) {
                // Clb ui component
                MiniClbModel miniModel = clbList.get(0);
                Clb clbComp = new Clb(miniModel);
                add(clbComp, "growx, wrap, height ::" + clbComp.getPreferredSize().height);
            }

            revalidate();
            repaint();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

    // Variables declaration - do not modify            
    // End of variables declaration                   
}
