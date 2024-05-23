/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class DataUtils {

    public static byte[] convertImageIconToBytes(ImageIcon imageIcon) throws IOException {
        // Get the image from the ImageIcon
        Image image = imageIcon.getImage();

        // Convert the Image to BufferedImage
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);

        // Write the BufferedImage to ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", baos);

        // Convert the ByteArrayOutputStream to byte[]
        return baos.toByteArray();
    }

    public static ImageIcon convertBytesToImageIcon(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Image image = ImageIO.read(bais);
        return new ImageIcon(image);
    }

    public static ImageIcon blobToImageIcon(Blob Blob) throws SQLException, IOException {
        InputStream is = Blob.getBinaryStream(1, Blob.length());
        Image image = ImageIO.read(is);
        is.close();
        return new ImageIcon(image);
    }
}
