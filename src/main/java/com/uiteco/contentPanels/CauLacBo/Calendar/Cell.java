package com.uiteco.contentPanels.CauLacBo.Calendar;

import com.uiteco.contentPanels.CauLacBo.Calendar.CalendarCustom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Cell extends JButton {

    private Date date;
    private boolean title = false;
    private boolean isToDay = false;
    private boolean isEntered = false;
    private boolean isEvent = false;
    private CalendarCustom ParentCalender;
    
    private float PoxX;
    
    public Cell() {
        Start();
    }
    
    public Cell(float PoxX) {
        this.PoxX = PoxX;
        Start();
    }
    
    private void Start()
    {
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        this.setBorder(null);
        this.setHorizontalAlignment(JLabel.CENTER);
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Clicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                Entered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                Exited(evt);
            }
        });
    }

    private void Clicked(MouseEvent evt)
    {
        isEntered = true;
        
        if(ParentCalender != null)
            ParentCalender.ShowNotificationsEvent(this, true);
    }
    
    private void Entered(MouseEvent evt) { 
        isEntered = true;
        
        if(ParentCalender != null)
            ParentCalender.ShowNotificationsEvent(this, false);
    } 
    
    private void Exited(MouseEvent evt) {                                                
        isEntered = false;
        
        if(ParentCalender != null)
            ParentCalender.CloseNotificationsEvent();
    } 
    
    public void asTitle() {
        title = true;
    }

    public boolean isTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void currentMonth(boolean act) {
        if (act) {
            setForeground(new Color(68, 68, 68));
        } else {
            setForeground(new Color(169, 169, 169));
        }
    }

    public void setAsToDay() {
        isToDay = true;
        setForeground(Color.WHITE);
    }

    public void setParent(CalendarCustom parent)
    {  
        this.ParentCalender = parent;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) { 
        if (title) {
            grphcs.setColor(Color.BLUE);
            grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            
            super.paintComponent(grphcs);
            return;
        }
        
        if (isEvent) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(204,0,0));
            int x = getWidth() / 2 + 14;
            int y = getHeight() / 2 + 14;
            g2.fillRoundRect(x, y, 5, 5, 100, 100);
        }
        
        if (isToDay) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(97, 49, 237));
            int x = getWidth() / 2 - 17;
            int y = getHeight() / 2 - 17;
            g2.fillRoundRect(x, y, 35, 35, 100, 100);
        }
        else
        if(isEntered) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(230,230,230));
            int x = getWidth() / 2 - 17;
            int y = getHeight() / 2 - 17;
            g2.fillRoundRect(x, y, 35, 35, 100, 100);
        }
        
        super.paintComponent(grphcs);
    }
    
    public void setPoxX(int PoxX)
    {
        this.PoxX = PoxX;
    }
    
    public float getPoxX()
    {
        return PoxX;
    }
}
