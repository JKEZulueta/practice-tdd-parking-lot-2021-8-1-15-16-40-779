package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    public static final int LOT_CAPACITY = 10;

    private final int capacity;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity){
        this.capacity = capacity;
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
        if(isUnrecognizedTicket(parkingTicket)){
            throw new UnrecognizedParkingTicketException();
        }

        final Car car = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket);
        return car;
    }

    public boolean isUnrecognizedTicket(ParkingTicket parkingTicket){
        return !parkedPosition.containsKey(parkingTicket);
    }

    public boolean isFullParkingLot(ParkingTicket parkingTicket) {
        return !parkedPosition.containsKey(parkingTicket);
    }

    private boolean ifFull() {
        return parkedPosition.size() >= LOT_CAPACITY;
    }

    public boolean isParkingFull(){
        return parkedPosition.size() >= LOT_CAPACITY;
    }

    public Map<ParkingTicket, Car> getCars(){
        return parkedPosition;
    }


}
