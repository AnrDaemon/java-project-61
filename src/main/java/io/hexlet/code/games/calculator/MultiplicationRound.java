package io.hexlet.code.games.calculator;

import io.hexlet.code.GameRound;

public class MultiplicationRound extends GameRound {

    public MultiplicationRound(int op0, int op1) {
        super(String.format("%1$d * %2$d (the multiply of %1$d by %2$d)", op0, op1), Integer.toString(op0 * op1));
    }
}
