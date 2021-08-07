package com.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy{
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    public static final int LOT_CAPACITY = 10;
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;
    public Car car;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {

    }

    public ParkingTicket park(Car car) {

        if(ifFull()){
            throw new NoAvailableParkingSlotException();
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);

        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isUnrecognizedTicket(parkingTicket)){
            throw new UnrecognizedParkingTicketException();
        } else {

            return parkingLot.fetch(parkingTicket);
        }
    }

    public boolean isUnrecognizedTicket(ParkingTicket parkingTicket){
        return !parkedPosition.containsKey(parkingTicket);
    }


    private boolean ifFull() {
        return parkedPosition.size() >= LOT_CAPACITY;
    }


}
