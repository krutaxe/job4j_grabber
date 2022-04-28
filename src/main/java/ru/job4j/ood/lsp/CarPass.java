package ru.job4j.ood.lsp;

public class CarPass implements Transport {
    public static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}
