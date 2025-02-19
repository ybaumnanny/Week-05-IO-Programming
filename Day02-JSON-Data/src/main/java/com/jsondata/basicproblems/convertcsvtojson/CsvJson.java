package com.jsondata.basicproblems.convertcsvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;

public class CsvJson {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("data.csv");

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Object> it = csvMapper.readerFor(Object.class).with(schema).readValues(csvFile);

        List<Object> data = it.readAll();
        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
    }
}
