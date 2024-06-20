package io.hexlet.code;

import java.util.Random;

public class EvenOdd implements GameInterface {

    private final String name = "Even/Odd";

    private int games = 0;
    private int score = 0;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Boolean play(App app) {
        Random rand = new Random();
        int q;
        String a;

        Cli.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {
            do {
                q = Math.abs(rand.nextInt()) % 100;
            } while (!(q > 0));
            a = (q % 2 > 0) ? "no" : "yes";
            Cli.println("Question: %d", q);
            String r = Cli.read("Answer:");
            if (a.equals(r)) {
                Cli.println(app.getCorrectAnswerMessage());
            } else {
                Cli.println(app.getWrongAnswerMessage(), r, a);
                return false;
            }
        }

        return true;
    }

    @Override
    public int getGames() {
        return this.games;
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
