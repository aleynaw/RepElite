package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;

public class SavedProfiles implements Writeable {

    private String name;
    public ArrayList<Profile> savedProfileArray;

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

    public void get() {

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
}
