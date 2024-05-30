/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo.Calendar;

import java.time.LocalDate;


public class InfoDateEvent {
    public LocalDate date = null;
    public String title = null;
    public String typeDate = null;
    
    public InfoDateEvent()
    {}
    
    public InfoDateEvent(LocalDate date, String title, String typeDate)
    {
        this.date = date;
        this.title = title;
        this.typeDate = typeDate;
    }
}
