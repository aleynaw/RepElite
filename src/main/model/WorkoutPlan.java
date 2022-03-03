package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;
import ui.TrackerApp;

import java.util.ArrayList;

import static model.Category.*;

//workoutplan can add pre-set exercises to a workout plan arraylist
public class WorkoutPlan implements Writeable {

    private String name;
    private ArrayList<Exercise> workoutPlan;
    private static int checker;

    //EFFECTS: Constructor
    public WorkoutPlan(String name) {
        this.name = name;
        workoutPlan = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Shoulder Press" exercise to user's workout plan
    public static void addExerciseShoulderPress(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise seatedRows = new Exercise("Shoulder Press", Shoulders);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(seatedRows);
        } else {
            for (Exercise exercise : workoutPlans.workoutPlan) {
                if (exercise.getExerciseName().equals("Shoulder Press")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                workoutPlans.addToPlan(seatedRows);
            }
        }

        TrackerApp.printWP(workoutPlans.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Barbell Squat" exercise to user's workout plan
    public static void addExerciseBarbellSquat(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise seatedRows = new Exercise("Barbell Squat", Quads);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(seatedRows);
        } else {
            for (Exercise exercise : workoutPlans.workoutPlan) {
                if (exercise.getExerciseName().equals("Barbell Squat")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                workoutPlans.addToPlan(seatedRows);
            }
        }

        TrackerApp.printWP(workoutPlans.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "DeadLift" exercise to user's workout plan
    public static void addExerciseDeadLift(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise seatedRows = new Exercise("DeadLift", Glutes);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(seatedRows);
        } else {
            for (Exercise exercise : workoutPlans.workoutPlan) {
                if (exercise.getExerciseName().equals("DeadLift")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                workoutPlans.addToPlan(seatedRows);
            }
        }

        TrackerApp.printWP(workoutPlans.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Seated Rows" exercise to user's workout plan
    public static void addExerciseSeatedRows(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise seatedRows = new Exercise("Seated Rows", Back);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(seatedRows);
        } else {
            for (Exercise exercise : workoutPlans.workoutPlan) {
                if (exercise.getExerciseName().equals("Seated Rows")) {
                    checker = 1;
                }
            }
            if (checker == 1) {
                TrackerApp.printDupError();
                checker = 0;
            } else {
                workoutPlans.addToPlan(seatedRows);
            }
        }

        TrackerApp.printWP(workoutPlans.workoutPlan);
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
    public ArrayList<Exercise> getWorkoutPlans() {
        return workoutPlan;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise t : workoutPlan) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
