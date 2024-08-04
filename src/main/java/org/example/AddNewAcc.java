package org.example;

import com.travel.clientstrips.User;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class AddNewAcc extends JFrame {

    private final JTextField passportField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField birthDateField = new JTextField(); // Changed from ageField to birthDateField
    private final JTextField phoneField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public AddNewAcc() {
        super("Add New Account");
        setSize(950, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        Font font = new Font("Chilanka", Font.BOLD, 20);
        Font fieldsFont = new Font("Chilanka", Font.PLAIN, 18);
        Color backgroundColor = Color.CYAN;

        JLabel heading = new JLabel("Add New Account");
        heading.setFont(new Font("Chilanka", Font.BOLD, 30));
        heading.setBounds(0, 5, getWidth(), 40);
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(Color.blue);
        add(heading);

        JLabel passportLabel = new JLabel("Passport Number:");
        passportLabel.setBounds(200, 55, 200, 35);
        passportLabel.setFont(font);
        add(passportLabel);

        passportField.setBounds(420, 55, 300, 35);
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

        JLabel birthDateLabel = new JLabel("Birth Date (YYYY-MM-DD):"); // Updated label
        birthDateLabel.setFont(font);
        birthDateLabel.setBounds(200, 165, 300, 35);
        add(birthDateLabel);

        birthDateField.setBounds(470, 165, 200, 35);
        birthDateField.setToolTipText("Enter your birth date");
        birthDateField.setFont(fieldsFont);
        add(birthDateField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(font);
        phoneLabel.setBounds(200, 220, 200, 35);
        add(phoneLabel);

        phoneField.setBounds(420, 220, 300, 35);
        phoneField.setToolTipText("Enter your phone number");
        phoneField.setFont(fieldsFont);
        add(phoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(font);
        emailLabel.setBounds(200, 275, 200, 35);
        add(emailLabel);

        emailField.setBounds(420, 275, 300, 35);
        emailField.setToolTipText("Enter your email");
        emailField.setFont(fieldsFont);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font);
        passwordLabel.setBounds(200, 330, 200, 35);
        add(passwordLabel);

        passwordField.setBounds(420, 330, 300, 35);
        passwordField.setToolTipText("Enter your password");
        passwordField.setFont(fieldsFont);
        add(passwordField);

        getContentPane().setBackground(backgroundColor);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(0, 385, getWidth(), 50);
        buttonsPanel.setBackground(backgroundColor);

        JButton submitButton = new JButton("Submit", new ImageIcon("src//images//all.png"));
        submitButton.setFont(fieldsFont);
        submitButton.setToolTipText("Click to register");
        submitButton.addActionListener(e -> register());
        buttonsPanel.add(submitButton);

        add(buttonsPanel);
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
            writer.write( user.getName() + "-" + user.getPassword()  + "-" + user.getAge() + "-" + user.getPassportNumber() + "-" + user.getPhoneNumber() + "-" + user.getEmail()+"-"+user.getId());
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
