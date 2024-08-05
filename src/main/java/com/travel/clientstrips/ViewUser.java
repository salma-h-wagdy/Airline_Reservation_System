package com.travel.clientstrips;

import javax.swing.*;
import java.awt.*;

public class ViewUser extends JFrame {

    private Image backgroundImage;
    private User user;

    public ViewUser(String username) {
        super("User Information");

        // Fetch user information based on the username
        user = new User().validateUser(username);

        // Check if the user is null
        if (user == null) {
            JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        ImageIcon imageIcon = new ImageIcon("src\\images\\img_2.png");
        backgroundImage = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        // Set the custom panel as the content pane
        setContentPane(new CustomPanel());

        setVisible(true);
    }

    private class CustomPanel extends JPanel {

        public CustomPanel() {
            setLayout(new GridBagLayout()); // Use GridBagLayout for centering components
            setOpaque(false); // Make the panel transparent so the background is visible

            // Define font
            Font labelFont = new Font("Chilanka", Font.BOLD, 18);

            // Create labels to display user info
            JLabel lblUsername = createLabel("Name: " + user.getName(), labelFont);
            JLabel lblAge = createLabel("Age: " + user.getAge(), labelFont);
            JLabel lblPassportNumber = createLabel("Passport Number: " + user.getPassportNumber(), labelFont);
            JLabel lblPhoneNumber = createLabel("Phone: " + user.getPhoneNumber(), labelFont);
            JLabel lblEmail = createLabel("Email: " + user.getEmail(), labelFont);

            // Create a panel to hold the labels
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false); // Make the panel transparent

            // Add labels to the panel
            infoPanel.add(lblUsername);
            infoPanel.add(Box.createVerticalStrut(10)); // Space between labels
            infoPanel.add(lblAge);
            infoPanel.add(Box.createVerticalStrut(10));
            infoPanel.add(lblPassportNumber);
            infoPanel.add(Box.createVerticalStrut(10));
            infoPanel.add(lblPhoneNumber);
            infoPanel.add(Box.createVerticalStrut(10));
            infoPanel.add(lblEmail);

            // Add the info panel to the center of the main panel
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            add(infoPanel, gbc);
        }

        private JLabel createLabel(String text, Font font) {
            JLabel label = new JLabel(text);
            label.setFont(font);
            label.setForeground(Color.BLACK);
            label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align label
            return label;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        // Test the ViewUser class
        new ViewUser("testuser");
    }
}
