/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofSuKienPanel.detailed;


import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 *
 * @author nddmi
 */
public class GalleryModel {
    private int windowSize;
    private int windowStart;
    private ArrayList<ImageIcon> images;
    private PropertyChangeSupport propertyChangeSupport;
    
    public GalleryModel() {
        setPropertyChangeSupport(new PropertyChangeSupport(this));
        setImages(new ArrayList<ImageIcon>());
        setWindowStart(0);
    }

    public int getWindowSize() {
        return windowSize;
    }

    public int getWindowStart() {
        return windowStart;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public ImageIcon getImage(int index) {
        return images.get(index);
    }
    
    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public void setWindowStart(int windowStart) {
        this.windowStart = windowStart;
    }

    public void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
    }
    
    public void setImage(int index, ImageIcon image) {
        this.images.set(index, image);
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
