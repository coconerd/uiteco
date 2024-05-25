
package com.uiteco.OfCuocThiPanel.secondPage;

import static com.raven.scroll.ScrollPaneUtil.configureScrollBar;
import com.uiteco.OfCuocThiPanel.firstPage.BriefPost_Model;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;


public class DetailedOnePost_View extends JPanel {

    /**
     * @return the scrollPaneImages
     */
    public com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages getScrollPaneImages() {
        return scrollPaneImages;
    }

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

        getScrollPaneImages().setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 25, 0));
        getScrollPaneImages().setOpaque(false);
        jContent1.add(getScrollPaneImages());

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
        jPanel5 = new javax.swing.JPanel();
        scrollPane2 = new com.raven.scroll.ScrollPaneWin11();
        jParentPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jBodyPanel1 = new javax.swing.JPanel();
        jTitle1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButtons1 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jRegister1 = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jListRegister1 = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLike1 = new com.uiteco.OfCuocThiPanel.secondPage.CustomButton();
        jLeftIcon1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jOrganizer1 = new javax.swing.JLabel();
        jPostTime1 = new javax.swing.JLabel();
        jMainContainer1 = new javax.swing.JPanel();
        jContent2 = new javax.swing.JPanel();
        jContent3 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        scrollPaneImages1 = new com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        youtubePlay1 = new com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay();
        highResolutionResize2 = new com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize();
        RegisterTimePanel1 = new com.uiteco.components.RoundedPanel();
        jRegisterTime1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(1185, 1014));

        scrollPane1.setBackground(new java.awt.Color(255, 255, 51));

        jParentPanel.setBackground(new java.awt.Color(242, 243, 244));
        jParentPanel.setLayout(new java.awt.BorderLayout());

        jBodyPanel.setBackground(new java.awt.Color(255, 102, 255));
        jBodyPanel.setPreferredSize(new java.awt.Dimension(1185, 1913));

        jTitle.setFont(new java.awt.Font("Merriweather", 0, 46)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("jLabel1");
        jTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        jTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 102, 204));
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

        jContent.setEditable(false);
        jContent.setColumns(20);
        jContent.setLineWrap(true);
        jContent.setWrapStyleWord(true);
        jContent.setOpaque(false);
        jContent1.add(jContent);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1034, 90));

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
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        jContent1.add(jPanel3);

        scrollPaneImages.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 25, 0));
        scrollPaneImages.setPreferredSize(new java.awt.Dimension(855, 500));
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
                .addGap(96, 96, 96)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLeftIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(jButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1056, 1056, 1056)
                        .addComponent(jMainContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jContent1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBodyPanelLayout.createSequentialGroup()
                .addGroup(jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1527, Short.MAX_VALUE)
                    .addGroup(jBodyPanelLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1402, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jBodyPanelLayout.setVerticalGroup(
            jBodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, Short.MAX_VALUE)
                .addGap(248, 248, 248))
        );

        jParentPanel.add(jBodyPanel, java.awt.BorderLayout.CENTER);

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
                .addGap(527, 527, 527)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );
        highResolutionResize1Layout.setVerticalGroup(
            highResolutionResize1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize1Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(RegisterTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(242, 243, 244));
        jPanel5.setPreferredSize(new java.awt.Dimension(1185, 1014));

        scrollPane2.setBackground(new java.awt.Color(255, 255, 51));

        jParentPanel1.setBackground(new java.awt.Color(242, 243, 244));
        jParentPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 102));
        jPanel6.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1913, Short.MAX_VALUE)
        );

        jParentPanel1.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jBodyPanel1.setBackground(new java.awt.Color(242, 243, 244));
        jBodyPanel1.setOpaque(false);
        jBodyPanel1.setPreferredSize(new java.awt.Dimension(1185, 1913));

        jTitle1.setFont(new java.awt.Font("Merriweather", 0, 46)); // NOI18N
        jTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle1.setText("jLabel1");
        jTitle1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        jTitle1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(1185, 1265));

        jButtons1.setOpaque(false);

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setOpaque(true);
        jSeparator6.setPreferredSize(new java.awt.Dimension(10, 10));

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setOpaque(true);
        jSeparator7.setPreferredSize(new java.awt.Dimension(10, 10));

        jRegister1.setBackground(new java.awt.Color(242, 243, 244));
        jRegister1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 1, 1));
        jRegister1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register.png"))); // NOI18N
        jRegister1.setText("THAM GIA");
        jRegister1.setColor(new java.awt.Color(242, 243, 244));
        jRegister1.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jRegister1.setIconTextGap(4);

        jListRegister1.setBackground(new java.awt.Color(242, 243, 244));
        jListRegister1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 1, 1));
        jListRegister1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookmark.png"))); // NOI18N
        jListRegister1.setText("DANH SÁCH");
        jListRegister1.setColor(new java.awt.Color(242, 243, 244));
        jListRegister1.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jListRegister1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jListRegister1.setIconTextGap(6);
        jListRegister1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListRegister1ActionPerformed(evt);
            }
        });

        jLike1.setBackground(new java.awt.Color(242, 243, 244));
        jLike1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jLike1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heart.png"))); // NOI18N
        jLike1.setColor(new java.awt.Color(242, 243, 244));
        jLike1.setFont(new java.awt.Font("Merriweather", 1, 12)); // NOI18N
        jLike1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jLike1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLike1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jButtons1Layout = new javax.swing.GroupLayout(jButtons1);
        jButtons1.setLayout(jButtons1Layout);
        jButtons1Layout.setHorizontalGroup(
            jButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtons1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jListRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLike1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jButtons1Layout.setVerticalGroup(
            jButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtons1Layout.createSequentialGroup()
                .addGroup(jButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jRegister1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLike1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jListRegister1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jButtons1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLeftIcon1.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/construction.png"))); // NOI18N

        jOrganizer1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jOrganizer1.setText("jLabel3");

        jPostTime1.setFont(new java.awt.Font("Merriweather", 0, 15)); // NOI18N
        jPostTime1.setText("jLabel4");

        javax.swing.GroupLayout jLeftIcon1Layout = new javax.swing.GroupLayout(jLeftIcon1);
        jLeftIcon1.setLayout(jLeftIcon1Layout);
        jLeftIcon1Layout.setHorizontalGroup(
            jLeftIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIcon1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLeftIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOrganizer1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPostTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jLeftIcon1Layout.setVerticalGroup(
            jLeftIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeftIcon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLeftIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLeftIcon1Layout.createSequentialGroup()
                        .addComponent(jOrganizer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPostTime1)))
                .addContainerGap())
        );

        jMainContainer1.setBackground(new java.awt.Color(242, 243, 244));

        javax.swing.GroupLayout jMainContainer1Layout = new javax.swing.GroupLayout(jMainContainer1);
        jMainContainer1.setLayout(jMainContainer1Layout);
        jMainContainer1Layout.setHorizontalGroup(
            jMainContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMainContainer1Layout.setVerticalGroup(
            jMainContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jContent2.setOpaque(false);
        jContent2.setPreferredSize(new java.awt.Dimension(1040, 50));
        jContent2.setLayout(new javax.swing.BoxLayout(jContent2, javax.swing.BoxLayout.PAGE_AXIS));

        jContent3.setEditable(false);
        jContent3.setColumns(20);
        jContent3.setLineWrap(true);
        jContent3.setWrapStyleWord(true);
        jContent3.setOpaque(false);
        jContent2.add(jContent3);

        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(1034, 90));

        jLabel5.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("H Ì N H  Ả N H  N Ổ I  B Ậ T");

        jSeparator8.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator8.setOpaque(true);
        jSeparator8.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        jContent2.add(jPanel8);

        scrollPaneImages1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 25, 0));
        scrollPaneImages1.setPreferredSize(new java.awt.Dimension(855, 500));
        jContent2.add(scrollPaneImages1);

        jPanel9.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Merriweather", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("T Ì M  H I Ể U  T H Ê M  V Ề  S Ự  K I Ệ N");

        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 2));

        jSeparator10.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator10.setOpaque(true);
        jSeparator10.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(557, 557, 557)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1084, 1084, 1084))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jContent2.add(jPanel9);

        youtubePlay1.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 0, 25, 0));
        youtubePlay1.setOpaque(false);
        jContent2.add(youtubePlay1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLeftIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1056, 1056, 1056)
                        .addComponent(jMainContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 88, Short.MAX_VALUE)
                .addComponent(jContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLeftIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jContent2, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMainContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1057, 1057, 1057))
        );

        javax.swing.GroupLayout jBodyPanel1Layout = new javax.swing.GroupLayout(jBodyPanel1);
        jBodyPanel1.setLayout(jBodyPanel1Layout);
        jBodyPanel1Layout.setHorizontalGroup(
            jBodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jBodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBodyPanel1Layout.createSequentialGroup()
                        .addGap(0, 119, Short.MAX_VALUE)
                        .addComponent(jTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jBodyPanel1Layout.setVerticalGroup(
            jBodyPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1513, Short.MAX_VALUE)
                .addGap(248, 248, 248))
        );

        jParentPanel1.add(jBodyPanel1, java.awt.BorderLayout.PAGE_START);

        scrollPane2.setViewportView(jParentPanel1);

        highResolutionResize2.setImage(new javax.swing.ImageIcon(getClass().getResource("/1.png"))); // NOI18N

        RegisterTimePanel1.setBackground(new java.awt.Color(255, 255, 255));
        RegisterTimePanel1.setRoundBottomLeft(45);
        RegisterTimePanel1.setRoundBottomRight(45);
        RegisterTimePanel1.setRoundTopLeft(45);
        RegisterTimePanel1.setRoundTopRight(45);

        jRegisterTime1.setFont(new java.awt.Font("Merriweather", 1, 26)); // NOI18N
        jRegisterTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRegisterTime1.setText("jLabel3");
        jRegisterTime1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout RegisterTimePanel1Layout = new javax.swing.GroupLayout(RegisterTimePanel1);
        RegisterTimePanel1.setLayout(RegisterTimePanel1Layout);
        RegisterTimePanel1Layout.setHorizontalGroup(
            RegisterTimePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRegisterTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        RegisterTimePanel1Layout.setVerticalGroup(
            RegisterTimePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterTimePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegisterTime1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout highResolutionResize2Layout = new javax.swing.GroupLayout(highResolutionResize2);
        highResolutionResize2.setLayout(highResolutionResize2Layout);
        highResolutionResize2Layout.setHorizontalGroup(
            highResolutionResize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize2Layout.createSequentialGroup()
                .addGap(526, 526, 526)
                .addComponent(RegisterTimePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        highResolutionResize2Layout.setVerticalGroup(
            highResolutionResize2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highResolutionResize2Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(RegisterTimePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(highResolutionResize2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(highResolutionResize2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(highResolutionResize1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(highResolutionResize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jListRegister1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListRegister1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jListRegister1ActionPerformed

    private void jLike1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLike1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLike1ActionPerformed

    private JScrollPane scrollPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected com.uiteco.components.RoundedPanel RegisterTimePanel;
    protected com.uiteco.components.RoundedPanel RegisterTimePanel1;
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize1;
    private com.uiteco.OfCuocThiPanel.secondPage.HighResolutionResize highResolutionResize2;
    protected javax.swing.JPanel jBodyPanel;
    protected javax.swing.JPanel jBodyPanel1;
    protected javax.swing.JPanel jButtons;
    protected javax.swing.JPanel jButtons1;
    protected javax.swing.JTextArea jContent;
    private javax.swing.JPanel jContent1;
    private javax.swing.JPanel jContent2;
    protected javax.swing.JTextArea jContent3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    protected javax.swing.JPanel jLeftIcon;
    protected javax.swing.JPanel jLeftIcon1;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jLike;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jLike1;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton jListRegister;
    private com.uiteco.OfCuocThiPanel.secondPage.CustomButton jListRegister1;
    protected javax.swing.JPanel jMainContainer;
    protected javax.swing.JPanel jMainContainer1;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JLabel jOrganizer1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    protected javax.swing.JPanel jPanel6;
    protected javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    protected javax.swing.JPanel jParentPanel;
    protected javax.swing.JPanel jParentPanel1;
    protected javax.swing.JLabel jPostTime;
    protected javax.swing.JLabel jPostTime1;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jRegister;
    protected com.uiteco.OfCuocThiPanel.secondPage.CustomButton jRegister1;
    protected javax.swing.JLabel jRegisterTime;
    protected javax.swing.JLabel jRegisterTime1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    protected javax.swing.JLabel jTitle;
    protected javax.swing.JLabel jTitle1;
    protected com.raven.scroll.ScrollPaneWin11 scrollPane1;
    protected com.raven.scroll.ScrollPaneWin11 scrollPane2;
    private com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages scrollPaneImages;
    private com.uiteco.OfCuocThiPanel.secondPage.ScrollPaneImages scrollPaneImages1;
    private com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay youtubePlay;
    private com.uiteco.OfCuocThiPanel.secondPage.YoutubePlay youtubePlay1;
    // End of variables declaration//GEN-END:variables

    public JLabel getjRegisterTime() {
        return jRegisterTime;
    }
}
