package model;

import java.util.ArrayList;

public class Exercise {

    private String name;
    private String category;
    private int workingWeight;
    private int personalRecord;


    //EFFECTS: constructs an exercise with given WW and PR
    public Exercise(String name, int workingWeight, int personalRecord) {
        this.name = name;
        this.workingWeight = workingWeight;
        this.personalRecord = personalRecord;

    }

    public Exercise(String name) {
        this.name = name;
    }

//    public void addToCatalogue(Exercise exercise) {
//        ArrayList<Exercise> exerciseCatalogue = new ArrayList<Exercise>();
//        Exercise exercise1 = new Exercise(name, workingWeight, personalRecord);
//
//        exerciseCatalogue.add(exercise1);
//    }

    public String getExerciseName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getWorkingWeight() {
        return workingWeight;
    }

    public int getPersonalRecord() {
        return personalRecord;
    }
}
