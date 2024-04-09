package com.uiteco.swing;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author nddmi
 */
public class ScrollableContentPanel extends DynamicPanel {
    private final JScrollPane scrollPane;
    
    public ScrollableContentPanel() {
        super();
        this.setLayout(new java.awt.BorderLayout());
        this.scrollPane = new JScrollPane();
        this.scrollPane.setViewportView(this.pageHolder);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
