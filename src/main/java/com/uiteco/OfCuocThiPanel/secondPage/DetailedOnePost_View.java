
package com.uiteco.OfCuocThiPanel.secondPage;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import static com.raven.scroll.ScrollPaneUtil.configureScrollBar;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;


public class DetailedOnePost_View extends JPanel {

    public DetailedOnePost_Controller getController() {
        return controller;
    }

    private DetailedOnePost_Controller controller;

    public DetailedOnePost_Controller createController(BriefPost_Model model) {
        this.controller = new DetailedOnePost_Controller(this, model);
        return getController();
    }

    public DetailedOnePost_View() {
        _initComponents();
        _init();
    }

    public void _init() {
        setBounds(0, 0, 1190, 1200);
        setOpaque(true);
        setBorder(null);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        configureScrollBar(scrollPane);
        jParentPanel.setBorder(null);

        jContent.setColumns(1);
        int countRows = jContent.getRows() + 10;
        jContent.setRows(countRows);
        jContent.setWrapStyleWord(true);
        jContent.setSelectedTextColor(new Color(59, 130, 246));

    }
    
    public void _initComponents(){
           
        scrollPane = new JScrollPane();
        jParentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBodyPanel = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtons = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jListRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLike = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLeftIcon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jPostTime = new javax.swing.JLabel();
        jMainContainer = new javax.swing.JPanel();
        jContent1 = new javax.swing.JPanel();
        jContent = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        scrollPaneImages = new com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        youtubePlay = new com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay();
        highResolutionResize1 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        RegisterTimePanel = new com.uiteco.components.RoundedPanel();
        jRegisterTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(1185, 1014));

        scrollPane.setBackground(new java.awt.Color(255, 255, 51));

        jParentPanel.setBackground(new java.awt.Color(242, 243, 244));
        jParentPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1913, Short.MAX_VALUE)
        );

        jParentPanel.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jBodyPanel.setBackground(new java.awt.Color(242, 243, 244));
        jBodyPanel.setOpaque(false);
        jBodyPanel.setPreferredSize(new java.awt.Dimension(1185, 1913));

        jTitle.setFont(new java.awt.Font("Merriweather", 0, 46)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("jLabel1");
        jTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1185, 1265));

        jButtons.setOpaque(false);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 10));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 10));

        jRegister.setBackground(new java.awt.Color(242, 243, 244));
        jRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 1, 1));
        jRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register.png"))); // NOI18N
        jRegister.setText("THAM GIA");
        jRegister.setColor(new java.awt.Color(242, 243, 244));
        jRegister.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jRegister.setIconTextGap(4);

        jListRegister.setBackground(new java.awt.Color(242, 243, 244));
        jListRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 1, 1));
        jListRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookmark.png"))); // NOI18N
        jListRegister.setText("DANH SÁCH");
        jListRegister.setColor(new java.awt.Color(242, 243, 244));
        jListRegister.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jListRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jListRegister.setIconTextGap(6);
        jListRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListRegisterActionPerformed(evt);
            }
        });

        jLike.setBackground(new java.awt.Color(242, 243, 244));
        jLike.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.png"))); // NOI18N
        jLike.setColor(new java.awt.Color(242, 243, 244));
        jLike.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jLike.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jButtonsLayout = new javax.swing.GroupLayout(jButtons);
        jButtons.setLayout(jButtonsLayout);
        jButtonsLayout.setHorizontalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jListRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLike, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonsLayout.setVerticalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jListRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jButtonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLeftIcon.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/construction.png"))); // NOI18N

        jOrganizer.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jOrganizer.setText("jLabel3");

        jPostTime.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPostTime.setText("jLabel4");

        javax.swing.GroupLayout jLeftIconLayout = new javax.swing.GroupLayout(jLeftIcon);
        jLeftIcon.setLayout(jLeftIconLayout);
        jLeftIconLayout.setHorizontalGroup(
            jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIconLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPostTime, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jLeftIconLayout.setVerticalGroup(
            jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIconLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLeftIconLayout.createSequentialGroup()
                        .addComponent(jOrganizer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPostTime)))
                .addContainerGap())
        );

        jMainContainer.setBackground(new java.awt.Color(242, 243, 244));

        javax.swing.GroupLayout jMainContainerLayout = new javax.swing.GroupLayout(jMainContainer);
        jMainContainer.setLayout(jMainContainerLayout);
        jMainContainerLayout.setHorizontalGroup(
            jMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMainContainerLayout.setVerticalGroup(
            jMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jContent1.setOpaque(false);
        jContent1.setPreferredSize(new java.awt.Dimension(1040, 50));
        jContent1.setLayout(new javax.swing.BoxLayout(jContent1, javax.swing.BoxLayout.PAGE_AXIS));

        jContent.setColumns(20);
        jContent.setLineWrap(true);
        jContent.setWrapStyleWord(true);
        jContent.setOpaque(false);
        jContent1.add(jContent);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1034, 100));

        jLabel1.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("H Ì N H  Ả N H  N Ổ I  B Ậ T");

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        jContent1.add(jPanel3);

        scrollPaneImages.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));
        scrollPaneImages.setOpaque(false);
        jContent1.add(scrollPaneImages);

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("T Ì M  H I Ể U  T H Ê M  V Ề  S Ự  K I Ệ N");

        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 2));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1084, 1084, 1084))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jContent1.add(jPanel1);

        youtubePlay.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 0, 25, 0));
        youtubePlay.setOpaque(false);
        jContent1.add(youtubePlay);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                        .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1056, 1056, 1056)
                        .addComponent(jMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jContent1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1057, 1057, 1057))
        );

        javax.swing.GroupLayout jBodyPanelLayout = new javax.swing.GroupLayout(jBodyPanel);
        jBodyPanel.setLayout(jBodyPanelLayout);
        jBodyPanelLayout.setHorizontalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGroup(jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBodyPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jBodyPanelLayout.setVerticalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jParentPanel.add(jBodyPanel, java.awt.BorderLayout.PAGE_START);

        scrollPane.setViewportView(jParentPanel);

        highResolutionResize1.setImage(new javax.swing.ImageIcon(getClass().getResource("/1.png"))); // NOI18N

        RegisterTimePanel.setBackground(new java.awt.Color(255, 255, 255));
        RegisterTimePanel.setRoundBottomLeft(45);
        RegisterTimePanel.setRoundBottomRight(45);
        RegisterTimePanel.setRoundTopLeft(45);
        RegisterTimePanel.setRoundTopRight(45);

        jRegisterTime.setFont(new java.awt.Font("Merriweather", 1, 26)); // NOI18N
        jRegisterTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRegisterTime.setText("jLabel3");
        jRegisterTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout RegisterTimePanelLayout = new javax.swing.GroupLayout(RegisterTimePanel);
        RegisterTimePanel.setLayout(RegisterTimePanelLayout);
        RegisterTimePanelLayout.setHorizontalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jRegisterTime, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        RegisterTimePanelLayout.setVerticalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegisterTime, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout highResolutionResize1Layout = new javax.swing.GroupLayout(highResolutionResize1);
        highResolutionResize1.setLayout(highResolutionResize1Layout);
        highResolutionResize1Layout.setHorizontalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize1Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        highResolutionResize1Layout.setVerticalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(highResolutionResize1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(highResolutionResize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new com.raven.scroll.ScrollPaneWin11();
        jParentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBodyPanel = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtons = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jListRegister = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLike = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLeftIcon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jPostTime = new javax.swing.JLabel();
        jMainContainer = new javax.swing.JPanel();
        jContent1 = new javax.swing.JPanel();
        jContent = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        scrollPaneImages = new com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        youtubePlay = new com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay();
        highResolutionResize1 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        RegisterTimePanel = new com.uiteco.components.RoundedPanel();
        jRegisterTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(1185, 1014));

        scrollPane1.setBackground(new java.awt.Color(255, 255, 51));

        jParentPanel.setBackground(new java.awt.Color(242, 243, 244));
        jParentPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1913, Short.MAX_VALUE)
        );

        jParentPanel.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jBodyPanel.setBackground(new java.awt.Color(242, 243, 244));
        jBodyPanel.setOpaque(false);
        jBodyPanel.setPreferredSize(new java.awt.Dimension(1185, 1913));

        jTitle.setFont(new java.awt.Font("Merriweather", 0, 46)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("jLabel1");
        jTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1185, 1265));

        jButtons.setOpaque(false);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 10));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 10));

        jRegister.setBackground(new java.awt.Color(242, 243, 244));
        jRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 1, 1));
        jRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register.png"))); // NOI18N
        jRegister.setText("THAM GIA");
        jRegister.setColor(new java.awt.Color(242, 243, 244));
        jRegister.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jRegister.setIconTextGap(4);

        jListRegister.setBackground(new java.awt.Color(242, 243, 244));
        jListRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 1, 1));
        jListRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookmark.png"))); // NOI18N
        jListRegister.setText("DANH SÁCH");
        jListRegister.setColor(new java.awt.Color(242, 243, 244));
        jListRegister.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jListRegister.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jListRegister.setIconTextGap(6);
        jListRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListRegisterActionPerformed(evt);
            }
        });

        jLike.setBackground(new java.awt.Color(242, 243, 244));
        jLike.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.png"))); // NOI18N
        jLike.setColor(new java.awt.Color(242, 243, 244));
        jLike.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jLike.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jButtonsLayout = new javax.swing.GroupLayout(jButtons);
        jButtons.setLayout(jButtonsLayout);
        jButtonsLayout.setHorizontalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jListRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLike, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtonsLayout.setVerticalGroup(
            jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonsLayout.createSequentialGroup()
                .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jListRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jButtonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLeftIcon.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/construction.png"))); // NOI18N

        jOrganizer.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jOrganizer.setText("jLabel3");

        jPostTime.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPostTime.setText("jLabel4");

        javax.swing.GroupLayout jLeftIconLayout = new javax.swing.GroupLayout(jLeftIcon);
        jLeftIcon.setLayout(jLeftIconLayout);
        jLeftIconLayout.setHorizontalGroup(
            jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIconLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPostTime, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jLeftIconLayout.setVerticalGroup(
            jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIconLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeftIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLeftIconLayout.createSequentialGroup()
                        .addComponent(jOrganizer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPostTime)))
                .addContainerGap())
        );

        jMainContainer.setBackground(new java.awt.Color(242, 243, 244));

        javax.swing.GroupLayout jMainContainerLayout = new javax.swing.GroupLayout(jMainContainer);
        jMainContainer.setLayout(jMainContainerLayout);
        jMainContainerLayout.setHorizontalGroup(
            jMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMainContainerLayout.setVerticalGroup(
            jMainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jContent1.setOpaque(false);
        jContent1.setPreferredSize(new java.awt.Dimension(1040, 50));
        jContent1.setLayout(new javax.swing.BoxLayout(jContent1, javax.swing.BoxLayout.PAGE_AXIS));

        jContent.setColumns(20);
        jContent.setLineWrap(true);
        jContent.setWrapStyleWord(true);
        jContent.setOpaque(false);
        jContent1.add(jContent);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1034, 100));

        jLabel1.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("H Ì N H  Ả N H  N Ổ I  B Ậ T");

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        jContent1.add(jPanel3);

        scrollPaneImages.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));
        scrollPaneImages.setOpaque(false);
        jContent1.add(scrollPaneImages);

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("T Ì M  H I Ể U  T H Ê M  V Ề  S Ự  K I Ệ N");

        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 2));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1084, 1084, 1084))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jContent1.add(jPanel1);

        youtubePlay.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 0, 25, 0));
        youtubePlay.setOpaque(false);
        jContent1.add(youtubePlay);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                        .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1056, 1056, 1056)
                        .addComponent(jMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jContent1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1057, 1057, 1057))
        );

        javax.swing.GroupLayout jBodyPanelLayout = new javax.swing.GroupLayout(jBodyPanel);
        jBodyPanel.setLayout(jBodyPanelLayout);
        jBodyPanelLayout.setHorizontalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGroup(jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBodyPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        jBodyPanelLayout.setVerticalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jParentPanel.add(jBodyPanel, java.awt.BorderLayout.PAGE_START);

        scrollPane1.setViewportView(jParentPanel);

        highResolutionResize1.setImage(new javax.swing.ImageIcon(getClass().getResource("/1.png"))); // NOI18N

        RegisterTimePanel.setBackground(new java.awt.Color(255, 255, 255));
        RegisterTimePanel.setRoundBottomLeft(45);
        RegisterTimePanel.setRoundBottomRight(45);
        RegisterTimePanel.setRoundTopLeft(45);
        RegisterTimePanel.setRoundTopRight(45);

        jRegisterTime.setFont(new java.awt.Font("Merriweather", 1, 26)); // NOI18N
        jRegisterTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRegisterTime.setText("jLabel3");
        jRegisterTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout RegisterTimePanelLayout = new javax.swing.GroupLayout(RegisterTimePanel);
        RegisterTimePanel.setLayout(RegisterTimePanelLayout);
        RegisterTimePanelLayout.setHorizontalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jRegisterTime, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        RegisterTimePanelLayout.setVerticalGroup(
            RegisterTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegisterTime, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout highResolutionResize1Layout = new javax.swing.GroupLayout(highResolutionResize1);
        highResolutionResize1.setLayout(highResolutionResize1Layout);
        highResolutionResize1Layout.setHorizontalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize1Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        highResolutionResize1Layout.setVerticalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(highResolutionResize1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(highResolutionResize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>                        

    private void jTymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTymActionPerformed

    }//GEN-LAST:event_jTymActionPerformed

    private void jLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLikeActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jLikeActionPerformed

    private void jListRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jListRegisterActionPerformed

    private JScrollPane scrollPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected com.uiteco.components.RoundedPanel RegisterTimePanel;
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize1;
    protected javax.swing.JPanel jBodyPanel;
    protected javax.swing.JPanel jButtons;
    protected javax.swing.JTextArea jContent;
    private javax.swing.JPanel jContent1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    protected javax.swing.JPanel jLeftIcon;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jLike;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton jListRegister;
    protected javax.swing.JPanel jMainContainer;
    protected javax.swing.JLabel jOrganizer;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JPanel jParentPanel;
    protected javax.swing.JLabel jPostTime;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jRegister;
    protected javax.swing.JLabel jRegisterTime;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    protected javax.swing.JLabel jTitle;
    protected com.raven.scroll.ScrollPaneWin11 scrollPane1;
    private com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages scrollPaneImages;
    private com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay youtubePlay;
    // End of variables declaration//GEN-END:variables

    public JLabel getjRegisterTime() {
        return jRegisterTime;
    }
}
