package library.utils;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author - Pavel Romanov
 */

@Slf4j
public class DataProviderUtil {
    private JSONObject jsonTestObject = null;
    private static final String TEST_FILE_PARAM_NAME = "test_file";

    /**
     * Метод для импорта тестовых данных из JSON и создания DataProvider
     * @param context
     * @return Object[][]
     */
    @DataProvider(name = "testData")
    public Object[][] getData(ITestContext context) {
        jsonTestObject = ConfigUtil.setTestData(context.getCurrentXmlTest().getParameter(TEST_FILE_PARAM_NAME));
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
