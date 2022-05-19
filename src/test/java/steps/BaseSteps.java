package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import pages.OzonMainPage;

public class BaseSteps {
    private static final String baseUrl = "https://www.ozon.ru/";

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 5000;
        Configuration.browserSize = "1366x968";
        Selenide.open(baseUrl);
    }

    @Before
    public static void goToMainPage() {
        new OzonMainPage().goToMainPage();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
