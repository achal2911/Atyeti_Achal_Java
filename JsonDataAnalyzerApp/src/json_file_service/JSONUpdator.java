package json_file_service;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUpdator {



    public static void updateAllNameFields(Object obj,String updatedField) {
        if (obj instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) obj;
            for (String key : jsonObj.keySet()) {
                Object value = jsonObj.get(key);
                if ("name".equals(key) && value instanceof String) {
                    jsonObj.put(key, updatedField);
                }
                updateAllNameFields(value,updatedField); // recursive call
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;
            for (int i = 0; i < jsonArray.length(); i++) {
                updateAllNameFields(jsonArray.get(i),updatedField); // recursive call
            }
        }
    }
}
