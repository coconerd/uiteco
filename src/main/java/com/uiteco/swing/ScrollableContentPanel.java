package com.uiteco.swing;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import com.raven.scroll.ScrollPaneWin11;

/**
 *
 * @author nddmi
 */
public class ScrollableContentPanel extends DynamicPanel {
    private final ScrollPaneWin11 scrollPane;
    
    public ScrollableContentPanel() {
        super();
        this.setLayout(new java.awt.BorderLayout());
        this.scrollPane= new ScrollPaneWin11();
        this.scrollPane.setViewportView(this.pageHolder);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
