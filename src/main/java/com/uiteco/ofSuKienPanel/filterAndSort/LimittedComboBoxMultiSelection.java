/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.filterAndSort;

import com.uiteco.components.comboBox.ComboBoxMultiSelection;

public class LimittedComboBoxMultiSelection extends ComboBoxMultiSelection {    
    public static final int DEFAULT_MAX_OPTIONS = 3;
    
    private int options;
    
    public LimittedComboBoxMultiSelection(Integer options) {
        setOptions((options == null || options <= 0) ? DEFAULT_MAX_OPTIONS : options);
        _init();
    }
    
    public LimittedComboBoxMultiSelection() {
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
        
    }
    
//    @Override
//    public void removeItemObject(Object obj) {
//        super.removeItemObject(obj);
//    }
    
    private void _init() {
        
    }
}
