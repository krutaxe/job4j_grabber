package ru.job4j.ood.dip;

/**
 * Метод carDrive() нарушает принцип DIP тем,
 * что принимает конкретный класс, вместо абстрактного.
 */

public class Driver {
    public void carDrive(Mazda mazda) {
        mazda.drive();
    }
}

class BMW {
    public void drive() {
        System.out.println("Drive BMW");
    }
}

class Audi {
    public void drive() {
        System.out.println("Drive Audi");
    }
}

class Mazda {
    public void drive() {
        System.out.println("Drive Mazda");
    }
}
