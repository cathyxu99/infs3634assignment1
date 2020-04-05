package com.example.infs3634assignment.Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.infs3634assignment.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Button submitButton = findViewById(R.id.submitButton);
        final Button beginButton = findViewById(R.id.beginButton);
        final ScrollView scrollView = findViewById(R.id.questionView);

        getQuestionCollection("brain");

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.removeAllViews();
                MultipleChoiceFragment fragment = new MultipleChoiceFragment();
                FragmentManager myManager = getSupportFragmentManager();
                FragmentTransaction myTransaction = myManager.beginTransaction();
                myTransaction.replace(R.id.questionView, fragment);
                myTransaction.commit();
                submitButton.setVisibility(View.VISIBLE);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultipleChoiceFragment fragment = new MultipleChoiceFragment();
                FragmentManager myManager = getSupportFragmentManager();
                FragmentTransaction myTransaction = myManager.beginTransaction();
                myTransaction.replace(R.id.questionView, fragment);
                myTransaction.commit();
            }
        });

    }

    public ArrayList<Question> getQuestionCollection(String organ){
        ArrayList<Question> list = new ArrayList<>();

        switch (organ){
            case "brain":
                list.addAll(MultipleChoiceQuestion.getBrainQuestions());
                list.addAll(TrueFalseQuestion.getBrainQuestions());
        }

        Collections.shuffle(list);
        return list;
    }
}
