package com.testing;

import com.travel.clientstrips.Flights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightsTest {

    @Test
    public void testSetAndGetId() {
        Flights flight = new Flights();
        flight.setId(123);
        assertEquals(123, flight.getId(), "The ID should be 123");
    }

    @Test
    public void testSetAndGetSource() {
        Flights flight = new Flights();
        flight.setSource("Cairo");
        assertEquals("Cairo", flight.getSource(), "The source should be 'Cairo'");
    }

    @Test
    public void testSetAndGetDestinantion() {
        Flights flight = new Flights();
        flight.setDestinantion("Los Angeles");
        assertEquals("Los Angeles", flight.getDestinantion(), "The destination should be 'Los Angeles'");
    }

    @Test
    public void testSetAndGetDepartureTime() {
        Flights flight = new Flights();
        flight.setDepartureTime("2024-08-01T10:00:00");
        assertEquals("2024-08-01T10:00:00", flight.getDepartureTime(), "The departure time should be '2024-08-01T10:00:00'");
    }

    @Test
    public void testSetAndGetArrivalTime() {
        Flights flight = new Flights();
        flight.setArrivalTime("2024-08-01T13:00:00");
        assertEquals("2024-08-01T13:00:00", flight.getArrivalTime(), "The arrival time should be '2024-08-01T13:00:00'");
    }

    @Test
    public void testToString() {
        Flights flight = new Flights(123,"Cairo","Los Angeles","2024-08-01T10:00:00","2024-08-01T13:00:00");

        String expectedString = "Flights{id=123, Source='Cairo', Destination='Los Angeles', departureTime='2024-08-01T10:00:00', arrivalTime='2024-08-01T13:00:00'}";

        assertEquals(expectedString, flight.toString());
    }
}
