package ru.job4j.ood.lsp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkTest {

    @Test @Ignore
    public void whenParkCarTrue() {
        Parking parking = new Park(1, 2);
        Transport carPass = new CarPass();
        assertTrue(parking.park(carPass));
    }

    @Test @Ignore
    public void whenParkTruckTrue() {
        Parking parking = new Park(1, 3);
        Transport truck1 = new Truck(5);
        Transport truck2 = new Truck(3);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }

    @Test @Ignore
    public void whenParkCarFalse() {
        Parking parking = new Park(2, 1);
        Transport carPass1 = new CarPass();
        Transport carPass2 = new CarPass();
        parking.park(carPass1);
        assertFalse(parking.park(carPass2));
    }

    @Test @Ignore
    public void whenParkTruckFalse() {
        Parking parking = new Park(0, 3);
        Transport truck = new Truck(5);
        assertFalse(parking.park(truck));
    }
}