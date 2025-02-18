package com.example.advanceproblems.validatecsvbeforeprocessing;
import java.io.*;
import java.util.regex.*;
public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\employees.csv";

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^[0-9]{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            br.lines().forEach(line -> {
                String[] values = line.split(",");
                if (values.length < 4) {
                    System.out.println("ERROR: Malformed row - " + line);
                    return;
                }
                String name = values[0].trim(), email = values[1].trim(), phone = values[2].trim();

                if (!emailPattern.matcher(email).matches())
                    System.out.println("ERROR: Invalid email for " + name + " (" + email + ")");
                if (!phonePattern.matcher(phone).matches())
                    System.out.println("ERROR: Invalid phone number for " + name + " (" + phone + ")");
            });
        }
    }
}
