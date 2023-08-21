package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class DriverFactory {
    private static WebDriver webDriver = null;

    public static void createInstance(String browserName) {
        if (webDriver == null) {
            Browsers browser = Browsers.valueOf(browserName.toUpperCase());
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
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
