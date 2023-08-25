package library.base;

import org.openqa.selenium.By;
import library.utils.WaitUtil;
import org.openqa.selenium.WebElement;

/**
 * @author - Pavel Romanov
 */

public abstract class BasePage {
    private final By locator;

    protected BasePage(By locator) {
        this.locator = locator;
    }

    /**
     * Метод для проверки открытия страницы через уникальный элемент
     * @return boolean
     */
    public boolean isPageAppeared() {
        WebElement element = WaitUtil.setPresenceWait(locator);
        return element.isDisplayed();
    }
}
