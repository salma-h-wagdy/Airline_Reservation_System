/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travel.clientstrips;
import javax.swing.*;
import java.util.Scanner;
/**
 *
 * @author Hp
 */
public class CalculateFare  {
    final int ECONOMY_PRICE = 500;
    final int BUSINESS_PRICE = 1000;
    final int FIRST_CLASS_PRICE = 2000;

    public CalculateFare() {}

    public int calculateFare(int numPassengers, String flightType) {

        int pricePerTicket = 0;

        switch (flightType.toLowerCase()) {
            case "economy":
                pricePerTicket = ECONOMY_PRICE;
                break;
            case "business":
                pricePerTicket = BUSINESS_PRICE;
                break;
            case "first class":
                pricePerTicket = FIRST_CLASS_PRICE;
                break;
            default:
               // JOptionPane.showMessageDialog(this, "Invalid flight type");
                return 0;
        }

        return pricePerTicket * numPassengers;
    }




//    private JTextField flightTypeField, numPassengersField, totalFareField;
//
//    public CalculateFare() {
//        setTitle("Fare Calculator");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(300, 200);
//        setLayout(new GridLayout(4, 2));
//
//        JLabel flightTypeLabel = new JLabel("Flight Type:");
//        flightTypeField = new JTextField();
//        JLabel numPassengersLabel = new JLabel("Number of Passengers:");
//        numPassengersField = new JTextField();
//        JLabel totalFareLabel = new JLabel("Total Fare:");
//        totalFareField = new JTextField();
//        totalFareField.setEditable(false); // Make it non-editable
//
//        JButton calculateButton = new JButton("Calculate");
//        calculateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent  
// e) {
//                calculateFare();  
//
//            }
//        });
//
//        add(flightTypeLabel);
//        add(flightTypeField);
//        add(numPassengersLabel);
//        add(numPassengersField);
//        add(totalFareLabel);
//        add(totalFareField);
//        add(new JLabel()); // Empty label for spacing
//        add(calculateButton);
//
//        setVisible(true);
//    }
//
//    private void calculateFare() {
//        final int ECONOMY_PRICE = 500;
//        final int BUSINESS_PRICE = 1000;
//        final int FIRST_CLASS_PRICE = 2000;
//
//        String flightType = flightTypeField.getText().toLowerCase();
//        int numPassengers;
//
//        try {
//            numPassengers = Integer.parseInt(numPassengersField.getText());
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Invalid number of passengers");
//            return;
//        }
//
//        int totalFare = 0;
//
//        switch (flightType) {
//            case "economy":
//                totalFare = ECONOMY_PRICE * numPassengers;
//                break;
//            case "business":
//                totalFare = BUSINESS_PRICE * numPassengers;
//                break;
//            case "first class":
//                totalFare = FIRST_CLASS_PRICE * numPassengers;
//                break;
//            default:
//                JOptionPane.showMessageDialog(this, "Invalid flight type");
//                return;
//        }
//
//        totalFareField.setText("$" + totalFare);
//    }
//
//    public static void main(String[] args) {
//        new CalculateFare();
//    }
}
