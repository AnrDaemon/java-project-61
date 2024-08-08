package io.hexlet.code.games;

import java.util.Random;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

public final class GCD implements GameInterface {

    private final String name = "GCD";

    private Random rand;

    public GCD() {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public GameRound play() {
        int op0 = rand.nextInt(50) + 1;
        int op1 = rand.nextInt(50) + 1;
        Integer gcd = Math.min(op0, op1);
        op0 = Math.max(op0, op1);
        op1 = gcd;
        final String q = String.format("%d %d", op0, op1);
        while (op0 % gcd > 0) {
            op0 = op0 % gcd;
            gcd = Math.min(op0, op1);
            op0 = Math.max(op0, op1);
            op1 = gcd;
        }

        return new GameRound(q, gcd.toString());
    }

}
