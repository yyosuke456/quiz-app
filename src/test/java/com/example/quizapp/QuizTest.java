package com.example.quizapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    @Test
    public void toStringマルのとき() {
        Quiz quiz = new Quiz("問題文", true);
        assertEquals(quiz.toString(), "問題文 ○");
    }
    @Test
    public void toStringバツのとき() {
        Quiz quiz = new Quiz("問題文", false);
        assertEquals(quiz.toString(), "問題文 ✕");
    }
    @Test
    public void fromStringマルのとき() {
        String line = "問題文1 ○";
        Quiz quiz = Quiz.fromString(line);
        assertEquals(quiz.getQuestion(), "問題文1");
        assertEquals(quiz.getAnswer(), true);
    }
    @Test
    public void fromStringバツのとき() {
        String line = "問題文1 ✕";
        Quiz quiz = Quiz.fromString(line);
        assertEquals(quiz.getQuestion(), "問題文1");
        assertEquals(quiz.getAnswer(), false);
    }
}