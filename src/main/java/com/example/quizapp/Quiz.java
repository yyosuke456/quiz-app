package com.example.quizapp;

public class Quiz {
    /**
     * 問題文
     */
    private String question;
    /**
     * クイズの正解
     */
    private boolean answer;
    public Quiz(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public boolean getAnswer() {
        return answer;
    }
}
