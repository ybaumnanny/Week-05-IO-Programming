package com.example.advanceproblems.convertcsvtojobjects;


import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{Name='" + name + "', Age=" + age + ", Marks=" + marks + "}";
    }
}

public class ConvertCsvToObj {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students1.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            br.lines().forEach(line -> {
                String[] values = line.split(",");
                if (values.length == 3) { // Ensure correct format
                    students.add(new Student(values[0].trim(), Integer.parseInt(values[1].trim()), Double.parseDouble(values[2].trim())));
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        // Print all students
        students.forEach(System.out::println);
    }
}
