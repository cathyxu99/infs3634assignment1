package com.example.infs3634assignment.Notes;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.infs3634assignment.R;
import com.example.infs3634assignment.blankHomeActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;


public class DetailNoteFragment extends Fragment {

    int noteId = 0;
    String userName = null;
    String noteSubject = null;
    String noteText = null;
    private NoteDatabase noteDatabase;
    final blankHomeActivity homeActivity = (blankHomeActivity) getActivity();

    public DetailNoteFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteDatabase = Room.databaseBuilder(getActivity().getApplicationContext(), NoteDatabase.class, "myDB").build();

        Bundle extras = getArguments();
        if(extras!=null){
            Note note = (Note) extras.getSerializable("noteInfo");
            noteId = note.getNoteId();
            userName = note.getUserName();
            noteSubject = note.getSubject();
            noteText =note.getNote();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_detail_note, container, false);

        final EditText noteContent = rootView.findViewById(R.id.noteText);
        final TextInputEditText noteSubjectView = rootView.findViewById(R.id.noteSubject);

        if(noteSubject!=null) {
            noteContent.setText(noteText);
            noteSubjectView.setText(noteSubject);
        }

        ImageButton saveNote = rootView.findViewById(R.id.saveNote);
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(noteSubjectView.getText().toString().matches("")){
                    Toast.makeText(rootView.getContext(), "Please fill in Subject!", Toast.LENGTH_SHORT).show();

                }else{

                    noteSubject = noteSubjectView.getText().toString();
                    noteText = noteContent.getText().toString();

                    new SaveNoteTask().execute();

                }

            }
        });

        return rootView;
    }

public class SaveNoteTask extends AsyncTask<Void,Integer, Integer>{

        Note noteToAdd;

    @Override
    protected Integer doInBackground(Void... voids) {

        if(userName==null){
            userName = "testUser";
            System.out.println("Check username 1" + userName);
        }

    if(noteId==0) {
        System.out.println("Check username 2" + userName);

        noteToAdd = new Note(userName,noteSubject,noteText);

        noteDatabase.noteDao().insertNotes(noteToAdd);
    }

    if(noteId!=0){

        noteToAdd = new Note(userName, noteSubject, noteText);


    }

        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Toast.makeText(getActivity(), "Note has been added!", Toast.LENGTH_SHORT).show();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new NotesFragment();
        transaction.replace(R.id.mainFragContainer,fragment);
        transaction.commit();
    }
}


}
