package base;

import org.openqa.selenium.By;
import utils.WaitUtil;

public abstract class BasePage {
    private final By locator;
    private final String name;

    protected BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public By getLocator() {
        return locator;
    }

    public boolean isPageAppeared() {
        return WaitUtil.setPresenceWait(locator).isDisplayed();
    }
}
