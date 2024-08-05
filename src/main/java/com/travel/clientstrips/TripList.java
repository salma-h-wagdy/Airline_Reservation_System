package com.travel.clientstrips;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class TripList extends JFrame {
    private final DefaultTableModel model = new DefaultTableModel();
    private final String username;
    private final String filePath = "src/main/java/com/travel/clientstrips/Trips.csv";

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
        model.addColumn("Departure Time");
        model.addColumn("Arrival Time");
        model.addColumn("One-Way Ticket");
        model.addColumn("Total Cost");

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        panel.add(deleteButton);
        panel.add(updateButton);
        add(panel, BorderLayout.SOUTH);

        loadTripsFromFile();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedFlight(table);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelectedFlight(table);
            }
        });

        setVisible(true);
    }

    private void loadTripsFromFile() {
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

    private void deleteSelectedFlight(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int confirmation = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this flight?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                // Remove the row from the table model
                model.removeRow(selectedRow);
                // Remove the row from the file
                updateFile();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No flight selected for deletion.");
        }
    }

    private void updateSelectedFlight(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String flightID = (String) model.getValueAt(selectedRow, 0);
            String newSource = JOptionPane.showInputDialog(this, "Enter new source:", model.getValueAt(selectedRow, 1));
            String newDestination = JOptionPane.showInputDialog(this, "Enter new destination:", model.getValueAt(selectedRow, 2));
            // Other fields can be updated similarly

            model.setValueAt(newSource, selectedRow, 1);
            model.setValueAt(newDestination, selectedRow, 2);
            // Update other fields similarly

            // Update the file
            updateFile();
        } else {
            JOptionPane.showMessageDialog(this, "No flight selected for updating.");
        }
    }

    public void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int row = 0; row < model.getRowCount(); row++) {
                StringBuilder sb = new StringBuilder();
                for (int col = 0; col < model.getColumnCount(); col++) {
                    sb.append(model.getValueAt(row, col));
                    if (col < model.getColumnCount() - 1) {
                        sb.append(",");
                    }
                }
                writer.write(sb.toString());
                writer.newLine();
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
