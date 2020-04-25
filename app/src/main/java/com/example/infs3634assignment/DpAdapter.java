package com.example.infs3634assignment;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DpAdapter extends RecyclerView.Adapter<DpAdapter.ViewHolder> {
    public ArrayList<Integer> imageDps = new ArrayList<Integer>();
    public ImageView currentDp;
    public int confirmedDp;

    public DpAdapter(ImageView currentDp,int confirmedDp){
        this.imageDps.add(R.drawable.avatarbloodcellsmall);
        this.imageDps.add(R.drawable.avatareyeballsmall);
        this.imageDps.add(R.drawable.avatarpersonsmall);
        this.imageDps.add(R.drawable.avatarskullsmall);
        this.currentDp = currentDp;
        this.confirmedDp = confirmedDp;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dp_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //set onclick method
        holder.dp.setImageResource(imageDps.get(position));
        holder.dp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                currentDp.setImageResource(imageDps.get(position));
                currentDp.setTag(imageDps.get(position));
            }
        });
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
