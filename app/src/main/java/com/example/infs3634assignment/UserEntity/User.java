package com.example.infs3634assignment.UserEntity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity
public class User{
    @PrimaryKey
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private int progress,displayPictureId;
    @TypeConverters(Converters.class)
    private java.util.Date brainCDate, brainStreak, brainFastestTime
            ,lungsCDate, lungsStreak , lungsFastestTime
            ,heartCDate, heartStreak, heartFastestTime
            ,liverCDate, liverStreak, liverFastestTime
            ,spleenCDate, spleenStreak, spleenFastestTime
            ,kidneyCDate, kidneyStreak, kidneyFastestTime
            ,stomachCDate, stomachStreak, stomachFastestTime
            ,intestineCDate, intestineStreak, intestineFastestTime
            ,pancreasCDate, pancreasStreak, pancreasFastestTime;

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

    public Date getBrainCDate() {
        return brainCDate;
    }

    public void setBrainCDate(Date brainCDate) {
        this.brainCDate = brainCDate;
    }

    public Date getBrainStreak() {
        return brainStreak;
    }

    public void setBrainStreak(Date brainStreak) {
        this.brainStreak = brainStreak;
    }

    public Date getBrainFastestTime() {
        return brainFastestTime;
    }

    public void setBrainFastestTime(Date brainFastestTime) {
        this.brainFastestTime = brainFastestTime;
    }

    public Date getLungsCDate() {
        return lungsCDate;
    }

    public void setLungsCDate(Date lungsCDate) {
        this.lungsCDate = lungsCDate;
    }

    public Date getLungsStreak() {
        return lungsStreak;
    }

    public void setLungsStreak(Date lungsStreak) {
        this.lungsStreak = lungsStreak;
    }

    public Date getLungsFastestTime() {
        return lungsFastestTime;
    }

    public void setLungsFastestTime(Date lungsFastestTime) {
        this.lungsFastestTime = lungsFastestTime;
    }

    public Date getHeartCDate() {
        return heartCDate;
    }

    public void setHeartCDate(Date heartCDate) {
        this.heartCDate = heartCDate;
    }

    public Date getHeartStreak() {
        return heartStreak;
    }

    public void setHeartStreak(Date heartStreak) {
        this.heartStreak = heartStreak;
    }

    public Date getHeartFastestTime() {
        return heartFastestTime;
    }

    public void setHeartFastestTime(Date heartFastestTime) {
        this.heartFastestTime = heartFastestTime;
    }

    public Date getLiverCDate() {
        return liverCDate;
    }

    public void setLiverCDate(Date liverCDate) {
        this.liverCDate = liverCDate;
    }

    public Date getLiverStreak() {
        return liverStreak;
    }

    public void setLiverStreak(Date liverStreak) {
        this.liverStreak = liverStreak;
    }

    public Date getLiverFastestTime() {
        return liverFastestTime;
    }

    public void setLiverFastestTime(Date liverFastestTime) {
        this.liverFastestTime = liverFastestTime;
    }

    public Date getSpleenCDate() {
        return spleenCDate;
    }

    public void setSpleenCDate(Date spleenCDate) {
        this.spleenCDate = spleenCDate;
    }

    public Date getSpleenStreak() {
        return spleenStreak;
    }

    public void setSpleenStreak(Date spleenStreak) {
        this.spleenStreak = spleenStreak;
    }

    public Date getSpleenFastestTime() {
        return spleenFastestTime;
    }

    public void setSpleenFastestTime(Date spleenFastestTime) {
        this.spleenFastestTime = spleenFastestTime;
    }

    public Date getKidneyCDate() {
        return kidneyCDate;
    }

    public void setKidneyCDate(Date kidneyCDate) {
        this.kidneyCDate = kidneyCDate;
    }

    public Date getKidneyStreak() {
        return kidneyStreak;
    }

    public void setKidneyStreak(Date kidneyStreak) {
        this.kidneyStreak = kidneyStreak;
    }

    public Date getKidneyFastestTime() {
        return kidneyFastestTime;
    }

    public void setKidneyFastestTime(Date kidneyFastestTime) {
        this.kidneyFastestTime = kidneyFastestTime;
    }

    public Date getStomachCDate() {
        return stomachCDate;
    }

    public void setStomachCDate(Date stomachCDate) {
        this.stomachCDate = stomachCDate;
    }

    public Date getStomachStreak() {
        return stomachStreak;
    }

    public void setStomachStreak(Date stomachStreak) {
        this.stomachStreak = stomachStreak;
    }

    public Date getStomachFastestTime() {
        return stomachFastestTime;
    }

    public void setStomachFastestTime(Date stomachFastestTime) {
        this.stomachFastestTime = stomachFastestTime;
    }

    public Date getIntestineCDate() {
        return intestineCDate;
    }

    public void setIntestineCDate(Date intestineCDate) {
        this.intestineCDate = intestineCDate;
    }

    public Date getIntestineStreak() {
        return intestineStreak;
    }

    public void setIntestineStreak(Date intestineStreak) {
        this.intestineStreak = intestineStreak;
    }

    public Date getIntestineFastestTime() {
        return intestineFastestTime;
    }

    public void setIntestineFastestTime(Date intestineFastestTime) {
        this.intestineFastestTime = intestineFastestTime;
    }

    public Date getPancreasCDate() {
        return pancreasCDate;
    }

    public void setPancreasCDate(Date pancreasCDate) {
        this.pancreasCDate = pancreasCDate;
    }

    public Date getPancreasStreak() {
        return pancreasStreak;
    }

    public void setPancreasStreak(Date pancreasStreak) {
        this.pancreasStreak = pancreasStreak;
    }

    public Date getPancreasFastestTime() {
        return pancreasFastestTime;
    }

    public void setPancreasFastestTime(Date pancreasFastestTime) {
        this.pancreasFastestTime = pancreasFastestTime;
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
