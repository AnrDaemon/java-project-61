package io.hexlet.code;

import io.hexlet.code.games.Calculator;
import io.hexlet.code.games.EvenOdd;
import io.hexlet.code.games.GCD;
import io.hexlet.code.games.Greeting;
import io.hexlet.code.games.Primes;
import io.hexlet.code.games.Progression;

public class App {

    private String userName = "stranger";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getGreeting() {
        return "Welcome to the Brain Games, %s!";
    }

    public String getParting() {
        return "Goodbye, %s! Until we meet again…";
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
        final Engine games = new Engine(this);
        games.register(new Greeting(this));
        games.register(new EvenOdd(this));
        games.register(new Calculator(this));
        games.register(new GCD(this));
        games.register(new Progression(this));
        games.register(new Primes(this));

        Cli.println(this.getGreeting(), this.getUserName());

        int n = 1;
        while (n > 0) {
            Boolean result = games.play(n);
            if (result != null) {
                if (result) {
                    Cli.println(this.getWinnerMessage(), this.getUserName());
                } else {
                    Cli.println(this.getLoserMessage(), this.getUserName());
                    return;
                }
            }

            for (GameTitle g : games) {
                Cli.println("%d. %s", g.idx, g.title);
            }

            Cli.println("%d. %s", 0, "Exit");
            n = Integer.parseInt(Cli.read(this.getSelectionPrompt()));
        }

        Cli.println(getParting(), this.getUserName());
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
