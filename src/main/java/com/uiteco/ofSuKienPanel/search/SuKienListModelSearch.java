/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.search;

import com.uiteco.ofSuKienPanel.SuKienDAO;
import com.uiteco.ofSuKienPanel.SuKienListModel;
import com.uiteco.ofSuKienPanel.SuKienModel;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nddmi
 */
public class SuKienListModelSearch extends SuKienListModel {

    protected boolean hasNextPage;
    protected boolean hasPreviousPage;

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
        setHasPreviousPage(getCurrentPage() > 1 ? true : false);

    }

    public SuKienListModelSearch(String searchText) {
        super();
        setSearchText(searchText);
        setSearchOption(DEFAULT_SEARCH_OPTION);
        setHasPreviousPage(getCurrentPage() > 1 ? true : false);
    }

    public boolean hasNextPage() {
        return hasNextPage;
    }

    public boolean hasPreviousPage() {
        return hasPreviousPage;
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

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Loading next page");
        if (evt.getPropertyName().equals("currentPage")) {
            try {
                System.out.println("I'm in here");

                setSuKienList(SuKienDAO.searchSuKien(searchText, searchOption, getCurrentPage(), getEntriesPerPage()));
                setHasPreviousPage(getCurrentPage() > 1 ? true : false);
                if (getSuKienList().size() > getEntriesPerPage()) {
                    getSuKienList().removeLast();
                    setHasNextPage(true);
                }
                setEntries(getSuKienList().size());
                fireSuKienList();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void switchPreviousPage() {
        if (hasPreviousPage || getCurrentPage() > 1) {
            setCurrentPageAndFire(currentPage - 1);
        }
    }

    @Override
    public void switchNextPage() {
        if (hasNextPage) {
            setCurrentPageAndFire(currentPage + 1);
        }
    }

    @Override
    protected int _getInitialEntries() {
        return 0; // false number
    }

    public void loadData() {
        try {
            List<SuKienModel> suKienList = SuKienDAO.searchSuKien(searchText, searchOption, getCurrentPage(), getEntriesPerPage());
            setSuKienList(suKienList);

            // If there are more page after the current one
            if (getSuKienList().size() > getEntriesPerPage()) {
                getSuKienList().removeLast();
                setHasNextPage(true);
            }
            setEntries(suKienList.size());
            fireSuKienList();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    // Override that of SuKienListModel
    @Override
    protected void _additionalInit() {
        // Do nothing
    }
}
