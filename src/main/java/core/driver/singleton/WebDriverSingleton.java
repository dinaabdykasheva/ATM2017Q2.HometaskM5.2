package core.driver.singleton;

import core.driver.decorator.WebDriverDecorator;
import core.driver.factory.ChromeDriverCreator;
import core.driver.factory.WebDriverCreator;
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
        WebDriverCreator creator = new ChromeDriverCreator();
        WebDriver driver = creator.FactoryMethod();
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
