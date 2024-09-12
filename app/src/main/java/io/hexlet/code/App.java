package io.hexlet.code;

import io.hexlet.code.games.Calculator;
import io.hexlet.code.games.EvenOdd;
import io.hexlet.code.games.GCD;
import io.hexlet.code.games.Greeting;
import io.hexlet.code.games.Primes;
import io.hexlet.code.games.Progression;

public final class App {

    public String getGreeting() {
        // Placate tests
        return LocaleStrings.GREETING;
    }

    public void run() {
        final Engine games = new Engine();
        final Greeting gr = new Greeting();
        games.register(gr);
        games.register(new EvenOdd());
        games.register(new Calculator());
        games.register(new GCD());
        games.register(new Progression());
        games.register(new Primes());

        Cli.println(gr.getRules());

        for (GameTitle g : games) {
            Cli.println("%d. %s", g.getIdx(), g.getTitle());
        }

        Cli.println("%d. %s", 0, "Exit");

        int n = Integer.parseInt(Cli.read(LocaleStrings.SELECTION_PROMPT));
        if (n == 0) {
            return;
        }

        if (n > 1) {
            games.play(1);
        }

        Boolean result = games.play(n);
        if (result != null) {
            if (result) {
                Cli.println(LocaleStrings.WINNER_MESSAGE, gr.getUserName());
            } else {
                Cli.println(LocaleStrings.LOSER_MESSAGE, gr.getUserName());
                return;
            }
        }

        Cli.println(LocaleStrings.PARTING, gr.getUserName());
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
