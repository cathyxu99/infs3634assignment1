package com.example.infs3634assignment.Quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3634assignment.R;

public class MultipleChoiceFragment extends Fragment {

    public MultipleChoiceFragment() {

    }

    public static MultipleChoiceFragment newInstance(String param1, String param2) {
        MultipleChoiceFragment fragment = new MultipleChoiceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multiple_choice, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final QuizActivity quizActivity = (QuizActivity) getActivity();

        Bundle bundle = getArguments();
        MultipleChoiceQuestion question = (MultipleChoiceQuestion) bundle.getSerializable("question");
        final View view = getView();

        TextView questionText = view.findViewById(R.id.mcqQuestion);
        final Button option1 = view.findViewById(R.id.mcqOption1);
        final Button option2 = view.findViewById(R.id.mcqOption2);
        final Button option3 = view.findViewById(R.id.mcqOption3);
        final Button option4 = view.findViewById(R.id.mcqOption4);

        questionText.setText(question.getQuestion());
        option1.setText(question.getOption1());
        option2.setText(question.getOption2());
        option3.setText(question.getOption3());
        option4.setText(question.getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    option1.setBackgroundColor(Color.BLUE);
                    quizActivity.answerSelected = 1;
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    option2.setBackgroundColor(Color.BLUE);
                    quizActivity.answerSelected = 2;
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    option3.setBackgroundColor(Color.BLUE);
                    quizActivity.answerSelected = 3;
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    option4.setBackgroundColor(Color.BLUE);
                    quizActivity.answerSelected = 4;
                }
            }
        });

    }

    public void clearColour(View v){

        Button option1 = v.findViewById(R.id.mcqOption1);
        Button option2 = v.findViewById(R.id.mcqOption2);
        Button option3 = v.findViewById(R.id.mcqOption3);
        Button option4 = v.findViewById(R.id.mcqOption4);

        option1.setBackgroundColor(Color.LTGRAY);
        option2.setBackgroundColor(Color.LTGRAY);
        option3.setBackgroundColor(Color.LTGRAY);
        option4.setBackgroundColor(Color.LTGRAY);
    }


}
