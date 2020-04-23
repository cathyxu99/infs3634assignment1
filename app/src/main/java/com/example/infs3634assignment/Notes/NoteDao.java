package com.example.infs3634assignment.Notes;

import androidx.room.Dao;
import androidx.room.Insert;


@Dao
public interface NoteDao {
    @Insert
    void insertNotes(Note...notes);

}
