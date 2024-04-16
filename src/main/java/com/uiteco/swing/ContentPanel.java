package com.uiteco.swing;

/**
 *
 * @author nddmi
 */
public class ContentPanel extends DynamicPanel {

    public ContentPanel() {
        super();
        _init();
    }

    public ContentPanel(int innerPaddingSize) {
        super(innerPaddingSize);
        _init();
    }

    private void _init() {
        this.setLayout(new java.awt.GridLayout(1, 1));
        this.add(pageHolder);

    }
}
