package io.hexlet.code;

public class Greeting implements GameInterface {

    private final String name = "Introduction";

    private int games = 0;
    private int score = 0;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Boolean play(App app) {
        Cli.println(app.getGreeting(), app.getUserName());
        String userName = Cli.read(app.getNameRequest());
        if (userName.length() > 0) {
            app.setUserName(userName);
        } else {
            Cli.println("Too bad. I'll call you %s, then.", app.getUserName());
        }

        Cli.println(app.getWelcomeString(), app.getUserName());

        return null;
    }

    @Override
    public int getGames() {
        return this.games;
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
