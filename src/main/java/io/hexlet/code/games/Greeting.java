package io.hexlet.code.games;

import io.hexlet.code.App;
import io.hexlet.code.Cli;
import io.hexlet.code.GameInterface;
import io.hexlet.code.GameRound;

public class Greeting implements GameInterface {

    private final String name = "Introduction";

    private App app;

    public Greeting(App app) {
        this.app = app;
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
        String userName = Cli.read(app.getNameRequest());
        if (userName.length() > 0) {
            app.setUserName(userName);
        } else {
            Cli.println("Too bad. I'll call you %s, then.", app.getUserName());
        }

        Cli.println(app.getWelcomeString(), app.getUserName());

        return null;
    }

}
