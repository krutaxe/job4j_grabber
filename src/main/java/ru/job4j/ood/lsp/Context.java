package ru.job4j.ood.lsp;

public class Context {
    private Storage storage;

    public Context() {
    }

    public Context(Storage storage) {
        this.storage = storage;
    }

    public void execute(Food food) {
        storage.distribution(food);
    }

}
