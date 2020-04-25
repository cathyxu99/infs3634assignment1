package com.example.infs3634assignment.UserEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class UserDb extends RoomDatabase{
    public abstract UserDao userDao();
}
