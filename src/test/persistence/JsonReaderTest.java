package persistence;

import model.Category;
import model.Exercise;
import model.WorkoutPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutPlan wp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkoutPlan() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkoutPlan.json");
        try {
            WorkoutPlan wp = reader.read();
            assertEquals("My workout plan", wp.getName());
            assertEquals(0, wp.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkoutPlan() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkoutPlan.json");
        try {
            WorkoutPlan wp = reader.read();
            assertEquals("My workout plan", wp.getName());
            List<Exercise> exercises = wp.getWorkoutPlans();
            assertEquals(2, exercises.size());
            checkExercise("Barbell Squat", Category.Quads, exercises.get(0));
            checkExercise("Seated Rows", Category.Back, exercises.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
