package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private List<Storage> storageList = new ArrayList<>();

    public Context(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void execute(Food food) {
        for (Storage s: storageList) {
            if (s.accept(food)) {
                s.distribution(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Storage s: storageList) {
            foodList.addAll(s.getStorage());
            s.clearStorage();
        }

        for (Food food: foodList) {
            execute(food);
        }
    }
}
