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
        String q1Question = "Where is the Brain Located?";
        String q1Option1 = "Torso";
        String q1Option2 = "Head";
        String q1Option3 = "Legs";
        String q1Option4 = "Arms";
        int q1Answer = 2;

        //Question 2
        String q2Question = "The brain is the central organ of which system:";
        String q2Option1 = "Lymphatic";
        String q2Option2 = "Endocrine";
        String q2Option3 = "Nervous";
        String q2Option4 = "Muscular";
        int q2Answer = 3;

        //Question 3
        String q3Question = "How many neurons are in the brain?";
        String q3Option1 = "Over 86 million";
        String q3Option2 = "Over 86 billion";
        String q3Option3 = "Over 860 million";
        String q3Option4 = "Over 860 billion";
        int q3Answer = 2;

        //Question 4
        String q4Question = "Which of these is NOT a lobe of a the brain hemispheres";
        String q4Option1 = "Temporal";
        String q4Option2 = "Occipital";
        String q4Option3 = "Parietal";
        String q4Option4 = "Cranial";
        int q4Answer = 4;

        //Question 5
        String q5Question = "The neocortex is split into how many neuronal layers?";
        String q5Option1 = "6";
        String q5Option2 = "7";
        String q5Option3 = "8";
        String q5Option4 = "9";
        int q5Answer = 1;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

}
