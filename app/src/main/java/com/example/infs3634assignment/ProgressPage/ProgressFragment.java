package com.example.infs3634assignment.ProgressPage;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private String mParam1;
    private String mParam2;
    private ProgressAdapter.RecyclerViewClickListener mListener;

    public ProgressFragment() {
        // Required empty public constructor
    }

    public static ProgressFragment newInstance(String param1, String param2) {
        ProgressFragment fragment = new ProgressFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_ITEM_ID);
            // mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }
    //TEMPORARILY manually putting in points
    public int point = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProgressAdapter.RecyclerViewClickListener mListener = new ProgressAdapter.RecyclerViewClickListener() {
            //when the item in the list is clicked, detail activity opens
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);
            }
        };
//unlocking levels according as they finish quizzes
        if(point ==0){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel1());
         mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel1();
            return rootView;
        }
        else if (point ==1){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel2());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel2();
            return rootView;
        }
        else if (point ==2){
        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel3());
        mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel3();
        return rootView; }

        else if (point ==3){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel4());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel4();
            return rootView; }

        else if (point ==4){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel5());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel5();
            return rootView; }

        else if (point ==5){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel6());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel6();
            return rootView; }

        else if (point ==6){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel7());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel7();
            return rootView; }

        else if (point ==7){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel8());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel8();
            return rootView; }

        else if (point ==8){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel9());
            mRecyclerView.setAdapter(mAdapter);
            mProgressData = ProgressData.getLevel9();
            return rootView; }


        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel9());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }




    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
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

         /*
        Intent intent = new Intent(getActivity(), ProgressDetail2.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);

          */
    }

    public class GetOrgans extends AsyncTask<Void,Void, UserDb> {
        public User currentUser;
        public UserDb userDb;
        GetOrgans(UserDb userDb, User currentUser){
            this.userDb = userDb;
            this.currentUser = currentUser;
        }
        @Override
        protected UserDb doInBackground(Void... voids) {
            currentUser = userDb.userDao().searchUser("s");
            return userDb;
        }

        @Override
        protected void onPostExecute(UserDb userDb) {
            super.onPostExecute(userDb);
            if(currentUser.getBrainTrophy()!=null) {
            }

            if(currentUser.getLungsTrophy()!=null){
            }

            if(currentUser.getHeartTrophy()!=null) {
            }

            if(currentUser.getLiverTrophy()!=null) {
            }

            if(currentUser.getSpleenTrophy()!=null) {
            }

            if(currentUser.getKidneyTrophy()!=null) {
            }

            if(currentUser.getStomachTrophy()!=null) {
            }

            if(currentUser.getIntestineTrophy()!=null) {
            }

            if ((currentUser.getPancreasTrophy()!=null)) {
            }
        }
    }
}

