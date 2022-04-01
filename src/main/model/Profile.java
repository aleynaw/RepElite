package model;

import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;


//Profile creates a profile of name, age, skill level and an empty favourites list
public class Profile implements Writeable {

    private String name;
    private int skillLevel;
    private int age;
    private int workingWeight;
    private int personalRecord;
    private ArrayList<Exercise> favourites;

    //EFFECTS: constructs a profile with given name, empty favourites set
    public Profile(String name, int age, int skillLevel) {
        this.name = name;
        this.age = age;
        this.skillLevel = skillLevel;
        favourites = new ArrayList<>();
        EventLog.getInstance().logEvent(new Event("Created a Profile"));

    }



    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSkillLevel() {
        if (Integer.valueOf(skillLevel) == 1) {
            return "1 - Beginner";
        } else if (Integer.valueOf(skillLevel) == 2) {
            return "2 - Intermediate";
        } else if (Integer.valueOf(skillLevel) == 3) {
            return "3 - Advanced";
        } else {
            return "4 - Chad";
        }
    }

    public int getSkillLevelInt() {
        return skillLevel;
    }

    //REQUIRES: valid exercise
    //MODIFIES: this
    //EFFECTS: adds exercise with given WW and PR to favourites set
//    public void addExerciseToFavourite(Exercise exercise, int workingWeight, int personalRecord) {
//        //stub
//    }

    @Override
    //Code modified from **JsonSerializationDemo**
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    //EFFECTS: creates JSONObject out of Profile
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("skillLevel", skillLevel);
        return json;
    }

}
