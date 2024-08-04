package com.testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.travel.UserTrips.UserTrips;
import org.junit.Before;
import org.junit.After;

public class UserTripsTest {

    private UserTrips UserTrips;

    @Before
    public void setUp() {
        System.out.println("Test setup");
        UserTrips = new UserTrips(123, "Farah Hany", "T123", "Leisure", "2024-08-01", 1000, "7 days", 200, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(123, UserTrips.getId());
        assertEquals("Farah Hany", UserTrips.getUsername());
        assertEquals("T123", UserTrips.getTripid());
        assertEquals("Leisure", UserTrips.getTriptype());
        assertEquals("2024-08-01", UserTrips.getTripdate());
        assertEquals("7 days", UserTrips.getDuration());
        assertEquals(200, UserTrips.getPrice());
        assertEquals(1000, UserTrips.getProfit());
        assertEquals(5, UserTrips.getNo_pass());
    }

    @Test
    public void testSettersAndGetters() {

        UserTrips.setId(456);
        UserTrips.setClientname("Rawan Mohamed");
        UserTrips.setTripid("T456");
        UserTrips.setTriptype("Business");
        UserTrips.setTripdate("2024-08-02");
        UserTrips.setDuration("3 days");
        UserTrips.setPrice(300);
        UserTrips.setProfit(900);
        UserTrips.setNo_pass(3);

        assertEquals(456, UserTrips.getId());
        assertEquals("Rawan Mohamed", UserTrips.getClientname());
        assertEquals("T456", UserTrips.getTripid());
        assertEquals("Business", UserTrips.getTriptype());
        assertEquals("2024-08-02", UserTrips.getTripdate());
        assertEquals("3 days", UserTrips.getDuration());
        assertEquals(300, UserTrips.getPrice());
        assertEquals(900, UserTrips.getProfit());
        assertEquals(3, UserTrips.getNo_pass());
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

        assertEquals(expected, UserTrips.toString());
    }
    @After
    public void tearDown () {
        UserTrips = null;
    }
}
