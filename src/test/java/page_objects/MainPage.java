package page_objects;

import base.BasePage;
import driver.DriverFactory;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {
    private final Button catalogueButton = new Button(By.cssSelector("#hamburger"));
    private final Button petSuppliesCategory = new Button(By.xpath("//span[contains(text(), 'Зоотовары')]"));
    private final Button catGoodiesButton = new Button(By.xpath("//*[contains(@href, 'lakomstva-dlia-koshek')]"));

    public MainPage() {
        super(By.xpath("//*[@data-zone-name='index-page']"), "mainPageIdentifier");
    }

    public void openCatalogue() {
        catalogueButton.doClick();
    }

    public void chooseGoodies() {
        new Actions(DriverFactory.getInstance()).moveToElement(petSuppliesCategory).perform();
        catGoodiesButton.doClick();
    }
}
