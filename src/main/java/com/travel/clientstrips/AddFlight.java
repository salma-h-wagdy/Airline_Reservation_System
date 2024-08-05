package com.travel.clientstrips;

import javax.swing.*;
import java.awt.*;

public class AddFlight extends JFrame {
    private final JTextField idField = new JTextField();
    private final JTextField sourceField = new JTextField();
    private final JTextField destinationField = new JTextField();
    private final JTextField departureTimeField = new JTextField();
    private final JTextField arrivalTimeField = new JTextField();
    private final JButton addButton = new JButton("Add Flight");
    private final JButton cancelButton = new JButton("Cancel");
    private Image backgroundImage;
    private boolean flightAdded = false; // Flag to check if a flight was added

    public AddFlight() {
        super("Add Flight");
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

            JLabel heading = new JLabel("Add Flight");
            heading.setFont(new Font("Chilanka", Font.BOLD, 30));
            heading.setBounds(0, 10, getWidth(), 40);
            heading.setHorizontalAlignment(JLabel.CENTER);
            heading.setForeground(Color.blue);
            add(heading);

            JLabel idLabel = new JLabel("ID:");
            idLabel.setBounds(200, 60, 200, 35);
            idLabel.setFont(font);
            add(idLabel);

            idField.setBounds(420, 60, 300, 35);
            idField.setToolTipText("Enter flight ID");
            idField.setFont(fieldsFont);
            add(idField);

            JLabel sourceLabel = new JLabel("Source:");
            sourceLabel.setFont(font);
            sourceLabel.setBounds(200, 110, 200, 35);
            add(sourceLabel);

            sourceField.setBounds(420, 110, 300, 35);
            sourceField.setToolTipText("Enter flight source");
            sourceField.setFont(fieldsFont);
            add(sourceField);

            JLabel destinationLabel = new JLabel("Destination:");
            destinationLabel.setFont(font);
            destinationLabel.setBounds(200, 160, 200, 35);
            add(destinationLabel);

            destinationField.setBounds(420, 160, 300, 35);
            destinationField.setToolTipText("Enter flight destination");
            destinationField.setFont(fieldsFont);
            add(destinationField);

            JLabel departureTimeLabel = new JLabel("Departure Time:");
            departureTimeLabel.setFont(font);
            departureTimeLabel.setBounds(200, 210, 200, 35);
            add(departureTimeLabel);

            departureTimeField.setBounds(420, 210, 300, 35);
            departureTimeField.setToolTipText("Enter flight departure time");
            departureTimeField.setFont(fieldsFont);
            add(departureTimeField);

            JLabel arrivalTimeLabel = new JLabel("Arrival Time:");
            arrivalTimeLabel.setFont(font);
            arrivalTimeLabel.setBounds(200, 260, 200, 35);
            add(arrivalTimeLabel);

            arrivalTimeField.setBounds(420, 260, 300, 35);
            arrivalTimeField.setToolTipText("Enter flight arrival time");
            arrivalTimeField.setFont(fieldsFont);
            add(arrivalTimeField);

            // Create the buttons panel
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0)); // Center align with spacing between buttons
            buttonsPanel.setBounds(0, 315, 1000, 100); // Full width, adjust as needed
            buttonsPanel.setOpaque(false); // Make the panel transparent so the background is visible

            addButton.setFont(fieldsFont);
            addButton.setToolTipText("Click to add flight");
            addButton.addActionListener(e -> addFlight());
            buttonsPanel.add(addButton);

            cancelButton.setFont(fieldsFont);
            cancelButton.setToolTipText("Cancel adding flight");
            cancelButton.addActionListener(e -> dispose()); // Close the form
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

    private void addFlight() {
        try {
            int id = Integer.parseInt(idField.getText());
            String source = sourceField.getText();
            String destination = destinationField.getText();
            String departureTime = departureTimeField.getText();
            String arrivalTime = arrivalTimeField.getText();

            Flights flight = new Flights(id, source, destination, departureTime, arrivalTime);

            // Call the FlightManager to save the flight
            FlightManager flightManager = new FlightManager();
            flightManager.addFlightToFile(flight);

            flightAdded = true; // Set the flag to true
            JOptionPane.showMessageDialog(this, "Flight added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the form after adding
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getters for the flight data
    public int getId() {
        return Integer.parseInt(idField.getText());
    }

    public String getSource() {
        return sourceField.getText();
    }

    public String getDestination() {
        return destinationField.getText();
    }

    public String getDepartureTime() {
        return departureTimeField.getText();
    }

    public String getArrivalTime() {
        return arrivalTimeField.getText();
    }

    public boolean isFlightAdded() {
        return flightAdded;
    }

    public static void main(String[] args) {
        new AddFlight();
    }
}
