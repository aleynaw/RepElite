package model;

import java.util.*;

import static ui.TrackerApp.printList;

public class ExerciseCatalogue {
    private static ExerciseCatalogue catalogue;


    private static ArrayList<Exercise> exercises;


    public ExerciseCatalogue() {
        exercises = new ArrayList<>();
        exercises.add(new Exercise("Barbell Squat", "Quads"));
        exercises.add(new Exercise("DeadLift", "Glutes"));
        exercises.add(new Exercise("Seated Rows", "Back"));
        exercises.add(new Exercise("Shoulder Press", "Shoulders"));
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: sorts given list by muscle category and prints it for user
    public static void sortList() {
        catalogue = new ExerciseCatalogue();

        exercises = getUnsortedExerciseList();

        Comparator<Exercise> compareByCategory = Comparator
                .comparing(Exercise::getCategory);

        Collections.sort(exercises, compareByCategory);

        printList(exercises);


    }


    public static ArrayList<Exercise> getUnsortedExerciseList() {
        return exercises;
    }


}
