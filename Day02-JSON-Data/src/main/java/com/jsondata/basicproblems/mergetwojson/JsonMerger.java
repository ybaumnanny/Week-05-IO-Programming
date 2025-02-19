package com.jsondata.basicproblems.mergetwojson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonMerger {
    public static void main(String[] args) {
        // JSON strings
        String json1 = "{ \"name\": \"Yaman Mahtha\", \"email\": \"yaman@example.com\" }";
        String json2 = "{ \"age\": 22, \"location\": \"India\" }";

        // Parse JSON strings to JsonObjects
        JsonObject jsonObject1 = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject jsonObject2 = JsonParser.parseString(json2).getAsJsonObject();

        for (String key : jsonObject2.keySet()) {
            jsonObject1.add(key, jsonObject2.get(key));
        }

        // Convert merged object back to JSON string
        Gson gson = new Gson();
        String mergedJson = gson.toJson(jsonObject1);

        // Print the merged JSON
        System.out.println("Merged JSON: " + mergedJson);
    }
}
