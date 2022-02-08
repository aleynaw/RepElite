package model;

import java.util.ArrayList;
import java.util.List;


public class Profile {

    private String name;
    private String skillLevel;
    private int age;
    private int workingWeight;
    private int personalRecord;
    private List<Exercise> favourites;

    //EFFECTS: constructs a profile with given name, empty favourites set
    public Profile(String name, int age, String skillLevel) {
        this.name = name;
        this.age = age;
        this.skillLevel = skillLevel;
        favourites = new ArrayList<>();
    }

    //REQUIRES: valid profile
    //EFFECTS: prints out profile data
    public static void viewProfile(Profile profile) {
        System.out.println("Your Profile:");
        System.out.println("Name: " + profile.name);
        System.out.println("Age: " + profile.age);
        System.out.println("Skill Level: " + profile.skillLevel);
        System.out.println("Favourites: " + profile.favourites);
        System.out.println(" ");
        System.out.println(" ");

    }

    //REQUIRES: valid exercise
    //MODIFIES: this
    //EFFECTS: adds exercise with given WW and PR to favourites set
    public void addExerciseToFavourite(Exercise exercise, int workingWeight, int personalRecord) {
        //stub
    }
}
