/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

/**
 *
 * @author nddmi
 */
public class BadCredentialsFormatException extends Exception {
    public static enum BAD {EMAIL, USERNAME, PASSWORD};
    private BAD creds;
    
    public BadCredentialsFormatException(BAD creds) {
        super("Thông tin đăng nhập không đúng format");
        this.creds = creds;
    }

    public BAD getCreds() {
        return creds;
    }
    
    @Override
    public String getMessage() {
        String error;
        if (getCreds() == BAD.EMAIL) {
            error = "Email phải có định dạng xxxxxxxx@gm.uit.edu.vn";
        } else if (getCreds() == BAD.USERNAME) {
            error = "Username phải có độ dài 4 - 15 ký tự và chỉ có chữ/số";
        } else {
            error = "Mật khẩu phải có độ dài từ 8 - 32 ký tự";
        }
        
        return error;
    }
    
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println(getMessage());
    }
}
