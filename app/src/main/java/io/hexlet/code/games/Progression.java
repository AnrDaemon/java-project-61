package io.hexlet.code.games;

import java.util.Random;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

public final class Progression implements GameInterface {

    private final String name = "Progression";

    private Random rand;

    public Progression() {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }

    @Override
    public GameRound play() {
        int n1 = rand.nextInt(20) + 1;
        int step = rand.nextInt(10) + 1;
        int length = 5 + rand.nextInt(4);
        int x = rand.nextInt(length);
        String a = Integer.toString(n1 + step * x);
        String q = "";
        for (int i = 0; i < length; i++) {
            q += (q.length() > 0 ? " " : "") + (i == x ? ".." : n1);
            n1 += step;
        }

        return new GameRound(q, a);
    }

}
