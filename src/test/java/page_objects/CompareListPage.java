package page_objects;

import base.BasePage;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtil;

import java.util.List;

public class CompareListPage extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
    private final String PRICE_VALUE_ATTRIBUTE = "data-autotest-value";
    private final By priceText = By.cssSelector("*[data-auto='mainPrice']");
    private final String productTitle = "//*[contains(text(), '%s')]";
    private final By deleteListButton = By.xpath("//*[text()='Удалить список']");
    private final By emptyState = By.cssSelector("*[data-apiary-widget-id='/content/emptyState']");
    private final String deleteProductButton = "/*[contains(text(), '%s')]//following::*[@aria-label='Удалить']";

    public CompareListPage() {
        super(By.cssSelector("*[data-apiary-widget-id='/content/compareContent']"));
    }

    public int getPriceSum() {
        List<WebElement> prices = DriverFactory.getInstance().findElements(priceText);
        int priceSum = 0;
        for (WebElement price: prices) {
            priceSum += Integer.parseInt(price.getAttribute(PRICE_VALUE_ATTRIBUTE));
        }
        return priceSum;
    }

    public void clearComparisonList() {
        DriverFactory.getInstance().findElement(deleteListButton).click();
    }

    public boolean isComparisonListEmpty() {
        return WaitUtil.setPresenceWait(emptyState).isDisplayed();
    }

    public boolean doesProductNameExist(String productName) {
        return DriverFactory.getInstance().findElement(By.xpath(String.format(productTitle, productName))).isDisplayed();
    }

    public void deleteProduct(String productName) {
        actions.moveToElement(DriverFactory.getInstance().findElement(By.xpath(String.format(deleteProductButton, productName))))
                .click().build().perform();
    }
}
