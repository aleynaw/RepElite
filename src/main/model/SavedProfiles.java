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
    private ArrayList<Profile> savedProfileArray;
    private static Profile profile;

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

    public void addToList(Profile profile) {
        savedProfileArray.add(profile);
    }

    public String getName() {
        return name;
    }


    //EFFECTS: assigns values from loaded profile to current profile
    public static void assignValues(SavedProfiles savedProfiles) {
        profile = savedProfiles.savedProfileArray.get(0);
        TrackerApp.assignValuesUI(profile);

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("profiles", profilesToJson());
        return json;
    }

    // EFFECTS: returns things in this ProfilesList as a JSON array
    private JSONArray profilesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Profile p : savedProfileArray) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

    public List<Profile> getSavedProfiles() {
        return savedProfileArray;
    }
}
