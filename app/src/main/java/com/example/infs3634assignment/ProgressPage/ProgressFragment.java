package com.example.infs3634assignment.ProgressPage;

import android.content.Context;
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
import android.widget.Button;

import com.example.infs3634assignment.LearnFragment;
import com.example.infs3634assignment.R;

public class ProgressFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_ITEM_ID = "item 1";
    public static final String EXTRA_MESSAGE = "start";

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ProgressAdapter.RecyclerViewClickListener listener = new ProgressAdapter.RecyclerViewClickListener() {
            //when the item in the list is clicked, detail activity opens
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);
            }
        };

        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getProgressData());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }

    private void launchDetailActivity(int position){
        /*
        Intent intent = new Intent(getActivity(), DetailFragmentProgress.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
*/
        DetailFragmentProgress progressDetail= new DetailFragmentProgress();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFragContainer, progressDetail, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }




}
