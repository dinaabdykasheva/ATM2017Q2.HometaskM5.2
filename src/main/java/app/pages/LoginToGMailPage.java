package app.pages;

import app.business_objects.User;
import core.driver.singleton.WebDriverSingleton;
import core.service.GlobalProperties;
import core.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class LoginToGMailPage extends AbstractPage {
    private static final By USERNAME_INPUT_LOCATOR = By.name("identifier");
    private static final By NEXT_BUTTON_LOCATOR = By.id("identifierNext");
    private static final By PASSWORD_INPUT_LOCATOR = By.name("password");
    private static final By NEXT_BUTTON_LOCATOR1 = By.id("passwordNext");
    private static final By LOGIN_PAGE_LOCATOR = By.xpath(".//*[@class= 'sfYUmb']");
    private static final By PROFILE_IDENTIFIER_LOCATOR = By.id("profileIdentifier");

    public AccountPage loginToGMail(User user) {
        WebDriverSingleton.getWebDriverInstance().get(GlobalProperties.URL);
        WebDriverSingleton.getWebDriverInstance().findElement(USERNAME_INPUT_LOCATOR).sendKeys(user.getUsername());
        WebDriverSingleton.getWebDriverInstance().findElement(NEXT_BUTTON_LOCATOR).click();
        Waiter.waitForElementPresent(ExpectedConditions.visibilityOfElementLocated(PROFILE_IDENTIFIER_LOCATOR));
        WebDriverSingleton.getWebDriverInstance().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(user.getPassword());
        WebDriverSingleton.getWebDriverInstance().findElement(NEXT_BUTTON_LOCATOR1).click();
        return new AccountPage();
    }

    public boolean isUserLoggedOff() {
        return isElementPresent(LOGIN_PAGE_LOCATOR);
    }
}
