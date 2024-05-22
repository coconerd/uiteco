package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends BriefPost_Model{

    /**
     * @return the urlYT
     */
    public List<String> getUrlYT() {
        return urlYT;
    }

    /**
     * @param urlYT the urlYT to set
     */
    public void setUrlYT(List<String> urlYT) {
        this.urlYT = urlYT;
    }


    public List<ImageIcon> getImages() {
        return images;
    }

    public ImageIcon getThumbnailYT() {
        return thumbnailYT;
    }

    public void setImages(List<ImageIcon> images) {
        this.images = images;
    }

    public void setThumbnailYT(ImageIcon thumbnailYT) {
        this.thumbnailYT = thumbnailYT;
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
    protected ImageIcon thumbnailYT;
    private List<String> urlYT;

    public DetailedOnePost_Model() {
    }
    
}