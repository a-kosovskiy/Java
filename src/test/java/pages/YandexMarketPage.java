package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexMarketPage extends BasePage {
    private static final String CATALOG_BUTTON_ID = "catalogPopupButton";
    private static final String ZOO_GOODS_LINK = "//span[text()='Зоотовары']/parent::a";
    private static final String CATS_TREATS_LINK = "//a[text()='Для кошек']/../..//a[text()='Лакомства']";
    private static final String PRICE_FROM_ID = "glpricefrom";
    private static final String PRICE_TO_ID = "glpriceto";
    private static final String COURIER_DELIVERY = "//span[text()='Доставка курьером']//ancestor::label";
    private static final String SHOW_ALL_BRANDS = "//legend[text()='Производитель']/..//button[text()='Показать всё']";
    private static final String SEARCH_FIELD = "//input[@name='Поле поиска']";
    private static final String FIRST_PRODUCT_LINK = "(//article)[1]//a[@data-node-name='title']";

    public YandexMarketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void viewCatalog() {
        webDriver.findElement(By.id(CATALOG_BUTTON_ID)).click();
    }

    public void viewCatsTreats() {
        Actions actionProvider = new Actions(webDriver);
        WebElement zooGoods = new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ZOO_GOODS_LINK)));
        actionProvider.moveToElement(zooGoods).build().perform();

        webDriver.findElement(By.xpath(CATS_TREATS_LINK)).click();
    }

    public void filterByPrice(String priceFrom, String priceTo) {
        webDriver.findElement(By.id(PRICE_FROM_ID)).sendKeys(priceFrom);
        webDriver.findElement(By.id(PRICE_TO_ID)).sendKeys(priceTo);
    }

    public void selectCourierDelivery() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(By.xpath(COURIER_DELIVERY)));
        WebElement courierDelivery = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(COURIER_DELIVERY)));
        courierDelivery.click();
    }

    public void filterByBrand(String brandName) {
        webDriver.findElement(By.xpath(SHOW_ALL_BRANDS)).click();
        WebElement searchField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_FIELD)));
        searchField.sendKeys(brandName);
        WebElement brandInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']/ancestor::label[@role='button']", brandName))));
        brandInput.click();
    }

    public void goToFirstProductPageInResults() {
        webDriver.findElement(By.xpath(FIRST_PRODUCT_LINK)).click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
    }
}
