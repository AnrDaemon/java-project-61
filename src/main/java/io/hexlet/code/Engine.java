package io.hexlet.code;

import java.util.HashMap;
import java.util.Iterator;

public class Engine implements Iterable<GameTitle> {

    private App app;

    private HashMap<Integer, GameInterface> games;

    public Engine(App app) {
        this.app = app;
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

        for (int i = 0; i < 3; i++) {
            final GameRound round = game.play();
            if (round == null) {
                return null;
            }
            if (round.getAnswer() == null) {
                Cli.println("%s", round.getQuestion());
                return null;
            }

            Cli.println("Question: %s", round.getQuestion());
            String r = Cli.read("Answer:");
            if (round.getAnswer().equals(r)) {
                Cli.println(app.getCorrectAnswerMessage());
            } else {
                Cli.println(app.getWrongAnswerMessage(), r, round.getAnswer());
                return false;
            }

        }

        return true;
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
