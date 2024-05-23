/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uiteco.database.mock;

import static com.uiteco.auth.AuthDAO.register;
import com.uiteco.database.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nddmi
 */
public class InsertTAIKHOAN {

    public static List<Integer> getAllAccountIDs() throws SQLException {
        List<Integer> accountIDS = new ArrayList<Integer>();

        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT MATK FROM TAIKHOAN";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("MATK");
            accountIDS.add(id);
        }

        return accountIDS;
    }

    public static Integer getRandomAccountID(List<Integer> accountsIDs) {
        if (accountsIDs == null || accountsIDs.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randIndex = random.nextInt(accountsIDs.size());
        return accountsIDs.get(randIndex);
    }

    public static void insertTaiKhoan() throws Exception {
        register("22520172@gm.uit.edu.vn", "congphan", "11111111", 2, "Phan Thành Công", "0999999999");
        register("22520124@gm.uit.edu.vn", "vubao", "11111111", 2, "Trần Vũ Bão", "0999999999");
        register("22520872@gm.uit.edu.vn", "ducminh", "11111111", 2, "Nguyễn Đỗ Đức Minh", "0937802672");
        register("22520423@gm.uit.edu.vn", "thuyhien", "11111111", 2, "Phan Thị Thủy Hiền", "0999999999");
        register("22520001@gm.uit.edu.vn", "apple", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520002@gm.uit.edu.vn", "banana", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520003@gm.uit.edu.vn", "mango", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520004@gm.uit.edu.vn", "papaya", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520005@gm.uit.edu.vn", "kiwi", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520006@gm.uit.edu.vn", "chily", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520007@gm.uit.edu.vn", "blueberry", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520008@gm.uit.edu.vn", "table", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520009@gm.uit.edu.vn", "house", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520010@gm.uit.edu.vn", "grape", "11111111", 2, "Nguy ễn Văn A", "0999999999");
        register("22520011@gm.uit.edu.vn", "rambutan", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520012@gm.uit.edu.vn", "longan", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520013@gm.uit.edu.vn", "milk", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520014@gm.uit.edu.vn", "rice", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520015@gm.uit.edu.vn", "orange", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520016@gm.uit.edu.vn", "lemon", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520017@gm.uit.edu.vn", "store", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520018@gm.uit.edu.vn", "book", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520019@gm.uit.edu.vn", "plane", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520020@gm.uit.edu.vn", "bike", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520021@gm.uit.edu.vn", "motobike", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520022@gm.uit.edu.vn", "bicycle", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520023@gm.uit.edu.vn", "water", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520024@gm.uit.edu.vn", "fire", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520025@gm.uit.edu.vn", "snow", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520026@gm.uit.edu.vn", "tree", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520027@gm.uit.edu.vn", "sunlight", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520028@gm.uit.edu.vn", "rain", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520029@gm.uit.edu.vn", "rainbow", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520030@gm.uit.edu.vn", "mushroom", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520031@gm.uit.edu.vn", "daisy", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520032@gm.uit.edu.vn", "flower", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520033@gm.uit.edu.vn", "tiger", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520034@gm.uit.edu.vn", "lion", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520035@gm.uit.edu.vn", "monkey", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520036@gm.uit.edu.vn", "elephant", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520037@gm.uit.edu.vn", "lime", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520038@gm.uit.edu.vn", "glass", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520039@gm.uit.edu.vn", "coffee", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("22520040@gm.uit.edu.vn", "phone", "11111111", 2, "Nguyễn Văn A", "0999999999");
        register("ctsv@gm.uit.edu.vn", "ctsvuit", "11111111", 1, "Văn phòng Công tác Sinh viên UIT", "0999999999");
    }
}
