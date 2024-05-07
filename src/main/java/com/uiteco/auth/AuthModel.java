/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

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

    private void setEmailOrThrow(String inputEmail) throws BadCredentialsFormatException {
        int len = inputEmail.length();
        
        if (len <= 14) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.EMAIL);
        }
        
        String postfix = inputEmail.substring(len - 14, len);
        if (!postfix.equals("@gm.uit.edu.vn")) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.EMAIL);
        }
        
        this.email = inputEmail;
    }

    private void setUsernameOrThrow(String inputUsername) throws BadCredentialsFormatException {
        int len = inputUsername.length();
        if (!(len >= 4 && len <= 15)) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.USERNAME);
        }
        
        String regex = "^[a-zA-Z0-9]*$"; 
        if (!Pattern.matches(regex, inputUsername)) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.USERNAME);
        }
        
        this.username = inputUsername;
    }

    private void setPasswordOrThrow(String inputPassword) throws BadCredentialsFormatException {
        int len = inputPassword.length();
        if (!(len >= 8 && len <= 32)) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.PASSWORD);
        }
        
        this.password = inputPassword;
    }

    private void setLoggedIn(boolean loggedIn) {
        boolean oldValue = isLoggedIn();
        this.loggedIn = loggedIn;
        propertyChangeSupport.firePropertyChange("loggedIn", oldValue, loggedIn);
    }

}
