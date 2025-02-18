package com.example.extras.generatecsvfromdatabase;

import java.io.*;
import java.util.*;


class EmployeeCSVWriter {
    public static void writeToCSV(String filePath) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Yaman", "IT", 60000),
                new Employee(2, "Vatsalya", "HR", 50000),
                new Employee(3, "Tanushree", "Finance", 70000),
                new Employee(4, "Moye", "IT", 65000),
                new Employee(5, "Moya", "Marketing", 55000)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee ID,Name,Department,Salary"); // Writing header
            writer.newLine();

            for (Employee emp : employees) {
                writer.write(emp.toCSVString());
                writer.newLine();
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\employees_report.csv";
        writeToCSV(filePath);
    }
}
