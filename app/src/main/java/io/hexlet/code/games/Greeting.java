package io.hexlet.code.games;

import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;
import io.hexlet.code.LocaleStrings;

public final class Greeting implements GameInterface {

    private final String name = "Introduction";

    private String userName = "stranger";

    public void setUserName(String u) {
        this.userName = u;
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
        return LocaleStrings.GREETING;
    }

    @Override
    public GameRound play() {
        return new GameRound(LocaleStrings.NAME_REQUEST, null);
    }

}
