package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class BaseSteps {
    private static final String baseUrl = "https://www.ozon.ru/";

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 5000;
        Selenide.open(baseUrl);
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
