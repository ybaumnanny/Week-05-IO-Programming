package com.example.extras.detectduplicatescsv;
import java.io.*;
import java.util.*;

public class DuplicateCsvDetect {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students.csv";

        Set<String> idSet = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

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
                String id = values[0].trim(); // ID is the first column

                // Check for duplicates
                if (!idSet.add(id)) {
                    duplicateRecords.add(line);
                }
            }

            // Print duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
