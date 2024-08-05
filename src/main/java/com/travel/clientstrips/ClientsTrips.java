package com.travel.clientstrips;

import java.util.Objects;

public class ClientsTrips {
    private int pass;
    private String clientname;
    //private String age;
    private String tripid;
    private String triptype;
    private String tripdate;
    private String duration;
    private int priceperticket;
    private int totalcost;
    private int No_pass;
    //private String details;

    public ClientsTrips() {
    }
    public ClientsTrips(String clientname,String tripid,String triptype,String tripdate,String duration,int priceperticket,int No_pass){
        this.clientname=clientname;
        this.tripid=tripid;
        this.triptype=triptype;
        this.tripdate=tripdate;
        this.duration=duration;
        this.priceperticket = priceperticket;
        this.tripid = tripid;
        this.No_pass = No_pass;
    }

    public ClientsTrips(User user, String tripid, String triptype, String tripdate, int totalcost, String duration, int price, int No_pass) {
        this.pass = user.getId();
        this.clientname = user.getName();
        this.triptype = triptype;
        this.tripdate = tripdate;
        this.duration = duration;
        this.priceperticket = price;
        this.totalcost = totalcost;
        this.tripid = tripid;
        this.No_pass = No_pass;
    }

    public int getNo_pass() {
        return No_pass;
    }

    public void setNo_pass(int No_pass) {
        this.No_pass = No_pass;
    }

    public int getId() {
        return pass;
    }

    public String getClientname() {
        return clientname;
    }

    //    public String getAge() {
    //        return age;
    //    }

    public String getTripid() {
        return tripid;
    }

    public String getTriptype() {
        return triptype;
    }

    public String getTripdate() {
        return tripdate;
    }

    public String getDuration() {
        return duration;
    }

    public int getPrice() {
        return priceperticket;
    }

    public int getProfit() {
        return totalcost;
    }

    //    public String getDetails() {
    //        return details;
    //    }

    public void setId(int pass) {
        this.pass = pass;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    //    public void setAge(String age) {
    //        this.age = age;
    //    }

    public void setTripid(String tripid) {
        this.tripid = tripid;
    }

    public void setTriptype(String triptype) {
        this.triptype = triptype;
    }

    public void setTripdate(String tripdate) {
        this.tripdate = tripdate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPrice(int price) {
        this.priceperticket = price;
    }

    public void setProfit(int profit) {
        this.totalcost = profit;
    }

    //    public void setDetails(String details) {
    //        this.details = details;
    //    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsTrips trip = (ClientsTrips) o;
        return Objects.equals(pass, trip.pass) && Objects.equals(clientname, trip.clientname) && Objects.equals(triptype, trip.triptype) && Objects.equals(tripdate, trip.tripdate) && Objects.equals(duration, trip.duration) && Objects.equals(priceperticket, trip.priceperticket) && Objects.equals(totalcost, trip.totalcost) && Objects.equals(No_pass, trip.No_pass);
        //&& Objects.equals(details, trip.details)
    }
    //&& Objects.equals(age, trip.age)

    @Override
    public int hashCode() {
        return Objects.hash(pass, clientname, triptype, tripdate, duration, priceperticket, totalcost, tripid, No_pass);
    }
    //,clientname , age , profit, details

    @Override
    public String toString() {
        return "Trip{" +
                "id='" + pass + '\'' +
                ", Category='" + clientname + '\'' +
                ", Category='" + triptype + '\'' +
                ", Trip Date='" + tripdate + '\'' +
                ", Duration='" + duration + '\'' +
                ", Price='" + priceperticket + '\'' +
                ", profit='" + totalcost + '\'' +
                ", Category='" + tripid + '\'' +
                ", Category='" + No_pass + '\'' +

                // ", details='" + details + '\'' +

                '}';
    }
}
