package core.utils;

import core.driver.singleton.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dina_Abdykasheva on 8/15/2017.
 */
public class Waiter {
    public static void waitForElementPresent(ExpectedCondition<WebElement> expectedConditions) {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 10);
        wait.until(expectedConditions);
    }
}
