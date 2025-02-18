package com.example.intermediateproblems.modifycsv;
import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\EMPLOYEE1.csv";
        String outputFilePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\updated_EMPLOYEE1.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                // Write header to new file
                if (!headerSkipped) {
                    bw.write(line);
                    bw.newLine();
                    headerSkipped = true;
                    continue;
                }

                // Split CSV row into values
                String[] values = line.split(",");
                if (values.length < 3) continue; // Skip malformed rows

                String name = values[0].trim();
                String department = values[1].trim();
                double salary;

                try {
                    salary = Double.parseDouble(values[2].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid salary format for employee: " + name);
                    continue;
                }

                // Increase salary by 10% if department is IT
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10; // Increase salary by 10%
                }

                // Write updated record to new file
                bw.write(name + "," + department + "," + String.format("%.2f", salary));
                bw.newLine();
            }

            System.out.println("Updated salaries saved to: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }
}