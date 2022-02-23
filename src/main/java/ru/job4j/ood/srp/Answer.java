package ru.job4j.ood.srp;

/**
 *  Пример нарушения принципа SRP.
 *  Интерфейс получает и выводит ответ.
 */

public interface Answer {
    String getAnswer(String question);

    void print(String answer);
}
