package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OzonCatalogPage {
    private static final SelenideElement showAllBrandsButton = $x("//div[contains(text(), 'Бренды')]/..//span[contains(text(), 'Посмотреть все')]");
    private static final SelenideElement brandSearchInput = $x("//div[contains(text(), 'Бренды')]/..//input[@type='text']");
    private static final SelenideElement nothingFoundSpan = $x("//div[contains(text(), 'Бренды')]/..//span[text()='Ничего не нашлось']");
    private static final SelenideElement sortingInput = $x("//input[@name='filter' and @role = 'combobox']");
    private static final SelenideElement sortByPriceAsc = $x("//*[contains(text(),'Сначала дешёвые')]");
    private static final SelenideElement sortByDiscountDesc = $x("//*[contains(text(),'По размеру скидки')]");
    private static final SelenideElement firstProductPrice = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'₽') and contains(@style,'ozAccentAlert')])[1]");
    private static final SelenideElement secondProductPrice = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'₽') and contains(@style,'ozAccentAlert')])[2]");
    private static final SelenideElement firstProductDiscount = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'%')])[1]");
    private static final SelenideElement secondProductDiscount = $x("(//div[@data-widget='megaPaginator']//span[contains(text(),'%')])[2]");
    private static final SelenideElement firstItemLink = $x("(//div[@data-widget='megaPaginator']//a)[1]");
    private static final SelenideElement cartLink = $x("//span[text()='Корзина']/ancestor::a");
    private static final SelenideElement mainLogoLink = $x("//img[@alt='Ozon']/ancestor::a");
    private static final SelenideElement minPrice = $x("//p[contains(text(),'от')]/preceding-sibling::input");
    private static final SelenideElement maxPrice = $x("//p[contains(text(),'до')]/preceding-sibling::input");
    private static final SelenideElement megaPaginatorDiv = $x("//div[@data-widget='megaPaginator']");

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
        sortByPriceAsc.click();
    }

    public void sortByDiscount() {
        sortingInput.click();
        sortByDiscountDesc.shouldBe(Condition.enabled).click();
    }

    public void checkProductsSortingByPriceAsc() {
        megaPaginatorDiv.scrollTo();
        $x("//div[contains(text(),'Сначала дешёвые')]").shouldBe(Condition.visible);
        int firstPrice = Integer.parseInt(firstProductPrice.getText().substring(0, firstProductPrice.getText().indexOf("₽")-1));
        int secondPrice = Integer.parseInt(secondProductPrice.getText().substring(0, secondProductPrice.getText().indexOf("₽")-1));
        assertTrue(firstPrice <= secondPrice);
    }

    public void checkProductsSortingByDiscountDesc() {
        megaPaginatorDiv.scrollTo();
        $x("//div[contains(text(),'По размеру скидки')]").shouldBe(Condition.visible);
        int firstDiscount = Integer.parseInt(firstProductDiscount.getText().substring(1, firstProductDiscount.getText().indexOf("%")));
        int secondDiscount = Integer.parseInt(secondProductDiscount.getText().substring(1, secondProductDiscount.getText().indexOf("%")));
        assertTrue(firstDiscount >= secondDiscount);
    }

    public void goToFirstItemPage() {
        firstItemLink.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public void goToMainPage() {
        mainLogoLink.click();
    }

    public void setMaxPrice(String price) {
        maxPrice.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        maxPrice.setValue(price).sendKeys(Keys.RETURN);
    }

    public void checkMaxPriceEqualsMinPrice() {
        maxPrice.shouldHave(Condition.exactValue(minPrice.getValue()));
    }
}
