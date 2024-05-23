/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import static com.uiteco.auth.AuthDAO.register;

/**
 *
 * @author nddmi
 */
public class RunMe {

    public static void main(String[] args) throws Exception {
        InsertTAIKHOAN.insertTaiKhoan();
        InsertCAULACBO.insertCAULACBO();
        InsertBAIDANG.insertBAIDANG();
    }
}
