package ru.job4j.ood.ocp;

/**
 *  Пример нарушения принципа OCP.
 *  В этом примере возвращаемый тип метода и параметры должны быть абстрактными,
 *  что бы можно было унаследоваться.
 */

public class Auto  {
    private String brand;
    private String model;
    private int powerEngine;
    private int price;

    public Auto(String brand, String model, int powerEngine, int price) {
        this.brand = brand;
        this.model = model;
        this.powerEngine = powerEngine;
        this.price = price;
    }

    public Car create(String brand, String model, int powerEngine, int price) {
        return new Car(brand, model, powerEngine, price);
    }

    private static class Car extends Auto {

        public Car(String brand, String model, int powerEngine, int price) {
            super(brand, model, powerEngine, price);
        }

        @Override
        public Car create(String brand, String model, int powerEngine, int price) {
            return super.create(brand, model, powerEngine, price);
        }

    }

    private static class Airplane extends Auto {

        public Airplane(String brand, String model, int powerEngine, int price) {
            super(brand, model, powerEngine, price);
        }

        @Override
        public Car create(String brand, String model, int powerEngine, int price) {
            return super.create(brand, model, powerEngine, price);
        }
    }
}