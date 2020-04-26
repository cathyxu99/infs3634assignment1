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
        String q1Question = "An interruption to the brain's blood flow is called a stroke.";
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

    public static List<TrueFalseQuestion> getLungsQuestions(){

        String organ = "lungs";

        //Question 1
        String q1Question = "The right lung is bigger than the left.";
        int q1Answer = 1;

        //Question 2
        String q2Question = "The lungs are developed completely a few months after birth";
        int q2Answer = 2;

        //Question 3
        String q3Question = "Pulmonology is the study of diseases involving the respiratory tract.";
        int q3Answer = 1;

        //Question 4
        String q4Question = "Together, the lungs contain approximately 2,400m of airways.";
        int q4Answer = 2;

        //Question 5
        String q5Question = "Pneumonia is an example of a respiratory illness";
        int q5Answer = 1;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }
    //TODO: Fill in Heart
    public static List<TrueFalseQuestion> getHeartQuestions(){

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
    //TODO: Fill in Liver
    public static List<TrueFalseQuestion> getLiverQuestions(){

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
    //TODO: Fill in Spleen
    public static List<TrueFalseQuestion> getSpleenQuestions(){

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
    //TODO: Fill in Kidney
    public static List<TrueFalseQuestion> getKidneyQuestions(){

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
    //TODO: Fill in Stomach
    public static List<TrueFalseQuestion> getStomachQuestions(){

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
    //TODO: Fill in Intestine
    public static List<TrueFalseQuestion> getIntestineQuestions(){

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
    //TODO: Fill in Pancreas
    public static List<TrueFalseQuestion> getPancreasQuestions(){

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
