package core.driver.factory;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 19.08.2017.
 */
public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver createWebDriver();
}
