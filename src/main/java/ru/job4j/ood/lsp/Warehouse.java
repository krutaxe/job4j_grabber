package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private List<Food> listWarehouse = new ArrayList<>();

    @Override
    public boolean distribution(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            listWarehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getStorage() {
        return List.copyOf(listWarehouse);
    }

    @Override
    public boolean accept(Food food) {
        return controlFresh(food) < 25;
    }
}
