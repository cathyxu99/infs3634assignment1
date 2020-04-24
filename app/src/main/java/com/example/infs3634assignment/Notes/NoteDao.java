package com.example.infs3634assignment.Notes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface NoteDao {
    @Insert
    void insertNotes(Note...notes);

    @Query("SELECT * FROM note")
    List<Note> getNotes();

}
