package com.uiteco.main;

import com.uiteco.auth.AuthView;
import com.uiteco.auth.Permissible;
import com.uiteco.auth.PermissibleNotPermittedException;
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
    private static AuthView authView;

    /**
     * Implementation for Permissible interface
     */
    private static Permissible sessionManager = new Permissible() {
        private static byte[] accessKey;

        @Override
        public byte[] getAccessKey() {
            return accessKey;
        }

        @Override
        public void setAccessKey(byte[] _accessKey) {
            accessKey = _accessKey;
        }
    };

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

                session = new Session(sessionManager);

                if (session.isPermitted()) {
                    new MainFrame().setVisible(true);
                } else {
                    authView = new AuthView();
                    try {
                        session.permitComponent(sessionManager, authView.getAuthModel());
                    } catch (PermissibleNotPermittedException e) {
                        e.printStackTrace();
                    }
                    authView.setVisible(true);
                }

//                final AuthView af = authView;
                session.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("permitted")) {
                            try {
                                if (session.isPermitted()) {
                                    if (authView != null) {
                                        authView.setVisible(false);
                                        session.revokeComponent(sessionManager, authView.getAuthModel());
                                        authView.dispose();
                                    }
                                    mainFrame = new MainFrame();
                                    session.permitComponent(sessionManager, mainFrame);
                                    mainFrame.setVisible(true);

                                } else {
                                    if (mainFrame != null) {
                                        mainFrame.setVisible(false);
                                        session.revokeComponent(sessionManager, mainFrame);
                                        mainFrame.dispose();
                                    }
                                    authView = new AuthView();
                                    session.permitComponent(sessionManager, authView.getAuthModel());
                                    authView.setVisible(true);
                                }
                            } catch (PermissibleNotPermittedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });

                running = true;
            }
        });
    }
}
