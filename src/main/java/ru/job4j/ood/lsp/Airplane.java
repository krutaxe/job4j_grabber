package ru.job4j.ood.lsp;

/**
 *  Пример нарушения принципа LSP.
 *  В этом примере предусловия усилены в подклассе.
 *  Подклассы не должны создавать больше предусловий, чем это определено в базовом классе.
 */

public class Airplane {

    private int height;

    public Airplane(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void seatBelts(int speed) {
        if (speed > 100 && height > 5000) {
            System.out.println("Unfasten your seat belts");
        }
    }
}

class Boeing777 extends Airplane {

    public Boeing777(int height) {
        super(height);
    }

    public void seatBelts(int speed) {
        if (speed > 100 && getHeight() > 5000 && getHeight() < 12000) {
            System.out.println("Unfasten your seat belts");
        }
    }
}
