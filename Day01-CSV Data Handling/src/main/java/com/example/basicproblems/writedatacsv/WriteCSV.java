package com.example.basicproblems.writedatacsv;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void main(String[] args) {
        String filePath = "employees.csv";

        String[] header = { "ID", "Name", "Department", "Salary" };
        String[][] employeeData = {
                { "1", "Yaman Mahtha", "HR", "55000" },
                { "2", "Staya", "IT", "75000" },
                { "3", "Choloe Decker", "Marketing", "60000" },
                { "4", "Lucifer Morningstar", "Finance", "80000" },
                { "5", "Belial Beehamoth", "Sales", "65000" }
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(header);

            writer.writeAll(java.util.Arrays.asList(employeeData));

            System.out.println("Data has been written to " + filePath);

        } catch (IOException e) {
            System.err.println("Error while writing to CSV file: " + e.getMessage());
        }
    }
}
