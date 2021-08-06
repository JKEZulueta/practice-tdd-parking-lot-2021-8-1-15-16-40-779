package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();



    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);

        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        ////Given a parking lot with a parked car, and a parking ticket, when fetch the car twice, then return the right car with each ticket
        return parkedPosition.get(parkingTicket);
    }
}
