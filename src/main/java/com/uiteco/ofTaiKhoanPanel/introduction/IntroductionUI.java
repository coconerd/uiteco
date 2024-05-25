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
import com.uiteco.components.RoundedGradientPanel;
import com.uiteco.components.jnafilechooser.api.JnaFileChooser;
import com.uiteco.main.App;
import com.uiteco.ofTaiKhoanPanel.TaiKhoanModel;
import java.awt.Color;
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
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author nddmi
 */
public class IntroductionUI extends RoundedGradientPanel {

    private class TitleDocListener implements DocumentListener {

        public static int charCountLimit = 100;

        @Override
        public void insertUpdate(DocumentEvent e) {
            limitCharacters();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateCharacterCount(false);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not needed for character count, can be left empty
        }

        private void updateCharacterCount(boolean isInsert) {
            int charCount = intro.getDocument().getLength();
            titleCharCountLabel.setText(String.valueOf(charCount));
        }

        private void limitCharacters() {
            int currentLength = intro.getDocument().getLength();
            if (currentLength > charCountLimit) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        intro.getDocument().remove(charCountLimit, currentLength - charCountLimit);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                updateCharacterCount(true);
            }
        }
    }

    public static final String INSTANCE_NAME = "introductionUI";
    private String mssv;
    private boolean isEditingIntro = false;

    /**
     * Creates new form IntroductionUI
     */
    public IntroductionUI() {
        initComponents();
        if (App.getSession().getUser().getAccountType() == TaiKhoanModel.ACCOUNT_TYPE.admin) {
            mssvPane.setVisible(false);
            jLabel10.setVisible(false);
        }
    }

    private void saveChanges() {
        String newName = namePane.getText();
        String newEmail = emailPane.getText();
        String newPhone = phonePane.getText();
        String newUsername = usernamePane.getText();
        Icon newAvatar = imageAvatar1.getIcon();
        String newIntro = intro.getText();

        boolean nameChanged = !(newName.equals(App.getSession().getUser().getFullname()));
        boolean emailChanged = !(newEmail.equals(App.getSession().getUser().getEmail()));
        boolean phoneChanged = !(newPhone.equals(App.getSession().getUser().getPhone()));
        boolean usernameChanged = !(newUsername.equals(App.getSession().getUser().getUsername()));
        boolean avatarChanged = !(((ImageIcon) newAvatar).equals(App.getSession().getUser().getAvatar()));
        boolean introChanged = !(newIntro.equals(App.getSession().getUser().getIntro()));

        if (!(nameChanged || emailChanged || phoneChanged || usernameChanged || avatarChanged || introChanged)) {
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
                AuthDAO.updateGeneralInfo(newEmail, newUsername, newPhone, newName, (ImageIcon) newAvatar, newIntro);
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
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        khoaPane = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        roundedPanel3 = new com.uiteco.components.RoundedPanel();
        intro = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        titleCharCountLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        editBtn = new com.uiteco.components.RoundedGradientPanel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 1, true));
        setColor1(new java.awt.Color(255, 255, 255));
        setColor2(new java.awt.Color(255, 255, 255));
        setFade(false);

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lưu thay đổi");
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

        emailPane.setEditable(false);
        emailPane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        emailPane.setForeground(new java.awt.Color(102, 102, 102));
        emailPane.setText(App.getSession().getUser().getEmail());
        emailPane.setToolTipText("");
        jScrollPane6.setViewportView(emailPane);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(174, 176, 179));
        jLabel9.setText("Username");

        ImageIcon avatar = App.getSession().getUser().getAvatar();
        if (avatar == null) {
            imageAvatar1.setForeground(new java.awt.Color(0, 0, 102));
            imageAvatar1.setBorderSize(4);
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
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        imageAvatar1Layout.setVerticalGroup(
            imageAvatar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageAvatar1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Cập nhật ảnh đại diện");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(174, 176, 179));
        jLabel10.setText("Khoa");

        khoaPane.setEditable(false);
        khoaPane.setBackground(new java.awt.Color(204, 204, 204));
        khoaPane.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        khoaPane.setForeground(new java.awt.Color(102, 102, 102));
        khoaPane.setText(App.getSession().getUser().getFaculty());
        jScrollPane7.setViewportView(khoaPane);

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        roundedPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        roundedPanel3.setRoundBottomLeft(11);
        roundedPanel3.setRoundBottomRight(11);
        roundedPanel3.setRoundTopLeft(11);
        roundedPanel3.setRoundTopRight(11);
        roundedPanel3.setLayout(new java.awt.GridLayout(1, 0));

        intro.setEditable(false);
        intro.setColumns(20);
        intro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        intro.setLineWrap(true);
        intro.setRows(5);
        intro.setTabSize(4);
        intro.setText(App.getSession().getUser().getIntro()
        );
        intro.setBorder(null);
        intro.setFocusable(false);
        intro.setOpaque(false);
        intro.getDocument().addDocumentListener(new TitleDocListener());
        roundedPanel3.add(intro);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Thông tin giới thiệu");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        jLabel11.setForeground(java.awt.SystemColor.textInactiveText);
        jLabel11.setText("Số ký tự: ");

        titleCharCountLabel.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        titleCharCountLabel.setForeground(java.awt.SystemColor.textInactiveText);
        titleCharCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleCharCountLabel.setText("0");

        jLabel12.setFont(new java.awt.Font("Segoe UI Variable", 0, 13)); // NOI18N
        jLabel12.setForeground(java.awt.SystemColor.textInactiveText);
        jLabel12.setText(String.valueOf("/ " + TitleDocListener.charCountLimit));

        editBtn.setBorder(null);
        editBtn.setColor1(new java.awt.Color(255, 102, 102));
        editBtn.setColor2(new java.awt.Color(51, 0, 153));
        editBtn.setPreferredSize(new java.awt.Dimension(73, 22));
        editBtn.setRoundBottomLeft(25);
        editBtn.setRoundBottomRight(25);
        editBtn.setRoundTopLeft(25);
        editBtn.setRoundTopRight(25);
        editBtn.setLayout(new java.awt.GridLayout(1, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Sửa");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        editBtn.add(jLabel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(jScrollPane5)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(239, 239, 239))
                                .addComponent(jScrollPane1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(44, 44, 44))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleCharCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(roundedPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titleCharCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jLabel13.setForeground(jLabel13.getForeground().darker());
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        jLabel13.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        if (!isEditingIntro) {
            intro.setEditable(true);
            intro.setForeground(new Color(5, 5, 5));
            intro.setFocusable(true);
            jLabel13.setText("");
            editBtn.setColor2(new Color(5, 5, 5));
            jLabel13.setIcon(new ImageIcon(getClass().getResource("/icons8-edit-24.png")));
        } else {
            intro.setEditable(false);
            intro.setForeground(new Color(153, 153, 153));
            intro.setFocusable(false);
            editBtn.setColor1(new Color(255, 102, 102));
            editBtn.setColor2(new Color(51, 0, 153));
//            editBtn.setColor2(new Color(204, 204, 204));
            jLabel13.setIcon(null);
            jLabel13.setText("Sửa");

        }
        isEditingIntro = !isEditingIntro;
    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.components.RoundedGradientPanel editBtn;
    private javax.swing.JTextPane emailPane;
    private com.uiteco.components.ImageAvatar imageAvatar1;
    private javax.swing.JTextArea intro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane khoaPane;
    private javax.swing.JTextPane mssvPane;
    private javax.swing.JTextPane namePane;
    private javax.swing.JTextPane phonePane;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    private com.uiteco.components.RoundedPanel roundedPanel2;
    private com.uiteco.components.RoundedPanel roundedPanel3;
    private javax.swing.JLabel titleCharCountLabel;
    private javax.swing.JTextPane usernamePane;
    // End of variables declaration//GEN-END:variables
}
