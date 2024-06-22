package io.hexlet.code;

public class GameRound {

    private String q;
    private String a;

    public GameRound(String q, String a) {
        this.q = q;
        this.a = a;
    }

    public String getQuestion() {
        return q;
    }

    public String getAnswer() {
        return a;
    }
}
