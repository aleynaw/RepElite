package model;

import ui.TrackerApp;

import java.util.ArrayList;

//workoutplan can add pre-set exercises to a workout plan arraylist
public class WorkoutPlan {

    private ArrayList<Exercise> workoutPlan;
    private static int checker;

    //EFFECTS: Constructor
    public WorkoutPlan() {
        workoutPlan = new ArrayList<>();
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Shoulder Press" exercise to user's workout plan
    public static void addExerciseShoulderPress(ArrayList<Exercise> workoutPlan) {
        checker = 0;
        Exercise shoulderPress = new Exercise("Shoulder Press", "Shoulders");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        if (wp.workoutPlan.isEmpty()) {
            wp.addToPlan(shoulderPress);
        } else {
            for (Exercise exercise : wp.workoutPlan) {
                if (exercise.getExerciseName() == "Shoulder Press") {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                wp.addToPlan(shoulderPress);
            }
        }

        TrackerApp.printWP(wp.workoutPlan);


    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Barbell Squat" exercise to user's workout plan
    public static void addExerciseBarbellSquat(ArrayList<Exercise> workoutPlan) {
        checker = 0;
        Exercise barbellSquat = new Exercise("Barbell Squat", "Quads");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        if (wp.workoutPlan.isEmpty()) {
            wp.addToPlan(barbellSquat);
        } else {
            for (Exercise exercise : wp.workoutPlan) {
                if (exercise.getExerciseName() == "Barbell Squat") {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                wp.addToPlan(barbellSquat);
            }
        }

        TrackerApp.printWP(wp.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "DeadLift" exercise to user's workout plan
    public static void addExerciseDeadLift(ArrayList<Exercise> workoutPlan) {
        checker = 0;
        Exercise deadLift = new Exercise("DeadLift", "Glutes");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        if (wp.workoutPlan.isEmpty()) {
            wp.addToPlan(deadLift);
        } else {
            for (Exercise exercise : wp.workoutPlan) {
                if (exercise.getExerciseName().equals("DeadLift")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                wp.addToPlan(deadLift);
            }
        }

        TrackerApp.printWP(wp.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Seated Rows" exercise to user's workout plan
    public static void addExerciseSeatedRows(ArrayList<Exercise> workoutPlan) {
        checker = 0;
        Exercise seatedRows = new Exercise("Seated Rows", "Back");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        if (wp.workoutPlan.isEmpty()) {
            wp.addToPlan(seatedRows);
        } else {
            for (Exercise exercise : wp.workoutPlan) {
                if (exercise.getExerciseName().equals("Seated Rows")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                wp.addToPlan(seatedRows);
            }
        }

        TrackerApp.printWP(wp.workoutPlan);
    }

    //REQUIRES: valid exercise (with name and category)
    //EFFECTS: adds given exercise to workoutPlan
    public void addToPlan(Exercise exercise) {
        workoutPlan.add(exercise);
    }


//    public void removeFromPlan(Exercise exercise) {
//        workoutPlan.remove(exercise);
//    }

    //getters
    public ArrayList<Exercise> getWorkoutPlan() {
        return workoutPlan;
    }
}
