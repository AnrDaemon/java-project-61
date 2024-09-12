package io.hexlet.code.games;

import java.util.Random;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

@SuppressWarnings("checkstyle:magicnumber")
public final class Primes implements GameInterface {

    private final static int numPrimes = 25;
    private static int[] set = new int[numPrimes];

    private final String name = "Primes";

    private final static int rangeMax = 100;

    private Random rand;

    static {
        initPrimes();
    }

    public Primes() {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public GameRound play() {
        Integer n = 2 * rand.nextInt(rangeMax / 2) + 1;
        final int length = set.length;
        for (int i = 0; i < length && set[i] > 0; i++) {
            if (n == set[i]) {
                return new GameRound(Integer.toString(n), "yes");
            }
        }

        return new GameRound(Integer.toString(n), "no");
    }

    public static void initPrimes() {
        int i = 0;
        set[i++] = 2;
        for (int n = 2 + 1; n < rangeMax; n = n + 2) {
            if (!isPrime(n)) {
                continue;
            }

            set[i++] = n;
        }
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
