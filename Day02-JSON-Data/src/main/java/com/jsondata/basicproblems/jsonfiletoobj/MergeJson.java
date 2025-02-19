package com.jsondata.basicproblems.jsonfiletoobj;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json1 = mapper.readTree(new File("D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day02-JSON-Data\\src\\main\\resources\\file1.json"));
        JsonNode json2 = mapper.readTree(new File("D:\\CAPGEMINI\\Program Prerequisites\\CG Training\\Week-05-IO-Programming\\Day02-JSON-Data\\src\\main\\resources\\json2.json"));

        JsonNode mergedJson = mergeJson(json1, json2);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
    }

    private static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        Iterator<Map.Entry<String, JsonNode>> fields = updateNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            ((com.fasterxml.jackson.databind.node.ObjectNode) mainNode).set(entry.getKey(), entry.getValue());
        }
        return mainNode;
    }
}
