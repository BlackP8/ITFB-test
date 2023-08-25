package library.base;

import library.driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import library.utils.ConfigUtil;

/**
 * @author - Pavel Romanov
 */

public abstract class BaseTest {
    private static final String URL_PARAM_NAME = "url";
    private static final String BROWSER_PARAM_NAME = "browser";

    @Parameters("config_path")
    @BeforeTest
    public void setup(String configPath) {
        ConfigUtil.setConfig(configPath);
        DriverFactory.createInstance(ConfigUtil.getConfProperty(BROWSER_PARAM_NAME));
        DriverFactory.getInstance().manage().window().maximize();
        DriverFactory.getInstance().get(ConfigUtil.getConfProperty(URL_PARAM_NAME));
    }

    @AfterTest
    public void quit() {
        DriverFactory.quitDriver();
    }
}
