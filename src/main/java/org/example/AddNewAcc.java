package org.example;

import com.travel.clientstrips.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AddNewAcc extends JFrame {
    private final JTextField passportField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField birthDateField = new JTextField();
    private final JTextField phoneField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private Image backgroundImage;

    public AddNewAcc() {
        super("Add New Account");
        setSize(950, 720);
        setLocationRelativeTo(null);
        setResizable(false);

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("src\\images\\img_1.png");
        backgroundImage = imageIcon.getImage().getScaledInstance(950, 720, Image.SCALE_SMOOTH);

        // Set the custom panel as the content pane
        setContentPane(new CustomPanel());

        setVisible(true);
    }

    private class CustomPanel extends JPanel {
        public CustomPanel() {
            setLayout(null); // Use null layout to manually set component bounds

            // Define fonts
            Font font = new Font("Chilanka", Font.BOLD, 20);
            Font fieldsFont = new Font("Chilanka", Font.PLAIN, 18);

            JLabel heading = new JLabel("Add New Account");
            heading.setFont(new Font("Chilanka", Font.BOLD, 30));
            heading.setBounds(0, 10, getWidth(), 40);
            heading.setHorizontalAlignment(JLabel.CENTER);
            heading.setForeground(Color.blue);
            add(heading);

            JLabel passportLabel = new JLabel("Passport Number:");
            passportLabel.setBounds(200, 60, 200, 35);
            passportLabel.setFont(font);
            add(passportLabel);

            passportField.setBounds(420, 60, 300, 35);
            passportField.setToolTipText("Enter client passport number");
            passportField.setFont(fieldsFont);
            add(passportField);

            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setFont(font);
            nameLabel.setBounds(200, 110, 200, 35);
            add(nameLabel);

            nameField.setBounds(420, 110, 300, 35);
            nameField.setToolTipText("Enter your name");
            nameField.setFont(fieldsFont);
            add(nameField);

            JLabel birthDateLabel = new JLabel("Birth Date (YYYY-MM-DD):");
            birthDateLabel.setFont(font);
            birthDateLabel.setBounds(200, 160, 300, 35);
            add(birthDateLabel);

            birthDateField.setBounds(470, 160, 200, 35);
            birthDateField.setToolTipText("Enter your birth date");
            birthDateField.setFont(fieldsFont);
            add(birthDateField);

            JLabel phoneLabel = new JLabel("Phone Number:");
            phoneLabel.setFont(font);
            phoneLabel.setBounds(200, 210, 200, 35);
            add(phoneLabel);

            phoneField.setBounds(420, 210, 300, 35);
            phoneField.setToolTipText("Enter your phone number");
            phoneField.setFont(fieldsFont);
            add(phoneField);

            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setFont(font);
            emailLabel.setBounds(200, 260, 200, 35);
            add(emailLabel);

            emailField.setBounds(420, 260, 300, 35);
            emailField.setToolTipText("Enter your email");
            emailField.setFont(fieldsFont);
            add(emailField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(font);
            passwordLabel.setBounds(200, 310, 200, 35);
            add(passwordLabel);

            passwordField.setBounds(420, 310, 300, 35);
            passwordField.setToolTipText("Enter your password");
            passwordField.setFont(fieldsFont);
            add(passwordField);

            // Create the buttons panel
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0)); // Center align with spacing between buttons
            buttonsPanel.setBounds(0, 365, 1000, 100); // Full width, adjust as needed
            buttonsPanel.setOpaque(false); // Make the panel transparent so the background is visible

            JButton submitButton = new JButton("Submit");
            submitButton.setFont(fieldsFont);
            submitButton.setToolTipText("Click to register");
            submitButton.addActionListener(e -> register());
            buttonsPanel.add(submitButton);

            JButton cancelButton = new JButton("Cancel");
            cancelButton.setFont(fieldsFont);
            cancelButton.setToolTipText("Cancel registration");
            cancelButton.addActionListener(e -> dispose()); // Close the registration window
            buttonsPanel.add(cancelButton);

            // Add the buttons panel to the main panel
            add(buttonsPanel);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    private void register() {
        // Retrieve the input values
        String passportNumber = passportField.getText();
        String name = nameField.getText();
        String birthDateStr = birthDateField.getText(); // Birth date input as a string
        String phoneNumber = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword()); // Get the password

        // Calculate age from birth date
        int age = calculateAgeFromBirthDate(birthDateStr);

        // Generate a unique ID
        int id = generateUniqueId();

        // Create a User object
        User user = new User(id, name, age, passportNumber, phoneNumber, email, password);

        // Define the file path
        String filePath = "src/main/java/com/travel/clientstrips/Users.txt";

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getName() + "-" + user.getPassword() + "-" + user.getAge() + "-" + user.getPassportNumber() + "-" + user.getPhoneNumber() + "-" + user.getEmail() + "-" + user.getId());
            writer.newLine();
        } catch (IOException e) {
            showMessage("Error writing to file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "You are registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private int calculateAgeFromBirthDate(String birthDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the format
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthDate, currentDate);
            return period.getYears();
        } catch (DateTimeParseException e) {
            showMessage("Invalid birth date format. Please use YYYY-MM-DD.");
            return 0; // Handle this as needed
        }
    }

    private int generateUniqueId() {
        Set<Integer> usedIds = new HashSet<>();
        String filePath = "src/main/java/com/travel/clientstrips/Users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ID: ")) {
                    usedIds.add(Integer.parseInt(line.substring(4).trim()));
                }
            }
        } catch (IOException e) {
            // File might not exist yet; it’s okay to start with an empty set
        }

        Random random = new Random();
        int id;
        do {
            id = random.nextInt(1000000); // Generates a random ID, adjust range as needed
        } while (usedIds.contains(id));

        return id;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, null, JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new AddNewAcc();
    }
}
