package com.example.infs3634assignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TheBodyFragment extends Fragment {
    private ImageButton brainButton,heartButton,lungButton,spleenButton,liverButton,stomachButton,kidneyButton,intestineButton,bladderButton;
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

        brainButton = view.findViewById(R.id.brainButton);
        brainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Brain");
            }
         });


        heartButton = view.findViewById(R.id.heartButton);
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Heart");
            }
        });

        lungButton = view.findViewById(R.id.lungButton);
        lungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Lung");
            }
        });

        spleenButton = view.findViewById(R.id.spleenButton);
        spleenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Spleen");
            }
        });

        stomachButton = view.findViewById(R.id.stomachButton);
        stomachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Stomach");
            }
        });

        liverButton = view.findViewById(R.id.liverButton);
        liverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Liver");
            }
        });
        kidneyButton = view.findViewById(R.id.kidneyButton);
        kidneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Kidney");
            }
        });
        intestineButton = view.findViewById(R.id.intestineButton);
        intestineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Gastrointestinal_tract");//
            }
        });

        bladderButton = view.findViewById(R.id.bladderButton);
        bladderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Urinary_bladder");
            }
        });
//
        return view;
    }

    public void launchLearnFragment(String organName){
        //the main activity is made up of a fragment similar to week 5 submission
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new LearnFragment();
        Bundle arguments = new Bundle();
        arguments.putString("organName",organName);
        fragment.setArguments(arguments);
        transaction.replace(R.id.mainFragContainer,fragment);
        transaction.commit();
    }
}

