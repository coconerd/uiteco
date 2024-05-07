package com.raven.scroll;

import com.raven.scroll.ScrollBarWin11UI;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.Objects;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Raven
 */
public class ScrollPaneWin11 extends JScrollPane {

    public ScrollPaneWin11() {
        getVerticalScrollBar().setUI(new ScrollBarWin11UI());
        getHorizontalScrollBar().setUI(new ScrollBarWin11UI());
        setLayout(new ScrollLayout());
    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        EventQueue.invokeLater(() -> {
            setComponentZOrder(getVerticalScrollBar(), 0);
            setComponentZOrder(getHorizontalScrollBar(), 1);
            setComponentZOrder(getViewport(), 2);
            getVerticalScrollBar().setOpaque(false);
            getHorizontalScrollBar().setOpaque(false);
        });
    }

    public void scrollToTop() {
        int topValue = 0;
        _scrollTo(topValue);
    }

    public void scrollToBottom() {
        int bottomValue = getVerticalScrollBar().getMaximum();
        _scrollTo(bottomValue);
    }

    private void _scrollTo(int targetValue) {
        int oldValue = getVerticalScrollBar().getValue();
        int animationDuration = 500;
        int steps = 50;
        
        Timer timer = new Timer(animationDuration / steps, new ActionListener() {
            int step = 0;
            public void actionPerformed(ActionEvent e) {
                if (step >= steps) {
                    ((Timer)e.getSource()).stop();
                    return;
                }
                int value = (int) (oldValue + (targetValue - oldValue) * ((double)step / steps));
                verticalScrollBar.setValue(value);
                step++;
            }
        });
        timer.start();

    }

    private class ScrollLayout extends ScrollPaneLayout {

        @Override
        public void layoutContainer(Container parent) {
            super.layoutContainer(parent);
            if (parent instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) parent;
                Rectangle rec = scroll.getViewport().getBounds();
                Insets insets = parent.getInsets();
                int rhHeight = 0;
                if (scroll.getColumnHeader() != null) {
                    Rectangle rh = scroll.getColumnHeader().getBounds();
                    rhHeight = rh.height;
                }
                rec.width = scroll.getBounds().width - (insets.left + insets.right);
                rec.height = scroll.getBounds().height - (insets.top + insets.bottom) - rhHeight;
                if (Objects.nonNull(viewport)) {
                    viewport.setBounds(rec);
                }
                if (!Objects.isNull(hsb)) {
                    Rectangle hrc = hsb.getBounds();
                    hrc.width = rec.width;
                    hsb.setBounds(hrc);
                }
            }
        }
    }
}
