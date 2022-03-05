package persistence;

import model.Category;
import model.Exercise;
import model.WorkoutPlan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            WorkoutPlan wp = new WorkoutPlan("My workout plan");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkoutPlan() {
        try {
            WorkoutPlan wp = new WorkoutPlan("My workout plan");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkoutPlan.json");
            writer.open();
            writer.write(wp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkoutPlan.json");
            wp = reader.read();
            assertEquals("My workout plan", wp.getName());
            assertEquals(0, wp.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkoutPlan() {
        try {
            WorkoutPlan wp = new WorkoutPlan("My workout plan");
            wp.addExerciseBarbellSquat(wp);
            wp.addExerciseSeatedRows(wp);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkoutPlan.json");
            writer.open();
            writer.write(wp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkoutPlan.json");
            wp = reader.read();
            assertEquals("My workout plan", wp.getName());
            List<Exercise> exercises = wp.getWorkoutPlans();
            assertEquals(2, exercises.size());
            checkExercise("Barbell Squat", Category.Quads, exercises.get(0));
            checkExercise("Seated Rows", Category.Back, exercises.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
