package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OzonMainPage {
    private static final SelenideElement catalogButton = $x("//span[text()='Каталог']/ancestor::button");

    public void openCategory(String name) {
        catalogButton.click();
        $x("//span[text()='"+name+"']/ancestor::a").click();
    }
}
