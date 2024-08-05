package com.testing;

import com.travel.clientstrips.CalculateFare;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;



public class CalculateFareTests {

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
    public void tearDown() {
        calculator = null;
    }

}
