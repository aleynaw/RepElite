package model;

import org.json.JSONObject;
import persistence.Writeable;


//Exercise class, instantiates an object known as exercise
public class Exercise implements Writeable {

    private String name;
    private Category category;
    private int workingWeight;
    private int personalRecord;



    //EFFECTS: constructs an exercise with given WW and PR
    public Exercise(String name, Category category, int workingWeight, int personalRecord) {
        this.name = name;
        this.category = category;
        this.workingWeight = workingWeight;
        this.personalRecord = personalRecord;

    }


    //EFFECTS: constructs an exercise with just name and category (no saved WW or PR)
    public Exercise(String name, Category category) {
        this.name = name;
        this.category = category;
    }



    //getters
    public String getExerciseName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryName() {
        return category.toString();
    }

    public int getWorkingWeight() {
        return workingWeight;
    }

    public int getPersonalRecord() {
        return personalRecord;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", category);
        return json;
    }
}
