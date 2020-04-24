package com.example.infs3634assignment.Notes;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.infs3634assignment.R;
import com.example.infs3634assignment.blankHomeActivity;

import java.util.ArrayList;
import java.util.List;


public class NotesFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private RecyclerView noteList;
    private NoteAdapter nAdapter;
    private List<Note> notes = new ArrayList<>();
    private NoteDatabase noteDatabase;
    final blankHomeActivity homeActivity = (blankHomeActivity) getActivity();



    public NotesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), NoteDatabase.class, "myDB").build();

        new PopulateNotesTask().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        noteList = rootView.findViewById(R.id.noteList);
        System.out.println("Length of notes: " + notes.size());

        nAdapter = new NoteAdapter(rootView.getContext(), notes);
        System.out.println("Length of adapter: " + nAdapter.getItemCount());

        noteList.setAdapter(nAdapter);
        noteList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        //Set button
        final blankHomeActivity homeActivity = (blankHomeActivity) getActivity();


        ImageButton addNewNote = rootView.findViewById(R.id.addNote);
        addNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = homeActivity.getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = new DetailNoteFragment();
                transaction.replace(R.id.mainFragContainer,fragment);
                transaction.commit();
            }
        });

        return rootView;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public class PopulateNotesTask extends AsyncTask<Void,Integer, List<Note>> {

        @Override
        protected List<Note> doInBackground(Void... voids) {

            List<Note> notes = noteDatabase.noteDao().getNotes();
            return notes;
        }

        @Override
        protected void onPostExecute(List<Note> notes) {
            if(notes!=null){
                nAdapter.setData(notes);
                nAdapter.notifyDataSetChanged();
            }

        }
    }
}
