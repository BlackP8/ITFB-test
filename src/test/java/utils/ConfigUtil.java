package utils;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class ConfigUtil {
    private static JSONParser parser = new JSONParser();
    private static JSONObject jsonConfObject;
    private static JSONObject jsonTestObject;

    public static void setConfig(String filePath) {
        jsonConfObject = setJSONObject(jsonConfObject, filePath);
    }

    private static JSONObject setJSONObject(JSONObject object, String pathToFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            object = (JSONObject) parser.parse(reader);
        }
        catch (IOException | ParseException e) {
            log.error(e.getMessage());
        }
        return object;
    }

    public static JSONObject setTestData(String filePath) {
        return setJSONObject(jsonTestObject, filePath);
    }

    public static String getConfProperty(String key) {
        return (String) jsonConfObject.get(key);
    }

    public static String getTestData(String key) {
        return (String) jsonTestObject.get(key);
    }
}
