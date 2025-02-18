package com.example.intermediateproblems.searchrecordcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\Employee.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll(); // Read all records at once

            // Skip header row
            if (records.size() < 2) {
                System.out.println("CSV file is empty or has no data.");
                return;
            }

            // Ask user for employee name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Name to search: ");
            String searchName = scanner.nextLine().trim();
            scanner.close();

            boolean found = false;

            // Iterate through records
            for (String[] row : records) {
                if (row.length < 3) continue; // Skip malformed rows

                String name = row[0].trim();
                String department = row[1].trim();
                String salary = row[2].trim();

                // Case-insensitive search
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
