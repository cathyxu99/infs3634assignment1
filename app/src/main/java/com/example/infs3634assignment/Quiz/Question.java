package com.example.infs3634assignment.Quiz;

import java.io.Serializable;

public class Question implements Serializable {
    String organ;
    String question;
    int answer;

    public Question(){
    }

    public Question(String organ, String question, int answer) {
        this.organ = organ;
        this.question = question;
        this.answer = answer;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
