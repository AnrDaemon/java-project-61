package io.hexlet.code.games;

import java.util.Random;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;
import io.hexlet.code.games.calculator.AdditionRound;
import io.hexlet.code.games.calculator.ModulusRound;
import io.hexlet.code.games.calculator.MultiplicationRound;
import io.hexlet.code.games.calculator.SubtractionRound;

@SuppressWarnings("checkstyle:magicnumber")
public final class Calculator implements GameInterface {

    private final String name = "Calculator";

    private final int rangeMax = 50;

    private final int numOps = 3;

    private Random rand;

    public Calculator() {
        this.rand = new Random();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    @Override
    public GameRound play() {
        int op0 = rand.nextInt(rangeMax) + 1;
        int op1 = rand.nextInt(rangeMax) + 1;
        int op = rand.nextInt(numOps);

        switch (op) {
            case 0: // Addition
                return new AdditionRound(op0, op1);

            case 1: // Subtraction
                return new SubtractionRound(Math.max(op0, op1), Math.min(op0, op1));

            case 2: // Multiplication
                return new MultiplicationRound(op0, op1);

            case 2 + 1: // Modulus
                return new ModulusRound(Math.max(op0, op1), Math.min(op0, op1));

            default: // Nothing, but linter yells if missed
                throw new RuntimeException("Something is seriously amiss");
        }
    }

}
