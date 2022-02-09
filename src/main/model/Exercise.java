package model;


public class Exercise {

    private String name;
    private String category;
    private int workingWeight;
    private int personalRecord;


    //EFFECTS: constructs an exercise with given WW and PR
    public Exercise(String name, String category, int workingWeight, int personalRecord) {
        this.name = name;
        this.category = category;
        this.workingWeight = workingWeight;
        this.personalRecord = personalRecord;

    }

    //EFFECTS: constructs an exercise with just name and category (no saved WW or PR)
    public Exercise(String name, String category) {
        this.name = name;
        this.category = category;
    }

//    public void addToCatalogue(Exercise exercise) {
//        ArrayList<Exercise> exerciseCatalogue = new ArrayList<Exercise>();
//        Exercise exercise1 = new Exercise(name, workingWeight, personalRecord);
//
//        exerciseCatalogue.add(exercise1);
//    }

    //getters

    public String getExerciseName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

//    public int getWorkingWeight() {
//        return workingWeight;
//    }

//    public int getPersonalRecord() {
//        return personalRecord;
//    }
}