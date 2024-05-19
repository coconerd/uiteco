package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.OnePost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends OnePost_Model{

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the urlYT
     */
    public String getUrlYT() {
        return urlYT;
    }

    /**
     * @param urlYT the urlYT to set
     */
    public void setUrlYT(String urlYT) {
        this.urlYT = urlYT;
    }

    /**
     * @return the images
     */
    public List<ImageIcon> getImages() {
        return images;
    }

    /**
     * @return the thumbnailYT
     */
    public ImageIcon getThumbnailYT() {
        return thumbnailYT;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<ImageIcon> images) {
        this.images = images;
    }

    /**
     * @param thumbnailYT the thumbnailYT to set
     */
    public void setThumbnailYT(ImageIcon thumbnailYT) {
        this.thumbnailYT = thumbnailYT;
    }
    
    private List<ImageIcon> images;
    private ImageIcon thumbnailYT;
    private String urlYT;
    private String content;
}