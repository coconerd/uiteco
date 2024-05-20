/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.OfCuocThiPanel.firstPage;

import java.util.ArrayList;
import java.util.List;

public class Pagination_Cus {
    private final List<Object> items;
    private final int itemsPerPage;
    private int currentPage;
    private int totalPages;

    public Pagination_Cus(List<Object> items, int itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;
        calculateTotalPages();
        setCurrentPage(1);
    }

    private void calculateTotalPages() {
        this.totalPages = (int) Math.ceil((double) items.size() / itemsPerPage);
    }

    public void setCurrentPage(int page) {
        if (page < 1) {
            this.currentPage = 1;
        } else if (page > totalPages) {
            this.currentPage = totalPages;
        } else {
            this.currentPage = page;
        }
    }

    public List<Object> getCurrentPageItems() {
        int startIndex = (currentPage - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, items.size());
        return new ArrayList<>(items.subList(startIndex, endIndex));
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean hasNextPage() {
        return currentPage < totalPages;
    }

    public boolean hasPreviousPage() {
        return currentPage > 1;
    }

    public void nextPage() {
        setCurrentPage(currentPage + 1);
    }

    public void previousPage() {
        setCurrentPage(currentPage - 1);
    }
}
