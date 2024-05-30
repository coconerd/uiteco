package com.uiteco.contentPanels.CauLacBo.Calendar;

import java.awt.Color;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;


public class CalendarCustom extends javax.swing.JPanel {

    private int month;
    private int year;
    private List_DateEvent ListDE = new List_DateEvent();
    private NotificationsEvent CurrentNoEvent;
    
    private JPanel parentPanel;
    
    public void setparentPanel(JPanel parent)
    {
        parentPanel = parent;
    }
    
    public CalendarCustom() {
        Start();
    }
    
    public CalendarCustom(List_DateEvent ListDE) {
        this.ListDE = ListDE;
        
        Start();
    }
    
    private void Start()
    {   
       
       initComponents();
        thisMonth();
        slide.show(new PanelDate(month, year, this, ListDE));
        showMonthYear();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MM-yyyy");
                    String time = tf.format(date);
                    lbTime.setText(time.split(" ")[0]);
                    lbType.setText(time.split(" ")[1]);
                    lbDate.setText(df.format(date));
                }
            }
        }).start();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        slide = new com.uiteco.contentPanels.CauLacBo.Calendar.PanelSlide();
        jPanel5 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbMonthYear = new javax.swing.JLabel();
        NextButton = new com.uiteco.contentPanels.CauLacBo.JpanelRound();
        BackButton = new com.uiteco.contentPanels.CauLacBo.JpanelRound();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(90, 139, 255));

        jPanel4.setBackground(new java.awt.Color(25, 92, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(25, 92, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbTime.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lbTime.setForeground(new java.awt.Color(241, 241, 241));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("9:32:00");

        lbType.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        lbType.setForeground(new java.awt.Color(241, 241, 241));
        lbType.setText("PM");

        lbDate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbDate.setForeground(new java.awt.Color(241, 241, 241));
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDate.setText("Sunday, 30/05/2021");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbType))
                .addGap(0, 0, 0)
                .addComponent(lbDate)
                .addGap(17, 17, 17))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(59, 59, 59));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(51, 51, 51));

        lbMonthYear.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        lbMonthYear.setForeground(new java.awt.Color(66, 134, 255));
        lbMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMonthYear.setText("Month - Year");

        NextButton.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Right2.png"))); // NOI18N
        NextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NextButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout NextButtonLayout = new javax.swing.GroupLayout(NextButton);
        NextButton.setLayout(NextButtonLayout);
        NextButtonLayout.setHorizontalGroup(
            NextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        NextButtonLayout.setVerticalGroup(
            NextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        BackButton.setImage(new javax.swing.ImageIcon(getClass().getResource("/CauLacBoResources/Left2.png"))); // NOI18N
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout BackButtonLayout = new javax.swing.GroupLayout(BackButton);
        BackButton.setLayout(BackButtonLayout);
        BackButtonLayout.setHorizontalGroup(
            BackButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        BackButtonLayout.setVerticalGroup(
            BackButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(lbMonthYear, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(NextButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(BackButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lbMonthYear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbMonthYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 274, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMousePressed
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        
        slide.show(new PanelDate(month, year, this, ListDE));
        showMonthYear();
    }//GEN-LAST:event_NextButtonMousePressed

    private void BackButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMousePressed
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        
        slide.show(new PanelDate(month, year, this, ListDE));
        showMonthYear();
    }//GEN-LAST:event_BackButtonMousePressed

    public void ShowNotificationsEvent(Cell CellButton, boolean BreakFunc, LocalDate date, String TextNote)
    {            
        Point bl = CellButton.getLocationOnScreen();
        Point pl = parentPanel.getLocationOnScreen();

//        System.out.println("Width: " + CellButton.getWidth() + ", Height: " + CellButton.getHeight());
//        System.out.println("X parent: " + pl.x + ", Y parent: " + pl.y);
//        System.out.println("X button: " + bl.x + ", Y button: " + bl.y);
               
        if(CurrentNoEvent != null)
        {
            parentPanel.remove(CurrentNoEvent);    
            parentPanel.repaint();
            CurrentNoEvent.removeAll();
            CurrentNoEvent = null;
           
            if(BreakFunc)
                return;
        }
        
        int x = bl.x - pl.x ;
        int y = bl.y - pl.y ;
        
        CurrentNoEvent = new NotificationsEvent(CellButton.getPoxX());
            CurrentNoEvent.setXfooter(CellButton.getPoxX());
            
            String DOW = "Thứ 2";
            if(date.getDayOfWeek() == date.getDayOfWeek().TUESDAY)
                DOW = "Thứ 3";
            else if(date.getDayOfWeek() == date.getDayOfWeek().WEDNESDAY)
                DOW = "Thứ 4";
            else if(date.getDayOfWeek() == date.getDayOfWeek().THURSDAY)
                DOW = "Thứ 5";
            else if(date.getDayOfWeek() == date.getDayOfWeek().FRIDAY)
                DOW = "Thứ 6";
            else if(date.getDayOfWeek() == date.getDayOfWeek().SATURDAY)
                DOW = "Thứ 7";
            else if(date.getDayOfWeek() == date.getDayOfWeek().SUNDAY)
                DOW = "Chủ Nhật";
            
            CurrentNoEvent.setHeadText(DOW + ", " + date.getDayOfMonth() + " Tháng " + date.getMonthValue() + " Năm " + date.getYear());
            CurrentNoEvent.setBodyText(TextNote);
            
            parentPanel.add(CurrentNoEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(-223, 0, -1, -1), 0);
            CurrentNoEvent.setparentPanel(parentPanel, x + CellButton.getWidth() / 2, y);
            
//        parentPanel.add(CurrentNoEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(x - (int) CurrentNoEvent.getXfooter() + CellButton.getWidth() / 2, y - CurrentNoEvent.getHeight(), -1, -1), 0);
    }
    
    public void CloseNotificationsEvent()
    {
        if(CurrentNoEvent != null)
        {
            parentPanel.remove(CurrentNoEvent);    
            parentPanel.repaint();
            CurrentNoEvent.removeAll();
            CurrentNoEvent = null;
        }
    }
    
    
    private void thisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());   //  today
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
    }

    private void showMonthYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("MMMM-yyyy");
        lbMonthYear.setText(df.format(calendar.getTime()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.contentPanels.CauLacBo.JpanelRound BackButton;
    private com.uiteco.contentPanels.CauLacBo.JpanelRound NextButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbMonthYear;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbType;
    private com.uiteco.contentPanels.CauLacBo.Calendar.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
