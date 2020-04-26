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
        String q3Question = "The number of neurons in the brain is closest to?";
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

    public static List<MultipleChoiceQuestion> getLungsQuestions(){

        String organ = "lungs";

        //Question 1
        String q1Question = "The Lungs are part of which system?";
        String q1Option1 = "Nervous";
        String q1Option2 = "Endocrine";
        String q1Option3 = "Respiratory";
        String q1Option4 = "Digestive";
        int q1Answer = 3;

        //Question 2
        String q2Question = "The lungs contain roughly how much Alveoli ";
        String q2Option1 = "3 to 5 million";
        String q2Option2 = "30 to 50 million";
        String q2Option3 = "300 to 300 million";
        String q2Option4 = "3 to 5 billion";
        int q2Answer = 3;

        //Question 3
        String q3Question = "The right lung contains how many lobes";
        String q3Option1 = "2";
        String q3Option2 = "3";
        String q3Option3 = "4";
        String q3Option4 = "5";
        int q3Answer = 2;

        //Question 4
        String q4Question = "Which muscle drives breathing in humans?";
        String q4Option1 = "Pectoral";
        String q4Option2 = "Abdominal";
        String q4Option3 = "Esophagus";
        String q4Option4 = "Diaphragm";
        int q4Answer = 4;

        //Question 5
        String q5Question = "Together, the lungs approximately weigh:";
        String q5Option1 = "1.3kg";
        String q5Option2 = "1kg";
        String q5Option3 = "1.7kg";
        String q5Option4 = "1.5kg";
        int q5Answer = 1;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getHeartQuestions(){

        String organ = "heart";

        //Question 1
        String q1Question = "The heart is part of which system?";
        String q1Option1 = "Nervous";
        String q1Option2 = "Circulatory";
        String q1Option3 = "Respiratory";
        String q1Option4 = "Endocrine";
        int q1Answer = 2;

        //Question 2
        String q2Question = "How many chambers is the heart divided into?";
        String q2Option1 = "2";
        String q2Option2 = "3";
        String q2Option3 = "4";
        String q2Option4 = "5";
        int q2Answer = 3;

        //Question 3
        String q3Question = "Which is NOT a a layer that makes up the wall of the heart";
        String q3Option1 = "Epicardium";
        String q3Option2 = "Merocardium";
        String q3Option3 = "Myocardium";
        String q3Option4 = "Endocardium";
        int q3Answer = 2;

        //Question 4
        String q4Question = "The average, healthy heart beats has a resting rate close to:";
        String q4Option1 = "68cpm";
        String q4Option2 = "80bpm";
        String q4Option3 = "70bpm";
        String q4Option4 = "72bpm";
        int q4Answer = 4;

        //Question 5
        String q5Question = "The heart metabolizes which type of molecule";
        String q5Option1 = "Oxygen";
        String q5Option2 = "Carbon Dioxide";
        String q5Option3 = "Hydrogen";
        String q5Option4 = "Carbon Monoxide";
        int q5Answer = 1;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getLiverQuestions(){

        String organ = "liver";

        //Question 1
        String q1Question = "How many functions do textbooks usually cite the liver performing?";
        String q1Option1 = "300";
        String q1Option2 = "400";
        String q1Option3 = "500";
        String q1Option4 = "600";
        int q1Answer = 3;

        //Question 2
        String q2Question = "Which quadrant of the abdomen is the liver located in?";
        String q2Option1 = "Upper Left";
        String q2Option2 = "Lower Left";
        String q2Option3 = "Upper Right";
        String q2Option4 = "Lower Right";
        int q2Answer = 3;

        //Question 3
        String q3Question = "What initially stores bile produced by the liver";
        String q3Option1 = "Bladder";
        String q3Option2 = "Gallbladder";
        String q3Option3 = "Small Intestine";
        String q3Option4 = "Pancreas";
        int q3Answer = 2;

        //Question 4
        String q4Question = "The Liver's highly specialised tissue consists of mostly:";
        String q4Option1 = "Adipocyte";
        String q4Option2 = "Osteocyte";
        String q4Option3 = "Phagocyte";
        String q4Option4 = "Hepatocytes";
        int q4Answer = 4;

        //Question 5
        String q5Question = "Which is NOT a function of the liver";
        String q5Option1 = "Purifies oxygen";
        String q5Option2 = "Detoxifies various metabolites";
        String q5Option3 = "Synthesizes proteins";
        String q5Option4 = "Produces biochemicals";
        int q5Answer = 1;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getSpleenQuestions(){

        String organ = "spleen";

        //Question 1
        String q1Question = "The spleen filters what liquid in our body";
        String q1Option1 = "Water";
        String q1Option2 = "Blood";
        String q1Option3 = "Urine";
        String q1Option4 = "Cerebral Fluid";
        int q1Answer = 2;

        //Question 2
        String q2Question = "What colour is the spleen in humans";
        String q2Option1 = "Red";
        String q2Option2 = "Blue";
        String q2Option3 = "Purple";
        String q2Option4 = "Brown";
        int q2Answer = 3;

        //Question 3
        String q3Question = "The spleen recycles which metallic element?";
        String q3Option1 = "Potassium";
        String q3Option2 = "Iron";
        String q3Option3 = "Magnesium";
        String q3Option4 = "Gold";
        int q3Answer = 2;

        //Question 4
        String q4Question = "Which system does the spleen play an important role in?";
        String q4Option1 = "Lymphatic";
        String q4Option2 = "Circulatory";
        String q4Option3 = "Nervous";
        String q4Option4 = "Immune";
        int q4Answer = 4;

        //Question 5
        String q5Question = "The spleen's reservior of monocytes equals how much of the body's total reservior";
        String q5Option1 = "Over 20%";
        String q5Option2 = "Over 30%";
        String q5Option3 = "Over 40%";
        String q5Option4 = "Over 50%";
        int q5Answer = 4;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getKidneyQuestions(){

        String organ = "kidney";

        //Question 1
        String q1Question = "In adults, the kidneys are roughly what length?";
        String q1Option1 = "10cm";
        String q1Option2 = "12cm";
        String q1Option3 = "14cm";
        String q1Option4 = "16cm";
        int q1Answer = 2;

        //Question 2
        String q2Question = "Which substance is secreted by the Kidney";
        String q2Option1 = "Sodium";
        String q2Option2 = "Bicarbonate";
        String q2Option3 = "Hydrogen";
        String q2Option4 = "Amino Acids";
        int q2Answer = 3;

        //Question 3
        String q3Question = "What is the name of the medical speciality related to diseases of kidney function?";
        String q3Option1 = "Microbiology";
        String q3Option2 = "Nephrology";
        String q3Option3 = "Epistemology";
        String q3Option4 = "Epidemiology";
        int q3Answer = 2;

        //Question 4
        String q4Question = "Around how much of the blood entering the kidney is filtered?";
        String q4Option1 = "Half";
        String q4Option2 = "One-quarter";
        String q4Option3 = "One-third";
        String q4Option4 = "One-fifth";
        int q4Answer = 4;

        //Question 5
        String q5Question = "Which is not a disease of kidney anatomy?";
        String q5Option1 = "Pneumonia";
        String q5Option2 = "Cancer";
        String q5Option3 = "Renal cysts";
        String q5Option4 = "Ureteral Stones";
        int q5Answer = 1;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getStomachQuestions(){

        String organ = "stomach";

        //Question 1
        String q1Question = "The stomach is part of which system?";
        String q1Option1 = "Respiratory";
        String q1Option2 = "Digestive";
        String q1Option3 = "Immune";
        String q1Option4 = "Endocrine";
        int q1Answer = 2;

        //Question 2
        String q2Question = "It is located between the oesophagus and what other part?";
        String q2Option1 = "Small Intestine";
        String q2Option2 = "Brain";
        String q2Option3 = "Lungs";
        String q2Option4 = "Heart";
        int q2Answer = 1;

        //Question 3
        String q3Question = "In what phase of digestion is the stomach involved?";
        String q3Option1 = "1st";
        String q3Option2 = "2nd";
        String q3Option3 = "3rd";
        String q3Option4 = "4th";
        int q3Answer = 2;

        //Question 4
        String q4Question = "What type of acid is found in the stomach";
        String q4Option1 = "Sulfuric";
        String q4Option2 = "Carbonic";
        String q4Option3 = "Citric";
        String q4Option4 = "Hydrochloric";
        int q4Answer = 4;

        //Question 5
        String q5Question = "What type of acid is secreted to aid in food digestion";
        String q5Option1 = "Boric";
        String q5Option2 = "Nitric";
        String q5Option3 = "Gastric";
        String q5Option4 = "Oxalic";
        int q5Answer = 3;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getIntestineQuestions(){

        String organ = "intestine";

        //Question 1
        String q1Question = "How many intestines are there in the human body";
        String q1Option1 = "1";
        String q1Option2 = "2";
        String q1Option3 = "3";
        String q1Option4 = "1.5";
        int q1Answer = 2;

        //Question 2
        String q2Question = "Where does the small intestine lie";
        String q2Option1 = "Next to the heart";
        String q2Option2 = "Between the stomach and large intestine";
        String q2Option3 = "Above the lungs";
        String q2Option4 = "Between the liver and the heart";
        int q2Answer = 2;

        //Question 3
        String q3Question = "The large intestine is also called the:";
        String q3Option1 = "Pancreas";
        String q3Option2 = "Trachea";
        String q3Option3 = "Colon";
        String q3Option4 = "Bile";
        int q3Answer = 3;

        //Question 4
        String q4Question = "The small intestine is covered in things called:";
        String q4Option1 = "Villi";
        String q4Option2 = "Spleen";
        String q4Option3 = "Capillaries";
        String q4Option4 = "Alveoli";
        int q4Answer = 1;

        //Question 5
        String q5Question = "Intestines are part of the:";
        String q5Option1 = "Nervous System";
        String q5Option2 = "Endocrine System";
        String q5Option3 = "Renal System";
        String q5Option4 = "Digestive System";
        int q5Answer = 4;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

    public static List<MultipleChoiceQuestion> getPancreasQuestions(){

        String organ = "pancreas";

        //Question 1
        String q1Question = "The pancreas mainly serves which system?";
        String q1Option1 = "Nervous System";
        String q1Option2 = "Digestive System";
        String q1Option3 = "Respiratory System";
        String q1Option4 = "Circulatory System";
        int q1Answer = 2;

        //Question 2
        String q2Question = "Inflammation of the Pancreas is called what?";
        String q2Option1 = "Inflammation of the pancreas";
        String q2Option2 = "Gastritis";
        String q2Option3 = "Arthritis";
        String q2Option4 = "Pancreatitis";
        int q2Answer = 4;

        //Question 3
        String q3Question = "Pancreatic juice contains:";
        String q3Option1 = "Bicarbonate and digestive enzymes";
        String q3Option2 = "Sodium Chloride and Hydrogen Dioxide";
        String q3Option3 = "White blood cells";
        String q3Option4 = "Antibodies";
        int q3Answer = 1;

        //Question 4
        String q4Question = "The Pancreas is roughly located...";
        String q4Option1 = "Above the heart";
        String q4Option2 = "Behind the stomach";
        String q4Option3 = "Behind the intestines";
        String q4Option4 = "In front of the lungs";
        int q4Answer = 2;

        //Question 5
        String q5Question = "When was the pancreas' role in insulin production identified";
        String q5Option1 = "1923";
        String q5Option2 = "2002";
        String q5Option3 = "1921";
        String q5Option4 = "1945";
        int q5Answer = 3;



        List<MultipleChoiceQuestion> list = new ArrayList<>();

        list.add(new MultipleChoiceQuestion(organ, q1Question, q1Option1, q1Option2, q1Option3, q1Option4, q1Answer));
        list.add(new MultipleChoiceQuestion(organ, q2Question, q2Option1, q2Option2, q2Option3, q2Option4, q2Answer));
        list.add(new MultipleChoiceQuestion(organ, q3Question, q3Option1, q3Option2, q3Option3, q3Option4, q3Answer));
        list.add(new MultipleChoiceQuestion(organ, q4Question, q4Option1, q4Option2, q4Option3, q4Option4, q4Answer));
        list.add(new MultipleChoiceQuestion(organ, q5Question, q5Option1, q5Option2, q5Option3, q5Option4, q5Answer));

        return list;
    }

}
