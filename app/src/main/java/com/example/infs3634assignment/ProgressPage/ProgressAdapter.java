package com.example.infs3634assignment.ProgressPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634assignment.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {
    public static final String TAG = "adapter";
    private ArrayList<ProgressData> mProgress;
    private RecyclerViewClickListener mListener;
  //  private MainActivity mParent;


    public ProgressAdapter(RecyclerViewClickListener listener, ArrayList<ProgressData> progress) {
        //  mParent = parent;
        mListener = listener;
        mProgress = progress;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int Position);
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public TextView level;

        public ProgressViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            level = v.findViewById(R.id.level);
            Log.d(TAG, "progress View Holder: success");


        }
    }

    //initialises the viewholder to display the contents
    @Override
    public ProgressAdapter.ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_list_row,parent,false);
        return new ProgressViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder (ProgressViewHolder holder, final int position){
        ProgressData progress = mProgress.get(position);
        holder.level.setText(progress.getLevel());
        holder.level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new DetailFragmentProgress(position,mProgress);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mProgress.size();
    }
}



