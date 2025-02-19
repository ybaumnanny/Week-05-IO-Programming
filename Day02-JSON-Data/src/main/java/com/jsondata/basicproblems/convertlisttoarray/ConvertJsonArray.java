package com.jsondata.basicproblems.convertlisttoarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (needed for Jackson)
    public String getName() { return name; }
    public int getAge() { return age; }
}

public class ConvertJsonArray {
    public static void main(String[] args) {
        try {
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25),
                    new Person("Bob", 30)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(people);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
