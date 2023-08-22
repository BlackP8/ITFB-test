package utils;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollUtil {
    private static final JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance();
    public static void scrollToElement(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
