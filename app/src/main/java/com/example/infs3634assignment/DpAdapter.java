package com.example.infs3634assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DpAdapter extends RecyclerView.Adapter<DpAdapter.ViewHolder> {
    public ArrayList<Integer> imageDps;

    public DpAdapter(ArrayList<Integer> imageDps){
        this.imageDps = imageDps;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dp_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set onclick method
        holder.dp.setImageResource(R.drawable.bladder);
    }

    @Override
    public int getItemCount() {
        return imageDps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView dp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dp =  itemView.findViewById(R.id.dp);
        }
    }
}
