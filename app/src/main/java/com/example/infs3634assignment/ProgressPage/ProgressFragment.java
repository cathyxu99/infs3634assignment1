package com.example.infs3634assignment.ProgressPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3634assignment.R;

public class ProgressFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_ITEM_ID = "item 1";
    public static final String EXTRA_MESSAGE = "test";
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
    public int point = 8;

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
        if(point ==0){
        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel1());
        mRecyclerView.setAdapter(mAdapter);
            return rootView;
        }
        else if (point ==1){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel2());
            mRecyclerView.setAdapter(mAdapter);
            return rootView;
        }
        else if (point ==2){
        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel3());
        mRecyclerView.setAdapter(mAdapter);
        return rootView; }

        else if (point ==3){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel4());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }

        else if (point ==4){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel5());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }

        else if (point ==5){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel6());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }

        else if (point ==6){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel7());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }

        else if (point ==7){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel8());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }

        else if (point ==8){
            RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getLevel9());
            mRecyclerView.setAdapter(mAdapter);
            return rootView; }
        return rootView;
    }




    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void launchDetailActivity(int position){
        /*
        System.out.println("launch detail activity method open");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        Fragment fragment = new DetailFragmentProgress();
        fragmentTransaction.replace(R.id.mainFragContainer, new DetailFragmentProgress());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

         */
        Intent intent = new Intent(getActivity(), ProgressDetail2.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }
}

