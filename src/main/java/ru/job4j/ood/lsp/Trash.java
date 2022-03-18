package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> listTrash = new ArrayList<>();

    @Override
    public boolean distribution(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            listTrash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getStorage() {
        return List.copyOf(listTrash);
    }

    @Override
    public boolean accept(Food food) {
        return controlFresh(food) >= 100;
    }

    @Override
    public void clearStorage() {
        listTrash.clear();
    }
}
