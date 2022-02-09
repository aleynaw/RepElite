package ui;

import model.Exercise;
import model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class TrackerApp {
    private static Profile prof;
    private static String name;
    private static String skillLevel;
    private static int age;


    public TrackerApp() {
        //init();
        menu();
    }

    private void init() {
        //
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
        String userName = scanner.nextLine();
        name = userName;

        System.out.println("What is your age?"); //change to age range?
        Integer userAge = scanner.nextInt();
        age = userAge;

        String[] skillz = {"1 - Beginner",
                "2 - Intermediate",
                "3 - Advanced",
                "4 - Chad"};
        int skill = 1;
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
        Profile.viewProfile(prof);

    }

    public static void printSkillz(String[] skillz) {
        for (String skill : skillz) {
            System.out.println(skill);
        }
        System.out.println("What is your skill level?");
    }

//    public static void exerciseCatalogue() {
//        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
//        exercises.add(new Exercise("Barbell Squat"));
//        exercises.add(new Exercise("DeadLift"));
//        exercises.add(new Exercise("Seated Rows"));
//        exercises.add(new Exercise("Shoulder Press"));
//
//
//    }


    public static void browseExercises() {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Barbell Squat"));
        exercises.add(new Exercise("DeadLift"));
        exercises.add(new Exercise("Seated Rows"));
        exercises.add(new Exercise("Shoulder Press"));

        System.out.println("Exercises: ");
        for (Exercise exercise : exercises) {
            System.out.println(exercise.getExerciseName());
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    private static void planWorkout() {
    }


}
