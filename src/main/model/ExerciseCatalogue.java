package model;

import java.util.*;

import static ui.TrackerApp.printList;

public class ExerciseCatalogue {
    private static ExerciseCatalogue catalogue;


    private ArrayList<Exercise> exercises;
    private static ArrayList<Exercise> exercisesGiven;
    private static ArrayList<Exercise> sortedExercises;


    //EFFECT: constructs an exercise catalogue
    public ExerciseCatalogue() {
        exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Barbell Squat", "Quads"));
        exercises.add(new Exercise("DeadLift", "Glutes"));
        exercises.add(new Exercise("Seated Rows", "Back"));
        exercises.add(new Exercise("Shoulder Press", "Shoulders"));
    }

    //REQUIRES:
    //MODIFIES:
    //EFFECTS: sorts given list by muscle category and prints it for user
    public static void sortList(ExerciseCatalogue catalogue) {

        Comparator<Exercise> compareByCategory = Comparator
                .comparing(Exercise::getCategory);

        catalogue.exercises.sort(compareByCategory);

        sortedExercises = catalogue.exercises;

        printList(sortedExercises);


    }


    public ArrayList<Exercise> getUnsortedExerciseList() {
        return exercises;
    }

    public ArrayList<Exercise> getSortedList() {
        return sortedExercises;
    }


}
