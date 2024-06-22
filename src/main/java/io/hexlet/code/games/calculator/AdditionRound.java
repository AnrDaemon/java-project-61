package io.hexlet.code.games.calculator;

import io.hexlet.code.GameRound;

public class AdditionRound extends GameRound {

    public AdditionRound(int op0, int op1) {
        super(String.format("%1$d + %2$d (the sum of %1$d and %2$d)", op0, op1), Integer.toString(op0 + op1));
    }

}
