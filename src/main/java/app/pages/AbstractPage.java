package app.pages;

import org.openqa.selenium.By;
import core.driver.singleton.WebDriverSingleton;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class AbstractPage {

    public boolean isElementPresent(By locator) {
        return !WebDriverSingleton.getWebDriverInstance().findElements(locator).isEmpty();
    }

}
