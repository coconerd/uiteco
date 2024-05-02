/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/**
 *
 * @author nddmi
 */
public class TestAuth {

    public static byte[] passwordHash;
    public static Scanner sc = new Scanner(System.in);
    public static byte[] salt;

    public class Session {

        private long epxirationTime; // Expiration time in seconds
        private String username;

        public long getExpirationTime() {
            return this.epxirationTime;
        }

        public void setExpirationTime(long expirationTime) {
            this.epxirationTime = expirationTime;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static byte[] genSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        
        return salt;
    }

    public static byte[] deriveKey(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        int keyLength = 128;
        int iterations = 65536;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey sk = factory.generateSecret(spec);
        System.out.println("Format of sk: " + sk.getFormat());
        System.out.println(sk.getAlgorithm());
        
        return sk.getEncoded();
    }

    public static boolean compareKeys(byte[] key1, byte[] key2) {
        if (key1.length != key2.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < key1.length; i++) {
            result |= key1[i] ^ key2[i];
        }
        return result == 0;
    }

    public static void register() {
        System.out.println("Enter password to register: ");
        String password = sc.nextLine();
        try {
            salt = genSalt();
            passwordHash = deriveKey(password, salt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Register successful");
    }

    public static void login() {
        System.out.println("Enter password to login: ");
        String password = sc.nextLine();
        try {
            byte[] toBeVerified = deriveKey(password, salt);
            if (compareKeys(toBeVerified, passwordHash) == true) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed: invalid credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            register();
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
