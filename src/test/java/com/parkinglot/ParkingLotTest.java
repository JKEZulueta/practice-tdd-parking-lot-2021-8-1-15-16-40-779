package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    //Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_with_ticket_when_fetch_car_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        Car oneCar = new Car();
        Car twoCar = new Car();
        ParkingTicket oneParkingTicket = parkingLot.park(oneCar);
        ParkingTicket twoParkingTicket = parkingLot.park(twoCar);

        //When
        Car oneExpectedCar = parkingLot.fetch(oneParkingTicket);
        Car twoExpectedCar = parkingLot.fetch(twoParkingTicket);

        //Then
        assertEquals(oneCar, oneExpectedCar);
        assertEquals(twoCar, twoExpectedCar);

    }

    //Given a parking lot, and a wrong parking ticket, When fetch the car, then return nothing.
    @Test
    void should_return_nothing_when_fetch_the_car_given_a_parking_lot_and_a_wrong_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket wrongParkingTicket = new ParkingTicket();

        Car wrongTicketCar = parkingLot.fetch(wrongParkingTicket);

        assertNull(wrongTicketCar);
    }


    //Given a parking lot, and a used parking ticket, When fetch the car, Then return nothing
    @Test
    void should_return_null_when_fetch_a_car_given_a_parking_lot_and_used_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket usedParkingTicket = parkingLot.park(car);


        parkingLot.fetch(usedParkingTicket);
//        Car firstCar = parkingLot.fetch(usedParkingTicket);
//        Car secondCar = parkingLot.fetch(usedParkingTicket);

        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(usedParkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    //Given a parking lot without any position, and a car, when park the car, then return nothing
    @Test
    void should_return_nothing_when_park_the_car_given_a_parking_lot_without_position_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        int capacity = 10;

        for(int i = 0; i < capacity; i++) {
            ParkingTicket carParkingTicket = parkingLot.park(car);
        }

        Car carWithoutPosition = new Car();

        ParkingTicket carWithoutPositionTicket = parkingLot.park(carWithoutPosition);
        
        assertNull(carWithoutPositionTicket);
    }

    //
    @Test
    void should_throw_exception_with_error_message_when_fetch_car_given_a_parking_lot_a_unrecognized_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }
}
