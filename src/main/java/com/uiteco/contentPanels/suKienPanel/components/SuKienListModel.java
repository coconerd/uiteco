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
public class SuKienListModel {

    private ArrayList<SuKienModel> suKienList;
    private PropertyChangeSupport propertyChangeSupport;
    private int TOTAL;
    private int PER_PAGE;
    private int pageCount;
    private int currentPage;

    public SuKienListModel() {
        this.setPropertyChangeSupport(new PropertyChangeSupport(this));

        this.setTOTAL(SuKienDAO.getCount());
        this.setPER_PAGE(Math.min(30, TOTAL));
        this.setPageCount((int) Math.ceil(TOTAL / PER_PAGE));

        ArrayList<SuKienModel> pageData = SuKienDAO.getPageData(1, PER_PAGE);
        this.setCurrentPage(1);
        this.setSuKienList(pageData);
    }

    public void loadPreviousPage() {
        if (currentPage > 1) {
            _loadPage(currentPage - 1);
        }
    }

    public void loadNextpage() {
        if (currentPage < pageCount) {
            _loadPage(currentPage + 1);
        }
    }

    public void loadPage(int page) {
        if (page != currentPage && page >= 1 && page <= pageCount) {
            _loadPage(page);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.removePropertyChangeListener(listener);
    }

    public void addSuKien(SuKienModel s) {
        this.suKienList.add(s);
        this.propertyChangeSupport.firePropertyChange("suKienListAdded", null, null);
    }

    public void removeSuKien(SuKienModel s) {
        this.suKienList.remove(s);
        this.propertyChangeSupport.firePropertyChange("suKienListRemoved", null, null);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public int getPageCount() {
        return pageCount;
    }

    public ArrayList<SuKienModel> getSuKienList() {
        return this.suKienList;
    }

    public SuKienModel getLastSuKien() {
        return this.suKienList.getLast();
    }

    public int getPER_PAGE() {
        return PER_PAGE;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    public void setPER_PAGE(int PER_PAGE) {
        this.PER_PAGE = PER_PAGE;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setSuKienList(ArrayList<SuKienModel> suKienList) {
        this.suKienList = suKienList;
        propertyChangeSupport.firePropertyChange("suKienList", null, null);
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        propertyChangeSupport.firePropertyChange("currentPage", null, null);
    }

    private void _loadPage(int page) {
        System.out.println("Debug: page = " + page);
        System.out.println("Debug: currentPage = " + currentPage);
        System.out.println("Debug: pageCount = " + pageCount);
        System.out.println("Debug: PER_PAGE = " + PER_PAGE);
        System.out.println("Debug: TOTAL = " + TOTAL);
        
        setSuKienList(SuKienDAO.getPageData(page, PER_PAGE));
        setCurrentPage(page);
    }
}
