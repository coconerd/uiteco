/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import com.uiteco.ofSuKienPanel.tagsAndSort.SuKienListModelWithTagSort;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

/**
 * import java.beans.PropertyChangeListener;
 *
 *
 * @author nddmi
 */
public class SuKienListModel extends PaginationModel implements PropertyChangeListener {

    public static final int DEFAULT_ENTRIES_PER_PAGE = 15;
    private List<SuKienModel> suKienList;

    public SuKienListModel() {
        _init();
        _additionalInit();
    }

    public SuKienListModel(List<SuKienModel> suKienList) {
        _init();
        setSuKienList(suKienList);
        _additionalInit();

    }

    public List<SuKienModel> getSuKienList() {
        return this.suKienList;
    }

    public void fireSuKienList() {
        // Fires a property-change event to notify SuKienListView that the list has changed. Therefore, view should be reloaded
        propertyChangeSupport.firePropertyChange("suKienList", null, null);
    }

    public void setSuKienList(List<SuKienModel> suKienList) {
        this.suKienList = suKienList;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            try {
                setSuKienList(SuKienDAO.getPageData(
                        getCurrentPage(),
                        getEntriesPerPage(),
                        SuKienListModelWithTagSort.SORT_OPTION.NEWEST
                ));
                fireSuKienList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected int _getInitialEntries() {
        int count = 0;
        try {
            count = SuKienDAO.getCount();

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        };

        return count;
    }

    @Override
    protected int _getInitialEntriesPerPage() {
        return DEFAULT_ENTRIES_PER_PAGE;
    }

    protected void _additionalInit() {
        if (suKienList != null) {
            fireSuKienList();
        } else {
            try {
                setSuKienList(SuKienDAO.getPageData(
                        getCurrentPage(),
                        getEntriesPerPage(),
                        SuKienListModelWithTagSort.SORT_OPTION.NEWEST
                ));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void _init() {
        addPropertyChangeListener(this);
    }

}
