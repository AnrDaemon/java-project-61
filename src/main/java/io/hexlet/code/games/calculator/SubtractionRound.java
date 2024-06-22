package io.hexlet.code.games.calculator;

import io.hexlet.code.GameRound;

public class SubtractionRound extends GameRound {

    public SubtractionRound(int op0, int op1) {
        super(String.format("%1$d - %2$d (the subtraction of %2$d from %1$d)", op0, op1), Integer.toString(op0 - op1));
    }

}
