package com.example.infs3634assignment.ProgressPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3634assignment.Notes.DetailNoteFragment;
import com.example.infs3634assignment.R;
import com.example.infs3634assignment.blankHomeActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class DetailFragmentProgress extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ProgressData mProgress;
    private String levelText;
    blankHomeActivity homeActivity;
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
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_detail_fragment_progress, container, false);
        final TextView levelText = rootView.findViewById(R.id.levelName);
      //  organImage.set
      //  mProgress = ProgressData.getProgressData().get(position);
        levelText.setText(mProgress.getLevel());




        return rootView;
    }


}

