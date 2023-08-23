package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import utils.WaitUtil;

public class CatGoodiesPage extends BasePage {
    private final String productPath = "(//*[@data-autotest-id='product-snippet'])[%s]";

    public CatGoodiesPage() {
        super(By.xpath("//h1[contains(text(),'Лакомства для кошек')]"));
    }

    public void chooseProduct(String productNumber) {
        WaitUtil.setPresenceWait(By.xpath(String.format(productPath, productNumber))).click();
    }
}
