package com.uiteco.OfCuocThiPanel.firstPage.slideShow;

import com.uiteco.components.RoundedPanel;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class SlideShow_AutoSlide extends JLayeredPane {

    /**
     * @return the panel
     */
    public static RoundedPanel getPanel() {
        return panel;
    }

    private static RoundedPanel panel;
    private final Pagination pagination;
    private final Animator animator;
    private Timer timer;
    private final MigLayout layout;
    private Component componentShow;
    private Component componentOut;
    private int currentIndex;
    private boolean next;
    private boolean isSlideShowPlay;

    public SlideShow_AutoSlide() {
        
        setOpaque(true);
        setBackground(new Color(200, 200, 200));
        layout = new MigLayout("inset 0");
        panel = new RoundedPanel();
        
        //panel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        panel.setRoundBottomLeft(30);
        panel.setRoundBottomRight(30);
        panel.setRoundTopLeft(30);
        panel.setRoundTopRight(30);

        pagination = new Pagination();
        pagination.setEventPagination(new EventPagination() {
            @Override
            public void onClick(int pageClick) {
                if (!animator.isRunning()) {
                    timer.restart();
                    next = currentIndex < pageClick;
                    if (next) {
                        componentOut = getPanel().getComponent(checkNext(currentIndex));
                        currentIndex = getNext(pageClick - 1);
                        componentShow = getPanel().getComponent(currentIndex);
                        animator.start();
                    } else {
                        componentOut = getPanel().getComponent(checkBack(currentIndex));
                        currentIndex = getBack(pageClick + 1);
                        componentShow = getPanel().getComponent(currentIndex);
                        animator.start();
                    }
                }
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                componentShow.setVisible(true);
                componentOut.setVisible(true);
                pagination.setIndex(currentIndex);
            }

            @Override
            public void timingEvent(float fraction) {
                int imageGap = 0; // Gap in pixels between images
                double width = getPanel().getWidth();
                int location = (int) (width * fraction); // Calculate position based on fraction

                int imageWidth = (int) (width - imageGap); // Calculate image width with gap
                if (next) {
                    layout.setComponentConstraints(componentShow, "pos 0 0 " + imageWidth + " 100%");
                    layout.setComponentConstraints(componentOut, "pos 0" + imageWidth + " 100%");
                } else {
                    layout.setComponentConstraints(componentOut, "pos 0" + imageWidth + " 100%");
                    layout.setComponentConstraints(componentShow, "pos 0 0 " + imageWidth + " 100%");
                }
                
                pagination.setAnimation(fraction);
                getPanel().revalidate();
            }

            @Override
            public void end() {
                componentOut.setVisible(false);
                layout.setComponentConstraints(componentShow, "pos 0 0 100% 100%, width 100%");
            }
        };
        animator = new Animator(1000, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        setLayer(pagination, JLayeredPane.POPUP_LAYER);
        panel.setLayout(layout);
        setLayout(new MigLayout("fill, inset 0", "[fill, center]", "3[fill]3"));
        add(pagination, "pos 0.5al 1al n n");
        add(panel, "w 100%-6!");
        timer = new Timer(3500, e -> next());
    }

    public void initSlideshow(List<Component> imageList) {
        if (imageList != null && imageList.size() >= 2) {
            for (Component image : imageList) {
                image.setVisible(false);
                getPanel().add(image, "pos 0 0 0 0");
            }
            if (getPanel().getComponentCount() > 0) {
                componentShow = getPanel().getComponent(0);
                componentShow.setVisible(true);
                layout.setComponentConstraints(componentShow, "pos 0 0 100% 100%");
                System.out.println("done");
            }
            pagination.setTotalPage(getPanel().getComponentCount());
            pagination.setCurrentIndex(0);
            timer.start();
        }
    }

    public void next() {
        if (!animator.isRunning()) {
            timer.restart();
            next = true;
            currentIndex = getNext(currentIndex);
            componentShow = getPanel().getComponent(currentIndex);
            componentOut = getPanel().getComponent(checkNext(currentIndex - 1));
            animator.start();
        }

    }

    public void back() {
        if (!animator.isRunning()) {
            timer.restart();
            next = false;
            currentIndex = getBack(currentIndex);
            componentShow = getPanel().getComponent(currentIndex);
            componentOut = getPanel().getComponent(checkBack(currentIndex + 1));
            animator.start();
        }
    }

    private int getNext(int index) {
        if (index == getPanel().getComponentCount() - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int checkNext(int index) {
        if (index == -1) {
            return getPanel().getComponentCount() - 1;
        } else {
            return index;
        }
    }

    private int getBack(int index) {
        if (index == 0) {
            return getPanel().getComponentCount() - 1;
        } else {
            return index - 1;
        }
    }

    private int checkBack(int index) {
        if (index == getPanel().getComponentCount()) {
            return 0;
        } else {
            return index;
        }
    }

    public void stop() {
        isSlideShowPlay = false;
        timer.stop();
    }

}
