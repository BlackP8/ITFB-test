package page_objects;

import base.BasePage;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.ScrollUtil;
import utils.WaitUtil;

public class FilterForm extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
    private final By minPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'min')]");
    private final By maxPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'max')]");
    private final By courierRadioButton = By.cssSelector("*[data-filter-value-id='offer-shipping_delivery']>label");
    private final By expandBrandsButton = By.xpath("//*[contains(text(), 'Показать всё')]//ancestor::button");
    private final By brandFilterSearchTextBox = By.cssSelector("*[data-zone-name='filterSearchValueField'] input");
    private final String brandButton = "//span[text()='%s']";

    public FilterForm() {
        super(By.cssSelector("#searchFilters"));
    }

    public void setMinPrice(String minPrice) {
        WaitUtil.setPresenceWait(minPriceField).sendKeys(minPrice);
    }

    public void setMaxPrice(String maxPrice) {
        WaitUtil.setPresenceWait(maxPriceField).sendKeys(maxPrice);
    }

    public void setCourierDeliveryOption() {
        DriverFactory.getInstance().findElement(courierRadioButton).click();
    }

    public void expandBrands() {
        ScrollUtil.scrollToElement(DriverFactory.getInstance().findElement(expandBrandsButton));
        actions.moveToElement(DriverFactory.getInstance().findElement(expandBrandsButton)).click().build().perform();
//        DriverFactory.getInstance().findElement(expandBrandsButton).click();
        WaitUtil.setPresenceWait(brandFilterSearchTextBox);
    }

    public void checkBrandCheckBox(String brandName) {
//        DriverFactory.getInstance().findElement(By.xpath(String.format(brandButton, brandName))).click();
        WaitUtil.setPresenceWait(By.xpath(String.format(brandButton, brandName))).click();
    }

    public void enterBrandNameInFilter(String brandName) {
        DriverFactory.getInstance().findElement(brandFilterSearchTextBox).sendKeys(brandName);
    }

    public void clearBrandSearchFilterTextBox() {
        DriverFactory.getInstance().findElement(brandFilterSearchTextBox).clear();
    }
}
