package page_objects;

import library.base.BasePage;
import library.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import library.utils.ScrollUtil;
import library.utils.WaitUtil;

import java.time.Duration;

/**
 * @author - Pavel Romanov
 */

public class FilterForm extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
    private static final int PAUSE_BEFORE_ACTION = 3;
    private final By minPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'min')]");
    private final By maxPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'max')]");
    private final By courierRadioButton = By.cssSelector("*[data-filter-value-id='offer-shipping_delivery']>label");
    private final By expandBrandsButton = By.xpath("//*[contains(text(), 'Показать всё')]//ancestor::button");
    private final By brandFilterSearchTextBox = By.cssSelector("*[data-zone-name='filterSearchValueField'] input");
    private final By toolTip = By.cssSelector("*[data-auto='filter-found-visible-tooltip']");
    private final String brandButton = "//span[text()='%s']";

    public FilterForm() {
        super(By.cssSelector("#searchFilters"));
    }

    public void setMinPrice(String minPrice) {
        WaitUtil.setClickableWait(minPriceField);
        actions.sendKeys(DriverFactory.getInstance().findElement(minPriceField), minPrice)
                .pause(Duration.ofSeconds(PAUSE_BEFORE_ACTION)).perform();
    }

    public void setMaxPrice(String maxPrice) {
        WaitUtil.setClickableWait(maxPriceField);
        actions.sendKeys(DriverFactory.getInstance().findElement(maxPriceField), maxPrice)
                .pause(Duration.ofSeconds(PAUSE_BEFORE_ACTION)).perform();
    }

    public void setCourierDeliveryOption() {
        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(courierRadioButton));
        actions.pause(Duration.ofSeconds(PAUSE_BEFORE_ACTION)).click(WaitUtil.setClickableWait(courierRadioButton)).perform();
    }

    public void expandBrands() {
        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(expandBrandsButton));
        actions.pause(Duration.ofSeconds(PAUSE_BEFORE_ACTION)).click(WaitUtil.setClickableWait(expandBrandsButton)).perform();
        WaitUtil.setPresenceWait(brandFilterSearchTextBox);
    }

    public void checkBrandCheckBox(String brandName) {
        WaitUtil.setPresenceWait(brandFilterSearchTextBox);
        WaitUtil.setClickableWait(By.xpath(String.format(brandButton, brandName))).click();
    }

    public void clickToolTip() {
        WaitUtil.setVisibilityWait(toolTip).click();
    }

    public void enterBrandNameInFilter(String brandName) {
        WaitUtil.setPresenceWait(brandFilterSearchTextBox).sendKeys(brandName);
    }

    public void clearBrandSearchFilterTextBox() {
        WaitUtil.setPresenceWait(brandFilterSearchTextBox).clear();
    }
}
