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

//adds value into array list based on the level the user is on

    public static ArrayList<ProgressData> getLevel1(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel2(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));

        return progressData;
    }

    public static ArrayList<ProgressData> getLevel3(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel4(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel5(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        progressData.add(new ProgressData("Level 5: Spleen"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel6(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        progressData.add(new ProgressData("Level 5: Spleen"));
        progressData.add(new ProgressData("Level 6: Kidney"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel7(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        progressData.add(new ProgressData("Level 5: Spleen"));
        progressData.add(new ProgressData("Level 6: Kidney"));
        progressData.add(new ProgressData("Level 7: Stomach"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel8(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        progressData.add(new ProgressData("Level 5: Spleen"));
        progressData.add(new ProgressData("Level 6: Kidney"));
        progressData.add(new ProgressData("Level 7: Stomach"));
        progressData.add(new ProgressData("Level 8: Intestine"));
        return progressData;
    }

    public static ArrayList<ProgressData> getLevel9(){
        ArrayList <ProgressData> progressData = new ArrayList<>();
        progressData.add(new ProgressData("Level 1: Brain"));
        progressData.add(new ProgressData("Level 2: Lungs"));
        progressData.add(new ProgressData("Level 3: Heart"));
        progressData.add(new ProgressData("Level 4: Liver"));
        progressData.add(new ProgressData("Level 5: Spleen"));
        progressData.add(new ProgressData("Level 6: Kidney"));
        progressData.add(new ProgressData("Level 7: Stomach"));
        progressData.add(new ProgressData("Level 8: Intestine"));
        progressData.add(new ProgressData("Level 9: Pancreas"));
        return progressData;
    }
}