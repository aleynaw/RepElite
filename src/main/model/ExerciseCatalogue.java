package model;

import java.util.*;

import static model.Category.*;
import static ui.TrackerApp.printList;


//Exercise Catalogue creates an array list of exercises with pre-set exercises and sorts it
public class ExerciseCatalogue {
    private static ExerciseCatalogue catalogue;


    private ArrayList<Exercise> exercises;
    private static ArrayList<Exercise> exercisesGiven;
    private static ArrayList<Exercise> sortedExercises;


    //EFFECT: constructs an exercise catalogue
    public ExerciseCatalogue() {
        exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Barbell Squat", Quads));
        exercises.add(new Exercise("DeadLift", Glutes));
        exercises.add(new Exercise("Seated Rows", Back));
        exercises.add(new Exercise("Shoulder Press", Shoulders));
    }

    //REQUIRES: non-empty catalogue
    //MODIFIES: this
    //EFFECTS: sorts given list by muscle category and prints it for user
    public static void sortList(ExerciseCatalogue catalogue) {

        Comparator<Exercise> compareByCategory = Comparator
                .comparing(Exercise::getCategoryName);

        catalogue.exercises.sort(compareByCategory);

        sortedExercises = catalogue.exercises;

        printList(sortedExercises);


    }


    //getters
    public ArrayList<Exercise> getUnsortedExerciseList() {
        return exercises;
    }

    public ArrayList<Exercise> getSortedList() {
        return sortedExercises;
    }


}
