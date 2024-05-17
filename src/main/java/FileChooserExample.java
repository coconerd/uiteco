import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserExample extends JFrame {

    public FileChooserExample() {
        // Set up the frame
        setTitle("File Chooser Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a button to open the file chooser
        JButton openButton = new JButton("Open File Chooser");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });

        // Add the button to the frame
        setLayout(new FlowLayout());
        add(openButton);
    }

    private void openFileChooser() {
        // Create a JFileChooser instance
        JFileChooser fileChooser = new JFileChooser();

        // Set the file chooser to open in the user's home directory
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Show the file chooser dialog and get the user's action
        int result = fileChooser.showOpenDialog(this);

        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Perform actions with the selected file (e.g., upload)
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("File selection canceled");
        }
    }

    public static void main(String[] args) {
        // Run the program
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileChooserExample().setVisible(true);
            }
        });
    }
}
