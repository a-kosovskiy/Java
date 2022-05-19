package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.OzonCartPage;
import pages.OzonCatalogPage;
import pages.OzonItemPage;
import pages.OzonMainPage;

public class OzonStepDefs {

    @Когда("пользователь выбирает категорию товара {string}")
    public void openCatalogCategory(String name) {
        OzonMainPage page = new OzonMainPage();
        page.openCategory(name);
    }

    @И("выбирает бренд {string}")
    public void selectBrand(String name) {
        OzonCatalogPage page = new OzonCatalogPage();
        page.selectBrand(name);
    }

    @Тогда("отображаются товары выбранного бренда {string}")
    public void checkActiveFilterByBrand(String name) {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkActiveFilterByBrand(name);
    }

    @Тогда("отображается сообщение о том, что бренд не найден")
    public void checkBrandIsNotFound() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkBrandIsNotFound();
    }

    @И("выбирает сортировку по цене по возрастанию")
    public void sortByPriceAsc() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.sortByPriceAsc();
    }

    @И("выбирает сортировку по размеру скидки")
    public void sortByDiscount() {
        new OzonCatalogPage().sortByDiscount();
    }

    @Тогда("товары отображаются по возрастанию цены")
    public void checkProductsSortingByPriceAsc() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkProductsSortingByPriceAsc();
    }

    @И("переходит на страницу первого товара")
    public void goToItemPage() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.goToFirstItemPage();
    }

    @И("добавляет товар в корзину")
    public void addToCart() {
        new OzonItemPage().addToCart();
    }

    @И("переходит в корзину")
    public void goToCart() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.goToCart();
    }

    @Тогда("число товаров в корзине равно {int}")
    public void checkCartItemsCount(int count) {
        new OzonCartPage().checkCartItemCount(count);
    }

    @И("название товара корректно отображается в корзине")
    public void checkCartItemTitle() {
        new OzonItemPage().checkCartItemTitle();
    }

    @И("удаляет товар из корзины")
    public void deleteItemFromCart() {
        new OzonCartPage().deleteFirstItemInCart();
    }

    @Тогда("отображается пустая корзина")
    public void checkCartIsEmpty() {
        new OzonCartPage().checkCartIsEmpty();
    }

    @И("указывает максимальную цену {string}")
    public void setMaxPriceValue(String price) {
        new OzonCatalogPage().setMaxPrice(price);
    }

    @Тогда("максимальная цена равна минимальной")
    public void checkMaxPriceEqualsMinPrice() {
        new OzonCatalogPage().checkMaxPriceEqualsMinPrice();
    }

    @Когда("пользователь вводит в поиске {string}")
    public void search(String value) {
        new OzonMainPage().search(value);
    }

    @Тогда("товар с названием {string} отображается в результах поиска")
    public void checkItemInSearchResults(String itemTitle) {
        new OzonMainPage().checkItemInSearchResults(itemTitle);
    }

    @Тогда("ничего не найдено")
    public void checkNoSearchResults() {
        new OzonMainPage().checkNoSearchResults();
    }

    @Тогда("товары отображаются по убыванию размера скидки")
    public void checkProductsSortingByDiscountDesc() {
        new OzonCatalogPage().checkProductsSortingByDiscountDesc();
    }

    @И("пользователь возвращается на главную страницу")
    public void goToMainPage() {
        new OzonCatalogPage().goToMainPage();
    }

    @Тогда("у товара указан бренд {string}")
    public void checkItemBrand(String name) {
        new OzonItemPage().checkBrandName(name);
    }
}
