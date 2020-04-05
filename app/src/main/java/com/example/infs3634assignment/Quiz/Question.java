package com.example.infs3634assignment.Quiz;

import java.io.Serializable;

public class Question implements Serializable {
    String organ;
    String question;

    public Question(String organ, String question) {
        this.organ = organ;
        this.question = question;
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
}
