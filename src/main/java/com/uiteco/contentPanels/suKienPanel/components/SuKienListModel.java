/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author nddmi
 */
public class SuKienListModel {

    private ArrayList<SuKienModel> suKienList;
    private PropertyChangeSupport propertyChangeSupport;

    public SuKienListModel() {
        this.suKienList = SuKienDAO.getAllSuKienFromDb();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public SuKienListModel(ArrayList<SuKienModel> suKienList) {
        this.suKienList = suKienList;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void addSuKien(SuKienModel s) {
        this.suKienList.add(s);
        this.propertyChangeSupport.firePropertyChange("suKienListAdded", null, null);
    }

    public void removeSuKien(SuKienModel s) {
        this.suKienList.remove(s);
        this.propertyChangeSupport.firePropertyChange("suKienListRemoved", null, null);
    }

    public ArrayList<SuKienModel> getSuKienList() {
        return this.suKienList;
    }
    
    public SuKienModel getLastSuKien() {
        return this.suKienList.getLast();
    }
}
