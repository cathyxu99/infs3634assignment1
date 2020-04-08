package com.example.infs3634assignment.Quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrueFalseQuestion extends Question implements Serializable {

    private boolean answer;

    public TrueFalseQuestion(String organ, String question) {
        super(organ, question);
    }

    public TrueFalseQuestion(String organ, String question, boolean answer) {
        super(organ, question);
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public static List<TrueFalseQuestion> getBrainQuestions(){

        String organ = "brain";

        //Question 1
        String q1Question = "Is the brain located within the head?";
        boolean q1Answer = true;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));

        return list;
    }
}
