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
    private static final SelenideElement firstProductPrice = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'₽') and contains(@style,'ozAccentAlert')])[1]");
    private static final SelenideElement secondProductPrice = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'₽') and contains(@style,'ozAccentAlert')])[2]");
    private static final SelenideElement firstItemLink = $x("(//div[@data-widget='megaPaginator']//a)[1]");
    private static final SelenideElement addToCartButton = $x("//span[text()='Добавить в корзину']/ancestor::button");
    private static final SelenideElement cartLink = $x("//span[text()='Корзина']/ancestor::a");
    private static final SelenideElement itemHeader = $x("//h1");
    private static final SelenideElement mainLogoLink = $x("//img[@alt='Ozon']/ancestor::a");

    private static String itemTitle;

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
        goToMainPage();
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

    public void goToFirstItemPage() {
        firstItemLink.click();
    }

    public void addToCart() {
        addToCartButton.click();
        itemTitle = itemHeader.getText();
    }

    public void goToCart() {
        cartLink.click();
    }

    public void checkCartItemCount(int count) {
        $x("//span[text()='Товары ("+count+")']").shouldBe(Condition.visible);
    }

    public void checkCartItemTitle() {
        $x("//span[text()='"+itemTitle+"']").shouldBe(Condition.visible);
    }

    public void goToMainPage() {
        mainLogoLink.click();
    }
}
