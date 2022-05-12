package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome" : return getChromeDriver();
            default : return getChromeDriver();
        }
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:/Users/alkos/AppData/Local/Google/Chrome/User Data");
        return chromeDriver;
    }
}
