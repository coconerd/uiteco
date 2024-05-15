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

    public static final int MIN_USERNAME_LEN = 4;
    public static final int MAX_USERNAME_LEN = 40;
    public static final int MIN_PASSWORD_LEN = 8;
    public static final int MAX_PASSWORD_LEN = 32;
    
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
            com.uiteco.main.App.getSession().setEmail(email);
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
            com.uiteco.main.App.getSession().setUsername(username);
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
        if (!(len >= MIN_USERNAME_LEN && len <= MAX_USERNAME_LEN)) {
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
        if (!(len >= MIN_PASSWORD_LEN && len <= MAX_PASSWORD_LEN)) {
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
