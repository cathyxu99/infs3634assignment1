package com.example.infs3634assignment.Quiz;

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

public class TrueFalseFragment extends Fragment {

    public TrueFalseFragment() {
        // Required empty public constructor
    }

    public static TrueFalseFragment newInstance(String param1, String param2) {
        TrueFalseFragment fragment = new TrueFalseFragment();
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
        View rootview = inflater.inflate(R.layout.fragment_true_false, container, false);

        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final QuizActivity quizActivity = (QuizActivity) getActivity();



        Bundle bundle = getArguments();
        TrueFalseQuestion question = (TrueFalseQuestion) bundle.getSerializable("question");
        final View view = getView();

        TextView questionNumber = view.findViewById(R.id.tfNumber);
        questionNumber.setText("Q"+(quizActivity.questionToAnswer));

        TextView questionText = view.findViewById(R.id.mcqQuestion);
        final Button trueButton = view.findViewById(R.id.trueButton);
        final Button falseButton = view.findViewById(R.id.falseButton);

        questionText.setText(question.getQuestion());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    trueButton.setBackgroundResource(R.drawable.solid_line_button_blue);
                    trueButton.setTextColor(Color.parseColor("#FFFFFF"));
                    falseButton.setTextColor(Color.parseColor("#76b4bd"));
                    falseButton.setBackgroundResource(R.drawable.solid_line_button);
                    quizActivity.answerSelected = 1;
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quizActivity.lockButtons) {
                    clearColour(view);
                    falseButton.setBackgroundResource(R.drawable.solid_line_button_blue);
                    falseButton.setTextColor(Color.parseColor("#FFFFFF"));
                    trueButton.setTextColor(Color.parseColor("#76b4bd"));
                    trueButton.setBackgroundResource(R.drawable.solid_line_button);
                    quizActivity.answerSelected = 2;
                }
            }
        });

    }

    public void clearColour(View v){

        Button trueButton = v.findViewById(R.id.trueButton);
        Button falseButton = v.findViewById(R.id.falseButton);


        trueButton.setBackgroundColor(Color.LTGRAY);
        falseButton.setBackgroundColor(Color.LTGRAY);

    }
}
