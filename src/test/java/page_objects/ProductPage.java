package page_objects;

import library.base.BasePage;
import org.openqa.selenium.By;
import library.utils.WaitUtil;

/**
 * @author - Pavel Romanov
 */

public class ProductPage extends BasePage {
    private final By compareButton = By.cssSelector("*[data-auto='compare-button']");
    private final By productName = By.cssSelector("h1[data-baobab-name='title']");
    private final By compareListButton = By.cssSelector("*[href='/my/compare-lists']");

    public ProductPage() {
        super(By.cssSelector("div[data-apiary-widget-name='@MarketNode/ProductSummary']"));
    }

    public String getProductName() {
        return WaitUtil.setPresenceWait(productName).getText();
    }

    public void clickCompareButton() {
        WaitUtil.setClickableWait(compareButton).click();
        WaitUtil.setPresenceWait(compareListButton);
    }

    public void clickShowCompareListButton() {
        WaitUtil.setClickableWait(compareListButton).click();
    }
}
