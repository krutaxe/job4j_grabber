package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends ControlQuality implements Storage {
    private List<Food> listTrash = new ArrayList<>();

    @Override
    public void distribution(Food food) {
        if (controlFresh(food) >= 100) {
            listTrash.add(food);
        }
    }

    @Override
    public List<Food> getStorage() {
        return listTrash;
    }
}
