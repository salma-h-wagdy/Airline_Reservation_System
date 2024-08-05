package com.travel.clientstrips;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TripList extends JFrame {
    private final DefaultTableModel model = new DefaultTableModel();
    private final String username;

    public TripList(String username) {
        super("Trip List");
        this.username = username;
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define table columns
        model.addColumn("Flight ID");
        model.addColumn("Source");
        model.addColumn("Destination");
        model.addColumn("Flight Type");
        model.addColumn("Flight Date");
        model.addColumn("Duration");
        model.addColumn("One-Way Ticket");
        model.addColumn("Total Cost");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        loadTripsFromFile();

        setVisible(true);
    }

    private void loadTripsFromFile() {
        String filePath = "src/main/java/com/travel/clientstrips/Trips.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Check the number of columns and parse accordingly
                if (parts.length == 8 || parts.length == 9) {
                    // Check if the username matches
                    if (parts.length == 8 && parts[7].equals(username) ||
                            parts.length == 9 && parts[8].equals(username)) {
                        // Add row to the table model
                        model.addRow(parts);
                    }
                } else {
                    System.err.println("Unexpected CSV format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This is for testing purposes. Pass the logged-in username.
        SwingUtilities.invokeLater(() -> new TripList("User1"));
    }
}
