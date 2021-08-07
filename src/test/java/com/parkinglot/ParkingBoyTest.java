package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {

    //Given a parking lot, a car, When the parkingboy park the car, return a parking ticket
    @Test
    void should_return_a_parking_ticket_when_parking_boy_park_car_given_a_parking_lot_and_a_car() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //When
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //Then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parked_car_when_parking_boy_fetch_the_car_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car myCar = new Car();
        ParkingTicket parkingTicket = parkingLot.park(myCar);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Car expectedCar = parkingBoy.fetch(parkingTicket);


        assertEquals(myCar, expectedCar);

//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket parkingTicket = parkingLot.park(car);
//
//        //When
//        Car expectedCar = parkingLot.fetch(parkingTicket);
//
//        //Then
//        assertEquals(car, expectedCar);

    }

    //Given a parking lot with two parked cars, and two parking tickets, When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_with_ticket_when_parking_boy_fetch_car_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car oneCar = new Car();
        Car twoCar = new Car();

        ParkingTicket oneParkingTicket = parkingBoy.park(oneCar);
        ParkingTicket twoParkingTicket = parkingBoy.park(twoCar);

        //When
        Car oneExpectedCar = parkingBoy.fetch(oneParkingTicket);
        Car twoExpectedCar = parkingBoy.fetch(twoParkingTicket);

        //Then
        assertEquals(oneCar, oneExpectedCar);
        assertEquals(twoCar, twoExpectedCar);

    }

    @Test
    void should_return_nothing_with_error_message_when_parking_boy_fetch_car_given_a_parking_lot_and_a_wrong_parking_ticket() {

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket wrongParkingTicket = new ParkingTicket();


        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(wrongParkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    @Test
    void should_return_nothing_when_parking_boy_fetch_the_car_given_a_parking_lot_and_a_used_parking_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car parkedCar = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(parkedCar);


        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());

//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket usedParkingTicket = parkingLot.park(car);
//
//
//        parkingLot.fetch(usedParkingTicket);


    }
}
