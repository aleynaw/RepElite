package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseCatalogueTest {
    private static ExerciseCatalogue testCatalogue;

    @BeforeEach
    void runBefore() { testCatalogue = new ExerciseCatalogue();} //technically don't have to do this? (for sortList)

    @Test
    void testConstructor() {
        assertEquals("Barbell Squat", testCatalogue.getUnsortedExerciseList().get(0).getExerciseName());
        assertEquals("DeadLift", testCatalogue.getUnsortedExerciseList().get(1).getExerciseName());
        assertEquals("Seated Rows", testCatalogue.getUnsortedExerciseList().get(2).getExerciseName());
        assertEquals("Shoulder Press", testCatalogue.getUnsortedExerciseList().get(3).getExerciseName());

    }

    @Test
    void testSortList() {
        ExerciseCatalogue.sortList(testCatalogue);
        assertEquals("Seated Rows", testCatalogue.getSortedList().get(0).getExerciseName());
        assertEquals("DeadLift", testCatalogue.getSortedList().get(1).getExerciseName());
        assertEquals("Barbell Squat", testCatalogue.getSortedList().get(2).getExerciseName());
        assertEquals("Shoulder Press", testCatalogue.getSortedList().get(3).getExerciseName());
    }
}
