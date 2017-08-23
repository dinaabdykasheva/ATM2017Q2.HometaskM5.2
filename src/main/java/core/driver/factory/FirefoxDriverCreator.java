package core.driver.factory;

import core.driver.decorator.WebDriverDecorator;
import core.service.GlobalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by User on 19.08.2017.
 */
public class FirefoxDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        System.setProperty(GlobalProperties.FIREFOX_DRIVER, GlobalProperties.PATH_TO_FIREFOX_DRIVER);
        WebDriver driver = new FirefoxDriverCreator().createWebDriver();
        return new WebDriverDecorator(driver);
    }
}
