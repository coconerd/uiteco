package com.uiteco.swing;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.util.Vector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author nddmi
 */
public class DynamicPanel extends JPanel {

    protected final CardLayout cardLayout;
    protected final JPanel pageHolder;
    protected final Vector<String> pageHistory;
    protected int historyIndex;
    protected int innerPaddingSize;

    public DynamicPanel() {
        this.cardLayout = new CardLayout();
        this.pageHolder = new JPanel(cardLayout);
        this.pageHistory = new Vector<String>();
        this.historyIndex = 0;
        this.innerPaddingSize = 0;
        this.setBorder(null);
    }

    public DynamicPanel(int innerPaddingSize) {
        this();
        this.innerPaddingSize = innerPaddingSize;

        // Add inner padding for DynamicPanel
        this.addComponentListener(new ComponentAdapter() {
            // This function will be invoked after all child components are loaded
            @Override
            public void componentResized(ComponentEvent e) {
                for (Component comp : pageHolder.getComponents()) {
                    if (!(comp instanceof JPanel)) {
                        continue;
                    }

                    for (Component subcomp : ((JPanel) comp).getComponents()) {
                        if (!(subcomp instanceof JPanel)) {
                            continue;
                        }

                        ((JPanel) subcomp).setBorder(new EmptyBorder(innerPaddingSize, innerPaddingSize, innerPaddingSize, innerPaddingSize));
                    }
                }
            }
        });
    }

    public int getInnerPaddingSize() {
        return this.innerPaddingSize;
    }

    public void previousComponent() {
        if (historyIndex > 0) {
            String name = this.pageHistory.get(historyIndex - 1);
            this._showComponent(name);
            this.historyIndex--;
        }
    }

    public void nextComponent() {
        if (historyIndex < pageHistory.size() - 1) {
            String name = this.pageHistory.get(historyIndex + 1);
            this._showComponent(name);
            this.historyIndex++;
        }
    }

    public void showComponent(String name) {
        // Clear page history after current spot
        int i = this.pageHistory.size() - 1;
        while (i >= this.historyIndex + 1) {
            this.pageHistory.remove(i);
            i--;
        }
        this._showComponent(name);
        this.pageHistory.add(name);
        this.historyIndex++;
    }

    public void registerComponent(JComponent comp, String name) {
        pageHolder.add(name, comp);
        if (this.pageHistory.size() == 0) {
            this.pageHistory.add(name);
        }
    }

    private void _showComponent(String name) {
        this.cardLayout.show(this.pageHolder, name);
    }
}
