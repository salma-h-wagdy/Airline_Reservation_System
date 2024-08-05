package com.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.util.List;
import com.travel.clientstrips.Flights;

import static org.junit.jupiter.api.Assertions.*;

class BookingTests {

    @TempDir
    File tempDir;
    private Flights flights;
    private File file;

    @BeforeEach
    void setUp() throws IOException {
        file = new File(tempDir, "Flightstemp.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Berlin-Tokyo-11:00-20:00-001-120\n");
            writer.write("New York-London-16:00-04:00-002-90\n");
            writer.write("Cape Town-Paris-21:00-05:00-003-150\n");
            writer.write("Sydney-Dubai-23:30-05:00-004-180\n");
            writer.write("Nairobi-Barcelona-08:15-14:00-005-110\n");
        }

        flights = new Flights();
    }


    @Test
    void testFlightSource() {
        List<String> sources = flights.Flight_Source(file.getAbsolutePath());
        assertNotNull(sources);
        assertEquals(5, sources.size());
        assertEquals("Berlin", sources.get(0));
        assertEquals("New York", sources.get(1));
        assertEquals("Cape Town", sources.get(2));
        assertEquals("Sydney", sources.get(3));
        assertEquals("Nairobi", sources.get(4));
    }

    @Test
    void testCheckAvailability() {
        assertTrue(flights.checkAvailability("003", 10, file.getAbsolutePath()));
        assertFalse(flights.checkAvailability("003", 160, file.getAbsolutePath()));
    }

    @Test
    void testUpdateAvailability() {
        flights.updateAvailability("003", 20, file.getAbsolutePath());
        assertFalse(flights.checkAvailability("003", 131, file.getAbsolutePath()));
        assertTrue(flights.checkAvailability("003", 119, file.getAbsolutePath()));
    }

    @AfterEach
    void tearDown() {
        flights = null;
    }
}
