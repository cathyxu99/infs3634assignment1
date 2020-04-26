package com.example.infs3634assignment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.R;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AchievementsFragment extends Fragment {
    public UserDb userDb;
    public User currentUser;
    public String loggedInUser;
    public ImageView trophy1,trophy2,trophy3,trophy4,trophy5,trophy6;
    public TextView tName1,tName2,tName3,tName4,tName5,tName6;

    public AchievementsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_achievements, container, false);
        userDb = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
                .build();
        loggedInUser = ((BlankHomeActivity) getActivity()).getLoggedInUser();

        trophy1 = view.findViewById(R.id.trophy1);
        trophy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Unlock a new organ", Toast.LENGTH_SHORT).show();
            }
        });
        trophy2 = view.findViewById(R.id.trophy2);
        trophy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Use a non-default display picture", Toast.LENGTH_SHORT).show();
            }
        });
        trophy3 = view.findViewById(R.id.trophy3);
        trophy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Earn your first gold", Toast.LENGTH_SHORT).show();
            }
        });
        trophy4 = view.findViewById(R.id.trophy4);
        trophy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Complete a quiz in less than a minute", Toast.LENGTH_SHORT).show();
            }
        });
        trophy5 = view.findViewById(R.id.trophy5);
        trophy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Complete 3+ different quizzes on the same day", Toast.LENGTH_SHORT).show();
            }
        });

        trophy6 = view.findViewById(R.id.trophy6);
        trophy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Get gold on all quizzes", Toast.LENGTH_SHORT).show();
            }
        });

        tName1 = view.findViewById(R.id.tName1);
        tName2 = view.findViewById(R.id.tName2);
        tName3 = view.findViewById(R.id.tName3);
        tName4 = view.findViewById(R.id.tName4);
        tName5 = view.findViewById(R.id.tName5);
        tName6 = view.findViewById(R.id.tName6);

        GetTrophies getTrophies = new GetTrophies();
        getTrophies.execute();

        return view;
    }

    public class GetTrophies extends AsyncTask<Void,Void,User> {
        @Override
        protected User doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(loggedInUser);
            return currentUser;
        }

        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            //achievement 1
            if(!currentUser.getBrainTrophy().equals("n")){
                trophy1.setImageResource(R.drawable.trophyunlocked);
            }

            //achievement 2
            if(currentUser.getDisplayPictureId()!=R.drawable.avatarbloodcellsmall
                &&currentUser.getDisplayPictureId()!=R.drawable.avatareyeballsmall
                &&currentUser.getDisplayPictureId()!=R.drawable.avatarpersonsmall
                &&currentUser.getDisplayPictureId()!=R.drawable.avatarskullsmall){
                trophy2.setImageResource(R.drawable.trophyunlocked);
            }

            //achievement 3
            if(currentUser.getBrainTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }
            if(currentUser.getLungsTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getHeartTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getLiverTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getSpleenTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getKidneyTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getStomachTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getIntestineTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            if(currentUser.getPancreasTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }

            //achievement 4
            if((currentUser.getBrainFastestTime()<60000&&currentUser.getBrainFastestTime()!=0)
                    ||(currentUser.getLungsFastestTime()<60000&&currentUser.getLungsFastestTime()!=0)
                    ||(currentUser.getHeartFastestTime()<60000&&currentUser.getHeartFastestTime()!=0)
                    ||(currentUser.getLiverFastestTime()<60000&&currentUser.getLiverFastestTime()!=0)
                    ||(currentUser.getSpleenFastestTime()<60000&&currentUser.getSpleenFastestTime()!=0)
                    ||(currentUser.getKidneyFastestTime()<60000&&currentUser.getKidneyFastestTime()!=0)
                    ||(currentUser.getStomachFastestTime()<60000&&currentUser.getStomachFastestTime()!=0)
                    ||(currentUser.getIntestineFastestTime()<60000&&currentUser.getIntestineFastestTime()!=0)
                    ||(currentUser.getPancreasFastestTime()<60000&&currentUser.getPancreasFastestTime()!=0)){
                trophy4.setImageResource(R.drawable.trophyunlocked);
            }

            //achievement 5
            ArrayList<String> dateList = new ArrayList<String>();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if(currentUser.getBrainCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getBrainCDate()));
            } if(currentUser.getLungsCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getLungsCDate()));
            } if(currentUser.getHeartCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getHeartCDate()));
            }if(currentUser.getLiverCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getLiverCDate()));
            }if(currentUser.getSpleenCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getSpleenCDate()));
            }if(currentUser.getKidneyCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getKidneyCDate()));
            }if(currentUser.getStomachCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getStomachCDate()));
            }if(currentUser.getIntestineCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getIntestineCDate()));
            }if(currentUser.getPancreasCDate()!=null){
                dateList.add(dateFormat.format(currentUser.getPancreasCDate()));
            }

            // checks the frequency of the same date
            // reference: https://stackoverflow.com/questions/34456414/java-find-if-an-array-has-at-least-3-elements-with-the-same-value
            for (String item : dateList) {
                if (Collections.frequency(dateList, item) > 3) {
                    trophy5.setImageResource(R.drawable.trophyunlocked);;
                }
            }

            //achievement 6
            if(currentUser.getPancreasTrophy().equals("g")){
                trophy3.setImageResource(R.drawable.trophyunlocked);
            }
        }
    }
}
