package com.uiteco.OfCuocThiPanel.secondPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class YoutubePlay extends JPanel {

    public ImageIcon getThumbnail() {
        return thumbnail;
    }

    public URI getUri() {
        return uri;
    }

    public void setThumbnail(ImageIcon thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    private static void open(URI uri) throws IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(uri);
        } else {
            // Handle case where Desktop is not supported
            Logger logger = Logger.getLogger(YoutubePlay.class.getName());
            logger.info("Desktop is not supported.");
        }
    }

    public YoutubePlay() {
        
        try {
            // URI for the YouTube video
            uri = new URI("https://www.youtube.com/watch?v=pMR_48AF-A0&list=PL_6klLfS1WqE1-_MJgZiJqAaccjLGHh0H&index=1");
        } catch (URISyntaxException ex) {
            Logger.getLogger(YoutubePlay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ImageIcon thumbnail = new ImageIcon(new URL("http://i3.ytimg.com/vi/-mO43N7EBCE/hqdefault.jpg"));
        
        // Define the constant size for the thumbnail label
        int thumbnailWidth = 480;
        int thumbnailHeight = 360;
        
        // Create the thumbnail label
        thumbnail = new ImageIcon(getClass().getResource("/hqdefault.jpg"));
        JLabel thumbnailLabel = new JLabel(thumbnail);
        thumbnailLabel.setPreferredSize(new Dimension(thumbnailWidth, thumbnailHeight));
        
        // Create the play button icon
        ImageIcon playButtonIcon = new ImageIcon(getClass().getResource("/youtube-play-icon.png"));
        JLabel playButtonLabel = new JLabel(playButtonIcon);
        
        // Create the panel to contain playButton
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridBagLayout());
        
        // Set the constraints for the play button label
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; //be placed in the first column
        constraints.gridy = 0; //be placed in the first row (index 0) of the grid
        constraints.anchor = GridBagConstraints.CENTER;
        
        // Add the play button label to the panel with the specified constraints
        panel.add(playButtonLabel, constraints);
        
        // Add the panel to the thumbnail label
        thumbnailLabel.setLayout(new BorderLayout());
        thumbnailLabel.add(panel, BorderLayout.CENTER);
        
        // Add the thumbnail label to the frame
        add(thumbnailLabel);
        setVisible(true);
        
        // Add mouse listener to open the video when the thumbnail is clicked
        thumbnailLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    open(uri);
                } catch (IOException ex) {
                    Logger.getLogger(YoutubePlay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    public static void downloadFile(String fileURL, String saveDir) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileURL);

        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                // Extracts the content and saves it to a file
                try (InputStream inputStream = entity.getContent();
                     FileOutputStream outputStream = new FileOutputStream(saveDir)) {

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
    
    private ImageIcon thumbnail;
    private URI uri;
}

