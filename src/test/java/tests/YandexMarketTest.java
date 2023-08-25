package tests;

import library.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.Steps;
import library.utils.DataProviderUtil;
import library.utils.TabUtil;

/**
 * @author - Pavel Romanov
 */

public class YandexMarketTest extends BaseTest {
    private static final boolean EXPECTED_POSITIVE_RESULT = true;
    private static final boolean EXPECTED_NEGATIVE_RESULT = false;

    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "testData")
    @Description(value = "Тест поиска и сравнения товаров в Яндекс Маркете.")
    public void testCatalogue(String secondProductNumber, String secondBrandName, String minPrice, String expectedPriceSumLimit,
                              String maxPrice, String firstProductNumber, String firstBrandName) {
        Steps.checkMainPage();
        Steps.openProductCategories();
        Steps.сhooseProductsForAnimals();
        Steps.selectGoodiesForCats();
        Steps.checkCatGoodiesPage();
        Steps.checkFilterAppeared();
        Steps.setFilterMinPrice(minPrice);
        Steps.setFilterMaxPrice(maxPrice);
        Steps.selectCourierDeliveryMethod();
        Steps.showAllBrands();
        Steps.enterBrandName(firstBrandName);
        Steps.chooseBrand(firstBrandName);
        Steps.useToolTip();
        Steps.chooseProductOnPageByIndex(firstProductNumber);
        TabUtil.changeTab();
        Steps.addProductToComparisonList();
        TabUtil.closeTab();
        TabUtil.switchToPreviousTab();
        Steps.chooseBrand(firstBrandName);
        Steps.clearFindBrandTextBox();
        Steps.enterBrandName(secondBrandName);
        Steps.chooseBrand(secondBrandName);
        Steps.useToolTip();
        Steps.chooseProductOnPageByIndex(secondProductNumber);
        TabUtil.changeTab();
        Steps.addProductToComparisonList();
        Steps.openComparisonList();
        Steps.checkCompareListPage();
        Steps.checkProductNameExistInComparisonList(EXPECTED_NEGATIVE_RESULT, firstBrandName);
        Steps.checkProductNameExistInComparisonList(EXPECTED_NEGATIVE_RESULT, secondBrandName);
        int priceSum = Steps.getPriceSumFromComparisonList();
        Steps.checkPriceSumLimit(priceSum, Integer.parseInt(expectedPriceSumLimit));
        Steps.deleteProductFromComparisonList(firstBrandName);
        Steps.checkProductNameExistInComparisonList(EXPECTED_POSITIVE_RESULT, firstBrandName);
        Steps.eraseComparisonList();
        Steps.checkComparisonListEmpty();
    }
}
