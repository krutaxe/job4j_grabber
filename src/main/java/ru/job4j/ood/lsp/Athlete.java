package ru.job4j.ood.lsp;

/**
 *  Пример нарушения принципа LSP.
 *  В этом примере нарушение Инварианта в подклассе.
 *  Все условия базового класса, должны быть сохранены и в подклассе.
 */

public class Athlete {
    private int speed;

    public Athlete(int speed) throws Exception {
        if (speed < 0) {
            throw new Exception("Скорость меньше нуля");
        }
        this.speed = speed;
    }

    public int getTime(int distance, int speed) {
        return distance / speed;
    }
}

class Runner extends Athlete {

    public Runner(int speed) throws Exception {
        super(speed);
    }

    @Override
    public int getTime(int distance, int speed) {
        return super.getTime(distance, speed);
    }
}
