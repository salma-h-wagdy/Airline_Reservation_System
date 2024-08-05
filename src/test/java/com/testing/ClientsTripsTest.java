package com.testing;

import com.travel.clientstrips.ClientsTrips;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientsTripsTest {

    private ClientsTrips trip;

    @BeforeEach
    public void setUp() {
        System.out.println("Test setup");
         trip = new ClientsTrips("Alia", "T123", "Business", "2024-12-25", "7 days", 500, 2);
    }

    @Test
    public void testConstructor() {
        assertEquals("Alia", trip.getClientname());
        assertEquals("T123", trip.getTripid());
        assertEquals("Business", trip.getTriptype());
        assertEquals("2024-12-25", trip.getTripdate());
        assertEquals("7 days", trip.getDuration());
        assertEquals(500, trip.getPrice());
        assertEquals(2, trip.getNo_pass());
    }

    @Test
    public void testSettersAndGetters() {

        trip.setId(1);
        trip.setClientname("Alia");
        trip.setTripid("T456");
        trip.setTriptype("Business");
        trip.setTripdate("2024-11-01");
        trip.setDuration("5 days");
        trip.setPrice(600);
        trip.setProfit(3000);
        trip.setNo_pass(3);

        assertEquals(1, trip.getId());
        assertEquals("Alia", trip.getClientname());
        assertEquals("T456", trip.getTripid());
        assertEquals("Business", trip.getTriptype());
        assertEquals("2024-11-01", trip.getTripdate());
        assertEquals("5 days", trip.getDuration());
        assertEquals(600, trip.getPrice());
        assertEquals(3000, trip.getProfit());
        assertEquals(3, trip.getNo_pass());
    }


    @Test
    public void testToString() {
        ClientsTrips trip = new ClientsTrips("Alia", "T123", "Business", "2024-12-25", "7 days", 500, 2);
        String expected = "Trip{" +
                "id='0'," +
                " Category='Alia'," +
                " Category='Business'," +
                " Trip Date='2024-12-25'," +
                " Duration='7 days'," +
                " Price='500'," +
                " profit='0'," +
                " Category='T123'," +
                " Category='2'" +
                '}';
        assertEquals(expected, trip.toString());
    }
    @AfterEach
    public void tearDown () {
        trip = null;
    }
}
