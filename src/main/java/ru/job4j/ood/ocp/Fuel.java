package ru.job4j.ood.ocp;

/**
 *  Пример нарушения принципа OCP.
 *  Класс наследует метод с реализацией который ему не подходит.
 */

public class Fuel {
    public String gasoline() {
        return "i use petrol";
    }

    private static class Car extends Fuel {
        @Override
        public String gasoline() {
            return super.gasoline();
        }
    }

    private static class ElectricCar extends Fuel {
        @Override
        public String gasoline() {
            return super.gasoline();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        ElectricCar electricCar = new ElectricCar();
        System.out.println(car.gasoline());
        System.out.println(electricCar.gasoline());
    }
}
