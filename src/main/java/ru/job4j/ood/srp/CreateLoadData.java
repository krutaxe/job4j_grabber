package ru.job4j.ood.srp;

import java.util.Date;
import java.util.List;

/**
 * Пример нарушения принципа SRP.
 * Интерфейс создает и загружает данные в БД.
 */

public interface CreateLoadData<T> {
    List<T> create(List<Integer> id, List<String> names, List<Date> date);

    void load(List<T> items);
}
