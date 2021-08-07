package com.parkinglot;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    public static final int LOT_CAPACITY = 10;
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }


    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots
                .stream()
                .reduce((parkingLot1, parkingLot2) -> parkingLot1.isParkingFull() ? parkingLot1 : parkingLot2)
                .get();
//        return parkingLot.park(car);

        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }

    public List<ParkingLot> getParkingLots(){
        return parkingLots;
    }

}
