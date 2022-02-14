package ru.job4j.gc;

public class User {
    private long age;
    private String name;

    public User(long age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Removed %d %s%n", age, name);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());

        for (long i = 0; i < 500; i++) {
             new User(i, "T" + i);
        }

        System.out.println("_____________________");
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());

    }
}
