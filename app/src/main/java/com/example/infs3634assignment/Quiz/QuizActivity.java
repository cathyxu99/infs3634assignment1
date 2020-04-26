package com.example.infs3634assignment.Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    final private String TAG = "#QUIZACTIVITY# ";

    //organ to test and user
    String organToTest;
    String userName;

    //Values use to check progress of user throughout the quiz
    int answerSelected = 0;
    boolean answered = false;
    boolean completed = false;
    boolean lockButtons = false;
    int questionToAnswer = 0;

    //Stats from the user's quiz attempt
    int correctAnswers = 0;
    long startTime = 0;
    long endTime = 0;
    long duration = 0;
    //int[] streaks;

    List<Question> questionList = getQuestionCollection("brain");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //get organ and user to test
        Intent organIntent = getIntent();
        organToTest = organIntent.getStringExtra("organ");
        userName = organIntent.getStringExtra("username");


        questionList = getQuestionCollection(organToTest);

        final Button submitButton = findViewById(R.id.submitButton);
        final Button beginButton = findViewById(R.id.beginButton);
        final ScrollView scrollView = findViewById(R.id.questionView);
        final TextView organMessage = findViewById(R.id.testingOrgan);

        organMessage.setText("Testing: " + organToTest);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.removeAllViews();
                loadNextQuestion();
                submitButton.setVisibility(View.VISIBLE);
                startTime = System.currentTimeMillis();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question question = new Question();

                //first check if the user answered the question
                if (!answered && answerSelected == 0) {
                    Toast.makeText(QuizActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                    //once feedback provided, user can progress to the next question
                } else if (answered) {
                    clearButtonColour();
                    completed = loadNextQuestion();
                    answered = false;
                    lockButtons = false;
                    submitButton.setText("Submit");
                    //if its completed, load the results fragment
                    if (completed) {

                        endTime = System.currentTimeMillis();
                        duration = endTime - startTime;
                        Log.d(TAG, getTime(duration));
                        Log.d(TAG, Integer.toString(correctAnswers));
                        loadResultsPage();

                        answerSelected = 0;
                        answered = false;
                        completed = false;
                        questionToAnswer = 0;
                    }
                 //if its has been answered check if it was right or wrong
                } else {

                    question = questionList.get(questionToAnswer - 1);

                    if (question.getAnswer() == answerSelected) {
                        answerFeedback(answerSelected);
                        answered = true;
                    } else if (question.getAnswer() != answerSelected) {
                        wrongAnswerFeedback(answerSelected);
                        answered = true;
                    }
                    answerSelected = 0;
                    lockButtons = true;
                    submitButton.setText("Next");
                }
            }
        });

    }

    /*Methods used to help complete the quiz lifecycle*/

    //Get the questions for the organ getting tested
    public ArrayList<Question> getQuestionCollection(String organ) {
        ArrayList<Question> list = new ArrayList<>();

        switch (organ) {
            case "brain":
                list.addAll(MultipleChoiceQuestion.getBrainQuestions());
                list.addAll(TrueFalseQuestion.getBrainQuestions());
                break;
            case "lungs":
                list.addAll(MultipleChoiceQuestion.getLungsQuestions());
                list.addAll(TrueFalseQuestion.getLungsQuestions());
                break;
            case "heart":
                list.addAll(MultipleChoiceQuestion.getHeartQuestions());
                list.addAll(TrueFalseQuestion.getHeartQuestions());
                break;
            case "liver":
                list.addAll(MultipleChoiceQuestion.getLiverQuestions());
                list.addAll(TrueFalseQuestion.getLiverQuestions());
                break;
            case "spleen":
                list.addAll(MultipleChoiceQuestion.getSpleenQuestions());
                list.addAll(TrueFalseQuestion.getSpleenQuestions());
                break;
            case "kidney":
                list.addAll(MultipleChoiceQuestion.getKidneyQuestions());
                list.addAll(TrueFalseQuestion.getKidneyQuestions());
                break;
            case "stomach":
                list.addAll(MultipleChoiceQuestion.getStomachQuestions());
                list.addAll(TrueFalseQuestion.getStomachQuestions());
                break;
            case "intestine":
                list.addAll(MultipleChoiceQuestion.getIntestineQuestions());
                list.addAll(TrueFalseQuestion.getIntestineQuestions());
                break;
            case "pancreas":
                list.addAll(MultipleChoiceQuestion.getPancreasQuestions());
                list.addAll(TrueFalseQuestion.getPancreasQuestions());
                break;
        }

        Collections.shuffle(list);
        return list;
    }

    //if wrong, set the colour of the button and record result
    public void wrongAnswerFeedback(int button) {

        if (questionList.get(questionToAnswer - 1) instanceof MultipleChoiceQuestion) {
            final Button option1 = findViewById(R.id.mcqOption1);
            final Button option2 = findViewById(R.id.mcqOption2);
            final Button option3 = findViewById(R.id.mcqOption3);
            final Button option4 = findViewById(R.id.mcqOption4);

            switch (button) {
                case 1:
                    option1.setBackgroundColor(Color.RED);
                    break;
                case 2:
                    option2.setBackgroundColor(Color.RED);
                    break;
                case 3:
                    option3.setBackgroundColor(Color.RED);
                    break;
                case 4:
                    option4.setBackgroundColor(Color.RED);
                    break;
            }

        } else if (questionList.get(questionToAnswer - 1) instanceof TrueFalseQuestion) {
            Button trueButton = findViewById(R.id.trueButton);
            Button falseButton = findViewById(R.id.falseButton);
            switch (button) {
                case 1:
                    trueButton.setBackgroundColor(Color.RED);
                    break;
                case 2:
                    falseButton.setBackgroundColor(Color.RED);
                    break;
            }

        }
    }

    //if right, set the colour of the button and record result
    public void answerFeedback(int button) {

        if (questionList.get(questionToAnswer - 1) instanceof MultipleChoiceQuestion) {
            final Button option1 = findViewById(R.id.mcqOption1);
            final Button option2 = findViewById(R.id.mcqOption2);
            final Button option3 = findViewById(R.id.mcqOption3);
            final Button option4 = findViewById(R.id.mcqOption4);

            switch (button) {
                case 1:
                    option1.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    option2.setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    option3.setBackgroundColor(Color.GREEN);
                    break;
                case 4:
                    option4.setBackgroundColor(Color.GREEN);
                    break;
            }

        } else if (questionList.get(questionToAnswer - 1) instanceof TrueFalseQuestion) {
            Button trueButton = findViewById(R.id.trueButton);
            Button falseButton = findViewById(R.id.falseButton);
            switch (button) {
                case 1:
                    trueButton.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    falseButton.setBackgroundColor(Color.GREEN);
                    break;
            }
        }

        correctAnswers++;
    }

    //clear all colours on buttons
    public void clearButtonColour() {

        if (questionList.get(questionToAnswer - 1) instanceof MultipleChoiceQuestion) {
            final Button option1 = findViewById(R.id.mcqOption1);
            final Button option2 = findViewById(R.id.mcqOption2);
            final Button option3 = findViewById(R.id.mcqOption3);
            final Button option4 = findViewById(R.id.mcqOption4);

            option1.setBackgroundColor(Color.LTGRAY);
            option2.setBackgroundColor(Color.LTGRAY);
            option3.setBackgroundColor(Color.LTGRAY);
            option4.setBackgroundColor(Color.LTGRAY);
        } else if (questionList.get(questionToAnswer - 1) instanceof TrueFalseQuestion) {
            Button trueButton = findViewById(R.id.trueButton);
            Button falseButton = findViewById(R.id.falseButton);


            trueButton.setBackgroundColor(Color.LTGRAY);
            falseButton.setBackgroundColor(Color.LTGRAY);
        }


    }

    //load the next fragment for the question
    public boolean loadNextQuestion() {
        boolean complete = false;

        if (questionList.size() <= questionToAnswer) {
            complete = true;
        } else {

            Fragment fragment = new Fragment();

            if (questionList.get(questionToAnswer) instanceof MultipleChoiceQuestion) {
                fragment = new MultipleChoiceFragment();
            } else if (questionList.get(questionToAnswer) instanceof TrueFalseQuestion) {
                fragment = new TrueFalseFragment();
            }

            Bundle bundle = new Bundle();
            bundle.putSerializable("question", questionList.get(questionToAnswer));
            fragment.setArguments(bundle);

            FragmentManager myManager = getSupportFragmentManager();
            FragmentTransaction myTransaction = myManager.beginTransaction();
            myTransaction.replace(R.id.questionView, fragment);
            myTransaction.commit();

            questionToAnswer++;
        }
        return complete;
    }

    //Load the results on completion
    public void loadResultsPage(){

        ResultsFragment fragment = new ResultsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("numberCorrect", correctAnswers);
        bundle.putLong("duration", duration);
        bundle.putString("organToTest", organToTest);
        bundle.putString("userName", userName);
        fragment.setArguments(bundle);

        FragmentManager myManager = getSupportFragmentManager();
        FragmentTransaction myTransaction = myManager.beginTransaction();
        myTransaction.replace(R.id.questionView, fragment);
        myTransaction.commit();

        Button submit = findViewById(R.id.submitButton);
        submit.setVisibility(View.INVISIBLE);
    }

    //convert long time to a user friendly string
    public String getTime(long milliTime){
        String stringTime = "Error collecting Time";

        String minutes = Long.toString((milliTime/1000)/60);
        String seconds = Integer.toString((int)((milliTime / 1000)%60));

        stringTime = minutes + "m " + seconds + "s";

        return stringTime;
    }

    //stop if the user exits the activity
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

