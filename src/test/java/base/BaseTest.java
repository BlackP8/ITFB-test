package base;

import driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.ConfigUtil;

public abstract class BaseTest {
    private static final String URL_PARAM_NAME = "url";

    @Parameters({"browser", "config_path"})
    @BeforeTest
    public void setup(String browser, String configPath) {
        ConfigUtil.setConfig(configPath);
        DriverFactory.createInstance(browser);
        DriverFactory.getInstance().manage().window().maximize();
        DriverFactory.getInstance().get(ConfigUtil.getConfProperty(URL_PARAM_NAME));
    }

    @AfterTest
    public void quit() {
        DriverFactory.quitDriver();
    }
}
