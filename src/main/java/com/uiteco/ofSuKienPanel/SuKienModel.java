/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel;

import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Set;
import java.time.LocalDate;

/**
 *
 * @author nddmi
 */
public class SuKienModel {

    private String title;
    private Set<String> tags;
    private int postID;
    private String type;
    private String content;
    private String postedBy;
    private LocalDateTime postedAt;
    private String note;
    private Integer clubID;
    private ImageIcon thumbnail;
    private ImageIcon[] images;
    private int views;
    private int likes;
    private boolean enrollable;
    private int enrollCount;
    private LocalDate enrollStart;
    private LocalDate enrollEnd;
    private Integer enrollLimit;
    
    private boolean liked;
    private String clubName;
    private LocalDateTime lastLoaded;

    public SuKienModel() {
    }

    public SuKienModel(
            String title,
            Set<String> tags,
            int postID,
            String type,
            String content,
            String postedBy,
            LocalDateTime postedAt,
            String note,
            Integer clubID,
            ImageIcon thumbnail,
            int views,
            int likes
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
        this.likes = likes;
        
        this.liked = false;
    }

    public void setEnrollStart(LocalDate enrollStart) {
        this.enrollStart = enrollStart;
    }

    public void setEnrollEnd(LocalDate enrollEnd) {
        this.enrollEnd = enrollEnd;
    }
    
    public void setEnrollLimit(Integer enrollLimit) {
        this.enrollLimit = enrollLimit;
    }
    

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(Set<String> tags) {
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
    
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setClubID(Integer clubID) {
        this.clubID = clubID;
    }

    public void setThumbnail(ImageIcon thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setImages(ImageIcon[] images) {
        this.images = images;
    }
    
    public void setLastLoaded(LocalDateTime lastLoaded) {
        this.lastLoaded = lastLoaded;
    }

    public void setImage(int index, ImageIcon image) {
        this.images[index] = image;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public void setLiked(boolean liked) {
        this.liked= liked;
    }

    public void setEnrollable(boolean enrollable) {
        this.enrollable = enrollable;
    }

    public void setEnrollCount(int enrollCount) {
        this.enrollCount = enrollCount;
    }
    
    public Integer getEnrollLimit() {
        return enrollLimit;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getEnrollStart() {
        return enrollStart;
    }

    public LocalDate getEnrollEnd() {
        return enrollEnd;
    }

    public Set<String> getTags() {
        return tags;
    }
    
    public String getTag(int index) {
        return (String) tags.toArray()[index];
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

    public Integer getClubID() {
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
    
    public int getLikes() {
        return this.likes;
    }
    
    public String getClubName() {
        return this.clubName;
    }
    
    public boolean isLiked() {
        return this.liked;
    }

    public boolean isEnrollable() {
        return enrollable;
    }

    public int getEnrollCount() {
        return enrollCount;
    }
    
    public LocalDateTime getLastLoaded() {
        return this.lastLoaded;
    }
}
