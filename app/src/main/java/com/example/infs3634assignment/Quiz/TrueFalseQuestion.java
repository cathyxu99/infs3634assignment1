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

    public static List<TrueFalseQuestion> getHeartQuestions(){

        String organ = "heart";

        //Question 1
        String q1Question = "Exercise increases heart rate temporarily and resting heart rate in the longer term.";
        int q1Answer = 2;

        //Question 2
        String q2Question = "The heart is located between the lungs.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "Blood only flows in one way through the heart.";
        int q3Answer = 1;

        //Question 4
        String q4Question = "High blood pressure is NOT a risk factor for heart-related diseases";
        int q4Answer = 2;

        //Question 5
        String q5Question = "Diagnoses of heart diseases often may involve using an ultrasound";
        int q5Answer = 1;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

    public static List<TrueFalseQuestion> getLiverQuestions(){

        String organ = "liver";

        //Question 1
        String q1Question = "The liver is only found in vertebrates.";
        int q1Answer = 1;

        //Question 2
        String q2Question = "Bile contains cholesterol and bile acids.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "The gallbladder is located above the liver.";
        int q3Answer = 2;

        //Question 4
        String q4Question = "Liver transplantation is the only option for complete liver failure";
        int q4Answer = 1;

        //Question 5
        String q5Question = "Dialysis can be used to support the liver long-term";
        int q5Answer = 2;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

    public static List<TrueFalseQuestion> getSpleenQuestions(){

        String organ = "spleen";

        //Question 1
        String q1Question = "The spleen plays an important role in regard to white blood cells";
        int q1Answer = 2;

        //Question 2
        String q2Question = "The spleen synthesizes antibodies in its white pulp.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "It is located in the lower left quadrant of the abdomen";
        int q3Answer = 2;

        //Question 4
        String q4Question = "In the event of hemorrhagic shock, the spleen holds a reserve of blood";
        int q4Answer = 1;

        //Question 5
        String q5Question = "The spleen plays a minor role in the mononuclear phagocyte system";
        int q5Answer = 2;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

    public static List<TrueFalseQuestion> getKidneyQuestions(){

        String organ = "kidney";

        //Question 1
        String q1Question = "Kidneys are located in the retroperitoneal space";
        int q1Answer = 1;

        //Question 2
        String q2Question = "The ureter tube carries excreted amino acids";
        int q2Answer = 2;

        //Question 3
        String q3Question = "Each human adult kidney contains around 1 million nephrons";
        int q3Answer = 1;

        //Question 4
        String q4Question = "Filtration occurs in the glomerulus";
        int q4Answer = 1;

        //Question 5
        String q5Question = "Nephrectomy is frequently used to cure renal cysts";
        int q5Answer = 2;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

    public static List<TrueFalseQuestion> getStomachQuestions(){

        String organ = "stomach";

        //Question 1
        String q1Question = "The stomach is only found in vertebrates.";
        int q1Answer = 2;

        //Question 2
        String q2Question = "It is a hollow organ.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "The pyloric sphincter controls the passage of partially digested food.";
        int q3Answer = 1;

        //Question 4
        String q4Question = "Peristalsis takes over in duodenum.";
        int q4Answer = 1;

        //Question 5
        String q5Question = "Chemical breakdowns are performed only with acid";
        int q5Answer = 2;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

    public static List<TrueFalseQuestion> getIntestineQuestions(){

        String organ = "intestine";

        //Question 1
        String q1Question = "The small intestine of an average adult is s 3m when stretched out.";
        int q1Answer = 2;

        //Question 2
        String q2Question = "The small intestine is longer in length than the large intestine.";
        int q2Answer = 1;

        //Question 3
        String q3Question = "The surface area of your intestines could cover two tennis courts.";
        int q3Answer = 1;

        //Question 4
        String q4Question = "Trillions of organs live inside your large intestine.";
        int q4Answer = 1;

        //Question 5
        String q5Question = "The duodenum is the first section of the large intestine.";
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

        String organ = "pancreas";

        //Question 1
        String q1Question = "Pancreatic cancer exists.";
        int q1Answer = 1;

        //Question 2
        String q2Question = "The pancreas’ role in the digestive system is as an exocrine gland.";
        int q2Answer = 2;

        //Question 3
        String q3Question = "A common cause of pancreatic cancer is chronic alcohol use.";
        int q3Answer = 1;

        //Question 4
        String q4Question = "The word pancreas has a latin origin.";
        int q4Answer = 2;

        //Question 5
        String q5Question = "The pancreas has the function of regulating blood sugar levels.";
        int q5Answer = 1;

        List<TrueFalseQuestion> list = new ArrayList<>();

        list.add(new TrueFalseQuestion(organ, q1Question, q1Answer));
        list.add(new TrueFalseQuestion(organ, q2Question, q2Answer));
        list.add(new TrueFalseQuestion(organ, q3Question, q3Answer));
        list.add(new TrueFalseQuestion(organ, q4Question, q4Answer));
        list.add(new TrueFalseQuestion(organ, q5Question, q5Answer));


        return list;
    }

}
