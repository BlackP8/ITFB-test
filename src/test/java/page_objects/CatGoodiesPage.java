package page_objects;

import base.BasePage;
import org.openqa.selenium.By;
import utils.WaitUtil;

public class CatGoodiesPage extends BasePage {
    private final String productPath = "//*[@data-apiary-widget-id='/content/page/cms/4/SearchSerp-SearchSerp/snippet_%s']";

    public CatGoodiesPage() {
        super(By.xpath("//h1[contains(text(),'Лакомства для кошек')]"), "catGoodiesPageIdentifier");
    }

    public void chooseProduct(String productNumber) {
        WaitUtil.setPresenceWait(By.xpath(String.format(productPath, productNumber))).click();
    }

//    public void chooseSecondProduct() {
//        WaitUtil.setPresenceWait(secondProduct).click();
//    }
}
