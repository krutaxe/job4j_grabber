package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP, в том что метод playFootball в классе
 * Football зависит от класса Run,
 * а не от интерфейса Sport.
 */

public interface Sport {
    void doSport();
}

class Run implements Sport {
    @Override
    public void doSport() {
    }

    public void runSprint() {

    }
}

class Football {
    private void playFootball(Run run) {

    }
}
