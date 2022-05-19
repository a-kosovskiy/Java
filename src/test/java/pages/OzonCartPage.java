package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OzonCartPage {
    private static final SelenideElement emptyCartHeader = $x("//h1[text()='Корзина пуста']");
    private static final SelenideElement deleteFromCartButton = $x("(//span[text()='Удалить']/ancestor::button)[1]");
    private static final SelenideElement confirmDeleteButton = $x("//div[contains(text(),'Удаление товаров')]/..//span[text()='Удалить']/ancestor::button");
    private static final SelenideElement closePopupButton = $x("//div[@data-widget='alertPopup']//*[name()='svg']/ancestor::button");

    private void closePopup() {
        if (closePopupButton.exists() & closePopupButton.is(Condition.enabled)) {
            closePopupButton.click();
        }
    }

    public void deleteFirstItemInCart() {
        Selenide.refresh();
        closePopup();
        deleteFromCartButton.click();
        confirmDeleteButton.click();
    }

    public void checkCartIsEmpty() {
        emptyCartHeader.shouldBe(Condition.visible);
    }

    public void checkCartItemCount(int count) {
        closePopup();
        $x("//span[text()='Товары ("+count+")']").shouldBe(Condition.visible);
    }
}
