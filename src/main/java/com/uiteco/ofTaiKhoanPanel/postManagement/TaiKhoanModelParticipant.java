/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel.postManagement;

import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
import java.time.LocalDateTime;

/**
 *
 * @author nddmi
 */
public class TaiKhoanModelParticipant extends TaiKhoanModel {

    private LocalDateTime enrolledAt;

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
