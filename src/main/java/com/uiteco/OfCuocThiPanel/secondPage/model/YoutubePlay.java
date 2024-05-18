package com.uiteco.OfCuocThiPanel.secondPage.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public YoutubePlay(ImageIcon thumbnail, URI uri) {
        
        // URI for the YouTube video
        //final URI uri = new URI("https://www.youtube.com/watch?v=pMR_48AF-A0&list=PL_6klLfS1WqE1-_MJgZiJqAaccjLGHh0H&index=1");
        
        //ImageIcon thumbnail = new ImageIcon(new URL("http://i3.ytimg.com/vi/-mO43N7EBCE/hqdefault.jpg"));
        
        // Define the constant size for the thumbnail label
        int thumbnailWidth = 480;
        int thumbnailHeight = 360;
        
        // Create the thumbnail label
        //thumbnail = new ImageIcon(getClass().getResource("/hqdefault.jpg"));
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
    
    private ImageIcon thumbnail;
    private URI uri;
}

