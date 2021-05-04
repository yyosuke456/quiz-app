package com.example.quizapp;

public class QuizTest {
    public void toStringWhenMaru(){
        Quiz quiz = new Quiz( question: "問題文", answer: true);
        assertThat(quiz.toString(), is("問題文○"));
    }

}
