package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin  {

    public <T> T find(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T el: value) {
            rsl = comparator.compare(el, rsl) > 0 ? el : rsl;
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator.reversed());
    }
}