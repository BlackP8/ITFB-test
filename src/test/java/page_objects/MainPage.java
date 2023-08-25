package page_objects;

import library.base.BasePage;
import library.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import library.utils.ScrollUtil;
import library.utils.WaitUtil;

import java.time.Duration;

/**
 * @author - Pavel Romanov
 */

public class MainPage extends BasePage {
    private static final int PAUSE_BEFORE_ACTION = 3;
    private static final int OFFSET_X_RANGE = 300;
    private static final int OFFSET_Y_RANGE = 0;
    private final By catalogueButton = By.xpath("//*[@id='hamburger']//parent::button");
    private final By petSuppliesCategory = By.xpath("//li//following::span[contains(text(), 'Зоотовары')]");
    private final By catGoodiesButton = By.xpath("//*[contains(@href, 'lakomstva-dlia-koshek')]");
    private static final Actions actions = new Actions(DriverFactory.getInstance());

    public MainPage() {
        super(By.xpath("//*[@data-zone-name='index-page']"));
    }

    public void openCatalogue() {
        WaitUtil.setPresenceWait(catalogueButton).click();
    }

    public void chooseAnimalGoods() {
        WaitUtil.setPresenceWait(petSuppliesCategory);
        ScrollUtil.scrollToElement(DriverFactory.getInstance().findElement(petSuppliesCategory));
        actions.pause(Duration.ofSeconds(PAUSE_BEFORE_ACTION))
                .moveToElement(WaitUtil.setPresenceWait(petSuppliesCategory))
                .moveByOffset(OFFSET_X_RANGE, OFFSET_Y_RANGE).perform();
    }

    public void chooseCatGoodies() {
        ScrollUtil.scrollToElement(WaitUtil.setPresenceWait(catGoodiesButton));
        WaitUtil.setClickableWait(catGoodiesButton).click();
    }
}
