package com.uiteco.OfCuocThiPanel.firstPage;

import java.util.List;

public class PaginationResult {
    private final List<BriefPost_Model> postList;
    private final int totalPages;

    public PaginationResult(List<BriefPost_Model> postList, int totalPages) {
        this.postList = postList;
        this.totalPages = totalPages;
    }

    public List<BriefPost_Model> getPostList() {
        return postList;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
