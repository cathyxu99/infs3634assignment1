package com.example.infs3634assignment.UserEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
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

    @Query("UPDATE user SET lungsCDate = :date WHERE username = :username")
    void changeLungsCDate(Date date, String username);

    @Query("UPDATE user SET heartCDate = :date WHERE username = :username")
    void changeHeartCDate(Date date, String username);

    @Query("UPDATE user SET liverCDate = :date WHERE username = :username")
    void changeLiverCDate(Date date, String username);

    @Query("UPDATE user SET brainCDate = :date WHERE username = :username")
    void changeBrainCDate(Date date, String username);

    @Query("UPDATE user SET spleenCDate = :date WHERE username = :username")
    void changeSpleenCDate(Date date, String username);

    @Query("UPDATE user SET kidneyCDate = :date WHERE username = :username")
    void changeKidneyCDate(Date date, String username);

    @Query("UPDATE user SET stomachCDate = :date WHERE username = :username")
    void changeStomachCDate(Date date, String username);

    @Query("UPDATE user SET intestineCDate = :date WHERE username = :username")
    void changeIntestineCDate(Date date, String username);

    @Query("UPDATE user SET pancreasCDate = :date WHERE username = :username")
    void changePancreasCDate(Date date, String username);

    @Query("UPDATE user SET brainTrophy = :trophy WHERE username = :username")
    void changeBrainTrophy(String trophy, String username);

    @Query("UPDATE user SET lungsTrophy = :trophy WHERE username = :username")
    void changeLungsTrophy(String trophy, String username);

    @Query("UPDATE user SET heartTrophy = :trophy WHERE username = :username")
    void changeHeartTrophy(String trophy, String username);

    @Query("UPDATE user SET liverTrophy = :trophy WHERE username = :username")
    void changeLiverTrophy(String trophy, String username);

    @Query("UPDATE user SET spleenTrophy = :trophy WHERE username = :username")
    void changeSpleenTrophy(String trophy, String username);

    @Query("UPDATE user SET kidneyTrophy = :trophy WHERE username = :username")
    void changeKidneyTrophy(String trophy, String username);

    @Query("UPDATE user SET stomachTrophy = :trophy WHERE username = :username")
    void changeStomachTrophy(String trophy, String username);

    @Query("UPDATE user SET intestineTrophy = :trophy WHERE username = :username")
    void changeIntestineTrophy(String trophy, String username);

    @Query("UPDATE user SET pancreasTrophy = :trophy WHERE username = :username")
    void changePancreasTrophy(String trophy, String username);

    @Query("UPDATE user SET brainFastestTime = :time WHERE username = :username")
    void changeBrainTime(long time, String username);

    @Query("UPDATE user SET lungsFastestTime = :time WHERE username = :username")
    void changeLungsTime(long time, String username);

    @Query("UPDATE user SET heartFastestTime = :time WHERE username = :username")
    void changeHeartTime(long time, String username);

    @Query("UPDATE user SET liverFastestTime = :time WHERE username = :username")
    void changeLiverTime(long time, String username);

    @Query("UPDATE user SET spleenFastestTime = :time WHERE username = :username")
    void changeSpleenTime(long time, String username);

    @Query("UPDATE user SET kidneyFastestTime = :time WHERE username = :username")
    void changeKidneyTime(long time, String username);

    @Query("UPDATE user SET stomachFastestTime = :time WHERE username = :username")
    void changeStomachTime(long time, String username);

    @Query("UPDATE user SET intestineFastestTime = :time WHERE username = :username")
    void changeIntestineTime(long time, String username);

    @Query("UPDATE user SET pancreasFastestTime = :time WHERE username = :username")
    void changePancreasTime(long time, String username);

    @Query("SELECT brainFastestTime FROM user WHERE username = :username")
    Long getBrainFastestTime(String username);

    @Query("SELECT lungsFastestTime FROM user WHERE username = :username")
    Long getLungsFastestTime(String username);

    @Query("SELECT heartFastestTime FROM user WHERE username = :username")
    Long getHeartFastestTime(String username);

    @Query("SELECT liverFastestTime FROM user WHERE username = :username")
    Long getLiverFastestTime(String username);

    @Query("SELECT spleenFastestTime FROM user WHERE username = :username")
    Long getSpleenFastestTime(String username);

    @Query("SELECT kidneyFastestTime FROM user WHERE username = :username")
    Long getKidneyFastestTime(String username);

    @Query("SELECT stomachFastestTime FROM user WHERE username = :username")
    Long getStomachFastestTime(String username);

    @Query("SELECT intestineFastestTime FROM user WHERE username = :username")
    Long getIntestineFastestTime(String username);

    @Query("SELECT pancreasFastestTime FROM user WHERE username = :username")
    Long getPancreasFastestTime(String username);

    @Query("SELECT brainTrophy FROM user WHERE username = :username")
    String getBrainTrophy(String username);

    @Query("SELECT lungsTrophy FROM user WHERE username = :username")
    String getLungsTrophy(String username);

    @Query("SELECT heartTrophy FROM user WHERE username = :username")
    String getHeartTrophy(String username);

    @Query("SELECT liverTrophy FROM user WHERE username = :username")
    String getLiverTrophy(String username);

    @Query("SELECT spleenTrophy FROM user WHERE username = :username")
    String getSpleenTrophy(String username);

    @Query("SELECT kidneyTrophy FROM user WHERE username = :username")
    String getKidneyTrophy(String username);

    @Query("SELECT stomachTrophy FROM user WHERE username = :username")
    String getStomachTrophy(String username);

    @Query("SELECT intestineTrophy FROM user WHERE username = :username")
    String getIntestineTrophy(String username);

    @Query("SELECT pancreasTrophy FROM user WHERE username = :username")
    String getPancreasTrophy(String username);

}
