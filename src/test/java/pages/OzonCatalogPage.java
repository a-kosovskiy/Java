package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OzonCatalogPage {
    private static final SelenideElement showAllBrandsButton = $x("//div[contains(text(), 'Бренды')]/..//span[contains(text(), 'Посмотреть все')]");
    private static final SelenideElement brandSearchInput = $x("//div[contains(text(), 'Бренды')]/..//input[@type='text']");
    private static final SelenideElement nothingFoundSpan = $x("//div[contains(text(), 'Бренды')]/..//span[text()='Ничего не нашлось']");
    private static final SelenideElement sortingInput = $x("//input[@name='filter' and @role = 'combobox']");
    private static final SelenideElement sortByPriceAsc = $x("//*[contains(text(),'Сначала дешёвые')]");
    private static final SelenideElement firstProductPrice = $x("(//div[@data-widget = 'megaPaginator']//span[contains(text(), '₽') and contains(@style, 'ozAccentAlert')])[1]");
    private static final SelenideElement secondProductPrice = $x("(//div[@data-widget = 'megaPaginator']//span[contains(text(), '₽') and contains(@style, 'ozAccentAlert')])[2]");

    public void selectBrand(String name) {
        showAllBrandsButton.click();
        brandSearchInput.setValue(name);
        if (!nothingFoundSpan.isDisplayed()) {
            $x("//span[text()='"+name+"']/ancestor::a").shouldBe(Condition.enabled).click();
            $x("//button//span[text()='Бренды: "+name+"']").shouldBe(Condition.visible);
        }
    }

    public void checkActiveFilterByBrand(String brandName) {
        $x("//button//span[text()='Бренды: "+brandName+"']").shouldBe(Condition.visible);
    }

    public void checkBrandIsNotFound() {
        nothingFoundSpan.shouldBe(Condition.visible);
    }

    public void sortByPriceAsc() {
        sortingInput.click();
        sortByPriceAsc.shouldBe(Condition.enabled).click();
    }

    public void checkProductsSortingByPriceAsc() {
        $x("//div[contains(text(),'Сначала дешёвые')]").shouldBe(Condition.visible);
        int firstPrice = Integer.parseInt(firstProductPrice.getText().substring(0, firstProductPrice.getText().indexOf("₽")-1));
        int secondPrice = Integer.parseInt(secondProductPrice.getText().substring(0, secondProductPrice.getText().indexOf("₽")-1));
        assertTrue(firstPrice <= secondPrice);
    }
}
