package com.parkinglot;

import java.sql.Array;
import java.util.*;

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
        ParkingLot parkingLot = parkingLots
                .stream()
                .reduce(null, (parkingLot1, parkingLot2) ->
                        parkingLot2.getCars().containsKey(parkingTicket) ? parkingLot2 : parkingLot1);
//        return parkingLot.fetch(parkingTicket);
        if(!Objects.isNull(parkingLot)) {
            return parkingLot.fetch(parkingTicket);
        }
        throw new UnrecognizedParkingTicketException();
    }

    public List<ParkingLot> getParkingLots(){
        return parkingLots;
    }

}
