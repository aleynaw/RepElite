package model;

import ui.TrackerApp;

import java.util.ArrayList;

public class WorkoutPlan {

    private ArrayList<Exercise> workoutPlan;

    //EFFECTS: Constructor
    public WorkoutPlan() {
        workoutPlan = new ArrayList<>();
    }

    public static void addExerciseShoulderPress(ArrayList<Exercise> workoutPlan) {
        Exercise shoulderPress = new Exercise("Shoulder Press", "Shoulders");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        wp.addToPlan(shoulderPress);
        TrackerApp.printWP(wp.workoutPlan);
    }

    public static void addExerciseBarbellSquat(ArrayList<Exercise> workoutPlan) {
        Exercise barbellSquat = new Exercise("Barbell Squat", "Quads");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        wp.addToPlan(barbellSquat);
        TrackerApp.printWP(wp.workoutPlan);
    }

    public static void addExerciseDeadLift(ArrayList<Exercise> workoutPlan) {
        Exercise deadLift = new Exercise("DeadLift", "Glutes");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        wp.addToPlan(deadLift);
        TrackerApp.printWP(wp.workoutPlan);
    }

    public static void addExerciseSeatedRows(ArrayList<Exercise> workoutPlan) {
        Exercise seatedRows = new Exercise("Seated Rows", "Back");
        WorkoutPlan wp = new WorkoutPlan();
        wp.workoutPlan = workoutPlan;
        wp.addToPlan(seatedRows);
        TrackerApp.printWP(wp.workoutPlan);
    }

    public void addToPlan(Exercise exercise) {
        workoutPlan.add(exercise);
    }

//    public void removeFromPlan(Exercise exercise) {
//        workoutPlan.remove(exercise);
//    }

    public ArrayList<Exercise> getWorkoutPlan() {
        return workoutPlan;
    }
}
