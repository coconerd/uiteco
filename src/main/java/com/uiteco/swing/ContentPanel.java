package com.uiteco.swing;

import java.beans.PropertyChangeEvent;
import java.awt.GridLayout;

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

//    @Override
    public void _propertyChangeHandler(PropertyChangeEvent evt) {
    }

    private void _init() {
        this.setLayout(new GridLayout(1, 1, 0, 0));
        this.add(pageHolder);

    }
}
