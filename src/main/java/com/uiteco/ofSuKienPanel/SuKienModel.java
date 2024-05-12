/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 *
 * @author nddmi
 */
public class SuKienModel {

    private String title;
    private ArrayList<String> tags;
    private int postID;
    private String type;
    private String content;
    private String postedBy;
    private LocalDateTime postedAt;
    private String note;
    private String clubID;
    private ImageIcon thumbnail;
    private ImageIcon[] images;
    private int views;

    public SuKienModel() {
    }

    public SuKienModel(
            String title,
            ArrayList<String> tags,
            int postID,
            String type,
            String content,
            String postedBy,
            LocalDateTime postedAt,
            String note,
            String clubID,
            ImageIcon thumbnail,
            int views
    ) {
        this.title = title;
        this.tags = tags;
        this.postID = postID;
        this.type = type;
        this.content = content;
        this.postedBy = postedBy;
        this.postedAt = postedAt;
        this.note = note;
        this.clubID = clubID;
        this.thumbnail = thumbnail;
        this.views = views;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
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

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public void setThumbnail(ImageIcon thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setImages(ImageIcon[] images) {
        this.images = images;
    }

    public void setImage(int index, ImageIcon image) {
        this.images[index] = image;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
    
    public String getTag(int index) {
        return tags.get(index);
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

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public String getNote() {
        return note;
    }

    public String getClubID() {
        return clubID;
    }

    public ImageIcon getThumbnail() {
        return thumbnail;
    }

    public ImageIcon[] getImages() {
        return images;
    }

    public ImageIcon getImage(int index) {
        return images[index];
    }

    public int getViews() {
        return this.views;
    }
}
