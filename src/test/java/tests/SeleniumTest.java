package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.YandexMainPage;
import pages.YandexMarketPage;

public class SeleniumTest extends BaseTest{
    @Test
    @DisplayName("Заказ лакомства для кошек")
    public void orderCatTreatsTest() {
        new YandexMainPage(webDriver).goToMarketPage();
        YandexMarketPage yandexMarketPage = new YandexMarketPage(webDriver);
        yandexMarketPage.viewCatalog();
        yandexMarketPage.viewCatsTreats();
        yandexMarketPage.filterByPrice("50","150");
        yandexMarketPage.selectCourierDelivery();
        yandexMarketPage.filterByBrand("Whiskas");
        yandexMarketPage.goToFirstProductPageInResults();
        new ProductPage(webDriver).compare();
    }
}
