package com.example.infs3634assignment.Learn;

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
import com.example.infs3634assignment.R;

import java.util.ArrayList;

public class OrganImageAdapter extends RecyclerView.Adapter<OrganImageAdapter.ViewHolder> {

    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private Context mContext;


    public OrganImageAdapter(Context context, ArrayList<String> imageURLs, ArrayList<String> imageNames) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext).asBitmap().load(mImageURLs.get(position)).into(holder.organImage);

        holder.organImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(mContext, "That is " + mImageNames.get(position), Toast.LENGTH_SHORT).show();
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
            organImage = itemView.findViewById(R.id.dp);
        }
    }

}
