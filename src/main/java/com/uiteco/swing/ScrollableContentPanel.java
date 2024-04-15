package com.uiteco.swing;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import com.raven.scroll.ScrollPaneWin11;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author nddmi
 */
public class ScrollableContentPanel extends DynamicPanel {

    private final ScrollPaneWin11 scrollPane;

    public ScrollableContentPanel() {
        super();
        this.setLayout(new java.awt.BorderLayout());
        this.scrollPane = new ScrollPaneWin11();
        this.scrollPane.setViewportView(this.pageHolder);
        this.scrollPane.setBorder(null);
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(scrollPane);

        scrollPane.getViewport().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // This function will be invoked after all child components are loaded
                for (Component comp : pageHolder.getComponents()) {
                    if (!(comp instanceof JPanel)) {
                        continue;
                    }
                    
                    for (Component subcomp : ((JPanel)comp).getComponents()) {
                        if (!(subcomp instanceof JPanel))
                            continue;
                        
                        ((JPanel)subcomp).setBorder(new EmptyBorder(0, 0, 0, 20)); // Add right border
                    }
                }
            }
        });

    }

}
