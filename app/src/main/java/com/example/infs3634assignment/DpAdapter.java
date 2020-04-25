package com.example.infs3634assignment;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.infs3634assignment.UserEntity.User;
import com.example.infs3634assignment.UserEntity.UserDb;

import java.util.ArrayList;

public class DpAdapter extends RecyclerView.Adapter<DpAdapter.ViewHolder> {
    public ArrayList<Integer> imageDps = new ArrayList<Integer>();
    public ImageView currentDp;
    public int confirmedDp;
    public User currentUser;
    public UserDb userDb;
    public String loggedInUser;

    public DpAdapter(ImageView currentDp, int confirmedDp, String loggedInUser){
        this.currentDp = currentDp;
        this.confirmedDp = confirmedDp;
        this.loggedInUser =  loggedInUser;
        this.imageDps.add(R.drawable.avatarbloodcellsmall);
        this.imageDps.add(R.drawable.avatareyeballsmall);
        this.imageDps.add(R.drawable.avatarpersonsmall);
        this.imageDps.add(R.drawable.avatarskullsmall);
    }

    public DpAdapter(ImageView currentDp, int confirmedDp){
        this.currentDp = currentDp;
        this.confirmedDp = confirmedDp;
        this.imageDps.add(R.drawable.avatarbloodcellsmall);
        this.imageDps.add(R.drawable.avatareyeballsmall);
        this.imageDps.add(R.drawable.avatarpersonsmall);
        this.imageDps.add(R.drawable.avatarskullsmall);
    }

    public void addAvatar(int avatar){
        this.imageDps.add(avatar);
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
