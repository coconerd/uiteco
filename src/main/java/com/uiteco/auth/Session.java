/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
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

    
    private TaiKhoanModel user;
    private boolean permitted;
    private Map<byte[], Boolean> permittedKeys;
    private byte[] accesskey;
    
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
    
    public TaiKhoanModel getUser() {
        return this.user;
    }

    public boolean isPermitted() {
        return permitted;
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
    
    public void setUser(TaiKhoanModel user, Permissible permissbile) throws PermissibleNotPermittedException {
        if (!isComponentPermitted(permissbile)) {
            throw new PermissibleNotPermittedException();
        }
        
        this.user = user;
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
