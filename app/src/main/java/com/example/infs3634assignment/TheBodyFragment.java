package com.example.infs3634assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.infs3634assignment.Learn.LearnFragment;

public class TheBodyFragment extends Fragment {
    private ImageButton brainButton
            ,heartButton
            ,lungButton
            ,spleenButton
            ,liverButton
            ,stomachButton
            ,kidneyButton
            ,intestineButton
            ,pancreasButton;
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
        ((blankHomeActivity) getActivity()).setTitleText("The Body");
        brainButton = view.findViewById(R.id.brainButton);
        brainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("human_brain");
                ((blankHomeActivity) getActivity()).setTitleText("The Brain");
            }
         });

        heartButton = view.findViewById(R.id.heartButton);
        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Heart");
                ((blankHomeActivity) getActivity()).setTitleText("The Heart");
            }
        });

        lungButton = view.findViewById(R.id.lungButton);
        lungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Lung");
                ((blankHomeActivity) getActivity()).setTitleText("The Lungs");
            }
        });

        spleenButton = view.findViewById(R.id.spleenButton);
        spleenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Spleen");
                ((blankHomeActivity) getActivity()).setTitleText("The Spleen");
            }
        });

        stomachButton = view.findViewById(R.id.stomachButton);
        stomachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Stomach");
                ((blankHomeActivity) getActivity()).setTitleText("The Stomach");
            }
        });

        liverButton = view.findViewById(R.id.liverButton);
        liverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Liver");
                ((blankHomeActivity) getActivity()).setTitleText("The Liver");
            }
        });
        kidneyButton = view.findViewById(R.id.kidneyButton);
        kidneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Kidney");
                ((blankHomeActivity) getActivity()).setTitleText("The Kidneys");
            }
        });
        intestineButton = view.findViewById(R.id.intestineButton);
        intestineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Gastrointestinal_tract");
                ((blankHomeActivity) getActivity()).setTitleText("The Intestines");//
            }
        });

        pancreasButton = view.findViewById(R.id.pancreaseButton);
        pancreasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLearnFragment("Pancreas");
                ((blankHomeActivity) getActivity()).setTitleText("The Pancreas");
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

