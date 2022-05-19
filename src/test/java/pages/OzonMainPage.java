package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class OzonMainPage {
    private static final SelenideElement catalogButton = $x("//span[text()='Каталог']/ancestor::button");
    private static final SelenideElement searchInput = $x("//input[@placeholder='Искать на Ozon']");
    private static final SelenideElement searchButton = $x("//form[@action='/search']//ancestor::button");
    private static final SelenideElement nothingFoundDiv = $x("//div[contains(text(),'Простите, по вашему запросу товаров сейчас нет')]");
    private static final SelenideElement mainLogoLink = $x("//img[@alt='Ozon']/ancestor::a");

    public void openCategory(String name) {
        catalogButton.click();
        $x("//span[text()='"+name+"']/ancestor::a").click();
    }

    public void search(String value) {
        searchInput.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        searchInput.setValue(value);
        searchButton.click();
    }

    public void checkItemInSearchResults(String itemTitle) {
        $x("//div[@data-widget='megaPaginator']//span[text()='"+itemTitle+"']").shouldBe(Condition.visible);
    }

    public void checkNoSearchResults() {
        nothingFoundDiv.shouldBe(Condition.visible);
    }

    public void goToMainPage() {
        mainLogoLink.click();
    }
}
