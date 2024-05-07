package com.uiteco.OfCuocThiPanel.firstPage;

import com.uiteco.components.RoundedPanel;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomLabel extends JPanel{

    public RoundedPanel getRoundedPanel() {
        return roundedPanel;
    }

    public JLabel getText() {
        return text;
    }

    public void setRoundedPanel(RoundedPanel roundedPanel) {
        this.roundedPanel = roundedPanel;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public CustomLabel(RoundedPanel roundedPanel, JLabel text) {
        this.roundedPanel = roundedPanel;
        this.text = text;
        roundedPanel.add(text);
    }
    
    private RoundedPanel roundedPanel;
    private JLabel text;
    
    
}
