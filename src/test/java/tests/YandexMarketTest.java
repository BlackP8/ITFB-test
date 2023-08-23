package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import steps.Steps;
import utils.DataProviderUtil;
import utils.TabUtil;

public class YandexMarketTest extends BaseTest {
    @Test(dataProviderClass = DataProviderUtil.class, dataProvider = "testData")
    public void testCatalogue(String secondProductNumber, String secondBrandName, String minPrice, String maxPrice,
                              String expectedPriceSumLimit, String firstProductNumber, String firstBrandName) {
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
        Steps.chooseProductOnPageByIndex(firstProductNumber);
//        MainPage mainPage = new MainPage();
//        Assert.assertTrue(mainPage.isPageAppeared(), "Главная страница не открылась.");
//        mainPage.openCatalogue();
//        mainPage.chooseAnimalGoods();
//        mainPage.chooseCatGoodies();
//
//        CatGoodiesPage catGoodiesPage = new CatGoodiesPage();
//        Assert.assertTrue(catGoodiesPage.isPageAppeared(), "Страница с лакомствами для кошек не открылась.");
//        FilterForm filter = new FilterForm();
//        Assert.assertTrue(filter.isPageAppeared(), "Фильтра нет");
//        filter.setMinPrice(minPrice);
//        filter.setMaxPrice(maxPrice);
//        filter.setCourierDeliveryOption();
//        filter.expandBrands();
//        filter.enterBrandNameInFilter(firstBrandName);
//        filter.checkBrandCheckBox(firstBrandName);
//        catGoodiesPage.chooseProduct(firstProductNumber);

        TabUtil.changeTab();
        String firstProductName = Steps.getNameOfProduct();
        Steps.addProductToComparisonList();
//        ProductPage productPage = new ProductPage();
//        String firstProductName = productPage.getProductName();
//        productPage.clickCompareButton();
        TabUtil.closeTab();
        TabUtil.switchToPreviousTab();
        Steps.chooseBrand(firstBrandName);
        Steps.clearFindBrandTextBox();
        Steps.enterBrandName(secondBrandName);
        Steps.chooseBrand(secondBrandName);
        Steps.chooseProductOnPageByIndex(secondProductNumber);
//
//        filter.checkBrandCheckBox(firstBrandName);
//        filter.clearBrandSearchFilterTextBox();
//        filter.enterBrandNameInFilter(secondBrandName);
//        filter.checkBrandCheckBox(secondBrandName);
//        catGoodiesPage.chooseProduct(secondProductNumber);
        TabUtil.changeTab();
        String secondProductName = Steps.getNameOfProduct();
        Steps.addProductToComparisonList();
        Steps.openComparisonList();
//        String secondProductName = productPage.getProductName();
//        productPage.clickCompareButton();
//        productPage.clickShowCompareListButton();
        Steps.checkCompareListPage();
        Steps.checkProductNameExistInComparisonList(firstProductName);
        Steps.checkProductNameExistInComparisonList(secondProductName);
        Steps.checkPriceSumLimit(expectedPriceSumLimit);
        Steps.deleteProductFromComparisonList(firstProductName);
        Steps.checkProductNameExistInComparisonList(firstProductName);
        Steps.eraseComparisonList();
        Steps.checkComparisonListEmpty();
//        CompareListPage compareListPage = new CompareListPage();
//        Assert.assertTrue(compareListPage.isPageAppeared(), "Страница сравнения не открылась.");
//        Assert.assertTrue(compareListPage.doesProductNameExist(firstProductName), "Имя товара соотвутствует первому товару.");
//        Assert.assertTrue(compareListPage.doesProductNameExist(secondProductName), "Имя товара соотвутствует второму товару.");
//        Assert.assertTrue(compareListPage.getPriceSum() < Integer.parseInt(expectedPriceSumLimit),
//                "Сумма стоимостей товаров превышает ожидаемую.");
//        compareListPage.deleteProduct(firstProductName);
//        Assert.assertFalse(compareListPage.doesProductNameExist(firstProductName), "Товар производителя Whiskas не удален.");
//        compareListPage.clearComparisonList();
//        Assert.assertTrue(compareListPage.isComparisonListEmpty(), "Товары не удалены.");
    }
}
