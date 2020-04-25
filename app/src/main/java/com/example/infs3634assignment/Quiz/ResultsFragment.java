package com.example.infs3634assignment.Quiz;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3634assignment.MainActivity;
import com.example.infs3634assignment.Notes.NoteDatabase;
import com.example.infs3634assignment.R;
import com.example.infs3634assignment.UserEntity.UserDb;
import com.example.infs3634assignment.blankHomeActivity;


public class ResultsFragment extends Fragment {

    int correctAnswers;
    long duration;
    String organ;
    String userName;

    UserDb userDatabase;

    public ResultsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), UserDb.class, "myDB").build();

        Bundle extras = getArguments();
        if(extras!=null){
            correctAnswers = extras.getInt("numberCorrect");
            duration = extras.getLong("duration");
            organ = extras.getString("organToTest");
            userName =extras.getString("userName");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_results, container, false);

        Button retryQuiz = rootview.findViewById(R.id.bRetryQuiz);
        Button returnHome = rootview.findViewById(R.id.bReturnHome);

        TextView amountCorrect = rootview.findViewById(R.id.amountCorrect);
        TextView amountIncorrect = rootview.findViewById(R.id.amountIncorrect);
        TextView time = rootview.findViewById(R.id.showTime);
        TextView msg = rootview.findViewById(R.id.resultMessage);

        amountCorrect.setText(Integer.toString(correctAnswers));
        amountIncorrect.setText(Integer.toString(4-correctAnswers));

        time.setText("Time: " + getTime(duration));

        //Set result message
        if(correctAnswers>=2){
            msg.setText("Congratulations, you have completed this level!");
        }else{
            msg.setText("Better luck next time...");
        }

        //Set retry quiz button
        retryQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("username",userName);
                intent.putExtra("organ", organ);
                startActivity(intent);
            }
        });

        //Set return Home button
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), blankHomeActivity.class);
                intent.putExtra("Username",userName);
                startActivity(intent);
            }
        });

        return rootview;
    }

    public String getTime(long milliTime){
        String stringTime = "Error collecting Time";

        String minutes = Long.toString((milliTime/1000)/60);
        String seconds = Integer.toString((int)((milliTime / 1000)%60));

        stringTime = minutes + "m " + seconds + "s";

        return stringTime;
    }

public class SaveResults extends AsyncTask<Void, Integer, Integer>{

    @Override
    protected Integer doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}

}
