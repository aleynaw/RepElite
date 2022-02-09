package ui;

import model.Exercise;
import model.ExerciseCatalogue;
import model.Profile;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class TrackerApp {
    private static Profile prof;
    private static String name;
    private static String skillLevel;
    private static int age;
    private static ArrayList<Exercise> favourites;



    public TrackerApp() {
        menu();
    }


    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("What would you like to do?");
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void menu() {
        String[] options = {"1 - Create a Profile",
                "2 - Browse Exercises",
                "3 - Plan a Workout",
                "4 - Exit"};
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        createProfile();
                        break;
                    case 2:
                        browseExercises();
                        break;
                    case 3:
                        planWorkout();
                        break;
                    case 4:
                        exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next(); //not working
            }
        }
    }


    public static void createProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        name = scanner.nextLine();

        System.out.println("What is your age?"); //change to age range?
        age = scanner.nextInt();

        String[] skillz = {"1 - Beginner",
                "2 - Intermediate",
                "3 - Advanced",
                "4 - Chad"};
        int skill;
        while (skillLevel == null) {
            printSkillz(skillz);
            try {
                skill = scanner.nextInt();
                switch (skill) {
                    case 1:
                        skillLevel = "Beginner";
                        break;
                    case 2:
                        skillLevel = "Intermediate";
                        break;
                    case 3:
                        skillLevel = "Advanced";
                        break;
                    case 4:
                        skillLevel = "Chad";
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + skillz.length);
                scanner.next(); //not working
            }
        }

        prof = new Profile(name, age, skillLevel);
        TrackerApp.viewProfile(prof);

    }

    //REQUIRES: valid profile
//    //EFFECTS: prints out profile data
//    //move to ui??
    public static void viewProfile(Profile profile) {
        System.out.println("Your Profile:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Skill Level: " + skillLevel);
        System.out.println("Favourites: " + favourites);
        System.out.println(" ");
        System.out.println(" ");

    }

    public static void printSkillz(String[] skillz) {
        for (String skill : skillz) {
            System.out.println(skill);
        }
        System.out.println("What is your skill level?");
    }


    public static void browseExercises() {
        ExerciseCatalogue.sortList();
    }

    public static void printList(ArrayList<Exercise> exerciseArrayList) {
        System.out.println("Exercises: ");
        for (Exercise exercise : exerciseArrayList) {
            System.out.println(exercise.getCategory() + ": " + exercise.getExerciseName());
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    private static void planWorkout() {
    }


}
