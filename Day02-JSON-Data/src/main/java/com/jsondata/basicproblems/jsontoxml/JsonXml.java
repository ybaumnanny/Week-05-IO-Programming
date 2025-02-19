package com.jsondata.basicproblems.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonXml {
    public static void main(String[] args) throws Exception {
        String json = "{ \"name\": \"Yaman\", \"age\": 22 }";

        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(json);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        System.out.println(xml);
    }
}
