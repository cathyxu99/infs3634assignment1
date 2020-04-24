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

    @Query("SELECT * FROM note WHERE userName = :username")
    List<Note> getUserNotes(String username);

    @Query("UPDATE note SET subject = :subject, note = :content WHERE noteID = :id")
    void updateNote(int id, String subject, String content);

}
