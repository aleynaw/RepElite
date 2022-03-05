package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// **Code Modified from JsonSerializationDemo**
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReaderP {
    private String sourceProf;

    //Constructor
    public JsonReaderP(String sourceProf) {
        this.sourceProf = sourceProf;
    }

    // EFFECTS: reads SavedProfiles from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SavedProfiles read() throws IOException {
        String jsonData = readFile(sourceProf);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSavedProfiles(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses SavedProfiles from JSON object and returns it
    private SavedProfiles parseSavedProfiles(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        SavedProfiles sp = new SavedProfiles(name);
        addProfiles(sp, jsonObject);
        return sp;
    }

    // MODIFIES: sp
    // EFFECTS: parses profiles from JSON object and adds them to SavedProfiles
    private void addProfiles(SavedProfiles sp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("profiles");
        for (Object json : jsonArray) {
            JSONObject nextProfile = (JSONObject) json;
            addProfile(sp, nextProfile);
        }
    }

    // MODIFIES: sp
    // EFFECTS: parses profile from JSON object and adds it to SavedProfiles
    private void addProfile(SavedProfiles sp, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String skillLevel = jsonObject.getString("skillLevel");
        int age = jsonObject.getInt("age");
        Profile profile = new Profile(name, age, skillLevel);
        sp.addToList(profile);
    }
}
