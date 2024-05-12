package com.uiteco.components.comboBox;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import com.raven.scroll.ScrollBarWin11UI;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ScrollBarWin11UI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(242, 243, 244));
    }
}
