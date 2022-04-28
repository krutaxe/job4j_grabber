package ru.job4j.ood.lsp;

public class Truck implements Transport {
    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
