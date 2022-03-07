package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class ControlQuality {
   public static int controlFresh(Food food) {
        return ((LocalDate.now().getDayOfYear() - food.getCreateDate().getDayOfYear()) * 100)
                / (food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear());
    }
}
