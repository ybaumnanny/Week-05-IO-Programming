package com.example.extras.readlargefilecsvefficiently;
import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\large.csv";
        int batchSize = 100; // Read 100 lines at a time
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;

            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                batchCount++;
                totalProcessed++;

                // Process the line (for now, just printing count)
                if (batchCount % batchSize == 0) {
                    System.out.println("Processed: " + totalProcessed + " records so far...");
                    batchCount = 0; // Reset batch counter
                }
            }
            System.out.println("Total records processed: " + totalProcessed);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
