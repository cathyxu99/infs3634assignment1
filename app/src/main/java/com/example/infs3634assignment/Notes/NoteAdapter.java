package com.example.infs3634assignment.Notes;

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

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ListViewHolder> {
    private static final String TAG = "NoteAdapter: ";
    private List<Note> mList;
    private LayoutInflater mInflater;

    public NoteAdapter(Context context, List<Note> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @NonNull
    @Override
    public NoteAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.note_list_row, parent, false);
        return new ListViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListViewHolder holder, int position) {

        Note mCurrent = mList.get(position);
        String subject =mCurrent.getSubject();
        holder.subject.setText(subject);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<Note> notes){
        mList.clear();
        this.mList = notes;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView subject;
        final NoteAdapter mAdapter;

        public ListViewHolder(@NonNull View itemView, NoteAdapter adapter) {
            super(itemView);
            subject =itemView.findViewById(R.id.noteSubject);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "Note Selected");
            int position = getLayoutPosition();
            Note note = mList.get(position);

            FragmentManager manager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            DetailNoteFragment fragment = new DetailNoteFragment();
            Bundle arguments = new Bundle();
            arguments.putSerializable("noteInfo", note);
            fragment.setArguments(arguments);
            transaction.replace(R.id.mainFragContainer,fragment);
            transaction.commit();
        }
    }
}
