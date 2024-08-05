package org.example;

import com.travel.clientstrips.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.IOException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

public class Welcom extends JFrame {

    private Image backgroundImage;

    public Welcom() throws IOException {
        // Load the background image
        ImageIcon imageIcon = new ImageIcon("src\\images\\AirPlane.jpg");
        backgroundImage = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);

        // Set up the JFrame
        this.setContentPane(new CustomPanel());
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CustomPanel extends JPanel {
        public CustomPanel() {
            // Set layout manager
            setLayout(new BorderLayout());

            // Define fonts
            Font buttons_font = new Font("Chilanka", Font.PLAIN, 22);
            Font label_font = new Font("Comic Sans MS", Font.BOLD, 40);

            // Create and configure the welcome label
            JLabel welcomeLabel = new JLabel("Welcome to Airline Reservation System", JLabel.CENTER);
            welcomeLabel.setFont(label_font);
            welcomeLabel.setForeground(Color.WHITE);
            add(welcomeLabel, BorderLayout.NORTH);

            // Create and configure buttons
            JButton loginButton = new JButton("Login", new ImageIcon("src\\images\\Login.png"));
            loginButton.setFont(buttons_font);
            loginButton.setPreferredSize(new Dimension(200, 50)); // Bigger button size
            loginButton.addActionListener(e -> {
                Login loginWindow = new Login();
                loginWindow.setVisible(true);
            });

            JButton registerButton = new JButton("Register", new ImageIcon("src\\images\\Register.png"));
            registerButton.setFont(buttons_font);
            registerButton.setPreferredSize(new Dimension(200, 50)); // Bigger button size
            registerButton.addActionListener(e -> {
                AddNewAcc registerWindow = new AddNewAcc();
                registerWindow.setVisible(true);
            });

            // Create a panel to hold buttons with GridBagLayout for centering
            JPanel buttonPanel = new JPanel(new GridBagLayout());
            buttonPanel.setOpaque(false); // Make the panel transparent

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new java.awt.Insets(200, 10, 1, 10); // Add padding around buttons
            gbc.anchor = GridBagConstraints.CENTER;

            buttonPanel.add(loginButton, gbc);

            gbc.gridx = 1;
            buttonPanel.add(registerButton, gbc);

            // Add the button panel to the bottom of the CustomPanel
            add(buttonPanel, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            try {
                new Welcom();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void handleLogin(String username) throws IOException {
        setVisible(false); // Remove the current frame
        new MainMenu(username);
    }

    private void changeLookAndFeel() {
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        try {
            UIManager.setLookAndFeel(looks[1].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
