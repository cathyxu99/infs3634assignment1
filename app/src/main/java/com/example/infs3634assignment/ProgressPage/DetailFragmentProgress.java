package com.example.infs3634assignment.ProgressPage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infs3634assignment.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DetailFragmentProgress extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ProgressData mProgress;


    public DetailFragmentProgress() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragmentProgress.
     */
    public static DetailFragmentProgress newInstance(String param1, String param2) {
        DetailFragmentProgress fragment = new DetailFragmentProgress();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("OnCreateView Method in DetailFragProgress");
        ArrayList<ProgressData> progressData = new ArrayList<>();
        System.out.println(progressData);
        // Inflate the layout for this fragment
       // mProgress = ProgressData.getProgressData().get(progressData);

        View rootView = inflater.inflate(R.layout.fragment_detail_fragment_progress, container, false);
     //   TextView text = rootView.findViewById(R.id.levelName);
       // text.setText(mProgress.getLevel());

        return rootView;
    }


}
