/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.uiteco.contentPanels.suKienPanel.components;

import java.awt.Component;
import java.util.ArrayList;
import com.uiteco.components.GradientPanel;
import com.uiteco.components.ImageAvatar;
import javax.swing.JLayeredPane;
import com.uiteco.components.RoundedImagePanel;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Dimension;

/**
 *
 * @author nddmi
 */
public class SlideShowView extends GradientPanel implements PropertyChangeListener {

    private SlideShowModel slideShowModel;
    private final Animator animator;
    private final MigLayout migLayout;
    private final Timer timer;
    private Component componentIn;
    private Component componentOut;
//    private ArrayList<Component> components;
    private int imageRadius;

    public static final int DEFAULT_IMAGE_RADIUS = 20;

    /**
     * Creates new form SlideShowView
     */
    public SlideShowView() {
        this.imageRadius = DEFAULT_IMAGE_RADIUS;
        this.setSlideShowModel(new SlideShowModel());
        this.slideShowModel.addPropertyChangeListener(this);

        initComponents();

//        this.setOpaque(true);
//        this.components = new ArrayList<Component>();
        this.migLayout = new MigLayout("inset 0");
        this.imageContainer.setLayout(migLayout);
        _populateSlideShow();

        TimingTarget target = new TimingTargetAdapter() {

            @Override
            public void begin() {
                componentIn.setVisible(true);
                componentOut.setVisible(true);
            }

            @Override
            public void timingEvent(float fraction) {
                double width = imageContainer.getWidth();
                int location = (int) (width * fraction);
                int locationShow = (int) (width * (1f - fraction));
                if (slideShowModel.isNext()) {
                    migLayout.setComponentConstraints(componentIn, "pos " + locationShow + " 0 100% 100%, w 100%!");
                    migLayout.setComponentConstraints(componentOut, "pos -" + location + " 0 " + (width - location) + " 100%");
                } else {
                    migLayout.setComponentConstraints(componentIn, "pos -" + locationShow + " 0 " + (width - locationShow) + " 100%");
                    migLayout.setComponentConstraints(componentOut, "pos " + location + " 0 100% 100%, w 100%!");
                }
                // pagination.setAnimation(fraction); ??
                imageContainer.revalidate();
            }

            @Override
            public void end() {
                componentOut.setVisible(false);
                migLayout.setComponentConstraints(componentIn, "pos 0 0 100% 100%, width 100%");
            }
        };

//        setLayer(pagination, JLayeredPane.POPUP_LAYER); ??
        this.animator = new Animator(1000, target);
        this.animator.setResolution(0);
        this.animator.setAcceleration(0f);
        this.animator.setDeceleration(1f);

        timer = new Timer(6000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                slideShowModel.switchNextPage();
            }
        });
        timer.start();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("currentPage")) {
            timer.restart();
            int oldPage = (Integer) evt.getOldValue();
            int newPage = (Integer) evt.getNewValue();
            setComponentOut(imageContainer.getComponent(_pageToIndex(oldPage)));
            setComponentIn(imageContainer.getComponent(_pageToIndex(newPage)));
            animator.start();
            System.out.println(((RoundedImagePanel) componentOut).getImage());
        }
    }

    private void _populateSlideShow() {
        ArrayList<SuKienModel> suKienList = slideShowModel.getSuKienList();
        if (suKienList.size() >= 2) {
            for (SuKienModel suKien : suKienList) {
                ImageIcon image = suKien.getThumbnail();
                RoundedImagePanel imgPanel = RoundedImagePanel.getRoundedImagePanel(getImageRadius());
                imgPanel.setMaximumSize(new Dimension(image.getIconWidth(), image.getIconHeight()));

                imgPanel.setImage(suKien.getThumbnail());
                imgPanel.setVisible(false);
                imageContainer.add(imgPanel, "pos 0 0 0 0");
            }

            if (imageContainer.getComponentCount() > 0) {
                setComponentIn(imageContainer.getComponent(0));
                componentIn.setVisible(true);
                migLayout.setComponentConstraints(componentIn, "pos 0 0 100% 100%");

            }
        }
    }

    public int getImageRadius() {
        return this.imageRadius;
    }

//    public Component getPage(int index) {
//        return this.components.get(index);
//    }
    public SlideShowModel getSlideShowModel() {
        return slideShowModel;
    }

    public Animator getAnimator() {
        return animator;
    }

    public MigLayout getMigLayout() {
        return migLayout;
    }

    public Component getComponentShow() {
        return componentIn;
    }

    public Component getComponentOut() {
        return componentOut;
    }

    public ImageAvatar getBackButton() {
        return forwardButton;
    }

    public ImageAvatar getForwardButton() {
        return backButton;
    }

    public RoundedImagePanel getImageContainer() {
//        return imageContainer;
        return null;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setImageRadius(int imageRadius) {
        this.imageRadius = imageRadius;
    }

//    public void setComponents(ArrayList<Component> components) {
//        this.components = components;
//    }
//
//    public void setPage(int index, Component page) {
//        this.components.set(index, page);
//    }
    public void setSlideShowModel(SlideShowModel slideShowModel) {
        this.slideShowModel = slideShowModel;
    }

    public void setComponentIn(Component componentShow) {
        this.componentIn = componentShow;
    }

    public void setComponentOut(Component componentOut) {
        this.componentOut = componentOut;
    }

    public void setImageContainer(RoundedImagePanel imageContainer) {
//        this.imageContainer = imageContainer;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    private int _pageToIndex(int page) {
        return page - 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        title = new javax.swing.JLabel();
        imageContainer = com.uiteco.components.RoundedPanel.getRoundedPanel(getImageRadius());
        forwardButton = new com.uiteco.components.ImageAvatar();
        backButton = new com.uiteco.components.ImageAvatar();

        setBackground(new java.awt.Color(242, 243, 244));
        setForeground(new java.awt.Color(242, 243, 244));
        setAutoscrolls(true);
        setColor1(new java.awt.Color(1, 186, 239));
        setColor2(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(728, 800));
        setLayout(new java.awt.GridBagLayout());

        title.setFont(new java.awt.Font("SVN-Adam Gorry", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(251, 251, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-flame-48.png"))); // NOI18N
        title.setText("Các sự kiện nổi bật trong tuần");
        title.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(title, gridBagConstraints);

        imageContainer.setPreferredSize(new java.awt.Dimension(700, 950));

        javax.swing.GroupLayout imageContainerLayout = new javax.swing.GroupLayout(imageContainer);
        imageContainer.setLayout(imageContainerLayout);
        imageContainerLayout.setHorizontalGroup(
            imageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageContainerLayout.setVerticalGroup(
            imageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        add(imageContainer, gridBagConstraints);

        forwardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-duotone-forward-36.png"))); // NOI18N
        forwardButton.setMinimumSize(new java.awt.Dimension(32, 32));
        forwardButton.setPreferredSize(new java.awt.Dimension(32, 32));
        forwardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forwardButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forwardButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forwardButtonMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(forwardButton, gridBagConstraints);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-duotone-back-36.png"))); // NOI18N
        backButton.setMinimumSize(new java.awt.Dimension(32, 32));
        backButton.setPreferredSize(new java.awt.Dimension(32, 32));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(backButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
//        if (animator.isRunning()) {
            animator.stop();
//        }
        slideShowModel.switchPreviousPage();
    }//GEN-LAST:event_backButtonMouseClicked

    private void forwardButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseClicked
        // TODO add your handling code here:
//        if (animator.isRunning()) {
            animator.stop();
//        }
        slideShowModel.switchNextPage();
    }//GEN-LAST:event_forwardButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonMouseEntered

    private void forwardButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_forwardButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonMouseExited

    private void forwardButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_forwardButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.uiteco.components.ImageAvatar backButton;
    private com.uiteco.components.ImageAvatar forwardButton;
    private com.uiteco.components.RoundedPanel imageContainer;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
