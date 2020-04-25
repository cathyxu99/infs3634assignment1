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

    public static class ProgressViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView level;
        public RecyclerViewClickListener mListener;

        public ProgressViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            level = v.findViewById(R.id.level);
            Log.d(TAG, "progress View Holder: success");


        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
            Log.d(TAG, "progress View Holder: inOnClick");
            System.out.println(getAdapterPosition());
            /*
            int position = getLayoutPosition();
            ProgressData progress = mProgress.get(position);

            FragmentManager manager = ((FragmentActivity) view.getContext()).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            DetailFragmentProgress fragment = new DetailFragmentProgress();
            Bundle arguments = new Bundle();
            arguments.putSerializable("progressInfo", (Serializable) progress);
            fragment.setArguments(arguments);
            transaction.replace(R.id.mainFragContainer,fragment);
            transaction.commit();

             */
        }
    }

    //initialises the viewholder to display the contents
    @Override
    public ProgressAdapter.ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_list_row,parent,false);
        return new ProgressViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder (ProgressViewHolder holder, int position){
        ProgressData progress = mProgress.get(position);
        holder.level.setText(progress.getLevel());


    }

    @Override
    public int getItemCount(){
        return mProgress.size();
    }
}



