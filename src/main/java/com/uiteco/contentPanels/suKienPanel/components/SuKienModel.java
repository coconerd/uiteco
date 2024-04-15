/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.time.LocalDate;

/**
 *
 * @author nddmi
 */
public class SuKienModel {

    private String title;
    private String tag;
    private int postID;
    private String type;
    private String content;
    private String postedBy;
    private LocalDate postedAt;
    private String note;
    private String clubID;

    public SuKienModel() {
    }

    public SuKienModel(String title, String tag, int postID, String type, String content, String postedBy, LocalDate postedAt, String note, String clubID) {
        this.title = title;
        this.tag = tag;
        this.postID = postID;
        this.type = type;
        this.content = content;
        this.postedBy = postedBy;
        this.postedAt = postedAt;
        this.note = note;
        this.clubID = clubID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getTitle() {
        return title;
    }

    public String getTag() {
        return tag;
    }

    public int getPostID() {
        return postID;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public String getNote() {
        return note;
    }

    public String getClubID() {
        return clubID;
    }

}
