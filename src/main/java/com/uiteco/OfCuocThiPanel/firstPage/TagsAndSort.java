package com.uiteco.OfCuocThiPanel.firstPage;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.uiteco.OfCuocThiPanel.secondPage.CustomButton;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.uiteco.OfCuocThiPanel.Components.comboBox.ComboBoxMultiSelection;
import com.uiteco.components.RoundedBorder;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class TagsAndSort extends JPanel {

    /**
     * @return the tagComboBox
     */
    public ComboBoxMultiSelection getTagComboBox() {
        return tagComboBox;
    }

    /**
     * @param tagComboBox the tagComboBox to set
     */
    public void setTagComboBox(ComboBoxMultiSelection tagComboBox) {
        this.tagComboBox = tagComboBox;
    }

    /**
     * @return the date
     */
    public CustomButton getDate() {
        return date;
    }

    /**
     * @return the hotest
     */
    public CustomButton getHotest() {
        return hotest;
    }

    /**
     * @return the solo
     */
    public CustomButton getSolo() {
        return solo;
    }

    /**
     * @return the team
     */
    public CustomButton getTeam() {
        return team;
    }

    public TagsAndSort() {
        initTagAndSort();

    }

    private CustomButton date, team, solo, hotest;
    private ComboBoxMultiSelection tagComboBox;

    public void initTagAndSort() {

        setLayout(new BorderLayout());
        setBounds(30, 20, 1170, 60);
        setBackground(Color.WHITE);

        RoundedBorder roundBor = new RoundedBorder(new Color(242, 243, 244), Color.WHITE, Color.WHITE, 15, 0);
        setBorder(roundBor);

        setOpaque(true); //display background color (white) in TagsAndSort panel
        add(RightPanel(), BorderLayout.LINE_END);
        add(LeftPanel(), BorderLayout.LINE_START);
    }

    public JPanel RightPanel() {

        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, -7)); //a horizontal gap of 10 pixels between each component

        JLabel sortText = new JLabel("Sort: ");
        sortText.setFont(new Font("Arial", BOLD, 17)); //17 is the size of text
        date = new CustomButton();
        team = new CustomButton();
        solo = new CustomButton();
        hotest = new CustomButton();

        date.addActionListener((e) -> {
            date.setSelected(true);
        });

        team.addActionListener((e) -> {
            team.setSelected(true);
        });
        solo.addActionListener((e) -> {
            solo.setSelected(true);
        });

        hotest.addActionListener((e) -> {
            hotest.setSelected(true);
        });

        getDate().setText("<html>Đến<br>hạn</html>");
        getTeam().setText("<html>Đội<br>nhóm</html>");
        getSolo().setText("<html>Cá<br>nhân</html>");
        getHotest().setText("<html>Hot<br>nhất</html>");

        // Set icons for buttons
        getSolo().setIcon(new javax.swing.ImageIcon(getClass().getResource("/person-20.png")));
        getTeam().setIcon(new javax.swing.ImageIcon(getClass().getResource("/team-20.png")));
        getDate().setIcon(new javax.swing.ImageIcon(getClass().getResource("/date-20.png")));
        getHotest().setIcon(new javax.swing.ImageIcon(getClass().getResource("/alarm-20.png")));

        rightPanel.add(sortText);
        rightPanel.add(getSolo());
        rightPanel.add(getTeam());
        rightPanel.add(getDate());
        rightPanel.add(getHotest());

        return rightPanel;
    }

    public JPanel LeftPanel() {

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
        setTagComboBox(new ComboBoxMultiSelection());

        List<String> tags = CuocThiDAO.getAllTags();
        String[] tagsList = tags.toArray(String[]::new);
        getTagComboBox().setModel(new javax.swing.DefaultComboBoxModel(tagsList));

        getTagComboBox().setPreferredSize(new Dimension(300, 27));
        leftPanel.add(searchIcon);
        leftPanel.add(getTagComboBox());

        //Add constraints to StringLayout panel
        layout.putConstraint(SpringLayout.WEST, searchIcon, 5, SpringLayout.WEST, leftPanel);
        layout.putConstraint(SpringLayout.NORTH, searchIcon, 5, SpringLayout.NORTH, leftPanel);
        layout.putConstraint(SpringLayout.WEST, getTagComboBox(), 10, SpringLayout.EAST, searchIcon);
        layout.putConstraint(SpringLayout.NORTH, getTagComboBox(), 3, SpringLayout.NORTH, leftPanel);

        return leftPanel;
    }
}
