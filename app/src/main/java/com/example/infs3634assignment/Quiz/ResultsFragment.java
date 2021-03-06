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
            correctAnswers = extras.getInt("numberCorrect");
            duration = extras.getLong("duration");
            organ = extras.getString("organToTest");
            userName =extras.getString("userName");


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
        amountIncorrect.setText(Integer.toString(10-correctAnswers));

        time.setText("Time: " + getTime(duration));
//TODO
        //Set result message
        if(correctAnswers>=8){
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
        if(correctAnswers<8){
            return null;
        }



        //set required medal
        if(correctAnswers==8){
            switch(organ){
                case "brain":
                    if(!(userDatabase.userDao().getBrainTrophy(userName).matches("s") || userDatabase.userDao().getBrainTrophy(userName).matches("g"))) {
                        userDatabase.userDao().changeBrainTrophy("b", userName);
                        Log.d(TAG, "doInBackground: Earned a bronze medal");
                    }
                    break;
                case "lungs":
                    if(!(userDatabase.userDao().getLungsTrophy(userName).matches("s") || userDatabase.userDao().getLungsTrophy(userName).matches("g")))
                    userDatabase.userDao().changeLungsTrophy("b", userName);
                    break;
                case "heart":
                    if(!(userDatabase.userDao().getHeartTrophy(userName).matches("s") || userDatabase.userDao().getHeartTrophy(userName).matches("g")))
                    userDatabase.userDao().changeHeartTrophy("b", userName);
                    break;
                case "liver":
                    if(!(userDatabase.userDao().getLiverTrophy(userName).matches("s") || userDatabase.userDao().getLiverTrophy(userName).matches("g")))
                    userDatabase.userDao().changeLiverTrophy("b", userName);
                    break;
                case "spleen":
                    if(!(userDatabase.userDao().getSpleenTrophy(userName).matches("s") || userDatabase.userDao().getSpleenTrophy(userName).matches("g")))
                    userDatabase.userDao().changeSpleenTrophy("b", userName);
                    break;
                case "kidney":
                    if(!(userDatabase.userDao().getKidneyTrophy(userName).matches("s") || userDatabase.userDao().getKidneyTrophy(userName).matches("g")))
                    userDatabase.userDao().changeKidneyTrophy("b", userName);
                    break;
                case "stomach":
                    if(!(userDatabase.userDao().getStomachTrophy(userName).matches("s") || userDatabase.userDao().getStomachTrophy(userName).matches("g")))
                    userDatabase.userDao().changeStomachTrophy("b", userName);
                    break;
                case "intestine":
                    if(!(userDatabase.userDao().getIntestineTrophy(userName).matches("s") || userDatabase.userDao().getIntestineTrophy(userName).matches("g")))
                    userDatabase.userDao().changeIntestineTrophy("b", userName);
                    break;
                case "pancreas":
                    if(!(userDatabase.userDao().getPancreasTrophy(userName).matches("s") || userDatabase.userDao().getPancreasTrophy(userName).matches("g")))
                    userDatabase.userDao().changePancreasTrophy("b", userName);
                    break;

            }
        }else if(correctAnswers==9) {
            switch (organ) {
                case "brain":
                    if(!(userDatabase.userDao().getBrainTrophy(userName).matches("g"))) {
                        userDatabase.userDao().changeBrainTrophy("s", userName);
                        Log.d(TAG, "doInBackground: Earned a silver medal");
                    }
                    break;
                case "lungs":
                    if(!(userDatabase.userDao().getLungsTrophy(userName).matches("g")))
                    userDatabase.userDao().changeLungsTrophy("s", userName);
                    break;
                case "heart":
                    if(!(userDatabase.userDao().getHeartTrophy(userName).matches("g")))
                    userDatabase.userDao().changeHeartTrophy("s", userName);
                    break;
                case "liver":
                    if(!(userDatabase.userDao().getLiverTrophy(userName).matches("g")))
                    userDatabase.userDao().changeLiverTrophy("s", userName);
                    break;
                case "spleen":
                    if(!(userDatabase.userDao().getSpleenTrophy(userName).matches("g")))
                    userDatabase.userDao().changeSpleenTrophy("s", userName);
                    break;
                case "kidney":
                    if(!(userDatabase.userDao().getKidneyTrophy(userName).matches("g")))
                    userDatabase.userDao().changeKidneyTrophy("s", userName);
                    break;
                case "stomach":
                    if(!(userDatabase.userDao().getStomachTrophy(userName).matches("g")))
                    userDatabase.userDao().changeStomachTrophy("s", userName);
                    break;
                case "intestine":
                    if(!(userDatabase.userDao().getIntestineTrophy(userName).matches("g")))
                    userDatabase.userDao().changeIntestineTrophy("s", userName);
                    break;
                case "pancreas":
                    if(!(userDatabase.userDao().getPancreasTrophy(userName).matches("g")))
                    userDatabase.userDao().changePancreasTrophy(organ, userName);
                    break;
            }
        }else if(correctAnswers==10) {
            switch (organ) {
                case "brain":
                    userDatabase.userDao().changeBrainTrophy("g", userName);
                    Log.d(TAG, "doInBackground: Earned a gold medal");
                    break;
                case "lungs":
                    userDatabase.userDao().changeLungsTrophy("g", userName);
                    break;
                case "heart":
                    userDatabase.userDao().changeHeartTrophy("g", userName);
                    break;
                case "liver":
                    userDatabase.userDao().changeLiverTrophy("g", userName);
                    break;
                case "spleen":
                    userDatabase.userDao().changeSpleenTrophy("g", userName);
                    break;
                case "kidney":
                    userDatabase.userDao().changeKidneyTrophy("g", userName);
                    break;
                case "stomach":
                    userDatabase.userDao().changeStomachTrophy("g", userName);
                    break;
                case "intestine":
                    userDatabase.userDao().changeIntestineTrophy("g", userName);
                    break;
                case "pancreas":
                    userDatabase.userDao().changePancreasTrophy("g", userName);
                    break;
            }
        }

        //update last completion date
        switch(organ){
            case "brain":
                userDatabase.userDao().changeBrainCDate(new Date(), userName);
                Log.d(TAG, "doInBackground: Date has been updated with" + new Date());
                break;
            case "lungs":
                userDatabase.userDao().changeLungsCDate(new Date(), userName);
                break;
            case "heart":
                userDatabase.userDao().changeHeartCDate(new Date(), userName);
                break;
            case "liver":
                userDatabase.userDao().changeLiverCDate(new Date(), userName);
                break;
            case "spleen":
                userDatabase.userDao().changeSpleenCDate(new Date(), userName);
                break;
            case "kidney":
                userDatabase.userDao().changeKidneyCDate(new Date(), userName);
                break;
            case "stomach":
                userDatabase.userDao().changeStomachCDate(new Date(), userName);
                break;
            case "intestine":
                userDatabase.userDao().changeIntestineCDate(new Date(), userName);
                break;
            case "pancreas":
                userDatabase.userDao().changePancreasCDate(new Date(), userName);
                break;
        }

        //get current fastest time
        long currentFastestTime = 99999999;
        switch(organ){
            case "brain":
                if( userDatabase.userDao().getBrainFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getBrainFastestTime(userName);
                    Log.d(TAG, "doInBackground: Getting currentFastestTime for Brain");
                    break;
                }
            case "lungs":
                if( userDatabase.userDao().getLungsFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getLungsFastestTime(userName);
                    break;
                }
            case "heart":
                if( userDatabase.userDao().getHeartFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getHeartFastestTime(userName);
                    break;
                }
            case "liver":
                if( userDatabase.userDao().getLiverFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getLiverFastestTime(userName);
                    break;
                }
            case "spleen":
                if( userDatabase.userDao().getSpleenFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getSpleenFastestTime(userName);
                    break;
                }
            case "kidney":
                if( userDatabase.userDao().getKidneyFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getKidneyFastestTime(userName);
                    break;
                }
            case "stomach":
                if( userDatabase.userDao().getStomachFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getStomachFastestTime(userName);
                    break;
                }
            case "intestine":
                if( userDatabase.userDao().getIntestineFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getIntestineFastestTime(userName);
                    break;
                }
            case "pancreas":
                if( userDatabase.userDao().getPancreasFastestTime(userName)!=0) {
                    currentFastestTime = userDatabase.userDao().getPancreasFastestTime(userName);
                    break;
                }
        }

        //set new time if it has been surpassed
        Log.d(TAG, "doInBackground: CurrentFastestTime Check " + currentFastestTime);

        if((duration/1000)<(currentFastestTime/1000)) {

            switch (organ) {
                case "brain":
                    userDatabase.userDao().changeBrainTime(duration, userName);
                    Log.d(TAG, "doInBackground: New fastest time" + duration);
                    break;
                case "lungs":
                    userDatabase.userDao().changeLungsTime(duration, userName);
                    break;
                case "heart":
                    userDatabase.userDao().changeHeartTime(duration, userName);
                    break;
                case "liver":
                    userDatabase.userDao().changeLiverTime(duration, userName);
                    break;
                case "spleen":
                    userDatabase.userDao().changeSpleenTime(duration, userName);
                    break;
                case "kidney":
                    userDatabase.userDao().changeKidneyTime(duration, userName);
                    break;
                case "stomach":
                    userDatabase.userDao().changeStomachTime(duration, userName);
                    break;
                case "intestine":
                    userDatabase.userDao().changeIntestineTime(duration, userName);
                    break;
                case "pancreas":
                    userDatabase.userDao().changePancreasTime(duration, userName);
                    break;
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
