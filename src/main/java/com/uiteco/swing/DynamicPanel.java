package com.uiteco.swing;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.util.Vector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.util.HashMap;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author nddmi
 */
public abstract class DynamicPanel extends JPanel {

    protected CardLayout cardLayout;
    protected JPanel pageHolder;
    protected Vector<String> pageHistory;
    protected int historyIndex;
    protected HashMap<String, Component> nameToComp;
    protected int innerPaddingSize;

    public DynamicPanel() {
        _init();
        this.innerPaddingSize = 0;
    }

    public DynamicPanel(int innerPaddingSize) {
        _init();
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

    public CardLayout getCardLayout() {
        return this.cardLayout;
    }

    public JPanel getPageHolder() {
        return this.pageHolder;
    }

    public Vector<String> getPageHistory() {
        return this.pageHistory;
    }

    public String getPageHistoryAt(int index) {
        return this.pageHistory.get(index);
    }

    public int getHistoryIndex() {
        return this.historyIndex;
    }

    public Component getComponent(String name) {
        return this.nameToComp.get(name);
    }

    public int getInnerPaddingSize() {
        return this.innerPaddingSize;
    }

    public void setPageHistory(int index, String name) {
        this.pageHistory.set(index, name);
    }

    public void setHistoryIndex(int index) {
        // (property_name, old_value, new_value)
        this.firePropertyChange("historyIndex", getHistoryIndex(), index);
        this.historyIndex = index;
    }

    public void setComponent(String name, Component comp) {
        this.nameToComp.put(name, comp);
    }

    /**
     *
     * @return the current component that is being shown by pageHolder
     */
    public Component getCurrentComponent() {
        String name = getPageHistoryAt(getHistoryIndex());
        return getComponent(name);
    }

    public void addPageHistory(String name) {
        pageHistory.add(name);
    }

    public void removePageHistory(int index) {
        pageHistory.remove(index);
    }

    public void trimPageHistory(int index) {
        // Clear page history after current spot
        int i = this.pageHistory.size() - 1;
        while (i >= getHistoryIndex() + 1) {
            removePageHistory(i);
            i--;
        }
    }

    public void previousComponent() {
        if (getHistoryIndex() > 0) {
            String name = getPageHistoryAt(getHistoryIndex() - 1);
            _showComponent(name);
            setHistoryIndex(getHistoryIndex() - 1);
        }
    }

    public void nextComponent() {
        if (getHistoryIndex() < (pageHistory.size() - 1)) {
            String name = getPageHistoryAt(getHistoryIndex() + 1);
            _showComponent(name);
            setHistoryIndex(getHistoryIndex() + 1);
        }
    }

    public void showComponentAndTrimHistory(String name) {
        // Abort if page hasn't been registered/doesn't exist
        if (nameToComp.get(name) == null) {
            System.err.printf("Error: component with name %s doesn't exist", name);
            return;
        }

        trimPageHistory(getHistoryIndex());
        _showComponent(name);
        addPageHistory(name);
        setHistoryIndex(getHistoryIndex() + 1);
    }

    public void registerComponent(JComponent comp, String name) {
        pageHolder.add(name, comp);
        if (this.pageHistory.size() == 0) {
            addPageHistory(name);
            setHistoryIndex(0);
        }

        if (getComponent(name) == null) {
            setComponent(name, comp);
        } else {
            System.err.printf("Error: component with name %s already exist", name);
        }
    }
    
    public void clear() {
        pageHistory.clear();
        pageHolder.removeAll();
        nameToComp.clear();
        historyIndex = 0;
    }

    public abstract void _propertyChangeHandler(PropertyChangeEvent evt);

    private void _init() {
        this.cardLayout = new CardLayout();
        this.pageHolder = new JPanel(cardLayout);
        this.pageHistory = new Vector<String>();
        /**
         * historyIndex will be initialized when the first page is added to card
         * layout
         */
//        this.historyIndex = 0; 
        this.setBorder(null);
        this.nameToComp = new HashMap<String, Component>();

        // Add a property change listener
        this.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                _propertyChangeHandler(evt);
            }
        });
    }

    private void _showComponent(String name) {
        this.cardLayout.show(this.pageHolder, name);
    }
}
