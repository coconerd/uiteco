/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uiteco.auth;

/**
 *
 * @author nddmi Classes that implements Permissible interface is a candidate to
 * be authorized by App.session object
 *
 * Note: It's just a candidate but not actually authorized if getAccessKey()
 * matches with App.session's private access key
 */
public interface Permissible {

    public byte[] getAccessKey();

    public void setAccessKey(byte[] accessKey);
}
