package com.uiteco.main;

import com.uiteco.auth.AuthView;
import com.uiteco.auth.Session;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author nddmi
 */

public class App {
    private static Session session; 
    private static MainFrame mainFrame;
    private static boolean running = false;


    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static boolean isRunning() {
        return running;
    }
    
    public static Session getSession() {
        return session;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AuthView authView = null;

                session = new Session();
                if (session.isPermitted()) {
                    new MainFrame().setVisible(true);
                } else {
                    authView = new AuthView();
                    authView.getAuthModel().addPropertyChangeListener(session);
                    authView.setVisible(true);
                }

                final AuthView af = authView;
                session.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("permitted")) {
                            if (session.isPermitted()) {
                                if (af != null) {
                                    af.setVisible(false);
                                    af.dispose();
                                }
                                mainFrame = new MainFrame();
                                mainFrame.setVisible(true);
                            }
                        }
                    }
                });

                running = true;
            }
        });
    }
}
