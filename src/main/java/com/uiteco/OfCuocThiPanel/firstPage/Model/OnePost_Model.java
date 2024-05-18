package com.uiteco.OfCuocThiPanel.firstPage.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;

public class OnePost_Model extends javax.swing.JPanel {

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }
    
    public String getPostTime_String(){
        final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = postTime.format(CUSTOM_FORMATTER);
        return formattedDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public int getCountLike() {
        return countLike;
    }

    public String getCountLike_String() {
        return "" + countLike + "";
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

    public String convertType() {
        if (type == 2) {
            return "Đội nhóm";
        } else {
            return "Cá nhân";
        }
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

    public String getEndDate_String() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = endDate.format(formatter);
        return formattedDate;
    }

    public String getStartDate_String() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = startDate.format(formatter);
        return formattedDate;
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
    
    private int id;
    private String title;
    private LocalDate thoiDiemDang;
    protected String status;
    private int type;
    private ImageIcon image;
    private LocalDate startDate;
    private LocalDate endDate;
    private String organizer;
    private List<String> tags;
    private int countLike = 0;
    private String content;
    private LocalDateTime postTime;
    
    public OnePost_Model() {
    }

    public String getDateRange() {
        String arrow = "\u2192";
        String dateRange = getStartDate_String() + " " + arrow + " " + getEndDate_String();
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
            status = "Dang dien ra";
        } else if (daysRemaining < 0) {
            status = "Ket thuc";
        }
        return status;
    }

}
