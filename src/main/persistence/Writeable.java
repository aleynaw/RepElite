package persistence;

import org.json.JSONObject;

// **Code Modified from JsonSerializationDemo**
public interface Writeable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
