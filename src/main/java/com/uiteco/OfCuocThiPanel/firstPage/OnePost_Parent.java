package com.uiteco.OfCuocThiPanel.firstPage;

class OnePost_Parent extends javax.swing.JPanel {

    public com.uiteco.components.RoundedPanel getRoundedPanel() {
        return roundedPanel;
    }

    public com.uiteco.components.RoundedPanel getRoundedPanel_Image() {
        return roundedPanel_Image;
    }

    public javax.swing.JLabel getjDateRange() {
        return jDateRange;
    }

    public javax.swing.JLabel getjImage() {
        return jImage;
    }

    public javax.swing.JLabel getjOrganizer() {
        return jOrganizer;
    }

    public javax.swing.JPanel getjPanelContainTags() {
        return jPanelContainTags;
    }

    public javax.swing.JSeparator getjSeparator() {
        return jSeparator;
    }

    public javax.swing.JLabel getjTags() {
        return jTags;
    }

    public javax.swing.JLabel getjTitle() {
        return jTitle;
    }

    public void setRoundedPanel(com.uiteco.components.RoundedPanel roundedPanel) {
        this.roundedPanel = roundedPanel;
    }

    public void setRoundedPanel_Image(com.uiteco.components.RoundedPanel roundedPanel_Image) {
        this.roundedPanel_Image = roundedPanel_Image;
    }

    public void setjDateRange(javax.swing.JLabel jDateRange) {
        this.jDateRange = jDateRange;
    }

    public void setjImage(javax.swing.JLabel jImage) {
        this.jImage = jImage;
    }

    public void setjOrganizer(javax.swing.JLabel jOrganizer) {
        this.jOrganizer = jOrganizer;
    }

    public void setjPanelContainTags(javax.swing.JPanel jPanelContainTags) {
        this.jPanelContainTags = jPanelContainTags;
    }

    public void setjSeparator(javax.swing.JSeparator jSeparator) {
        this.jSeparator = jSeparator;
    }

    public void setjTags(javax.swing.JLabel jTags) {
        this.jTags = jTags;
    }

    public void setjTitle(javax.swing.JLabel jTitle) {
        this.jTitle = jTitle;
    }

    
    
    public void SetData(Model_OnePost data){
        jImage.setIcon(data.getImage());
        jTitle.setText(data.getTitle());
        jOrganizer.setText(data.getOrganizer());
        jDateRange.setText(data.getDateRange());
        
        //display on a panel the number of tags which a post has (based on database)
        int numberOfTags = data.getNumberOfTags();
        for(int i = 0; i < numberOfTags; i++){
            LabelTag tag = new LabelTag();
            jPanelContainTags.add(tag);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel = new com.uiteco.components.RoundedPanel();
        jTitle = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTags = new javax.swing.JLabel();
        jPanelContainTags = new javax.swing.JPanel();
        labelDaysLeft1 = new com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft();
        roundedPanel1 = new com.uiteco.components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jImage = new com.uiteco.components.RoundedImagePanel();

        setPreferredSize(new java.awt.Dimension(1170, 240));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel.setPreferredSize(new java.awt.Dimension(1170, 240));
        roundedPanel.setRoundBottomLeft(15);
        roundedPanel.setRoundBottomRight(15);
        roundedPanel.setRoundTopLeft(15);
        roundedPanel.setRoundTopRight(15);

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 24)); // NOI18N
        jTitle.setText("Title");

        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("jLabel3");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("jLabel1");

        jTags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-tag-24.png"))); // NOI18N
        jTags.setText("jLabel1");

        jPanelContainTags.setLayout(new java.awt.GridLayout(2, 2, 2, 3));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-global-24.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(jTags, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(341, 341, 341)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jDateRange, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTags, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelContainTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(labelDaysLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOrganizer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    protected OnePost_Parent() {
        _initComponents();
    }
    
    protected void _initComponents(){
        
        roundedPanel = new com.uiteco.components.RoundedPanel();
        roundedPanel_Image = new com.uiteco.components.RoundedPanel();
        jImage = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();
        jOrganizer = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jDateRange = new javax.swing.JLabel();
        jTags = new javax.swing.JLabel();
        jPanelContainTags = new javax.swing.JPanel();
        //labelUpcoming = new com.uiteco.OfCuocThiPanel.firstPage.LabelUpComing();

        setPreferredSize(new java.awt.Dimension(1170, 240));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel.setOpaque(false);
        roundedPanel.setPreferredSize(new java.awt.Dimension(1170, 240));
        roundedPanel.setRoundBottomLeft(15);
        roundedPanel.setRoundBottomRight(15);
        roundedPanel.setRoundTopLeft(15);
        roundedPanel.setRoundTopRight(15);

        roundedPanel_Image.setRoundBottomLeft(15);
        roundedPanel_Image.setRoundBottomRight(15);
        roundedPanel_Image.setRoundTopLeft(15);
        roundedPanel_Image.setRoundTopRight(15);

        jImage.setText("jLabel1");

        javax.swing.GroupLayout roundedPanel_ImageLayout = new javax.swing.GroupLayout(roundedPanel_Image);
        roundedPanel_Image.setLayout(roundedPanel_ImageLayout);
        roundedPanel_ImageLayout.setHorizontalGroup(
            roundedPanel_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel_ImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedPanel_ImageLayout.setVerticalGroup(
            roundedPanel_ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel_ImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTitle.setFont(new java.awt.Font("Circular Std Bold", 0, 24)); // NOI18N
        jTitle.setText("Title");

        jOrganizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-organization-24.png"))); // NOI18N
        jOrganizer.setText("jLabel3");

        jSeparator.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setPreferredSize(new java.awt.Dimension(240, 8));

        jDateRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-calendar-24.png"))); // NOI18N
        jDateRange.setText("jLabel1");

        jTags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/uiteco/OfCuocThiPanel/Components/competitionImages/icons8-tag-24.png"))); // NOI18N
        jTags.setText("jLabel1");
        
        jPanelContainTags.setLayout(new java.awt.GridLayout(2, 2, 2, 3));
        
        javax.swing.GroupLayout jPanelContainTagsLayout = new javax.swing.GroupLayout(jPanelContainTags);
        jPanelContainTags.setLayout(jPanelContainTagsLayout);
        jPanelContainTagsLayout.setHorizontalGroup(
            jPanelContainTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );
        jPanelContainTagsLayout.setVerticalGroup(
            jPanelContainTagsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jDateRange;
    private com.uiteco.components.RoundedImagePanel jImage;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jOrganizer;
    protected javax.swing.JPanel jPanelContainTags;
    protected javax.swing.JSeparator jSeparator;
    protected javax.swing.JLabel jTags;
    protected javax.swing.JLabel jTitle;
    private com.uiteco.OfCuocThiPanel.firstPage.LabelDaysLeft labelDaysLeft1;
    protected com.uiteco.components.RoundedPanel roundedPanel;
    private com.uiteco.components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
