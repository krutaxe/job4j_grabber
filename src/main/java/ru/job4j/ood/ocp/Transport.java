package ru.job4j.ood.ocp;

/**
 *  Пример нарушения принципа OCP.
 *  Не всему траспорту оптимально подходит конструктор.
 */

public class Transport {
    private int wheels;
    private String fuel;
    private String typeEngine;

    public Transport(int wheels, String fuel, String typeEngine) {
        this.wheels = wheels;
        this.fuel = fuel;
        this.typeEngine = typeEngine;
    }

    public static void main(String[] args) {
        Transport truck = new Transport(18, "diesel", "V12");
        Transport boat = new Transport(0, null, null);
    }
}
