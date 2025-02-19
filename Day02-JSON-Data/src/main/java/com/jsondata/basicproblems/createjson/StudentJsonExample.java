package com.jsondata.basicproblems.createjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;
import java.util.List;

public class StudentJsonExample {
    public static String createStudentJson(String name, int age, List<String> subjects) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode studentNode = objectMapper.createObjectNode();

            studentNode.put("name", name);
            studentNode.put("age", age);

            ArrayNode subjectsArray = objectMapper.createArrayNode();
            for (String subject : subjects) {
                subjectsArray.add(subject);
            }
            studentNode.set("subjects", subjectsArray);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentNode);
        } catch (Exception e) {
            return "Error creating JSON: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        List<String> subjects = Arrays.asList("Math", "Science", "English");
        String studentJson = createStudentJson("Yaman", 21, subjects);

        System.out.println("Generated Student JSON:\n" + studentJson);
    }
}
