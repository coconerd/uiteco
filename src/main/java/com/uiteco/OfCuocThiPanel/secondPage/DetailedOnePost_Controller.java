package com.uiteco.OfCuocThiPanel.secondPage;

import com.bulenkov.iconloader.util.Pair;
import com.uiteco.OfCuocThiPanel.dataBase.CuocThiDAO;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import com.uiteco.main.App;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DetailedOnePost_Controller {

    public BriefPost_Model getBaseModel() {
        return baseModel;
    }

    public DetailedOnePost_Controller(DetailedOnePost_View view, BriefPost_Model baseModel) {
        this.view = view;
        this.baseModel = baseModel;

    }

    private final DetailedOnePost_View view;
    private final BriefPost_Model baseModel;

    public int getPostID() {
        return getBaseModel().getId();
    }

    public DetailedOnePost_View setData(BriefPost_Model baseModel) {
        view.jTitle.setText(baseModel.getTitle());
        view.getjRegisterTime().setText(baseModel.getDateRange_ForDetailedPage());
        view.jOrganizer.setText(baseModel.getOrganizer());
        view.jPostTime.setText(baseModel.getPostTime_String());
        view.jContent.setText(baseModel.getContent());
        view.jLike.setText(baseModel.getCountLike_String());
        if (baseModel.getType() == 2) {
            view.jRegister.setVisible(false);
        } else if (baseModel.getType() == 1) {
            view.jRegister.setVisible(true);
        }

        List<ImageIcon> imageList = CuocThiDAO.getAllImagesForPosts(baseModel.getId()).getImages();
        List<RoundImageUI> listImage = new ArrayList<>();
        for (ImageIcon i : imageList) {
            RoundImageUI r = new RoundImageUI();
            r.getjLabel1().setIcon(i);
            listImage.add(r);
        }

        for (Component c : listImage) {
            view.scrollPaneImages.getRoundedGradientPanel().add(c);

            view.scrollPaneImages.getRoundedGradientPanel().add(c);
            c.addMouseListener(new MouseListener() {

                @Override
                public void mousePressed(MouseEvent e) {
                    createDialog("Ảnh sự kiện", c);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });

        }

        List<Pair<URI, String>> pairUrls = CuocThiDAO.getvideoAndThumbnailYoutubeUrl(baseModel.getId());
        if (!pairUrls.isEmpty()) {
            for (Pair<URI, String> pair : pairUrls) {
                view.youtubePlay.setUri(pair.getFirst());
                ImageIcon thumbnail = downloadImageAndCreateIcon(pair.getSecond());
                view.youtubePlay.setThumbnail(thumbnail);
            }
        }

        view.revalidate();
        view.repaint();
        return view;
    }

    public static void downloadFile(String fileURL, String saveDir) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileURL);

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                // Extracts the content and saves it to a file
                try (InputStream inputStream = entity.getContent(); FileOutputStream outputStream = new FileOutputStream(saveDir)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("File downloaded to " + saveDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ImageIcon downloadImageAndCreateIcon(String imageUrl) {
        try {
            // Download the image file to a temporary location
            String tempFilePath = "temp_image.jpg";
            downloadFile(imageUrl, tempFilePath);

            // Read the downloaded image file and create an ImageIcon
            Image image = ImageIO.read(new URL("file://" + tempFilePath));
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createDialog(String dialogName, Component child) {
        JDialog dialog = new JDialog(App.getMainFrame(), dialogName, false);
        dialog.setLayout(new GridLayout(1, 1, 0, 0));
        dialog.setSize(child.getPreferredSize());
        dialog.add(child);
        dialog.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = dialog.getSize();
        dialog.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
    }

}
