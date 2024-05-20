/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class Session {

    public static final String SESSION_FILE_NAME = "session.properties";
    public static final long SESSION_DURATION = 14 * 24 * 60 * 60; // 14 days in seconds;

    public static enum ACCOUNT_TYPE {
        admin, sinhvien, cuusinhvien, giangvien
    };

    private boolean permitted;
    private Map<byte[], Boolean> permittedKeys;
    private byte[] accesskey;

    // User info
    private String username;
    private String email;
    private Long issuedAt; // Unix timestamp
    private ACCOUNT_TYPE accountType;
    private int accountID;
    private ImageIcon avatar;
    private LocalDate accountCreationDate;
    private String fullname;
    private String phone;

    private String mssv;

    private PropertyChangeSupport propertyChangeSupport;

    public Session() {
        _init();
    }

    /**
     *
     * @param sessionManager The first Permissible instance that would be
     * granted private access to the current session instance.
     */
    public Session(Permissible sessionManager) {
        _init();
        _permitComponent(sessionManager);

    }

    public boolean isPermitted() {
        return permitted;
    }

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

    public String getPhone() {
        return this.phone;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * The following section consists of pseudo-public setter functions and
     * other function (public visibility but safe-guarded by requiring the
     * Permissible parameter to be permitted to continue execution)
     *
     * @param permitted
     */
    public void setPermitted(boolean permitted, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        boolean oldValue = isPermitted();
        this.permitted = permitted;
        this.propertyChangeSupport.firePropertyChange("permitted", oldValue, permitted);
    }

    public void setUsername(String username, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.username = username;
    }

    public void setEmail(String email, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.email = email;
    }

    public void setIssuedAt(Long issuedAt, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.issuedAt = issuedAt;
    }

    public void setAccountType(ACCOUNT_TYPE accountType, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.accountType = accountType;
    }

    public void setAccountID(int accountID, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.accountID = accountID;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.accountCreationDate = accountCreationDate;
    }

    public void setAvatar(ImageIcon avatar, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.avatar = avatar;
    }

    public void setMssv(String mssv, Permissible permissible) throws PermissibleNotPermittedException {
        if (getAccountType() != ACCOUNT_TYPE.sinhvien && getAccountType() != ACCOUNT_TYPE.cuusinhvien) {
            System.err.println("NOT sinh vien");
            return;
        }

        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.mssv = mssv;
    }

    public void setFullname(String fullname, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.fullname = fullname;
    }

    public void setPhone(String phone, Permissible permissible) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissible)) {
            throw new PermissibleNotPermittedException();
        }

        this.phone = phone;
    }

    public void permitComponent(Permissible permitter, Permissible permittee) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permitter)) {
            throw new PermissibleNotPermittedException();
        }

        _permitComponent(permittee);
    }

    public void revokeComponent(Permissible permitter, Permissible permittee) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permitter)) {
            throw new PermissibleNotPermittedException();
        }

        _revokeComponent(permittee);
    }

    public boolean isComponentPermitted(Permissible permissible) {
        Boolean val = permittedKeys.get(permissible.getAccessKey());
        if (val == null) {
            return false;
        }
        return val;
    }

    /**
     * Private functions
     */
    /**
     * Register private access rights for an instance of interface Permissible
     * as
     */
    private void _permitComponent(Permissible permissible) {
        byte[] permittedKey = _genPrivateKey(32);
        permittedKeys.put(permittedKey, true);
        permissible.setAccessKey(permittedKey);
    }

    private void _revokeComponent(Permissible permissible) {
        permittedKeys.put(permissible.getAccessKey(), true);
    }

    private byte[] _genPrivateKey(int bytes) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[bytes]; // bytes * 8 bits
        secureRandom.nextBytes(key);
        return key;
    }

    private void _init() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.permittedKeys = new HashMap<byte[], Boolean>();
    }
}
