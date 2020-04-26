package com.example.infs3634assignment.ProgressPage;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3634assignment.BlankHomeActivity;
import com.example.infs3634assignment.R;
import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.util.ArrayList;

public class ProgressFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_ITEM_ID = "item 1";
    public static final String EXTRA_MESSAGE = "test";
    public ArrayList<ProgressData> mProgressData;
    private ProgressAdapter.RecyclerViewClickListener mListener;
    public UserDb  userDb;
    public User currentUser;
    public String loggedInUser;
    public RecyclerView mRecyclerView;

    public ProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        userDb = Room.databaseBuilder(getContext(), UserDb.class,"UserDB")
                .build();


        loggedInUser =  ((BlankHomeActivity) getActivity()).getLoggedInUser();
        GetProgress getProgress = new GetProgress();
        getProgress.execute();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    private void launchDetailActivity(int position){

        System.out.println("launch detail activity method open");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        Fragment fragment = new DetailFragmentProgress(position,mProgressData);
        fragmentTransaction.replace(R.id.mainFragContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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

//unlocking levels according as they finish quizzes
            if(currentUser.getBrainTrophy().equals("n")) {
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel1());
                mRecyclerView.setAdapter(mAdapter);
                mProgressData = ProgressData.getLevel1();
            }

            if(!currentUser.getBrainTrophy().equals("n")){
                mProgressData = ProgressData.getLevel2();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getLungsTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel3();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getHeartTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel4();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getLiverTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel5();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getSpleenTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel6();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getKidneyTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel7();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if(!currentUser.getStomachTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel8();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }

            if (!currentUser.getIntestineTrophy().equals("n")) {
                mProgressData = ProgressData.getLevel9();
                RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, mProgressData);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}

