package com.example.infs3634assignment.ProgressPage;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.Adapter mAdapter = new ProgressAdapter(mListener, ProgressData.getProgressData());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;

    }




    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
