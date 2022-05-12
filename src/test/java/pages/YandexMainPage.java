package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMainPage extends BasePage {

    private static final String YANDEX_MARKET_LINK = "//ul[@class='services-new__list']//a[@data-id='market']";

    public void goToMarketPage() {
        webDriver.findElement(By.xpath(YANDEX_MARKET_LINK)).click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }
}
