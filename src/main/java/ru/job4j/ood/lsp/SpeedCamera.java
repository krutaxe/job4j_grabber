package ru.job4j.ood.lsp;

/**
 *  Пример нарушения принципа LSP.
 *  В этом примере постусловия ослаблены в подклассе.
 */

public class SpeedCamera {

    public int speedControl(int speedCar) {
        int fine = 0;
        if (speedCar > 100) {
            System.out.println("You violated the speed limit");
        }

        if ((speedCar - 100) > 20) {
            fine = 1000;
        }
        return fine;
    }
}

class Car extends SpeedCamera {

    public int speedControl(int speedCar) {
        int fine = 0;
        if (speedCar > 100) {
            System.out.println("You violated the speed limit");
            fine = 1000;
        }
        return fine;
    }
}
