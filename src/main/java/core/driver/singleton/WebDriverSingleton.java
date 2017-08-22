package core.driver.singleton;

import core.driver.decorator.WebDriverDecorator;
import core.driver.factory.ChromeDriverCreator;
import core.driver.factory.FirefoxDriverCreator;
import core.driver.factory.WebDriverCreator;
import core.service.GlobalProperties;
import core.utils.Logger;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static WebDriver init() {
        WebDriverCreator creator;
        if (GlobalProperties.BROWSER.equals("chrome")) {
            creator = new ChromeDriverCreator();
        } else if (GlobalProperties.BROWSER.equals("firefox")) {
            creator = new FirefoxDriverCreator();
        } else {
            creator = new ChromeDriverCreator();
        }
        WebDriver driver = creator.createWebDriver();
        driver = new WebDriverDecorator(driver);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void kill() {
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
                Logger.error("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }
}
