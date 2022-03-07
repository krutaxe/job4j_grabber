package ru.job4j.ood.isp;

public interface DrawFigure {
    void drawCircle();

    void drawSquare();
}

class Circle implements DrawFigure {
    @Override
    public void drawCircle() {
        System.out.println("Draw circle...");
    }

    @Override
    public void drawSquare() {
        throw new UnsupportedOperationException();
    }
}

class Square implements DrawFigure {
    @Override
    public void drawCircle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void drawSquare() {
        System.out.println("Draw square...");
    }
}