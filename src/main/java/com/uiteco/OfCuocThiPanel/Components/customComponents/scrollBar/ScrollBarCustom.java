package com.uiteco.OfCuocThiPanel.Components.customComponents.scrollBar;

import com.uiteco.OfCuocThiPanel.Components.customComponents.scrollBar.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(242, 243, 244));
    }
}
