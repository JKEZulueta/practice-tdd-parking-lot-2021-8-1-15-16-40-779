package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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


        Car expectedCar = parkingBoy.fetch(parkingTicket);

        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());

//        ParkingLot parkingLot = new ParkingLot();
//        Car car = new Car();
//        ParkingTicket usedParkingTicket = parkingLot.park(car);
//
//
//        parkingLot.fetch(usedParkingTicket);


    }

    @Test
    void should_return_exception_no_available_position_when_parking_boy_park_the_car_given_a_parking_lot_without_any_position_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        int capacity = 10;

        for(int i = 0; i < capacity; i++){
            ParkingTicket parkingTicket = parkingBoy.park(car);
        }

        Exception exception = assertThrows(NoAvailableParkingSlotException.class, () -> parkingBoy.park(car));


        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    void should_return_parking_lot_one_when_parking_lot_two_given_two_parking_lot_and_parking_boy_and_a_car() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.park(car);

        assertNotNull(parkingBoy.getParkingLots().get(0));
    }
    
    //void should_return_parking_ticket_when_park_given_two_parking_lots_and_a_car


    @Test
    void should_return_parking_ticket_when_park_car_given_two_parking_lots_and_a_car() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.park(car);

        assertNotNull(parkingBoy.getParkingLots().get(1));

    }

    @Test
    void should_return_the_right_car_when_parking_boy_fetch_the_car_twice_given_two_parking_lot_with_two_parked_cars_and_two_parking_tickets() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car carOne = new Car();
        Car carTwo = new Car();

        ParkingTicket parkingTicketOne = parkingLots.get(1).park(carOne);
        ParkingTicket parkingTicketTwo = parkingLots.get(1).park(carTwo);

        Car carExpectedOne = parkingBoy.fetch(parkingTicketOne);
        Car carExpectedTwo = parkingBoy.fetch(parkingTicketTwo);


        assertEquals(carOne, carExpectedOne);
        assertEquals(carTwo, carExpectedTwo);

    }

    @Test
    void should_return_exception_when_parking_boy_fetch_the_car_given_two_parking_lots_and_a_wrong_parking_ticket() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        ParkingTicket wrongParkingTicket = new ParkingTicket();


        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(wrongParkingTicket));


        assertEquals("Unrecognized parking ticket.", exception.getMessage());


    }

}
