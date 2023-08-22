package page_objects;

import base.BasePage;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import utils.ScrollUtil;
import utils.WaitUtil;


public class MainPage extends BasePage {
    private final By catalogueButton = By.xpath("//*[@id='hamburger']//parent::button");
    private final By petSuppliesCategory = By.xpath("//li//following::span[contains(text(), 'Зоотовары')]");
    private final By catGoodiesButton = By.xpath("//*[contains(@href, 'lakomstva-dlia-koshek')]");
    private static final Actions actions = new Actions(DriverFactory.getInstance());

    public MainPage() {
        super(By.xpath("//*[@data-zone-name='index-page']"), "mainPageIdentifier");
    }

    public void openCatalogue() {
//        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance();
//        executor.executeScript("arguments[0].click();", WaitUtil.setPresenceWait(catalogueButton));
        WaitUtil.setPresenceWait(catalogueButton).click();
    }

    public void chooseAnimalGoods() {
//        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(petSuppliesCategory));
        actions.moveToElement(WaitUtil.setPresenceWait(petSuppliesCategory)).build().perform();
    }

    public void chooseCatGoodies() {
//        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(catGoodiesButton));
//        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance();
//        executor.executeScript("arguments[0].click();", WaitUtil.setPresenceWait(catGoodiesButton));
        actions.moveToElement(WaitUtil.setPresenceWait(catGoodiesButton)).build().perform();
        WaitUtil.setPresenceWait(catGoodiesButton).click();
    }
}
