package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
   private List<Food> listShop = new ArrayList<>();

   @Override
   public boolean distribution(Food food) {
      boolean rsl = false;
      if (accept(food)) {
         if (add(food)) {
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount()));
         }
         listShop.add(food);
         rsl = true;
      }
      return rsl;
   }

   @Override
   public List<Food> getStorage() {
      return List.copyOf(listShop);
   }

   @Override
   public boolean accept(Food food) {
      return controlFresh(food) >= 25 && controlFresh(food) < 100;
   }

   public boolean add(Food food) {
      return controlFresh(food) > 75;
   }

   @Override
   public void clearStorage() {
      listShop.clear();
   }
}
