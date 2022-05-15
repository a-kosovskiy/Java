package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.OzonCatalogPage;
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

    @Тогда("товары отображаются по возрастанию цены")
    public void checkProductsSortingByPriceAsc() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkProductsSortingByPriceAsc();
    }

    @И("переходит на страницу товара")
    public void goToItemPage() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.goToFirstItemPage();
    }

    @И("добавляет товар в корзину")
    public void addToCart() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.addToCart();
    }

    @И("переходит в корзину")
    public void goToCart() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.goToCart();
    }

    @Тогда("число товаров в корзине равно {int}")
    public void checkCartItemsCount(int count) {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkCartItemCount(count);
    }

    @И("название товара корректно отображается в корзине")
    public void checkCartItemTitle() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkCartItemTitle();
    }
}
