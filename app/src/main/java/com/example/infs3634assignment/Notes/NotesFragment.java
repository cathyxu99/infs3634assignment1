package com.example.infs3634assignment.Notes;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.infs3634assignment.R;
import com.example.infs3634assignment.BlankHomeActivity;

import java.util.ArrayList;
import java.util.List;


public class NotesFragment extends Fragment {

    BlankHomeActivity homeActivity;


    String userName;
    private RecyclerView noteList;
    private NoteAdapter nAdapter;
    private List<Note> notes = new ArrayList<>();
    private NoteDatabase noteDatabase;




    public NotesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeActivity = (BlankHomeActivity) getActivity();

        userName = homeActivity.loggedInUser;

        noteDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), NoteDatabase.class, "myDB").build();

        new PopulateNotesTask().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);

        //Steps to set up the recycler view with the adapter
        noteList = rootView.findViewById(R.id.noteList);
        System.out.println("Length of notes: " + notes.size());

        nAdapter = new NoteAdapter(rootView.getContext(), notes);
        System.out.println("Length of adapter: " + nAdapter.getItemCount());

        noteList.setAdapter(nAdapter);
        noteList.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        //Add swipe to delete functionality
        ItemTouchHelper.SimpleCallback removeNoteFromList = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView rV, RecyclerView.ViewHolder vH, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder vH, int swipeDirection) {
                final int position = vH.getAdapterPosition();
                new DeleteNoteTask().execute(position);
            }
        };

        //Initialize the ItemTouchHelper and attach recycler view
        ItemTouchHelper touchHelper = new ItemTouchHelper(removeNoteFromList);
        touchHelper.attachToRecyclerView(noteList);


        //Set add new note button
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

    //Task to add notes to the List
    public class PopulateNotesTask extends AsyncTask<Void,Integer, List<Note>> {

        @Override
        protected List<Note> doInBackground(Void... voids) {

            if(userName==null){
                userName = "testUser";
                System.out.println("Check username 1" + userName);
            }

            List<Note> notes = noteDatabase.noteDao().getUserNotes(userName);
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

    //Delete the note from the database
    public class DeleteNoteTask extends AsyncTask<Integer,Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer...integers) {

            Note note = nAdapter.getAndRemoveNote(integers[0]);
            noteDatabase.noteDao().deleteNote(note.getNoteId());
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {

            nAdapter.notifyDataSetChanged();

        }
    }
}


