package io.hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

import io.hexlet.code.App;
import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

public class Primes implements GameInterface {

    private static int[] set = new int[25];

    private final String name = "Primes";

    private Random rand;

    static {
        int i = 0;
        set[i++] = 2;
        for (int n = 3; n < 100; n = n + 2) {
            if (!isPrime(n)) {
                continue;
            }

            set[i++] = n;
        }
    }

    public Primes(App app) {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "Determine if an odd number is Prime and answer 'yes' or 'no'.";
    }

    @Override
    public GameRound play() {
        Integer n = 2 * rand.nextInt(50) + 1;
        final int length = set.length;
        for (int i = 0; i < length && set[i] > 0; i++) {
            if (n == set[i]) {
                return new GameRound(Integer.toString(n), "yes");
            }
        }

        return new GameRound(Integer.toString(n), "no");
    }

    private static Boolean isPrime(int n) {
        final int length = set.length;
        for (int i = 1; i < length && set[i] > 0; i++) {
            if (n % set[i] > 0) {
                continue;
            }

            return false;
        }

        return true;
    }
}
