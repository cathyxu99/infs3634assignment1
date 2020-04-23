package com.example.infs3634assignment.UserEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase{
    public abstract UserDao userDao();
}