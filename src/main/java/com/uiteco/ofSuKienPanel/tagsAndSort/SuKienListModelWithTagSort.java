/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.tagsAndSort;

import com.uiteco.ofSuKienPanel.SuKienListModel;
import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 * import java.beans.PropertyChangeListener;
 *
 *
 * @author nddmi
 */
public class SuKienListModelWithTagSort extends SuKienListModel {

    /**
     * All sorting options (Eg. Sort by posted time, sort by views, ...)
     */
    public static enum SORT_OPTION {
        NEWEST, HOTTEST
    };
    public static SORT_OPTION DEFAULT_SORT_OPTION = SORT_OPTION.NEWEST;
    private SORT_OPTION sortOption;
    private Set<String> tags;

    public SuKienListModelWithTagSort() {
        setTags(new HashSet<String>());
        setSortOption(DEFAULT_SORT_OPTION);
    }

    public SuKienListModelWithTagSort(Set<String> tags, SORT_OPTION sortOption) {
        setTags(tags);
        setSortOption(sortOption);
    }

    public SuKienListModelWithTagSort(List<SuKienModel> suKienList) {
        super(suKienList);
    }

    public SORT_OPTION getSortOption() {
        return sortOption;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setSortOption(SORT_OPTION sortOption) {
        this.sortOption = sortOption;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    /**
     *
     */
    public void loadData() {
        try {
            setEntries(SuKienDAO.getCount(tags));
            setPageCount((int) Math.ceil((double) getEntries() / getEntriesPerPage()));
            setSuKienList(SuKienDAO.getPageData(getCurrentPage(), getEntriesPerPage(), tags, sortOption));
            fireSuKienList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            try {
                setSuKienList(SuKienDAO.getPageData(
                        getCurrentPage(),
                        getEntriesPerPage(),
                        tags,
                        sortOption
                ));
                fireSuKienList();

                System.out.println("Debug: current page = " + getCurrentPage());
                System.out.println("Debug: page count = " + getPageCount());
                System.out.println("Debug: entries per page = " + getEntriesPerPage());
                System.out.println("Debug: total entries count = " + getEntries());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected int _getInitialEntries() {
        return 0; // False value
    }

    @Override
    protected void _additionalInit() {
        if (getSuKienList() != null) {
            fireSuKienList();
        }
    }
}
