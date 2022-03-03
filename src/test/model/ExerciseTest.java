package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Category.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {
    private Exercise testExercise;
    private Exercise testExerciseWW;

    @BeforeEach
    void runBefore() {
        testExercise = new Exercise("Leg Press", Quads);
        testExerciseWW = new Exercise("Leg Press", Quads, 100, 135);
    }

    @Test
    void testConstructorNoWWPR() {
        assertEquals("Leg Press", testExercise.getExerciseName());
        assertEquals("Quads", testExercise.getCategory());
    }

    @Test
    void testConstructorWWPR() {
        assertEquals("Leg Press", testExerciseWW.getExerciseName());
        assertEquals("Quads", testExerciseWW.getCategory());
        assertEquals(100, testExerciseWW.getWorkingWeight());
        assertEquals(135, testExerciseWW.getPersonalRecord());


    }
}


