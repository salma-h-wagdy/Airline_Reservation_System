/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travel.clientstrips;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author 62040
 */
//, int tripprice

public class TripService {
    //  private final SupplierConnection supplierConnection = SupplierConnection.getInstance();

    public void addNewTrip(String id_str, String name,String tripid, String triptype, String tripdate,String tripduration ,int profit,int No_pass) {
        Pattern email_pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher email_matcher = email_pattern.matcher(tripdate);
        boolean matchFound = email_matcher.matches();

        if (id_str.isBlank() || tripid.isBlank()  || triptype.isBlank() || tripdate.isBlank()) {
            showMessage("Please fill out all fields!", "WARNING");
        } else if(!matchFound) {
            showMessage("Invalid email", "ERROR");
        } else {

            Trip trip = new Trip(Integer.parseInt(id_str),name,tripid ,triptype, tripdate,tripduration,profit,No_pass);//,tripprice
            ///         tripConnection.addNewSupplier(trip);
            showMessage("Trip Added successfully!", "INFORMATION");
        }
    }


    public void updateTrip(String id, String name, String address, String phone, String email) {
        Pattern email_pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher email_matcher = email_pattern.matcher(email);
        boolean matchFound = email_matcher.matches();

        if (!matchFound) {
            throw new RuntimeException("Invalid email");
        } else {
            //         supplierConnection.updateSupplier(id, name, address, phone, email);
        }
    }

    public void deleteSupplier(String id) {
        if(id.isBlank()) {
            showMessage("Please enter supplier id!", "WARNING");
        } else {
            //         supplierConnection.deleteSupplier(Integer.parseInt(id));
            showMessage("Trip Deleted Successfully!", "INFORMATION");
        }
    }

    public List<ClientsTrips> getTrips(int id) {
        List<ClientsTrips> TripsList = new ArrayList<>();
        TripsList.clear();
//        if (id == 1234){
//            TripsList.add(new ClientsTrips (1234,"Nancy","F3245","Economy","2023-08-6",500,"25" ,1500,3));
//            TripsList.add(new ClientsTrips (1234,"Nancy","F5346","Business","2023-07-24",1000,"50",2000,2));
//            TripsList.add(new ClientsTrips (1234,"Nancy","F7645","First class","2023-08-9",2000,"30" ,2000,1)) ;
//        }
//        if (id == 5462){
//            TripsList.add(new ClientsTrips (5462,"Salma","F5342","Economy","2023-07-20",500,"12" ,2500,5)) ;
//            TripsList.add(new ClientsTrips (5462,"Salma","F9876","Business","2023-08-9",1000,"60" ,2000,2)) ;
//        }
//
//        if (id == 3095){
//            TripsList.add(new ClientsTrips (3095,"Alaa","F5637","Economy","2023-08-9",500,"30",3000,6)) ;
//            TripsList.add(new ClientsTrips (3095,"Alaa","F8712","First class","2023-08-30",2000,"83" ,2000,3)) ;
//
//        }
        return TripsList;

    }


    public List<Trip> getTrips() {
        List<Trip> TripsList = new ArrayList<>();


//        TripsList.add(new Trip (1234,"Nancy","F3245","Economy","2023-08-6","25" ,1500,3)) ;
//        TripsList.add(new Trip (1234,"Nancy","F5346","Business","2023-07-24","50",2000,2));
//        TripsList.add(new Trip (1234,"Nancy","F7645","First class","2023-08-9","30" ,2000,1)) ;
//
//
//        TripsList.add(new Trip (5462,"Salma","F5342","Economy","2023-07-20","12" ,2500,5)) ;
//        TripsList.add(new Trip (5462,"Salma","F9876","Business","2023-08-9","60" ,2000,2)) ;
//
//
//
//        TripsList.add(new Trip (3095,"Alaa","F5637","Economy","2023-08-9","30",3000,6)) ;
//        TripsList.add(new Trip (3095,"Alaa","F8712","First class","2023-08-30","83" ,6000,3)) ;


        return TripsList;

    }

    public List<Trip> getTripsClient(String username) {
        List<Trip> TripsList = new ArrayList<>();

        TripsList.clear();
        if (username == "nancy"){
            TripsList.add(new Trip (1234,"Nancy","F3245","Economy","2023-08-6","25" ,1500,3)) ;
            TripsList.add(new Trip (1234,"Nancy","F5346","Business","2023-07-24","50",2000,2));
            TripsList.add(new Trip (1234,"Nancy","F7645","First class","2023-08-9","30" ,2000,1)) ;
        }
        if (username == "salma"){

            TripsList.add(new Trip (5462,"Salma","F5342","Economy","2023-07-20","12" ,2500,5)) ;
            TripsList.add(new Trip (5462,"Salma","F9876","Business","2023-08-9","60" ,2000,2)) ;

        }
        if(username == "alaa"){

            TripsList.add(new Trip (3095,"Alaa","F5637","Economy","2023-08-9","30",3000,6)) ;
            TripsList.add(new Trip (3095,"Alaa","F8712","First class","2023-08-30","83" ,6000,3)) ;
        }

        return TripsList;

    }

    public Trip getTrip(int id) {
        //return supplierConnection.getTrip(id);
        return new Trip (1234,"Nancy","F3245","Economy","2023-08-6","25" ,500,3) ;
    }

    public List<ClientsTrips> getClientTrip() {
        //return supplierConnection.getTrip(id);

        List<ClientsTrips> TripsList = new ArrayList<>();

//
//        TripsList.add(new ClientsTrips (1234,"Nancy","F3245","Economy","2023-08-6",500,"25" ,500,3)) ;
//        TripsList.add(new ClientsTrips (1234,"Nancy","F5346","Business","2023-07-24",1000,"50",1000,2)) ;
//        TripsList.add(new ClientsTrips (1234,"Nancy","F7645","First class","2023-08-9",2000,"30" ,2000,1)) ;
//        TripsList.add(new ClientsTrips (5462,"Salma","F5342","Economy","2023-07-20",500,"12" ,500,5)) ;
//        TripsList.add(new ClientsTrips (5462,"Salma","F9876","Business","2023-08-9",1000,"60" ,1000,2)) ;
//        TripsList.add(new ClientsTrips (3095,"Alaa","F5637","Economy","2023-08-9",500,"30",500,6)) ;
//        TripsList.add(new ClientsTrips (3095,"Alaa","F8712","First class","2023-08-30",2000,"83" ,2000,3)) ;
//



        return TripsList;


        //return  TripsList ;
    }



    private List<ClientsTrips> getAllTrips() {
        // Replace with actual data retrieval logic
        List<ClientsTrips> allTrips = new ArrayList<>();
        // ... populate allTrips with data ...
        return allTrips;
    }


    public void showMessage(String message, String type) {
        switch (type) {
            //   case "ERROR" -> JOptionPane.showMessageDialog(null, message, null, JOptionPane.ERROR_MESSAGE);
            //   case "WARNING" -> JOptionPane.showMessageDialog(null, message, null, JOptionPane.WARNING_MESSAGE);
            //   case "INFORMATION" -> JOptionPane.showMessageDialog(null, message, null, JOptionPane.INFORMATION_MESSAGE);
            //   default -> JOptionPane.showMessageDialog(null, message);
        }
    }

}