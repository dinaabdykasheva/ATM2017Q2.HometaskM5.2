package core.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by User on 06.08.2017.
 */
public class WebElementsUtils {

    public static void executeJavaScript(WebDriver driver, By locator, String script) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(script, element);
    }

    public static void moveToField(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator));
    }

    public static void fillInField(WebDriver driver, By locator, String keys) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).click().sendKeys(keys).build().perform();
    }
}