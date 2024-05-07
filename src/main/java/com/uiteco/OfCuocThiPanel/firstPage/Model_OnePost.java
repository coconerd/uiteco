package com.uiteco.OfCuocThiPanel.firstPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.Icon;

public class Model_OnePost extends javax.swing.JPanel {

    public LocalDate getStartDate() {
        return startDate;
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

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
        String formattedDate = endDate.format(formatter);
        return formattedDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public LocalDate getEndDate_LocalDate(){
        return endDate;
    }
    
    private String title;
    private Icon image;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private String organizer;
    private List<String> tags; //choose ArrayList instead of LinkedList cause I just retrieve tag datas 
                                    //to show through press 4 buttons or in the posts 
                                    //dont adjust like insert or delete tags after a post was launched 
    
    public Model_OnePost
        (String title, 
         String organizer, 
         Icon image, 
         LocalDate startDate, 
         LocalDate endDate, 
         String content, 
         List<String> tags){
            
            this.title = title;
            this.content = content;
            this.image = image;
            this.startDate = startDate;
            this.endDate = endDate;
            this.tags = tags;
            this.organizer = organizer;
    }
    
    public String getDateRange(){
        String dateRange = getStartDate() + " - " + getEndDate();
        return dateRange;
    }

    public int calculateToDueDays(LocalDate endDate){
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), endDate);
    }
    
    public int getNumberOfTags(){
        return tags.size();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setBackground(new java.awt.Color(242, 243, 244));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}

