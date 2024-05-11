package com.uiteco.OfCuocThiPanel.firstPage;

class OnePost extends javax.swing.JPanel {

    /**
     * @return the roundPanel_Parent
     */
    public com.uiteco.components.RoundedPanel getRoundPanel_Parent() {
        return roundPanel_Parent;
    }

    /**
     * @return the jDateRange
     */
    public javax.swing.JLabel getjDateRange() {
        return jDateRange;
    }

    /**
     * @return the jImage
     */
    public com.uiteco.components.RoundedImagePanel getjImage() {
        return jImage;
    }

    /**
     * @return the jOrganizer
     */
    public javax.swing.JLabel getjOrganizer() {
        return jOrganizer;
    }

    /**
     * @return the jPanelContainTags
     */
    public javax.swing.JPanel getjPanelContainTags() {
        return jPanelContainTags;
    }

    /**
     * @return the jSeparator
     */
    public javax.swing.JSeparator getjSeparator() {
        return jSeparator;
    }

    /**
     * @return the jTagsIcon
     */
    public javax.swing.JLabel getjTagsIcon() {
        return jTagsIcon;
    }

    /**
     * @return the jTitle
     */
    public javax.swing.JLabel getjTitle() {
        return jTitle;
    }

    /**
     * @return the jType
     */
    public javax.swing.JLabel getjType() {
        return jType;
    }

    /**
     * @param roundPanel_Parent the roundPanel_Parent to set
     */
    public void setRoundPanel_Parent(com.uiteco.components.RoundedPanel roundPanel_Parent) {
        this.roundPanel_Parent = roundPanel_Parent;
    }

    /**
     * @param jDateRange the jDateRange to set
     */
    public void setjDateRange(javax.swing.JLabel jDateRange) {
        this.jDateRange = jDateRange;
    }

    /**
     * @param jImage the jImage to set
     */
    public void setjImage(com.uiteco.components.RoundedImagePanel jImage) {
        this.jImage = jImage;
    }

    /**
     * @param jOrganizer the jOrganizer to set
     */
    public void setjOrganizer(javax.swing.JLabel jOrganizer) {
        this.jOrganizer = jOrganizer;
    }

    /**
     * @param jPanelContainTags the jPanelContainTags to set
     */
    public void setjPanelContainTags(javax.swing.JPanel jPanelContainTags) {
        this.jPanelContainTags = jPanelContainTags;
    }

    /**
     * @param jSeparator the jSeparator to set
     */
    public void setjSeparator(javax.swing.JSeparator jSeparator) {
        this.jSeparator = jSeparator;
    }

    /**
     * @param jTagsIcon the jTagsIcon to set
     */
    public void setjTagsIcon(javax.swing.JLabel jTagsIcon) {
        this.jTagsIcon = jTagsIcon;
    }

    /**
     * @param jTitle the jTitle to set
     */
    public void setjTitle(javax.swing.JLabel jTitle) {
        this.jTitle = jTitle;
    }

    /**
     * @param jType the jType to set
     */
    public void setjType(javax.swing.JLabel jType) {
        this.jType = jType;
    }

    
//    public void SetData(Model_OnePost data){
//        getjImage().setImage((Icon) data.getImage());
//        getjTitle().setText(data.getTitle());
//        getjOrganizer().setText(data.getOrganizer());
//        getjDateRange().setText(data.getDateRange());
//        
//        //display on a panel the number of tags which a post has (based on database)
//        int numberOfTags = data.getNumberOfTags();
//        for(int i = 0; i < numberOfTags; i++){
//            LabelTag tag = new LabelTag();
//            getjPanelContainTags().add(tag);
//        }
//        
//    }
      
    protected OnePost() {
        _initComponents();
        setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    private void _initComponents(){
        
        roundPanel_Parent = new com.uiteco.components.RoundedPanel();
        jTitle = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTagsIcon = new javax.swing.JLabel();
        jPanelContainTags = new javax.swing.JPanel();
        jImage = new com.uiteco.components.RoundedImagePanel();
        jType = new javax.swing.JLabel();
        labelDaysLeft1 = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();

        setPreferredSize(new java.awt.Dimension(1170, 240));

        roundPanel_Parent.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel_Parent.setPreferredSize(new java.awt.Dimension(1170, 240));
        roundPanel_Parent.setRoundBottomLeft(15);
        roundPanel_Parent.setRoundBottomRight(15);
        roundPanel_Parent.setRoundTopLeft(15);
        roundPanel_Parent.setRoundTopRight(15);

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 24)); // NOI18N
        jTitle.setText("Title");

        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("jLabel3");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("jLabel1");

        jTagsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-tag-24.png"))); // NOI18N
        jTagsIcon.setText("jLabel1");

        jPanelContainTags.setLayout(new java.awt.GridLayout(2, 2, 2, 3));

        //jImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/medium_square.png"))); // NOI18N
        jImage.setMinimumSize(new java.awt.Dimension(200, 200));
        jImage.setPreferredSize(new java.awt.Dimension(200, 200));
        jImage.setRoundBottomLeft(20);
        jImage.setRoundBottomRight(20);
        jImage.setRoundTopLeft(20);
        jImage.setRoundTopRight(20);

        javax.swing.GroupLayout jImageLayout = new javax.swing.GroupLayout(jImage);
        jImage.setLayout(jImageLayout);
        jImageLayout.setHorizontalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jImageLayout.setVerticalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-global-24.png"))); // NOI18N
        jType.setText("jLabel1");

        javax.swing.GroupLayout roundPanel_ParentLayout = new javax.swing.GroupLayout(roundPanel_Parent);
        roundPanel_Parent.setLayout(roundPanel_ParentLayout);
        roundPanel_ParentLayout.setHorizontalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jType)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(341, 341, 341)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel_ParentLayout.setVerticalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel_ParentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jType)
                        .addGap(18, 18, 18)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel_Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel_Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel_Parent = new com.uiteco.components.RoundedPanel();
        jTitle = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTagsIcon = new javax.swing.JLabel();
        jPanelContainTags = new javax.swing.JPanel();
        jImage = new com.uiteco.components.RoundedImagePanel();
        jType = new javax.swing.JLabel();
        labelDaysLeft1 = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();

        setPreferredSize(new java.awt.Dimension(1170, 240));

        roundPanel_Parent.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel_Parent.setPreferredSize(new java.awt.Dimension(1170, 240));
        roundPanel_Parent.setRoundBottomLeft(15);
        roundPanel_Parent.setRoundBottomRight(15);
        roundPanel_Parent.setRoundTopLeft(15);
        roundPanel_Parent.setRoundTopRight(15);

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 24)); // NOI18N
        jTitle.setText("Title");

        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("jLabel3");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("jLabel1");

        jTagsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-tag-24.png"))); // NOI18N
        jTagsIcon.setText("jLabel1");

        jPanelContainTags.setLayout(new java.awt.GridLayout(2, 2, 2, 3));

        jImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/medium_square.png"))); // NOI18N
        jImage.setMinimumSize(new java.awt.Dimension(200, 200));
        jImage.setPreferredSize(new java.awt.Dimension(200, 200));
        jImage.setRoundBottomLeft(20);
        jImage.setRoundBottomRight(20);
        jImage.setRoundTopLeft(20);
        jImage.setRoundTopRight(20);

        javax.swing.GroupLayout jImageLayout = new javax.swing.GroupLayout(jImage);
        jImage.setLayout(jImageLayout);
        jImageLayout.setHorizontalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jImageLayout.setVerticalGroup(
            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-global-24.png"))); // NOI18N
        jType.setText("jLabel1");

        javax.swing.GroupLayout roundPanel_ParentLayout = new javax.swing.GroupLayout(roundPanel_Parent);
        roundPanel_Parent.setLayout(roundPanel_ParentLayout);
        roundPanel_ParentLayout.setHorizontalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jType)
                    .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(341, 341, 341)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel_ParentLayout.setVerticalGroup(
            roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTagsIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel_ParentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundPanel_ParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel_ParentLayout.createSequentialGroup()
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jType)
                        .addGap(18, 18, 18)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel_Parent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel_Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
  
//    protected void _initComponents(){
//         roundPanel_Parent = new com.uiteco.components.RoundedPanel();
//        jTitle = new javax.swing.JLabel();
//        jOrganizer = new javax.swing.JLabel();
//        jSeparator = new javax.swing.JSeparator();
//        jDateRange = new javax.swing.JLabel();
//        jTagsIcon = new javax.swing.JLabel();
//        jPanelContainTags = new javax.swing.JPanel();
//        jImage = new com.uiteco.components.RoundedImagePanel();
//        jType = new javax.swing.JLabel();
//
//        setPreferredSize(new java.awt.Dimension(1170, 240));
//
//        roundPanel_Parent.setBackground(new java.awt.Color(255, 255, 255));
//        roundPanel_Parent.setPreferredSize(new java.awt.Dimension(1170, 240));
//        roundPanel_Parent.setRoundBottomLeft(15);
//        roundPanel_Parent.setRoundBottomRight(15);
//        roundPanel_Parent.setRoundTopLeft(15);
//        roundPanel_Parent.setRoundTopRight(15);
//
//        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 24)); // NOI18N
//        jTitle.setText("Title");
//
//        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-organization-24.png"))); // NOI18N
//        jOrganizer.setText("jLabel3");
//
//        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
//        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
//        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));
//
//        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-calendar-24.png"))); // NOI18N
//        jDateRange.setText("jLabel1");
//
//        jTagsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-tag-24.png"))); // NOI18N
//        jTagsIcon.setText("jLabel1");
//
//        jPanelContainTags.setLayout(new java.awt.GridLayout(2, 2, 2, 3));
//
//        jImage.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/medium_square.png"))); // NOI18N
//        jImage.setMinimumSize(new java.awt.Dimension(200, 200));
//        jImage.setPreferredSize(new java.awt.Dimension(200, 200));
//        jImage.setRoundBottomLeft(20);
//        jImage.setRoundBottomRight(20);
//        jImage.setRoundTopLeft(20);
//        jImage.setRoundTopRight(20);
//
//        javax.swing.GroupLayout jImageLayout = new javax.swing.GroupLayout(jImage);
//        jImage.setLayout(jImageLayout);
//        jImageLayout.setHorizontalGroup(
//            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 200, Short.MAX_VALUE)
//        );
//        jImageLayout.setVerticalGroup(
//            jImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 200, Short.MAX_VALUE)
//        );
//
//        jType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-global-24.png"))); // NOI18N
//        jType.setText("jLabel1");
//        
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(getRoundPanel_Parent(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(getRoundPanel_Parent(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jDateRange;
    protected com.uiteco.components.RoundedImagePanel jImage;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JPanel jPanelContainTags;
    protected javax.swing.JSeparator jSeparator;
    protected javax.swing.JLabel jTagsIcon;
    protected javax.swing.JLabel jTitle;
    protected javax.swing.JLabel jType;
    protected com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1;
    protected com.uiteco.components.RoundedPanel roundPanel_Parent;
    // End of variables declaration//GEN-END:variables
}
