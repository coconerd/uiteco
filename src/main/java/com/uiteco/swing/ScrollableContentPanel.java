package com.uiteco.swing;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import com.raven.scroll.ScrollPaneWin11;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import javax.swing.JViewport;

/**
 *
 * @author nddmi
 */
public class ScrollableContentPanel extends DynamicPanel {

    private ScrollPaneWin11 scrollPane;

    public ScrollableContentPanel() {
        super();
        _init();
    }

    public ScrollableContentPanel(int innerPaddingSize) {
        super(innerPaddingSize);
        _init();
    }

    
    @Override
    public void _propertyChangeHandler(PropertyChangeEvent evt) {
  
    }

    public void ScrollToTop()
    {
        scrollPane.scrollToTop();
    }
    
    private void _init() {
        this.setLayout(new java.awt.BorderLayout());
        this.scrollPane = new ScrollPaneWin11();
        this.scrollPane.setViewportView(this.pageHolder);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
    }
}
