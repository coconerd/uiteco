/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.FileNotFoundException;

/**
 *
 * @author nddmi
 */
public class Session implements PropertyChangeListener {

    public static final String SESSION_FILE_NAME = "session.properties";
    public static final long SESSION_DURATION = 14 * 24 * 60 * 60; // 14 days in seconds;

    private boolean permitted;
//    private boolean fileFound;

    private String username;
    private String email;
    private Long issuedAt; // Unix timestamp

    private PropertyChangeSupport propertyChangeSupport;

    public Session() {
        setPropertyChangeSupport(new PropertyChangeSupport(this));
        Properties properties = new Properties();
//        try (InputStream input = this.getClass().getResourceAsStream(SESSION_FILE_NAME)) {
//            if (input == null) {
//                setFileFound(false);
//                setPermitted(false);
//                System.err.println("Session file not found. Login is required");
//            } else {
//                properties.load(input);
//                setFileFound(true);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (fileFound) {
//            username = properties.getProperty("session.username", null);
//            email = properties.getProperty("session.email", null);
//            issuedAt = Long.valueOf(properties.getProperty("session.issuedAt", null));
//
//            if (username == null || email == null || issuedAt == null) {
//                permitted = false;
//                System.err.println("Faulty session file. One of the fields is missing/incorrect");
//
//            } else {
//                System.out.println("Retrieved user's credentials successfully");
//
//                // Check if session hasn't expired
//                long timestamp = System.currentTimeMillis() / 1000;
//                permitted = timestamp <= (issuedAt + SESSION_DURATION) ? true : false;
//                if (permitted) {
//                    System.out.println("Session is still valid");
//                } else {
//                    System.out.println("Session has epxired. Please login again");
//                }
//            }
//        }
    }

    public void saveSession(String email, String username) {
//        this.email = email;
//        this.username = username;
//        this.issuedAt = System.currentTimeMillis() / 1000;
//        File sessionFile;
//
//        try {
//            sessionFile = new File(this.getClass().getResource(SESSION_FILE_NAME).toURI());
//            if (sessionFile == null) {
//                sessionFile.createNewFile();
//            }
//
//            try {
//                FileOutputStream output = new FileOutputStream(sessionFile);
//                Properties properties = new Properties();
//
//                // Set properties
//                properties.setProperty("session.username", getUsername());
//                properties.setProperty("session.email", getEmail());
//                properties.setProperty("session.issuedAt", String.valueOf(getIssuedAt()));
//
//                // Save properties to project root directory
//                properties.store(output, null);
//
//                // Set file to read-only on Windows
//                if (sessionFile.setReadOnly()) {
//                    System.out.println("Session file set to read-only.");
//                } else {
//                    System.err.println("Failed to set session file to read-only.");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("loggedIn")) {
            if ((boolean) evt.getNewValue() == true) {
                setPermitted(true);
            }
        }
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void setPermitted(boolean permitted) {
        boolean oldValue = isPermitted();
        this.permitted = permitted;
        this.propertyChangeSupport.firePropertyChange("permitted", oldValue, permitted);
    }

//    private void setFileFound(boolean fileFound) {
//        this.fileFound = fileFound;
//    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setIssuedAt(Long issuedAt) {
        this.issuedAt = issuedAt;
    }

    private void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }
}
