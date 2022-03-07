package ru.job4j.ood.lsp;

import java.util.List;

public interface Storage {
    void distribution(Food food);

    List<Food> getStorage();
}
