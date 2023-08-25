package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import page_objects.*;

import java.util.concurrent.TimeoutException;

/**
 * @author - Pavel Romanov
 */

public class Steps {
    private static MainPage mainPage = new MainPage();
    private static CatGoodiesPage catGoodiesPage = new CatGoodiesPage();
    private static FilterForm filter = new FilterForm();
    private static ProductPage productPage = new ProductPage();
    private static CompareListPage compareListPage = new CompareListPage();

    @Step("Проверка открытия главной страницы.")
    public static void checkMainPage() {
        Assert.assertTrue(mainPage.isPageAppeared(), "Главная страница не открылась.");
    }

    @Step("Открытие каталога с видами товаров.")
    public static void openProductCategories() {
        mainPage.openCatalogue();
    }

    @Step("Открытие меню товаров для животных.")
    public static void сhooseProductsForAnimals() {
        mainPage.chooseAnimalGoods();
    }

    @Step("Открытие категории товаров лакомства для кошек.")
    public static void selectGoodiesForCats() {
        mainPage.chooseCatGoodies();
    }

    @Step("Проверка открытия страницы с лакомствами для кошек.")
    public static void checkCatGoodiesPage() {
        Assert.assertTrue(catGoodiesPage.isPageAppeared(), "Страница с лакомствами для кошек не открылась.");
    }

    @Step("Проверка наличия фильтра на странице товаров.")
    public static void checkFilterAppeared() {
        Assert.assertTrue(filter.isPageAppeared(), "Фильтра нет");
    }

    @Step("Установка минимального значения цены {minPrice} в фильтре.")
    public static void setFilterMinPrice(String minPrice) {
        filter.setMinPrice(minPrice);
    }

    @Step("Установка максимального значения цены {maxPrice} в фильтре.")
    public static void setFilterMaxPrice(String maxPrice) {
        filter.setMaxPrice(maxPrice);
    }
    @Step("Выбор курьерской доставки в фильтре.")
    public static void selectCourierDeliveryMethod() {
        filter.setCourierDeliveryOption();
    }

    @Step("Нажатие кнопки показать всех производителей.")
    public static void showAllBrands() {
        filter.expandBrands();
    }

    @Step("Ввод имени производителя {brandName} в поисковом поле фильтра.")
    public static void enterBrandName(String brandName) {
        filter.enterBrandNameInFilter(brandName);
    }

    @Step("Выбор производителя в фильтре.")
    public static void chooseBrand(String brandName) {
        filter.checkBrandCheckBox(brandName);
    }

    @Step("Выбор товара на странице по индексу {productIndex}.")
    public static void chooseProductOnPageByIndex(String productIndex) {
        catGoodiesPage.chooseProduct(productIndex);
    }

    @Step("Получение имени товара со страницы товара.")
    public static String getNameOfProduct() {
        return productPage.getProductName();
    }

    @Step("Добавление товара в список сравнения.")
    public static void addProductToComparisonList() {
        productPage.clickCompareButton();
    }

    @Step("Очистка поискового меню производителей товаров в фильтре.")
    public static void clearFindBrandTextBox() {
        filter.clearBrandSearchFilterTextBox();
    }

    @Step("Открытие списка сравнения товаров.")
    public static void openComparisonList() {
        productPage.clickShowCompareListButton();
    }

    @Step("Проверка открытия страницы со списком сравнения.")
    public static void checkCompareListPage() {
        Assert.assertTrue(compareListPage.isPageAppeared(), "Страница сравнения не открылась.");
    }

    @Step("Проверка наличия имени товара {productName} в списке сравнения.")
    public static void checkProductNameExistInComparisonList(boolean expectedResult, String productName) {
        Assert.assertEquals(compareListPage.doesProductNameExist(productName), expectedResult,
                "Имя товара не соотвутствует добавленному в список сравнения.");
    }

    @Step("Получение суммы стоимостей товаров из списка сравнения.")
    public static int getPriceSumFromComparisonList() {
        return compareListPage.getPriceSum();
    }

    @Step("Проверка соответствия суммы стоимости товаров ожидаемому лимиту {expectedPriceSumLimit}.")
    public static void checkPriceSumLimit(int actualPriceSum, int expectedPriceSumLimit) {
        Assert.assertTrue(actualPriceSum < expectedPriceSumLimit,
                "Сумма стоимостей товаров превышает ожидаемую.");
    }

    @Step("Удаление товара с именем {productName} из списка сравнения.")
    public static void deleteProductFromComparisonList(String productName) {
        compareListPage.deleteProduct(productName);
    }

    @Step("Очистка списка сравнения товаров.")
    public static void eraseComparisonList() {
        compareListPage.clearComparisonList();
    }

    @Step("Проверка, что список сравнения пуст.")
    public static void checkComparisonListEmpty() {
        Assert.assertTrue(compareListPage.isComparisonListEmpty(), "Товары не удалены.");
    }

    @Step("Нажатие на выпадающее меню количества результатов поиска.")
    public static void useToolTip() {
        filter.clickToolTip();
    }
}
