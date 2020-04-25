package com.example.infs3634assignment.UserEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from User")
    List<User> getUsers();

    @Insert
    void insertUsers(User...users);

    @Insert
    void insertNewUser(User user);

    @Query("SELECT * FROM User WHERE username = :username")
    User searchUser (String username);

    @Query("UPDATE User SET password = :password WHERE username = :username")
    void changePassword(String password, String username);

    @Query("UPDATE User SET displayPictureId = :displayPictureId WHERE username = :username")
    void changeDp(int displayPictureId, String username);

}
