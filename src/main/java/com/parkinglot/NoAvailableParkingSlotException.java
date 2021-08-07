package com.parkinglot;

public class NoAvailableParkingSlotException extends RuntimeException{
    @Override
    public String getMessage(){
        return "No available position.";
    }
}
