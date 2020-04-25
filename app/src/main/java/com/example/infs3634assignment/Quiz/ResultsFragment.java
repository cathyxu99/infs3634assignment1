package com.example.infs3634assignment.Quiz;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.service.autofill.UserData;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3634assignment.BlankHomeActivity;
import com.example.infs3634assignment.R;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.time.LocalDate;
import java.util.Date;


public class ResultsFragment extends Fragment {

    final private String TAG = "#RESULTSFRAGMENT#";

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

        userDatabase = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
                .build();

        Bundle extras = getArguments();
        if(extras!=null){
            correctAnswers = extras.getInt("numberCorrect");
            duration = extras.getLong("duration");
            organ = extras.getString("organToTest");
            userName =extras.getString("userName");
        }

        new SaveResults().execute();

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
//TODO
        amountCorrect.setText(Integer.toString(correctAnswers));
        amountIncorrect.setText(Integer.toString(4-correctAnswers));

        time.setText("Time: " + getTime(duration));
//TODO
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
                Intent intent = new Intent(getActivity(), BlankHomeActivity.class);
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

        //don't save any data if failed
        if(correctAnswers<2){
            return null;
        }
//TODO:
        //set required medal
        if(correctAnswers==2){
            switch(organ){
                case "brain":
                    userDatabase.userDao().changeBrainTrophy("b", userName);
                    Log.d(TAG, "doInBackground: Earned a bronze medal");
                case "lungs":
                    userDatabase.userDao().changeLungsTrophy("b", userName);
                case "heart":
                    userDatabase.userDao().changeHeartTrophy("b", userName);
                case "liver":
                    userDatabase.userDao().changeLiverTrophy("b", userName);
                case "spleen":
                    userDatabase.userDao().changeSpleenTrophy("b", userName);
                case "kidney":
                    userDatabase.userDao().changeKidneyTrophy("b", userName);
                case "stomach":
                    userDatabase.userDao().changeStomachTrophy("b", userName);
                case "intestine":
                    userDatabase.userDao().changeIntestineTrophy("b", userName);
                case "pancreas":
                    userDatabase.userDao().changePancreasTrophy("b", userName);

            }
        }else if(correctAnswers==3) {
            switch (organ) {
                case "brain":
                    userDatabase.userDao().changeBrainTrophy("s", userName);
                    Log.d(TAG, "doInBackground: Earned a silver medal");
                case "lungs":
                    userDatabase.userDao().changeLungsTrophy("s", userName);
                case "heart":
                    userDatabase.userDao().changeHeartTrophy("s", userName);
                case "liver":
                    userDatabase.userDao().changeLiverTrophy("s", userName);
                case "spleen":
                    userDatabase.userDao().changeSpleenTrophy("s", userName);
                case "kidney":
                    userDatabase.userDao().changeKidneyTrophy("s", userName);
                case "stomach":
                    userDatabase.userDao().changeStomachTrophy("s", userName);
                case "intestine":
                    userDatabase.userDao().changeIntestineTrophy("s", userName);
                case "pancreas":
                    userDatabase.userDao().changePancreasTrophy(organ, userName);
            }
        }else if(correctAnswers==4) {
            switch (organ) {
                case "brain":
                    userDatabase.userDao().changeBrainTrophy("g", userName);
                    Log.d(TAG, "doInBackground: Earned a gold medal");
                case "lungs":
                    userDatabase.userDao().changeLungsTrophy("g", userName);
                case "heart":
                    userDatabase.userDao().changeHeartTrophy("g", userName);
                case "liver":
                    userDatabase.userDao().changeLiverTrophy("g", userName);
                case "spleen":
                    userDatabase.userDao().changeSpleenTrophy("g", userName);
                case "kidney":
                    userDatabase.userDao().changeKidneyTrophy("g", userName);
                case "stomach":
                    userDatabase.userDao().changeStomachTrophy("g", userName);
                case "intestine":
                    userDatabase.userDao().changeIntestineTrophy("g", userName);
                case "pancreas":
                    userDatabase.userDao().changePancreasTrophy("g", userName);
            }
        }

        //update last completion date
        switch(organ){
            case "brain":
                userDatabase.userDao().changeBrainCDate(new Date(), userName);
                Log.d(TAG, "doInBackground: Date has been updated with" + new Date());
            case "lungs":
                userDatabase.userDao().changeLungsCDate(new Date(), userName);
            case "heart":
                userDatabase.userDao().changeHeartCDate(new Date(), userName);
            case "liver":
                userDatabase.userDao().changeLiverCDate(new Date(), userName);
            case "spleen":
                userDatabase.userDao().changeSpleenCDate(new Date(), userName);
            case "kidney":
                userDatabase.userDao().changeKidneyCDate(new Date(), userName);
            case "stomach":
                userDatabase.userDao().changeStomachCDate(new Date(), userName);
            case "intestine":
                userDatabase.userDao().changeIntestineCDate(new Date(), userName);
            case "pancreas":
                userDatabase.userDao().changePancreasCDate(new Date(), userName);
        }

        //get current fastest time
        long currentFastestTime = 99999999;
        switch(organ){
            case "brain":
                if( userDatabase.userDao().getBrainFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getBrainFastestTime(userName);
                    Log.d(TAG, "doInBackground: Updating currentFastestTime for Brain");
                }
            case "lungs":
                if( userDatabase.userDao().getLungsFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getLungsFastestTime(userName);
                }
            case "heart":
                if( userDatabase.userDao().getHeartFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getHeartFastestTime(userName);
                }
            case "liver":
                if( userDatabase.userDao().getLiverFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getLiverFastestTime(userName);
                }
            case "spleen":
                if( userDatabase.userDao().getSpleenFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getSpleenFastestTime(userName);
                }
            case "kidney":
                if( userDatabase.userDao().getKidneyFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getKidneyFastestTime(userName);
                }
            case "stomach":
                if( userDatabase.userDao().getStomachFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getStomachFastestTime(userName);
                }
            case "intestine":
                if( userDatabase.userDao().getIntestineFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getIntestineFastestTime(userName);
                }
            case "pancreas":
                if( userDatabase.userDao().getPancreasFastestTime(userName)!=null) {
                    currentFastestTime = userDatabase.userDao().getPancreasFastestTime(userName);
                }
        }

        //set new time if it has been surpassed
        Log.d(TAG, "doInBackground: CurrentFastestTime Check " + currentFastestTime);

        if((duration/1000)<(currentFastestTime/1000)) {

            switch (organ) {
                case "brain":
                    userDatabase.userDao().changeBrainTime(currentFastestTime, userName);
                    Log.d(TAG, "doInBackground: New fastest time" + duration);
                case "lungs":
                    userDatabase.userDao().changeLungsTime(currentFastestTime, userName);
                case "heart":
                    userDatabase.userDao().changeHeartTime(currentFastestTime, userName);
                case "liver":
                    userDatabase.userDao().changeLiverTime(currentFastestTime, userName);
                case "spleen":
                    userDatabase.userDao().changeSpleenTime(currentFastestTime, userName);
                case "kidney":
                    userDatabase.userDao().changeKidneyTime(currentFastestTime, userName);
                case "stomach":
                    userDatabase.userDao().changeStomachTime(currentFastestTime, userName);
                case "intestine":
                    userDatabase.userDao().changeIntestineTime(currentFastestTime, userName);
                case "pancreas":
                    userDatabase.userDao().changePancreasTime(currentFastestTime, userName);
            }
        }

        Log.d(TAG, "onPostExecute: UserName is " + userName);
        Log.d(TAG, "onPostExecute: The newly stored time is: " + userDatabase.userDao().getBrainFastestTime(userName));

        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

    }

}

}
