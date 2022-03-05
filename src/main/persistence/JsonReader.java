package persistence;

import model.Category;
import model.Exercise;
import model.WorkoutPlan;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// **Code Modified from JsonSerializationDemo**
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workoutplan from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutPlan read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutPlan(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workoutplan from JSON object and returns it
    private WorkoutPlan parseWorkoutPlan(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkoutPlan wp = new WorkoutPlan(name);
        addExercises(wp, jsonObject);
        return wp;
    }

    // MODIFIES: wp
    // EFFECTS: parses exercises from JSON object and adds them to workoutplan
    private void addExercises(WorkoutPlan wp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(wp, nextExercise);
        }
    }

    // MODIFIES: wp
    // EFFECTS: parses exercise from JSON object and adds it to workoutplan
    private void addExercise(WorkoutPlan wp, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Exercise exercise = new Exercise(name, category);
        wp.addToPlan(exercise);
    }
}
