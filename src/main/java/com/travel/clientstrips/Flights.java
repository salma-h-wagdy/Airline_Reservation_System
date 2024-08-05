package com.travel.clientstrips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Flights {
    private int id;
    private String Source;
    private String Destinantion;
    private String departureTime;
    private String arrivalTime;

    public Flights() {}

    public List<String> Flight_Source() {
        String filePath = "src/main/java/com/travel/clientstrips/Flights.txt";
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
}
