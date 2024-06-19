package io.hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greeting(App app) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(app.getGreeting());

        System.out.print(app.getNameRequest());
        String userName = scanner.next();

        System.out.println(app.getWelcomeString(userName));

        scanner.close();
    }

}
