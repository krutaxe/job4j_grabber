package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Storage {

    default int controlFresh(Food food) {
        return ((LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear()) * 100)
                / (food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear());
    }

    boolean distribution(Food food);

    List<Food> getStorage();

    boolean accept(Food food);

    void clearStorage();
}
