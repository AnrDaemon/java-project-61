package io.hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class App {

    private String userName = "stranger";

    private Map<Integer, GameInterface> games;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getGreeting() {
        return "Welcome to the Brain Games, %s!";
    }

    public String getNameRequest() {
        return "May I have your name?";
    }

    public String getWelcomeString() {
        return "Hello, %s! Glad to meet you!";
    }

    public String getSelectionPrompt() {
        return "Please select your game:";
    }

    public void run() {
        games = new HashMap<Integer, GameInterface>();
        games.put(0, null);
        games.put(1, new Greeting());

        int n = 1;
        while (n > 0) {
            games.get(n).play(this);

            int length = games.size();
            for (int i = 1; i < length; i++) {
                Cli.println("%d. %s", i, games.get(i).getName());
            }

            Cli.println("%d. %s", 0, "Exit");
            n = Integer.parseInt(Cli.read(this.getSelectionPrompt()));
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
