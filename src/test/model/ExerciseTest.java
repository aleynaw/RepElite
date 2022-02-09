package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {
    private Exercise testExercise;

    @BeforeEach
    void runBefore() { testExercise = new Exercise("Leg Press", "Quads");}

    @Test
    void testConstructor() {
        assertEquals("Leg Press", testExercise.getExerciseName());
        assertEquals("Quads", testExercise.getCategory());
    }
}


