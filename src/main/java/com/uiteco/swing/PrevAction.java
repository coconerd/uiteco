/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.swing;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author nddmi
 */
public class PrevAction extends AbstractAction {
    private DynamicPanel man;
    
    PrevAction(DynamicPanel _man, String name, Integer keyCode) {
        super(name);
        this.man = _man;
        putValue(MNEMONIC_KEY, keyCode);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.man.previousPage();
    }
    
}
