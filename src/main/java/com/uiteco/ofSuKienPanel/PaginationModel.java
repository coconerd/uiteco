/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author nddmi
 */
public abstract class PaginationModel {

    /**
     * entries: The total amount of objects that exists in database (e.g:
     * database has 325 SuKien => entries will have value of 325)
     */
    protected int entries;
    protected int entriesPerPage;
    protected int pageCount;
    protected int currentPage;
    protected PropertyChangeSupport propertyChangeSupport;

    public PaginationModel() {
        this.setPropertyChangeSupport(new PropertyChangeSupport(this));
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
        int oldPageCount = getPageCount();
        this.pageCount = pageCount;
        propertyChangeSupport.firePropertyChange("pageCount", oldPageCount, pageCount);
    }

    /**
     * Fires a property-change event to notify SuKienListModel that users wanna
     * switch page
     *
     * @param newPage
     */
    public void setCurrentPage(int newPage) {
        int oldPage = getCurrentPage();
        this.currentPage = newPage;
        propertyChangeSupport.firePropertyChange("currentPage", oldPage, newPage);
        System.out.println("Debug: current page = " + newPage);
        System.out.println("Debug: page count = " + pageCount);
        System.out.println("Debug: entries per page = " + entriesPerPage);
        System.out.println("Debug: total entries count = " + entries);
    }

//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        this.propertyChangeSupport.addPropertyChangeListener(listener);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        this.propertyChangeSupport.removePropertyChangeListener(listener);
//    }
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * Must be overridden
     */
    protected abstract int _getInitialEntries();
    
    /**
     * Must be overridden
     */
    protected abstract int _getInitialEntriesPerPage();
    
    private void _init() {
        this.setEntries(_getInitialEntries());
        this.setEntriesPerPage(_getInitialEntriesPerPage());
        this.setPageCount((int) Math.ceil((double) entries / entriesPerPage));
        this.setCurrentPage(1);
    }
}
