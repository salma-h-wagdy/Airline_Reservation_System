package com.testing;

//package tests;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import com.travel.clientstrips.ClientsTrips;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

public class ClientsTripsTest {

    private ClientsTrips clientsTrips;

    @Before
    public void setUp() {
        System.out.println("Test setup");
        clientsTrips = new ClientsTrips(123, "Farah Hany", "T123", "Leisure", "2024-08-01", 1000, "7 days", 200, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(123, clientsTrips.getId());
        assertEquals("Farah Hany", clientsTrips.getClientname());
        assertEquals("T123", clientsTrips.getTripid());
        assertEquals("Leisure", clientsTrips.getTriptype());
        assertEquals("2024-08-01", clientsTrips.getTripdate());
        assertEquals("7 days", clientsTrips.getDuration());
        assertEquals(200, clientsTrips.getPrice());
        assertEquals(1000, clientsTrips.getProfit());
        assertEquals(5, clientsTrips.getNo_pass());
    }

    @Test
    public void testSettersAndGetters() {

        clientsTrips.setId(456);
        clientsTrips.setClientname("Rawan Mohamed");
        clientsTrips.setTripid("T456");
        clientsTrips.setTriptype("Business");
        clientsTrips.setTripdate("2024-08-02");
        clientsTrips.setDuration("3 days");
        clientsTrips.setPrice(300);
        clientsTrips.setProfit(900);
        clientsTrips.setNo_pass(3);

        assertEquals(456, clientsTrips.getId());
        assertEquals("Rawan Mohamed", clientsTrips.getClientname());
        assertEquals("T456", clientsTrips.getTripid());
        assertEquals("Business", clientsTrips.getTriptype());
        assertEquals("2024-08-02", clientsTrips.getTripdate());
        assertEquals("3 days", clientsTrips.getDuration());
        assertEquals(300, clientsTrips.getPrice());
        assertEquals(900, clientsTrips.getProfit());
        assertEquals(3, clientsTrips.getNo_pass());
    }


    @Test
    public void testToString() {
        String expected = "Trip{" +
                "id='123', " +
                "Category='Farah Hany', " +
                "Category='Leisure', " +
                "Trip Date='2024-08-01', " +
                "Duration='7 days', " +
                "Price='200', " +
                "profit='1000', " +
                "Category='T123', " +
                "Category='5'}";

        assertEquals(expected, clientsTrips.toString());
    }
}
