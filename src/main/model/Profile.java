package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;

//Profile creates a profile of name, age, skill level and an empty favourites list
public class Profile implements Writeable {

    private String name;
    private String skillLevel;
    private int age;
    private int workingWeight;
    private int personalRecord;
    private ArrayList<Exercise> favourites;

    //EFFECTS: constructs a profile with given name, empty favourites set
    public Profile(String name, int age, String skillLevel) {
        this.name = name;
        this.age = age;
        this.skillLevel = skillLevel;
        favourites = new ArrayList<>();
    }



    //getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    //REQUIRES: valid exercise
    //MODIFIES: this
    //EFFECTS: adds exercise with given WW and PR to favourites set
//    public void addExerciseToFavourite(Exercise exercise, int workingWeight, int personalRecord) {
//        //stub
//    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("age", age);
        json.put("skillLevel", skillLevel);
        return json;
    }

}
