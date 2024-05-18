/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.auth;

/**
 *
 * @author nddmi
 */
public class PermissibleNotPermittedException extends Exception {

    public PermissibleNotPermittedException() {
        super("The instance of Permissible interface is not granted access rights to Session instance");
    }
}
