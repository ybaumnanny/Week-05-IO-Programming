package com.example.intermediateproblems.sortcsvbycolumn;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\EMPLOYEE2.csv";

        List<String[]> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false;
            String header = br.readLine(); // Read header separately

            while ((line = br.readLine()) != null) {
                // Split CSV row into values
                String[] values = line.split(",");
                if (values.length < 3) continue; // Skip malformed rows
                employeeList.add(values);
            }

            // Sort the list by salary in descending order
            employeeList.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[2].trim());
                double salaryB = Double.parseDouble(b[2].trim());
                return Double.compare(salaryB, salaryA); // Descending order
            });

            // Print the top 5 highest-paid employees
            System.out.println(header); // Print header
            int limit = Math.min(5, employeeList.size()); // Ensure we don't exceed available records
            for (int i = 0; i < limit; i++) {
                String[] employee = employeeList.get(i);
                System.out.println(String.join(",", employee));
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}
