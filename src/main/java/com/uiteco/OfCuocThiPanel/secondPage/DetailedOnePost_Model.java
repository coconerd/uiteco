package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends BriefPost_Model{

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlYT() {
        return urlYT;
    }

    public void setUrlYT(String urlYT) {
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
        return Integer.toString(countLike);
    }
    
    protected List<ImageIcon> images;
    protected ImageIcon thumbnailYT;
    protected String urlYT;
    protected String content;
}