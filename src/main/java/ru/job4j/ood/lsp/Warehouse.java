package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends ControlQuality implements Storage {
    private List<Food> listWarehouse = new ArrayList<>();

    @Override
    public void distribution(Food food) {
        if (controlFresh(food) < 25) {
            listWarehouse.add(food);
        }
    }

    @Override
    public List<Food> getStorage() {
        return listWarehouse;
    }
}
