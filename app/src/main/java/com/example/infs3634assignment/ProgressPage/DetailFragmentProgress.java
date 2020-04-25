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
    private int position;
    private ArrayList<ProgressData> mProgress;
    private String levelText;

    blankHomeActivity homeActivity;

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
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_detail_fragment_progress, container, false);
        final TextView levelText = rootView.findViewById(R.id.levelName);
      //  organImage.set
        levelText.setText(mProgress.get(position).getLevel());




        return rootView;
    }


}

