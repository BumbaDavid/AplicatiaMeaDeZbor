package org.loose.fis.sre.model;

public class Flight {
    public int id;
    public String airline;
    public String departure_country;
    public String departure_city;
    public String departure_airport;
    public String destination_country;
    public String destination_city;
    public String destination_airport;
    public int number_seats;
    public int one_way;
    public String departure_date;
    public String depature_time;
    public String arriver_date;
    public String arriver_time;
    public String time;
    public double price;
    public String flight_status;

    public Flight() {
    }

    public Flight(int id, String airline, String departure_country, String departure_city, String departure_airport, String destination_country, String city, String destination_airport, int number_seats, int one_way, String departure_date, String depature_time, String arriver_date, String arriver_time, String time, double price, String flight_status) {
        this.id = id;
        this.airline = airline;
        this.departure_country = departure_country;
        this.departure_city = departure_city;
        this.departure_airport = departure_airport;
        this.destination_country = destination_country;
        this.destination_city = this.destination_city;
        this.destination_airport = destination_airport;
        this.number_seats = number_seats;
        this.one_way = one_way;
        this.departure_date = departure_date;
        this.depature_time = depature_time;
        this.arriver_date = arriver_date;
        this.arriver_time = arriver_time;
        this.time = time;
        this.price = price;
        this.flight_status = flight_status;
    }
}
