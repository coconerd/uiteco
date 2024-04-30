/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author nddmi
 */
public class AuthDAO {

    public static final String PBE_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA256";
    public static final int PBE_DERIVATION_SALT_LENGTH = 16; // bytes;
    public static final int PBE_DERIVATIONKEY_KEY_LENGTH = 16; // bytes

    public static byte[] genSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }

    public static byte[] deriveKey(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        int iterations = 65536;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, PBE_DERIVATIONKEY_KEY_LENGTH * 8);

        SecretKeyFactory factory = SecretKeyFactory.getInstance(PBE_DERIVATION_ALGORITHM);
        SecretKey sk = factory.generateSecret(spec);

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
//        System.out.println("Enter password to register: ");
//        String password = sc.nextLine();
//        try {
//            salt = genSalt();
//            passwordHash = deriveKey(password, salt);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Register successful");
    }

    public static void login(String username, String email, String password) {
        try {
            // salt == ; retrieve the salt from db
            // retrieve passwordHash from db
            byte[] passwordHash = new byte[16];
            byte[] salt = new byte[16];
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
}
