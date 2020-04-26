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
        String q1Question = "The brain located within the head.";
        int q1Answer = 1;

        //Question 2
        String q2Question = "The cerebrum is the largest part of the brain.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "Both hemispheres of the brain perform exactly the same functions.";
        int q3Answer = 2;

        //Question 4
        String q4Question = "The brain is protected by the skull, suspended in water.";
        int q4Answer = 2;

        //Question 5
        String q5Question = "Parkinson's is an example of a psychiatric condition that can affect the brain.";
        int q5Answer = 2;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }
}
