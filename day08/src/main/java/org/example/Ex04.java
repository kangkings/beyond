package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Ex04 {
    public static void main(String[] args) throws IOException {
        String jsonStr = "{\"id\" : 1, \"name\" : \"Anna\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(jsonMap);
        System.out.println(jsonMap.get("name"));

        String jsonStr2 = "[{\"id\" : 1, \"name\" : \"Anna\"}, {\"id\" : 2, \"name\" : \"Brian\"}]";
        List<Object> list = objectMapper.readValue(jsonStr2, new TypeReference<List<Object>>() {});

        System.out.println(list);
        System.out.println(list.get(0));

    }
}