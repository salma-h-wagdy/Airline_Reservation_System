/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travel.clientstrips;
import java.util.Scanner;
/**
 *
 * @author Hp
 */
public class CalculateFare {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for flight types and prices
        final int ECONOMY_PRICE = 500;
        final int BUSINESS_PRICE = 1000;
        final int FIRST_CLASS_PRICE = 2000;

        System.out.print("Enter flight type (economy, business, first class): ");
        String flightType = scanner.nextLine().toLowerCase();

        System.out.print("Enter number of passengers: ");
        int numPassengers = scanner.nextInt();

        int totalFare = 0;

        switch (flightType) {
            case "economy":
                totalFare = ECONOMY_PRICE * numPassengers;
                break;
            case "business":
                totalFare = BUSINESS_PRICE * numPassengers;
                break;
            case "first class":
                totalFare = FIRST_CLASS_PRICE * numPassengers;
                break;
            default:
                System.out.println("Invalid flight type.");
                return;
        }

        System.out.println("Total fare: $" + totalFare);
    }
    
    
}
