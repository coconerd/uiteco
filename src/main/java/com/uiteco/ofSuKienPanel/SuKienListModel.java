/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

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
public class SuKienListModel extends PaginationModel implements PropertyChangeListener {

    public static final int DEFAULT_ENTRIES_PER_PAGE = 30;
    private ArrayList<SuKienModel> suKienList;

    public SuKienListModel() {
        super();
        this.addPropertyChangeListener(this);
        this.setSuKienList(SuKienDAO.getPageData(
                getCurrentPage(),
                getEntriesPerPage()
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

    public void setSuKienList(ArrayList<SuKienModel> suKienList) {
        this.suKienList = suKienList;
        // Fires a property-change event to notify SuKienListView that the list has changed. Therefore, view should be reloaded
        propertyChangeSupport.firePropertyChange("suKienList", null, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            setSuKienList(SuKienDAO.getPageData(
                    getCurrentPage(),
                    getEntriesPerPage()
            ));
        }
    }

    @Override
    protected int _getInitialEntries() {
        return SuKienDAO.getCount();
    }
    
    @Override
    protected int  _getInitialEntriesPerPage() {
        return DEFAULT_ENTRIES_PER_PAGE;
    }
}
