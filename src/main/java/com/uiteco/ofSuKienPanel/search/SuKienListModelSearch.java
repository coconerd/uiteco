/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienListModel;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nddmi
 */
public class SuKienListModelSearch extends SuKienListModel {

    public static enum SEARCH_OPTION {
        title, content, postedBy
    };

    public static final SEARCH_OPTION DEFAULT_SEARCH_OPTION = SEARCH_OPTION.title;

    protected SEARCH_OPTION searchOption;
    protected String searchText;

    public SuKienListModelSearch(String searchText, SEARCH_OPTION searchOption) {
        super();
        setSearchText(searchText);
        setSearchOption(searchOption);
    }
    
    public SuKienListModelSearch(String searchText) {
        super();
        setSearchText(searchText);
        setSearchOption(DEFAULT_SEARCH_OPTION);
    }

    public String getSearchText() {
        return searchText;
    }
    
    public SEARCH_OPTION getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(SEARCH_OPTION searchOption) {
        this.searchOption = searchOption;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            try {
                setSuKienList(SuKienDAO.getPageData(
                        getCurrentPage(),
                        getEntriesPerPage()
                ));
                fireSuKienList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected int _getInitialEntries() {
        return 0; // false number
    }

    public void loadData() {
        try {
            List<SuKienModel> suKienList = SuKienDAO.searchSuKien(searchText, searchOption);
            setEntries(suKienList.size());
            setPageCount((int) Math.ceil((double) getEntries()) / getEntriesPerPage());
            setSuKienList(suKienList);
            fireSuKienList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Override that of SuKienListModel
    @Override
    protected void _additionalInit() {
        // Do nothing
    }
}
