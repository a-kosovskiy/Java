package pages;

import framework.Browser;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        this.webDriver = Browser.getInstance().getWebDriver();
    }
}
