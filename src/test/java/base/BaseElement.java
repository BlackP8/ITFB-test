package base;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtil;

public abstract class BaseElement {
    private WebElement element;
    private By locator;
    private static JavascriptExecutor executor;

    protected BaseElement(By locator) {
        this.locator = locator;
    }

    public void findElement() {
        element = WaitUtil.setPresenceWait(locator);
    }

    public void doClick() {
        element.click();
    }

    public void moveToElement() {
        new Actions(DriverFactory.getInstance()).moveToElement(petSuppliesCategory).perform();
    }
}
