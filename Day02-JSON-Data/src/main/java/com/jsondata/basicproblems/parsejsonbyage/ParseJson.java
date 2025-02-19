package com.jsondata.basicproblems.parsejsonbyage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Person {
    public String name;
    public int age;

    public Person() {} // Default constructor required for Jackson

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ParseJson {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\":\"Yaman\",\"age\":22}, {\"name\":\"Matt\",\"age\":30}, {\"name\":\"John\",\"age\":27}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Step 1: Parse JSON into a List of Person objects
            List<Person> people = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});

            // Step 2: Filter records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.age > 25)
                    .collect(Collectors.toList());

            // Step 3: Convert filtered list back to JSON
            String filteredJson = objectMapper.writeValueAsString(filteredPeople);

            System.out.println("Filtered JSON: " + filteredJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
