package library.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author - Pavel Romanov
 */

@Slf4j
public class ConfigUtil {
    private static JSONParser parser = new JSONParser();
    private static JSONObject jsonConfObject;

    /**
     * Метод для установки данных из файла конфига
     * @param filePath
     */
    public static void setConfig(String filePath) {
        jsonConfObject = setJSONObject(jsonConfObject, filePath);
    }

    /**
     * Метод для создания JSONObject для создания тестовых данных и конфига
     * @param object
     * @param pathToFile
     * @return JSONObject
     */
    private static JSONObject setJSONObject(JSONObject object, String pathToFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            object = (JSONObject) parser.parse(reader);
        }
        catch (IOException | ParseException e) {
            log.error(e.getMessage());
        }
        return object;
    }

    /**
     * Метод для создания JSONObject для создания тестовых данных и конфига
     * @param filePath
     * @return JSONObject
     */
    public static JSONObject setTestData(String filePath) {
        return setJSONObject(new JSONObject(), filePath);
    }

    /**
     * Метод для получения данных из файла конфига
     * @param key
     * @return String
     */
    public static String getConfProperty(String key) {
        return (String) jsonConfObject.get(key);
    }
}
