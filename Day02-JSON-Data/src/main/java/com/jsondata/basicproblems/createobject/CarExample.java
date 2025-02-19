package com.jsondata.basicproblems.createobject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CarExample {
    public static String convertCarToJson(Car car) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        } catch (Exception e) {
            return "Error converting to JSON: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 2022);
        String carJson = convertCarToJson(myCar);
        System.out.println("Car JSON:\n" + carJson);
    }
}
