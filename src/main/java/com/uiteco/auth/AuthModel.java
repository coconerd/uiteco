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

    private String email;
    private String username;
    private String password;
    private boolean loggedIn;
    private PropertyChangeSupport propertyChangeSupport;

    public AuthModel() {
        setPropertyChangeSupport(new PropertyChangeSupport(this));
        this.loggedIn = false;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void loginWithEmail(String email, String password) throws Exception {
        boolean hasEmail = (email != null && !email.equals(""));
        boolean hasPassword = (password != null && !password.equals(""));

        if (!(hasEmail && hasPassword)) {
            throw new MissingCredentialsException();
        }

        try {
            setEmailOrThrow(email);
            setPasswordOrThrow(password);
            AuthDAO.login(getUsername(), getEmail(), getPassword());
            setLoggedIn(true);
        } catch (Exception e) {
            throw e;
        }
    }

    public void loginWithUsername(String username, String password) throws Exception {
        boolean hasUsername = (username != null && !username.equals(""));
        boolean hasPassword = (password != null && !password.equals(""));

        if (!(hasUsername && hasPassword)) {
            throw new MissingCredentialsException();
        }

        // Verify and set credentials
        try {
            setUsernameOrThrow(username);
            setPasswordOrThrow(password);
            AuthDAO.login(getUsername(), getEmail(), getPassword());
            setLoggedIn(true);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    private void setEmailOrThrow(String email) throws BadCredentialsFormatException {
        this.email = email;
    }

    private void setUsernameOrThrow(String username) throws BadCredentialsFormatException {
        this.username = username;

    }

    private void setPasswordOrThrow(String password) throws BadCredentialsFormatException {
        this.password = password;
    }

    private void setLoggedIn(boolean loggedIn) {
        boolean oldValue = isLoggedIn();
        this.loggedIn = loggedIn;
        propertyChangeSupport.firePropertyChange("loggedIn", oldValue, loggedIn);
    }

}
