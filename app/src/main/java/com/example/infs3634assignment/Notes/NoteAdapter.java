package com.example.infs3634assignment.Notes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
            //Intent intent = new Intent(v.getContext(), DetailActivity.class);
            //intent.putExtra("pos", position);
           // v.getContext().startActivity(intent);
        }
    }
}
