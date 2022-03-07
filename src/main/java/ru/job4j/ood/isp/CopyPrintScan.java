package ru.job4j.ood.isp;

public interface CopyPrintScan {
    void copy(String text);

    void print(String text);

    void scan(String text);
}

class Copy implements CopyPrintScan {
    @Override
    public void copy(String text) {
        System.out.println("Copy text " + text);
    }

    @Override
    public void print(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scan(String text) {
        throw new UnsupportedOperationException();
    }
}

class Printer implements CopyPrintScan {
    @Override
    public void copy(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(String text) {
        System.out.println("Print text " + text);
    }

    @Override
    public void scan(String text) {
        throw new UnsupportedOperationException();
    }
}

class Scanner implements CopyPrintScan {
    @Override
    public void copy(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void print(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void scan(String text) {
        System.out.println("Scan text " + text);
    }
}
