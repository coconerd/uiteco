/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import com.uiteco.components.RoundedImagePanel;

/**
 *
 * @author nddmi
 */
public class SlideShowModel extends PaginationModel {

    public static int DEFAULT_ENTRIES_PER_PAGE = 1;
    private ArrayList<SuKienModel> suKienList;
    private boolean next;

    public SlideShowModel() {
        super();
        setSuKienList(SuKienDAO.getSuKienSlideShow());
        if (getSuKienCount() > 0) {
            setSuKienIn(getSuKien(0));
        }
    }

    public boolean isNext() {
        return next;
    }

    public SuKienModel getSuKien(int index) {
        return this.suKienList.get(index);
    }

    public ArrayList<SuKienModel> getSuKienList() {
        return this.suKienList;
    }

//    public SuKienModel getSuKienIn() {
//        return suKienIn;
//    }
//    public SuKienModel getSuKienOut() {
//        return suKienOut;
//    }
    public int getSuKienCount() {
        return this.suKienList.size();
    }

    public void setSuKien(int index, SuKienModel suKien) {
        this.suKienList.set(index, suKien);
    }

    public void setSuKienList(ArrayList<SuKienModel> suKienList) {
        this.suKienList = suKienList;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public void setSuKienIn(SuKienModel suKienIn) {
//        this.suKienIn = suKienIn;
    }

    public void setSuKienOut(SuKienModel suKienOut) {
//        this.suKienOut = suKienOut;
    }

    public void addSuKien(SuKienModel suKien) {
        this.suKienList.add(suKien);
    }

    public void removeSuKien(SuKienModel suKien) {
        this.suKienList.remove(suKien);
    }


    @Override
    public void switchNextPage() {
        int currPage = getCurrentPage();
        int nextPage = _nextPage(currPage);
//        setSuKienIn(getSuKien(pageToIndex(nextPage)));
//        setSuKienOut(getSuKien(pageToIndex(currPage)));
        setNext(true);
        setCurrentPage(nextPage);
    }

    @Override
    public void switchPreviousPage() {
        int currPage = getCurrentPage();
        int previousPage = _previousPage(currPage);
//        setSuKienIn(getSuKien(pageToIndex(previousPage)));
//        setSuKienOut(getSuKien(pageToIndex(currPage)));
        setNext(false);
        setCurrentPage(previousPage);
    }

    @Override
    public void switchPage(int page) {
        if (page != getCurrentPage()) {
            setNext(true);
            setNext(page < getCurrentPage() ? false : true);
            setCurrentPage(page);
        }
    }

    @Override
    protected int _getInitialEntries() {
        return SuKienDAO.getSlideShowPageCount();
    }

    @Override
    protected int _getInitialEntriesPerPage() {
        return DEFAULT_ENTRIES_PER_PAGE;
    }

    private int _nextPage(int page) {
        if (page == getPageCount()) {
            return 1;
        }
        return page + 1;
    }

    private int _previousPage(int page) {
        if (page == 1) {
            return getPageCount();
        }
        return page - 1;
    }
}
