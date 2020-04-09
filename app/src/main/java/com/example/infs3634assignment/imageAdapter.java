package com.example.infs3634assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder> {

    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private Context mContext;


    public imageAdapter(Context context,ArrayList<String> imageURLs,ArrayList<String> imageNames) {
        mImageURLs = imageURLs;
        mImageNames = imageNames;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(mImageURLs.get(position)).into(holder.organImage);
        holder.imageName.setText(mImageNames.get(position));

        holder.organImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageURLs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView organImage;
        TextView imageName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            organImage = itemView.findViewById(R.id.organImage);
            imageName = itemView.findViewById(R.id.imageName);
        }
    }

}
