/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author nddmi
 */
public class PaginationModel {
    /**
     * entries: The total amount of objects that exists in database (e.g: database has 325 SuKien => entries will have value of 325)
     */
    private int entries;
    private int entriesPerPage;
    private int pageCount;
    private int currentPage;
    private PropertyChangeSupport propertyChangeSupport;
    
    public static final int DEFAULT_ENTRIES_PER_PAGE = 100;

    
    public PaginationModel() {
        this.entriesPerPage = DEFAULT_ENTRIES_PER_PAGE;
        _init();
    }
    
    public PaginationModel(int entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
        _init();
    }
    
    public int getEntries() {
        return this.entries;
    }
    
    public int getEntriesPerPage() {
        return this.entriesPerPage;
    }
    
    public int getPageCount() {
        return this.pageCount;
    }
    
    public int getCurrentPage() {
        return this.currentPage;
    }
    
    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }
    
    public void setEntries(int entries) {
        this.entries = entries;
    }
    
    public void setEntriesPerPage(int entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
     /**
     * Fires a property-change event to notify SuKienListModel that users wanna switch page
     * @param page 
     */
    public void setCurrentPage(int page) {
        this.currentPage = page;
        propertyChangeSupport.firePropertyChange("currentPage", null, null);
        System.out.println("Debug: current page = " + page);
        System.out.println("Debug: page count = " + pageCount);
        System.out.println("Debug: entries per page = " + entriesPerPage);
        System.out.println("Debug: total entries count = " + entries);
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
 
    public void switchPreviousPage() {
        if (currentPage > 1) {
            setCurrentPage(currentPage - 1);
        }
    }

    public void switchNextPage() {
        if (currentPage < pageCount) {
            setCurrentPage(currentPage + 1);
        }
    }
    
    public void switchPage(int page) {
        if (page != currentPage && page >= 1 && page <= pageCount) {
            setCurrentPage(page);
        }
    }
    
    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }
    
    private void _init() {
        this.setEntries(SuKienDAO.getCount());
        this.setPropertyChangeSupport(new PropertyChangeSupport(this));
        this.setPageCount( (int)Math.ceil( (double)entries / entriesPerPage ));
        this.setCurrentPage(1);
    }
}
