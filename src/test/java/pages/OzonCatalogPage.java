package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OzonCatalogPage {
    private static final SelenideElement showAllBrandsButton = $x("//div[contains(text(), 'Бренды')]/..//span[contains(text(), 'Посмотреть все')]");
    private static final SelenideElement brandSearchInput = $x("//div[contains(text(), 'Бренды')]/..//input[@type='text']");
    private static final SelenideElement nothingFoundSpan = $x("//div[contains(text(), 'Бренды')]/..//span[text()='Ничего не нашлось']");

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
}
