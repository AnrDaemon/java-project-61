package io.hexlet.code;

import io.hexlet.code.games.Calculator;
import io.hexlet.code.games.EvenOdd;
import io.hexlet.code.games.GCD;
import io.hexlet.code.games.Greeting;
import io.hexlet.code.games.Primes;
import io.hexlet.code.games.Progression;

public class App {

    public String getGreeting() {
        // Placate tests
        return LocaleStrings.greeting;
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

        int n = 1;
        while (n > 0) {
            Boolean result = games.play(n);
            if (result != null) {
                if (result) {
                    Cli.println(LocaleStrings.winnerMessage, gr.getUserName());
                } else {
                    Cli.println(LocaleStrings.loserMessage, gr.getUserName());
                    return;
                }
            }

            for (GameTitle g : games) {
                Cli.println("%d. %s", g.idx, g.title);
            }

            Cli.println("%d. %s", 0, "Exit");
            n = Integer.parseInt(Cli.read(LocaleStrings.selectionPrompt));
        }

        Cli.println(LocaleStrings.parting, gr.getUserName());
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
