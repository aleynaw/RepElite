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

    private static Exercise shoulderPress;
    private static Exercise barbellSquat;
    private static Exercise deadLift;
    private static Exercise seatedRows;

    //EFFECTS: Constructor
    public WorkoutPlan(String name) {
        this.name = name;
        workoutPlan = new ArrayList<>();
        shoulderPress = new Exercise("Shoulder Press", Shoulders);
        barbellSquat = new Exercise("Barbell Squat", Quads);
        deadLift = new Exercise("DeadLift", Glutes);
        seatedRows = new Exercise("Seated Rows", Back);

    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return workoutPlan.size();
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Shoulder Press" exercise to user's workout plan
    public static void addExerciseShoulderPress(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise shoulderPress = new Exercise("Shoulder Press", Shoulders);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(shoulderPress);
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
                workoutPlans.addToPlan(shoulderPress);
            }
        }

//        TrackerApp.printWP(workoutPlans.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "Barbell Squat" exercise to user's workout plan
    public static void addExerciseBarbellSquat(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise barbellSquat = new Exercise("Barbell Squat", Quads);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(barbellSquat);
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
                workoutPlans.addToPlan(barbellSquat);
            }
        }

//        TrackerApp.printWP(workoutPlans.workoutPlan);
    }

    //REQUIRES: valid workoutPlan arraylist
    //MODIFIES: this
    //EFFECTS: adds the "DeadLift" exercise to user's workout plan
    public static void addExerciseDeadLift(WorkoutPlan workoutPlans) {
        checker = 0;
        Exercise deadLift = new Exercise("DeadLift", Glutes);
        if (workoutPlans.workoutPlan.isEmpty()) {
            workoutPlans.addToPlan(deadLift);
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
                workoutPlans.addToPlan(deadLift);
            }
        }

//        TrackerApp.printWP(workoutPlans.workoutPlan);
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

//        TrackerApp.printWP(workoutPlans.workoutPlan);
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

    public static String messageBuilder(WorkoutPlan wp) {
        int amount = 0;
        String msg = "";
        for (Exercise e : wp.workoutPlan) {
            if (e.getExerciseName().equals(shoulderPress.getExerciseName())) {
                amount++;
                msg += "Shoulder Press (Shoulders) -- 4s15r\n";
            }
            if (e.getExerciseName().equals(deadLift.getExerciseName())) {
                amount++;
                msg += "DeadLift (Glutes) -- 3s10r\n";
            }
            if (e.getExerciseName().equals(barbellSquat.getExerciseName())) {
                amount++;
                msg += "Barbell Squat (Quads) -- 4s8r\n";
            }
            if (e.getExerciseName().equals(seatedRows.getExerciseName())) {
                amount++;
                msg += "Seated Rows (Back) -- 4s8r\n";
            }
        }
        msg += "-----------------\n" + "Total Exercises: " + amount;
        return msg;
    }


    //Below code modified from **JsonSerializationDemo**
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Override
    //EFFECTS: creates JSONObject out of WorkoutPlan
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: returns exercises in this workoutplan as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise t : workoutPlan) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
