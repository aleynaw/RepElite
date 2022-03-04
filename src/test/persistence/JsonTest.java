package persistence;

import model.Category;
import model.Exercise;
import model.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkExercise(String name, Category category, Exercise exercise) {
        assertEquals(name, exercise.getExerciseName());
        assertEquals(category, exercise.getCategory());
    }

    protected void checkProfile(String name, int age, String skillLevel, Profile profile) {
        assertEquals(name, profile.getName());
        assertEquals(age, profile.getAge());
        assertEquals(skillLevel, profile.getSkillLevel());
    }
}
