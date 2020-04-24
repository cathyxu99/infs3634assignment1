package com.example.infs3634assignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.infs3634assignment.Learn.OrganImageAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    public Button register;
    public TextView username, currentPassword, newPassword, newPasswordConfirmed;

    public ProfileFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
       LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
       RecyclerView recyclerView = view.findViewById(R.id.dpRecycler);
       recyclerView.setLayoutManager(layoutManager);
       ArrayList<Integer> imageDps = new ArrayList<>();
       imageDps.add(R.drawable.bladder);
       DpAdapter dpAdapter = new DpAdapter(imageDps);
       recyclerView.setAdapter(dpAdapter);
       return view;
    }


}
