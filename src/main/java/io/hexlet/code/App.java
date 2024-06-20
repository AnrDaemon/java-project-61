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
        return "Please choose a game:";
    }

    public String getCorrectAnswerMessage() {
        return "Correct!";
    }

    /**
     * Provides a "wrong answer" reply template
     *
     * @return
     */
    public String getWrongAnswerMessage() {
        return "'%s' was a wrong answer :`(. Correct answer was '%s'.";
    }

    public String getWinnerMessage() {
        return "Congratulations, %s! Wanna play again?";
    }

    public String getLoserMessage() {
        return "My condolence, but you lose. Good bye!";
    }

    public void run() {
        games = new HashMap<Integer, GameInterface>();
        games.put(0, null);
        games.put(1, new Greeting());
        games.put(2, new EvenOdd());

        int n = 1;
        while (n > 0) {
            Boolean result = games.get(n).play(this);
            if (result != null) {
                if (result) {
                    Cli.println(this.getWinnerMessage(), this.getUserName());
                } else {
                    Cli.println(this.getLoserMessage(), this.getUserName());
                    return;
                }
            }

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
