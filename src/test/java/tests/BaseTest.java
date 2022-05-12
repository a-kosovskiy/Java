package tests;

import framework.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static final String baseURL = "https://yandex.ru/";

    protected WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        Browser browser = Browser.getInstance();
        browser.open(baseURL);
        browser.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        Browser.quit();
    }
}
