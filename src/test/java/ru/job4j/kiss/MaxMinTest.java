package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        List<Integer> integers = List.of(6, -5, -1, 20, 34, 4, 5, 2);
        int expected = 34;
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.max(integers, Integer::compare);
        assertThat(rsl, is(expected));
    }

    @Test
    public void min() {
        List<Integer> integers = List.of(6, -5, -1, 20, 34, 4, 5, 2);
        int expected = -5;
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.min(integers, Integer::compare);
        assertThat(rsl, is(expected));
    }
}