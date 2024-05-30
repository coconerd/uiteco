package com.uiteco.OfCuocThiPanel.firstPage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;

public class BriefPost_Model extends javax.swing.JPanel {

    /**
     * @return the thumbnailYT
     */
    public ImageIcon getThumbnailYT() {
        return thumbnailYT;
    }

    /**
     * @param thumbnailYT the thumbnailYT to set
     */
    public void setThumbnailYT(ImageIcon thumbnailYT) {
        this.thumbnailYT = thumbnailYT;
    }

    /**
     * @return the dueDate
     */
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getType() {
        return type;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int newCountLike) {
        int oldCountLike = countLike;
        countLike = newCountLike;
        propertyChangeSupport.firePropertyChange("countLike", oldCountLike, countLike);
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getThoiDiemDang() {
        return thoiDiemDang;
    }

    public void setThoiDiemDang(LocalDate thoiDiemDang) {
        this.thoiDiemDang = thoiDiemDang;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrganizer() {
        return organizer;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTime_String() {
        final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH : mm : ss");
        String formattedDateTime = postTime.format(CUSTOM_FORMATTER);
        return formattedDateTime;
    }

    public String getDate_String(LocalDate lcd){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = lcd.format(formatter);
        return formattedDate;
    }
    
    public String getCountLike_String() {
        String s = String.valueOf(getCountLike());
        return s;
    }

    public String convertType() {
        if (getType() == 2) {
            return "Đội nhóm";
        } else {
            return "Cá nhân";
        }
    }

    public String getDateRange() {
        String arrow = "\u2192";
        String dateRange = getDate_String(startDate) + " " + arrow + " " + getDate_String(endDate);
        return dateRange;
    }

    public long calculateToDueDays(LocalDate endDate) {
        LocalDate curDate = LocalDate.now();
        return endDate.compareTo(curDate); //endDate - curDate

    }

    public String getCustomStatus() {
        long daysRemaining = calculateToDueDays(endDate);

        if (daysRemaining > 0) {
            status = "Còn " + daysRemaining + " ngày";
        } else if (daysRemaining == 0) {
            status = "Đang diên ra";
        } else if (daysRemaining < 0) {
            status = "Kết thúc";
        }
        return status;
    }

    public String getDateRange_ForDetailedPage() {
        return "Thời gian đăng kí: " + getDateRange();
    }

    public void _addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void _removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected int id;
    protected String title;
    protected LocalDate thoiDiemDang;
    protected String status;
    protected int type;
    protected ImageIcon image;
    private LocalDate startDate;
    protected LocalDate endDate;
    protected String organizer;
    protected List<String> tags;
    protected String content;
    protected LocalDateTime postTime;
    public int countLike;
    protected LocalDateTime dueDate;
    private ImageIcon thumbnailYT;
}