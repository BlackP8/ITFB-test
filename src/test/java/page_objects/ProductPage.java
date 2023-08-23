package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import utils.WaitUtil;

public class ProductPage extends BasePage {
    private final By compareButton = By.cssSelector("*[data-auto='compare-button']");
    private final By productName = By.cssSelector("*[data-additional-zone='title']");
    private final By compareListButton = By.cssSelector("*[href='/my/compare-lists']");

    public ProductPage() {
        super(By.cssSelector("div[data-apiary-widget-name='@MarketNode/ProductSummary']"));
    }

    public String getProductName() {
        return WaitUtil.setPresenceWait(productName).getText();
    }

    public void clickCompareButton() {
        WaitUtil.setPresenceWait(compareButton).click();
    }

    public void clickShowCompareListButton() {
        WaitUtil.setPresenceWait(compareListButton).click();
    }
}
