package page_objects;

import base.BasePage;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

import java.util.List;

public class CompareListPage extends BasePage {
    private final String PRICE_VALUE_ATTRIBUTE = "data-autotest-value";
    private final By priceText = By.cssSelector("*[data-auto='mainPrice']");
    private final String productTitle = "//*[contains(@title, '%s')]";
    private final By deleteListButton = By.xpath("//*[text()='Удалить список']");
    private final By emptyState = By.cssSelector("*[data-apiary-widget-id='/content/emptyState']");

    public CompareListPage() {
        super(By.cssSelector("*[data-apiary-widget-id='/content/compareContent']"), "comparePageIdentifier");
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
}
