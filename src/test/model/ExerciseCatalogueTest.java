package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseCatalogueTest {
    private ExerciseCatalogue testCatalogue;

    @BeforeEach
    void runBefore() { testCatalogue = new ExerciseCatalogue();}

    @Test
    void testConstructor() {
        assertEquals("Barbell Squat", testCatalogue.getUnsortedExerciseList().get(0).getExerciseName());
        assertEquals("DeadLift", testCatalogue.getUnsortedExerciseList().get(1).getExerciseName());
        assertEquals("Seated Rows", testCatalogue.getUnsortedExerciseList().get(2).getExerciseName());
        assertEquals("Shoulder Press", testCatalogue.getUnsortedExerciseList().get(3).getExerciseName());

    }

    @Test
    void testSortList() {
        //stub
    }
}
