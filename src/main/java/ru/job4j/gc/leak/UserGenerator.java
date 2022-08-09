package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {

    public static final String PATH_NAMES = "src/main/java/ru/job4j/gc/leak/files/names.txt";
    public static final String PATH_SURNAMES = "src/main/java/ru/job4j/gc/leak/files/surnames.txt";
    public static final String PATH_PATRONS = "src/main/java/ru/job4j/gc/leak/files/patr.txt";

    public static final String SEPARATOR = " ";
    public static final int NEW_USERS = 1000;
    private static List<User> users = new ArrayList<>();

    private List<String> names;
    private List<String> surnames;
    private List<String> patrons;
    private Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        StringBuilder name = new StringBuilder();
        users.clear();
        for (int i = 0; i < NEW_USERS; i++) {
            name.append(surnames.get(random.nextInt(surnames.size())))
                    .append(SEPARATOR)
                    .append(names.get(random.nextInt(names.size())))
                    .append(SEPARATOR)
                    .append(patrons.get(random.nextInt(patrons.size())));
            users.add(new User(name.toString()));
            name.setLength(0);
        }
    }

    private void readAll() {
        try {
            names = read(PATH_NAMES);
            surnames = read(PATH_SURNAMES);
            patrons = read(PATH_PATRONS);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public static List<User> getUsers() {
        return users;
    }
}
