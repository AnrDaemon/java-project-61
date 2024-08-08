package io.hexlet.code;

public class GameRound {

    private String q;
    private String a;

    /**
     * Creates a pair "question:answer" which represents the next game round.
     *
     * @param q The question.
     * @param a The correct answer.
     */
    public GameRound(String q, String a) {
        this.q = q;
        this.a = a;
    }

    /**
     * @return Round question.
     */
    public String getQuestion() {
        return q;
    }

    /**
     * @return Round answer.
     */
    public String getAnswer() {
        return a;
    }
}
