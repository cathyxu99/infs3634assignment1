package com.example.infs3634assignment.ProgressPage;

import java.util.ArrayList;

public class ProgressData {
    private String level;

    public ProgressData(){
    }

    public ProgressData(String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }

    public static ArrayList<ProgressData> getProgressData(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        progressData.add(new ProgressData("Level 5"));
        progressData.add(new ProgressData("Level 6"));
        progressData.add(new ProgressData("Level 7"));
        progressData.add(new ProgressData("Level 8"));
        progressData.add(new ProgressData("Level 9"));
        progressData.add(new ProgressData("Level 10"));
        progressData.add(new ProgressData("Level 11"));

        return progressData;
    }

}