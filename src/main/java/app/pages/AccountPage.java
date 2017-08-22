package app.pages;

import core.driver.singleton.WebDriverSingleton;
import org.openqa.selenium.By;
import core.utils.Logger;

/**
 * Created by Dina_Abdykasheva on 6/15/2017.
 */
public class AccountPage extends AbstractPage {
    private static final By ACCOUNT_ICON_LOCATOR = By.xpath(".//span [@class='gb_7a gbii']");
    private static final By WRITE_MAIL_BUTTON_LOCATOR = By.xpath(".//div[@class='T-I J-J5-Ji T-I-KE L3']");
    private static final By DRAFTS_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Черновики')]");
    private static final By SENT_MAIL_FOLDER_LOCATOR = By.xpath(".//a[contains(text(), 'Отправленные')]");
    private static final By EXIT_BUTTON_LOCATOR = By.xpath(".//a[contains(text(), 'Выйти')]");

    public WriteMailPage clickWriteMailButton() {
        WebDriverSingleton.getWebDriverInstance().findElement(WRITE_MAIL_BUTTON_LOCATOR).click();
        WebDriverSingleton.getWebDriverInstance().switchTo().activeElement();
        return new WriteMailPage();
    }

    public boolean isAccountIconPresent() {
        Logger.info("User successfully logged in");
        return isElementPresent(ACCOUNT_ICON_LOCATOR);
    }

    public DraftsFolderPage openDrafts() {
        WebDriverSingleton.getWebDriverInstance().findElement(DRAFTS_FOLDER_LOCATOR).click();
        return new DraftsFolderPage();
    }

    public SentFolderPage openSentMail() {
        WebDriverSingleton.getWebDriverInstance().findElement(SENT_MAIL_FOLDER_LOCATOR).click();
        return new SentFolderPage();
    }

    public LoginToGMailPage exitGMail() {
        WebDriverSingleton.getWebDriverInstance().findElement(ACCOUNT_ICON_LOCATOR).click();
        WebDriverSingleton.getWebDriverInstance().findElement(EXIT_BUTTON_LOCATOR).click();
        return new LoginToGMailPage();
    }
}
