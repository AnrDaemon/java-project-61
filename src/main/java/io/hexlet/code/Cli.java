package io.hexlet.code;

import java.util.Scanner;

public class Cli {

    private static Scanner scanner = new Scanner(System.in);

    public static void print(String line, Object... param) {
        System.out.printf(line, param);
    }

    public static void println(String line, Object... param) {
        System.out.printf(line + '\n', param);
    }

    public static String read(String line, Object... param) {
        scanner.reset();
        print("%s ", line);
        return scanner.nextLine().trim();
    }
}
