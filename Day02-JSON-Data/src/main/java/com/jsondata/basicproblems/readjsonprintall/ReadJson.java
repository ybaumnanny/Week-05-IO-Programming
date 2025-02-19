package com.jsondata.basicproblems.readjsonprintall;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadJson {
    public static void main(String[] args) {
        String filePath = "data.json"; // Change this to your JSON file path

        try {
            // Read file content as a String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Parse JSON string into a JSONObject
            JSONObject jsonObject = new JSONObject(content);

            // Iterate and print keys and values
            printJson(jsonObject, "");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Recursive method to handle nested JSON
    private static void printJson(JSONObject jsonObject, String prefix) {
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                System.out.println(prefix + key + " : {");
                printJson((JSONObject) value, prefix + "  ");
                System.out.println(prefix + "}");
            } else {
                System.out.println(prefix + key + " : " + value);
            }
        }
    }
}
