package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ElkService {
    public JSONArray getAllFoodDetails(){
        log.info("Fetching ALL food details...");
        JSONArray foodDetail = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("example.json", StandardCharsets.UTF_8));
            JSONObject jsonObject = (JSONObject) obj;
            foodDetail = (JSONArray) jsonObject.get("data");

        } catch (IOException | ParseException e) {
            log.error("Error occurred in reading JSON file");
            e.printStackTrace();
        }
        return foodDetail;
    }
}
