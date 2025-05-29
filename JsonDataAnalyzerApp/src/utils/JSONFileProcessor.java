package utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileProcessor {

    public static JSONObject parseJson(String jsonText) {
        return new JSONObject(jsonText);
    }


    // this method will read all lines from the JSON file and returns concatenated JSON string
    public static String readJsonFile(String filePath) throws IOException {
        List<String> linesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        }

        // Join all  lines into a single JSON string
        StringBuilder jsonText = new StringBuilder();
        for (String line : linesList) {
            jsonText.append(line);
        }
        return jsonText.toString();
    }


    public static void writeJsonToFile(String filePath, JSONObject json) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json.toString(2)); //2 spaces
        }
    }
}
