package ru.job4j.cache;


import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dirFileCache1 = new DirFileCache("C:\\projects\\cache");
        String fileNames = "Names.txt";
        String fileAddress = "Address.txt";
        System.out.println(dirFileCache1.get(fileAddress));
        System.out.println(dirFileCache1.get(fileNames));

        Scanner in = new Scanner(System.in);
        System.out.println("Enter cached directory:");
        String dir = in.nextLine();
        DirFileCache dirFileCache2 = new DirFileCache(dir);
        System.out.println("Enter cached file:");
        String file = in.nextLine();
        System.out.println(dirFileCache2.get(file));
    }
}
