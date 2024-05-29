package com.raven.scroll;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Phan Thi Thuy Hien
 */
public class ScrollPaneUtil {

    public static void configureScrollBar(JScrollPane scroll) {
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
        );

        scroll.putClientProperty(FlatClientProperties.SCROLL_BAR_SHOW_BUTTONS, true);
        UIManager.put("ScrollBar.thumb", new ColorUIResource(100, 150, 200)); // Change thumb color
        UIManager.put("ScrollBar.track", new ColorUIResource(230, 230, 230)); // Change track color

        FlatMacLightLaf.setup();
    }
}
