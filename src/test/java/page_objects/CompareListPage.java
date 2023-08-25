package page_objects;

import library.base.BasePage;
import library.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import library.utils.WaitUtil;
import java.util.List;

/**
 * @author - Pavel Romanov
 */

public class CompareListPage extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
    private final String PRICE_VALUE_ATTRIBUTE = "data-autotest-value";
    private final By priceText = By.cssSelector("*[data-auto='mainPrice']");
    private final By product = By.xpath("//*[@data-auto='cell']//child::a");
    private final By deleteListButton = By.xpath("//*[text()='Удалить список']");
    private final By emptyState = By.cssSelector("*[data-apiary-widget-id='/content/emptyState']");
    private final String deleteProductButton = "//*[contains(text(), '%s')]//following::*[@aria-label='Удалить']";

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
        WebElement element = WaitUtil.setPresenceWait(emptyState);
        return element.isDisplayed();
    }

    public boolean doesProductNameExist(String brandName) {
        List<WebElement> productsToCompare = DriverFactory.getInstance().findElements(product);
        int counter = 0;

        for (WebElement product: productsToCompare) {
            if (product.getText().toLowerCase().contains(brandName)) {
                counter++;
            }
        }
        return counter == 0;
    }

    public void deleteProduct(String brandName) {
        String newBrand = brandName.substring(0, 1).toUpperCase() + brandName.substring(1);
        By deletableProduct = By.xpath(String.format(deleteProductButton, newBrand));
        WaitUtil.setPresenceWait(deletableProduct);
        actions.moveToElement(DriverFactory.getInstance().findElement(deletableProduct))
                .doubleClick().perform();
        WaitUtil.setInvisibilityWait(deletableProduct);
    }
}
