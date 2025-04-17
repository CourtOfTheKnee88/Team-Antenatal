import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Antenatal Records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create buttons
        JButton addMotherButton = new JButton("Add Mother Record");
        JButton addMidwifeButton = new JButton("Add Midwife Record");

        // Add action listeners to buttons
        addMotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setDialogTitle("Select a PDF File");
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.getName().endsWith(".pdf")) {
                        JOptionPane.showMessageDialog(frame, "Selected file: " + selectedFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please select a valid PDF file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        addMidwifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setDialogTitle("Select a PDF File");
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile.getName().endsWith(".pdf")) {
                        JOptionPane.showMessageDialog(frame, "Selected file: " + selectedFile.getAbsolutePath());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please select a valid PDF file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add buttons to the panel
        panel.add(addMotherButton);
        panel.add(addMidwifeButton);

        // Add panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
