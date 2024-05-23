/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.detailed.rightPanel;

import javax.swing.Icon;

/**
 *
 * @author nddmi
 */
public class ProfileLineModel {
    private String fullname;
    private Icon avatar;
    
    public ProfileLineModel() {
        
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public void setAvatar(Icon avtar) {
        this.avatar = avatar;
    }
    
    public Icon getAvatar() {
        return this.avatar;
    }
    
    public String getFullname() {
        return this.fullname;
    }
}
