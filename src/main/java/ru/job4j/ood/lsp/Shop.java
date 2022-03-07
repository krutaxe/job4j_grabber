package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends ControlQuality implements Storage {
   private List<Food> listShop = new ArrayList<>();

   @Override
   public void distribution(Food food) {
      if (controlFresh(food) >= 25 && controlFresh(food) < 100) {
         if (controlFresh(food) > 75) {
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount()));
         }
         listShop.add(food);
      }
   }

   @Override
   public List<Food> getStorage() {
      return listShop;
   }

}
