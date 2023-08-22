package utils;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class DataProviderUtil {
    private JSONObject jsonTestObject = null;
    private static String testFile = "test_file";
    private JSONArray jsonTestArray = null;

    @DataProvider(name = "testData")
    public Object[][] getData(ITestContext context) {
        jsonTestObject = ConfigUtil.setTestData(context.getCurrentXmlTest().getParameter(testFile));
        Map<String, String> hashMap = new LinkedHashMap<>();

        if (jsonTestObject != null) {
            Set<String> jsonObjKeys = jsonTestObject.keySet();
            for (String jsonObjKey: jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonTestObject.get(jsonObjKey));
            }
        }
        else {
            log.error("Тестовые данные не определены.");
        }
        String[] testData = hashMap.values().toArray(new String[hashMap.size()]);
        Object[][] data = new Object[1][testData.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < testData.length; j++) {
                data[i][j] = testData[j];
            }
        }
        return data;
    }
}
