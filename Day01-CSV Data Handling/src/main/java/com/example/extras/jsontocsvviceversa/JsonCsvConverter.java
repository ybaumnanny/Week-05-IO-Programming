package com.example.extras.jsontocsvviceversa;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

class JsonCsvConverter {

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(new File(jsonFilePath));

            List<String[]> csvData = new ArrayList<>();
            // Extract headers
            if (jsonArray.isArray() && jsonArray.size() > 0) {
                JsonNode firstObj = jsonArray.get(0);
                List<String> headers = new ArrayList<>();
                firstObj.fieldNames().forEachRemaining(headers::add);
                csvData.add(headers.toArray(new String[0]));

                // Extract row data
                for (JsonNode node : jsonArray) {
                    List<String> row = new ArrayList<>();
                    for (String header : headers) {
                        row.add(node.get(header).asText());
                    }
                    csvData.add(row.toArray(new String[0]));
                }
            }

            // Write CSV
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                writer.writeAll(csvData);
            }

            System.out.println("JSON converted to CSV successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            CSVReader reader = new CSVReader(br);
            List<String[]> csvData = reader.readAll();

            if (csvData.isEmpty()) return;

            List<ObjectNode> jsonArray = new ArrayList<>();
            String[] headers = csvData.get(0);

            // Convert each row to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 1; i < csvData.size(); i++) {
                ObjectNode obj = objectMapper.createObjectNode();
                for (int j = 0; j < headers.length; j++) {
                    obj.put(headers[j], csvData.get(i)[j]);
                }
                jsonArray.add(obj);
            }

            objectMapper.writeValue(new File(jsonFilePath), jsonArray);
            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String jsonFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students.json";
        String csvFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\students15.csv";
        String newJsonFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day01-CSV Data Handling\\src\\main\\resources\\converted_students.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, newJsonFile);
    }
}
