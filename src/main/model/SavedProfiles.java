package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;
import ui.TrackerApp;

import java.util.ArrayList;
import java.util.List;

//list of profiles, used to load JSON conveniently
public class SavedProfiles implements Writeable {

    private static String name;
    private static int age;
    private static String skillLevel;
    ArrayList<Profile> savedProfileArray;
    static Profile profile;

    //EFFECTS: Constructor
    public SavedProfiles(String name) {
        this.name = name;
        savedProfileArray = new ArrayList<>();

    }

    //REQUIRES: valid exercise (with name and category)
    //EFFECTS: adds given exercise to workoutPlan
    public static void addToList(SavedProfiles savedProfiles, Profile profile) {
        savedProfiles.savedProfileArray.add(profile);
    }

    //EFFECTS: adds profile to list inside SavedProfiles
    public void addToList(Profile profile) {
        savedProfileArray.add(profile);
    }



    //EFFECTS: assigns values from loaded profile to dummy profile
    public static void assignValues(SavedProfiles savedProfiles) {
        profile = savedProfiles.savedProfileArray.get(0);
        TrackerApp.assignValuesUI(profile);

    }

    //Below JSON code modified from **JsonSerializationDemo**
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    @Override
    //EFFECTS: creates JSONObject out of Profiles
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("profiles", profilesToJson());
        return json;
    }

    // EFFECTS: returns profiles in this ProfilesList as a JSON array
    private JSONArray profilesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Profile p : savedProfileArray) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

    //getters
    public List<Profile> getSavedProfiles() {
        return savedProfileArray;
    }

    public String getName() {
        return name;
    }
}
