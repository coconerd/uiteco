/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import com.uiteco.ofSuKienPanel.SuKienDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

import static com.uiteco.ofSuKienPanel.SuKienDAO.loadImagesFromFolder;
import static com.uiteco.ofSuKienPanel.SuKienDAO.createSuKien;
import static com.uiteco.ofSuKienPanel.SuKienDAO.getAllTags;
import static com.uiteco.database.mock.InsertTAIKHOAN.getRandomAccountID;
import static com.uiteco.database.mock.InsertTAIKHOAN.getAllAccountIDs;
import static com.uiteco.database.mock.InsertCAULACBO.getAllClubIDs;
import static com.uiteco.database.mock.InsertCAULACBO.getRandomClubID;
import static com.uiteco.database.mock.InsertCAULACBO.getRandomDateInPast;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author nddmi
 */
public class InsertBAIDANG {

    public static void insertBAIDANG() throws Exception {
        String imagePath = "D:\\DoAn\\database\\mock\\ImagesOfSuKien"; // Replace with your folder path
        String contentPath = "D:\\DoAn\\database\\mock\\content"; // Replace with your folder path
        List<String> fileContents = readAllContents(contentPath);
        List<ImageIcon> images = loadImagesFromFolder(imagePath);
        Set<String> tags = getAllTags();
        List<Integer> accountIDs = getAllAccountIDs();
        List<Integer> clubIDs = getAllClubIDs();

        for (int i = 0; i < 300; i++) {
            String title = "Đây là sự kiện thứ " + String.valueOf(i + 1);
            createSuKien(
                    1,
                    title,
                    getRandomContent(fileContents),
                    getRandomAccountID(accountIDs),
                    getRandomTags(tags),
                    getRandomImages(images),
                    getRandomThumbnail(images),
                    getRandomClubID(clubIDs),
                    i % 2 == 0,
                    i % 2 == 0 ? i : null,
                    i % 2 == 0 ? getRandomDateInPast() : null,
                    i % 2 == 0 ? LocalDate.now().plusDays(7) : null,
                    null
            );
        }
    }

    public static Set<String> getRandomTags(Set<String> originalTags) {
        // Convert the original set to a list
        List<String> list = new ArrayList<>(originalTags);

        // Determine the number of elements to select (between 1 and 3, inclusive)
        int selectQuantity = new Random().nextInt(Math.min(3, originalTags.size())) + 1;

        // Shuffle the list to randomize the order
        Collections.shuffle(list);

        // Create a new set to hold the randomly selected elements
        Set<String> randomSubset = new HashSet<>();

        // Add the randomly selected elements to the new set
        for (int i = 0; i < selectQuantity; i++) {
            randomSubset.add(list.get(i));
        }

        return randomSubset;
    }

    public static List<String> readAllContents(String folderPath) {
        List<String> fileContents = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*.txt")) {
            for (Path entry : stream) {
                String content = new String(Files.readAllBytes(entry));
                fileContents.add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContents;
    }

    public static String getRandomContent(List<String> contents) {
        if (contents == null || contents.isEmpty()) {
            return null; // Or throw an exception if preferred
        }
        Random random = new Random();
        int randomIndex = random.nextInt(contents.size());
        return contents.get(randomIndex);
    }

    public static ImageIcon getRandomThumbnail(List<ImageIcon> images) {
        if (images == null || images.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randIndex = random.nextInt(images.size());
        return images.get(randIndex);
    }

    public static List<ImageIcon> getRandomImages(List<ImageIcon> imageIcons) {
        if (imageIcons == null || imageIcons.isEmpty()) {
            return Collections.emptyList(); // Return an empty list or handle it appropriately
        }
        int numberOfImages = imageIcons.size();
        int randomCount = new Random().nextInt(3) + 3; // Random number between 3 and 5

        // Ensure we don't request more images than are available
        if (numberOfImages < randomCount) {
            randomCount = numberOfImages;
        }

        Collections.shuffle(imageIcons); // Shuffle the list to randomize
        return new ArrayList<>(imageIcons.subList(0, randomCount)); // Return the sublist
    }

    public static int getRandomAccountId(List<Integer> accountIDs) {
        if (accountIDs == null || accountIDs.isEmpty()) {
            return 1;
        }
        Random random = new Random();
        int randIndex = random.nextInt(accountIDs.size());
        return accountIDs.get(randIndex);
    }

    public static void main(String[] args) {
        String folderPath = "D:\\DoAn\\database\\mock\\content"; // Replace with your folder path
        List<String> fileContents = readAllContents(folderPath);
        String random = getRandomContent(fileContents);
        System.out.print(random);

    }
}
