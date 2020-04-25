package com.example.infs3634assignment.UserEntity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User{
    @PrimaryKey
    @NonNull
    private String username;
    @NonNull
    private String password;
    private int displayPictureId;
    private String  brainTrophy
        , lungsTrophy
        , heartTrophy
        , liverTrophy
        , spleenTrophy
        , kidneyTrophy
        , stomachTrophy
        , intestineTrophy
        , pancreasTrophy;
    @TypeConverters(Converters.class)
    private java.util.Date brainCDate , lungsCDate
            ,heartCDate
            ,liverCDate
            ,spleenCDate
            ,kidneyCDate
            ,stomachCDate
            ,intestineCDate
            ,pancreasCDate;

    private long brainFastestTime
            , lungsFastestTime
            , heartFastestTime
            , liverFastestTime
            , spleenFastestTime
            ,  kidneyFastestTime
            , stomachFastestTime
            , intestineFastestTime
            , pancreasFastestTime;
/*
    private int brainStreak
            , lungsStreak
            , heartStreak
            , liverStreak
            , spleenStreak
            ,  kidneyStreak
            , stomachStreak
            , intestineStreak
            , pancreasStreak;
*/

    public User(String username, String password, int displayPictureId) {
        this.username = username;
        this.password = password;
        this.displayPictureId = displayPictureId;
    }
    @Ignore
    public User(@NonNull String username, @NonNull String password, int displayPictureId, String brainTrophy, String lungsTrophy, String heartTrophy, String liverTrophy, String spleenTrophy, String kidneyTrophy, String stomachTrophy, String intestineTrophy, String pancreasTrophy, Date brainCDate, Date lungsCDate, Date heartCDate, Date liverCDate, Date spleenCDate, Date kidneyCDate, Date stomachCDate, Date intestineCDate, Date pancreasCDate, long brainFastestTime, long lungsFastestTime, long heartFastestTime, long liverFastestTime, long spleenFastestTime, long kidneyFastestTime, long stomachFastestTime, long intestineFastestTime, long pancreasFastestTime) {
        this.username = username;
        this.password = password;
        this.displayPictureId = displayPictureId;
        this.brainTrophy = brainTrophy;
        this.lungsTrophy = lungsTrophy;
        this.heartTrophy = heartTrophy;
        this.liverTrophy = liverTrophy;
        this.spleenTrophy = spleenTrophy;
        this.kidneyTrophy = kidneyTrophy;
        this.stomachTrophy = stomachTrophy;
        this.intestineTrophy = intestineTrophy;
        this.pancreasTrophy = pancreasTrophy;
        this.brainCDate = brainCDate;
        this.lungsCDate = lungsCDate;
        this.heartCDate = heartCDate;
        this.liverCDate = liverCDate;
        this.spleenCDate = spleenCDate;
        this.kidneyCDate = kidneyCDate;
        this.stomachCDate = stomachCDate;
        this.intestineCDate = intestineCDate;
        this.pancreasCDate = pancreasCDate;
        this.brainFastestTime = brainFastestTime;
        this.lungsFastestTime = lungsFastestTime;
        this.heartFastestTime = heartFastestTime;
        this.liverFastestTime = liverFastestTime;
        this.spleenFastestTime = spleenFastestTime;
        this.kidneyFastestTime = kidneyFastestTime;
        this.stomachFastestTime = stomachFastestTime;
        this.intestineFastestTime = intestineFastestTime;
        this.pancreasFastestTime = pancreasFastestTime;
    }
    @Ignore
    public User(@NonNull String username, @NonNull String password, int displayPictureId, String brainTrophy, String lungsTrophy, String heartTrophy) {
        this.username = username;
        this.password = password;
        this.displayPictureId = displayPictureId;
        this.brainTrophy = brainTrophy;
        this.lungsTrophy = lungsTrophy;
        this.heartTrophy = heartTrophy;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int getDisplayPictureId() {
        return displayPictureId;
    }

    public void setDisplayPictureId(int displayPictureId) {
        this.displayPictureId = displayPictureId;
    }

    public String getBrainTrophy() {
        return brainTrophy;
    }

    public void setBrainTrophy(String brainTrophy) {
        this.brainTrophy = brainTrophy;
    }

    public String getLungsTrophy() {
        return lungsTrophy;
    }

    public void setLungsTrophy(String lungsTrophy) {
        this.lungsTrophy = lungsTrophy;
    }

    public String getHeartTrophy() {
        return heartTrophy;
    }

    public void setHeartTrophy(String heartTrophy) {
        this.heartTrophy = heartTrophy;
    }

    public String getLiverTrophy() {
        return liverTrophy;
    }

    public void setLiverTrophy(String liverTrophy) {
        this.liverTrophy = liverTrophy;
    }

    public String getSpleenTrophy() {
        return spleenTrophy;
    }

    public void setSpleenTrophy(String spleenTrophy) {
        this.spleenTrophy = spleenTrophy;
    }

    public String getKidneyTrophy() {
        return kidneyTrophy;
    }

    public void setKidneyTrophy(String kidneyTrophy) {
        this.kidneyTrophy = kidneyTrophy;
    }

    public String getStomachTrophy() {
        return stomachTrophy;
    }

    public void setStomachTrophy(String stomachTrophy) {
        this.stomachTrophy = stomachTrophy;
    }

    public String getIntestineTrophy() {
        return intestineTrophy;
    }

    public void setIntestineTrophy(String intestineTrophy) {
        this.intestineTrophy = intestineTrophy;
    }

    public String getPancreasTrophy() {
        return pancreasTrophy;
    }

    public void setPancreasTrophy(String pancreasTrophy) {
        this.pancreasTrophy = pancreasTrophy;
    }

    public Date getBrainCDate() {
        return brainCDate;
    }

    public void setBrainCDate(Date brainCDate) {
        this.brainCDate = brainCDate;
    }

    public Date getLungsCDate() {
        return lungsCDate;
    }

    public void setLungsCDate(Date lungsCDate) {
        this.lungsCDate = lungsCDate;
    }

    public Date getHeartCDate() {
        return heartCDate;
    }

    public void setHeartCDate(Date heartCDate) {
        this.heartCDate = heartCDate;
    }

    public Date getLiverCDate() {
        return liverCDate;
    }

    public void setLiverCDate(Date liverCDate) {
        this.liverCDate = liverCDate;
    }

    public Date getSpleenCDate() {
        return spleenCDate;
    }

    public void setSpleenCDate(Date spleenCDate) {
        this.spleenCDate = spleenCDate;
    }

    public Date getKidneyCDate() {
        return kidneyCDate;
    }

    public void setKidneyCDate(Date kidneyCDate) {
        this.kidneyCDate = kidneyCDate;
    }

    public Date getStomachCDate() {
        return stomachCDate;
    }

    public void setStomachCDate(Date stomachCDate) {
        this.stomachCDate = stomachCDate;
    }

    public Date getIntestineCDate() {
        return intestineCDate;
    }

    public void setIntestineCDate(Date intestineCDate) {
        this.intestineCDate = intestineCDate;
    }

    public Date getPancreasCDate() {
        return pancreasCDate;
    }

    public void setPancreasCDate(Date pancreasCDate) {
        this.pancreasCDate = pancreasCDate;
    }

    public long getBrainFastestTime() {
        return brainFastestTime;
    }

    public void setBrainFastestTime(long brainFastestTime) {
        this.brainFastestTime = brainFastestTime;
    }

    public long getLungsFastestTime() {
        return lungsFastestTime;
    }

    public void setLungsFastestTime(long lungsFastestTime) {
        this.lungsFastestTime = lungsFastestTime;
    }

    public long getHeartFastestTime() {
        return heartFastestTime;
    }

    public void setHeartFastestTime(long heartFastestTime) {
        this.heartFastestTime = heartFastestTime;
    }

    public long getLiverFastestTime() {
        return liverFastestTime;
    }

    public void setLiverFastestTime(long liverFastestTime) {
        this.liverFastestTime = liverFastestTime;
    }

    public long getSpleenFastestTime() {
        return spleenFastestTime;
    }

    public void setSpleenFastestTime(long spleenFastestTime) {
        this.spleenFastestTime = spleenFastestTime;
    }

    public long getKidneyFastestTime() {
        return kidneyFastestTime;
    }

    public void setKidneyFastestTime(long kidneyFastestTime) {
        this.kidneyFastestTime = kidneyFastestTime;
    }

    public long getStomachFastestTime() {
        return stomachFastestTime;
    }

    public void setStomachFastestTime(long stomachFastestTime) {
        this.stomachFastestTime = stomachFastestTime;
    }

    public long getIntestineFastestTime() {
        return intestineFastestTime;
    }

    public void setIntestineFastestTime(long intestineFastestTime) {
        this.intestineFastestTime = intestineFastestTime;
    }

    public long getPancreasFastestTime() {
        return pancreasFastestTime;
    }

    public void setPancreasFastestTime(long pancreasFastestTime) {
        this.pancreasFastestTime = pancreasFastestTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DisplayPictureId=" + displayPictureId +
                '}';
    }
}
