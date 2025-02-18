package com.example.basicproblems.readcountrows;

import java.io.*;

class CSVRowCounter {
    public static int countRows(String filePath) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\data.csv";
        int rowCount = countRows(filePath);
        System.out.println("Total records (excluding header): " + rowCount);
    }
}
