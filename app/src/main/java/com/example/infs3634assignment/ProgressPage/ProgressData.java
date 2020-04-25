package com.example.infs3634assignment.ProgressPage;

import java.util.ArrayList;
import java.util.HashMap;

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
/*
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

 */
//adds value into array list based on the level the user is on
    public static ArrayList<ProgressData> getLevel1(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel2(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));

        return progressData;
    }

    public static ArrayList<ProgressData> getLevel3(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel4(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel5(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        progressData.add(new ProgressData("Level 5"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel6(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        progressData.add(new ProgressData("Level 5"));
        progressData.add(new ProgressData("Level 6"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel7(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        progressData.add(new ProgressData("Level 5"));
        progressData.add(new ProgressData("Level 6"));
        progressData.add(new ProgressData("Level 7"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel8(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1"));
        progressData.add(new ProgressData("Level 2"));
        progressData.add(new ProgressData("Level 3"));
        progressData.add(new ProgressData("Level 4"));
        progressData.add(new ProgressData("Level 5"));
        progressData.add(new ProgressData("Level 6"));
        progressData.add(new ProgressData("Level 7"));
        progressData.add(new ProgressData("Level 8"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel9(){
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
        return progressData;
    }
}