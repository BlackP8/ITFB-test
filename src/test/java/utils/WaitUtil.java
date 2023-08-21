package utils;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtil {
    private static WebDriverWait wait;
    private static final String WAIT_TIME = ConfigUtil.getConfProperty("explicitWaitTime");
    private static final int WAIT_ATTRIBUTE_TIME = 50;

    public static WebElement setPresenceWait(By locator) {
        wait = new WebDriverWait(DriverFactory.getInstance(), Duration.ofSeconds(Long.parseLong(WAIT_TIME)));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
