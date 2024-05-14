/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.tagsAndSort;

/**
 *
 * @author nddmi
 */
public class NullSuKienViewException extends Exception {
    public NullSuKienViewException() {
        super("Tags and Sort feature won't work when SuKienListView is null");
    }
}
