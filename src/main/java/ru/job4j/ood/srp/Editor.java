package ru.job4j.ood.srp;

/**
 * Пример нарушения принципа SRP.
 * Интерфейс производит вычесления и записывает в файл.
 */

public interface Editor {
    double calculations(int a, int b, int c);
    void writeFile(double number);
}
