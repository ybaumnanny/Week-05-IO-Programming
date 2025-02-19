package com.jsondata.basicproblems.convertlisttojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ConvertJson {
    public static void main(String[] args) {
        try {
            List<Person> people = Arrays.asList(
                    new Person("Yaman", 22),
                    new Person("Matt", 25)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(people);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
