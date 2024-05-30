package com.uiteco.OfCuocThiPanel.secondPage;

import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.util.List;
import javax.swing.ImageIcon;

public class DetailedOnePost_Model extends BriefPost_Model {

    /**
     * @return the urlThumbnailYT
     */
    public List<String> getUrlThumbnailYT() {
        return urlThumbnailYT;
    }

    /**
     * @return the urlVideoYT
     */
    public List<String> getUrlVideoYT() {
        return urlVideoYT;
    }

    /**
     * @param urlThumbnailYT the urlThumbnailYT to set
     */
    public void setUrlThumbnailYT(List<String> urlThumbnailYT) {
        this.urlThumbnailYT = urlThumbnailYT;
    }

    /**
     * @param urlVideoYT the urlVideoYT to set
     */
    public void setUrlVideoYT(List<String> urlVideoYT) {
        this.urlVideoYT = urlVideoYT;
    }

    public List<ImageIcon> getImages() {
        return images;
    }

    public void setImages(List<ImageIcon> images) {
        this.images = images;
    }

    public String getCountLike_Update() {
        return Integer.toString(getCountLike());
    }

    public DetailedOnePost_Model(List<ImageIcon> images, List<String> urlVideoYT, List<String> urlThumbnailYT) {
        this.images = images;
        this.urlVideoYT = urlVideoYT;
        this.urlThumbnailYT = urlThumbnailYT;
    }

    private List<ImageIcon> images;
    private List<String> urlVideoYT;
    private List<String> urlThumbnailYT;

    public DetailedOnePost_Model() {
    }

}
