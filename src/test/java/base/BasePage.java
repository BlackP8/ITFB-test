package base;

import org.openqa.selenium.By;
import utils.WaitUtil;

public abstract class BasePage {
    private final By locator;

    protected BasePage(By locator) {
        this.locator = locator;
    }

    public boolean isPageAppeared() {
        return WaitUtil.setPresenceWait(locator).isDisplayed();
    }
}
