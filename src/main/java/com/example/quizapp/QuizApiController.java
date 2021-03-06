package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuizApiController {
    private List<Quiz> quizzes = new ArrayList<>();
    private QuizFileDao quizFileDao = new QuizFileDao();

    @GetMapping("quiz")
    public Quiz quiz() {
        int index = new Random().nextInt(quizzes.size());
        return quizzes.get(index);
    }
    @GetMapping("/show")
    public List<Quiz> show() {
        return quizzes;
    }

    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer) {
        Quiz quiz = new Quiz(question, answer);
        quizzes.add(quiz);
    }

    @GetMapping("/check")
    public String check(@RequestParam String question, @RequestParam boolean answer) {
        // 回答が正しいかをチェックして結果を返す。
        // questionを登録済みのクイズから検索
        for(Quiz quiz: quizzes) {
            // クイズが見つかったらanswerを取得する
            if (quiz.getQuestion().equals(question)) {
                // 登録されているanswerと登録されているanswerを比較し、一致していれば「正解」
                if(quiz.getAnswer() == answer) {
                    return "正解！";
                }else{// 一致していなければ「不正解」
                    return "不正解！";
                }
            } else {
                return "問題がありません";
            }
        }
        // 見つからなかったら「問題がありません」
        return "問題がありません";
    }

    @PostMapping("/save")
    public String save() {
        try {
            quizFileDao.write(quizzes);
            return "ファイルに保存しました";
        } catch (IOException e) {
            e.printStackTrace();
            return "ファイルの保存に失敗しました";
        }
    }

    @GetMapping("load")
    public String load() {
        try {
            quizzes = quizFileDao.read();
            return "ファイルを読み込みました。";
        } catch (IOException e){
            e.printStackTrace();
            return "ファイルの読み込みにｎ失敗しました";
        }
    }
}
