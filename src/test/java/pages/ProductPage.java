package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private static final String COMPARE = "//div[@data-node-name='comparison']/parent::div[@role='button']";

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void compare() {
        webDriver.findElement(By.xpath(COMPARE)).click();
    }
}
