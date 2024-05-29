package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends BriefPost_Model{

    public String getUrlYT() {
        return urlYT;
    }

    public void setUrlYT(String urlYT) {
        this.urlYT = urlYT;
    }

    public List<ImageIcon> getImages() {
        return images;
    }

    public void setImages(List<ImageIcon> images) {
        this.images = images;
    }

    public String getCountLike_Update(){
        return Integer.toString(getCountLike());
    }

    public DetailedOnePost_Model(String urlYT) {
        this.urlYT = urlYT;
    }

    public DetailedOnePost_Model(List<ImageIcon> images, String urlYT) {
        this.images = images;
        this.urlYT = urlYT;
    }

    
    protected List<ImageIcon> images;
    private String urlYT;
    
    
    public DetailedOnePost_Model() {
    }
    
}