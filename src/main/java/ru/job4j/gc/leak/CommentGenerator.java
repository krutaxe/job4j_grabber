package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {

    public static final String PATH_PHRASES = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";

    public static final String SEPARATOR = System.lineSeparator();

    private static List<Comment> comments = new ArrayList<>();

    private static List<String> phrases;

    private final int count = 50;

    private UserGenerator userGenerator;

    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read(PATH_PHRASES);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        StringBuilder comment = new StringBuilder();
        comments.clear();
        List<Integer> ints = new ArrayList<>();
        random.ints(0, phrases.size())
                .distinct().limit(3).forEach(ints::add);
        for (int i = 0; i < count; i++) {
            comment.append(phrases.get(ints.get(0)))
                    .append(SEPARATOR)
                    .append(phrases.get(ints.get(1)))
                    .append(SEPARATOR)
                    .append(phrases.get(ints.get(2)));
            comments.add(new Comment(comment.toString(),
                    userGenerator.randomUser()));
        }
    }
}
