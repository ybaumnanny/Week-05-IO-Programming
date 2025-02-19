package com.jsondata.basicproblems.filteruserbyage;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterAge {
    public static void main(String[] args) {
        String jsonData = """
        {
            "users": [
                {"name": "Alice", "age": 30},
                {"name": "Bob", "age": 22},
                {"name": "Charlie", "age": 27},
                {"name": "David", "age": 25}
            ]
        }
        """;

        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray usersArray = jsonObject.getJSONArray("users");

        System.out.println("Users older than 25:");
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject user = usersArray.getJSONObject(i);
            int age = user.getInt("age");
            if (age > 25) {
                System.out.println(user.getString("name") + " - Age: " + age);
            }
        }
    }
}
