package com.uiteco.swing;

/**
 *
 * @author nddmi
 */
public class ContentPanel extends DynamicPanel {
    public ContentPanel() {
        super();
        this.setLayout(new java.awt.GridLayout(1, 1));
        this.add(pageHolder);
    }
}
