package com.uiteco.OfCuocThiPanel.secondPage.scrollBar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(20, 20));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
