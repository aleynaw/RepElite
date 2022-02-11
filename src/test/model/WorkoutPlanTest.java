package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutPlanTest {
    private WorkoutPlan testWorkoutPlan;

    @BeforeEach
    void runBefore() {
        testWorkoutPlan = new WorkoutPlan();
    }

    @Test
    void testConstructor() {
        assertTrue(testWorkoutPlan.getWorkoutPlan().isEmpty());
    }

    @Test
    void testAddExerciseShoulderPress() {
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
    }

    @Test
    void testAddExerciseBarbellSquat() {
        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
    }

    @Test
    void testAddExerciseDeadLift() {
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
    }

    @Test
    void testAddExerciseSeatedRows() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
    }

    @Test
    void testAddMultipleToPlan() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlan().get(1).getExerciseName());
    }

//    @Test
//    void testRemoveFromPlan() {
//        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
//        testWorkoutPlan.removeFromPlan();
//
//    }
}
