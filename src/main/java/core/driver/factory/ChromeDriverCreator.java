package core.driver.factory;

import core.service.GlobalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by User on 19.08.2017.
 */
public class ChromeDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        System.setProperty(GlobalProperties.CHROME_DRIVER, GlobalProperties.PATH_TO_CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
