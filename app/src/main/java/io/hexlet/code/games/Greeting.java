package io.hexlet.code.games;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;
import io.hexlet.code.LocaleStrings;

public class Greeting implements GameInterface {

    private final String name = "Introduction";

    private String userName = "stranger";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getRules() {
        return null;
    }

    @Override
    public GameRound play() {
        return new GameRound(LocaleStrings.nameRequest, null);
    }

}
