package com.example.quizapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class QuizFileDao {

    private static final String FILE_PATH = "quizzes.txt";
    public void write(List<Quiz> quizzes) throws IOException {
        List<String> lines = quizzes.stream().map(q -> q.toString()).collect(Collectors.toList());
        Path path = Paths.get(FILE_PATH);
        Files.write(path, lines);
    }
}
