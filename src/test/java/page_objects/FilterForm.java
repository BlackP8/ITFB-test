package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import utils.ScrollUtil;
import utils.WaitUtil;

public class FilterForm extends BasePage {
    private final By minPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'min')]");
    private final By maxPriceField = By.xpath("//*[contains(@id, 'price') and contains(@id, 'max')]");
//    private final By courierRadioButton = By.xpath("//*[contains(@data-filter-value-id, 'shipping_delivery')]");
    private final By courierRadioButton = By.cssSelector("input[value='offer-shipping_delivery']");
    private final By expandBrandsButton = By.xpath("//*[contains(text(), 'Показать всё')]");
    private final String brandButton = "//*[text()='%s']";

    public FilterForm() {
        super(By.cssSelector("#searchFilters"), "filterFormIdentifier");
    }

    public void setMinPrice(String minPrice) {
        WaitUtil.setPresenceWait(minPriceField).sendKeys(minPrice);
    }

    public void setMaxPrice(String maxPrice) {
        WaitUtil.setPresenceWait(maxPriceField).sendKeys(maxPrice);
    }

    public void setCourierDeliveryOption() {
        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(courierRadioButton));
        WaitUtil.setPresenceWait(courierRadioButton).click();
    }

    public void expandBrands() {
        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(expandBrandsButton));
        WaitUtil.setPresenceWait(expandBrandsButton).click();
    }

    public void chooseBrand(String brandName) {
        WaitUtil.setPresenceWait(By.xpath(String.format(brandButton, brandName))).click();
    }
}
