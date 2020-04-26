package com.example.infs3634assignment.ProgressPage;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infs3634assignment.R;
import com.example.infs3634assignment.BlankHomeActivity;
import com.example.infs3634assignment.TheBodyFragment;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DetailFragmentProgress extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private int position;
    private ArrayList<ProgressData> mProgress;
    private String levelText, loggedInUser;
    public User currentUser;
    private UserDb userDb;
    public TextView time, levelTextView, cDate,badgeText ;
    public ImageView trophyImage;
    public Button backProgress;

    BlankHomeActivity homeActivity;

    public DetailFragmentProgress() {
        // Required empty public constructor
    }

    public DetailFragmentProgress(int position,ArrayList<ProgressData> mProgress){
        this.position = position;
        this.mProgress = mProgress;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
        if(extras!=null){
            ProgressData progress = (ProgressData) extras.getSerializable("noteInfo");
            levelText = progress.getLevel();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("OnCreateView Method in DetailFragProgress");
        ArrayList<ProgressData> progressData = new ArrayList<>();
        System.out.println(progressData);
        userDb = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
                .build();

        loggedInUser =  ((BlankHomeActivity) getActivity()).getLoggedInUser();
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_detail_fragment_progress, container, false);
       levelTextView = rootView.findViewById(R.id.levelName);
      //  organImage.set
        levelTextView.setText(mProgress.get(position).getLevel());
        cDate = rootView.findViewById(R.id.cDate);
        time = rootView.findViewById(R.id.time);
        trophyImage = rootView.findViewById(R.id.trophyImage);
        cDate = rootView.findViewById(R.id.cDate);
        badgeText = rootView.findViewById(R.id.badgeText);
        backProgress = rootView.findViewById(R.id.backProgress);
        backProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = new ProgressFragment();
                transaction.replace(R.id.mainFragContainer,fragment);
                transaction.commit();
            }
        });

        GetProgress getProgress = new GetProgress();
        getProgress.execute();
        return rootView;
    }

    public class GetProgress extends AsyncTask<Void,Void, UserDb> {
        @Override
        protected UserDb doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser(loggedInUser);
            return userDb;
        }

        @Override
        protected void onPostExecute(UserDb userDb) {
            super.onPostExecute(userDb);
            DateFormat dateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");

//unlocking levels according as they finish quizzes
            if(levelTextView.getText().toString().equals("Level 1: Brain")) {
                if (currentUser.getBrainCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getBrainCDate()));
                }
                if (currentUser.getBrainFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getBrainFastestTime()));
                }
                if (currentUser.getBrainTrophy() != null) {
                    if (currentUser.getBrainTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getBrainTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getBrainTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 2: Lungs")) {
                if (currentUser.getLungsCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getLungsCDate()));
                }
                if (currentUser.getLungsFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getLungsFastestTime()));
                }
                if (currentUser.getLungsTrophy() != null) {
                    if (currentUser.getLungsTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getLungsTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getLungsTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }


            if(levelTextView.getText().toString().equals("Level 3: Heart")) {
                if (currentUser.getHeartCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getHeartCDate()));
                }
                if (currentUser.getHeartFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getHeartFastestTime()));
                }
                if (currentUser.getHeartTrophy() != null) {
                    if (currentUser.getHeartTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getHeartTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getHeartTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 4: Liver")) {
                if (currentUser.getLiverCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getLiverCDate()));
                }
                if (currentUser.getLiverFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getLiverFastestTime()));
                }
                if (currentUser.getLiverTrophy() != null) {
                    if (currentUser.getLiverTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getLiverTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getLiverTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }
            if(levelTextView.getText().toString().equals("Level 5: Spleen")) {
                if (currentUser.getSpleenCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getSpleenCDate()));
                }
                if (currentUser.getSpleenFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getSpleenFastestTime()));
                }
                if (currentUser.getSpleenTrophy() != null) {
                    if (currentUser.getSpleenTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getSpleenTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getSpleenTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 6: Kidney")) {
                if (currentUser.getKidneyCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getKidneyCDate()));
                }
                if (currentUser.getKidneyFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getKidneyFastestTime()));
                }
                if (currentUser.getKidneyTrophy() != null) {
                    if (currentUser.getKidneyTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getKidneyTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getKidneyTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 7: Stomach")) {
                if (currentUser.getStomachCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getStomachCDate()));
                }
                if (currentUser.getStomachFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getStomachFastestTime()));
                }
                if (currentUser.getStomachTrophy() != null) {
                    if (currentUser.getStomachTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getStomachTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getStomachTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 8: Intestine")) {
                if (currentUser.getIntestineCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getIntestineCDate()));
                }
                if (currentUser.getIntestineFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getIntestineFastestTime()));
                }
                if (currentUser.getIntestineTrophy() != null) {
                    if (currentUser.getIntestineTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getIntestineTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getIntestineTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }

            if(levelTextView.getText().toString().equals("Level 9: Pancreas")) {
                if (currentUser.getPancreasCDate() != null) {
                    cDate.setText(dateFormat.format(currentUser.getPancreasCDate()));
                }
                if (currentUser.getPancreasFastestTime() != 0) {
                    time.setText(Long.toString(currentUser.getPancreasFastestTime()));
                }
                if (currentUser.getPancreasTrophy() != null) {
                    if (currentUser.getPancreasTrophy().equals("b")) {
                        badgeText.setText("Bronze");
                        trophyImage.setImageResource(R.drawable.badgebronze);
                    } else if (currentUser.getPancreasTrophy().equals("s")) {
                        badgeText.setText("Silver");
                        trophyImage.setImageResource(R.drawable.badgesilver);
                    } else if (currentUser.getPancreasTrophy().equals("g")) {
                        badgeText.setText("Gold");
                        trophyImage.setImageResource(R.drawable.badgegold);
                    }
                }
            }
        }
    }


}

