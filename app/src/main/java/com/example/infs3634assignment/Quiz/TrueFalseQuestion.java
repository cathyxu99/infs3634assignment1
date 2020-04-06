package com.example.infs3634assignment.Quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrueFalseQuestion extends Question implements Serializable {



    public TrueFalseQuestion(String organ, String question, int answer) {
        super(organ, question, answer);

    }

    public static List<TrueFalseQuestion> getBrainQuestions(){

        String organ = "brain";

        //Question 1
        String q1Question = "Is the brain located within the head?";
        int q1Answer = 1;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        //list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        //list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));

        return list;
    }
}
