/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

/**
 *
 * @author nddmi
 */
public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException() {
        super("Thông tin đăng nhập sai!");
    }
}
