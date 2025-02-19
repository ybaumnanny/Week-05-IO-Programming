package com.jsondata.basicproblems.readjsonextractspecificfields;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class JsonFieldExtractor {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day02-Json-Handling\\src\\main\\resources\\data.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Extract specific fields
            String name = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "N/A";
            String email = jsonObject.has("email") ? jsonObject.get("email").getAsString() : "N/A";

            // Print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
