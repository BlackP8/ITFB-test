package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public abstract class DriverFactory {
    private static WebDriver webDriver = null;

    public static void createInstance(String browserName) {
        if (webDriver == null) {
            Browsers browser = Browsers.valueOf(browserName.toUpperCase());
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
            }
        }
    }

    public static WebDriver getInstance() {
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.quit();
    }
}
