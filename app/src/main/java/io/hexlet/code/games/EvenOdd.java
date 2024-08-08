package io.hexlet.code.games;

import java.util.Random;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

public final class EvenOdd implements GameInterface {

    private final String name = "Even/Odd";

    private Random rand;

    public EvenOdd() {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public GameRound play() {
        Integer q;
        String a;

        q = 1 + Math.abs(rand.nextInt(100));
        a = (q % 2 > 0) ? "no" : "yes";

        return new GameRound(q.toString(), a);
    }
}
