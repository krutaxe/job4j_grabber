package ru.job4j.ood.ocp;

/**
 *  Пример нарушения принципа OCP.
 *  Не всем фигурам подходит формула вычисления в методе.
 */

public class FigureArea {
    private static class Area {
        public int area(int a, int b) {
            return a * b;
        }
    }
}
