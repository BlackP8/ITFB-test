package page_objects;

import library.base.BasePage;
import library.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import library.utils.WaitUtil;

import java.time.Duration;
import java.util.ArrayList;

/**
 * @author - Pavel Romanov
 */

public class CatGoodiesPage extends BasePage {
    private static final Actions actions = new Actions(DriverFactory.getInstance());
    private final By productPath = By.cssSelector("*[data-autotest-id='product-snippet']");

    public CatGoodiesPage() {
        super(By.xpath("//h1[contains(text(),'Лакомства для кошек')]"));
    }

    public void chooseProduct(String productNumber) {
        WaitUtil.setVisibilityWait(productPath);
        ArrayList<WebElement> products = (ArrayList<WebElement>) DriverFactory.getInstance().findElements(productPath);
        actions.pause(Duration.ofSeconds(3)).click(products.get(Integer.parseInt(productNumber))).perform();
    }
}
