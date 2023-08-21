package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import page_objects.MainPage;

public class YandexMarketTest extends BaseTest {
    @Test
    public void testCatalogue() {
        MainPage mainPage = new MainPage();
        mainPage.isPageAppeared();
        mainPage.openCatalogue();
        mainPage.chooseGoodies();
    }
}
