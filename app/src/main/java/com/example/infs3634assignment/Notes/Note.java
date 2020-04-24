package com.example.infs3634assignment.Notes;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.infs3634assignment.UserEntity.User;

import java.io.Serializable;

@Entity
public class Note implements Serializable {

    @ForeignKey(entity = User.class,
            parentColumns = "userName",
            childColumns = "userName", onDelete = ForeignKey.CASCADE)
    @NonNull
    private String userName;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int noteId;
    @NonNull
    private String subject;
    private String note;

    public Note(@NonNull String userName, @NonNull String subject, String note) {
        this.userName = userName;
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
