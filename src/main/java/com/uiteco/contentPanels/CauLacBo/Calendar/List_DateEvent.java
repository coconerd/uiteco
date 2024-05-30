/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.contentPanels.CauLacBo.Calendar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author 21H1 HNQA
 */
public class List_DateEvent {
    public ArrayList<InfoDateEvent> Listdate;
    
    public List_DateEvent()
    {
        Listdate = new ArrayList();;
    }
    
    public void add(InfoDateEvent ifDate)
    {
        Listdate.add(ifDate);
    }
    
    public InfoDateEvent get(int i)
    {
        return Listdate.get(i);
    }
    
    public int size()
    {
        return Listdate.size();
    }
    
    public void SortDate()
    {
        Collections.sort(Listdate, new Comparator<InfoDateEvent>(){
        public int compare(InfoDateEvent o1, InfoDateEvent o2){
            return o1.date.compareTo(o2.date);
            }});
    }
}
