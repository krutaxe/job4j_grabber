package ru.job4j.ood.isp;

public interface Transport {
    void drive();

    void fly();

    void swim();
}

class Car implements Transport {
    @Override
    public void drive() {
        System.out.println("Car drive...");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException();
    }
}

class Airplane implements Transport {
    @Override
    public void drive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fly() {
        System.out.println("Airplane fly...");
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException();
    }
}

class Ship implements Transport {
    @Override
    public void drive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Ship swim...");
    }
}