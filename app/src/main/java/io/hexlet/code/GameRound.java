package io.hexlet.code;

public class GameRound {

    private String question;
    private String answer;

    /**
     * Creates a pair "question:answer" which represents the next game round.
     *
     * @param q The question.
     * @param a The correct answer.
     */
    public GameRound(String q, String a) {
        this.question = q;
        this.answer = a;
    }

    /**
     * @return Round question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return Round answer.
     */
    public String getAnswer() {
        return answer;
    }
}
