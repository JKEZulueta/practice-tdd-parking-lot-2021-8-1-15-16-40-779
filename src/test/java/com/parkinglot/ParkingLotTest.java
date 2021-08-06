package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //When
        ParkingTicket parkingTicket = parkingLot.park(car);

        //Then
        assertNotNull(parkingTicket);
    }

    ////Given a parking lot with a parked car, and a parking ticket, when fetch the car twice, then return the right car with each ticket
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_parked_car_and_a_parking_ticket() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //When
        Car expectedCar = parkingLot.fetch(parkingTicket);

        //Then
        assertEquals(car, expectedCar);
    }
}
