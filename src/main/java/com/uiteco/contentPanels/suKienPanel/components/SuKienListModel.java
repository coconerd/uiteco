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
 * import java.beans.PropertyChangeListener;
 *
 *
 * @author nddmi
 */
public class SuKienListModel implements PropertyChangeListener {

    private ArrayList<SuKienModel> suKienList;
    private PropertyChangeSupport propertyChangeSupport;
    private PaginationModel paginationModel;

    public SuKienListModel(PaginationModel paginationModel) {
        if (paginationModel == null) {
            System.err.println("Error: SuKienListModel requires an instance of paginationModel!");
            System.exit(0);
        }
        
        this.setPropertyChangeSupport(new PropertyChangeSupport(this));
        this.setPaginationModel(paginationModel);
        this.paginationModel.addPropertyChangeListener(this);
        this.setSuKienList(SuKienDAO.getPageData(
                paginationModel.getCurrentPage(),
                paginationModel.getEntriesPerPage()
        ));
    }

    public void addSuKien(SuKienModel suKien) {
        this.suKienList.add(suKien);
        // Fires a property-change event to notify SuKienListView that the list has changed. Therefore, view should be reloaded
        this.propertyChangeSupport.firePropertyChange("SuKienList", null, suKien);
    }

    public void removeSuKien(SuKienModel suKien) {
        this.suKienList.remove(suKien);
        // Fires a property-change event to notify SuKienListView that the list has changed. Therefore, view should be reloaded
        this.propertyChangeSupport.firePropertyChange("suKienListRemoved", suKien, null);
    }

    public ArrayList<SuKienModel> getSuKienList() {
        return this.suKienList;
    }

    public SuKienModel getLastSuKien() {
        return this.suKienList.getLast();
    }
    
    public PaginationModel getPaginationModel() {
        return this.paginationModel;
    }
    
    public void setSuKienList(ArrayList<SuKienModel> suKienList) {
        this.suKienList = suKienList;
        // Fires a property-change event to notify SuKienListView that the list has changed. Therefore, view should be reloaded
        propertyChangeSupport.firePropertyChange("suKienList", null, null);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }
    
    public void setPaginationModel(PaginationModel pagionationModel) {
        this.paginationModel = pagionationModel;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Implements PropertyChangeListener interface to listen to page-change
     * event from PaginationModel
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            setSuKienList(SuKienDAO.getPageData(
                    paginationModel.getCurrentPage(),
                    paginationModel.getEntriesPerPage()
            ));
        }
    }
}
