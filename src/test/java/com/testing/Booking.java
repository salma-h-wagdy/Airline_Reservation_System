package com.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.travel.clientstrips.Flights;
import com.travel.clientstrips.CalculateFare;

import static org.junit.jupiter.api.Assertions.*;

class BookingTests {

    @TempDir
    File tempDir;

    @Test
    void testFlightSource() throws IOException {

        File file = new File(tempDir, "Flights.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("New York-Los Angeles-2024-08-05T10:00:00-2024-08-05T13:00:00\n");
            writer.write("London-Paris-2024-08-06T09:00:00-2024-08-06T11:00:00\n");
            writer.write("Tokyo-Seoul-2024-08-07T15:00:00-2024-08-07T18:00:00\n");
        }


        Flights flights = new Flights() {
            @Override
            public List<String> Flight_Source() {
                // Override method to use the temp file path
                String filePath = file.getAbsolutePath();
                List<String> sources = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("-");
                        if (parts.length >= 5) {
                            String source = parts[0];
                            sources.add(source);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return sources;
            }
        };


        List<String> sources = flights.Flight_Source();
        assertNotNull(sources);
        assertEquals(3, sources.size());
        assertEquals("New York", sources.get(0));
        assertEquals("London", sources.get(1));
        assertEquals("Tokyo", sources.get(2));
    }


    //fare calculations for Flights
     CalculateFare calculator;

    @BeforeEach
    public void setUp() {
        System.out.println("before test");
        calculator = new CalculateFare();}

    @Test
    public void testCalculateFareEconomy() {

        int fare = calculator.calculateFare(2, "economy");
        assertEquals(1000, fare, "Fare for 2 economy tickets should be 1000");
    }

    @Test
    public void testCalculateFareBusiness() {

        int fare = calculator.calculateFare(3, "business");
        assertEquals(3000, fare, "Fare for 3 business tickets should be 3000");
    }

    @Test
    public void testCalculateFareFirstClass() {

        int fare = calculator.calculateFare(1, "first class");
        assertEquals(2000, fare, "Fare for 1 first class ticket should be 2000");
    }

    @Test
    public void testCalculateFareInvalidType() {

        int fare = calculator.calculateFare(1, "invalid");
        assertEquals(0, fare, "Fare for an invalid flight type should be 0");
    }

    @AfterEach
    public void tearDown() throws IOException {
        calculator = null;
    }

    Flights flight;

        @Test
        public void testCheckAvailability() throws IOException {
            flight= new Flights();


            assertTrue(flight.checkAvailability("001", 5));
            assertFalse(flight.checkAvailability("003", 11));


        }



    @Test
    void testUpdateAvailability() throws IOException {

        flight= new Flights();

        flight.updateAvailability("003", 6);

        assertFalse(flight.checkAvailability("003", 5));
        assertTrue(flight.checkAvailability("003", 4));
    }




}

