package ui;


import model.Exercise;
import model.ExerciseCatalogue;
import model.Profile;
import model.WorkoutPlan;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class TrackerApp {
    private static Profile prof;
    private static String name;
    private static String skillLevel;
    private static int age;
    private static ArrayList<Exercise> favourites;

    private static final ArrayList<Exercise> WORKOUT_PLAN = new ArrayList<>();


    //EFFECTS: initializes menu
    public TrackerApp() {
        menu();
    }


    //EFFECTS: prints user menu
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("What would you like to do?");
    }

    //EFFECTS: accepts user's choice from menu, runs corresponding method
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void menu() {
        String[] options = {"1 - Create a Profile \n2 - Browse Exercises \n3 - Plan a Workout \n4 - Exit"};
        String[] optionsProfile = {"1 - View Profile \n2 - Browse Exercises \n3 - Plan a Workout \n4 - Exit"};
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            if (prof == null) {
                printMenu(options);
            } else {
                printMenu(optionsProfile);
            }
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        if (prof == null) {
                            createProfile();
                        } else {
                            viewProfile();
                        }
                        break;
                    case 2:
                        browseExercises();
                        break;
                    case 3:
                        planWorkout(WORKOUT_PLAN);
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

    //EFFECTS: creates a profile with user input
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void createProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        name = scanner.nextLine();
        System.out.println("What is your age?"); //change to age range?
        age = scanner.nextInt();
        String[] skillz = {"1 - Beginner \n2 - Intermediate \n3 - Advanced \n4 - Chad"};
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
        TrackerApp.viewProfile();
        menu();
    }

    //REQUIRES: valid profile
   //EFFECTS: prints out profile data
    public static void viewProfile() {
        System.out.println("Your Profile:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Skill Level: " + skillLevel);
        System.out.println("Favourites: " + favourites);
        System.out.println(" ");
        System.out.println(" ");

    }

    //EFFECTS: prints a list of skill levels
    public static void printSkillz(String[] skillz) {
        for (String skill : skillz) {
            System.out.println(skill);
        }
        System.out.println("What is your skill level?");
    }


    //EFFECTS: instantiates catalogue
    public static void browseExercises() {
        ExerciseCatalogue catalogue = new ExerciseCatalogue();

        ExerciseCatalogue.sortList(catalogue);
    }

    //EFFECTS: prints catalogue for user to browse
    public static void printList(ArrayList<Exercise> exerciseArrayList) {
        System.out.println("Exercises: ");
        for (Exercise exercise : exerciseArrayList) {
            System.out.println(exercise.getCategory() + ": " + exercise.getExerciseName());
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    //REQUIRES: valid workout plan
    //MODIFIES: this
    //EFFECTS:
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private static void planWorkout(ArrayList<Exercise> workoutPlan) {
        System.out.println("What exercises would you like to add?");


        Scanner scanner = new Scanner(System.in);
        String workouts = null;
        while (workouts == null) {
            browseExercises();
            System.out.println("Go Back");
            try {
                workouts = scanner.nextLine();
                switch (workouts) {
                    case "Seated Rows":
                        WorkoutPlan.addExerciseSeatedRows(workoutPlan);
                        addAnother(workoutPlan);
                        break;
                    case "DeadLift":
                        WorkoutPlan.addExerciseDeadLift(workoutPlan);
                        addAnother(workoutPlan);
                        break;
                    case "Barbell Squat":
                        WorkoutPlan.addExerciseBarbellSquat(workoutPlan);
                        addAnother(workoutPlan);
                        break;
                    case "Shoulder Press":
                        WorkoutPlan.addExerciseShoulderPress(workoutPlan);
                        addAnother(workoutPlan);
                        break;
                    case "Go Back":
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Please enter a valid workout (case sensitive)");
                scanner.nextLine(); //not working
            }
        }

    }

    public static void printWP(ArrayList<Exercise> workoutPlan) {
        System.out.println("Your Current Workout Plan: ");
        for (Exercise exercise : workoutPlan) {
            System.out.println(exercise.getCategory() + ": " + exercise.getExerciseName());
        }
        System.out.println(" ");
        System.out.println(" ");

    }

    public static void printDupError() {
        System.out.println("You've already added this workout to your plan for today!");

    }

    public static void addAnother(ArrayList<Exercise> workoutPlan) {
        planWorkout(workoutPlan);
    }


}

