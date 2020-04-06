package com.example.infs3634assignment.Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.infs3634assignment.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class QuizActivity extends AppCompatActivity {

    int answerSelected = 0;
    boolean answered = false;
    boolean completed = false;
    boolean lockButtons = false;
    int questionToAnswer = 0;


    final List<Question> questionList = getQuestionCollection("brain");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Button submitButton = findViewById(R.id.submitButton);
        final Button beginButton = findViewById(R.id.beginButton);
        final ScrollView scrollView = findViewById(R.id.questionView);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.removeAllViews();
                loadNextQuestion();
                submitButton.setVisibility(View.VISIBLE);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question question = new Question();

                if (!answered && answerSelected == 0) {
                    Toast.makeText(QuizActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                } else if (answered) {
                    clearButtonColour();
                    completed = loadNextQuestion();
                    answered = false;
                    lockButtons = false;
                    submitButton.setText("Submit");
                    if (completed) {
                        Intent intent = new Intent(v.getContext(), QuizActivity.class);
                        startActivity(intent);
                        answerSelected = 0;
                        answered = false;
                        completed = false;
                        questionToAnswer = 0;
                    }
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

    public ArrayList<Question> getQuestionCollection(String organ) {
        ArrayList<Question> list = new ArrayList<>();

        switch (organ) {
            case "brain":
                list.addAll(MultipleChoiceQuestion.getBrainQuestions());
                list.addAll(TrueFalseQuestion.getBrainQuestions());
                break;
        }

        Collections.shuffle(list);
        return list;
    }

    public void wrongAnswerFeedback(int button) {

        if (questionList.get(questionToAnswer-1) instanceof MultipleChoiceQuestion) {
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

        } else if (questionList.get(questionToAnswer-1) instanceof TrueFalseQuestion) {
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
        public void answerFeedback ( int button) {

            if (questionList.get(questionToAnswer-1) instanceof MultipleChoiceQuestion) {
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

            } else if (questionList.get(questionToAnswer-1) instanceof TrueFalseQuestion) {
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
        }
            public void clearButtonColour () {

                if (questionList.get(questionToAnswer-1) instanceof MultipleChoiceQuestion) {
                    final Button option1 = findViewById(R.id.mcqOption1);
                    final Button option2 = findViewById(R.id.mcqOption2);
                    final Button option3 = findViewById(R.id.mcqOption3);
                    final Button option4 = findViewById(R.id.mcqOption4);

                    option1.setBackgroundColor(Color.LTGRAY);
                    option2.setBackgroundColor(Color.LTGRAY);
                    option3.setBackgroundColor(Color.LTGRAY);
                    option4.setBackgroundColor(Color.LTGRAY);
                } else if (questionList.get(questionToAnswer-1) instanceof TrueFalseQuestion) {
                    Button trueButton = findViewById(R.id.trueButton);
                    Button falseButton = findViewById(R.id.falseButton);


                    trueButton.setBackgroundColor(Color.LTGRAY);
                    falseButton.setBackgroundColor(Color.LTGRAY);
                }


            }

            public boolean loadNextQuestion () {
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

            @Override
            protected void onPause () {
                super.onPause();
                finish();
            }
}

