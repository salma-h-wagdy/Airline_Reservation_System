package com.travel.clientstrips;

import java.util.Objects;

public class Trip {
    private int id;
    private String clientname;
    //private String age;
    private String tripid;
    private String triptype;
    private String tripdate;
    private String duration;
    //private int priceperticket;
    private int totalcost;
    private int No_pass;
    //private String details;

    public Trip() {
    }

    public Trip(int id, String clientname  ,String tripid, String triptype, String tripdate,String duration ,int profit, int No_pass) { //, String age, String details
        this.id = id;
        this.clientname = clientname;
        //this.age = age;
        this.triptype = triptype;
        this.tripdate = tripdate;
        this.duration = duration;
        //this.priceperticket = price;
        this.totalcost = profit;
        this.tripid = tripid;
        this.No_pass = No_pass;
        //this.details = details;
    }

    public int getNo_pass() {
        return No_pass;
    }

    public void setNo_pass(int No_pass) {
        this.No_pass = No_pass;
    }

    public String getTripid() {
        return tripid;
    }

    public void setTripid(String tripid) {
        this.tripid = tripid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientname;
    }

    public void setClientName(String clientname) {
        this.clientname = clientname;
    }

    public String getTripType() {
        return triptype;
    }

//    public String getAge() {
//        return age;
//    }
//
//    public void seAge(String age) {
//        this.age = age;
//    }
//

    public void setTripType(String triptype) {
        this.triptype = triptype;
    }

    public String getTripDate() {
        return tripdate;
    }

    public void setTripDate(String tripdate) {
        this.tripdate = tripdate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

//    public int getPrice() {
//        return priceperticket;
//    }
//
//    public void setPrice(int price) {
//        this.priceperticket = price;
//    }


    public int getProfit() {
        return totalcost;
    }

    public void setProfit(int profit) {
        this.totalcost = profit;
    }


//       public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(clientname, trip.clientname)&& Objects.equals(triptype, trip.triptype) && Objects.equals(tripdate, trip.tripdate) && Objects.equals(duration, trip.duration) && Objects.equals(totalcost, trip.totalcost)&& Objects.equals(No_pass, trip.No_pass);//&& Objects.equals(priceperticket, trip.priceperticket)
    }//&& Objects.equals(age, trip.age)&& Objects.equals(details, trip.details)

    @Override
    public int hashCode() {
        return Objects.hash(id,clientname , triptype, tripdate, duration, totalcost,No_pass);//priceperticket
    }//, age , details

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + id + '\'' +
                ", Category='" + triptype + '\'' +
                ", Trip Date='" + tripdate + '\'' +
                ", Duration='" + duration + '\'' +
                // ", Price='" + priceperticket + '\'' +
                ", profit='" + totalcost + '\'' +
                ", passengers='" + No_pass + '\'' +
                // ", details='" + details + '\'' +

                '}';
    }
}
