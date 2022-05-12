package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelenideTest extends SelenideBaseTest{

    @Test
    @DisplayName("Поиск лучшей за месяц статьи")
    public void findBestArticleTest() {
        System.out.println("успешный вызов");
    }

}
