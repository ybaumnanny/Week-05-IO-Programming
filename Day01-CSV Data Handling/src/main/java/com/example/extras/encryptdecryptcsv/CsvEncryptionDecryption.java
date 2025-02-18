package com.example.extras.encryptdecryptcsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvEncryptionDecryption {

    private static final String SECRET_KEY = "1234567890123456";

    public static void writeToCSV(String filePath, List<Employee> employees) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"ID", "Name", "Email", "Salary"}); // Write headers

            for (Employee emp : employees) {
                // Encrypt sensitive fields: Email and Salary
                String encryptedEmail = EncryptionUtil.encrypt(emp.email, SECRET_KEY);
                String encryptedSalary = EncryptionUtil.encrypt(emp.salary, SECRET_KEY);
                // Create CSV row
                String[] row = {emp.id, emp.name, encryptedEmail, encryptedSalary};
                writer.writeNext(row);
            }

            System.out.println("Data written to CSV with encrypted fields.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readFromCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                // Decrypt sensitive fields: Email and Salary
                String decryptedEmail = EncryptionUtil.decrypt(nextLine[2], SECRET_KEY);
                String decryptedSalary = EncryptionUtil.decrypt(nextLine[3], SECRET_KEY);

                // Create Employee object with decrypted data
                Employee emp = new Employee(nextLine[0], nextLine[1], decryptedEmail, decryptedSalary);
                System.out.println(emp); // Print employee details
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Yamann", "yaman@example.com", "5000"));
        employees.add(new Employee("2", "Vatsalya", "vatsalya@example.com", "6000"));
        employees.add(new Employee("3", "Moye", "tanushree@example.com", "7000"));

        // Path to store the CSV file
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\data2.csv";

        // Write encrypted data to CSV
        writeToCSV(filePath, employees);

        // Read and decrypt data from CSV
        System.out.println("\nReading decrypted data:");
        readFromCSV(filePath);
    }
}