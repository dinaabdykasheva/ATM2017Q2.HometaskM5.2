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
        return instance = init(GlobalProperties.CHROME_DRIVER_TYPE);
    }

    private static WebDriver init(String driverType) {
        if (driverType.equals(GlobalProperties.CHROME_DRIVER_TYPE)) {
            WebDriverCreator creator = new ChromeDriverCreator();
        } else if (driverType.equals(GlobalProperties.FIREFOX_DRIVER_TYPE)) {
            WebDriverCreator creator = new FirefoxDriverCreator();
        }
        WebDriverCreator creator = new ChromeDriverCreator();
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
