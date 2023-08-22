package utils;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtil {
    private static final String WAIT_TIME = ConfigUtil.getConfProperty("explicitWaitTime");
    private static WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance(), Duration.ofSeconds(Long.parseLong(WAIT_TIME)));

    public static WebElement setPresenceWait(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement setVisibilityWait(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
