/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.components.comboBox;

import com.uiteco.components.comboBox.ComboBoxMultiSelection;

public class ComboBoxMultiSelectionLimitted extends ComboBoxMultiSelection {

    public static final int DEFAULT_MAX_OPTIONS = 3;

    private int options;

    public ComboBoxMultiSelectionLimitted(Integer options) {
        setOptions((options == null || options <= 0) ? DEFAULT_MAX_OPTIONS : options);
        _init();
    }

    public ComboBoxMultiSelectionLimitted() {
        setOptions(DEFAULT_MAX_OPTIONS);
        _init();
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

    @Override
    public void addItemObject(Object obj) {
        if (getSelectedItems().size() >= options) {
            System.out.println("Khong the chon them");
        } else {
            selectedItems.add(obj);
            comboBoxMultiCellEditor.addItem(obj);
            if (comboList != null) {
                comboList.repaint();
            }
        }
//
//        selectedItems.add(obj);
//        comboBoxMultiCellEditor.addItem(obj);
//        if (comboList != null) {
//            comboList.repaint();
//        }

    }

//    @Override
//    public void removeItemObject(Object obj) {
//        super.removeItemObject(obj);
//    }
    private void _init() {

    }
}
