package page_objects;

import library.base.BasePage;
import library.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import library.utils.WaitUtil;
import java.time.Duration;

/**
 * @author - Pavel Romanov
 */

public class ProductPage extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
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
        actions.click(WaitUtil.setClickableWait(compareButton)).pause(Duration.ofSeconds(3)).perform();
    }

    public void clickShowCompareListButton() {
        WaitUtil.setClickableWait(compareListButton).click();
    }
}
