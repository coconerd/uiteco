package com.uiteco.OfCuocThiPanel.layouts;

import com.uiteco.components.RoundedBorder;
import com.uiteco.OfCuocThiPanel.components.roundedButton.CustomButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TagsAndSort extends JPanel{
   
    
    public TagsAndSort(){
        initLayout();
        initSortButtons();
    }
    
    public void initLayout(){
        setLayout(new FlowLayout(FlowLayout.TRAILING, 15, 0)); //20 is gap between components in pixels
        setBounds(30, 30, 1170, 60);
        setBackground(Color.WHITE);
        RoundedBorder roundBor = new RoundedBorder(new Color(242, 243, 244), Color.WHITE, Color.WHITE, 15, 0); 
        setBorder(roundBor);
    }
    
    public void initSortButtons(){
        
        JLabel sortText = new JLabel("SORT: ");
        sortText.setFont(new Font("Arial", BOLD, 15)); //15 is the size of text
        
        CustomButton date = new CustomButton();
        CustomButton team = new CustomButton();
        CustomButton solo = new CustomButton();
        CustomButton latest = new CustomButton();
        
        date.setText("<html>Đến hạn<br>đăng kí</html>");
        date.setPreferredSize(new Dimension(100, 37));
       
        team.setText("<html>Đội<br>nhóm</html>");
        solo.setText("<html>Cá<br>nhân</html>");
        latest.setText("<html>Mới<br>nhất</html>");
   
        // Set icons for buttons
        //team.setIcon(new javax.swing.ImageIcon(getClass().getResource("/layouts/team_20.png")));
        //solo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-17.png")));
        
        //team.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\scr\\main\\java\\resources\\person_10.png"));
        this.add(sortText);
        this.add(solo);
        this.add(team);
        this.add(date);
        this.add(latest);
      
    }
    
    
}
