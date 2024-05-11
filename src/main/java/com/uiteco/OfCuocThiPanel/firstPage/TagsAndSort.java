package com.uiteco.OfCuocThiPanel.firstPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uiteco.OfCuocThiPanel.Components.comboBoxMultiSelection.ComboBoxMultiSelection;
import com.uiteco.components.RoundedBorder;
import com.uiteco.OfCuocThiPanel.data.DatabaseConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public final class TagsAndSort extends JPanel{
   
    public TagsAndSort(){
        initTagAndSort();
    }
    
    public void initTagAndSort(){
        
        setLayout(new BorderLayout());
        setBounds(30, 30, 3000, 60);
        setBackground(Color.WHITE);
        
        RoundedBorder roundBor = new RoundedBorder(new Color(242, 243, 244), Color.WHITE, Color.WHITE, 15, 0); 
        setBorder(roundBor); 
        
        setOpaque(true); //display background color (white) in TagsAndSort panel
        add(RightPanel(), BorderLayout.LINE_END);
        add(LeftPanel(), BorderLayout.LINE_START);
    }
    
    public JPanel RightPanel(){
        
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, -7)); //a horizontal gap of 10 pixels between each component
      
        
        JLabel sortText = new JLabel("Sort: ");
        sortText.setFont(new Font("Arial", BOLD, 17)); //17 is the size of text
        CustomButton date = new CustomButton();
        CustomButton team = new CustomButton();
        CustomButton solo = new CustomButton();
        CustomButton latest = new CustomButton();
        
        date.setText("<html>Đến<br>hạn</html>");
        team.setText("<html>Đội<br>nhóm</html>");
        solo.setText("<html>Cá<br>nhân</html>");
        latest.setText("<html>Mới<br>nhất</html>");
        
        // Set icons for buttons
        solo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/person-20.png")));
        team.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team-20.png")));
        date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/date-20.png")));
        latest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alarm-20.png")));
        
        rightPanel.add(sortText);
        rightPanel.add(solo);
        rightPanel.add(team);
        rightPanel.add(date);
        rightPanel.add(latest);
        
        return rightPanel;
    }
    
    public JPanel LeftPanel(){
        
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        
        SpringLayout layout = new SpringLayout();
        leftPanel.setLayout(layout);
        leftPanel.setPreferredSize(new Dimension(350, 100));
       
        //create label to hold search icon
        JLabel searchIcon = new JLabel();
        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tag-24.png")));
        
        //comboBox --> replace comboBox with multi selection JComboBox
        FlatMacLightLaf.setup();
        ComboBoxMultiSelection tagComboBox = new ComboBoxMultiSelection();
        DatabaseConnection dbc = new DatabaseConnection();
        String[] tags = dbc.getAllTags();
        tagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(tags));
        
        leftPanel.add(searchIcon);
        leftPanel.add(tagComboBox);
        
        //Add constraints to StringLayout panel
        layout.putConstraint(SpringLayout.WEST, searchIcon, 5, SpringLayout.WEST, leftPanel);
        layout.putConstraint(SpringLayout.NORTH, searchIcon, 5, SpringLayout.NORTH, leftPanel);
        layout.putConstraint(SpringLayout.WEST, tagComboBox, 18, SpringLayout.EAST, searchIcon);
        layout.putConstraint(SpringLayout.NORTH, tagComboBox, 5, SpringLayout.NORTH, leftPanel);
        layout.putConstraint(SpringLayout.EAST, tagComboBox, -5, SpringLayout.EAST, leftPanel); // Constraint for width
        layout.putConstraint(SpringLayout.SOUTH, tagComboBox, -5, SpringLayout.SOUTH, leftPanel); // Constraint for height

        return leftPanel;
    } 
}

