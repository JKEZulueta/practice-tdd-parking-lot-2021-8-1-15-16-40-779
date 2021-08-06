package com.parkinglot;

public class ParkingLot {
    private Car car;


    public ParkingTicket park(Car car) {
        this.car = car;
        return new ParkingTicket();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        ////Given a parking lot with a parked car, and a parking ticket, when fetch the car twice, then return the right car with each ticket
        return car;
    }
}
