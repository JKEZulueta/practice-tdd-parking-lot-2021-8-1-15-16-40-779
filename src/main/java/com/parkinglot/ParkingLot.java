package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    public static final int LOT_CAPACITY = 10;



    public ParkingTicket park(Car car) {

        if(LOT_CAPACITY == parkedPosition.size()){
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);

        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if(!parkingTicket.isUsed()){
            parkingTicket.setUsed();
            return parkedPosition.get(parkingTicket);
        }
        return null;
    }


}
