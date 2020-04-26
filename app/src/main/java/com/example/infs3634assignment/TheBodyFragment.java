package com.example.infs3634assignment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.infs3634assignment.Learn.LearnFragment;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

public class TheBodyFragment extends Fragment {
    private ImageButton brainButton
            ,heartButton
            ,lungButton
            ,spleenButton
            ,liverButton
            ,stomachButton
            ,kidneyButton
            ,intestineButton
            ,pancreasButton;
    public User currentUser;
    public UserDb userDb;
    public String loggedInUser;
    public TextView progressMessage, avatarUnlock;

    public TheBodyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body, container, false);
        ((BlankHomeActivity) getActivity()).setTitleText("The Body");
       loggedInUser =  ((BlankHomeActivity) getActivity()).getLoggedInUser();
        userDb = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
                .build();
        GetOrgans getOrgans = new GetOrgans(userDb,currentUser);
        getOrgans.execute();

        brainButton = view.findViewById(R.id.brainButton);
        heartButton = view.findViewById(R.id.heartButton);
        spleenButton = view.findViewById(R.id.spleenButton);
        kidneyButton = view.findViewById(R.id.kidneyButton);
        liverButton = view.findViewById(R.id.liverButton);
        stomachButton = view.findViewById(R.id.stomachButton);
        lungButton = view.findViewById(R.id.lungButton);
        intestineButton = view.findViewById(R.id.intestineButton);
        pancreasButton = view.findViewById(R.id.pancreaseButton);

        progressMessage = view.findViewById(R.id.message);
        avatarUnlock = view.findViewById(R.id.message2);

        brainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("human_brain","brain");
                ((BlankHomeActivity) getActivity()).setTitleText("The Brain");
            }
         });


//
        return view;
    }

    public void launchLearnFragment(String organName,String quizName){
        //the main activity is made up of a fragment similar to week 5 submission
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new LearnFragment();
        Bundle arguments = new Bundle();
        arguments.putString("organName",organName);
        arguments.putString("quizName",quizName);
        fragment.setArguments(arguments);
        transaction.replace(R.id.mainFragContainer,fragment);
        transaction.commit();
    }

    public class GetOrgans extends AsyncTask<Void,Void, UserDb>{
        public User currentUser;
        public UserDb userDb;
        GetOrgans(UserDb userDb, User currentUser){
            this.userDb = userDb;
            this.currentUser = currentUser;
        }
        @Override
        protected UserDb doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(loggedInUser);
            return userDb;
        }

        @Override
        protected void onPostExecute(UserDb userDb) {
            super.onPostExecute(userDb);
            if(!currentUser.getBrainTrophy().equals("n")) {
                lungButton.setVisibility(View.VISIBLE);
                progressMessage.setText("Great job braniac, complete the lungs quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Brain");
                lungButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Lung","lungs");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Lungs");
                    }
                });
            }

            if(!currentUser.getLungsTrophy().equals("n")){
                heartButton.setVisibility(View.VISIBLE);
                progressMessage.setText("Keep it up, complete the heart quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Lungs");
                heartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Heart","heart");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Heart");
                    }
                });
            }

            if(!currentUser.getHeartTrophy().equals("n")) {
                progressMessage.setText("Excellent, complete the liver quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Heart");
                liverButton.setVisibility(View.VISIBLE);
                liverButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Liver","liver");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Liver");
                    }
                });
            }

            if(!currentUser.getLiverTrophy().equals("n")) {
                progressMessage.setText("Keep it up, complete the spleen quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Liver");
                spleenButton.setVisibility(View.VISIBLE);
                spleenButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Spleen","spleen");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Spleen");
                    }
                });
            }

            if(!currentUser.getSpleenTrophy().equals("n")) {
                progressMessage.setText("Great, complete the kidney quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Spleen");
                kidneyButton.setVisibility(View.VISIBLE);
                kidneyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Kidney","kidney");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Kidneys");
                    }
                });
            }

            if(!currentUser.getKidneyTrophy().equals("n")) {
                progressMessage.setText("Nice job, complete the stomach quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Kidneys");
                stomachButton.setVisibility(View.VISIBLE);
                stomachButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Stomach","stomach");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Stomach");
                    }
                });
            }

            if(!currentUser.getStomachTrophy().equals("n")) {
                progressMessage.setText("Keep it up, complete the intestine quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Stomach");
                intestineButton.setVisibility(View.VISIBLE);
                intestineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Gastrointestinal_tract","intestines");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Intestines");//
                    }
                });
            }

            if(!currentUser.getIntestineTrophy().equals("n")) {
                progressMessage.setText("Keep it up, complete the pancreas quiz to unlock a new organ");
                avatarUnlock.setText("You've unlocked a new avatar: The Intestines");
                pancreasButton.setVisibility(View.VISIBLE);
                pancreasButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchLearnFragment("Pancreas","pancreas");
                        ((BlankHomeActivity) getActivity()).setTitleText("The Pancreas");
                    }
                });
            }
            if (!currentUser.getPancreasTrophy().equals("n")) {
                progressMessage.setText("Congratulations, you've passed all quizes. Try to master your knowledge by unlocking all trophies and achievements");
                avatarUnlock.setText("You've unlocked a new avatar: The Pancreas");
            }
        }
    }
}

