package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private static final String COMPARE = "//div[@data-node-name='comparison']/parent::div[@role='button']";

    public void compare() {
        webDriver.findElement(By.xpath(COMPARE)).click();
    }
}
