package library.utils;

import library.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * @author - Pavel Romanov
 */

public class ScrollUtil {
    private static final JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance();
    private static final String SCROLL_ELEMENT_INTO_MIDDLE =
            "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
    public static void scrollToElement(WebElement element) {
        executor.executeScript(SCROLL_ELEMENT_INTO_MIDDLE, element);
    }
}
