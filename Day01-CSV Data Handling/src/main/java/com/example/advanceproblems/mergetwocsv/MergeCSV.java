package com.example.advanceproblems.mergetwocsv;
import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    double marks;
    String grade;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void updateMarksAndGrade(double marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students11.csv";
        String file2 = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students12.csv";
        String outputFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\merged_students13.csv";

        Map<Integer, Student> studentMap = new HashMap<>();

        // Read students1.csv (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine(); // Skip header
            br.lines().forEach(line -> {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                studentMap.put(id, new Student(id, values[1].trim(), Integer.parseInt(values[2].trim())));
            });
        } catch (IOException e) {
            System.err.println("Error reading " + file1 + ": " + e.getMessage());
        }

        // Read students2.csv (ID, Marks, Grade) and update studentMap
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            br.readLine(); // Skip header
            br.lines().forEach(line -> {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                if (studentMap.containsKey(id)) {
                    studentMap.get(id).updateMarksAndGrade(Double.parseDouble(values[1].trim()), values[2].trim());
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading " + file2 + ": " + e.getMessage());
        }

        // Write merged data to new CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentMap.values()) {
                bw.write(student + "\n");
            }
            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to " + outputFile + ": " + e.getMessage());
        }
    }
}
