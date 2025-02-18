package com.example.intermediateproblems.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }

                // Split CSV row into values
                String[] values = line.split(",");
                if (values.length < 2) continue; // Skip malformed lines

                String name = values[0].trim();
                int marks;

                try {
                    marks = Integer.parseInt(values[1].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid marks format: " + values[1]);
                    continue; // Skip invalid data
                }

                // Filtering condition: Print only students with marks > 80
                if (marks > 80) {
                    System.out.println("Name: " + name + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
