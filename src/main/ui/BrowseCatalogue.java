package ui;

import model.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BrowseCatalogue {
    //REQUIRES:
    //MODIFIES:
    //EFFECTS: sorts given list by muscle category and prints it for user
    public static void sortList(String[] args) {

        ArrayList<Exercise> exercises = getUnsortedExerciseList();

        Comparator<Exercise> compareByCategory = Comparator
                .comparing(Exercise::getCategory);

        Collections.sort(exercises, compareByCategory);

        System.out.println(exercises);


    }

    private static ArrayList<Exercise> getUnsortedExerciseList() {
        //stub
        return null;
    }
}
