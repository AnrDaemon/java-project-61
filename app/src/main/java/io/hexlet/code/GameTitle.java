package io.hexlet.code;

public class GameTitle {

    public int idx;
    public String title;

    public GameTitle(int idx, String title) {
        this.idx = idx;
        this.title = title;
    }

    public GameTitle(int idx, GameInterface game) {
        this.idx = idx;
        this.title = game.getName();
    }
}
