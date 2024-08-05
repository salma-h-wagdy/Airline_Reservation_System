package com.travel.clientstrips;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Flights {
    private int id;
    private String Source;
    private String Destinantion;
    private String departureTime;
    private String arrivalTime;
    String filePath = "src/main/java/com/travel/clientstrips/Flights.txt";
    public Flights() {}

    public Flights(int id, String source, String destinantion, String departureTime, String arrivalTime) {
        this.id = id;
        Source = source;
        Destinantion = destinantion;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", Source='" + Source + '\'' +
                ", Destination='" + Destinantion + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return Source;
    }

    public String getDestinantion() {
        return Destinantion;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setDestinantion(String destinantion) {
        Destinantion = destinantion;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> Flight_Source() {

        List<String> sources = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 5) { // Ensure there are enough parts in the line
                    String source = parts[0];
                    sources.add(source);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sources;
    }
    public List<String> readDestinationsFromFile(String source) {

        List<String> destinations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 5) {
                    String fileSource = parts[0];
                    String destination = parts[1];
                    if (fileSource.equals(source) && !destinations.contains(destination)) {
                        destinations.add(destination);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinations;
    }
    public boolean checkAvailability(String tripId, int numPassengers) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 6) {
                    String fileId = parts[4];
                    int availableSeats = Integer.parseInt(parts[5]);
                    if (fileId.equals(tripId) && availableSeats >= numPassengers) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateAvailability(String tripId, int numPassengers) {
        List<String> lines = new ArrayList<>();
        boolean tripFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length >= 6) {
                    String fileId = parts[4];
                    int availableSeats = Integer.parseInt(parts[5]);
                    if (fileId.equals(tripId)) {
                        tripFound = true;
                        availableSeats -= numPassengers;
                        if (availableSeats < 0) {
                            availableSeats = 0; // Prevent negative seat numbers
                        }
                        lines.add(String.join("-", parts[0], parts[1], parts[2], parts[3], fileId, String.valueOf(availableSeats)));
                    } else {
                        lines.add(line);
                    }
                } else {
                    lines.add(line); // Keep lines that do not match the expected format
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return; // Early exit in case of read error
        }

        if (!tripFound) {
            System.err.println("Trip ID not found: " + tripId);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
