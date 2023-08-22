package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.CatGoodiesPage;
import page_objects.MainPage;
import page_objects.ProductPage;
import utils.DataProviderUtil;
import utils.TabUtil;

public class YandexMarketTest extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "testData")
    public void testCatalogue(String secondProductNumber, String secondBrandName, String minPrice, String maxPrice,
                              String firstProductNumber, String firstBrandName) {
       MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageAppeared(), "Главная страница не открылась.");
        mainPage.openCatalogue();
        mainPage.chooseAnimalGoods();
        mainPage.chooseCatGoodies();

        CatGoodiesPage catGoodiesPage = new CatGoodiesPage();
        Assert.assertTrue(catGoodiesPage.isPageAppeared(), "Страница с лакомствами для кошек не открылась.");
//        FilterForm filter = new FilterForm();
//        Assert.assertTrue(filter.isPageAppeared(), "Фильтра нет");
//        filter.setMinPrice(minPrice);
//        filter.setMaxPrice(maxPrice);
//        filter.setCourierDeliveryOption();
//        filter.expandBrands();
//        filter.chooseBrand(firstBrandName);
//        catGoodiesPage.setMinPrice(minPrice);
//        catGoodiesPage.setMaxPrice(maxPrice);
//        catGoodiesPage.setDeliveryOption();
//        catGoodiesPage.expandBrands();
//        catGoodiesPage.chooseWhiskas();
        catGoodiesPage.chooseProduct(firstProductNumber);
        TabUtil.changeTab();
//        ProductPage productPage = new ProductPage();
//        String firstProductDescription = productPage.getProductDescription();
//        productPage.clickCompareButton();
        TabUtil.closeTab();
        TabUtil.switchToPreviousTab();
        catGoodiesPage.chooseProduct(secondProductNumber);
    }
}
