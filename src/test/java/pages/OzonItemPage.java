package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OzonItemPage {

    private static final SelenideElement brandLink = $x("//span[text()='Бренд в одежде и обуви']//ancestor::dl//a");
    private static final SelenideElement addToCartButton = $x("//span[text()='Добавить в корзину']/ancestor::button");
    private static final SelenideElement itemHeader = $x("//h1");

    private static String itemTitle;

    public void checkBrandName(String name) {
        brandLink.shouldHave(Condition.exactText(name));
    }

    public void addToCart() {
        addToCartButton.click();
        itemTitle = itemHeader.getText();
    }

    public void checkCartItemTitle() {
        $x("//span[contains(text(),'"+itemTitle+"')]").shouldBe(Condition.visible);
    }
}
