package com.parkinglot;

public class NoAvailableParkingSlot extends RuntimeException{
    @Override
    public String getMessage(){
        return "No available position.";
    }
}
