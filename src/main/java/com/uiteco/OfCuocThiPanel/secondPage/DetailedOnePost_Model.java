package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends BriefPost_Model{

    public List<String> getUrlYT() {
        return urlYT;
    }

    public void setUrlYT(List<String> urlYT) {
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

    public DetailedOnePost_Model(List<String> urlYT) {
        this.urlYT = urlYT;
    }

    public DetailedOnePost_Model(List<ImageIcon> images, List<String> urlYT) {
        this.images = images;
        this.urlYT = urlYT;
    }

    
    protected List<ImageIcon> images;
    private List<String> urlYT;
    //private DefaultTableModel modelTable;
    
    
    public DetailedOnePost_Model() {
    }
    
}