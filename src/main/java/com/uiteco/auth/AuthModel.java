/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 *
 * @author nddmi
 */
public class AuthModel {

    private byte[] passwordHash;
    private byte[] salt;
    private boolean loggedIn;
    private PropertyChangeSupport propertyChangeSupport;

    public AuthModel() {
        setPropertyChangeSupport(new PropertyChangeSupport(this));
        setLoggedIn(false);
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public byte[] getSalt() {
        return salt;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setLoggedIn(boolean loggedIn) {
        boolean oldValue = isLoggedIn();
        this.loggedIn = loggedIn;
        propertyChangeSupport.firePropertyChange("loggedIn", oldValue, loggedIn);
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

}
