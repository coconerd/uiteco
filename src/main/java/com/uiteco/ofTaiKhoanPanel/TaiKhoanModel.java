/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class TaiKhoanModel {

    public static enum ACCOUNT_TYPE {
        admin, sinhvien, cuusinhvien, giangvien
    };

    // User info
    private String username;
    private String email;
    private Long issuedAt; // Unix timestamp
    private ACCOUNT_TYPE accountType;
    private int accountID;
    private ImageIcon avatar;
    private LocalDate accountCreationDate;
    private LocalDateTime lastAccess;
    private String fullname;
    private String phone;
    private String country;
    private String province;
    private String timezone;
    private String intro;

    // Sinhvien
    private String faculty;
    private String mssv;

    /**
     * Getter methods
     */
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getIssuedAt() {
        return issuedAt;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getMssv() {
        return mssv;
    }

    public String getFaculty() {
        return faculty;
    }

    public ACCOUNT_TYPE getAccountType() {
        return accountType;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public ImageIcon getAvatar() {
        return this.avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public String getShortName() {
        String[] parts = fullname.split(" ");
        StringBuilder abbreviatedName = new StringBuilder();

        for (int i = 0; i < parts.length - 1; i++) {
            abbreviatedName.append(parts[i].charAt(0)).append(". ");
        }

        abbreviatedName.append(parts[parts.length - 1]);
        return abbreviatedName.toString();
    }

    public String getPhone() {
        return this.phone;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getIntro() {
        return intro;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    /**
     * Setter methods
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIssuedAt(Long issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setAccountType(ACCOUNT_TYPE accountType) {
        this.accountType = accountType;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }
}
