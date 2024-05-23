package com.uiteco.contentPanels.CauLacBo.Calendar;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

public class PanelDate extends javax.swing.JLayeredPane {

    private int month;
    private int year;
    private CalendarCustom ParentCalender;
    
    public PanelDate(int month, int year) {
        Start(month, year);
    }
    
    public PanelDate(int month, int year, CalendarCustom parent) {
        ParentCalender = parent;
        Start(month, year);
    }

    private void Start(int month, int year)
    {
        initComponents();
        this.month = month;
        this.year = year;
        init();
    }
    
    private void init() {
        mon.asTitle();
        tue.asTitle();
        wed.asTitle();
        thu.asTitle();
        fri.asTitle();
        sat.asTitle();
        sun.asTitle();
        setDate();
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
        calendar.add(Calendar.DATE, -startDay);
        ToDay toDay = getToDay();
        for (Component com : getComponents()) {
            Cell cell = (Cell) com;
            if (!cell.isTitle()) {
                cell.setParent(ParentCalender);
                
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                }
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }

    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }
    
    public void setCalendarCustom(CalendarCustom parent)
    {
        this.ParentCalender = parent;
        
        System.out.println("insert complete Parentcalender");
    }
    
    public CalendarCustom getCalendarCustom()
    {
        return this.ParentCalender;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        mon = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        tue = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        wed = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        thu = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        fri = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        sat = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell();
        cell8 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell9 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell10 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell11 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell12 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell13 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell14 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);
        cell15 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell16 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell17 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell18 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell19 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell20 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell21 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);
        cell22 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell23 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell24 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell25 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell26 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell27 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell28 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);
        cell29 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell30 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell31 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell32 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell33 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell34 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell35 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);
        cell36 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell37 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell38 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell39 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell40 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell41 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell42 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);
        cell43 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(0);
        cell44 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(1);
        cell45 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(2);
        cell46 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(3);
        cell47 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(4);
        cell48 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(5);
        cell49 = new com.uiteco.contentPanels.CauLacBo.Calendar.Cell(6);

        setLayout(new java.awt.GridLayout(7, 7));

        sun.setForeground(new java.awt.Color(222, 12, 12));
        sun.setText("Sun");
        sun.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(sun);

        mon.setText("Mon");
        mon.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(mon);

        tue.setText("Tue");
        tue.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(tue);

        wed.setText("Wed");
        wed.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(wed);

        thu.setText("Thu");
        thu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(thu);

        fri.setText("Fri");
        fri.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(fri);

        sat.setText("Sat");
        sat.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(sat);

        cell8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell8);

        cell9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell9);

        cell10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell10);

        cell11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell11);

        cell12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell12);

        cell13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell13);

        cell14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell14);

        cell15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell15);

        cell16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell16);

        cell17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell17);

        cell18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell18);

        cell19.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell19);

        cell20.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell20);

        cell21.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell21);

        cell22.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell22);

        cell23.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell23);

        cell24.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell24);

        cell25.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell25);

        cell26.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell26);

        cell27.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell27);

        cell28.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell28);

        cell29.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell29);

        cell30.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell30);

        cell31.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell31);

        cell32.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell32);

        cell33.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell33);

        cell34.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell34);

        cell35.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell35);

        cell36.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell36);

        cell37.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell37);

        cell38.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell38);

        cell39.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell39);

        cell40.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell40);

        cell41.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell41);

        cell42.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell42);

        cell43.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell43);

        cell44.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell44);

        cell45.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell45);

        cell46.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell46);

        cell47.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell47);

        cell48.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell48);

        cell49.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell10;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell11;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell12;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell13;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell14;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell15;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell16;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell17;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell18;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell19;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell20;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell21;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell22;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell23;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell24;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell25;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell26;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell27;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell28;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell29;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell30;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell31;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell32;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell33;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell34;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell35;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell36;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell37;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell38;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell39;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell40;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell41;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell42;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell43;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell44;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell45;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell46;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell47;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell48;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell49;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell8;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell cell9;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell fri;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell mon;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell sat;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell sun;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell thu;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell tue;
    private com.uiteco.contentPanels.CauLacBo.Calendar.Cell wed;
    // End of variables declaration//GEN-END:variables
}
