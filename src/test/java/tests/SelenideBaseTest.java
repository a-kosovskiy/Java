package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SelenideBaseTest {
    private static final String baseUrl = "https://habr.com/ru/all";

    @BeforeEach
    public void setUp() {
        Selenide.open(baseUrl);
    }

    @AfterEach
    public void tearDown() {

    }
}
