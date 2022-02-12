package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class WorkoutPlanTest {
    private WorkoutPlan testWorkoutPlan;
    private static int checker;

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
        assertEquals(checker, 0);

    }

    @Test
    void testAddExerciseBarbellSquat() {
        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddExerciseDeadLift() {
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddExerciseSeatedRows() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddMultipleToPlanNonDupe() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlan().get(1).getExerciseName());


        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlan().get(2).getExerciseName());
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlan().get(3).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddMultipleToPlanDupe(){
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlan().get(0).getExerciseName());

        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlan().get(1).getExerciseName());

        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan.getWorkoutPlan());
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlan().get(2).getExerciseName());

        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan.getWorkoutPlan());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlan().get(3).getExerciseName());
    }

//    @Test
//    void testRemoveFromPlan() {
//        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
//        testWorkoutPlan.removeFromPlan();
//
//    }
}
