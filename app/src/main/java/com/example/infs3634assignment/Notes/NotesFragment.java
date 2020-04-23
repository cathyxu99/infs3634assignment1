package com.example.infs3634assignment.Notes;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3634assignment.R;

import java.util.ArrayList;
import java.util.List;

//UNEDITED BLANK NOTES FRAGMENT:


public class NotesFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    private RecyclerView noteList;
    private NoteAdapter nAdapter;
    private List<Note> notes = new ArrayList<>();

    public NotesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notes.add(new Note("harryPotter", 1,"My first subject", "My first note"));
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

        return rootView;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
