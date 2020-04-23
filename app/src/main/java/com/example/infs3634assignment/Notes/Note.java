package com.example.infs3634assignment.Notes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.infs3634assignment.UserEntity.User;

@Entity
public class Note {

    @ForeignKey(entity = User.class,
            parentColumns = "userName",
            childColumns = "userName", onDelete = ForeignKey.CASCADE)
    @NonNull
    private String userName;
    @PrimaryKey
    @NonNull
    private int noteId;
    @NonNull
    private String subject;
    @NonNull
    private String note;

    public Note(String userName, int noteId, String subject, String note) {
        this.userName = userName;
        this.noteId = noteId;
        this.subject = subject;
        this.note = note;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
