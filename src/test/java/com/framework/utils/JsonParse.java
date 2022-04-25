package com.framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonParse {

    protected static String PATH = "src/test/resources/demoqa.properties.json";
    protected static JSONObject jsonObject;
    protected static Reader reader;

    static {
        try {
            reader = new FileReader(PATH);

            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException | NullPointerException | ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static String getPropertyFromJson(String key) {
        return jsonObject.get(key).toString();
    }
}

