package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import utils.WaitUtil;

public class ProductPage extends BasePage {
    private final By compareButton = By.cssSelector("div[data-auto='compare-button']");
    private final By productDescription = By.cssSelector("h1[data-additional-zone='title']");

    public ProductPage() {
        super(By.cssSelector("div[data-apiary-widget-name='@MarketNode/ProductSummary']"), "productPageIdentifier");
    }

    public String getProductDescription() {
        return WaitUtil.setPresenceWait(productDescription).getText();
    }

    public void clickCompareButton() {
        WaitUtil.setPresenceWait(compareButton).click();
    }
}
