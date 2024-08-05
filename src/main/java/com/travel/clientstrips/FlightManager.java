package com.travel.clientstrips;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FlightManager {

    public void addFlight(String username) {
        Admin admin=new Admin();
        if (admin.validateAdmin(username)) {
            AddFlight addFlightForm = new AddFlight();

            // Wait for the form to close and then check if a flight was added
            addFlightForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    if (addFlightForm.isFlightAdded()) {
                        // Retrieve flight data from the form
                        Flights flight = new Flights(
                                addFlightForm.getId(),
                                addFlightForm.getSource(),
                                addFlightForm.getDestination(),
                                addFlightForm.getDepartureTime(),
                                addFlightForm.getArrivalTime()
                        );

                        // Add flight to the file
                        addFlightToFile(flight);
                    }
                }
            });

        } else {
            System.out.println("Permission denied. Admin does not have the required privileges.");
        }
    }

    public void addFlightToFile(Flights flight) {
        String filePath = "src/main/java/com/travel/clientstrips/Flights.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(flight.getSource() + "-" + flight.getDestinantion() + "-" + flight.getDepartureTime() + "-" + flight.getArrivalTime() + "-" + flight.getId());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Flight added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
