package library.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author - Pavel Romanov
 */

public abstract class DriverFactory {
    private static WebDriver webDriver = null;

    /**
     * Метод для создания объекта драйвера для разных браузеров в зависимости от значения в конфиге
     * @param browserName
     */
    public static void createInstance(String browserName) {
        if (webDriver == null) {
            Browsers browser = Browsers.valueOf(browserName.toUpperCase());
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new EventFiringWebDriver(new ChromeDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new EventFiringWebDriver(new FirefoxDriver());
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
