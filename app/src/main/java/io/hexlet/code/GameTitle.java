package io.hexlet.code;

public class GameTitle {

    private int idx;

    public final int getIdx() {
        return idx;
    }

    private String title;

    public final String getTitle() {
        return title;
    }

    public GameTitle(int gameIndex, String gameTitle) {
        this.idx = gameIndex;
        this.title = gameTitle;
    }

    public GameTitle(int gameIndex, GameInterface game) {
        this.idx = gameIndex;
        this.title = game.getName();
    }
}
