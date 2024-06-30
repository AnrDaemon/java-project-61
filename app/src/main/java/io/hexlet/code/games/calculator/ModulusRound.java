package io.hexlet.code.games.calculator;

import io.hexlet.code.GameRound;

public class ModulusRound extends GameRound {

    public ModulusRound(int op0, int op1) {
        super(String.format("%1$d mod %2$d (the remainder of division of %1$d by %2$d)", op0, op1),
                Integer.toString(op0 % op1));
    }
}
