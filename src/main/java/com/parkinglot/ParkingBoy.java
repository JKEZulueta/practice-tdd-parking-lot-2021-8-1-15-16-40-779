package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    public static final int LOT_CAPACITY = 10;
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }


    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }

}
