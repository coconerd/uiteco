/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.ofTaiKhoanPanel.introduction;

import com.uiteco.auth.AuthDAO;
import com.uiteco.auth.AuthModel;
import static com.uiteco.auth.AuthModel.MAX_USERNAME_LEN;
import static com.uiteco.auth.AuthModel.MIN_USERNAME_LEN;
import com.uiteco.auth.BadCredentialsFormatException;
import com.uiteco.auth.InvalidCredentialsException;
import com.uiteco.components.jnafilechooser.api.JnaFileChooser;
import com.uiteco.main.App;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nddmi
 */
public class IntroductionUI extends javax.swing.JPanel {

    public static final String INSTANCE_NAME = "introductionUI";
    private String mssv;

    /**
     * Creates new form IntroductionUI
     */
    public IntroductionUI() {
        initComponents();
    }

    private void saveChanges() {
        String newName = namePane.getText();
        String newEmail = emailPane.getText();
        String newPhone = phonePane.getText();
        String newUsername = usernamePane.getText();
        Icon newAvatar = imageAvatar1.getIcon();

        boolean nameChanged = !(newName.equals(App.getSession().getUser().getFullname()));
        boolean emailChanged = !(newEmail.equals(App.getSession().getUser().getEmail()));
        boolean phoneChanged = !(newPhone.equals(App.getSession().getUser().getPhone()));
        boolean usernameChanged = !(newUsername.equals(App.getSession().getUser().getUsername()));
        boolean avatarChanged = !(((ImageIcon) newAvatar).equals(App.getSession().getUser().getAvatar()));

        if (!(nameChanged || emailChanged || phoneChanged || usernameChanged || avatarChanged)) {
            JOptionPane.showMessageDialog(this, "Chưa có thông tin nào được thay đổi");
            return;
        }

        try {
            validateName(newName);
            validateUsername(newUsername);
            validateEmail(newEmail);
            validatePhone(newPhone);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Thông tin thay đổi không hợp lệ", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TypePassword tp = new TypePassword();
        JDialog dialog = _createDialog("Nhập mật khẩu để ghi nhận thay đổi", tp);

        tp.getOkBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tp.setOk(true);
                tp.setTypedPassword(new String(tp.getjPasswordField().getPassword()));
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        tp.getCancelBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tp.setOk(false);
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        dialog.setVisible(true);

        if (tp.isOk()) {
            // Confirms update
            if (JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc muốn cập nhật thay đổi",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            ) == JOptionPane.NO_OPTION) {
                return;
            }

            // Verify password  
            try {
                if (AuthDAO.verifyPassword(tp.getTypedPassword()) == false) {
                    JOptionPane.showMessageDialog(this, "Không thể ghi nhận thay đổi vì xác nhận mật khẩu sai", "Mật khẩu không đúng", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (InvalidCredentialsException ie) {
                JOptionPane.showMessageDialog(this, "Không thể ghi nhận thay đổi vì xác nhận mật khẩu sai", "Mật khẩu không đúng", JOptionPane.ERROR_MESSAGE);
                return;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra khi xác nhận mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return;
            }

            // Update
            try {
                AuthDAO.updateGeneralInfo(newEmail, newUsername, newPhone, newName, (ImageIcon) newAvatar);
            } catch (SQLException | IOException e) {
                JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra khi cập nhật thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return;
            }

            // Show noti
            JOptionPane.showMessageDialog(this, "Thông tin cá nhân đã được cập nhật", "Thành công", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private JDialog _createDialog(String dialogName, Component child) {
        JDialog dialog = new JDialog(App.getMainFrame(), dialogName, true); // modal mode
        dialog.setLayout(new GridLayout(1, 1, 0, 0));
        dialog.setSize(child.getPreferredSize());
        dialog.add(child);
//        dialog.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = dialog.getSize();
        dialog.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
        return dialog;
    }

    private void _chooseImage() {
        JnaFileChooser jnaCh = new JnaFileChooser();
        jnaCh.setTitle("Chọn một ảnh để tải lên");
        jnaCh.setMode(JnaFileChooser.Mode.Files);
        jnaCh.setCurrentDirectory(System.getProperty("user.home"));
        jnaCh.setOpenButtonText("Tải lên");

        boolean opened = jnaCh.showOpenDialog(App.getMainFrame());
        if (!opened) {
            return;
        }

        File file = jnaCh.getSelectedFile();
        ImageIcon image = new ImageIcon(file.getAbsolutePath());
        imageAvatar1.setIcon(image);
        imageAvatar1.revalidate();
        imageAvatar1.repaint();
    }

    private void validateEmail(String email) throws BadCredentialsFormatException {
        int len = email.length();

        // Email must ends with 'uit.edu.vn'
        if (len <= AuthModel.EMAIL_POSTFIX.length()) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.EMAIL);
        }

        String postfix = email.substring(len - AuthModel.EMAIL_POSTFIX.length(), len);
        if (!postfix.equals("uit.edu.vn")) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.EMAIL);
        }
    }

    private void validateUsername(String username) throws BadCredentialsFormatException {
        int len = username.length();
        if (!(len >= MIN_USERNAME_LEN && len <= MAX_USERNAME_LEN)) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.USERNAME);
        }

        String regex = "^[a-zA-Z0-9]*$";
        if (!Pattern.matches(regex, username)) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.USERNAME);
        }
    }

    private void validatePhone(String phone) throws BadCredentialsFormatException {
        if (phone.length() < 9 || phone.length() > 11) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.PHONE);
        }
    }

    private void validateName(String name) throws BadCredentialsFormatException {
        if (name.length() < 1 || name.length() > 40) {
            throw new BadCredentialsFormatException(BadCredentialsFormatException.BAD.NAME);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        phonePane = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        namePane = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        usernamePane = new javax.swing.JTextPane();
        roundedPanel2 = new com.uiteco.components.RoundedPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        mssvPane = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        emailPane = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        imageAvatar1 = new com.uiteco.components.ImageAvatar();
        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(174, 176, 179));
        jLabel2.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(174, 176, 179));
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(174, 176, 179));
        jLabel5.setText("Số điện thoại");

        phonePane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        phonePane.setText(App.getSession().getUser().getPhone());
        jScrollPane1.setViewportView(phonePane);

        namePane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        namePane.setText(App.getSession().getUser().getFullname());
        jScrollPane3.setViewportView(namePane);

        usernamePane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        usernamePane.setText(App.getSession().getUser().getUsername());
        usernamePane.setToolTipText("");
        jScrollPane4.setViewportView(usernamePane);

        roundedPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.background"));
        roundedPanel2.setRoundBottomLeft(15);
        roundedPanel2.setRoundBottomRight(15);
        roundedPanel2.setRoundTopLeft(15);
        roundedPanel2.setRoundTopRight(15);
        roundedPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lưu");
        jLabel7.setToolTipText("");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        roundedPanel2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(174, 176, 179));
        jLabel8.setText("Mã số sinh viên");

        mssvPane.setEditable(false);
        mssvPane.setBackground(new java.awt.Color(204, 204, 204));
        mssvPane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mssvPane.setForeground(new java.awt.Color(102, 102, 102));
        mssvPane.setText(App.getSession().getUser().getMssv());
        jScrollPane5.setViewportView(mssvPane);

        emailPane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        emailPane.setText(App.getSession().getUser().getEmail());
        emailPane.setToolTipText("");
        jScrollPane6.setViewportView(emailPane);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(174, 176, 179));
        jLabel9.setText("Username");

        ImageIcon avatar = App.getSession().getUser().getAvatar();
        if (avatar == null) {
            imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/placeholder-avatar.png"))); // NOI18N
        } else {
            imageAvatar1.setIcon(avatar);
        }
        imageAvatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar1MouseClicked(evt);
            }
        });

        roundedPanel1.setBackground(new java.awt.Color(51, 51, 255));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(30, 30));
        roundedPanel1.setRoundBottomLeft(99);
        roundedPanel1.setRoundBottomRight(99);
        roundedPanel1.setRoundTopLeft(99);
        roundedPanel1.setRoundTopRight(99);
        roundedPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-edit-35.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        roundedPanel1.add(jLabel1);

        javax.swing.GroupLayout imageAvatar1Layout = new javax.swing.GroupLayout(imageAvatar1);
        imageAvatar1.setLayout(imageAvatar1Layout);
        imageAvatar1Layout.setHorizontalGroup(
            imageAvatar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageAvatar1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        imageAvatar1Layout.setVerticalGroup(
            imageAvatar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageAvatar1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cập nhật ảnh đại diện");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(239, 239, 239))
                            .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane4))))
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        saveChanges();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        _chooseImage();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void imageAvatar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MouseClicked
        // TODO add your handling code here:
        _chooseImage();
    }//GEN-LAST:event_imageAvatar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane emailPane;
    private com.uiteco.components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane mssvPane;
    private javax.swing.JTextPane namePane;
    private javax.swing.JTextPane phonePane;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    private com.uiteco.components.RoundedPanel roundedPanel2;
    private javax.swing.JTextPane usernamePane;
    // End of variables declaration//GEN-END:variables
}
