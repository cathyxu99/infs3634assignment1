package com.example.infs3634assignment.Quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question implements Serializable {
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answer;

    public MultipleChoiceQuestion(String organ, String question, String option1, String option2, String option3, String option4, int answer) {
        super(organ, question, answer);
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
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

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
/*
    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
*/
    public static List<MultipleChoiceQuestion> getBrainQuestions(){

        String organ = "brain";

        //Question 1
        String question = "Where is the Brain Located?";
        String q1Option1 = "Torso";
        String q1Option2 = "Head";
        String q1Option3 = "Legs";
        String q1Option4 = "Arms";
        int q1Answer = 2;


        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        //list.add(new MultipleChoiceQuestion(organ, question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        //list.add(new MultipleChoiceQuestion(organ, question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        //list.add(new MultipleChoiceQuestion(organ, question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));

        return list;
    }

}
