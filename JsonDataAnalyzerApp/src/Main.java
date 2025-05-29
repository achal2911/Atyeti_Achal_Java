import json_file_service.JSONUpdator;
import org.json.JSONObject;
import utils.JSONFileProcessor;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/utils/data.json";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the updated_value for 'name' fields : ");
        String updatedField = scanner.nextLine();

        try {
            String jsonText = JSONFileProcessor.readJsonFile(filePath);
            JSONObject json = JSONFileProcessor.parseJson(jsonText);

            JSONUpdator.updateAllNameFields(json, updatedField);
            JSONFileProcessor.writeJsonToFile(filePath, json);
            System.out.println("All 'name' fields updated successfully.");
        } catch (IOException e) {
            throw new RuntimeException("IO error occurred", e);
        }
    }
}