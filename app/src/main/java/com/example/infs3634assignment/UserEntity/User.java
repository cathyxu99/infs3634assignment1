package com.example.infs3634assignment.UserEntity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User{
    @PrimaryKey
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private int progress,displayPictureId;

    public User(@NonNull String userName, String password,int progress, int displayPictureId) {
        this.userName = userName;
        this.password = password;
        this.progress = progress;
        this.displayPictureId = displayPictureId;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getDisplayPictureId() {
        return displayPictureId;
    }

    public void setDisplayPictureId(int displayPictureId) {
        displayPictureId = displayPictureId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", progress=" + progress +
                ", DisplayPictureId=" + displayPictureId +
                '}';
    }
}
