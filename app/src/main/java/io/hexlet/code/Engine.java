package io.hexlet.code;

import java.util.HashMap;
import java.util.Iterator;

import io.hexlet.code.games.Greeting;

public class Engine implements Iterable<GameTitle> {

    private HashMap<Integer, GameInterface> games;

    public Engine() {
        this.games = new HashMap<Integer, GameInterface>();
        this.games.put(0, null);
    }

    public Engine register(GameInterface game) {
        this.games.put(games.size(), game);
        return this;
    }

    public Boolean play(int idx) {
        final GameInterface game = this.games.get(idx);
        if (game == null) {
            throw new RuntimeException("Unknown game idx");
        }

        final String rules = game.getRules();
        if (rules != null) {
            Cli.println("%s", rules);
        }

        if (game instanceof Greeting) {
            // Introduction game
            return this.greet((Greeting) game);
        }

        for (int i = 0; i < 3; i++) {
            final GameRound round = game.play();
            Cli.println(LocaleStrings.ROUND_QUESTION, round.getQuestion());
            String r = Cli.read(LocaleStrings.ROUND_ANSWER);
            if (round.getAnswer().equals(r)) {
                Cli.println(LocaleStrings.CORRECT_ANSWER_MESSAGE);
            } else {
                Cli.println(LocaleStrings.WRONG_ANSWER_MESSAGE, r, round.getAnswer());
                return false;
            }

        }

        return true;
    }

    private Boolean greet(Greeting game) {
        final GameRound round = game.play();
        String userName = Cli.read(round.getQuestion());
        if (userName.length() > 0) {
            game.setUserName(userName);
            Cli.println(LocaleStrings.WELCOME_STRING, userName);
        } else {
            Cli.println(LocaleStrings.INCOGNITO_STRING, game.getUserName());
        }
        return null;
    }

    @Override
    public Iterator<GameTitle> iterator() {
        return new Iterator<GameTitle>() {

            private int idx = 1;

            public boolean hasNext() {
                return (this.idx) < games.size();
            }

            public GameTitle next() {
                final GameInterface game = games.get(this.idx);
                return game == null ? null : new GameTitle(this.idx++, game);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("This is a read only collection");
            }
        };
    }
}
