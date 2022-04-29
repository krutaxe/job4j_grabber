package ru.job4j.ood.lsp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParkTest {

    @Test
    public void whenParkCarTrue() {
        Parking parking = new Park(0, 2, new ArrayList<>());
        Transport carPass1 = new CarPass();
        Transport carPass = new CarPass();
        parking.park(carPass1);
        assertTrue(parking.park(carPass));
    }

    @Test
    public void whenParkTruckTrue() {
        Parking parking = new Park(1, 3, new ArrayList<>());
        Transport truck1 = new Truck(5);
        Transport truck2 = new Truck(3);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Test
    public void whenParkCarFalse() {
        Parking parking = new Park(2, 1, new ArrayList<>());
        Transport carPass1 = new CarPass();
        Transport carPass2 = new CarPass();
        parking.park(carPass1);
        assertFalse(parking.park(carPass2));
    }

    @Test
    public void whenParkTruckFalse() {
        Parking parking = new Park(0, 3, new ArrayList<>());
        Transport truck = new Truck(5);
        assertFalse(parking.park(truck));
    }
}