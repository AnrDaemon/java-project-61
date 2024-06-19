package io.hexlet.code;

public class App {
    public String getGreeting() {
        return "Welcome to the Brain Games!";
    }

    public String getNameRequest() {
        return "May I have your name? ";
    }

    public String getWelcomeString(String userName) {
        return "Hello, " + userName + "!";
    }

    public static void main(String[] args) {
        Cli.greeting(new App());
    }
}
