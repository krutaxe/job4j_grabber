package ru.job4j.ood.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenBreadTrash() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = new ArrayList<>();
        storages.add(warehouse);
        storages.add(shop);
        storages.add(trash);
        Context context = new Context(storages);
        Food bread = new Bread("Baton",
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(20),
                100.0,
                0.5);
        context.execute(bread);
        assertEquals(bread, trash.getStorage().get(0));
    }

    @Test
    public void whenLemonadeWarehouse() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = new ArrayList<>();
        storages.add(warehouse);
        storages.add(shop);
        storages.add(trash);
        Context context = new Context(storages);
        Food lemonade = new Lemonade("Coca-cola",
                LocalDate.now().plusDays(100),
                LocalDate.now().minusDays(1),
                50.0,
                0.2);
        context.execute(lemonade);
        assertEquals(lemonade, warehouse.getStorage().get(0));
    }

    @Test
    public void whenCheeseShop() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = new ArrayList<>();
        storages.add(warehouse);
        storages.add(shop);
        storages.add(trash);
        Context context = new Context(storages);
        Food cheese = new Cheese("Hochland",
                LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(5),
                300.0,
                0.7);
        context.execute(cheese);
        assertEquals(cheese, shop.getStorage().get(0));
    }

    @Test
    public void whenCheeseDiscountShop() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = new ArrayList<>();
        storages.add(warehouse);
        storages.add(shop);
        storages.add(trash);
        Context context = new Context(storages);
        Food cheese = new Cheese("Hochland",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(10),
                300.0,
                0.5);
        Food expected = new Cheese("Hochland",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(10),
                150.0,
                0.5);
        context.execute(cheese);
        assertEquals(expected, shop.getStorage().get(0));
    }
}