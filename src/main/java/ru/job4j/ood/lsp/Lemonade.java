package ru.job4j.ood.lsp;

import java.time.LocalDate;

class Lemonade extends Food {
    public Lemonade(String name, LocalDate expiryDate, LocalDate createDate,
                    double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
