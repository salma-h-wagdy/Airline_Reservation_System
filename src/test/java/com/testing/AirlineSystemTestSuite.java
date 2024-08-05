package com.testing;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BookingTests.class,
        AdminTest.class,
        ClientsTripsTest.class,
        FlightsTest.class
})
public class AirlineSystemTestSuite {
}





