package test;

import core.driver.singleton.WebDriverSingleton;
import org.testng.annotations.AfterClass;

/**
 * Created by Dina_Abdykasheva on 8/10/2017.
 */
public class BaseTest {

    @AfterClass(description = "closeDriver")
    public void closeDriver() {
        WebDriverSingleton.kill();
    }
}
