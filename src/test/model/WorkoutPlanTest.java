package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class WorkoutPlanTest {
    private WorkoutPlan testWorkoutPlan;
    private static int checker;

    @BeforeEach
    void runBefore() {
        testWorkoutPlan = new WorkoutPlan("New Workout Plan");
    }

    @Test
    void testConstructor() {
        assertTrue(testWorkoutPlan.getWorkoutPlans().isEmpty());
    }

    @Test
    void testAddExerciseShoulderPress() {
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan);
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());
        assertEquals(checker, 0);

    }

    @Test
    void testAddExerciseBarbellSquat() {
        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan);
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddExerciseDeadLift() {
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan);
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddExerciseSeatedRows() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan);
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddMultipleToPlanNonDupe() {
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan);
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan);
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlans().get(1).getExerciseName());


        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan);
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlans().get(2).getExerciseName());
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan);
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlans().get(3).getExerciseName());
        assertEquals(checker, 0);
    }

    @Test
    void testAddMultipleToPlanDupe(){
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan);
        WorkoutPlan.addExerciseShoulderPress(testWorkoutPlan);
        assertEquals("Shoulder Press", testWorkoutPlan.getWorkoutPlans().get(0).getExerciseName());

        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan);
        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan);
        assertEquals("Seated Rows", testWorkoutPlan.getWorkoutPlans().get(1).getExerciseName());

        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan);
        WorkoutPlan.addExerciseBarbellSquat(testWorkoutPlan);
        assertEquals("Barbell Squat", testWorkoutPlan.getWorkoutPlans().get(2).getExerciseName());

        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan);
        WorkoutPlan.addExerciseDeadLift(testWorkoutPlan);
        assertEquals("DeadLift", testWorkoutPlan.getWorkoutPlans().get(3).getExerciseName());
    }

//    @Test
//    void testRemoveFromPlan() {
//        WorkoutPlan.addExerciseSeatedRows(testWorkoutPlan.getWorkoutPlan());
//        testWorkoutPlan.removeFromPlan();
//
//    }
}
