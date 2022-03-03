package ui;


import com.sun.corba.se.spi.orbutil.threadpool.Work;
import model.Exercise;
import model.ExerciseCatalogue;
import model.Profile;
import model.WorkoutPlan;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class TrackerApp {
    private static Profile prof;
    private static String name;
    private static String skillLevel;
    private static int age;
    private static ArrayList<Exercise> favourites;
    private WorkoutPlan workoutPlans;

    private static final ArrayList<Exercise> WORKOUT_PLAN = new ArrayList<>();
    private static final String JSON_STORE = "./data/workroom.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    //EFFECTS: initializes menu
    public TrackerApp() {
        menu();
    }


    //EFFECTS: prints user menu
    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("What would you like to do?");
    }

    //EFFECTS: accepts user's choice from menu, runs corresponding method
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void menu() {
        String[] options = {"1 - Create or Load a Profile \n2 - Browse Exercises \n3 - Plan a Workout  "
                + "\n4 - Save Workout \n5 - Load Workout \n6 - Exit"};
        String[] optionsProfile = {"1 - View Profile \n2 - Browse Exercises \n3 - Plan a Workout  \n4 - Save Workout"
                + "\n5 - Load Workout \n6 - Exit"};
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        workoutPlans = new WorkoutPlan("My Workout Plan");
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 6) {
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
                        planWorkout(workoutPlans);
                        break;
                    case 4:
                        saveWorkoutPlan();
                        break;
                    case 5:
                        loadWorkoutPlan();
                        break;
                    case 6:
                        exit(0);
                }
            } catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next(); //not working
            }
        }
    }

//    public void createOrLoadProfile() {
//        try {
//            prof = jsonReader.read();
//            System.out.println("Loaded " + prof.getName() + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//        createProfile();
//    }

    //EFFECTS: creates a profile with user input
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void createProfile() {
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
//        saveProfile();
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
    private static void planWorkout(WorkoutPlan workoutPlans) {
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
                        WorkoutPlan.addExerciseSeatedRows(workoutPlans);
                        addAnother(workoutPlans);
                        break;
                    case "DeadLift":
                        WorkoutPlan.addExerciseDeadLift(workoutPlans);
                        addAnother(workoutPlans);
                        break;
                    case "Barbell Squat":
                        WorkoutPlan.addExerciseBarbellSquat(workoutPlans);
                        addAnother(workoutPlans);
                        break;
                    case "Shoulder Press":
                        WorkoutPlan.addExerciseShoulderPress(workoutPlans);
                        addAnother(workoutPlans);
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

    public static void addAnother(WorkoutPlan workoutPlans) {
        planWorkout(workoutPlans);
    }
//
//    public void saveProfile() {
//        //stub
//    }

    public void saveWorkoutPlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(workoutPlans);
            jsonWriter.close();
            System.out.println("Saved " + workoutPlans.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void loadWorkoutPlan() {
        try {
            workoutPlans = jsonReader.read();
            System.out.println("Loaded " + workoutPlans.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}

