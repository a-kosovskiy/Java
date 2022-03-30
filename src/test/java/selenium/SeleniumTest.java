package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {

    private WebDriver webDriver;
    public static final String baseURL = "https://yandex.ru/";

    //Локаторы
    private static final String YANDEX_MARKET_REF = "//ul[@class='services-new__list']//a[@data-id='market']";
    private static final String CATALOG_BUTTON_ID = "catalogPopupButton";
    private static final String ZOO_GOODS_REF = "//span[text()='Зоотовары']/parent::a";
    private static final String CATS_TREATS_REF = "//a[text()='Для кошек']/../..//a[text()='Лакомства']";
    private static final String PRICE_FROM_ID = "glpricefrom";
    private static final String PRICE_TO_ID = "glpriceto";
    private static final String COURIER_DELIVERY = "//span[text()='Доставка курьером']//ancestor::label";
    private static final String SHOW_ALL_BRANDS = "//legend[text()='Производитель']/..//button[text()='Показать всё']";
    private static final String SEARCH_FIELD = "//input[@name='Поле поиска']";
    private static final String BRAND_INPUT = "//span[text()='Whiskas']/../../input";
    private static final String FIRST_TREAT = "(//article)[1]";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(baseURL);
        webDriver.manage().window().maximize();
    }

    @Test
    @DisplayName("Заказ лакомства для кошек")
    public void orderCatTreatsTest() {
        webDriver.findElement(By.xpath(YANDEX_MARKET_REF)).click();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }

        webDriver.findElement(By.id(CATALOG_BUTTON_ID)).click();

        Actions actionProvider = new Actions(webDriver);
        WebElement zooGoods = new WebDriverWait(webDriver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(ZOO_GOODS_REF)));
        actionProvider.moveToElement(zooGoods).build().perform();

        webDriver.findElement(By.xpath(CATS_TREATS_REF)).click();
        webDriver.findElement(By.id(PRICE_FROM_ID)).sendKeys("50");
        webDriver.findElement(By.id(PRICE_TO_ID)).sendKeys("150");

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({block:\"center\"});", webDriver.findElement(By.xpath(COURIER_DELIVERY)));
        WebElement courierDelivery = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(COURIER_DELIVERY)));
        courierDelivery.click();

        webDriver.findElement(By.xpath(SHOW_ALL_BRANDS)).click();
        WebElement searchField = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_FIELD)));
        searchField.sendKeys("Whiskas");
        WebElement brand = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(BRAND_INPUT)));
        brand.click();

        webDriver.findElement(By.xpath(FIRST_TREAT)).click();
    }

    @AfterEach
    public void tearDown() {
        webDriver.close();
    }
}
